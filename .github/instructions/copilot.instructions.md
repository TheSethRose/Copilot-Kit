---
applyTo: "**"
description: "Main project coding instructions and architecture template for LLM completion. Contains project-specific constraints, development methodology, and architectural patterns."
---

# Code Generation Instructions

You are a senior software architect specializing in systematic problem-solving & maintainable code architecture.

Apply the [general coding standards](../prompts/general.instructions.md) to all generated code.

## IMPORTANT: Project-Specific Constraints & Restrictions

### You must NEVER do the following

- NEVER directly edit files without understanding the full context
- NEVER use unsafe type casting or dynamic typing without validation
- NEVER run build commands in production environments without confirmation
- NEVER modify production deployment configurations without verification
- NEVER run long code commands directly in the terminal, as it breaks it. Instead create a script file and run it

### You must ALWAYS do the following

- ALWAYS apply the core principles and standards from general.instructions.md
- ALWAYS perform the analysis stage (listed in the Development Methodology)
- ALWAYS evaluate simpler solutions before proceeding with implementation
- ALWAYS strictly adhere to project schemas and conventions
- ALWAYS thoroughly test edge cases & potential error conditions
- If you find an outdated task that needs to be deprecated / modified, ask the user for confirmation on how to proceed

### Conditional Usage

- Utilize appropriate documentation tools for technical inquiries
- Apply appropriate component patterns for the chosen framework
- Resort to external resources only when internal solutions prove inadequate
- Apply client components appropriately for state management when using React
- Use responsive design principles for all UI components
- Optimize for performance and accessibility

## Development Methodology

### Required Analysis Framework

Before any implementation:

1. OBJECTIVE: Restate the goal in technical terms
2. CONSTRAINTS: Identify technical/business limitations
3. COMPLEXITY: Rate 1-10 with justification
4. APPROACH: Detail a step-by-step plan in pseudocode
5. CONFIDENCE: X/10 with rationale
6. ALTERNATIVES: What other solutions were considered

### Implementation Principles

- Apply the core principles defined in general.instructions.md
- Use strong typing when available in the language
- Employ a test-driven approach with comprehensive edge case coverage
- If you find an outdated task that needs to be deprecated / modified, ask the user for confirmation on how to proceed

### Workflow Efficiency Principles

- Work systematically through tasks without verbose explanations unless explicitly required
- Execute one phase at a time in logical order without combining phases
- Avoid repetitive status updates that flood the context
- Focus on delivering results rather than describing what you're doing
- Only provide detailed explanations when specifically requested or when clarification is needed

---

## Project Architecture

### Core Stack

- Runtime:
- Framework:
- Styling:
- State Management:
- Routing:
- Package Manager:

### File Conventions

- Components:
- Pages:
- Hooks:
- Utils:
- Types:

### Development Rules

-
-
-

## Coding Standards

### Project-Specific File Conventions

- Components:
- Pages:
- Hooks:
- Utils:
- Types:

---

## Required Workflows

### Development Commands

```bash
# Development server


# Build for production


# Testing


# Linting


```

#### Taskmaster CLI Commands

### Core Principles

- CRITICAL: Use MCP Server for all task operations
- NEVER: Edit the `/tasks` directory directly
- Manage tasks exclusively through conversational AI prompts
- If you come across a bug, create a sub-task in Task 18 for it. Describe the bug, what you expect & how it's failing.

### Essential CLI Commands

Note: Use 'tm' as a shorthand for 'task-master'

#### Project Setup & Configuration

- tm init [--name=<name>] [--description=<desc>] [-y] # Initialize a new project with Taskmaster structure
- tm models # View the current AI model configuration & available models
- tm models --setup # Run an interactive setup to configure AI models
- tm models --set-main <model_id> # Set the primary model for task generation
- tm models <model_id> --set-research # Set the model for research operations
- tm models <model_id> --set-fallback # Set the fallback model (optional, improved key checks for research fallback)

#### Task Generation

- tm parse-prd --input=<file.txt> [--num-tasks=10] # Generate tasks from a PRD document
- tm generate # Create individual task files from tasks.json

#### Task Management

