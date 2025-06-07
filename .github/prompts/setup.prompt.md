---
mode: agent
---

# /setup - React TypeScript Portfolio Project Setup

You are a senior project setup specialist for React TypeScript portfolio applications. When the `/setup` command is invoked, execute comprehensive project initialization following the mandatory analysis framework and setup methodology.

**Command:** `/setup`

## Usage

```
/setup [project-type] [options]
```

**Examples:**

- `/setup portfolio --with-shadcn --analytics`
- `/setup blog --cms-integration --seo-optimized`
- `/setup dashboard --auth-required --data-visualization`
- `/setup landing-page --conversion-focused --a11y-compliant`
- `/setup e-commerce --payment-integration --inventory-management`

## When to Use

This command is ideal for:

- 🆕 **New project initialization** - Setting up portfolio, blog, or dashboard projects
- 🔧 **Development environment configuration** - Installing and configuring tools
- 📦 **Dependency management** - Setting up the complete tech stack
- 🎨 **UI framework integration** - Configuring Tailwind, Shadcn/UI, and styling
- ⚙️ **Build tool optimization** - Vite configuration and performance tuning
- 🧪 **Testing infrastructure** - Setting up Jest, Testing Library, and testing workflows

## MANDATORY ANALYSIS FRAMEWORK

Before any setup implementation:

1. **OBJECTIVE**: Restate the project setup goal in technical terms
2. **CONSTRAINTS**: Identify technical/business limitations affecting setup
3. **COMPLEXITY**: Rate 1-10 with justification for the setup effort
4. **APPROACH**: Detail step-by-step setup plan in pseudocode
5. **CONFIDENCE**: X/10 with rationale for setup approach
6. **ALTERNATIVES**: What other setup approaches were considered

## COMPREHENSIVE PROJECT SETUP METHODOLOGY

Execute in this exact order:

1. **ENVIRONMENT PREPARATION**: Ensure system requirements and tools
2. **PROJECT INITIALIZATION**: Create base project structure
3. **DEPENDENCY INSTALLATION**: Install and configure dependencies
4. **CONFIGURATION SETUP**: Configure tools and build systems
5. **DEVELOPMENT ENVIRONMENT**: Set up development tools and workflows
6. **TESTING SETUP**: Configure testing frameworks and utilities
7. **VERIFICATION**: Test the complete setup and ensure everything works

## PROJECT SETUP CATEGORIES

### System Requirements Check

- Node.js version compatibility (18+ recommended)
- npm/yarn package manager
- Git version control
- VS Code or preferred IDE
- Required VS Code extensions

### Base Project Structure

- React + TypeScript + Vite foundation
- Tailwind CSS for styling
- Shadcn UI component library
- File organization and conventions
- Environment configuration

## SETUP COMMANDS & PROCEDURES

### 1. Environment Verification

```bash
# Check Node.js version (18+ required)
node --version

# Check npm version
npm --version

# Check Git configuration
git --version
git config --global user.name
git config --global user.email

# Verify VS Code installation
code --version
```

### 2. Project Initialization

```bash
# Create new Vite React TypeScript project
npm create vite@latest portfolio-project -- --template react-ts

# Navigate to project directory
cd portfolio-project

# Initialize git repository
git init

# Create initial commit
git add .
git commit -m "feat(init): initialize React TypeScript portfolio project"
```

### 3. Core Dependencies Installation

```bash
# Install core dependencies
npm install

# Install Tailwind CSS and PostCSS
npm install -D tailwindcss postcss autoprefixer
npx tailwindcss init -p

# Install Shadcn UI
npx shadcn-ui@latest init

# Install React Router for navigation
npm install react-router-dom
npm install -D @types/react-router-dom

# Install utility libraries
npm install clsx tailwind-merge
npm install lucide-react

# Install form handling
npm install react-hook-form @hookform/resolvers zod
```

### 4. Development Dependencies

```bash
# ESLint and Prettier setup
npm install -D eslint @typescript-eslint/eslint-plugin @typescript-eslint/parser
npm install -D prettier eslint-config-prettier eslint-plugin-prettier
npm install -D eslint-plugin-react eslint-plugin-react-hooks

# Testing framework
npm install -D vitest @testing-library/react @testing-library/jest-dom
npm install -D @testing-library/user-event jsdom

# Additional development tools
npm install -D @types/node
```

### 5. Configuration Files Setup

#### Tailwind Configuration (tailwind.config.ts)

```typescript
import type { Config } from "tailwindcss";

const config: Config = {
  darkMode: ["class"],
  content: [
    "./pages/**/*.{ts,tsx}",
    "./components/**/*.{ts,tsx}",
    "./app/**/*.{ts,tsx}",
    "./src/**/*.{ts,tsx}",
  ],
  theme: {
    extend: {
      // Shadcn UI theme extensions
    },
  },
  plugins: [require("tailwindcss-animate")],
};

export default config;
```

#### TypeScript Configuration (tsconfig.json)

```json
{
  "compilerOptions": {
    "target": "ES2020",
    "useDefineForClassFields": true,
    "lib": ["ES2020", "DOM", "DOM.Iterable"],
    "module": "ESNext",
    "skipLibCheck": true,
    "moduleResolution": "bundler",
    "allowImportingTsExtensions": true,
    "resolveJsonModule": true,
    "isolatedModules": true,
    "noEmit": true,
    "jsx": "react-jsx",
    "strict": true,
    "noUnusedLocals": true,
    "noUnusedParameters": true,
    "noFallthroughCasesInSwitch": true,
    "baseUrl": ".",
    "paths": {
      "@/*": ["./src/*"]
    }
  },
  "include": ["src"],
  "references": [{ "path": "./tsconfig.node.json" }]
}
```

