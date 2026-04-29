package net.mudcrab.coursework.mbsd.validation

import java.util.HashMap
import net.mudcrab.coursework.mbsd.ifictiondsl.Node

class TraversalNode {
	
	private Node node;
	private TraversalNode prevNode;
	private TraversalNode nextNode;
	private HashMap<String, Integer> stateSnapshot;
	
	new (Node node, HashMap<String, Integer> stateSnapshot, TraversalNode prevNode) {
		this.node = node
		this.stateSnapshot = stateSnapshot
		if (prevNode !== null) {
			prevNode.nextNode = this
			this.prevNode = prevNode
		}
	}
	
	public def setNextNode(TraversalNode nextNode) {
		this.nextNode = nextNode
	}
	
	public def setStateSnapshot(HashMap<String, Integer> stateSnapshot) {
		this.stateSnapshot = stateSnapshot
	}
	
	public def TraversalNode getNextNode() {
		this.nextNode
	}
	
	public def TraversalNode getPrevNode() {
		this.prevNode
	}
	
	public def HashMap<String, Integer> getStateSnapshot() {
		this.stateSnapshot
	}
	
	public def Node getNode() {
		this.node
	}
	
}