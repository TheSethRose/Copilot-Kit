# Joyride Integration for GitHub Copilot Instructions Template

This repository includes a powerful Joyride script that allows you to easily install and manage GitHub Copilot instructions, prompts, and chatmodes directly from VS Code.

## What is Joyride?

[Joyride](https://github.com/BetterThanTomorrow/joyride) is a VS Code extension that lets you script VS Code using ClojureScript. It provides a REPL-driven development environment for automating and customizing your VS Code experience.

## Installation

### 1. Install Joyride Extension

First, install the Joyride extension from the VS Code marketplace:

1. Open VS Code
2. Go to Extensions (Ctrl+Shift+X / Cmd+Shift+X)
3. Search for "Joyride"
4. Install the extension by Better Than Tomorrow

### 2. Install the Copilot Template Script

1. Open the script file: `scripts/joyride-copilot-template.cljs`
2. Select all the code (Ctrl+A / Cmd+A) and copy it (Ctrl+C / Cmd+C)
3. Open VS Code Command Palette (Ctrl+Shift+P / Cmd+Shift+P)
4. Run: `Joyride: Create User Script...`
5. Name it: `copilot-template`
6. In the editor that opens, select all existing content and paste the copied script
7. Save the file (Ctrl+S / Cmd+S)

## Usage

### Running the Script

1. Open Command Palette (Ctrl+Shift+P / Cmd+Shift+P)
2. Run: `Joyride: Run User Script...`
3. Select: `copilot_template.cljs`

### Available Features

The script provides several bulk installation options and browsing capabilities:

#### Bulk Installation Options

1. **Install Chatmodes** - Install all available chatmodes at once
2. **Install Instructions (Core)** - Install all core instruction files
3. **Install Language Instructions** - Choose a specific language and install all its instructions
4. **Install Prompts** - Install all available prompts

#### Installation Modes

For each bulk installation, you can choose:
- **Global Installation**: Available across all VS Code workspaces
- **Workspace Installation**: Only available in the current workspace

#### Browse Individual Items

You can also browse and install individual items:
- **Browse Instructions** - View and install specific instruction files
- **Browse Prompts** - View and install specific prompts
- **Browse Chatmodes** - View and install specific chatmodes

### Language-Specific Instructions

The script includes support for the following languages with dedicated instruction sets:

- **AI/GenAI**: GenAIScript development
- **Angular**: Angular framework development
- **C++**: CMake and vcpkg usage
- **C#**: ASP.NET, Blazor, MAUI, and general C# development
- **Go**: Go language development
- **Infrastructure**: Bicep and Terraform for Azure
- **Python**: Python coding standards
- **TypeScript**: Azure Functions, Next.js, and React development

### Progress Tracking

The script provides real-time progress feedback during bulk installations, showing:
- Current item being installed
- Progress counter (e.g., "Installing 3/15...")
- Installation location (global vs workspace)

### Installation Locations

- **Global**: `~/.vscode/extensions/ms-vscode.copilot-chat-<version>/instructions/`
- **Workspace**: `<workspace>/.vscode/copilot-instructions/`

## File Structure

The script understands the repository structure and can install:

### Core Instructions
- General coding standards
- Copilot configuration
- Debug practices
- Review standards
- PR documentation
- Localization guidelines
- Performance optimization
- Security and OWASP guidelines

### Language-Specific Instructions
- Organized by language in `languages/` subfolders
- Each language has dedicated instruction files
- Covers frameworks, tools, and best practices

### Prompts
- Action-oriented prompts for common development tasks
- Database operations, testing, deployment, and more
- Organized by functionality

### Chatmodes
- Specialized AI personas for different development scenarios
- Debug mode, DBA mode, planning mode, and more
- Ready-to-use chat configurations

## Benefits

1. **Bulk Installation**: Install entire categories of instructions at once
2. **Language Focus**: Install only the instructions relevant to your current project
3. **Flexible Scope**: Choose between global and workspace installations
4. **Progress Feedback**: See real-time installation progress
5. **Easy Browsing**: Browse and preview individual items before installation
6. **Automatic Updates**: Script always pulls the latest content from the repository

## Troubleshooting

### Common Issues

1. **Script not found**: Make sure you've properly installed the script as a User Script in Joyride
2. **Installation fails**: Check your internet connection and VS Code permissions
3. **Files not showing**: Restart VS Code after installation to refresh the Copilot extension

### Getting Help

If you encounter issues:
1. Check the Joyride extension documentation
2. Verify your internet connection
3. Ensure you have the latest version of the Copilot Chat extension
4. Try running the script again (it handles existing files gracefully)

## Contributing

To add new instructions, prompts, or chatmodes:
1. Add your files to the appropriate directory structure
2. Update the `repository-index` in the Joyride script
3. Test the script to ensure new items are accessible
4. Submit a pull request

This integration makes it incredibly easy to maintain and distribute your GitHub Copilot customizations across different projects and team members.
