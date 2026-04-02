package LanguageModel;

import java.util.ArrayList;
<<<<<<< HEAD
import java.util.List;
import java.util.Scanner;

public class ChoiceNode extends Node {

    List<ChoiceOption> options;
    static final Scanner scanner = new Scanner(System.in);

    public ChoiceNode(String name, String displayText) {
        super(name, displayText);
        this.options = new ArrayList<>();
    }

    public void addOption(ChoiceOption option) {
        options.add(option);
    }

    @Override
    public void displayText() {
        System.out.println(displayText);
        for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i).getOptionText());
        }

        System.out.println("What do you do? (Type the option text to choose)");
    }

    @Override
    public void execute() {
        
        displayText();

        if (options.isEmpty()) {
            System.out.println("No options available. Ending execution.");
            throw new IllegalStateException("No options available for this choice node: " + name);
        }

        ChoiceOption selectedOption = getUserChoice();
        while (selectedOption == null) {
            System.out.println("Invalid choice. Please try again.");
            selectedOption = getUserChoice();
        }

        Transition bestTransition = selectedOption.getBestTransition(SystemState.getSystemState());
        if (bestTransition == null)
            throw new IllegalStateException("No valid transitions available for the selected option: " + selectedOption.getOptionText());
        bestTransition.execute();

    }


    private ChoiceOption getUserChoice() {
        ChoiceOption selectedOption = null;
        String choice = scanner.nextLine();
        for (ChoiceOption option : options) {
            if (option.getOptionText().equalsIgnoreCase(choice)) {
                selectedOption = option;
                break;
            }
        }
        return selectedOption;
    }

}
 
=======
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
>>>>>>> 23e094c0adf1119a9e45c094b4eb4075f9253dcf
