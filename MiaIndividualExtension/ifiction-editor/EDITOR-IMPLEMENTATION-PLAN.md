# Editor Implementation Plan

This plan turns the current React Flow canvas into a user-friendly story editor while keeping the internal DSL hidden from the user.

## Goal

Build `StoryEditor` as the visual authoring surface for stories, not as a direct view of the AST or runtime model.

The user should be able to:
- create and delete story nodes
- select nodes and edit their properties
- edit transitions as first-class objects
- see and understand the story graph visually
- save and reload the story document

## Guiding Rules

- Keep `story` as the source of truth for persisted data.
- Do not expose the internal AST or parser structure in the UI.
- Treat transitions as meaningful editor objects, not ordinary wires.
- Prefer Blueprint-like usability and direct manipulation.
- Keep the canvas simple and friendly, even when the underlying model is rich.

## Build Order

### 1. Editor Shell ✓ DONE

Multi-pane layout implemented:
- left: React Flow canvas with all node types rendered
- right: collapsible inspector panel
- far-right: collapsible virtual console (story runner)
- Smooth pane transitions and toggle buttons

### 2. Node Selection and Editing ✓ DONE

Node selection on canvas, inspector allows editing:
- label
- id (with automatic transition rename/redirect)
- display text
- delete button (disabled for start node)
- Sub-block selection (transitions, options, variable blocks, condition blocks) resolves correctly in the inspector and preserves selection across edits

### 3. Node and Block Creation ✓ DONE

Toolbar implemented in `NodeToolbar.tsx`, rendered above the canvas:
- **Node group**: Dialogue, Choice, State Change, End — each creates a story node with a unique auto-ID, drops it on the canvas, and auto-selects it
- **Block group**: Transition, Option, Variable — each creates an orphaned block ready to be wired
- **Condition group**: Comparison, AND, OR — each creates an orphaned condition block; AND/OR render as standalone gates with no children until wired
- Start node intentionally has no creation button (only one allowed per story)
- Adding options and variable blocks via wiring is the intended flow (create orphan, then wire to parent)

### 4. Wiring ✓ DONE

Canvas edge dragging implemented via `onConnect` in `StoryEditor.tsx`. All handle IDs follow a consistent `input`/`output` convention (semantic handles `condition`, `var`, `conditionA`, `conditionB` retained). Supported connection flows:

- **Transition → StoryNode** (`output → input`): sets `transition.targetNodeId`
- **StoryNode/OptionBlock → orphaned Transition** (`output → input`): adopts the orphaned transition into the node or option's transitions array
- **ChoiceNode → orphaned OptionBlock** (`output → input`): adopts the orphaned option into the choice node's choices array
- **Orphaned ConditionBlock → Transition `condition` handle**: attaches the orphaned condition tree root to the transition
- **Orphaned ConditionBlock → AND/OR `conditionA`/`conditionB`**: wires the orphaned condition into the left or right slot of a logical group
- **Orphaned VariableBlock → StateChangeNode `var` handle**: adopts the orphaned variable change into the state change node's stateChanges array
- Edges for orphaned transitions with a set `targetNodeId` are derived and rendered correctly
- Position is preserved on all block adoptions (no reset to origin on wire)

### 5. Choice, Option, and Transition Editing ✓ DONE

- `ChoiceNode`: options created via toolbar (orphaned) and wired in; options deletable from inspector (orphans transitions on deletion)
- `OptionBlock`: display text editable in inspector; transitions managed via wiring
- `TransitionBlock`: priority editing and deletion in inspector; both edges wired via canvas interaction

### 5.1. Condition Editing ✓ DONE

- **Storage**: Conditions stored as nested `Condition` AST on transitions; persisted to JSON ✓
- **Rendering**: Condition blocks render on canvas from existing AST data ✓
- **Block types**: Comparison blocks (variable, operator, value) and AND/OR gates ✓
- **Conversion**: `conditionASTToBlocks` converts AST ↔ visual block trees; path-based stable block IDs ✓
- **Inspector editing**: Comparison block fields editable; AND/OR and orphaned condition blocks inspectable and deletable ✓
- **Orphaned nodes**: Stored in `story.orphanedConditions[]`; render as disconnected floating subtrees ✓
- **Two-tier deletion**: "Delete Block Only" (orphans children) and "Delete Entire Subtree" on both attached and orphaned condition blocks ✓
- **Wiring**: Orphaned condition blocks wire to transition `condition` handles and AND/OR gate inputs via canvas ✓

### 6. State Change & Dialogue Editing ✓ DONE

