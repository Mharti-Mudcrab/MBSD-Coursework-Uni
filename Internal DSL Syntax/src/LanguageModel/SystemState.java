package LanguageModel;

import java.util.HashMap;
import java.lang.IllegalStateException;
import Utils.Priority;


public class SystemState {

    protected HashMap<String, Integer> items;
    protected HashMap<String, Node> nodes;
    protected String name;
    protected Node startNode;
    protected Node currentNode;
    protected ChoiceOption currentOption;

    public SystemState() {
        this.items = new HashMap<>();
        this.nodes = new HashMap<>();
    }

    public boolean isRunning() {
        return currentNode != null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addNode(String name, Node node) {
        nodes.put(name, node);
        currentNode = node;
    }

    public Node getNode(String name) {
        return nodes.get(name);
    }

    public Node getCurrentNode() {
        return currentNode;
    }

    public void setStartNode(Node node) {
        startNode = node;
    }

    public void setCurrentNode(Node node) {
        currentNode = node;
    }

    public void addChoiceOption(ChoiceOption option) {
        if (currentNode instanceof ChoiceNode) {
            ((ChoiceNode) currentNode).addOption(option);
            currentOption = option;
        }
        else {
            throw new IllegalStateException("Current node is not a choice node");
        }
    }
    
    public ChoiceOption getCurrentChoice() {
        return currentOption;
    }

    public void setCurrentChoice(ChoiceOption option) {
        currentOption = option;
    }

    public void setTransition(String targetName, int priority, String condition) {
        if (currentNode instanceof ChoiceNode) {
            currentOption.setTransition(new Transition(targetName, priority, condition));
        }
        else if (currentNode != null) {
            currentNode.setTransition(new Transition(targetName, priority, condition));
        }
        else {
            throw new IllegalStateException("No current node");
        }
    }

    public Integer getItemValue(String key) {
        return items.getOrDefault(key, 0);
    }

    public void setItemValue(String key, int value) {
        items.put(key, value);
    }

    public void resolveTransitionRefferences() {
        for (Node node : nodes.values()) {
            node.resolveTransitionNodeRefference(this);
        }
        currentNode = startNode;
    }
}
