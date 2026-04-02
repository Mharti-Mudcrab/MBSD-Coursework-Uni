package LanguageModel;

public class StartNode extends Node {

    public StartNode(String name, String displayText) {
        super(name, displayText);
    }

    @Override
    public void displayText() {
        System.out.println(displayText);
    }

    @Override
    public void execute() {
        displayText();
        if (transition != null) {
            transition.execute();
        }
    }

}
