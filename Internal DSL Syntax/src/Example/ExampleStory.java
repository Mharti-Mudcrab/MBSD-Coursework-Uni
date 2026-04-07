package Example;

import LanguageModel.StoryBuilder;
import Utils.Priority;
import java.lang.IllegalStateException;


public class ExampleStory extends StoryBuilder {

    @Override
    public void build() throws IllegalStateException {
        Story("Encanhted Forest")
            .Start("start",
                    "You are in an enchanted forest. Magic fills the air and you feel enchanted\nYou see 2 roads to go down and some bushes around.")
                .Transition("roadChoice") // PRIOIRTY_1 is default
            
            .Choice("roadChoice")
                .ChoiceOption("Go down road number 1")
                    .Transition("road1DialogueTalisman", 2, "Talisman=1")
                    .Transition("road1DialogueNoTalisman")
                .ChoiceOption("Go down road number 2")
                    .Transition("road2Dialogue")
                .ChoiceOption("Look in bushes")
                    .Transition("foundTalismanDialogue", 2, "Talisman=0")
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
                    .Transition("goThroughOpeningDialogueSuccess", 2, "Talisman=1")
                    .Transition("goThroughOpeningDialogueFail")
                
            .Dialogue("goThroughOpeningDialogueSuccess",
                    "You get through to the oppening")
                .Transition("moreChoices...")

            .Dialogue("goThroughOpeningDialogueFail",
                    "On no you are blocked!")
                .Transition("shieldChoice")

            .Dialogue("road1DialogueNoTalisman",
                    "You encounter a suspisious looking old lady!\n\"Hello dear child\"\n\n\"Do you perhaps want to help an old lady through the forest?")
                .Transition("movePastWitchChoice")

            .Dialogue("road1DialogueTalisman",
                    "You encounter a suspisious looking old lady!\n\"Hello dear child\"\n\n\"You see the witch for who she is")
                .Transition("movePastWitchChoice")

            .Choice("movePastWitchChoice")
                .ChoiceOption("Go back to start")
                    .Transition("Start")
                .ChoiceOption("Go past her")
                    .Transition("walkPastWitch", 2, "Talisman=1")
                    .Transition("witchBadEnd")

            .Dialogue("walkPastWitch",
                    "You catch a lurking eye from the old lady as you walk past")
                .Transition("moreChoices...")

            .End("witchBadEnd",
                "The witch stabs you, mauls you and absolutely decimates you. You are dead, dead, dead. Any questions?")

            .End("moreChoices...",
                "Opps... The story ended abruptly.. To be continued maybe?...");
    }
}