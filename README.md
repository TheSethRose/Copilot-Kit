# GitHub Copilot Instructions Template

A comprehensive collection of language-agnostic templates and structured prompts for GitHub Copilot that can be customized for any programming language and project type. This repository provides a systematic approach to AI-assisted development with standardized workflows, coding guidelines, and specialized prompts.

## Overview

This template system enables consistent, high-quality code generation through:

- **Structured Instructions**: Comprehensive coding standards and best practices
- **Specialized Prompts**: Task-specific prompts for common development workflows
- **Workflow Automation**: Standardized processes for commits, reviews, and documentation
- **Quality Assurance**: Built-in guidelines for testing, security, and performance

## Repository Structure

```
.github/
├── instructions/           # Core instruction templates
│   ├── commit.instructions.md     # Git commit message standards
│   ├── copilot.instructions.md    # Code generation guidelines
│   ├── debug.instructions.md      # Error handling and debugging
│   ├── pr.instructions.md         # Pull request documentation
│   └── review.instructions.md     # Code review standards
└── prompts/               # Specialized prompt templates
    ├── general.instructions.md    # Core coding standards
    ├── markdown.instructions.md   # Markdown writing guidelines
    ├── typescript-react.instructions.md  # Framework-specific rules
    ├── python.instructions.md     # Language-specific standards
    ├── clean.prompt.md            # Code cleanup workflows
    ├── db.prompt.md               # Database operations
    ├── debug.prompt.md            # Debugging assistance
    ├── deploy.prompt.md           # Deployment procedures
    ├── doc.prompt.md              # Documentation generation
    ├── explain.prompt.md          # Code explanation
    ├── git.prompt.md              # Git operations
    ├── migrate.prompt.md          # Migration assistance
    ├── perf.prompt.md             # Performance optimization
    ├── plan.prompt.md             # Project planning
    ├── review.prompt.md           # Code review assistance
    ├── scaffold.prompt.md         # Project scaffolding
    ├── schema.prompt.md           # Schema design
    ├── security.prompt.md         # Security analysis
    ├── seed.prompt.md             # Data seeding
    ├── setup.prompt.md            # Project setup
    └── think.prompt.md            # Problem analysis
```

## Core Instructions

### `.github/instructions/`

These files establish fundamental development standards and workflows:

#### `commit.instructions.md`
- **Purpose**: Standardizes Git commit message formatting using Conventional Commits
- **Features**: 
  - Structured commit types (feat, fix, docs, etc.)
  - Scope guidelines for project organization
  - Body and footer formatting standards
  - Quality control rules and examples
- **Usage**: Referenced automatically when generating commit messages

#### `copilot.instructions.md` 
- **Purpose**: Core code generation guidelines and project constraints
- **Features**:
  - Development methodology framework
  - Project-specific restrictions and requirements
  - Implementation principles (SOLID, DRY, KISS, YAGNI)
  - Architecture patterns and file conventions
- **Usage**: Applied to all code generation tasks

#### `debug.instructions.md`
- **Purpose**: Systematic error handling and debugging procedures
- **Features**:
  - Project-specific error categories
  - Debugging scenarios for different issue types
  - Tool recommendations and logging standards
  - Structured error reporting guidelines
- **Usage**: Activated when troubleshooting issues

#### `pr.instructions.md`
- **Purpose**: Comprehensive pull request documentation standards
- **Features**:
  - PR title and description templates
  - Testing and performance impact documentation
  - Accessibility and SEO considerations
  - Task management integration
- **Usage**: Applied when creating pull request descriptions

#### `review.instructions.md`
- **Purpose**: Thorough code review standards and checklists
- **Features**:
  - SOLID principles compliance checks
  - Security and performance review criteria
  - Testing standards and coverage requirements
  - Architecture-specific review guidelines
- **Usage**: Referenced during code review processes

## Specialized Prompts

### `.github/prompts/`

Task-specific prompts for common development workflows:

#### Core Standards
- **`general.instructions.md`**: Universal coding standards and principles
- **`markdown.instructions.md`**: Documentation writing guidelines
- **`typescript-react.instructions.md`**: React TypeScript specific patterns
- **`python.instructions.md`**: Python development standards

#### Development Workflows
- **`setup.prompt.md`**: Project initialization and configuration
- **`scaffold.prompt.md`**: Code structure and boilerplate generation  
- **`clean.prompt.md`**: Code cleanup and refactoring
- **`plan.prompt.md`**: Project planning and architecture design

