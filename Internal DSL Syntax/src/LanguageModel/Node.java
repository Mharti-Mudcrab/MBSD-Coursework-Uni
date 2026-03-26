package LanguageModel;

import Utils.Output;

public abstract class Node {
    protected String name;
    protected String displayText;
    protected Transition transition;

    public Node (String name) {
        this.name = name;
    }

    public Node (String name, String displayText) {
        this.name = name;
        this.displayText = displayText;
    }

    /**
     * executeNode performs the notes anction and returs the next node to be 
     * executed in the story.
     * @return Node - Next story node
     */
    public abstract void executeNode(SystemState systemState);

    public void displayText() {
        if (displayText != null && !displayText.isEmpty()) {
            Output.println(displayText);
        }
    }

    public String getName() {
        return name;
    }

    public void setTransition(Transition transition) {
        this.transition = transition;
    }

    public void setTransitionRefference(Node node) {
        this.transition.setNextNode(node);
    }

    public String getNextNodeName() {
        if (transition == null) {
            return null;
        }
        return transition.getNextNodeName();
    }

}