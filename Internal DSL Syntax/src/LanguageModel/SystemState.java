package LanguageModel;

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
