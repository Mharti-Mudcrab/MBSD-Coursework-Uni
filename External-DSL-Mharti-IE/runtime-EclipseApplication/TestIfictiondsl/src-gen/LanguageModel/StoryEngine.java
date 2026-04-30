package LanguageModel;

import Utils.Output;

public class StoryEngine {

    protected SystemState state;

    public StoryEngine(StoryBuilder story) {
        story.build();
        story.resolveTransitionRefferences();
        this.state = story.getState();
    }

    public void run() throws IllegalStateException{
        Output.printLine("Welcome to the magical story: " + state.getName());

        while (state.isRunning()) {
            state.getCurrentNode().execute(state);
        }

        Output.printLine("\nThanks for playing " + state.getName() + "!\n");
    }

}
