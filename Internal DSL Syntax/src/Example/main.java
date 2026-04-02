package Example;

import LanguageModel.StoryEngine;
import java.lang.IllegalStateException;


public class Main {
    public static void main(String args[]) {
        try {
            new StoryEngine(new ExampleStory()).run();
        }
        catch (IllegalStateException e) {
            System.err.println(e.getMessage());
        }
    }
}