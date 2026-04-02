package LanguageModel;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChoiceOption {

    public HashMap<Transition, List<Requirement>> possibleTransitions;
    public String optionText;

    public ChoiceOption(String optionText) {
        this.optionText = optionText;
        this.possibleTransitions = new HashMap<>();
    }

    public void addRequirement(Transition transition, Item item, int quantity) {
        if (!possibleTransitions.containsKey(transition)) {
            possibleTransitions.put(transition, new ArrayList<>());
            possibleTransitions.get(transition).add(new Requirement(item, quantity));
            return;
        }
        
        possibleTransitions.get(transition).add(new Requirement(item, quantity));
        

    }

    public void addTransition(Transition transition) {
        if (!possibleTransitions.containsKey(transition)) {
            possibleTransitions.put(transition, new ArrayList<>());
        }
    }

    public Transition getBestTransition(SystemState state) {
        Transition bestTransition = null;
        for (Transition transition : possibleTransitions.keySet()) {
            List<Requirement> requirements = possibleTransitions.get(transition);

            if (!meetsAllRequirements(state, requirements)) 
                continue;

            // If we do, see if the transition has higher priority than the best one we've found so far, if any.
            if (bestTransition == null || transition.priority > bestTransition.priority)
                bestTransition = transition;

        }
        return bestTransition;
    }


    private boolean meetsRequirement(SystemState state, Requirement requirement) {
        return state.hasItem(requirement.item, requirement.quantity);
    }

    private boolean meetsAllRequirements(SystemState state, List<Requirement> requirements) {
        for (Requirement requirement : requirements) {
            if (!meetsRequirement(state, requirement)) {
                return false;
            }
        }
        return true;
    }

    public String getOptionText() {
        return optionText;
    }

=======
import java.lang.IllegalStateException;
import java.util.ArrayList;

public class ChoiceOption {

    public String displayText;
    public ArrayList<Transition> transitions;


    public ChoiceOption(String displayText) {
        this.displayText = displayText;
        this.transitions = new ArrayList<>();
    }

    public String getDisplayText() {
        return displayText;
    }

    public void setTransition(Transition transition) {
        transitions.add(transition);
    }

    public ArrayList<Transition> getTransitions() {
        return transitions;
    }

    public boolean hasViableTransition(SystemState systemState) {
        for (Transition transition : transitions) {
            if (transition.satisfiesCondition(systemState)) {
                return true;
            }
        }
        return false;
    }

    public Transition getBestTransition(SystemState systemState) {
        Transition bestTransition = null;
        for (Transition transition : transitions) {
            if (transition.satisfiesCondition(systemState)) {
                if (bestTransition == null || transition.getPriority().value() > bestTransition.getPriority().value()) {
                    bestTransition = transition;
                }
            }
        }
        if (bestTransition == null) {
            throw new IllegalStateException("No best transition found for choice option: " + displayText);
        }
        return bestTransition;
    }
>>>>>>> 23e094c0adf1119a9e45c094b4eb4075f9253dcf
}
