# What makes this a DSL?
- A language: authored artifact (story model) separate from executor (engine) — describe, then run
- Domain-specific: primitives are domain concepts, not computational; cannot express anything outside interactive fiction
- Not just an application: an application does things; a language lets you describe things that get executed


# Architecture
- 3 layers: Data (types) / Model (engine, runner, utils) / Editor (canvas, inspector, toolbar, console)
- Nodes → `story.nodes`; blocks owned by nodes; max nesting: Condition → Transition → ChoiceOption → ChoiceNode
- Handles colour-coded: optional vs integral (ChoiceOptions = integral, main flow colour)
- `StoryNode`: discriminated union, types.ts:30-35; `Condition`: recursive type, types.ts:57-60
- `EditorState`: canvas positions + orphans, invisible to engine — types.ts:77-83


# Nodes and Transitions
- Original DSL: 1:1 transition per non-Choice node; extension: `transitions: Transition[]` on all nodes
- Any node can branch; priority 0 = default fallback
(include pseudocode example)

# Conditions
- User builds tree directly — same shape engine evaluates
- Incomplete trees necessary: user must build incrementally (text DSL always complete at runtime)
- AND/OR precedence absent — deliberate; non-programmers unfamiliar with it; complicates future "compile to external DSL"
- Delete on gate: gate only (orphan children) vs entire subtree — both implemented
- `isConditionStructurallyValid`: completeness — intraversible + marked red if failed
- `checkCondition`: runtime evaluator, structurally valid trees only → StoryEngine.ts:64-94


# Canvas-AST Bridge
→ canvasLayout.ts, wiring.ts, inspectorSelection.ts, conditionBlocksGenerator.ts; StoryEditor.tsx (glue)

- `buildCanvasNodes`: Pass 1 (story) + Pass 2 (orphans); `buildCanvasEdges` separate
- Pass 1: node → transitions → conditions; choice → options → transitions → conditions (82:119); stateChange → variables
- `buildConditionBlocks`: recursive tree walk; IDs `condition-{transId}-root-left-right` — deterministic = position persists
- `BuildNodesResult`: nodes, edges, registry (block ID → model object), rootBlockId
- `blockToCondition` → feeds registry; `updateConditionInTree`: immutable update by object ref
- `remapBlockPositions/Subtree`: rename `canvasPositions` keys after structural edits
- `omitKey`: immutable record delete; `applyConditionToParent`: routes condition to correct parent (cases 3+4)
- Case 1: set `targetNodeId` — orphan stays orphaned, gains target
- Case 2/2b: adopt orphaned transition/option → remove from orphanedX, remap positions
- Case 3/4: adopt orphaned condition → onto transition / into AND/OR slot via `updateConditionInTree`
- Case 5: adopt orphaned variable → stateChange node

## Orphans
- Spawn as orphans by design; adopted via wiring; also orphaned on parent delete
- Live in `EditorState` — keeps `StoryData` clean; Spawning: NodeToolbar.tsx:81; Adoption: wiring.ts:123

## Technical Debt
- Deterministic IDs shift on structural changes → remap passes; ID string parsing; 14-variant union + mirrored inspector
- Root cause: no unified write abstraction over split state — orphaned/owned leaks into selection type
- Fix: stable UUIDs + generic `update(blockId, changes)`; cost: touches core types, serialization, migration


# Liveness
→ VirtualConsole.tsx — Level 4 (automatic)

- Story edits → rebuild runner → replay history; choices advance runner directly
- Restart: `choiceHistoryRef` emptied when replayHistory fails (choice gone) OR collectInvalidTransitionIds finds a hit — next rebuild replays nothing → starts from beginning
- `getExecutionSignature`: alphabetically sorted JSON string — cheap deep-equality; fragile (full stringify per render)
- Signature change OR Restart button → useEffect → check invalid taken IDs → rebuild → replay
- `takenTransitionIds`: tracks taken transitions; `collectInvalidTransitionIds` checks them on rebuild — only meaningful now traversal is blocked
- `describeTransition`: human-readable label for restart notice
- replayHistory: :87; useEffect: :127; collectInvalidTransitionIds: :33; getAvailableChoices: :73


# Internal DSL
→ `../Internal DSL/src/LanguageModel/StoryBuilder.java`

- Fluent builder, abstract `StoryBuilder`, user subclasses + implements `build()`
- `ChoiceOption()` attaches to most recently added Choice (implicit context)
- Conditions: string → `Condition.parseCondition()` at resolve time
- `resolveTransitionReferences()`: fixes forward refs post-`build()`; single transition per non-Choice node


# External DSL
→ `../External DSL/.../Ifictiondsl.xtext`, `IfictiondslGenerator.xtend`

- Xtext; forward refs via Xtext — no manual resolve
- Condition precedence: grammar layering `OrCondition → AndCondition → Primary(Parentheses | Comparison)`
- Generator outputs `StoryBuilder` subclass — compiles to internal DSL; language model shared
- `generateCondition`: serialises Xtext Condition back to string; `Operator` = datatype rule not enum


# Extension Differences
- **No parse step** — canvas is concrete syntax; edits directly transform an instance of the metamodel
- Closer to an interpreted language: no compile-time; liveness surfaces errors immediately
- Multi-transition on all nodes; serialization free (JSON); no forward ref resolution needed
- Orphan blocks + incomplete states unavoidable in visual editing


# Low Priority
- StoryBuilder.ts: TypeScript mirror of Java internal DSL
- Variables: `Record<string, number>` — strings/booleans out of scope
- ID renaming: renameNodeInMap App.tsx:28 — cascades `targetNodeId` + `startNodeId`
- Click → set `selectedNodeId` → re-render → `resolveInspectorSelection` → inspector renders panel
- InspectorSelection carries typed context to survive re-render (deselect-on-edit bug)
