package LanguageModel;

import Utils.Output;
import java.lang.IllegalStateException;

public class StoryEngine {

    protected SystemState state;

    public StoryEngine(StoryBuilder story) {
        story.build();
        story.resolveTransitionRefferences();
        this.state = story.getState();
    }

    public void run() throws IllegalStateException{
        Output.print("Welcome to the magical story: " + state.getName() + "\n");

        Node currentNode = state.getCurrentNode();
        
        while (currentNode != null) {
            currentNode.executeNode();
            currentNode = state.getCurrentNode();
        }

        Output.print("Thanks for playing " + state.getName() + "!\n");
    }

}
