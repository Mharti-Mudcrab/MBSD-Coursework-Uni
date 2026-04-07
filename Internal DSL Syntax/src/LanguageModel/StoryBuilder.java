package LanguageModel;

import java.lang.IllegalStateException;
import Utils.Priority;

public abstract class StoryBuilder {

    protected SystemState state;

    public abstract void build() throws IllegalStateException;

    public SystemState getState() {
        return state;
    }

    public StoryBuilder() {
        state = new SystemState();
    }

    public StoryBuilder Story(String name) {
        state.setName(name);
        return this;
    }

    public StoryBuilder Start(String name, String displayText) {
        Node startNode = new StartNode(name, displayText);
        state.setStartNode(startNode);
        state.addNode(name, startNode);
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
        return Transition(targetName, 0, null);
    }

    public StoryBuilder Transition(String targetName, int priority, String condition) {
        state.setTransition(targetName, priority, condition);
        return this;
    }

    public void resolveTransitionRefferences() {
        state.resolveTransitionRefferences();
    }
}
