package Example;

import LanguageModel.StoryEngine;
import LanguageModel.Priority;
import java.lang.IllegalStateException;


public class main {
    public static void main (String args[]) {
        try {
            new StoryEngine(new ExampleStory()).run();
        }
        catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}