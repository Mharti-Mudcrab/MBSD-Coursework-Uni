package LanguageModel;

import java.util.ArrayList;
import java.lang.Integer;


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

    /**
     * Takes string of eg "Talisman=1 and coin=2"
     */
    private generateRequirements(String condition) {
        String requirementStrings[] = condition.trim().split("and");
        for (String requiremen : requirementStrings) {
            
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

    public String getNextNodeName();
    {
        return nextNodeName;
    }

    public setNextNode(Node nextNode) {
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