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

### 3. Node Creation and Deletion ⧗ REMAINING (Toolbar)

The editor shell is effectively complete except for the node toolbar UI. Deletion is implemented; creation is the remaining shell task:
- `NodeToolbar.tsx` currently exists as a stub and needs interactive controls
- Provide toolbar buttons or a context menu to add nodes of each type
- Ensure start-node rules remain enforced when creating or promoting nodes

### 4. Choice, Option, and Transition Editing ⧗ PARTIAL / TODO

These editing surfaces are partially implemented in the canvas but need inspector + UX work:
- `ChoiceNode`: visual and canvas rendering exist, but inspector rows for adding/removing/editing options are missing
- `OptionBlock`: options render and persist positions, but option-level transition editing in the inspector is incomplete
- `TransitionBlock`: blocks are draggable and positioned, but the inspector needs controls for setting the target node, priority, and conditions; also support interactive wiring via transition handles (Node → Transition → Target Node)

### 4.1. Condition Editing ⧗ IMMEDIATE PRIORITY

Transitions support optional conditions that control flow. Building condition editing as blueprint-style canvas nodes:
- **Storage**: Conditions are stored as nested `Condition` AST objects on transitions (`condition?: Condition`); persisted directly to JSON as structured data
- **Flow**: Transition block has a condition handle → wires to condition blocks on canvas → block topology reconstructs back to AST on edit
- **Condition block types**:
  - **Comparison blocks**: one per operator (>, <, ==, !=, >=, <=); each takes variable name + value inputs; display as `varName [op] value`
  - **Boolean gates**: AND/OR blocks that take two condition inputs and output one condition; display as `[left] AND/OR [right]`
  - These blocks compose on the canvas to build condition trees
- **Conversion**: Condition AST ↔ visual block trees; block topology reconstructs AST; AST persists to JSON without string conversion
- **Parentheses**: Implicit in block wiring topology; AST structure preserves nesting without explicit parentheses nodes
- **Architecture**: Condition blocks don't persist in story data; they're rendered on-demand from AST and updated atomically when edited

### 5. State Change & Dialogue Editing ⧗ TODO

Inspector editing for the remaining node-specific fields is not implemented yet:
- **State Change nodes**: need UI for editing mutations (variable, operator, value)
- **Dialogue nodes**: need a richer editing surface for dialogue text and metadata
- Both node types should expose their outgoing transitions in the inspector for easier editing

### 6. Persistence

Add load/save support for the story document:
- export to JSON
- import from JSON
- preserve node ids, positions, and transition data

### 7. Validation and Feedback ⊘ OUT OF SCOPE

Validation (missing targets, orphans, cycles, etc.) is explicitly out of scope for this iteration.

## Suggested Component Breakdown

- `StoryEditor.tsx`: top-level editor composition ✓ exists
- `StoryInspector.tsx`: editing panel for selected node ✓ exists (partial)
- `NodeToolbar.tsx`: create/delete/save controls ⧗ stubbed
- `ChoiceNode.tsx`: visual display ✓ exists (editing UI pending)
- `TransitionBlock.tsx`: first-class transition card ✓ exists (editing UI pending)
- `StateChangeNode.tsx`: visual display ✓ exists (editing UI pending)
- `DialogueNode.tsx`: visual display ✓ exists (editing UI pending)
- `OptionBlock.tsx`: option card for choice nodes ✓ exists (editing UI pending)
- `StartNode.tsx`, `EndNode.tsx`: visual bookends ✓ exist

## Current Status

**What works now:**
- Canvas renders all node types with correct styling
- Transitions and options render as first-class blocks on canvas
- Node selection and basic property editing (id, label, displayText)
- Node deletion (with start node protection)
- ID renaming with automatic transition update
- Dragging nodes/transitions/options preserves positions
- Story runner updates in real-time; path validity is preserved when story changes

**What's next:**
1. Implement `NodeToolbar.tsx` and wire it to creation flows (this completes the editor shell)
2. Extend the inspector for `ChoiceNode` / `OptionBlock` (add/remove/edit options)
3. Add transition inspector controls (target, priority, condition) and improve wiring UX
4. Implement inspector editing for `StateChangeNode` and enhanced dialogue editing
5. Add save/load (export/import JSON)


**Architecture notes:**
- Story graph is flat: `Record<string, StoryNode>`
- Edges are interactive: users drag from transition block handles to wire targets
- Transitions are first-class with position field
- Options own their transitions independently
- All positions persist via story data updates

## Stretch Goals

These features are beyond the core scope but would enhance usability if time permits:

- **Unreal-style comments**: Draggable, resizable comment boxes on the canvas for documenting sections of the story graph. Comments are visual annotations only (no functional connections) and can be colored and positioned freely. Users can right-click to add comments, drag to reposition, and resize to fit content.
- **Choice text healing**: When a choice's option text is edited, attempt to preserve the runner's active selection by matching the updated option to the previous selection. Use a simple matching strategy (exact match → index match → fallback to nearest index) or a small similarity heuristic to pick the best candidate and update the selection so the story continues seamlessly across minor text edits.
- Additional node types (conditions as standalone nodes, branches, etc.)
- Visual feedback for currently-executing path in the runner
- Undo/redo for editor changes
- Story templates or quick-start presets
- Export to other formats (Twine, Ink, etc.)
