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

### 3. Node and Block Creation ⧗ REMAINING — IMMEDIATE PRIORITY

Deletion is fully implemented. Creation is entirely missing:
- `NodeToolbar.tsx` currently exists as a stub with no code
- No way to add any node type to the canvas
- No way to add transitions, options, state changes, or condition blocks to existing nodes
- Provide toolbar buttons or a context menu to add nodes of each type
- Ensure start-node rules remain enforced when creating or promoting nodes

### 4. Wiring ⧗ REMAINING — IMMEDIATE PRIORITY

Canvas edge dragging is not implemented. This is the other major missing feature and affects every canvas-level connection. All existing connections from story data display correctly; none can be created or changed interactively.

Connection flows that need wiring support:
- **Transitions**: `SourceNode → Transition → TargetNode` or `SourceChoiceOption → Transition → TargetNode` — both edges need to be draggable
- **Condition blocks**: `Transition condition handle → root condition block (AND/OR gate or comparison block) → further condition blocks as needed` — building or reconnecting condition trees requires dragging between block handles
- **Variable blocks**: canvas-level wiring of variable blocks to their parent state change node
- **Orphan reconnection**: reconnecting any orphaned block back into the graph also depends on this

### 5. Choice, Option, and Transition Editing ⧗ PARTIAL

Visual rendering is complete. Inspector editing is partial:
- `ChoiceNode`: canvas rendering complete; inspector rows for adding/removing/editing options are missing
- `OptionBlock`: options render and persist positions; no way to add or remove options via the inspector
- `TransitionBlock`: priority editing and deletion work in the inspector; both edges (source → transition, transition → target) require wiring support from Section 4

### 5.1. Condition Editing ⧗ PARTIAL

Condition block rendering and inspector editing are implemented; wiring is not:
- **Storage**: Conditions stored as nested `Condition` AST on transitions; persisted to JSON ✓
- **Rendering**: Condition blocks render on canvas from existing AST data ✓
- **Block types**: Comparison blocks (variable, operator, value) and AND/OR gates; root block can be either ✓
- **Conversion**: `conditionASTToBlocks` converts AST ↔ visual block trees; path-based stable block IDs ✓
- **Parentheses**: Implicit in block topology ✓
- **Architecture**: Condition blocks rendered on-demand from AST; not persisted directly ✓
- **Inspector editing**: Comparison block fields editable; orphaned blocks editable and deletable ✓
- **Orphaned nodes**: Stored in `transition.orphanedConditions[]`; render as disconnected floating subtrees ✓
- **Wiring**: Cannot connect condition blocks to each other or to transitions via canvas interaction ⧗ (blocked by Section 4)

### 6. State Change & Dialogue Editing ⧗ PARTIAL

Variable block inspector editing is implemented. Canvas-level wiring and node-level management are not:
- **Variable blocks**: editing variable name, operator, and value is fully implemented in the inspector ✓
- **State Change nodes**: no UI to add or remove state change entries at the node level; canvas wiring of variable blocks is also missing (tracked under Section 4)
- **Dialogue nodes**: only generic node properties (label, id, displayText) are editable; no richer editing surface

### 7. Persistence ⧗ REMAINING

Not started. Required for a usable editor:
- Export story to JSON
- Import story from JSON
- Preserve node ids, positions, and all transition data

### 8. Validation and Feedback ⊘ OUT OF SCOPE

Validation (missing targets, orphans, cycles, etc.) is explicitly out of scope for this iteration.

## Suggested Component Breakdown

- `StoryEditor.tsx`: top-level editor composition ✓ exists
- `StoryInspector.tsx`: editing panel for selected node ✓ exists (partial — option and block creation pending)
- `NodeToolbar.tsx`: create/delete/save controls ⧗ stubbed (empty file)
- `ChoiceNode.tsx`: visual display ✓ exists (option add/remove pending)
- `TransitionBlock.tsx`: first-class transition card ✓ exists (canvas wiring pending)
- `StateChangeNode.tsx`: visual display ✓ exists (variable block wiring and add/remove pending)
- `DialogueNode.tsx`: visual display ✓ exists (richer editing surface pending)
- `OptionBlock.tsx`: option card for choice nodes ✓ exists (add/remove pending)
- `StartNode.tsx`, `EndNode.tsx`: visual bookends ✓ exist

## Current Status

**What works:**
- Canvas renders all node types with correct styling
- Transitions, options, condition blocks, and variable blocks render as first-class objects on canvas from existing data
- All existing canvas connections display correctly
- Node selection and basic property editing (id, label, displayText)
- Node deletion (with start node protection)
- ID renaming with automatic transition update
- Dragging nodes/transitions/options/condition blocks preserves positions
- Transition priority editing and deletion in inspector
- Condition block inspector editing (comparison fields, orphan editing and deletion)
- Variable block (state change) field editing in inspector
- Story runner updates in real-time; path validity preserved when story changes

**What's missing (priority order):**
1. **Node and block creation** — `NodeToolbar.tsx` is empty; no way to add any node or block type to the canvas
2. **Wiring** — no canvas edge dragging anywhere in the system; cannot create or change any connection between nodes, transitions, condition blocks, or variable blocks
3. **Option management** — no add/remove options on ChoiceNode via inspector
4. **StateChangeNode block management** — can edit existing VariableBlock fields but can't add new ones
5. **Persistence** — no save/load anywhere in the codebase

**Architecture notes:**
- Story graph is flat: `Record<string, StoryNode>`
- Transitions are first-class with position field; connection flow is `SourceNode → Transition → TargetNode`
- Options own their transitions independently; connection flow is `SourceChoiceOption → Transition → TargetNode`
- Condition blocks rendered on-demand from AST; not stored as canvas state
- All positions persist via story data updates

## Stretch Goals

These features are beyond the core scope but would enhance usability if time permits:

- **System refactor**: Two categories of technical debt have accumulated. First, type-safety: `as any` casts throughout `StoryEngine.ts`, `StoryInspector.tsx`, and `conditionBlocksGenerator.ts` stem from `Condition` and related types not being modelled as proper discriminated unions; a refactor would tighten these types in `types.ts`, remove the casts, and consolidate the duplicated validation logic between `isConditionStructurallyValid` (VirtualConsole) and `checkCondition` (StoryEngine). Second, file size and responsibility: several files — particularly `StoryInspector.tsx` and `StoryEditor.tsx` — have grown large and handle too many concerns; splitting these along single-responsibility lines would improve maintainability.
- **Unreal-style comments**: Draggable, resizable comment boxes on the canvas for documenting sections of the story graph. Comments are visual annotations only (no functional connections) and can be colored and positioned freely.
- **Choice text healing**: When a choice's option text is edited, attempt to preserve the runner's active selection by matching the updated option to the previous selection. Use a simple matching strategy (exact match → index match → fallback to nearest index) to pick the best candidate and update the selection so the story continues seamlessly across minor text edits.
- Additional node types (conditions as standalone nodes, branches, etc.)
- Visual feedback for currently-executing path in the runner
- Undo/redo for editor changes
- Story templates or quick-start presets
- Export to other formats (Twine, Ink, etc.)
