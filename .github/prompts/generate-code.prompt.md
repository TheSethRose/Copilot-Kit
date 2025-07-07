---
description: "Automated generation of boilerplate code, components, API routes, pages, and project structures following established patterns and best practices"
---

# Code Scaffolding & Generation

Apply the [general coding guidelines](./general.instructions.md) and [TypeScript React guidelines](./typescript-react.instructions.md) to all generated code.

**Command:** `/scaffold`

## Purpose

Automated generation of boilerplate code, components, API routes, pages, and other project structures following established patterns and best practices.

## Usage

```
/scaffold [component/feature type] [name] [options]
```

**Examples:**

- `/scaffold component UserProfile --with-props --styled`
- `/scaffold page Dashboard --with-routing`
- `/scaffold api user --crud-operations`
- `/scaffold hook useLocalStorage --with-types`
- `/scaffold form ContactForm --with-validation`

## Methodology

### 1. Scaffolding Categories

#### React Components

- Functional components with TypeScript
- Component variants (basic, with props, with state)
- Styled components with Tailwind CSS
- Form components with validation
- Data display components

#### API Routes & Services

- RESTful API endpoints
- GraphQL resolvers and mutations
- Service layer implementations
- Data access layer components
- Middleware functions

#### Pages & Layouts

- Page components with routing
- Layout components with responsive design
- Error boundaries and loading states
- SEO-optimized page structures
- Authentication-protected pages

#### Utility & Helper Functions

- Custom hooks for common patterns
- Utility functions with proper typing
- Validation schemas with Zod
- Test utilities and fixtures
- Configuration helpers

### 2. Scaffolding Commands

#### Component Generation

```bash
# Basic component
npm run scaffold:component MyComponent

# Component with props interface
npm run scaffold:component MyComponent --with-props

# Form component with validation
npm run scaffold:form UserForm --fields="name,email,password"

# Page component with routing
npm run scaffold:page AboutPage --route="/about"
```

#### API Scaffolding

```bash
# REST API endpoint
npm run scaffold:api users --methods="GET,POST,PUT,DELETE"

# Service layer
npm run scaffold:service UserService --model=User

# Database model
npm run scaffold:model User --fields="name:string,email:email,active:boolean"
```

#### Utility Scaffolding

```bash
# Custom hook
npm run scaffold:hook useLocalStorage --type="generic"

# Utility function
npm run scaffold:util formatCurrency --category="formatting"

# Validation schema
npm run scaffold:schema UserSchema --based-on=User
```

### 3. Code Templates

#### React Component Template

```typescript
import React from 'react';
import { cn } from '@/lib/utils';

interface {{ComponentName}}Props {
  className?: string;
  // Add specific props here
}

export const {{ComponentName}}: React.FC<{{ComponentName}}Props> = ({
  className,
  ...props
}) => {
  return (
    <div className={cn('{{default-classes}}', className)}>
      {/* Component content */}
    </div>
  );
};

{{ComponentName}}.displayName = '{{ComponentName}}';
```

#### Custom Hook Template

```typescript
import { useState, useEffect } from 'react';

interface Use{{HookName}}Options {
  // Define hook options
}

interface Use{{HookName}}Return {
  // Define return type
}

export const use{{HookName}} = (options: Use{{HookName}}Options): Use{{HookName}}Return => {
  // Hook implementation

  return {
    // Return values
  };
};
```

#### API Route Template

```typescript
import { NextRequest, NextResponse } from 'next/server';
import { z } from 'zod';

const {{RequestSchema}} = z.object({
  // Define request schema
});

export async function GET(request: NextRequest) {
  try {
    // Implementation
    return NextResponse.json({ success: true });
  } catch (error) {
    return NextResponse.json(
      { error: 'Internal server error' },
      { status: 500 }
    );
  }
}
```

### 4. Scaffolding Configuration

#### Template Customization

