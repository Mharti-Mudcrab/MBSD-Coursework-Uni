import { enchantedForest as story }  from "./testStory";

import { StoryRunner } from "./StoryRunner";

function start() {

    const runner = new StoryRunner(story);

    console.log(`\n=== Welcome to the ${story.name} Story ===\n`);

    let lastPrintedLogIndex = 0;
    
    while (true) {
        while (lastPrintedLogIndex < runner.logs.length) {
            console.log(runner.logs[lastPrintedLogIndex]+'\n');
            lastPrintedLogIndex++;
        }


        const choices = runner.getAvailableChoices();

        if (choices.length === 0) {
            console.log(`\n=== The End ===\n`);
            return;
        }

        choices.forEach((choice) => {
            console.log(`${choice}`);
        });

        const input = prompt(`\n>`)?.trim();
        if (!input) continue;

        let selectedChoice: string | undefined = choices.find(c => c.toLowerCase() === input.toLowerCase());

        if (!selectedChoice) {
            console.log("Invalid choice, please try again.");
            continue;
        }

        runner.handleChoice(selectedChoice);


    }
   




}

start();

