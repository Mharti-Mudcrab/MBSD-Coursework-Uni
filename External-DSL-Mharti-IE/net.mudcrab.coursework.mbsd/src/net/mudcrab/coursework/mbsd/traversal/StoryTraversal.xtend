package net.mudcrab.coursework.mbsd.traversal

import java.util.ArrayList
import java.util.HashMap
import java.util.HashSet
import java.util.List
import java.util.Map
import java.util.Set
import net.mudcrab.coursework.mbsd.ifictiondsl.And
import net.mudcrab.coursework.mbsd.ifictiondsl.ChoiceNode
import net.mudcrab.coursework.mbsd.ifictiondsl.ChoiceOption
import net.mudcrab.coursework.mbsd.ifictiondsl.Comparison
import net.mudcrab.coursework.mbsd.ifictiondsl.Condition
import net.mudcrab.coursework.mbsd.ifictiondsl.DialogueNode
import net.mudcrab.coursework.mbsd.ifictiondsl.EndNode
import net.mudcrab.coursework.mbsd.ifictiondsl.Node
import net.mudcrab.coursework.mbsd.ifictiondsl.Or
import net.mudcrab.coursework.mbsd.ifictiondsl.Parentheses
import net.mudcrab.coursework.mbsd.ifictiondsl.StartNode
import net.mudcrab.coursework.mbsd.ifictiondsl.StateUpdate
import net.mudcrab.coursework.mbsd.ifictiondsl.Story
import net.mudcrab.coursework.mbsd.ifictiondsl.SystemStateChangeNode
import net.mudcrab.coursework.mbsd.ifictiondsl.Transition

/**
 * Traverses a Story model, records visited nodes and snapshots of system state.
 *
 * - Keeps a visit log (VisitEntry) with the node and a copy of the state at the time
 * - Applies StateUpdate entries on SystemStateChangeNode when visited
 * - Evaluates Transition conditions against the current state and only follows transitions
 *   whose condition evaluates to true (or with no condition)
 * - Avoids infinite loops by tracking visited nodes
 */
class StoryTraversal {

	static class VisitEntry {
		public final Node node
		public final Map<String, Integer> stateSnapshot

		new(Node node, Map<String,Integer> stateSnapshot) {
			this.node = node
			this.stateSnapshot = stateSnapshot
		}

		override toString() {
			val name = if (node?.name !== null) node.name else node.toString
			'VisitEntry(' + name + ', ' + stateSnapshot.toString + ')'
		}
	}

	private val ArrayList<Node> visited = new ArrayList<Node>()
	private val ArrayList<VisitEntry> visitLog = new ArrayList<VisitEntry>()
	private val HashMap<String, Integer> state = new HashMap<String, Integer>()
	private val HashSet<Transition> visitedTransitions = new HashSet<Transition>()

	def void reset() {
		visited.clear
		visitLog.clear
		state.clear
		visitedTransitions.clear
	}

	/** Traverse whole story starting from the first StartNode found. */
	def List<VisitEntry> traverse(Story story) {
		reset
		if (story === null) { return visitLog }
		val start = story.nodes.findFirst [ it instanceof StartNode ] as StartNode
		if (start === null) { return visitLog }
		traverseFrom(start)
		return visitLog
	}

	def List<VisitEntry> getVisitLog() {
		visitLog
	}

	def Set<Transition> getVisitedTransitions() {
		visitedTransitions
	}

	def Map<String,Integer> getState() {
		state
	}

	private def void traverseFrom(Node node) {
		if (node === null) { return }
		if (visited.contains(node)) { return }
		visited.add(node)

		// apply updates first if this node carries them
		applyNodeStateChanges(node)

		// record a snapshot after applying updates for this node
		visitLog.add(new VisitEntry(node, copyState()))

		// follow outgoing transitions depending on node type
		if (node instanceof StartNode) {
			val s = node as StartNode
			traverseTransition(s.transition)
		} else if (node instanceof DialogueNode) {
			val d = node as DialogueNode
			traverseTransition(d.transition)
		} else if (node instanceof SystemStateChangeNode) {
			val sc = node as SystemStateChangeNode
			traverseTransition(sc.transition)
		} else if (node instanceof ChoiceNode) {
			val c = node as ChoiceNode
			for (opt : c.options) {
				for (t : opt.transitions) {
					traverseTransition(t)
				}
			}
		} else if (node instanceof EndNode) {
			// nothing to do
		} else {
			// best-effort: try to access a 'transition' property if present using reflection
			try {
				val t = node.eGet(node.eClass.getEStructuralFeature('transition')) as Transition
				traverseTransition(t)
			} catch (Throwable e) {
				// ignore
			}
		}
	}

	private def void traverseTransition(Transition t) {
		if (t === null) { return }
		if (t.condition !== null && !evaluateCondition(t.condition)) { return }
		visitedTransitions.add(t)
		val dest = t.destination
		traverseFrom(dest)
	}

	private def void applyNodeStateChanges(Node node) {
		if (node instanceof SystemStateChangeNode) {
			val sc = node as SystemStateChangeNode
			for (upd : sc.stateUpdates) {
				applyStateUpdate(upd)
			}
		}
	}

	private def void applyStateUpdate(StateUpdate upd) {
		if (upd === null) return
		val varName = upd.variable
		val op = upd.operator
		val value = upd.value
		val cur = if (state.containsKey(varName)) state.get(varName) else 0
		if (op == '+=')
			state.put(varName, cur + value)
		else if (op == '-=')
			state.put(varName, cur - value)
		else if (op == '=')
			state.put(varName, value)
		else {
			// ignore unknown operator
		}
	}

	private def boolean evaluateCondition(Condition cond) {
		if (cond === null) return true
		if (cond instanceof Parentheses) {
			return evaluateCondition((cond as Parentheses).inner)
		}
		if (cond instanceof And) {
			val a = cond as And
			return evaluateCondition(a.left) && evaluateCondition(a.right)
		}
		if (cond instanceof Or) {
			val o = cond as Or
			return evaluateCondition(o.left) || evaluateCondition(o.right)
		}
		if (cond instanceof Comparison) {
			val c = cond as Comparison
			val varName = c.variable
			val op = c.operator
			val rhs = c.value
			val lhs = if (state.containsKey(varName)) state.get(varName) else 0
			if (op == '==') return lhs == rhs
			if (op == '!=') return lhs != rhs
			if (op == '>') return lhs > rhs
			if (op == '<') return lhs < rhs
			if (op == '>=') return lhs >= rhs
			if (op == '<=') return lhs <= rhs
			return false
		}
		return false
	}

	private def Map<String,Integer> copyState() {
		val m = new HashMap<String,Integer>()
		for (entry : state.entrySet) {
			m.put(entry.key, entry.value)
		}
		m
	}

}

