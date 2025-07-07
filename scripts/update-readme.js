#!/usr/bin/env node

const fs = require("fs");
const path = require("path");

// Template sections for the README
const TEMPLATES = {
  header: `# Copilot-Kit

A comprehensive collection of language-agnostic templates and structured prompts for GitHub Copilot that can be customized for any programming language and project type. This repository provides a systematic approach to AI-assisted development with standardized workflows, coding guidelines, and specialized prompts.

## Overview

This template system enables consistent, high-quality code generation through:

- **Structured Instructions**: Comprehensive coding standards and best practices
- **Specialized Prompts**: Task-specific prompts for common development workflows
- **Chat Modes**: AI personas for specific development tasks
- **Workflow Automation**: Standardized processes for commits, reviews, and documentation
- **Quality Assurance**: Built-in guidelines for testing, security, and performance

## Repository Structure

{{REPOSITORY_STRUCTURE}}`,

  instructionsSection: `## 📋 Instructions

The \`.github/instructions/\` directory contains core instruction templates that establish fundamental development standards and workflows. These files guide GitHub Copilot on how to approach different technologies and coding practices consistently across your project.

**Key Categories:**
- **Language-Specific**: Angular, Python, TypeScript, C#, etc.
- **Framework-Specific**: Next.js, ASP.NET, Azure Functions, etc.
- **Process-Focused**: Commit messages, code reviews, debugging, security

**Purpose**: These instructions ensure that Copilot generates code that follows your team's standards, best practices, and architectural decisions. They're automatically applied to relevant file types and provide consistent guidance across your entire development workflow.`,

  instructionsUsage: `> 💡 **Usage**: Copy relevant instruction files to your project's \`.github/instructions/\` directory. VS Code will automatically apply them based on file types and contexts.`,

  promptsSection: `## 🎯 Prompts

The \`.github/prompts/\` directory contains specialized prompt templates for common development scenarios and specific tasks. These are reusable prompts that can be invoked to perform particular actions or generate specific types of code.

**Key Categories:**
- **Development Workflows**: Setup, scaffolding, cleanup, deployment
- **Database Operations**: Schema design, migrations, seeding
- **Quality Assurance**: Testing, security analysis, performance optimization
- **Documentation**: API docs, technical writing, code explanation

**Purpose**: These prompts eliminate repetitive prompt writing and provide consistent, well-structured approaches to common development tasks. They can be customized with variables and chained together for complex workflows.`,

  promptsUsage: `> 💡 **Usage**: Copy prompt files to your project's \`.github/prompts/\` directory or VS Code user prompts folder. Invoke them using \`/prompt-name\` in Copilot Chat.`,

  chatmodesSection: `## 🧩 Chat Modes

The \`.github/chatmodes/\` directory contains custom chat modes that define specific AI behaviors, available tools, and interaction patterns. Each chat mode creates a specialized assistant for particular development tasks.

**Key Categories:**
- **Role-Based**: Product Manager (PRD), Database Administrator, Prompt Engineer
- **Task-Focused**: Debugging, Planning, Requirements Refinement
- **Specialized**: Performance optimization, security analysis

**Purpose**: Chat modes provide context-aware assistance by defining the AI's role, available tools, and behavioral patterns. They create focused, expert-level assistance for specific development scenarios and workflows.`,

  chatmodesUsage: `> 💡 **Usage**: Copy chat mode files to your project's \`.github/chatmodes/\` directory. Configure them in VS Code using \`Chat: Configure Chat Modes...\` command.`,

  footer: `## Installation

### Manual Installation

Clone the repository and copy the \`.github\` folder to your project:

\`\`\`bash
# Clone the repository
git clone https://github.com/TheSethRose/Copilot-Kit.git

# Copy to your project
cp -r Copilot-Kit/.github your-project/

# Optional: Copy prompts to VS Code User Data folder
cp Copilot-Kit/.github/prompts/* ~/Library/Application\\ Support/Code\\ -\\ Insiders/User/prompts/
\`\`\`

### Using as a Template

You can also use this repository as a GitHub template:

1. Click "Use this template" on the GitHub repository page
2. Create a new repository from the template
3. Clone your new repository
4. Copy the \`.github\` folder to your existing projects as needed

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

## Special Thanks

This project was inspired by and benefits from the following amazing open-source projects:

- **[Joyride](https://github.com/BetterThanTomorrow/joyride)** - VS Code scripting with ClojureScript that powers our bulk installation system
- **[Awesome Copilot](https://github.com/github/awesome-copilot)** - A curated list of resources for GitHub Copilot that inspired many of our best practices
- **[GitHub Copilot](https://github.com/features/copilot)** - The AI pair programmer that makes all of this possible
- **[Visual Studio Code](https://code.visualstudio.com/)** - The extensible editor that provides the platform for these integrations

## License

This project is licensed under the MIT License - see the LICENSE file for details.`
};

