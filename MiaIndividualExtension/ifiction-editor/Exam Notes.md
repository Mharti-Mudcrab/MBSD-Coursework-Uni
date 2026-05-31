Architecture Overview:

- Refactored such that the story does not contain editor state.
Positions on the canvas is stored separately from the program itself. Orphaned nodes also live here.

Three-Layer Architecture:
Data - Defines node types, the conditions system, the system state, etc.
Model - Primarily the interpreter and runner. The builder and console runner for the "internal" DSL also lives here, though both compile their data to JSON at the end of the day. Some helper functions used primarily for storing editor related data also lives here.
Editor - The core of the extension lives here, as this is where the editor functionality lives.

In practice, the VirtualConsole acts as the story runner in the browser and has achieved Level 4 liveness. 

StoryInspector and InspectorSelection manage node/block properties. 

canvasLayout does what??

wiring.ts handles all logic related to wiring. It used to live in StoryEditor, but was moved to its own file to ease clarity.

NodeToolbar handles node creation and (de)serialization of the data structure for save and load functionality.

StoryEditor glues the main canvas-related functionality together, while the overall connecting glue for the editor in its entirety lives in the main App.tsx file.

At an interface level, we distinguish between "nodes" and "blocks". This terminology exists to indicate what produces a node in the data structure, and what doesn't, though the user doesn't necessarily need to know about this distinction themselves. What is represented as blocks in the graph will always at the end of the chain be owned by a node when connected to the main data structrure. These can also have sub data structures of their own. In the most extreme case, a Condition can be attached to a Transition, which in turn can be attached to a ChoiceOption, which in itself is attached to a ChoiceNode. The handles these Block handles attach to (with the exception of Choice Options) also have separate colorations from the main story graph, which indicates these are a different kind of input. This is also reflected in the handles of the blocks that these attach to. For example, since the state change input handle for a StateChangeNode is green, the output handle of a Variable Block is also green.

The only case in which this colouration is *not* the case is for ChoiceNodes and Choice Option Blocks, because Choice Options are an integral part of the ChoiceNode flow, and choices are treated as as the logical next step after a choice node, not an optional input, so these tie more into the main flow than the others.


# File notes

