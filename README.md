# MBSD-Coursework-Uni
Model Based Software Development

## GitHub Copilot: Agent vs Regular Chat

### Regular Chat
GitHub Copilot Chat is a conversational AI assistant integrated into your IDE or browser. You ask it questions and it responds with answers, code suggestions, or explanations — one exchange at a time.

Key characteristics:
- **Reactive**: Responds to individual questions or requests
- **No tool access**: Cannot read/write files, run commands, or take actions in your repo
- **Single-turn or short sessions**: Each response is self-contained
- **Informational**: Great for getting explanations, reviewing a snippet, or brainstorming ideas

### Agent Mode (Copilot Coding Agent)
GitHub Copilot agent mode is an autonomous AI that can carry out multi-step tasks in your codebase end-to-end, without needing you to guide every step.

Key characteristics:
- **Autonomous**: Plans and executes a sequence of actions to complete a task
- **Tool access**: Can read and write files, run shell commands, execute tests, navigate the browser, and call APIs
- **Multi-step workflows**: Iterates — writing code, running tests, checking CI, fixing failures — until the task is done
- **Pull request integration**: Can open or update a PR, push commits, and report progress as it works
- **Long-running sessions**: Maintains context across many actions within a single task

### Summary

| Feature | Regular Chat | Agent Mode |
|---|---|---|
| Takes autonomous actions | ✗ | ✓ |
| Reads/writes files | ✗ | ✓ |
| Runs commands & tests | ✗ | ✓ |
| Opens pull requests | ✗ | ✓ |
| Multi-step task completion | ✗ | ✓ |
| Good for quick Q&A | ✓ | ✗ |

Use **regular chat** when you want a quick answer or code snippet. Use **agent mode** when you want Copilot to autonomously implement a feature, fix a bug, or complete a multi-step coding task on your behalf.
