---
applyTo: "**"
description: "Core coding standards and best practices for consistent, maintainable, and high-quality code across all project files"
---

# Project general coding standards

These standards apply to all code in this project and serve as the foundation for maintaining code quality, consistency, and team collaboration.

## Core Principles

- Adhere to SOLID, DRY, KISS & YAGNI principles
- Evaluate simpler solutions before proceeding with implementation
- Document all public interfaces comprehensively
- Thoroughly test edge cases & potential error conditions

## Naming Conventions

- Classes: PascalCase (e.g., UserService, AuthMiddleware)
- Functions/Variables: camelCase (e.g., getUserData, isAuthenticated)
- Files/Directories: kebab-case (e.g., user-service.ts, auth-utils/)
- Constants/Env Variables: UPPERCASE (e.g., MAX_RETRY_ATTEMPTS, DATABASE_URL)
- Component names, interfaces, and type aliases: PascalCase
- Private class members: prefix with underscore (\_)

## Error Handling

- Use try/catch blocks for async operations
- Always log errors with contextual information
- Implement proper error boundaries where appropriate
- Handle edge cases and potential error conditions

## Documentation Standards

- Follow the Google Technical Writing Style Guide
- Write JSDoc for all public APIs using TypeDoc-compatible tags
- Clearly define terminology where needed
- Use structured lists & tables when appropriate

## Code Quality

- Keep functions and components small and focused
- Follow the single responsibility principle
- Prefer immutable data patterns
- Split files over 300 lines into logical modules for better maintainability

## Integration with Development Workflow

These standards integrate with:

- **Prompt files** - All project-specific prompts reference these guidelines
- **Code reviews** - Use `/review` command to validate adherence
- **Setup processes** - `/setup` command implements these standards
- **Documentation** - `/doc` command follows these formatting guidelines
- **Testing** - Ensure all code follows these patterns for testability

## Enforcement

- Use ESLint and Prettier configurations that align with these standards
- Include these guidelines in pull request templates
- Reference during code reviews and pair programming sessions
- Update team documentation when standards evolve
