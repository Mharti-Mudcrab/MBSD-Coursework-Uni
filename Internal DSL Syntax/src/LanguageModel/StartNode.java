package LanguageModel;

public class StartNode extends Node {
    public StartNode(String name, String displayText) {
        super(name, displayText);
    }
    
    @Override
    public Node executeNode(SystemState systemState) {
        displayText();

        if (transition != null) {
            return transition.performTransition();
        }
        else {
            throw new IllegalStateException("Dialogue node has no transition");
        }
    }
}