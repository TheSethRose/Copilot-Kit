---
description: "Comprehensive code review process focusing on best practices, security, performance and maintainability"
---

# Review - Comprehensive Code Review Process

Apply the [general coding guidelines](./general.instructions.md) to all code review assessments.

**Command:** `/review`

## Purpose

Perform thorough code reviews with focus on best practices, security, performance, maintainability, and adherence to project standards.

## Usage

```
/review [file/component/feature to review]
```

## Review Framework

### 1. Code Quality Assessment

- **Readability**: Clear naming, logical structure, appropriate comments
- **Maintainability**: Modular design, separation of concerns, documentation
- **Consistency**: Adherence to project coding standards and conventions
- **Complexity**: Cognitive load, cyclomatic complexity, potential simplifications
- **DRY Principle**: Identification of code duplication and refactoring opportunities

### 2. Architecture Review

- **Design Patterns**: Appropriate use of established patterns
- **SOLID Principles**: Single responsibility, open/closed, dependency inversion
- **Component Structure**: Logical organization and clear interfaces
- **Data Flow**: Unidirectional data flow, state management patterns
- **API Design**: RESTful principles, consistent naming, proper HTTP methods

### 3. Security Analysis

- **Input Validation**: Sanitization and validation of user inputs
- **Authentication/Authorization**: Proper access controls and permissions
- **Data Protection**: Encryption, secure storage, privacy considerations
- **Vulnerability Assessment**: Common security antipatterns and exploits
- **Dependencies**: Security audit of third-party packages

### 4. Performance Evaluation

- **Algorithm Efficiency**: Time and space complexity analysis
- **Resource Usage**: Memory leaks, unnecessary computations
- **Bundle Size**: Import optimization, tree shaking opportunities
- **Rendering Performance**: React optimization, memoization strategies
- **Network Optimization**: Caching, compression, lazy loading

### 5. Testing Coverage

- **Unit Tests**: Component isolation, edge case coverage
- **Integration Tests**: Component interaction validation
- **End-to-End Tests**: User journey verification
- **Test Quality**: Meaningful assertions, test maintainability
- **Coverage Metrics**: Line, branch, and functional coverage

## Review Checklist

### General Code Quality

- [ ] Code follows established naming conventions
- [ ] Functions and classes have single responsibilities
- [ ] Complex logic is properly commented
- [ ] Magic numbers and strings are replaced with named constants
- [ ] Error handling is comprehensive and user-friendly

### TypeScript Specific

- [ ] Strong typing used throughout (no `any` types)
- [ ] Interfaces and types are properly defined
- [ ] Generic types used appropriately
- [ ] Type guards implemented where necessary
- [ ] Import statements use `import type` for type-only imports

### React Specific

- [ ] Components are properly memoized where beneficial
- [ ] Hooks are used correctly (dependency arrays, custom hooks)
- [ ] Props are properly typed and validated
- [ ] State management follows React best practices
- [ ] Event handlers are optimized to prevent unnecessary re-renders

### Accessibility

- [ ] Semantic HTML elements used appropriately
- [ ] ARIA attributes provided where necessary
- [ ] Keyboard navigation supported
- [ ] Screen reader compatibility verified
- [ ] Color contrast meets WCAG guidelines

### Security

- [ ] User inputs are validated and sanitized
- [ ] XSS prevention measures implemented
- [ ] Sensitive data is not exposed in client-side code
- [ ] HTTPS enforced for sensitive operations
- [ ] Dependencies are up-to-date and vulnerability-free

## Output Structure

```markdown
## Review Summary

- **Overall Rating**: [Excellent/Good/Needs Improvement/Poor]
- **Key Strengths**: [Positive aspects]
- **Critical Issues**: [Must-fix problems]
- **Improvement Opportunities**: [Enhancement suggestions]

## Detailed Findings

### 🔴 Critical Issues (Must Fix)

1. **[Issue Category]**: [Description]
   - **Location**: [File/line reference]
   - **Impact**: [Security/Performance/Functionality]
   - **Recommendation**: [Specific solution]

### 🟡 Improvements (Should Fix)

1. **[Issue Category]**: [Description]
   - **Location**: [File/line reference]
   - **Impact**: [Code quality/maintainability]
   - **Recommendation**: [Suggested improvement]

### 🟢 Suggestions (Could Fix)

1. **[Enhancement Category]**: [Description]
   - **Location**: [File/line reference]
   - **Benefit**: [Potential improvement]
   - **Recommendation**: [Optional enhancement]

## Architecture Assessment

- **Design Patterns**: [Evaluation of pattern usage]
- **Code Organization**: [Structure and modularity assessment]
- **Dependencies**: [Analysis of external dependencies]
- **Scalability**: [Future growth considerations]

## Performance Analysis

- **Bundle Impact**: [Size and loading considerations]
- **Runtime Performance**: [Execution efficiency]
- **Memory Usage**: [Resource consumption]
- **Optimization Opportunities**: [Specific improvements]

## Security Review

- **Vulnerability Assessment**: [Security risk evaluation]
- **Data Protection**: [Privacy and encryption review]
- **Access Control**: [Authentication/authorization review]
- **Dependency Security**: [Third-party package audit]

## Testing Evaluation

- **Coverage Assessment**: [Test completeness]
- **Test Quality**: [Test effectiveness and maintainability]
- **Missing Tests**: [Identified gaps]
- **Test Strategy**: [Improvement recommendations]

## Action Items

### Priority 1 (Critical)

- [ ] [Specific action with owner and deadline]

### Priority 2 (Important)

- [ ] [Specific action with owner and deadline]

### Priority 3 (Enhancement)

- [ ] [Specific action with owner and deadline]
```

## Best Practices

- Focus on constructive feedback with specific examples
- Prioritize issues by impact and effort required
- Provide code examples for recommended changes
- Consider the broader system impact of suggestions
- Balance perfectionism with practical delivery needs
- Acknowledge good practices and improvements
- Ensure recommendations align with project goals

## Integration

Use this command for:

- Pull request reviews
- Feature completion assessments
- Refactoring validation
- Security audits
- Performance optimization reviews
- Code quality improvements
