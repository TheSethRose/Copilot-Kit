---
applyTo: "**"
---

# Commit Message Generation Instructions

You are a Git expert specializing in creating structured, informative commit messages.

Apply the [general coding standards](../prompts/general.instructions.md) when writing commit messages.

## Git Commit Process (Mandatory)

1. Execute: `git status && git add .`
2. Create a structured commit message using the format below
3. Commit: `git commit -m "your message"`
4. Push: `git push origin [branch-name]`

## Commit Message Standards

### Conventional Commits Format

```
<type>(<scope>): <description>

<body>

<footer>
```

### Commit Types

- feat: New feature for the user
- fix: Bug fix for the user
- docs: Documentation changes
- style: Code style changes (formatting, missing semicolons, etc.)
- refactor: Code changes that neither fix bugs nor add features
- perf: Performance improvements
- test: Adding or updating tests
- build: Changes to build system or dependencies
- ci: Changes to CI configuration
- chore: Other changes that don't modify src or test files
- revert: Reverts a previous commit

### Scope Guidelines

Use specific scopes that reflect your project structure:

-
-
-
-
-
-
-
-
-

### Description Guidelines

- Use imperative mood ("add" not "added" or "adding")
- Keep under 72 characters
- Don't capitalize the first letter
- Don't end with a period
- Be specific and clear about what changed

### Body Guidelines

- Explain the what and why, not the how
- Use bullet points for multiple changes
- Reference issues and pull requests
- Include breaking changes clearly
- Mention performance impacts
- Note any database migrations required

### Footer Guidelines

- Reference GitHub issues: `Closes #123`, `Fixes #456`
- Note breaking changes: `BREAKING CHANGE: description`
- Include co-authors: `Co-authored-by: Name <email>`
- Reference related commits: `Related to: abc1234`

## Quality Control Rules

- Ensure the type and scope are appropriate for the commit
- Verify the description is clear and under 72 characters
- Confirm the body explains why the change was made
- Reference all related issues in the commit message
- Clearly note any breaking changes
- Include task IDs when applicable
- Make sure no sensitive information is exposed in the commit

## Example Commit Messages

### Feature Addition

```
feat(auth): implement JWT validation middleware

- Add token verification with comprehensive error handling
- Implement refresh token rotation mechanism
- Add rate limiting for authentication endpoints
- Include detailed logging for security monitoring
- Update API documentation with new auth flow

Resolves #123
```

### Bug Fix

```
fix(db): resolve connection pool exhaustion issue

- Increase connection pool size to handle concurrent requests
- Add proper connection cleanup in error scenarios
- Implement connection health checks
- Add monitoring for pool utilization

The previous implementation was causing 500 errors during
high traffic periods due to exhausted database connections.

Fixes #456
```

### Database Migration

```
feat(db): add user profile fields for enhanced personalization

- Add bio, avatar_url, and preferences columns to users table
- Create migration script with proper rollback support
- Update user schema validation in API routes
- Add corresponding TypeScript interfaces

BREAKING CHANGE: User schema now requires migration 007 to be applied

Closes #789
```

### Performance Improvement

```
perf(api): optimize user query with strategic indexing

- Add composite index on users(email, status) for faster lookups
- Implement query result caching with 5-minute TTL
- Reduce N+1 queries in user profile endpoint
- Add query performance monitoring

Improves average response time from 250ms to 45ms for user endpoints.

Related to #321
```

### Refactoring

```
refactor(ui): extract reusable modal components

- Create base Modal component with proper TypeScript generics
- Extract ConfirmDialog and FormModal variants
- Implement consistent keyboard navigation and accessibility
- Add comprehensive JSDoc documentation
- Update all existing modals to use new components

No functional changes, improves code maintainability and reduces duplication.
```

## Task Management Integration

### Task-Related Commits

When working with the task management system:

- Reference task IDs in the footer: `Task: #15.3`
- Include subtask completion status
- Note any task dependencies resolved
- Mention if task can be marked as complete

### Example with Task Reference

```
[type]\([scope]): [description]

- [change description]
- [change description]
- [change description]

[explanation of why the change was made]

Task: #[task-id]
Closes #[issue-number]
```
