package LanguageModel;

import java.util.ArrayList;
import java.lang.Boolean;
import Utils.Priority;


public class Transition {
    
    private Node nextNode;
    protected String nextNodeName;
    private int priority;
    private ArrayList<Requirement> requirements; 

    public Transition(String nextNodeName, int priority, String condition) {
        this.nextNodeName = nextNodeName;
        this.priority = priority;
        this.requirements = new ArrayList<>();
        if (condition != null) {
            generateRequirements(condition);
        }
    }

    private void generateRequirements(String condition) {
        if (condition == null || condition.isEmpty()) {
            throw new IllegalStateException("Tansition condition null of transition: " + nextNodeName + ", " + priority);
        }
        
        String terms[] = condition.trim().split("or "); // space afer or is important in order to not accidentally catch "door"

        for (int i = 0; i < terms.length; i++) {
            String operands[] = terms[i].trim().split("and "); // Same here. can't not have the option of an "tandembike"
            for (int j = 0; j < operands.length-1; j++) {
                requirements.add(new Requirement(operands[j].trim(), "and"));
            }
            if (i < terms.length-1) {
                // last operand of and-sequense with more lements to come has an "or"
                requirements.add(new Requirement(operands[operands.length-1].trim(), "or"));
            } else {
                // Last operand overall has no following boolean operand
                requirements.add(new Requirement(operands[operands.length-1].trim(), null));
            }
        }
    }

    public boolean satisfiesCondition(SystemState systemState) {
        // if no requirements all is good
        if (requirements.isEmpty()) {
            return true;
        }
        ArrayList<Boolean> orSequenze = new ArrayList<>();
        boolean temp = true;
        for (Requirement requirement : requirements) {
            temp = temp && requirement.isSatisfied(systemState);
            if (requirement.booleanOperator != "and") {
                orSequenze.add(temp);
                temp = true; // reset temp
            }
        }
        
        boolean result = false;
        for (Boolean boo : orSequenze) {
            result = result || boo;
        }
        return result;
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

    public int getPriority() {
        return priority;
    }

    public void performTransition(SystemState systemState) {
        if (satisfiesCondition(systemState)) {
            systemState.setCurrentNode(nextNode);  
        } else {
            throw new IllegalStateException("Transition failed to transition to node: " + nextNodeName);
        }
    }

}