# Exam Notes Writing Plan

## Context

File to edit: `Exam Notes.md` (same directory as this file)

These are exam notes for a DSLs course exam on 2026-06-02. The student has ~2.5 hours and a ~20k character report limit. Notes are already ~5k characters. This is **not** a formal report — concise, bullet-point style is appropriate.

The individual extension is a **visual graph-based DSL editor** for interactive fiction, built with React + ReactFlow + TypeScript. The two focal topics are:
1. **Visual DSL** — the canvas is the concrete syntax; the data model is the abstract syntax
2. **Liveness** — Level 4 on Tanimoto's 6-level model

The codebase is at `/mnt/windows/Users/Mia/Desktop/MBSD-Coursework-Uni/MiaIndividualExtension/ifiction-editor/src/`.

---

## What's Already In The Notes (don't duplicate)

- Architecture overview (three-layer, EditorState vs StoryData separation)
- Node/block distinction and handle colouration
- Conditions (visual AST construction, Xtext shape, would-be-proper-AST with import support)
- Nodes and Transitions (plural transitions extension vs original 1:1, pseudocode example)
- Variables & Comparisons (key-value store, type system reflection)

---

## What Needs To Be Written

Priority order (1 = most important for the exam):

### 1. Liveness — `src/editor/VirtualConsole.tsx`

Section heading: `# Liveness`

Key points:
- Tanimoto Level 4: automatic liveness — the story re-executes as the user edits, without the user triggering it
- Mechanism: `getExecutionSignature` hashes the story; a `useEffect` watches it and triggers rebuild on change
- `replayHistory`: rebuilds a fresh `StoryRunner`, replays the user's prior choice sequence step-by-step to restore execution position
- Graceful degradation: if a replayed choice no longer exists → warn + restart from beginning; if a previously-taken transition's condition is structurally broken → warn + restart
- `collectInvalidTransitionIds`: detects structurally broken conditions (e.g. AND/OR node with null children) to decide whether to restart
- Normal choices during play just advance the runner directly — no rebuild
- This is "persistent liveness": keeps running as you edit, falls back to restart only when the edit invalidates the current path

Suggested source excerpt: `replayHistory` function signature + the core loop, and/or `getExecutionSignature`. Keep it short (~10 lines max).

### 2. Canvas Layout — `src/editor/canvasLayout.ts`

Section heading: fill in `canvasLayout does what??` in the architecture overview, and optionally a dedicated subsection

Key points:
- `buildCanvasNodes`: takes `StoryData` + `EditorState` → produces ReactFlow node objects for rendering
- `buildCanvasEdges`: takes `StoryData` + `EditorState` → produces ReactFlow edge objects
- This is the "concrete syntax rendering" step — the AST is projected onto the canvas
- Handles orphaned elements: orphaned transitions, options, variables, conditions all appear as disconnected canvas nodes
- `pushConditionBlocks`: walks the condition tree recursively, calls `conditionASTToBlocks` to render each condition node as a canvas block
- `BlockRegistry`: maps canvas block IDs → AST positions (used by inspector and wiring to know where in the AST a canvas element lives)

### 3. Wiring — `src/editor/wiring.ts`

The architecture overview already has one line. Expand it or add a subsection.

Key points:
- `applyWiring`: pure function `(connection, story, editorState, blockRegistry) → { nextStory?, nextEditorState? }`
- Handles 5 connection cases when user draws an edge on the canvas:
  1. Transition → node (sets transition target)
  2. Node → orphan transition (moves transition from orphan map into node's transitions array)
  3. Choice node → orphan option (moves option into node's choices array)
  4. Orphan condition → transition (attaches condition to transition)
  5. Orphan condition → AND/OR gate's left/right input (builds condition tree)
  6. Orphan variable → stateChange node (adds variable to node's stateChanges)
- This is how user interactions on the concrete syntax (drawing edges) modify the abstract syntax (StoryData)
- Pure function design: no side effects, easy to reason about

### 4. InspectorSelection / StoryInspector — `src/editor/inspectorSelection.ts` + `src/editor/StoryInspector.tsx`

Key points:
- `InspectorSelection`: discriminated union mapping selected canvas element → typed AST position
  - e.g. `{ type: 'stateChangeNode', node: Extract<StoryNode, {type:'stateChange'}> }` 
  - Gives the inspector type-safe access to exactly the right AST node
- `resolveInspectorSelection`: takes a canvas selection + story → returns the appropriate `InspectorSelection` variant
- This is **syntax-directed editing**: selecting an element on the canvas determines what editing controls appear in the inspector panel
- The inspector shows fields appropriate to the selected element; changes propagate back to the AST
- Reflection point: this is projectional editing — the user never edits text, only structured properties

### 5. Orphan System

Section heading: `# Orphan System`

Key points (correct version — previously had an error in notes):
- **Story nodes** (Dialogue, Choice, StateChange, End) are added directly to `story.nodes` — never orphaned
- **Blocks** (Transition, Choice Option, Variable, Comparison, AND, OR) are spawned directly into `editorState.orphanedX` maps — they start life as orphans by design
- Source: `NodeToolbar.tsx` — `addOrphanTransition`, `addOrphanOption`, `addOrphanVariable`, `addOrphanComparison`, `addOrphanLogical` all write to `editorState` orphan maps, not to `story`
- Orphans become connected via `applyWiring` (wiring.ts)
- Orphans can also be left unconnected — they persist in `editorState` invisibly to the engine
- A block can also become orphaned if its parent node is deleted

### 6. conditionBlocksGenerator — `src/model/conditionBlocksGenerator.ts`

Can be a short note under Conditions or its own subsection.

Key points:
- `conditionASTToBlocks`: Condition AST → ReactFlow canvas nodes + edges
- `buildConditionBlocks`: recursive, mirrors the Condition type structure (comparison, and, or, parenthesized)
- This is the inverse of `ConditionParser` (which goes string → AST)
- Used by `canvasLayout.ts` via `pushConditionBlocks` to render condition trees on the canvas
- Direction: AST → concrete syntax (rendering), vs ConditionParser which is concrete → AST

---

## Style Notes

- Bullet points, not paragraphs
- No formal academic tone needed
- Source code excerpts: short (under 10 lines each), only where they directly illustrate a DSL concept
- Character budget: ~5k remaining before hitting 10k soft limit; prioritise sections 1–4, skip 5–6 if tight
- The exam will ask: what topic, why, how (with source), challenges, reflection
