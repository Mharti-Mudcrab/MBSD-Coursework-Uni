package LanguageModel;

import java.util.Comparator;
import java.util.ArrayList;
import Utils.Output;

public class ChoiceOption {

    public String displayText;
    public ArrayList<Transition> transitions;


    public ChoiceOption(String displayText) {
        this.displayText = displayText;
        this.transitions = new LinkedHashMap<>();
    }

    public String getDisplayText() {
        return displayText;
    }

    public void addTransition(Transition transition, Requirement requirement) {
        transitions.put(transition, requirement);
    }

    public ArrayList<Transition> getTransitions() {
        return transitions;
    }

    public Transition getBestTransition(SystemState systemState) {
        Transition bestTransition = null;
        for (Transition transition : transitions) {
            if (transition.satisfiesAllRequirements(systemState)) {
                if (bestTransition == null || transition.getPriority() > bestTransition.getPriority()) {
                    bestTransition = transition;
                }
            }
        }
    }
}