- **Variable blocks**: editing variable name, operator, and value fully implemented in inspector ✓
- **Variable block wiring**: orphaned variable blocks wire to StateChangeNode `var` handle; adoption preserves position ✓
- **State Change nodes**: entry management is via toolbar + wire by design; no direct inspector add/remove intended ✓

### 7. Persistence ✓ DONE

Save/Load buttons in `NodeToolbar.tsx`:
- Save: serialises `story` to JSON and triggers a browser download
- Load: file picker reads a `.json` file and replaces the current story via `onStoryChange`
- Node ids, positions, and all transition/orphan data round-trip through `JSON.stringify`/`JSON.parse` intact

### 8. Validation and Feedback ⊘ OUT OF SCOPE

Validation (missing targets, orphans, cycles, etc.) is explicitly out of scope for this iteration.

## Suggested Component Breakdown

- `StoryEditor.tsx`: top-level editor composition ✓ exists
- `StoryInspector.tsx`: editing panel for selected node ✓ exists
- `NodeToolbar.tsx`: create/delete/save controls ✓ exists
- `ChoiceNode.tsx`: visual display ✓ exists
- `TransitionBlock.tsx`: first-class transition card ✓ exists
- `StateChangeNode.tsx`: visual display ✓ exists (variable block add via toolbar+wiring only)
- `DialogueNode.tsx`: visual display ✓ exists
- `OptionBlock.tsx`: option card for choice nodes ✓ exists
- `StartNode.tsx`, `EndNode.tsx`: visual bookends ✓ exist

## Current Status

**What works:**
- Canvas renders all node types with correct styling
- Transitions, options, condition blocks, and variable blocks render as first-class canvas objects
- All canvas connections display correctly and can be created or changed via drag
- Orphaned blocks (transitions, options, variables, conditions) can be created from the toolbar and wired back into the graph
- Node selection and basic property editing (id, label, displayText)
- Sub-block selection (transition, option, variable, condition) persists correctly across inspector edits — no deselect-on-edit bug
- Node deletion (with start node protection) orphans dependent blocks
- ID renaming with automatic transition update
- Dragging nodes/transitions/options/condition blocks preserves positions; multi-type drags handled correctly
- Transition priority editing and deletion in inspector
- Condition block inspector editing (comparison fields, orphan editing and two-tier deletion)
- Variable block field editing in inspector
- Story runner updates in real-time; path validity preserved when story changes
- Node and block creation via toolbar (all story node types, all block types, all condition block types)
- Save/load to JSON

**What's missing:** nothing — all planned features are implemented.

## Stretch Goals

These features are beyond the core scope but would enhance usability if time permits:

- **Multi-select and group drag**: Region-select multiple canvas nodes via rubber-band drag, then move them together. React Flow supports multi-select natively; the work is (1) removing the `selected`-sync `useEffect` that currently fights React Flow's internal selection state, (2) replacing `onNodeClick`/`onPaneClick` with `onSelectionChange` so the inspector shows "nothing selected" when 0 or 2+ nodes are selected, and (3) adding `onSelectionDragStop` to save all moved positions in one story update. Optionally switch `panOnDrag` to right-click so left-drag rubber-bands without needing Shift.
- **System refactor**: Two categories of technical debt have accumulated. First, type-safety: `as any` casts throughout `StoryEngine.ts`, `StoryInspector.tsx`, and `conditionBlocksGenerator.ts` stem from `Condition` and related types not being modelled as proper discriminated unions; a refactor would tighten these types in `types.ts`, remove the casts, and consolidate the duplicated validation logic between `isConditionStructurallyValid` (VirtualConsole) and `checkCondition` (StoryEngine). Second, file size and responsibility: several files — particularly `StoryInspector.tsx` and `StoryEditor.tsx` — have grown large and handle too many concerns; splitting these along single-responsibility lines would improve maintainability.
- **Unreal-style comments**: Draggable, resizable comment boxes on the canvas for documenting sections of the story graph. Comments are visual annotations only (no functional connections) and can be colored and positioned freely.
- **Choice text healing**: When a choice's option text is edited, attempt to preserve the runner's active selection by matching the updated option to the previous selection. Use a simple matching strategy (exact match → index match → fallback to nearest index) to pick the best candidate and update the selection so the story continues seamlessly across minor text edits.
- Additional node types (conditions as standalone nodes, branches, etc.)
- Visual feedback for currently-executing path in the runner
- Undo/redo for editor changes
- Story templates or quick-start presets
- Export to other formats (Twine, Ink, etc.)
