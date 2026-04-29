package net.mudcrab.coursework.mbsd.validation;

import java.util.HashMap;
import net.mudcrab.coursework.mbsd.ifictiondsl.Node;

@SuppressWarnings("all")
public class TraversalNode {
  private Node node;

  private TraversalNode prevNode;

  private TraversalNode nextNode;

  private HashMap<String, Integer> stateSnapshot;

  public TraversalNode(final Node node, final HashMap<String, Integer> stateSnapshot, final TraversalNode prevNode) {
    this.node = node;
    this.stateSnapshot = stateSnapshot;
    if ((prevNode != null)) {
      prevNode.nextNode = this;
      this.prevNode = prevNode;
    }
  }

  public TraversalNode setNextNode(final TraversalNode nextNode) {
    return this.nextNode = nextNode;
  }

  public HashMap<String, Integer> setStateSnapshot(final HashMap<String, Integer> stateSnapshot) {
    return this.stateSnapshot = stateSnapshot;
  }

  public TraversalNode getNextNode() {
    return this.nextNode;
  }

  public TraversalNode getPrevNode() {
    return this.prevNode;
  }

  public HashMap<String, Integer> getStateSnapshot() {
    return this.stateSnapshot;
  }

  public Node getNode() {
    return this.node;
  }
}