```json
{
  "scaffolding": {
    "templates": {
      "component": "./templates/component.hbs",
      "hook": "./templates/hook.hbs",
      "api": "./templates/api.hbs"
    },
    "outputPaths": {
      "components": "src/components",
      "hooks": "src/hooks",
      "pages": "src/pages",
      "api": "src/api"
    },
    "naming": {
      "convention": "PascalCase",
      "suffixes": {
        "components": "Component",
        "hooks": "Hook",
        "services": "Service"
      }
    }
  }
}
```

#### Code Style Preferences

- TypeScript strict mode compliance
- Functional components with hooks
- Props interfaces for all components
- JSDoc documentation for public APIs
- Consistent import organization
- Tailwind CSS for styling

### 5. Advanced Scaffolding

#### Feature Generation

```bash
# Complete feature with all layers
npm run scaffold:feature UserManagement --include="components,hooks,api,types,tests"

# CRUD operations for entity
npm run scaffold:crud Product --fields="name,price,description,category"

# Authentication flow
npm run scaffold:auth --provider="next-auth" --strategies="email,oauth"
```

#### Test Generation

```bash
# Unit tests for component
npm run scaffold:test MyComponent --type="unit"

# Integration tests for API
npm run scaffold:test /api/users --type="integration"

# E2E test scenarios
npm run scaffold:test UserFlow --type="e2e"
```

### 6. Quality Assurance

#### Generated Code Standards

- All generated code must compile without errors
- TypeScript strict mode compliance
- ESLint and Prettier formatting
- Consistent naming conventions
- Proper import statements and dependencies

#### Validation Process

```bash
# Validate generated code
npm run lint
npm run type-check
npm run test --changed

# Format generated code
npm run format
```

### 7. File Organization

#### Directory Structure

```
src/
├── components/
│   ├── ui/           # Shadcn UI components
│   ├── forms/        # Form components
│   ├── layout/       # Layout components
│   └── features/     # Feature-specific components
├── hooks/
│   ├── api/          # API-related hooks
│   ├── ui/           # UI utility hooks
│   └── business/     # Business logic hooks
├── lib/
│   ├── utils/        # Utility functions
│   ├── schemas/      # Validation schemas
│   └── services/     # Service implementations
└── types/
    ├── api/          # API type definitions
    └── models/       # Data model types
```

#### Naming Conventions

- Components: PascalCase (UserProfile.tsx)
- Hooks: camelCase with 'use' prefix (useUserData.ts)
- Utilities: camelCase (formatDate.ts)
- Types: PascalCase with descriptive suffixes (UserData.types.ts)

### 8. Documentation Generation

#### Automatic Documentation

```bash
# Generate component documentation
npm run docs:components

# Create API documentation
npm run docs:api

# Generate type documentation
npm run docs:types
```

#### Documentation Templates

- Component props documentation
- Hook usage examples
- API endpoint specifications
- Type definitions with examples
- Integration guides

## Implementation Examples

### Component Scaffolding

```bash
# Generate a form component
npm run scaffold:component ContactForm --type="form" --fields="name,email,message"

# Output: src/components/forms/ContactForm.tsx
# Includes: Props interface, validation, form handling, accessibility
```

### API Scaffolding

```bash
# Generate CRUD API for products
npm run scaffold:api products --crud --validation

# Output: Multiple API route files with full CRUD operations
# Includes: Request validation, error handling, TypeScript types
```

## Best Practices

- Follow established project patterns and conventions
- Generate comprehensive TypeScript types and interfaces
- Include proper error handling and validation
- Add accessibility attributes for UI components
- Include comprehensive JSDoc documentation
- Generate corresponding test files when appropriate
- Maintain consistency with existing codebase structure

## Integration

Use this command for:

- Rapid prototyping and development acceleration
- Maintaining consistency across team implementations
- Onboarding new team members with standardized patterns
- Creating foundation code for new features
- Establishing project-wide coding conventions
- Reducing boilerplate code repetition

## Success Criteria

- Generated code follows project coding standards
- All TypeScript types are properly defined
- Components include proper props interfaces
- Error handling is comprehensive and consistent
- Documentation is complete and accurate
- Generated tests provide adequate coverage
- Code is immediately usable with minimal modifications
