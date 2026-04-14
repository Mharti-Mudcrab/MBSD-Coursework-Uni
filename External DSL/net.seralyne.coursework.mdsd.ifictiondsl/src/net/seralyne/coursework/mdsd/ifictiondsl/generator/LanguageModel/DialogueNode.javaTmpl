package LanguageModel;

import java.lang.IllegalStateException;

public class DialogueNode extends Node {

    public DialogueNode(String name, String displayText) {
        super(name, displayText);
    }
    
    public void execute(SystemState systemState) throws IllegalStateException {
        displayText();

        if (transition != null) {
            transition.performTransition(systemState);
        }
        else {
            throw new IllegalStateException("Dialogue node has no transition");
        }
    }

}