package Example;

import LanguageModel.StoryBuilder;
import LanguageModel.Priority;
import java.lang.IllegalStateException;


public class ExampleStory extends StoryBuilder {

    @Override
    public StoryBuilder build() throws IllegalStateException {
        return Story("Encanhted Forest")
                .Start("start",
                        "You are in an enchanted forest. Magic fills the air and you feel enchanted\n\nYou see 2 roads to go down and some bushes around")
                    .Transition("roadChoice") // PRIOIRTY_1 is default
                
                .Choice("roadChoice")
                    .ChoiceOption("Go down road number 1")
                        .Transition("road1DialogueTalisman", PRIORITY_HIGH, "Talisman=1")
                        .Transition("road1DialogueNoTalisman")
                    .ChoiceOption("Go down road number 2")
                        .Transition("road2Dialogue")
                    .ChoiceOption("Look in bushes")
                        .Transition("foundTalismanDialogue", PRIORITY_HIGH, "Talisman=1")
                        .Transition("foundNothingDialogue")
                
                .Dialogue("foundTalismanDialogue",
                        "You found a Talisman! It looks important")
                    .Transition("addTalismanSystemStateChange")

                .SystemStateChange("addTalismanSystemStateChange", 
                        "Adds talisman to backpack",
                        "Talisman=1")
                    .Transition("roadChoice")
                
                .Dialogue("foundNothingDialogue",
                        "You found nothing")
                    .Transition("roadChoice")

                .Dialogue("road2Dialogue",
                        "You find an oppening in the forest but wait! It is blocked by a magic Shield!")
                    .Transition("shieldChoice")
                
                .Choice("shieldChoice")
                    .ChoiceOption("Go back to start")
                        .Transition("Start")
                    .ChoiceOption("Try to go through")
                        .Transition("goThroughOpeningDialogueSuccess", PRIORITY_HIGH, "Talisman=1")
                        .Transition("goThroughOpeningDialogueFail")
                    
                .Dialogue("goThroughOpeningDialogueSuccess",
                        "You get through to the oppening")
                    .Transiton("moreChoices...")

                .Dialogue("goThroughOpeningDialogueFail",
                        "On no you are blocked!")
                    .Transiton("shieldChoice")

                .Dialogue("road1DialogueNoTalisman",
                        "You encounter a suspisious looking old lady!\n\"Hello dear child\"\n\n\"Do you perhaps want to help an old lady through the forest?")
                    .Transiton("movePastWitchChoice")

                .Dialogue("road1DialogueTalisman",
                        "You encounter a suspisious looking old lady!\n\"Hello dear child\"\n\n\"You see the witch for who she is")
                    .Transiton("movePastWitchChoice")

                .Choice("movePastWitchChoice")
                    .ChoiceOption("Go back to start")
                        .Transition("Start")
                    .ChoiceOption("Go past her")
                        .Transition("walkPastWitch", PRIORITY_HIGH, "Talisman=1")
                        .Transition("witchBadEnd")

                .Dialogue("walkPastWitch",
                        "You catch a lurking eye from the old lady as you walk past")
                    .Transiton("moreChoices...")

                .End("witchBadEnd",
                    "The witch stabs you, mauls you and absolutely decimates you. You are dead, dead, dead. Any questions?")

                .End("moreChoices...",
                    "Opps... The story ended abruptly.. To be continued maybe?...");
    }
}