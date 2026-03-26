package LanguageModel;

public class EndNode extends Node {
    
    public EndNode(String name, String displayText) {
        super(name, displayText);
        this.transition = null; // has no transition
    }
    
    @Override
    public void executeNode(SystemState systemState) {
        displayText();
        systemState.setCurrentNode(null);
    }

}
