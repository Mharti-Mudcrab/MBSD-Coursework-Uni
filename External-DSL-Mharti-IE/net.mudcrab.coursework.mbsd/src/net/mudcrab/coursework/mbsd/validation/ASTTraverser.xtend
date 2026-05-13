package net.mudcrab.coursework.mbsd.validation

import java.util.ArrayList
import java.util.HashMap
import java.util.HashSet
import net.mudcrab.coursework.mbsd.ifictiondsl.And
import net.mudcrab.coursework.mbsd.ifictiondsl.ChoiceNode
import net.mudcrab.coursework.mbsd.ifictiondsl.Comparison
import net.mudcrab.coursework.mbsd.ifictiondsl.Condition
import net.mudcrab.coursework.mbsd.ifictiondsl.DialogueNode
import net.mudcrab.coursework.mbsd.ifictiondsl.EndNode
import net.mudcrab.coursework.mbsd.ifictiondsl.Node
import net.mudcrab.coursework.mbsd.ifictiondsl.Or
import net.mudcrab.coursework.mbsd.ifictiondsl.Parentheses
import net.mudcrab.coursework.mbsd.ifictiondsl.StartNode
import net.mudcrab.coursework.mbsd.ifictiondsl.Story
import net.mudcrab.coursework.mbsd.ifictiondsl.SystemStateChangeNode
import net.mudcrab.coursework.mbsd.ifictiondsl.Transition
import java.util.concurrent.ConcurrentHashMap

class ASTTraverser {

	private HashMap<String, Integer> state
	private ArrayList<TraversalNode> nodeVisitPath
	private ConcurrentHashMap<Node, TraversalNode> visitedNodes
	private HashSet<Node> highlyConnectedToNodes
	private HashSet<Transition> visitedTransitions
	private HashSet<SystemStateChangeNode> visitedStateChangeNodes
	private Story story

	new() {
		this.state = new HashMap<String, Integer>()
		this.nodeVisitPath = new ArrayList<TraversalNode>()
		this.visitedNodes = new ConcurrentHashMap<Node, TraversalNode>()
		this.highlyConnectedToNodes = new HashSet<Node>()
		this.visitedTransitions = new HashSet<Transition>()
		this.visitedStateChangeNodes = new HashSet<SystemStateChangeNode>()
	}
	
	public def ArrayList<TraversalNode> 		getNodeVisitPath() { nodeVisitPath }
	public def ConcurrentHashMap<Node, TraversalNode> 	getVisitedNodes() { visitedNodes }
	public def HashSet<Node> 					getHighlyConnectedToNodes() { highlyConnectedToNodes }
	public def HashSet<Transition> 				getVisitedTransitions() { visitedTransitions }
	public def HashSet<SystemStateChangeNode> 	getVisitedStateChangeNodes() { visitedStateChangeNodes }

	public def void traverseStory(Story story) {
		state.clear
		visitedNodes.clear
		nodeVisitPath.clear
		highlyConnectedToNodes.clear
		visitedTransitions.clear
		visitedStateChangeNodes.clear
		this.story = story
		
		traverseStoryHelper(story.nodes.findFirst[it instanceof StartNode], null)
	}

	public def boolean findNodeFrom(Node fromNode, Node toNode) {
		findNodeFrom(fromNode, toNode, false)
	}
	
	public def boolean findNodeFrom(Node fromNode, Node toNode, boolean strictMatch) {
		if (!visitedNodes.containsKey(fromNode)) {
			return false
		}

		state = new HashMap<String, Integer>(visitedNodes.get(fromNode).stateSnapshot)
		nodeVisitPath.clear
		
		if ((visitedNodes.containsKey(toNode) || fromNode === toNode) && !strictMatch) {
			//System.out.println("WARNING: visitedNodes contains key or fromNode(" + fromNode.name + ") === toNode(" + toNode.name + ") in findNodeFrom()")
			return false
		}
		
		nodeVisitPath.add(new TraversalNode(fromNode, new HashMap<String, Integer>(state), visitedNodes.get(fromNode).prevNode))
		return findNodeFromHelper(fromNode, toNode, strictMatch)
	}
	
