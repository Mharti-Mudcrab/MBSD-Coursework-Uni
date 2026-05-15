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
