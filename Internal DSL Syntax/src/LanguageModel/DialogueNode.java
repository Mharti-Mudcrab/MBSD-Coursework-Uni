package LanguageModel;

public class DialogueNode extends Node {
    @Override
    public void displayText() {
        System.out.println(displayText);
    }

    public DialogueNode(String name, String displayText) {
        super(name, displayText);
    }

    
    public void execute() {
        displayText();

        if (transition != null) {
            transition.execute();
        }
    }

}