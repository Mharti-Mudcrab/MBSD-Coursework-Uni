package LanguageModel;

public class DialogueNode extends Node {
    @Override
    public void displayText() {
        System.out.println(displayText);
    }

    public DialogueNode(String name, String displayText) {
        super(displayText);
    }

    
    public void executeNode() {
        displayText();

        if (transition != null) {
            transition.run();
        }
    }

}