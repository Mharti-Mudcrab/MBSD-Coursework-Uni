package LanguageModel;

public class StartNode extends Node {
<<<<<<< HEAD

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
=======
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
>>>>>>> 23e094c0adf1119a9e45c094b4eb4075f9253dcf
