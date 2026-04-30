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
                if (bestTransition == null || transition.getPriority() > bestTransition.getPriority()) {
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
