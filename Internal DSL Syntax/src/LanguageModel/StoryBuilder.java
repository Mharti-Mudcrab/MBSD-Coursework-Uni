package LanguageModel;

import java.lang.IllegalStateException;
import java.util.HashMap;

public class StoryBuilder {

    protected SystemState state;

    public abstract StoryBuilder build() throws IllegalStateException;

    public SystemState getState() {
        return state;
    }

    public StoryBuilder(String name) {
        this.state = new SystemState(name);
    }

    public static StoryBuilder Story(String name) {
        return new StoryBuilder(name);
    }

    public StoryBuilder Start(String name, String displayText) {
        state.addNode(name, new StartNode(name, displayText));
        return this;
    }

    public StoryBuilder Dialogue(String name, String displayText) {
        state.addNode(name, new DialogueNode(name, displayText));
        return this;
    }

    public StoryBuilder Choice(String name) {
        return Choice(name, null);
    }

    public StoryBuilder Choice(String name, String displayText) {
        state.addNode(name, new ChoiceNode(name, displayText));
        return this;
    }

    public StoryBuilder ChoiceOption(String displayText) throws IllegalStateException {
        state.addChoiceOption(new ChoiceOption(displayText));
        return this;
    }

    public StoryBuilder SystemStateChange(String name, String displayText, String expression) {
        state.addNode(name, new SystemStateChangeNode(name, displayText, expression));
        return this;
    }

    public StoryBuilder End(String name, String displayText) {
        state.addNode(name, new EndNode(name, displayText));
        return this;
    }

    public StoryBuilder Transition(String targetName) throws IllegalStateException {
        return Transition(targetName, Priority.LOW, null);
    }

    public StoryBuilder Transition(String targetName, Priority priority, String condition) {
        state.setTransition(targetName, priority, condition);
        return this;
    }

    public void resolveTransitionRefferences() {
        state.resolveTransitionRefferences();
    }


}