// Add error handling utility
function safeFileOperation(operation, filePath, defaultValue = null) {
  try {
    return operation();
  } catch (error) {
    console.error(`Error processing file ${filePath}: ${error.message}`);
    return defaultValue;
  }
}

function extractTitle(filePath) {
  return safeFileOperation(
    () => {
      const content = fs.readFileSync(filePath, "utf8");
      const lines = content.split("\n");

      // Step 1: Look for title in frontmatter for all file types
      let inFrontmatter = false;
      let frontmatterEnded = false;

      for (const line of lines) {
        if (line.trim() === "---") {
          if (!inFrontmatter) {
            inFrontmatter = true;
          } else if (!frontmatterEnded) {
            frontmatterEnded = true;
          }
          continue;
        }

        if (inFrontmatter && !frontmatterEnded) {
          // Look for title field in frontmatter
          if (line.includes("title:")) {
            // Extract everything after 'title:'
            const afterTitle = line
              .substring(line.indexOf("title:") + 6)
              .trim();
            // Remove quotes if present
            const cleanTitle = afterTitle.replace(/^['"]|['"]$/g, "");
            return cleanTitle;
          }
        }
      }

      // Reset for second pass
      inFrontmatter = false;
      frontmatterEnded = false;

      // Step 2: For prompt/chatmode/instructions files, look for heading after frontmatter
      if (
        filePath.includes(".prompt.md") ||
        filePath.includes(".chatmode.md") ||
        filePath.includes(".instructions.md")
      ) {
        for (const line of lines) {
          if (line.trim() === "---") {
            if (!inFrontmatter) {
              inFrontmatter = true;
            } else if (inFrontmatter && !frontmatterEnded) {
              frontmatterEnded = true;
            }
            continue;
          }

          if (frontmatterEnded && line.startsWith("# ")) {
            return line.substring(2).trim();
          }
        }

        // Step 3: Format filename for prompt/chatmode/instructions files if no heading found
        const basename = path.basename(
          filePath,
          filePath.includes(".prompt.md")
            ? ".prompt.md"
            : filePath.includes(".chatmode.md")
              ? ".chatmode.md"
              : ".instructions.md"
        );
        return basename
          .replace(/[-_]/g, " ")
          .replace(/\b\w/g, (l) => l.toUpperCase());
      }

      // Step 4: For instruction files, look for the first heading
      for (const line of lines) {
        if (line.startsWith("# ")) {
          return line.substring(2).trim();
        }
      }

      // Step 5: Fallback to filename
      const basename = path.basename(filePath, path.extname(filePath));
      return basename
        .replace(/[-_]/g, " ")
        .replace(/\b\w/g, (l) => l.toUpperCase());
    },
    filePath,
    path
      .basename(filePath, path.extname(filePath))
      .replace(/[-_]/g, " ")
      .replace(/\b\w/g, (l) => l.toUpperCase())
  );
}

function extractDescription(filePath) {
  return safeFileOperation(
    () => {
      const content = fs.readFileSync(filePath, "utf8");

      // Parse frontmatter for description (for both prompts and instructions)
      const lines = content.split("\n");
      let inFrontmatter = false;
      let frontmatterEnded = false;

      // For multi-line descriptions
      let isMultilineDescription = false;
      let multilineDescription = [];

      for (let i = 0; i < lines.length; i++) {
        const line = lines[i];

        if (line.trim() === "---") {
          if (!inFrontmatter) {
            inFrontmatter = true;
          } else if (inFrontmatter && !frontmatterEnded) {
            frontmatterEnded = true;
            break;
          }
          continue;
        }

        if (inFrontmatter && !frontmatterEnded) {
          // Check for multi-line description with pipe syntax (|)
          const multilineMatch = line.match(/^description:\s*\|(\s*)$/);
          if (multilineMatch) {
            isMultilineDescription = true;
            // Continue to next line to start collecting the multi-line content
            continue;
          }

          // If we're collecting a multi-line description
          if (isMultilineDescription) {
            // If the line has no indentation or has another frontmatter key, stop collecting
            if (!line.startsWith("  ") || line.match(/^[a-zA-Z0-9_-]+:/)) {
              isMultilineDescription = false;
              // Join the collected lines and return
              return multilineDescription.join(" ").trim();
            }

            // Add the line to our multi-line collection (removing the 2-space indentation)
            multilineDescription.push(line.substring(2));
          } else {
            // Look for single-line description field in frontmatter
            const descriptionMatch = line.match(
              /^description:\s*['"]?(.+?)['"]?$/
            );
            if (descriptionMatch) {
              return descriptionMatch[1];
            }
          }
        }
      }

      // If we've collected multi-line description but the frontmatter ended
      if (multilineDescription.length > 0) {
        return multilineDescription.join(" ").trim();
      }

      return null;
    },
    filePath,
    null
  );
}

/**
 * Generate badges for installation links in VS Code and VS Code Insiders.
 * @param {string} link - The relative link to the instructions or prompts file.
 * @returns {string} - Markdown formatted badges for installation.
 */
const vscodeInstallImage =
  "https://img.shields.io/badge/VS_Code-Install-0098FF?style=flat-square&logo=visualstudiocode&logoColor=white";
const vscodeInsidersInstallImage =
  "https://img.shields.io/badge/VS_Code_Insiders-Install-24bfa5?style=flat-square&logo=visualstudiocode&logoColor=white";
const repoBaseUrl =
  "https://raw.githubusercontent.com/TheSethRose/Copilot-Kit/main/.github";
const vscodeBaseUrl = "https://vscode.dev/redirect?url=";
const vscodeInsidersBaseUrl = "https://insiders.vscode.dev/redirect?url=";
function makeBadges(link, type) {
  return `[![Install in VS Code](${vscodeInstallImage})](${vscodeBaseUrl}${encodeURIComponent(
    `vscode:chat-${type}/install?url=${repoBaseUrl}/${link})`
  )} [![Install in VS Code](${vscodeInsidersInstallImage})](${vscodeInsidersBaseUrl}${encodeURIComponent(
    `vscode-insiders:chat-${type}/install?url=${repoBaseUrl}/${link})`
  )}`;
}

/**
 * Generate the instructions section with explanatory content
 */
function generateInstructionsSection(instructionsDir) {
  // Get all instruction files for count
  const instructionFiles = fs
    .readdirSync(instructionsDir)
    .filter((file) => file.endsWith(".md"))
    .sort();

  console.log(`Found ${instructionFiles.length} instruction files`);

  return `${TEMPLATES.instructionsSection}\n\n${TEMPLATES.instructionsUsage}`;
}

/**
 * Generate the prompts section with explanatory content
 */
function generatePromptsSection(promptsDir) {
  // Get all prompt files for count
  const promptFiles = fs
    .readdirSync(promptsDir)
    .filter((file) => file.endsWith(".prompt.md"))
    .sort();

  console.log(`Found ${promptFiles.length} prompt files`);

  return `${TEMPLATES.promptsSection}\n\n${TEMPLATES.promptsUsage}`;
}

/**
 * Generate the chat modes section with explanatory content
 */
function generateChatModesSection(chatmodesDir) {
  // Check if chatmodes directory exists
  if (!fs.existsSync(chatmodesDir)) {
    console.log("Chat modes directory does not exist");
    return "";
  }

  // Get all chat mode files for count
  const chatmodeFiles = fs
    .readdirSync(chatmodesDir)
    .filter((file) => file.endsWith(".chatmode.md"))
    .sort();

  console.log(`Found ${chatmodeFiles.length} chat mode files`);

  // If no chat modes, return empty string
  if (chatmodeFiles.length === 0) {
    return "";
  }

  return `${TEMPLATES.chatmodesSection}\n\n${TEMPLATES.chatmodesUsage}`;
}

/**
 * Generate repository structure dynamically based on actual files
 */
function generateRepositoryStructure(githubDir) {
  try {
    const structure = [];
    structure.push(".github/");

    // Get directories in .github
    const dirs = fs.readdirSync(githubDir).filter(item => {
      const fullPath = path.join(githubDir, item);
      return fs.statSync(fullPath).isDirectory() && !item.startsWith('.');
    }).sort();

    // First pass: collect all file info to determine max filename length for alignment
    const allFileInfo = [];
    dirs.forEach(dir => {
      const dirPath = path.join(githubDir, dir);
      const files = fs.readdirSync(dirPath)
        .filter(file => file.endsWith('.md'))
        .sort();

      files.forEach(file => {
        const title = extractTitle(path.join(dirPath, file));
        const shortDescription = getShortDescription(file, title);
        allFileInfo.push({
          dir,
          file,
          description: shortDescription,
          fullPath: path.join(dirPath, file)
        });
      });
    });

    // Calculate the maximum filename length for alignment
    const maxFilenameLength = Math.max(
      ...allFileInfo.map(info => info.file.length),
      30 // Minimum alignment width
    );

    dirs.forEach((dir, dirIndex) => {
      const isLastDir = dirIndex === dirs.length - 1;
      const dirPrefix = isLastDir ? "└── " : "├── ";

      structure.push(`${dirPrefix}${dir}/`);

      // Get files in this directory
      const dirPath = path.join(githubDir, dir);
      const files = fs.readdirSync(dirPath)
        .filter(file => file.endsWith('.md'))
        .sort(); // Remove .slice(0, 8) to show all files

      files.forEach((file, fileIndex) => {
        const isLastFile = fileIndex === files.length - 1;
        const filePrefix = isLastDir ?
          (isLastFile ? "    └── " : "    ├── ") :
          (isLastFile ? "│   └── " : "│   ├── ");

        const title = extractTitle(path.join(dirPath, file));
        const shortDescription = getShortDescription(file, title);

        // Align comments by padding filename to consistent width
        const paddedFilename = file.padEnd(maxFilenameLength);
        const commentPart = shortDescription ? ` # ${shortDescription}` : "";

        structure.push(`${filePrefix}${paddedFilename}${commentPart}`);
      });
    });

    return structure.join('\n');
  } catch (error) {
    console.error(`Error generating repository structure: ${error.message}`);
    return ".github/\n├── instructions/\n├── prompts/\n└── chatmodes/";
  }
}

/**
 * Get a short description for common file types
 */
function getShortDescription(filename, title) {
  // For instruction files
  if (filename.includes('.instructions.md')) {
    if (filename === 'commit.instructions.md') return 'Git commit message standards';
    if (filename === 'copilot.instructions.md') return 'Code generation guidelines';
    if (filename === 'debug.instructions.md') return 'Error handling and debugging';
    if (filename === 'pr.instructions.md') return 'Pull request documentation';
    if (filename === 'review.instructions.md') return 'Code review standards';
    if (filename === 'security-and-owasp.instructions.md') return 'Security best practices';
    if (filename === 'performance-optimization.instructions.md') return 'Performance guidelines';
    return `${title.split(' ').slice(-1)[0].toLowerCase()} specific standards`;
  }

  // For prompt files
  if (filename.includes('.prompt.md')) {
    if (filename === 'clean.prompt.md') return 'Code cleanup workflows';
    if (filename === 'debug.prompt.md') return 'Debugging assistance';
    if (filename === 'doc.prompt.md') return 'Documentation generation';
    if (filename === 'review.prompt.md') return 'Code review assistance';
    if (filename === 'security.prompt.md') return 'Security analysis';
    if (filename === 'think.prompt.md') return 'Problem analysis';
    return null; // Let the main description handle it
  }

  // For chatmode files
  if (filename.includes('.chatmode.md')) {
    if (filename === 'debug.chatmode.md') return 'Debugging assistance mode';
    if (filename === 'prd.chatmode.md') return 'Product requirements mode';
    return `${title.toLowerCase()} mode`;
  }

  return null;
}

/**
 * Generate the complete README.md content from scratch
 */
function generateReadme() {
  // Find the repository root (where the script is located)
  const repoRoot = path.dirname(__dirname);

  // Define paths relative to the repository root
  const githubDir = path.join(repoRoot, ".github");
  const instructionsDir = path.join(githubDir, "instructions");
  const promptsDir = path.join(githubDir, "prompts");
  const chatmodesDir = path.join(githubDir, "chatmodes");

  console.log(`Repository root: ${repoRoot}`);
  console.log(`Instructions directory: ${instructionsDir}`);
  console.log(`Prompts directory: ${promptsDir}`);
  console.log(`Chat modes directory: ${chatmodesDir}`);  // Generate dynamic repository structure
  const repoStructure = generateRepositoryStructure(githubDir);

  // Update the template header to include the dynamic structure
  const dynamicHeader = TEMPLATES.header.replace(
    '{{REPOSITORY_STRUCTURE}}',
    `\`\`\`\n${repoStructure}\n\`\`\``
  );

  // Generate each section
  const instructionsSection = generateInstructionsSection(instructionsDir);
  const promptsSection = generatePromptsSection(promptsDir);
  const chatmodesSection = generateChatModesSection(chatmodesDir);

  // Build the complete README content with template sections
  let readmeContent = [dynamicHeader, instructionsSection, promptsSection];

  // Only include chat modes section if we have any chat modes
  if (chatmodesSection) {
    readmeContent.push(chatmodesSection);
  }

  // Add footer
  readmeContent.push(TEMPLATES.footer);

  return readmeContent.join("\n\n");
}

// Main execution
try {
  console.log("Generating README.md from scratch...");

  // Find the repository root and set README path
  const repoRoot = path.dirname(__dirname);
  const readmePath = path.join(repoRoot, "README.md");

  console.log(`Writing README to: ${readmePath}`);

  const newReadmeContent = generateReadme();

  // Check if the README file already exists
  if (fs.existsSync(readmePath)) {
    const originalContent = fs.readFileSync(readmePath, "utf8");
    const hasChanges = originalContent !== newReadmeContent;

    if (hasChanges) {
      fs.writeFileSync(readmePath, newReadmeContent);
      console.log("README.md updated successfully!");
    } else {
      console.log("README.md is already up to date. No changes needed.");
    }
  } else {
    // Create the README file if it doesn't exist
    fs.writeFileSync(readmePath, newReadmeContent);
    console.log("README.md created successfully!");
  }
} catch (error) {
  console.error(`Error generating README.md: ${error.message}`);
  process.exit(1);
}

