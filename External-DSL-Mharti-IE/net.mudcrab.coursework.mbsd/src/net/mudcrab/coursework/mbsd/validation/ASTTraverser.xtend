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

class ASTTraverser {

	private HashMap<String, Integer> state
	private ArrayList<TraversalNode> nodeVisitPath
	private HashMap<Node, TraversalNode> visitedNodes
	private HashSet<Node> highlyConnectedToNodes
	private HashSet<Transition> visitedTransitions
	private HashSet<SystemStateChangeNode> visitedStateChangeNodes
	private Story story

	new() {
		this.state = new HashMap<String, Integer>()
		this.nodeVisitPath = new ArrayList<TraversalNode>()
		this.visitedNodes = new HashMap<Node, TraversalNode>()
		this.highlyConnectedToNodes = new HashSet<Node>()
		this.visitedTransitions = new HashSet<Transition>()
		this.visitedStateChangeNodes = new HashSet<SystemStateChangeNode>()
	}
	
	public def ArrayList<TraversalNode> 		getNodeVisitPath() { nodeVisitPath }
	public def HashMap<Node, TraversalNode> 	getVisitedNodes() { visitedNodes }
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
		if (visitedNodes.containsKey(fromNode)) {
			state = new HashMap<String, Integer>(visitedNodes.get(fromNode).stateSnapshot)
			nodeVisitPath.clear
		} else {
			return false
		}
		if (visitedNodes.containsKey(toNode) || fromNode === toNode) {
			//System.out.println("WARNING: visitedNodes contains key or fromNode(" + fromNode.name + ") === toNode(" + toNode.name + ") in findNodeFrom()")
			return false
		}
		
		nodeVisitPath.add(new TraversalNode(fromNode, new HashMap<String, Integer>(state), visitedNodes.get(fromNode).prevNode))
		return findNodeFromHelper(fromNode, toNode)
	}
	
	private def boolean findNodeFromHelper(Node currentNode, Node toNode) {
		// return false if we hit a loop i.e. visit before seen node in path without having changed state since last time
		if (nodeVisitPath.length !== 1) {			
			val nodePossiblySeenBeforInPath = nodeVisitPath.findFirst[
				it.node === currentNode &&
				it.stateSnapshot.equals(this.state)
			]
			if(nodePossiblySeenBeforInPath !== null) {
				return false
			}
		}
		
		
		// If state of current traversal is not the same as state when last seeing this node -> update the state of that node
		if (visitedNodes.containsKey(currentNode) && !visitedNodes.get(currentNode).stateSnapshot.equals(state)) {
			System.out.println("Got in here! node: \"" + currentNode.name + "\" state: " + state)
			visitedNodes.get(currentNode).stateSnapshot = new HashMap<String, Integer>(this.state)
		}
		
		// If it is not the first time this function is called
		if (!nodeVisitPath.last.node.equals(currentNode)) {
			if (currentNode instanceof SystemStateChangeNode) {
				updateState(currentNode)
			}

			val traversalNode = new TraversalNode(currentNode, new HashMap<String, Integer>(this.state), nodeVisitPath.lastOrNull)
			nodeVisitPath.add(traversalNode)
			
			if (!visitedNodes.containsKey(currentNode)) {
				// We found one new node. Not necessarily the one we were looking for, but that is good enough
				visitedNodes.put(currentNode, traversalNode)
			
				if (currentNode === toNode) {
					System.out.println("Found the right node: \"" + currentNode.name + "\" state: " + state)
					return true
				} else {
					System.out.println("Found a node \"" + currentNode.name + "\". Was looking for \"" + toNode.name + "\": " + state)
					return false // we will return false because we did not find it, but can still use it
				}
			}
		}
		
		switch (currentNode) {
			ChoiceNode: {
				for (option : currentNode.options) {
					val t = getBestTransition(option.transitions)
					if (t !== null && checkCondition(t.condition)) {
						if(findNodeFromHelper(t.destination, toNode)) {
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
						return findNodeFromHelper(t.destination, toNode)
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
