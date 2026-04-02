package LanguageModel;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SystemState {

    private Map<Item, Integer> inventory;
    private Node startNode;

    private ArrayList<Node> nodes;


    private static SystemState instance;


    public void addNode(Node node) {
        nodes.add(node);
    }

    public Node getNodeByName(String name) {
        for (Node node : nodes) {
            if (node.name.equals(name)) {
                return node;
            }
        }
        return null; // or throw an exception if you prefer
    }
    

    private SystemState(String startNode) {
        this.inventory = new HashMap<>();
        this.startNode = getNodeByName(startNode);
    }


    // Keep singleton system state
    public static void initialize(String startNode) {
        if (instance != null) {
            throw new IllegalStateException("SystemState has already been initialized.");
        }
        instance = new SystemState(startNode);
    }

    public static SystemState getSystemState() {
        if (instance == null) {
            throw new IllegalStateException("SystemState has not been initialized yet.");
        }
        return instance;
    }


    public boolean hasItem(Item item, int quantity) {
        return (inventory.getOrDefault(item, 0) >= quantity);
    }

    public boolean hasItem(Item item) {
        return inventory.containsKey(item);
    }

}
=======
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

    public void setTransition(String targetName, Priority priority, String condition) {
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
>>>>>>> 23e094c0adf1119a9e45c094b4eb4075f9253dcf
