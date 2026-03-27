package LanguageModel;

import java.util.ArrayList;
import java.lang.Integer;
import Utils.Priority;


public class Transition {
    
    private Node nextNode;
    protected String nextNodeName;
    private Priority priority;
    private String condition;
    private ArrayList<Requirement> requirements; 

    public Transition(String nextNodeName, Priority priority, String condition) {
        this.nextNodeName = nextNodeName;
        this.priority = priority;
        this.condition = condition;
        this.requirements = new ArrayList<>();
        generateRequirements(condition);
    }

    private void generateRequirements(String condition) {
        if (condition == null || condition.isEmpty()) {
            throw new IllegalStateException("Tansition condition null of transition: " + nextNodeName + ", " + priority);
        }
    }

    public boolean satisfiesAllRequirements(SystemState systemState) {
        for (Requirement requirement : requirements) {
            if (!requirement.isSatisfied(systemState)) {
                return false;
            }
        }
        return true;
    }

    public String getNextNodeName()
    {
        return nextNodeName;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public Priority getPriority() {
        return priority;
    }

    public void performTransition(SystemState systemState) {
        for (Requirement requirement : requirements) {
            if (!requirement.isSatisfied(systemState)) {
                systemState.setCurrentNode(null);
                return;
            }
        }
        systemState.setCurrentNode(nextNode);  
    }

}