# MBSD-Coursework-Uni
Model Based Software Development

## GitHub Copilot: Agent vs Regular Chat

### Regular Chat
Regular chat in GitHub Copilot (e.g. the chat panel in VS Code or GitHub.com) is a **conversational assistant**. It:
- Answers questions and explains concepts
- Suggests code snippets you can copy and paste manually
- Does **not** take any actions on your behalf
- Does **not** read, create, or modify files in your repository
- Does **not** run commands or tests

### Agent Mode
GitHub Copilot's **agent** (also called the Coding Agent or `@workspace` agent) is an **autonomous assistant** that can act on your behalf. It:
- Reads and explores files in your repository automatically
- Creates, edits, and deletes files to address issues or implement features
- Runs shell commands, build steps, tests, and linters
- Reports progress and opens pull requests with the changes it makes
- Makes decisions iteratively — plan → code → test → fix — without requiring you to copy/paste anything

### Key Differences

| Feature | Regular Chat | Agent |
|---|---|---|
| Answers questions | ✅ | ✅ |
| Suggests code | ✅ | ✅ |
| Reads your files automatically | ❌ | ✅ |
| Creates / edits files | ❌ | ✅ |
| Runs commands & tests | ❌ | ✅ |
| Opens pull requests | ❌ | ✅ |
| Works autonomously | ❌ | ✅ |

In short: **regular chat gives you advice**, while the **agent takes action**.
