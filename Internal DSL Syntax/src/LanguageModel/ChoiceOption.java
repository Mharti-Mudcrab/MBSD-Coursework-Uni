package LanguageModel;

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

}
