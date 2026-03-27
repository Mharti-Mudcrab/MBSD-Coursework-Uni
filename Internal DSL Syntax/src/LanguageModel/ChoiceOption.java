package LanguageModel;

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
            if (transition.satisfiesAllRequirements(systemState)) {
                return true;
            }
        }
        return false;
    }

    public Transition getBestTransition(SystemState systemState) {
        Transition bestTransition = null;
        for (Transition transition : transitions) {
            if (transition.satisfiesAllRequirements(systemState)) {
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
}
