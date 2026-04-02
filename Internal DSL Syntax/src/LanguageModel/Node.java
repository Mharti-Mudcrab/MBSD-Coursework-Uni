package LanguageModel;

public abstract class Node {
    public String name;
    String displayText;
    Transition transition;


    public abstract void displayText();
    public abstract void execute();

    public void setTransition(Transition transition) {
        this.transition = transition;
    }

    public Node (String name, String displayText) {
        this.name = name;
        this.displayText = displayText;
    }


}