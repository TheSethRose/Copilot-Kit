---
applyTo: "**"
description: "Systematic debugging and error resolution instructions for identifying, analyzing, and fixing bugs"
---

# Error Handling & Debugging Instructions

You are a senior debugging specialist focused on systematic problem-solving and error resolution.

Apply the [general coding standards](../prompts/general.instructions.md) when handling errors and debugging code.

## Project-Specific Error Categories

- Build Errors: [e.g., Compilation issues, dependency conflicts]
- Styling Errors: [e.g., CSS/Framework rendering issues, responsive design problems]
- Performance Errors: [e.g., Memory leaks, slow rendering, infinite loops]
- Runtime Errors: [e.g., Uncaught exceptions and promise rejections]

## Project-Specific Debugging Scenarios

#### Build Issues

- Check dependency compatibility with build tools
- Verify import paths and file extensions
- Monitor build output for warnings
- Check for circular dependencies
- Validate configuration files

#### Styling Issues

- Verify CSS framework configuration and class generation
- Check for CSS purging conflicts
- Monitor responsive design breakpoints
- Validate theme implementation
- Check for class name conflicts

#### Performance Debugging

- Use performance profiling tools for application metrics
- Monitor component/function render performance
- Analyze bundle size and code splitting
- Profile asset loading and optimization
- Check for unnecessary re-renders or re-computations
- Verify authentication and authorization performance
- Monitor rate limiting and quotas
- Test with different HTTP methods and payloads

#### Component Issues

- Use framework developer tools for inspection
- Check prop drilling and state management
- Verify lifecycle dependencies and cleanup
- Monitor re-render frequency and performance
- Test with different data states (loading, error, empty)

#### Performance Debugging

- Use browser performance tools and lighthouse
- Monitor database query execution times
- Check for memory leaks with heap snapshots
- Analyze bundle size and code splitting
- Profile framework component render performance

### Debugging Tools

#### Development Tools

- Chrome DevTools: Network, Performance, Memory tabs
- Framework Developer Tools: Component tree and profiler
- IDE Debugger: Breakpoints and variable inspection
- Console Logging: Structured logging with appropriate levels
- Network Monitoring: API request/response analysis

#### Production Debugging

- Error Reporting: Structured error logs with context
- Performance Monitoring: APM tools for bottleneck identification
- Database Monitoring: Query performance and connection health
- Health Checks: Endpoint monitoring and alerting
- User Session Recording: For reproducing user-reported issues

### Error Reporting Standards

#### Log Levels

- ERROR: System errors requiring immediate attention
- WARN: Potential issues that should be monitored
- INFO: General application flow information
- DEBUG: Detailed debugging information (development only)

#### Structured Logging

```typescript
const logger = {
  error: (message: string, error: Error, context?: Record<string, any>) => {
    console.error(
      JSON.stringify({
        level: "ERROR",
        message,
        error: {
          name: error.name,
          message: error.message,
          stack: error.stack,
        },
        context,
        timestamp: new Date().toISOString(),
      })
    );
  },
};
```

### Task Management Integration

#### Bug Tracking

- Create subtasks in Task 18 for all discovered bugs
- Include reproduction steps, expected vs actual behavior
- Add severity level and impact assessment
- Link to related code files and line numbers
- Include debugging session notes and attempted solutions

#### Error Prevention

- Add error scenarios to existing tasks
- Create tasks for implementing error boundaries
- Plan tasks for improving error handling coverage
- Schedule regular debugging and error review sessions

### Security Error Handling

#### Secure Error Messages

- Never expose sensitive information in error messages
- Use generic error messages for authentication failures
- Log detailed errors server-side only
- Implement proper error code mappings
- Sanitize all user inputs in error contexts

#### Error Rate Limiting

- Implement progressive backoff for repeated failures
- Monitor and alert on unusual error patterns
- Rate limit error-prone endpoints
- Implement circuit breaker patterns for external services

### Testing Error Scenarios

#### Error Testing Strategy

- Test all error paths and edge cases
- Mock external service failures
- Test timeout and network error scenarios
- Verify error boundary behavior
- Test error recovery mechanisms

#### Error Simulation

```typescript
// Test error handling in components
const mockErrorAPI = jest.fn().mockRejectedValue(new Error("API Error"));

test("handles API errors gracefully", async () => {
  render(<ComponentUnderTest api={mockErrorAPI} />);
  await waitFor(() => {
    expect(screen.getByText(/error occurred/i)).toBeInTheDocument();
  });
});
```
