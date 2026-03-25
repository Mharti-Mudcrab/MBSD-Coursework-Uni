package LanguageModel;

public abstract class Node {
    public String name;
    private String displayText;
    private Transition transition;


    public abstract void displayText();
    public abstract void executeNode();

    public void setTransition(Transition transition) {
        this.transition = transition;
    }

    public Node (String name, String displayText) {
        this.name = name;
        this.displayText = displayText;
    }


}