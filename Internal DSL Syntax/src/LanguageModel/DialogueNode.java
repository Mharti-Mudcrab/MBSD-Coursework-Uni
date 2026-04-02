package LanguageModel;

import java.lang.IllegalStateException;

public class DialogueNode extends Node {

    public DialogueNode(String name, String displayText) {
        super(name, displayText);
    }
    
<<<<<<< HEAD
    public void execute() {
        displayText();

        if (transition != null) {
            transition.execute();
=======
    public void execute(SystemState systemState) throws IllegalStateException {
        displayText();

        if (transition != null) {
            transition.performTransition(systemState);
        }
        else {
            throw new IllegalStateException("Dialogue node has no transition");
>>>>>>> 23e094c0adf1119a9e45c094b4eb4075f9253dcf
        }
    }

}