#### ESLint Configuration (.eslintrc.js)

```javascript
module.exports = {
  root: true,
  env: { browser: true, es2020: true },
  extends: [
    "eslint:recommended",
    "@typescript-eslint/recommended",
    "plugin:react-hooks/recommended",
    "prettier",
  ],
  ignorePatterns: ["dist", ".eslintrc.js"],
  parser: "@typescript-eslint/parser",
  plugins: ["react-refresh"],
  rules: {
    "react-refresh/only-export-components": [
      "warn",
      { allowConstantExport: true },
    ],
    "@typescript-eslint/no-explicit-any": "error",
  },
};
```

### 6. Project Structure Creation

```bash
# Create standard directory structure
mkdir -p src/{components,pages,hooks,lib,types}
mkdir -p src/components/ui
mkdir -p public/{images,icons}
mkdir -p docs
mkdir -p .github/{workflows,instructions,prompts}

# Create essential files
touch src/components/index.ts
touch src/types/index.ts
touch src/lib/utils.ts
touch README.md
touch .env.local
touch .env.example
```

### 7. Essential File Templates

#### Utility Functions (src/lib/utils.ts)

```typescript
import { type ClassValue, clsx } from "clsx";
import { twMerge } from "tailwind-merge";

export function cn(...inputs: ClassValue[]) {
  return twMerge(clsx(inputs));
}
```

#### Main App Component (src/App.tsx)

```typescript
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { Index } from "./pages/Index";
import { NotFound } from "./pages/NotFound";
import "./App.css";

function App() {
  return (
    <Router>
      <div className="min-h-screen bg-background">
        <Routes>
          <Route path="/" element={<Index />} />
          <Route path="*" element={<NotFound />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
```

### 8. Package.json Scripts Setup

```json
{
  "scripts": {
    "dev": "vite",
    "build": "tsc && vite build",
    "preview": "vite preview",
    "lint": "eslint . --ext ts,tsx --report-unused-disable-directives --max-warnings 0",
    "lint:fix": "eslint . --ext ts,tsx --fix",
    "format": "prettier --write \"src/**/*.{ts,tsx,json,css,md}\"",
    "type-check": "tsc --noEmit",
    "test": "vitest",
    "test:ui": "vitest --ui",
    "test:coverage": "vitest run --coverage"
  }
}
```

### 9. Environment Configuration

#### .env.example

```bash
# Development
VITE_APP_NAME="Portfolio Project"
VITE_APP_VERSION="1.0.0"
VITE_APP_ENVIRONMENT="development"

# API Configuration (if needed)
# VITE_API_URL="http://localhost:3001"
# VITE_API_KEY=""

# Analytics (if needed)
# VITE_GOOGLE_ANALYTICS_ID=""
```

### 10. Testing Setup

#### Vitest Configuration (vitest.config.ts)

```typescript
import { defineConfig } from "vitest/config";
import react from "@vitejs/plugin-react";
import path from "path";

export default defineConfig({
  plugins: [react()],
  test: {
    globals: true,
    environment: "jsdom",
    setupFiles: ["./src/test/setup.ts"],
  },
  resolve: {
    alias: {
      "@": path.resolve(__dirname, "./src"),
    },
  },
});
```

## VERIFICATION CHECKLIST

### Development Environment

- [ ] Node.js 18+ installed and configured
- [ ] Git repository initialized with proper configuration
- [ ] VS Code with recommended extensions installed
- [ ] All dependencies installed without errors
- [ ] TypeScript compilation successful

### Project Structure

- [ ] Standard directory structure created
- [ ] Essential configuration files in place
- [ ] Environment variables properly configured
- [ ] Package.json scripts functional
- [ ] Git ignore file configured

### Build System

- [ ] Development server starts successfully (`npm run dev`)
- [ ] Production build completes without errors (`npm run build`)
- [ ] Linting passes without errors (`npm run lint`)
- [ ] Type checking passes (`npm run type-check`)
- [ ] Tests run successfully (`npm test`)

### Component System

- [ ] Shadcn UI components can be added successfully
- [ ] Tailwind CSS styling works correctly
- [ ] React Router navigation functional
- [ ] TypeScript strict mode enabled and working

## POST-SETUP TASKS

### Immediate Next Steps

1. Add initial components (Header, Footer, Layout)
2. Set up basic routing structure
3. Configure SEO meta tags
4. Set up error boundaries
5. Add loading states and error handling

### Development Workflow Setup

1. Configure Git hooks for pre-commit checks
2. Set up CI/CD pipeline (GitHub Actions)
3. Configure deployment environment
4. Set up monitoring and analytics
5. Create documentation structure

## TASK MANAGEMENT INTEGRATION

### Setup Task Creation

- Create tasks for each major setup milestone
- Track configuration file updates and validations
- Monitor dependency installation and updates
- Document setup decisions and configurations

### Documentation Requirements

- Update README with setup instructions
- Document environment variable requirements
- Create development workflow documentation
- Maintain setup troubleshooting guide

This setup framework ensures a robust, scalable foundation for React TypeScript portfolio development with modern best practices and tooling.
