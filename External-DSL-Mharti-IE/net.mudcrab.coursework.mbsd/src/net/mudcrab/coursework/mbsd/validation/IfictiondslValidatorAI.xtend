//package net.mudcrab.coursework.mbsd.validation
//
//import java.util.ArrayList
//import java.util.HashMap
//import java.util.HashSet
//import java.util.List
//import java.util.Map
//import java.util.Set
//import net.mudcrab.coursework.mbsd.ifictiondsl.And
//import net.mudcrab.coursework.mbsd.ifictiondsl.ChoiceNode
//import net.mudcrab.coursework.mbsd.ifictiondsl.Comparison
//import net.mudcrab.coursework.mbsd.ifictiondsl.Condition
//import net.mudcrab.coursework.mbsd.ifictiondsl.Or
//import net.mudcrab.coursework.mbsd.ifictiondsl.Parentheses
//import net.mudcrab.coursework.mbsd.ifictiondsl.Story
//import net.mudcrab.coursework.mbsd.ifictiondsl.SystemStateChangeNode
//import net.mudcrab.coursework.mbsd.ifictiondsl.Transition
//import net.mudcrab.coursework.mbsd.traversal.StoryTraversal
//import org.eclipse.xtext.validation.Check
//
///**
// * Validation rules for Ifictiondsl using the StoryTraversal helper.
// */
//class IfictiondslValidatorAI extends AbstractIfictiondslValidator {
//
//    /** Entry point: run story-level checks. */
//    @Check
//    def checkStory(Story story) {
//        if (story === null) return
//
//        val traverser = new StoryTraversal
//        traverser.traverse(story)
//
//        val visitedNodes = traverser.getVisitLog.map[it.node].toSet
//        val visitedTransitions = traverser.getVisitedTransitions
//
//        // collect all transitions in the story
//        val allTransitions = new ArrayList<Transition>()
//        for (n : story.nodes) {
//            if (n instanceof ChoiceNode) {
//                for (opt : (n as ChoiceNode).options) {
//                    allTransitions.addAll(opt.transitions)
//                }
//            } else {
//                try {
//                    val t = n.eGet(n.eClass.getEStructuralFeature('transition')) as Transition
//                    if (t !== null) allTransitions.add(t)
//                } catch (Throwable e) {
//                    // ignore
//                }
//            }
//        }
//
//        // Idea 1: dead/unreachable nodes
//        for (n : story.nodes) {
//            if (!visitedNodes.contains(n)) {
//                warning('Unreachable/dead node: ' + (n.name ?: n.toString), n, null, 'dead-node')
//            }
//        }
//
//        // Idea 2: dead transitions (never taken under traversal)
//        for (t : allTransitions) {
//            if (!visitedTransitions.contains(t)) {
//                warning('Dead transition (never reachable): -> ' + (t.destination?.name ?: 'unknown'), t, null, 'dead-transition')
//            }
//        }
//
//        // Idea 2b: detect transitions shadowed by higher-priority transitions
//        for (n : story.nodes) {
//            if (n instanceof ChoiceNode) {
//                for (opt : (n as ChoiceNode).options) {
//                    val trans = opt.transitions.toList.sortBy[-it.priority]
//                    checkOptionShadowing(trans)
//                }
//            }
//        }
//
//        // Idea 3: variables referenced in conditions but never assigned by any StateUpdate
//        val assignedVars = new HashSet<String>()
//        for (n : story.nodes) if (n instanceof SystemStateChangeNode) {
//            for (u : (n as SystemStateChangeNode).stateUpdates) assignedVars.add(u.variable)
//        }
//
//        val referencedVars = new HashSet<String>()
//        for (t : allTransitions) if (t.condition !== null) collectReferencedVars(t.condition, referencedVars)
//
//        for (v : referencedVars) if (!assignedVars.contains(v)) {
//            warning('Variable referenced in conditions but never assigned by any StateChangeNode: ' + v, story, null, 'uninitialized-variable')
//        }
//    }
//
//    private def void collectReferencedVars(Condition cond, Set<String> out) {
//        if (cond === null) {
//        	return
//        }
//        if (cond instanceof Parentheses) { 
//        	collectReferencedVars((cond as Parentheses).inner, out)
//        	return
//        }
//        if (cond instanceof And) { 
//        	collectReferencedVars((cond as And).left, out)
//        	collectReferencedVars((cond as And).right, out) 
//        	return
//        }
//        if (cond instanceof Or) { 
//        	collectReferencedVars((cond as Or).left, out); 
//        	collectReferencedVars((cond as Or).right, out); 
//        	return
//        }
//        if (cond instanceof Comparison) { 
//        	out.add((cond as Comparison).variable); 
//        	return
//        }
//    }
//
//    /** Check a sorted (descending priority) list of transitions for shadowing. */
//    private def void checkOptionShadowing(List<Transition> trans) {
//        for (i : 0 .. trans.size - 1) {
//            val lower = trans.get(i)
//            if (lower === null) {
//                // skip
//            } else {
//                for (j : 0 .. i - 1) {
//                    val higher = trans.get(j)
//                    if (higher === null) {
//                        // skip
//                    } else {
//                        if (higher.condition === null) {
//                            warning('Transition is shadowed by an unconditional higher-priority transition', lower, null, 'shadowed-transition')
//                            return
//                        }
//                        if (conditionImplies(lower.condition, higher.condition)) {
//                            warning('Transition is shadowed by a higher-priority transition with a weaker condition', lower, null, 'shadowed-transition')
//                            return
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    /** Simple numeric interval used for implication checks. */
//    static class Interval {
//        public int low
//        public boolean lowInc
//        public int high
//        public boolean highInc
//
//        new(int low, boolean lowInc, int high, boolean highInc) {
//            this.low = low
//            this.lowInc = lowInc
//            this.high = high
//            this.highInc = highInc
//        }
//
//        def Interval intersect(Interval other) {
//            val nl = if (other.low > this.low) other.low else this.low
//            val nli = if (other.low > this.low) other.lowInc else if (other.low < this.low) this.lowInc else (this.lowInc && other.lowInc)
//            val nh = if (other.high < this.high) other.high else this.high
//            val nhi = if (other.high < this.high) other.highInc else if (other.high > this.high) this.highInc else (this.highInc && other.highInc)
//            if (nl > nh) return null
//            if (nl == nh && !(nli && nhi)) return null
//            new Interval(nl, nli, nh, nhi)
//        }
//
//        def boolean subsetOf(Interval other) {
//            if (other === null) return false
//            if (this.low > other.low) {
//                // ok
//            } else if (this.low < other.low) return false
//            else if (this.low == other.low) {
//                if (this.lowInc && !other.lowInc) return false
//            }
//            if (this.high < other.high) {
//                // ok
//            } else if (this.high > other.high) return false
//            else if (this.high == other.high) {
//                if (this.highInc && !other.highInc) return false
//            }
//            return true
//        }
//    }
//
//    /** Build a map of variable->interval for conjunctions of simple comparisons. Returns null if unsupported (e.g. OR, !=). */
//    private def Map<String,Interval> intervalsFromCondition(Condition cond) {
//        if (cond === null) return null
//        if (cond instanceof Parentheses) return intervalsFromCondition((cond as Parentheses).inner)
//        if (cond instanceof Or) return null
//        if (cond instanceof Comparison) {
//            val c = cond as Comparison
//            val map = new HashMap<String,Interval>()
//            val op = c.operator
//            val v = c.value
//            if (op == "==") {
//                map.put(c.variable, new Interval(v, true, v, true))
//            } else if (op == "!=") {
//                return null
//            } else if (op == ">=") {
//                map.put(c.variable, new Interval(v, true, Integer.MAX_VALUE, true))
//            } else if (op == ">") {
//                map.put(c.variable, new Interval(v+1, true, Integer.MAX_VALUE, true))
//            } else if (op == "<=") {
//                map.put(c.variable, new Interval(Integer.MIN_VALUE, true, v, true))
//            } else if (op == "<") {
//                map.put(c.variable, new Interval(Integer.MIN_VALUE, true, v-1, true))
//            } else {
//                return null
//            }
//            return map
//        }
//        if (cond instanceof And) {
//            val a = cond as And
//            val left = intervalsFromCondition(a.left)
//            val right = intervalsFromCondition(a.right)
//            if (left === null || right === null) return null
//            val result = new HashMap<String,Interval>(left)
//            for (entry : right.entrySet) {
//                val key = entry.key
//                val other = entry.value as Interval
//                if (result.containsKey(key)) {
//                    val merged = result.get(key).intersect(other)
//                    if (merged === null) return null
//                    result.put(key, merged)
//                } else {
//                    result.put(key, other)
//                }
//            }
//            return result
//        }
//        return null
//    }
//
//    /** Conservative check: does condA imply condB? i.e. whenever A is true B is also true. */
//    private def boolean conditionImplies(Condition a, Condition b) {
//        val ma = intervalsFromCondition(a)
//        val mb = intervalsFromCondition(b)
//        if (ma === null || mb === null) return false
//        for (entry : ma.entrySet) {
//            val vname = entry.key
//            val ia = entry.value as Interval
//            val ib = mb.get(vname)
//            if (ib === null) return false
//            if (!ia.subsetOf(ib)) return false
//        }
//        return true
//    }
//
//}
