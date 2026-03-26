package LanguageModel;

import java.util.ArrayList;
import Utils.Output;
import Utils.Input;

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
    public void executeNode(SystemState systemState) {
        displayText();

        Output.println("Your choices are:");

        ArrayList<ChoiceOption> viableOptionList = new ArrayList<>();
        for (ChoiceOption option : options) {
            if (option.getBestTransition(systemState) != null) {
                // i.e: - walk in the door (1)
                Output.println("\t - " + option.getDisplayText()) ;
                viableOptionList.add(option);
            }
        }

        if (viableOptionList.isEmpty()) {
            throw new IllegalStateException("No viable options available for this choice node.");
        }

        String answer = "";
        while (answer.isEmpty()) {
            answer = Input.readLine();
            for (option : viableOptionList) {
                if (option.getDisplayText().equalsIgnoreCase(answer)) {
                    Transition transition = option.getBestTransition(systemState);
                    if (transition != null) {
                        transition.performTransition(systemState);
                    }
                }
            }
            Output.println("Invalid choice, please try again.");
        }
    }
}