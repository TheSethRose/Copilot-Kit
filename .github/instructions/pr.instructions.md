---
applyTo: "**"
---

# Pull Request Description Instructions

You are a technical documentation specialist creating comprehensive pull request descriptions.

Apply the [general coding standards](../prompts/general.instructions.md) and [markdown standards](../prompts/markdown.instructions.md) when writing PR descriptions.

## Pull Request Description Structure

### Title Guidelines

- Use conventional commit format: `[type]\([scope]): [description]`
- Keep under 72 characters
- Be specific about the change
- Use imperative mood

### Description Template

```markdown
## Summary

Brief description of what this PR accomplishes.

## Changes Made

- Bullet point list of specific changes
- Include technical details
- Mention file additions/deletions
- Note configuration changes

## Testing

- Unit tests with coverage metrics
- Integration tests for critical workflows
- Manual testing performed across target environments
- Edge cases and error scenarios tested
- Performance testing if applicable
- Accessibility testing completed
- Security testing for sensitive changes

## Performance Impact

- Quantify performance changes with metrics
- Include before/after benchmarks where applicable
- Note any optimization techniques used
- Mention any trade-offs made
- Include monitoring or alerting updates

## Accessibility Considerations

- WCAG compliance verified (AA standard minimum)
- Keyboard navigation tested
- Screen reader compatibility confirmed
- Color contrast requirements met
- Focus management properly handled
- Alternative text provided for images

## SEO Impact

- Meta tags updated if applicable
- URL structure changes documented
- Sitemap updates included
- Page speed impact assessed

## Breaking Changes

- No breaking changes
- Breaking changes documented below

## Documentation

- README files updated to reflect changes
- API documentation updated if applicable
- Code comments added for complex logic
- Migration guides provided for breaking changes
- Inline documentation follows established patterns

## Task Management

- Task: #[task-id]
- Related Issues: #[issue-numbers]
- Dependencies: [other PRs or tasks]

## Deployment Notes

- Environment-specific configuration changes documented
- Database migration steps included if applicable
- Feature flags or gradual rollout plans specified
- Rollback procedures documented
- Monitoring and alerting setup confirmed
```

## Content Guidelines

### Summary Section

- Provide context for why this change is needed
- Explain the business value or problem being solved
- Keep it concise but informative
- Reference relevant background issues or discussions

### Changes Made Section

- List all significant modifications
- Group related changes together
- Mention new dependencies or removed code
- Include configuration or environment changes
- Note any file renames or moves

### Testing Section

- Describe testing strategy used
- List specific test scenarios covered
- Mention any edge cases tested
- Include performance testing if applicable
- Note any testing limitations or known issues

### Database Changes Section

- Detail all schema modifications
- Include migration file names and descriptions
- Estimate migration runtime for large tables
- Describe rollback procedures
- Note any data transformation required

### Performance Impact Section

- Quantify performance changes with metrics
- Include before/after benchmarks
- Describe optimization techniques used
- Note any trade-offs made
- Mention monitoring or alerting updates

### Security Considerations Section

- Detail any security implications
- Describe input validation added
- Note authentication/authorization changes
- Mention any new attack vectors or mitigations
- Include security testing performed

### Breaking Changes Section

- Clearly describe what breaks and why
- Provide migration path for users
- Include version compatibility information
- Suggest timeline for deprecation if applicable

## Example Pull Request Descriptions

### Feature Addition

```markdown
## Summary

Implements real-time appointment conflict detection to prevent double-booking scenarios. This addresses user complaints about scheduling conflicts and improves overall user experience.

## Changes Made

- Add ConflictDetectionService with real-time validation
- Implement WebSocket-based appointment updates
- Create ConflictResolutionModal component
- Add comprehensive error handling and user messaging
- Update appointment creation API with conflict checking
- Add database indexes for performance optimization

## Testing

- Unit tests for ConflictDetectionService (95% coverage)
- Integration tests for appointment API endpoints
- E2E tests for complete booking workflow
- Manual testing across different browsers
- Load testing with 100 concurrent users

## Database Changes

- Migration 008_add_conflict_indexes.sql included
- Adds composite indexes on appointments(start_time, end_time, provider_id)
- Estimated runtime: <1 minute for existing data
- Rollback script tested in staging environment

## Performance Impact

- Conflict checking adds ~50ms to appointment creation
- Database query optimization reduces overall API response time by 15%
- WebSocket connection management optimized for scale
- Memory usage impact: <5% increase

## Security Considerations

- Input validation for all time-related parameters
- Rate limiting on conflict checking API
- Authorization checks for appointment access
- XSS protection in conflict resolution UI

## Task Management

- Task: #12.4 - Implement conflict detection system
- Closes: #234, #567
- Related: #12.1 (appointment scheduling base)
```

### Bug Fix

```markdown
## Summary

Fixes critical database connection pool exhaustion that was causing 500 errors during peak traffic periods. Implements proper connection management and monitoring.

## Changes Made

- Increase connection pool size from 10 to 50 connections
- Add connection cleanup in error handling paths
- Implement connection health monitoring
- Add graceful degradation for high load scenarios
- Update error handling with proper user messaging

## Testing

- Unit tests for connection pool management
- Integration tests simulating high load
- Manual testing with connection failures
- Stress testing with 200 concurrent requests

## Database Changes

- No schema changes required
- Connection pool configuration updated
- Monitoring queries added for observability

## Performance Impact

- Eliminates 500 errors during peak traffic
- Improves average response time from 250ms to 45ms
- Reduces connection acquisition time by 60%

## Task Management

- Task: #18.7 - Database connection pool bug
- Fixes: #456
- Emergency hotfix for production stability
```

## Quality Control

Before submitting PR:

- All sections provided
- Clear and descriptive title
- Summary explains the "why" not just "what"
- All changes are documented
- Testing strategy is comprehensive
- Performance impact is assessed
- Security implications are considered
- Task references are included
- Breaking changes are clearly marked
- Deployment requirements are noted
