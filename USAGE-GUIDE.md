# GitHub Copilot Instructions Usage Guide

A comprehensive guide for effectively using the GitHub Copilot instruction files, chat modes, and prompts in your development workflow.

## 📋 Table of Contents

- [Quick Start](#quick-start)
- [File Types Overview](#file-types-overview)
- [Recommended Setup Order](#recommended-setup-order)
- [Best Practices](#best-practices)
- [File Selection Guide](#file-selection-guide)
- [Troubleshooting](#troubleshooting)

## 🚀 Quick Start

1. **Copy the `.github` directory** to your project root
2. **Start with core instructions** (see [Setup Order](#recommended-setup-order))
3. **Add language-specific instructions** for your tech stack
4. **Configure chat modes** for your workflow
5. **Use prompts** for specific tasks

## 📁 File Types Overview

### Instructions Files (`*.instructions.md`)
**Purpose**: Define coding standards, best practices, and automatic guidance that GitHub Copilot applies to your code.

**Key Features**:
- Automatically applied based on file types (`applyTo` field)
- Establish consistent coding standards across your project
- Provide language-specific and framework-specific guidance
- Include security, performance, and debugging standards

### Chat Modes (`*.chatmode.md`)
**Purpose**: Specialized AI personas for specific development tasks and workflows.

**Key Features**:
- Activate specific modes in GitHub Copilot Chat
- Provide focused assistance for specialized tasks
- Include task-specific tools and capabilities
- Offer structured problem-solving approaches

### Prompts (`*.prompt.md`)
**Purpose**: Task-specific templates for generating code, documentation, and performing specific development tasks.

**Key Features**:
- On-demand assistance for specific tasks
- Structured templates for common development scenarios
- Comprehensive examples and best practices
- Customizable for project-specific needs

## 🔄 Recommended Setup Order

### Phase 1: Core Foundation (Start Here)
Set up these files first to establish fundamental standards:

1. **`general-coding-standards.instructions.md`** - Core coding principles and standards
2. **`copilot.instructions.md`** - Basic Copilot configuration and behavior
3. **`commit.instructions.md`** - Git commit message standards
4. **`debug.instructions.md`** - Error handling and debugging practices

### Phase 2: Language-Specific Instructions
Choose based on your primary technology stack:

#### For TypeScript/React Projects:
- `languages/typescript/typescript-react-standards.instructions.md`
- `languages/typescript/nextjs-tailwind.instructions.md` (if using Next.js)
- `languages/typescript/azure-functions-typescript.instructions.md` (if using Azure Functions)
- `performance-optimization.instructions.md`

#### For .NET Projects:
- `languages/csharp/csharp.instructions.md`
- `languages/csharp/aspnet-rest-apis.instructions.md`
- `languages/csharp/blazor.instructions.md` (if using Blazor)
- `languages/csharp/dotnet-maui.instructions.md` (if using MAUI)

#### For Python Projects:
- `languages/python/python-coding-standards.instructions.md`

#### For Go Projects:
- `languages/go/go.instructions.md`

#### For Angular Projects:
- `languages/angular/angular.instructions.md`

#### For Infrastructure as Code:
- `languages/infrastructure/bicep-code-best-practices.instructions.md`
- `languages/infrastructure/generate-modern-terraform-code-for-azure.instructions.md`

#### For C++ Projects:
- `languages/cpp/cmake-vcpkg.instructions.md`

#### For AI/GenAI Projects:
- `languages/ai/genaiscript.instructions.md`

### Phase 3: Process and Quality
Add these for comprehensive development workflow:

1. **`review.instructions.md`** - Code review standards
2. **`pr.instructions.md`** - Pull request documentation
3. **`security-and-owasp.instructions.md`** - Security best practices
4. **`markdown-standards.instructions.md`** - Documentation standards
5. **`localization.instructions.md`** (if internationalization needed)

### Phase 4: Specialized Tools
Add based on your specific needs:

- `performance-optimization.instructions.md` (for performance optimization)
- Additional language-specific files as needed from the `languages/` folder

### Phase 5: Chat Modes
Configure these for enhanced workflow:

1. **`debug.chatmode.md`** - Essential for debugging
2. **`planner.chatmode.md`** - Project planning and architecture
3. **`prd.chatmode.md`** - Product requirements and specifications
4. **`prompt-engineer.chatmode.md`** - For creating better prompts
5. **`refine-issue.chatmode.md`** - Issue refinement and analysis

## 🎯 Best Practices

### For Instructions Files

1. **Start Small**: Begin with core instructions and gradually add more specific ones
2. **Customize**: Modify the `applyTo` patterns to match your project structure
3. **Test**: Create test files to verify instructions are working correctly
4. **Update**: Keep instructions current with your evolving project needs

### For Chat Modes

1. **Learn the Modes**: Understand what each mode does before using it
2. **Use Contextually**: Switch modes based on the task at hand
3. **Combine with Instructions**: Chat modes work best with proper instructions in place
4. **Practice**: Try different modes to find what works best for your workflow

### For Prompts

1. **Read Before Using**: Review prompt content to understand what it does
2. **Customize**: Modify prompts for your specific project needs
3. **Combine**: Use multiple prompts for complex tasks
4. **Document**: Keep track of which prompts work best for your use cases

## 🔍 File Selection Guide

### Choose Instructions Based on Your Project

| Project Type | Core Instructions | Additional Instructions |
|-------------|-------------------|------------------------|
| **React/TypeScript** | general-coding-standards, languages/typescript/typescript-react-standards | languages/typescript/nextjs-tailwind, performance-optimization |
| **ASP.NET Core** | general-coding-standards, languages/csharp/csharp | languages/csharp/aspnet-rest-apis, security-and-owasp |
| **Python API** | general-coding-standards, languages/python/python-coding-standards | security-and-owasp, performance-optimization |
| **Angular** | general-coding-standards, languages/angular/angular | languages/typescript/typescript-react-standards, performance-optimization |
| **Full-Stack** | general-coding-standards, [language-specific] | security-and-owasp, performance-optimization, review |

### Choose Chat Modes Based on Your Workflow

| Task Type | Recommended Mode | Alternative Modes |
|-----------|------------------|-------------------|
| **Bug Fixing** | debug.chatmode | planner.chatmode (for complex bugs) |
| **Feature Planning** | planner.chatmode | prd.chatmode |
| **Code Review** | review.chatmode | debug.chatmode |
| **Requirements Analysis** | prd.chatmode | refine-issue.chatmode |
| **Database Work** | postgresql-dba.chatmode | debug.chatmode |

### Choose Prompts Based on Your Task

| Task | Recommended Prompt | Related Prompts |
|------|-------------------|----------------|
| **Documentation** | document-project.prompt | explain.prompt |
| **Testing** | csharp-xunit.prompt, javascript-typescript-jest.prompt | csharp-mstest.prompt |
| **Database** | diagnose-database.prompt, ef-core.prompt | validate-schema.prompt |
| **Deployment** | deploy-react-app.prompt | build-dockerfile.prompt |
| **Performance** | optimize-performance.prompt | az-cost-optimize.prompt |
| **Project Cleanup** | clean.prompt | generate-code.prompt |
| **Git Operations** | commit.prompt | generate-issues.prompt |

## 🛠️ Troubleshooting

### Common Issues

**Instructions Not Working**
- Check the `applyTo` pattern matches your file structure
- Verify the file is in the correct `.github/instructions/` directory
- Ensure frontmatter is properly formatted

**Chat Mode Not Activating**
- Verify the file is in `.github/chatmodes/` directory
- Check that the `description` and `tools` fields are present
- Restart VS Code if necessary

**Prompts Not Functioning**
- Ensure the file is in `.github/prompts/` directory
- Check that the frontmatter is correctly formatted
- Verify the prompt content is clear and specific

### Getting Help

1. **Check the README**: Review the main README.md for detailed information
2. **Examine Examples**: Look at working examples in the repository
3. **Test Incrementally**: Add one file at a time to isolate issues
4. **Use Debug Mode**: Try the debug.chatmode for troubleshooting

## 📚 Advanced Usage

### Custom Instructions

You can create custom instruction files by:
1. Following the frontmatter format with `applyTo` and `description`
2. Including relevant coding standards and practices
3. Testing with sample files to ensure they work correctly

### Combining Instructions

Instructions are additive - you can have multiple instruction files that apply to the same file types. They will all be considered by GitHub Copilot.

### Project-Specific Customization

1. **Fork the repository** to create your own version
2. **Modify existing files** to match your team's standards
3. **Add new files** for project-specific requirements
4. **Remove unused files** to reduce complexity

## 🎯 Success Metrics

Track your success with these metrics:

- **Code Quality**: Fewer bugs, better structure, consistent style
- **Development Speed**: Faster feature development and debugging
- **Team Consistency**: Uniform coding standards across team members
- **Documentation Quality**: Better comments, documentation, and commit messages
- **Review Efficiency**: Faster code reviews with fewer style-related comments

## 📝 Conclusion

This instruction system provides a comprehensive framework for AI-assisted development. Start with the core instructions, add language-specific guidance, and gradually incorporate specialized tools as your needs evolve.

Remember: The goal is to enhance your development workflow, not replace your expertise. Use these tools to maintain consistency, catch common issues, and accelerate routine tasks while focusing your energy on creative problem-solving and architecture decisions.

---

*For more detailed information about specific files, see the main [README.md](./README.md) and individual file documentation.*
