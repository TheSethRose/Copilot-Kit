---
applyTo: "**/*.ts,**/*.tsx"
description: "TypeScript and React coding standards with performance optimization, accessibility, and testing requirements"
---

# Project coding standards for TypeScript and React

Apply the [general coding guidelines](./general.instructions.md) to all code.

## TypeScript Guidelines

### Type Safety Requirements

- NEVER use the `any` type
- Use TypeScript strict mode
- All functions must have return type annotations
- Use interfaces for data structures and type definitions
- Prefer immutable data (const, readonly)
- Use optional chaining (?.) and nullish coalescing (??) operators
- When importing types, use `import type` for type-only imports
- Implement proper error handling with typed exceptions

### Zod Schema Usage

Create Zod schemas for all data structures:

```typescript
const UserSchema = z.object({
  id: z.string().uuid(),
  email: z.string().email(),
  createdAt: z.date(),
});
type User = z.infer<typeof UserSchema>;
```

### Error Handling Patterns

Use Result type pattern for error handling:

```typescript
type Result<T, E = Error> =
  | { success: true; data: T }
  | { success: false; error: E };

async function safeDataFetch(): Promise<Result<PortfolioData>> {
  try {
    const data = await fetch("/api/portfolio");
    const portfolioData = await data.json();
    return { success: true, data: portfolioData };
  } catch (error) {
    return {
      success: false,
      error: error instanceof Error ? error : new Error("Unknown error"),
    };
  }
}
```

## React Guidelines

### Component Standards

- Use functional components with hooks for state management
- Follow the React hooks rules (no conditional hooks)
- Use React.FC type for components with children
- Keep components small and focused
- Implement proper key props in lists
- Efficient event handling and cleanup

### Performance Optimization

- Check for unnecessary re-renders in React components
- Properly use `useMemo`, `useCallback`, and `React.memo`
- Avoid prop drilling (use context when appropriate)
- Monitor memory leaks in useEffect

### Error Boundaries

Implement React Error Boundaries for robust error handling:

```typescript
class ErrorBoundary extends React.Component<
  { children: React.ReactNode },
  { hasError: boolean; error?: Error }
> {
  constructor(props: { children: React.ReactNode }) {
    super(props);
    this.state = { hasError: false };
  }

  static getDerivedStateFromError(error: Error) {
    return { hasError: true, error };
  }

  componentDidCatch(error: Error, errorInfo: React.ErrorInfo) {
    console.error("Error boundary caught an error:", error, errorInfo);
  }

  render() {
    if (this.state.hasError) {
      return <ErrorFallback error={this.state.error} />;
    }
    return this.props.children;
  }
}
```

### Anti-Patterns to Avoid

- Using `any` type anywhere
- Missing error boundaries
- Unhandled promise rejections
- Memory leaks in useEffect
- Direct DOM manipulation in React
- Direct database queries in components

## Testing Requirements

- Unit tests for business logic
- Component tests for UI logic
- Edge cases and error scenarios covered
- Maintain >90% code coverage

## Styling Guidelines

- Use CSS modules for component styling
- Implement responsive design principles
- Optimize for performance and accessibility
