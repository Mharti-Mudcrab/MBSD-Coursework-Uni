package LanguageModel;

import java.util.ArrayList;
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
 
