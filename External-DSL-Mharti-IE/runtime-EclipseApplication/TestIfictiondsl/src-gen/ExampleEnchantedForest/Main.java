package ExampleEnchantedForest;
			
import LanguageModel.StoryEngine;
		
public class Main {
    public static void main(String args[]) {
        try {
            new StoryEngine(new EnchantedForestBuilder()).run();
        }
        catch (IllegalStateException e) {
            System.err.println(e.getMessage());
        }
    }
}