	private def boolean findNodeFromHelper(Node currentNode, Node toNode, boolean strictMatch) {
		// return false if we hit a loop i.e. visit before seen node in path // without having changed state since last time
		if (nodeVisitPath.length !== 1 && currentNode !== toNode) {			
			val nodePossiblySeenBeforInPath = nodeVisitPath.findFirst[
				it.node === currentNode 
				//&& it.stateSnapshot.equals(this.state)
			]
			if(nodePossiblySeenBeforInPath !== null) {
				return false
			}
		}
		
		
		// If it is not the first time this function is called. Nodes should not be able to refference themselves
		if (!nodeVisitPath.last.node.equals(currentNode)) {
			if (currentNode instanceof SystemStateChangeNode) {
				updateState(currentNode)
				if (!visitedStateChangeNodes.contains(currentNode)) {
					visitedStateChangeNodes.add(currentNode)
				}
			}

			// If state of current traversal is not the same as state when last seeing this node -> update the state of that node
			if (visitedNodes.containsKey(currentNode) && !visitedNodes.get(currentNode).stateSnapshot.equals(state)) {
				//System.out.println("Updating state of already seen node: \"" + currentNode.name + "\", with state: " + state)
				visitedNodes.get(currentNode).stateSnapshot = new HashMap<String, Integer>(this.state)
			}

			val traversalNode = new TraversalNode(currentNode, new HashMap<String, Integer>(this.state), nodeVisitPath.lastOrNull)
			nodeVisitPath.add(traversalNode)
			
			if (currentNode === toNode) {
				//System.out.println("Found the right node: \"" + currentNode.name + "\" state: " + state)
				if (!visitedNodes.containsKey(currentNode)) {
					// System.out.println('''«'\t'»Found a new node: «currentNode.name»: " «state»''')
					visitedNodes.put(currentNode, traversalNode)	
				}
				return true
			}
			
			if (!visitedNodes.containsKey(currentNode)) {
				// We found one new node. Not necessarily the one we were looking for, but that is good enough
				visitedNodes.put(currentNode, traversalNode)
				// System.out.println('''«'\t'»Found a new node: «currentNode.name». Was looking for "toNode.name": " «state»''')			
				if (!strictMatch) {
					return false // we will return false because we did not find it, but can still use it
				}
			}
		}
		
		switch (currentNode) {
			ChoiceNode: {
				for (option : currentNode.options) {
					val t = getBestTransition(option.transitions)
					if (t !== null && checkCondition(t.condition)) {
						if (!visitedTransitions.contains(t)) {
							visitedTransitions.add(t)
						}
						if(findNodeFromHelper(t.destination, toNode, strictMatch)) { // If not the first one finds it, maybe the second one will
							return true
						}
					}
				}
			}
			EndNode: {
				return false				
			}
			default: {
				val structuralFeature = currentNode.eClass.getEStructuralFeature("transition")
				if (structuralFeature !== null) {
					val t = currentNode.eGet(structuralFeature) as Transition
					if (t !== null && checkCondition(t.condition)) {
						if (!visitedTransitions.contains(t)) {
							visitedTransitions.add(t)
						}
						return findNodeFromHelper(t.destination, toNode, strictMatch)
					}					
				}
			}
		}
		return false
	}

