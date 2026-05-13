package LanguageModel;

public class Transition {
    
    private Node nextNode;
    protected String nextNodeName;
    private int priority;
    private Condition condition; 

    public Transition(String nextNodeName, int priority, String condition) {
        this.nextNodeName = nextNodeName;
        this.priority = priority;
        this.condition = Condition.parseCondition(condition);
    }

    public boolean satisfiesCondition(SystemState systemState) {
        return condition == null || condition.isSatisfied(systemState);
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