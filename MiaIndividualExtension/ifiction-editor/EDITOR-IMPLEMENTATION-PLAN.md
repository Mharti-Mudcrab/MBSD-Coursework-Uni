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

### 1. Editor Shell

Create a real editor layout around `StoryEditor`:
- left side: canvas
- right side: inspector panel
- top: toolbar for create/delete/save actions

### 2. Node Selection and Editing

Add node selection support and an inspector that can edit:
- label
- display text
- node type-specific fields
- position, if needed for debugging

### 3. Node Creation and Deletion

Add controls for:
- creating nodes of each type
- deleting the selected node
- ensuring start node rules stay valid

### 4. Choice Editing

Make `ChoiceNode` a first-class editor experience:
- show option rows clearly
- allow adding/removing options
- allow editing option text
- allow each option to own its transitions

### 5. Transition Editing

Represent transitions as editable blocks/cards with fields for:
- target node
- condition
- priority

This is the important semantic object in the editor.

### 6. Dialogue and State Change Nodes

Add editing surfaces for the other semantic node types:
- dialogue text
- state change mutations
- outgoing transitions

### 7. Persistence

Add load/save support for the story document:
- export to JSON
- import from JSON
- preserve node ids, positions, and transition data

### 8. Validation and Feedback

Add validation for:
- missing targets
- invalid conditions
- duplicate ids
- missing start node
- orphaned nodes

## Suggested Component Breakdown

- `StoryEditor.tsx`: top-level editor composition
- `StoryCanvas.tsx`: React Flow canvas area
- `StoryInspector.tsx`: editing panel for selected node or transition
- `NodeToolbar.tsx`: create/delete/save controls
- `ChoiceNode.tsx`: specialized visual editor for choices
- `TransitionBlock.tsx`: first-class transition editor card
- `NodePalette.tsx`: palette for adding node types

## Immediate Next Step

Implement the editor shell first, then wire selection to the inspector.
That gives the fastest path toward a usable editor without exposing the internal AST.
