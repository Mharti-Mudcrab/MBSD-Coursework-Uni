# Editor Presentation Guidelines

The editor should present the story in a user-friendly, Blueprint-like way, while the internal DSL remains hidden.

## Core Principles

- The user should be blissfully unaware of the internal AST.
- The canvas should feel like a friendly visual editor, not a parser or metamodel browser.
- Transitions are first-class complex objects and should have their own visual blocks.
- Transitions should not be reduced to ordinary Blueprint-style wires.
- The internal model can remain richer and more semantic than the presentation layer.
- The presentation should optimize for editing and understanding, not for exposing structure directly.

## Implication For Implementation

- Keep the story model as the source of truth.
- Derive the visual editor from that model.
- Give nodes and transitions distinct UI treatments where their meaning differs.
- Use the canvas to support editing, not to reveal implementation details.

## Current Implementation

### What's Already Visual

- **Nodes**: Five node types rendered as distinct visual blocks
  - Start/End: Terminal bookends
  - Dialogue: Tan dashed border, shows text preview
  - Choice: Tan dashed, shows option count
  - State Change: Green border, for mutations
  - Each node is selectable and draggable on canvas

- **Transitions**: Rendered as first-class `TransitionBlock` cards
  - Show target node ID and priority (if set)
  - Draggable on canvas; position persists
  - **Flow: Node → Transition → Target Node**
  - Users drag from node handles to transition blocks, then from transition blocks to target nodes
  - This makes the transition object explicit and wiring intentional

- **Options**: Rendered as `OptionBlock` cards within choice nodes
  - Show option text and transition count
  - Each option can own multiple transitions
  - **Flow from options: Option → Transition → Target Node**
  - Same wiring pattern as nodes, but originating from option blocks

- **Inspector**: Side panel for editing selected node
  - Edit label, id, displayText
  - Delete button (protected for start node)
  - Will extend for type-specific fields

- **Real-time Runner**: Far-right console
  - Shows story output as you edit
  - Intelligently preserves execution path unless it becomes invalid
  - No AST or parser detail exposed

### What's Next

1. **Node Creation UI**: Toolbar or context menu to add nodes (currently stubbed)
2. **Choice/Option Inspector**: Rows to add/remove options and edit their text
3. **Transition Inspector**: Editing target, priority, and conditions
4. **State Change Inspector**: Mutation editor (variable, operator, value)
5. **Condition Integration**: Hook condition parser into transition UI
6. **Persistence**: Save/load documents without exposing JSON structure

### Design Decisions

- **Transition-centric wiring**: The core authoring flow is **Node A → Transition → Node B**
  - Users drag from source node handles to transition block handles
  - Then drag from transition block handles to target node handles
  - This makes transitions explicit, first-class objects that users actively wire together
  - Much more intuitive and gives users full control over the flow
- **Positions everywhere**: Canvas layout is persisted at every level (nodes, transitions, options) so users can craft a readable graph layout
- **No AST in inspector**: Inspector shows only user-meaningful fields (label, text, options); internal structure stays internal
- **Start node protection**: Delete button is disabled; renaming updates all references automatically so user can't orphan the story