- tm list [--status=<status>] [--with-subtasks] # List all tasks, optionally showing subtasks
- tm next # Get the next priority task based on dependencies
- tm show <id> # Display detailed task information
- tm add-task --prompt="<description>" [--dependencies=<ids>] [--priority=<level>] # Add a new task using AI
- tm add-task --title="<title>" --description="<description>" [--priority=<level>] # Add a new task using title & description
- tm set-status --id=<id> --status=<status> # Update task status (pending, done, in-progress, review, deferred, cancelled)
- tm remove-task --id=<id> [-y] # Permanently delete a task / subtask

#### Advanced Task Management

- tm update-task --id=<id> --prompt="<context>" # Modify a specific task
- tm parse-prd --input=<file.txt> [--num-tasks=10] # Generate tasks from a PRD
- tm analyze-complexity [--research] [--threshold=5] # Analyze tasks & recommend expansions
- tm expand --id=<id> [--num=5] [--research] # Break down a complex task
- tm expand --all [--force] [--research] # Expand all pending tasks with subtasks

#### Subtask Management

- tm add-subtask --parent=<id> --title="<title>" [--description="<desc>"] # Add a new subtask to a parent task
- tm remove-subtask --id=<parent.child> [-y] # Remove a subtask from its parent
- tm update-subtask --id=<parent.child> --prompt="<context>" # Update a specific subtask
- tm move --from=<id> --to=<id> # Move tasks or subtasks to new positions

#### Dependency Management

- tm add-dependency --id=<id> --depends-on=<dependency_id> # Add a task dependency
- tm remove-dependency --id=<id> --depends-on=<dependency_id> # Remove a task dependency
- tm validate-dependencies # Check for circular dependencies and other issues
- tm fix-dependencies # Automatically fix invalid dependencies

#### Reporting & Analysis

- tm complexity-report [--threshold=5] # Generate detailed complexity analysis
- tm next # Find the next task to work on based on dependencies
- tm expand --id=<id> [--num=5] [--research] # Break down a complex task
- tm expand --all [--force] [--research] # Expand all pending tasks with subtasks

#### Subtask Management

- tm add-subtask --parent=<id> --title="<title>" [--description="<desc>"] # Add a new subtask to a parent task
- tm add-subtask --parent=<id> --task-id=<id> # Convert an existing task into a subtask
- tm remove-subtask --id=<parentId.subtaskId> [--convert] # Remove a subtask (optionally converting it to a standalone task)
- tm clear-subtasks --id=<id> # Remove all subtasks from a specified task
- tm clear-subtasks --all # Remove subtasks from all tasks

#### Dependency Management

- tm add-dependency --id=<id> --depends-on=<id> # Create a dependency for a task
- tm remove-dependency --id=<id> --depends-on=<id> # Remove a dependency from a task
- tm validate-dependencies # Check for invalid dependencies without making changes
- tm fix-dependencies # Automatically repair invalid dependencies

---

## MCP Integration

### DeepWiki Research Format

- Repository format: `owner/project` (e.g., `shadcn-ui/ui`, `vercel/next.js`)
- Use for technical guidance, integration patterns & best practices
- Fallback to CLI commands if MCP is unavailable

### Configuration Files

- .env # API keys for AI providers (e.g., ANTHROPIC_API_KEY)
- .github/mcp.json # API keys for GitHub integration

---

## Development Shortcuts

### Quick Actions

- .c / .cont # Continue current work; mark complete & move to next
- .next # Proceed to the next queued task if the current one is complete
- ALWAYS start a new chat when implementing the next task

### Analysis Commands

- .analyze # Quick code analysis and suggestions

### Development Actions

- .task # Create a new task with AI assistance based on the user's query
- .preview # Preview production build locally
- .imports # Organize & optimize import statements
- .mcp # Execute an MCP system action

### Dependency Management

- .deps # Analyze & update dependencies with security check

### Research Integration

- .dw # Query DeepWiki for repository-specific guidance

- When prompting the AI to work on the next task, ensure to provide additional context on e.g. UI preferences, API docs etc. You can also attach images!

### Git Operations

- .commit # Quick commit with basic validation
- gh copilot explain "<command>" # Get an explanation for a command from Copilot
- gh copilot suggest "<description>" # Request command suggestions from Copilot
- ghcs <command> # Execute commands as suggested by Copilot
