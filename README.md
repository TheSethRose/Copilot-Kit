# GitHub Copilot Instructions Template

A comprehensive collection of language-agnostic templates and structured prompts for GitHub Copilot that can be customized for any programming language and project type. This repository provides a systematic approach to AI-assisted development with standardized workflows, coding guidelines, and specialized prompts.

## Overview

This template system enables consistent, high-quality code generation through:

- **Structured Instructions**: Comprehensive coding standards and best practices
- **Specialized Prompts**: Task-specific prompts for common development workflows
- **Chat Modes**: AI personas for specific development tasks
- **Workflow Automation**: Standardized processes for commits, reviews, and documentation
- **Quality Assurance**: Built-in guidelines for testing, security, and performance

## Repository Structure

```
.github/
├── chatmodes/
│   ├── debug.chatmode.md                          # Debugging assistance mode
│   ├── gpt-4.1-coding-agent.chatmode.md           # 4.1 beast mode mode
│   ├── planner.chatmode.md                        # planning mode instructions mode
│   ├── postgresql-dba.chatmode.md                 # postgresql database administrator mode
│   ├── prd.chatmode.md                            # Product requirements mode
│   ├── process-tracking.chatmode.md               # process tracking mode mode
│   ├── prompt-engineer.chatmode.md                # prompt engineer mode
│   └── refine-issue.chatmode.md                   # refine requirement or issue chat mode mode
├── instructions/
│   ├── copilot.instructions.md                    # Code generation guidelines
│   ├── debug.instructions.md                      # Error handling and debugging
│   ├── general-coding-standards.instructions.md   # standards specific standards
│   ├── localization.instructions.md               # localization specific standards
│   ├── markdown-standards.instructions.md         # standards specific standards
│   ├── performance-optimization.instructions.md   # Performance guidelines
│   ├── pr.instructions.md                         # Pull request documentation
│   ├── review.instructions.md                     # Code review standards
│   └── security-and-owasp.instructions.md         # Security best practices
└── prompts/
    ├── analyze-requirements.prompt.md            
    ├── aspnet-minimal-api-openapi.prompt.md      
    ├── audit-security.prompt.md                  
    ├── az-cost-optimize.prompt.md                
    ├── build-dockerfile.prompt.md                
    ├── clean.prompt.md                            # Code cleanup workflows
    ├── comment-code-generate-a-tutorial.prompt.md
    ├── commit.prompt.md                          
    ├── csharp-async.prompt.md                    
    ├── csharp-docs.prompt.md                     
    ├── csharp-mstest.prompt.md                   
    ├── csharp-nunit.prompt.md                    
    ├── csharp-xunit.prompt.md                    
    ├── debug-react.prompt.md                     
    ├── deploy-react-app.prompt.md                
    ├── diagnose-database.prompt.md               
    ├── document-project.prompt.md                
    ├── ef-core.prompt.md                         
    ├── explain.prompt.md                         
    ├── generate-code.prompt.md                   
    ├── generate-issues.prompt.md                 
    ├── javascript-typescript-jest.prompt.md      
    ├── migrate-database.prompt.md                
    ├── my-issues.prompt.md                       
    ├── my-pull-requests.prompt.md                
    ├── next-intl-add-language.prompt.md          
    ├── optimize-performance.prompt.md            
    ├── review.prompt.md                           # Code review assistance
    ├── seed-database.prompt.md                   
    ├── setup-react-portfolio.prompt.md           
    ├── think.prompt.md                            # Problem analysis
    └── validate-schema.prompt.md                 
```

## 📋 Instructions

The `.github/instructions/` directory contains core instruction templates that establish fundamental development standards and workflows. These files guide GitHub Copilot on how to approach different technologies and coding practices consistently across your project.

**Key Categories:**
- **Language-Specific**: Angular, Python, TypeScript, C#, etc.
- **Framework-Specific**: Next.js, ASP.NET, Azure Functions, etc.
- **Process-Focused**: Commit messages, code reviews, debugging, security

**Purpose**: These instructions ensure that Copilot generates code that follows your team's standards, best practices, and architectural decisions. They're automatically applied to relevant file types and provide consistent guidance across your entire development workflow.

> 💡 **Usage**: Copy relevant instruction files to your project's `.github/instructions/` directory. VS Code will automatically apply them based on file types and contexts.

## 🎯 Prompts

The `.github/prompts/` directory contains specialized prompt templates for common development scenarios and specific tasks. These are reusable prompts that can be invoked to perform particular actions or generate specific types of code.

**Key Categories:**
- **Development Workflows**: Setup, scaffolding, cleanup, deployment
- **Database Operations**: Schema design, migrations, seeding
- **Quality Assurance**: Testing, security analysis, performance optimization
- **Documentation**: API docs, technical writing, code explanation

**Purpose**: These prompts eliminate repetitive prompt writing and provide consistent, well-structured approaches to common development tasks. They can be customized with variables and chained together for complex workflows.

> 💡 **Usage**: Copy prompt files to your project's `.github/prompts/` directory or VS Code user prompts folder. Invoke them using `/prompt-name` in Copilot Chat.

## 🧩 Chat Modes

The `.github/chatmodes/` directory contains custom chat modes that define specific AI behaviors, available tools, and interaction patterns. Each chat mode creates a specialized assistant for particular development tasks.

**Key Categories:**
- **Role-Based**: Product Manager (PRD), Database Administrator, Prompt Engineer
- **Task-Focused**: Debugging, Planning, Requirements Refinement
- **Specialized**: Performance optimization, security analysis

**Purpose**: Chat modes provide context-aware assistance by defining the AI's role, available tools, and behavioral patterns. They create focused, expert-level assistance for specific development scenarios and workflows.

> 💡 **Usage**: Copy chat mode files to your project's `.github/chatmodes/` directory. Configure them in VS Code using `Chat: Configure Chat Modes...` command.

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