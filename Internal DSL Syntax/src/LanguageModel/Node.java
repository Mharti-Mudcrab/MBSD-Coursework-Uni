package LanguageModel;

import Utils.Output;

public abstract class Node {
<<<<<<< HEAD
    public String name;
    String displayText;
    Transition transition;


    public abstract void displayText();
    public abstract void execute();

    public void setTransition(Transition transition) {
        this.transition = transition;
=======
    protected String name;
    protected String displayText;
    protected Transition transition;

    public Node (String name) {
        this.name = name;
>>>>>>> 23e094c0adf1119a9e45c094b4eb4075f9253dcf
    }

    public Node (String name, String displayText) {
        this.name = name;
        this.displayText = displayText;
    }

    /**
     * execute performs the notes anction and returs the next node to be 
     * executed in the story.
     * @return Node - Next story node
     */
    public abstract void execute(SystemState systemState);

    public void displayText() {
        if (displayText != null && !displayText.isEmpty()) {
            Output.printLine("\n" + displayText + "\n");
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

    public Transition getTransition() {
        if (transition == null) {
            return null;
        }
        return transition;
    }

    public boolean resolveTransitionNodeRefference(SystemState systemState) {
        if (transition != null) {
            if (transition.getNextNode() != null) {
                return true;
            } else {
                transition.setNextNode(systemState.getNode(transition.getNextNodeName()));
            }
        }
        return false;
    }

}