	private def void traverseStoryHelper(Node node, TraversalNode prevNode) {
		if (node === null) {
			return
		}

		switch (node) {
			StartNode: {
				visitedNodes.put(node, new TraversalNode(node, new HashMap<String, Integer>(state), null))
				addIfHighlyConnectedToNode(node)
				if (checkCondition(node.transition.condition)) {
					visitedTransitions.add(node.transition)
					if (!visitedNodes.containsKey(node.transition.destination)) {
						traverseStoryHelper(node.transition.destination, visitedNodes.get(node))						
					}
				}
			}
			DialogueNode: {
				visitedNodes.put(node, new TraversalNode(node, new HashMap<String, Integer>(state), prevNode))
				addIfHighlyConnectedToNode(node)
				if (checkCondition(node.transition.condition)) {
					visitedTransitions.add(node.transition)
					if (!visitedNodes.containsKey(node.transition.destination)) {
						traverseStoryHelper(node.transition.destination, visitedNodes.get(node))					
					}
				}
			}
			SystemStateChangeNode: {
				updateState(node)
				visitedStateChangeNodes.add(node)
				visitedNodes.put(node, new TraversalNode(node, new HashMap<String, Integer>(state), prevNode))
				addIfHighlyConnectedToNode(node)
				if (checkCondition(node.transition.condition)) {
					visitedTransitions.add(node.transition)
					if (!visitedNodes.containsKey(node.transition.destination)) {
						traverseStoryHelper(node.transition.destination, visitedNodes.get(node))					
					}
				}
			}
			ChoiceNode: {
				visitedNodes.put(node, new TraversalNode(node, new HashMap<String, Integer>(state), prevNode))
				addIfHighlyConnectedToNode(node)
				for (choiceOption : node.options) {
					val Transition bestTransition = getBestTransition(choiceOption.transitions)
					
					if (bestTransition !== null) {
						visitedTransitions.add(bestTransition)
						if (!visitedNodes.containsKey(bestTransition.destination)) {
							traverseStoryHelper(bestTransition.destination, visitedNodes.get(node))						
						}
					}
				}
			}
			EndNode: {
				addIfHighlyConnectedToNode(node)
				visitedNodes.put(node, new TraversalNode(node, new HashMap<String, Integer>(state), prevNode))
			}
		}
	}
	
	private def updateState(SystemStateChangeNode node) {
		for (stateUpdate : node.stateUpdates) {
			switch (stateUpdate.operator) {
				case "=": { state.put(stateUpdate.variable, stateUpdate.value) }
				case "-=": { state.put(stateUpdate.variable, state.getOrDefault(stateUpdate.variable, 0) - stateUpdate.value) }
				case "+=": { state.put(stateUpdate.variable, state.getOrDefault(stateUpdate.variable, 0) + stateUpdate.value) }
			}
		}
	}
	
	private def void addIfHighlyConnectedToNode(Node node) {
		var int connectCount = 0
		for (no : story.nodes) {
			switch(no) {
				ChoiceNode: {
					for (option : no.options) {
						for (transition : option.transitions) {
							if (transition.destination.name.equals(node.name)) {
								connectCount++
							}
						}
					}
				}
				default: {
					val structuralFeature = no.eClass.getEStructuralFeature("transition")
					if (structuralFeature !== null) {				 		
						val transition = no.eGet(structuralFeature) as Transition
						if (transition !== null && transition.destination.name.equals(node.name)) {
							connectCount++
						}
					}
				}
			}
		}
		if (connectCount > 1) {
			highlyConnectedToNodes.add(node)
		}
	}
	
	private def Transition getBestTransition(Transition[] transitions) {
		 transitions.filter[checkCondition(it.condition)]
					.sortBy[priority]
					.lastOrNull
	}

	private def boolean checkCondition(Condition cond) {
		return checkCondition(cond, this.state)
	}

	public static def boolean checkCondition(Condition cond, HashMap<String, Integer> state) {
		if (cond === null) {
			return true
		}
		
		switch (cond) {
			And: {
				return checkCondition(cond.left, state) && checkCondition(cond.right, state)
			}
			Or: {
				return checkCondition(cond.left, state) || checkCondition(cond.right, state)
			}
			Parentheses: {
				return checkCondition(cond.inner, state)
			}
			Comparison: {
				switch (cond.operator) {
				case "==": { return state.getOrDefault(cond.variable, 0) == cond.value }
				case "!=": { return state.getOrDefault(cond.variable, 0) != cond.value }
				case ">": { return state.getOrDefault(cond.variable, 0) > cond.value }
				case "<": { return state.getOrDefault(cond.variable, 0) < cond.value }
				case ">=": { return state.getOrDefault(cond.variable, 0) >= cond.value }
				case "<=": { return state.getOrDefault(cond.variable, 0) <= cond.value }
				}
			}
		}
	}
}
