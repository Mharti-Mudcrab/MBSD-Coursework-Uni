package LanguageModel;

public class StartNode extends Node {
    public StartNode(String name, String displayText) {
        super(name, displayText);
    }
    
    @Override
    public void execute(SystemState systemState) {
        displayText();

        if (transition != null) {
            transition.performTransition(systemState);
        }
        else {
            throw new IllegalStateException("Dialogue node has no transition");
        }
    }
}
