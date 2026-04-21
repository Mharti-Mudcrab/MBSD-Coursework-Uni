import { StoryBuilder } from './model/StoryBuilder';

const builder = new StoryBuilder();

export const enchantedForest = builder
    .Story("EnchantedForest")
    
    // --- Start Node ---
    .Start("Start", "You are in an enchanted forest. Magic fills the air and you feel enchanted\n\nYou see 2 roads to go down and some bushes around")
        .Transition("roadChoice")

    // --- Choice Node: roadChoice ---
    .Choice("roadChoice", "What do you want to do?")
        .ChoiceOption("Go down road number 1")
            .Transition("road1DialogueTalisman", 2, "Talisman==1 and Coin==5 or ((Cucumber<10 and Favor>=15) or (CancanDancers==1)) or Grit==100")
            .Transition("road1DialogueNoTalisman")
        
        .ChoiceOption("Go down road number 2")
            .Transition("road2Dialogue")
        
        .ChoiceOption("Look in bushes")
            .Transition("addTalismanSystemStateChange", 3, "Talisman==0")
            .Transition("addCoinSystemStateChange", 3, "Talisman==1 and BushLookup<3")
            .Transition("addPictureSystemStateChange", 2, "Talisman==1 and BushLookup<4")
            .Transition("foundNothingSystemStateChange", 1, "BushLookup<5")

    // --- State Change Nodes ---
    .StateChange("addPictureSystemStateChange", "You found a picture of your mom! aaaw...\nThat goes right in the shoulder pocket <3", 
        "BushLookup+=1, PictureOfMom=1")
        .Transition("roadChoice")

    .StateChange("addCoinSystemStateChange", "You found some coin! neat...\nAdded 5 coins to backpack!", 
        "BushLookup+=1, Coin+=5")
        .Transition("roadChoice")

    .StateChange("addTalismanSystemStateChange", "You found a Talisman! It looks important!\nAdded the talisman to backpack ", 
        "Talisman=1, Coin+=10, Cucumber-=1") // Fixed 'Coind' typo from original
        .Transition("roadChoice")

    .StateChange("foundNothingSystemStateChange", "You found nothing...", 
        "BushLookup+=1")
        .Transition("roadChoice")

    // --- Road 2 Branch ---
    .Dialogue("road2Dialogue", "You find an opening in the forest but wait! It is blocked by a magic Shield!")
        .Transition("shieldChoice")

    .Choice("shieldChoice", "The magic shield pulses with energy.")
        .ChoiceOption("Go back to start")
            .Transition("Start")
        .ChoiceOption("Try to go through")
            .Transition("goThroughOpeningDialogueSuccess", 2, "Talisman==1")
            .Transition("goThroughOpeningDialogueFail")

    .Dialogue("goThroughOpeningDialogueSuccess", "You get through to the opening")
        .Transition("abruptBadEnd")

    .Dialogue("goThroughOpeningDialogueFail", "On no you are blocked!")
        .Transition("shieldChoice")

    // --- Road 1 Branch ---
    .Dialogue("road1DialogueNoTalisman", "You encounter a suspicious looking old lady!\n\"Hello dear child\"\n\n\"Do you perhaps want to help an old lady through the forest?")
        .Transition("movePastWitchChoice")

    .Dialogue("road1DialogueTalisman", "You encounter a suspicious looking old lady!\n\"Hello dear child\"\n\n\"You see the witch for who she is")
        .Transition("movePastWitchChoice")

    .Choice("movePastWitchChoice", "The old lady smiles, but her eyes remain cold.")
        .ChoiceOption("Go back to start")
            .Transition("Start")
        .ChoiceOption("Go past her")
            .Transition("walkPastWitch", 2, "Talisman==1")
            .Transition("witchBadEnd")

    .Dialogue("walkPastWitch", "You catch a lurking eye from the old lady as you walk past")
        .Transition("abruptBadEnd")

    // --- End Nodes ---
    .End("witchBadEnd", "The witch stabs you, mauls you and absolutely decimates you. You are dead, dead, dead. Any questions?")
    .End("abruptBadEnd", "Oops... The story ended abruptly.. To be continued maybe?...")

    .build();