#### Database & Data
- **`db.prompt.md`**: Database operations and queries
- **`schema.prompt.md`**: Database schema design and validation
- **`migrate.prompt.md`**: Database migration assistance
- **`seed.prompt.md`**: Test data generation and seeding

#### Quality Assurance
- **`debug.prompt.md`**: Debugging assistance and error resolution
- **`review.prompt.md`**: Code review and quality analysis
- **`security.prompt.md`**: Security analysis and vulnerability assessment
- **`perf.prompt.md`**: Performance optimization and profiling

#### Documentation & Communication
- **`doc.prompt.md`**: Technical documentation generation
- **`explain.prompt.md`**: Code explanation and analysis
- **`think.prompt.md`**: Problem analysis and solution planning

#### Operations
- **`git.prompt.md`**: Git operations and version control
- **`deploy.prompt.md`**: Deployment procedures and automation

## Installation

### Manual Installation

Clone the repository and copy the `.github` folder to your project:

```bash
# Clone the repository
git clone https://github.com/TheSethRose/GitHub-Copilot-Instructions-Template.git

# Copy to your project
cp -r GitHub-Copilot-Instructions-Template/.github your-project/

# Optional: Copy prompts to VS Code User Data folder
cp GitHub-Copilot-Instructions-Template/.github/prompts/* ~/Library/Application\ Support/Code\ -\ Insiders/User/prompts/
```

### Using as a Template

You can also use this repository as a GitHub template:

1. Click "Use this template" on the GitHub repository page
2. Create a new repository from the template
3. Clone your new repository
4. Copy the `.github` folder to your existing projects as needed

## Quick Start

1. **Choose Your Language**: Copy relevant instruction files for your tech stack
2. **Customize Settings**: Update project-specific configurations in each file
3. **Configure VS Code**: Add prompts to your VS Code settings or workspace
4. **Start Coding**: Reference instructions through GitHub Copilot Chat

## Usage Examples

### Setting Up Instructions
```bash
# Copy core instructions to your project
cp .github/instructions/* your-project/.github/instructions/

# Copy relevant prompts
cp .github/prompts/general.instructions.md your-project/.github/prompts/
cp .github/prompts/typescript-react.instructions.md your-project/.github/prompts/
```

### VS Code Integration
Add to your VS Code settings or workspace configuration:
```json
{
  "github.copilot.chat.promptFiles": [
    ".github/prompts/general.instructions.md",
    ".github/prompts/typescript-react.instructions.md"
  ]
}
```

### Using Specialized Prompts
```bash
# In GitHub Copilot Chat
/doc Generate API documentation for the user service
/review Analyze this component for performance issues
/debug Help troubleshoot this database connection error
```

## Customization Guide

### Adapting for Your Project

1. **Update Project Context**: Modify technology stack references in instruction files
2. **Customize Scopes**: Update commit scope guidelines in `commit.instructions.md`
3. **Add Project Rules**: Include project-specific constraints in `copilot.instructions.md`
4. **Configure Workflows**: Adapt prompt templates for your development process

### Language-Specific Adaptations

- **Frontend Projects**: Focus on React, Vue, or Angular specific instructions
- **Backend Projects**: Emphasize API design, database, and security patterns
- **Full-Stack Projects**: Combine frontend and backend instruction sets
- **Data Projects**: Prioritize data processing, analysis, and visualization prompts

## Best Practices

### Implementation Guidelines

- **Start Small**: Begin with core instructions and add specialized prompts gradually
- **Iterate Often**: Regularly update instructions based on project evolution
- **Team Alignment**: Ensure all team members understand and follow the standards
- **Documentation**: Keep instructions current with your project's development

### Quality Assurance

- **Regular Reviews**: Periodically review and update instruction effectiveness
- **Feedback Loop**: Collect team feedback on instruction clarity and usefulness
- **Consistency**: Maintain consistent formatting and structure across all files
- **Version Control**: Track changes to instructions alongside code changes

## Contributing

1. Fork this repository
2. Create a feature branch for your changes
3. Update or add instruction/prompt files
4. Test with your development workflows
5. Submit a pull request with detailed examples

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Support

- **Issues**: Report bugs or request features via GitHub Issues
- **Discussions**: Share usage examples and best practices in GitHub Discussions
- **Documentation**: Refer to individual instruction files for detailed usage
