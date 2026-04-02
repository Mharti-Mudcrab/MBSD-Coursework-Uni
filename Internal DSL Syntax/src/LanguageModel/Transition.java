package LanguageModel;

public class Transition {
    
    public String nextNodeName;
    public int priority;
    

    public void execute() {
        if (nextNodeName != null) {
            resolveNode(nextNodeName).execute();
        }
    }


    public Transition(String nextNodeName, int priority) {
        this.nextNodeName = nextNodeName;
        this.priority = priority;
    }

    private Node resolveNode(String nextNodeName) {
        return SystemState.getSystemState().getNodeByName(nextNodeName);
        
    }

    
    
}