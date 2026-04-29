package LanguageModel;

import java.util.ArrayList;
import Utils.Input;
import Utils.Output;

public class ChoiceNode extends Node {


    private ArrayList<ChoiceOption> options;

    public ChoiceNode(String name) {
        super(name);
        this.options = new java.util.ArrayList<>();
    }

    public ChoiceNode(String name, String displayText) {
        super(name, displayText);
        this.options = new java.util.ArrayList<>();
    }

    public void addOption(ChoiceOption option) {
        this.options.add(option);
    }

    public ArrayList<ChoiceOption> getOptions() {
        return options;
    }

    @Override
    public void execute(SystemState systemState) {
        displayText();

        Output.printLine("Your choices are:");

        ArrayList<ChoiceOption> viableOptionList = new ArrayList<>();
        for (ChoiceOption option : options) {
            if (option.hasViableTransition(systemState)) {
                // i.e: - walk in the door (1)
                Output.printLine("\t - " + option.getDisplayText()) ;
                viableOptionList.add(option);
            }
        }

        if (viableOptionList.isEmpty()) {
            throw new IllegalStateException("No viable options available for this choice node.");
        }

        Output.printNoLine("> ");
        String answer = "";
        while (answer.isEmpty()) {
            answer = Input.readLine();
            for (ChoiceOption option : viableOptionList) {
                if (option.getDisplayText().equalsIgnoreCase(answer)) {
                    Transition transition = option.getBestTransition(systemState);
                    if (transition != null) {
                        transition.performTransition(systemState);
                        return;
                    }
                }
            }
            Output.printLine("Invalid choice, please try again.");
            Output.printNoLine("> ");
            answer = "";
        }
    }

    @Override
    public boolean resolveTransitionNodeRefference(SystemState systemState) {
        for (ChoiceOption option : options) {
            for (Transition transition : option.getTransitions()) {
                if (transition.getNextNode() == null) {
                    transition.setNextNode(systemState.getNode(transition.getNextNodeName()));
                }
            }
        }
        return true;
    }
}
