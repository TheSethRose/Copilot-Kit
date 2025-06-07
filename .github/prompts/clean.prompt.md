---
description: "Comprehensive project cleanup to remove build artifacts, outdated dependencies, unused code, and optimize project structure"
---

# Project Cleanup & Maintenance

Apply the [general coding guidelines](./general.instructions.md) to all cleanup operations.

**Command:** `/clean`

## Purpose

Comprehensive project cleanup to remove build artifacts, outdated dependencies, unused code, and optimize project structure for development and production environments.

## Usage

```
/clean [scope] [options]
```

**Examples:**

- `/clean all --deep-clean`
- `/clean build --remove-artifacts`
- `/clean deps --update-lockfile`
- `/clean code --remove-unused`
- `/clean cache --clear-all`

## Methodology

### 1. Cleanup Categories

#### Build Artifacts

- Remove compiled JavaScript files
- Clear TypeScript build cache
- Clean Vite build outputs
- Remove temporary build files
- Clear source map files

#### Dependencies & Cache

- Clean node_modules directory
- Clear package manager caches
- Remove outdated lockfiles
- Clean browser caches during development
- Clear TypeScript incremental cache

#### Code Quality

- Remove unused imports and exports
- Identify and remove dead code
- Clean up commented-out code
- Remove debugging console statements
- Optimize import statements

#### Development Files

- Clean temporary development files
- Remove editor-specific files
- Clear log files and debugging outputs
- Remove test coverage artifacts
- Clean profiling and performance data

### 2. Cleanup Commands

#### Basic Cleanup

```bash
# Clean build artifacts
npm run clean:build

# Clean node_modules and reinstall
npm run clean:deps

# Clean all caches
npm run clean:cache

# Full cleanup (everything)
npm run clean:all
```

#### Specific Cleanup Operations

```bash
# TypeScript cleanup
npm run clean:ts

# Vite cleanup
npm run clean:vite

# Test artifacts cleanup
npm run clean:test

# Log files cleanup
npm run clean:logs
```

#### Advanced Cleanup

```bash
# Remove unused dependencies
npm run clean:unused-deps

# Clean dead code
npm run clean:dead-code

# Optimize imports
npm run clean:imports

# Clean generated files
npm run clean:generated
```

### 3. Automated Cleanup Scripts

#### Pre-commit Cleanup

```bash
#!/bin/bash
# .scripts/pre-commit-clean.sh

echo "Running pre-commit cleanup..."

# Remove debugging statements
npm run clean:debug

# Optimize imports
npm run clean:imports

# Format code
npm run format

# Lint and fix
npm run lint:fix

echo "Pre-commit cleanup complete"
```

#### Build Cleanup

```bash
#!/bin/bash
# .scripts/build-clean.sh

echo "Cleaning for production build..."

# Remove development files
rm -rf src/**/*.dev.*
rm -rf src/**/*.test.*
rm -rf src/**/__tests__/

# Clean build directory
rm -rf dist
rm -rf .vite

# Clear caches
npm run clean:cache

echo "Build cleanup complete"
```

### 4. Code Quality Cleanup

#### Unused Code Detection

```bash
# Find unused exports
npm run analyze:unused-exports

# Find unused files
npm run analyze:unused-files

# Find unused dependencies
npm run analyze:unused-deps

# Dead code elimination
npm run clean:dead-code
```

#### Import Optimization

```bash
# Organize imports
npm run clean:imports

# Remove unused imports
npm run clean:unused-imports

# Optimize import paths
npm run clean:import-paths

# Sort imports consistently
npm run format:imports
```

### 5. Dependency Management

#### Dependency Cleanup

```bash
# Remove unused dependencies
npm run deps:unused

# Update dependencies to latest
npm run deps:update

# Audit and fix vulnerabilities
npm run deps:audit

# Deduplicate dependencies
npm run deps:dedupe
```

#### Security Cleanup

```bash
# Remove packages with vulnerabilities
npm run security:clean

# Update vulnerable dependencies
npm run security:update

# Clean sensitive data from logs
npm run clean:sensitive
```

### 6. File System Cleanup

#### Temporary Files

```bash
# Remove temporary files
find . -name "*.tmp" -delete
find . -name "*.temp" -delete
find . -name ".DS_Store" -delete

# Clean editor files
find . -name "*.swp" -delete
find . -name "*.swo" -delete
find . -name "*~" -delete
```

#### Large Files & Directories

```bash
# Find large files
find . -size +10M -type f

# Find large directories
du -sh */ | sort -hr | head -10

# Clean large log files
find . -name "*.log" -size +1M -delete
```

### 7. Development Environment Cleanup

#### Cache Directories

```bash
# Clear all caches
rm -rf node_modules/.cache
rm -rf .vite
rm -rf .turbo
rm -rf .next (if applicable)

# Browser cache clearing instructions
echo "Clear browser cache and dev tools cache"
```

#### Database Cleanup (if applicable)

```bash
# Clean test databases
npm run db:clean:test

# Remove migration artifacts
npm run db:clean:migrations

# Clear development seeds
npm run db:clean:seeds
```

### 8. Monitoring & Reporting

#### Cleanup Metrics

```bash
# Measure cleanup impact
du -sh . > before-cleanup.txt
# ... run cleanup ...
du -sh . > after-cleanup.txt

# Generate cleanup report
npm run clean:report
```

#### Cleanup Report Format

```markdown
## Cleanup Report

### Summary

- Total space reclaimed: [size]
- Files removed: [count]
- Dependencies cleaned: [count]
- Build time improvement: [percentage]

### Details

#### Build Artifacts

- Removed: [list of artifact types]
- Space saved: [size]

#### Dependencies

- Unused packages removed: [list]
- Vulnerabilities fixed: [count]
- Cache cleared: [size]

#### Code Quality

- Unused imports removed: [count]
- Dead code eliminated: [lines]
- Import statements optimized: [count]

### Recommendations

- [List of ongoing maintenance suggestions]
```

### 9. Automation & Scheduling

#### Automated Cleanup

```bash
# Daily cleanup script
# .scripts/daily-clean.sh
npm run clean:cache
npm run clean:logs
npm run clean:temp

# Weekly cleanup script
# .scripts/weekly-clean.sh
npm run clean:unused-deps
npm run clean:dead-code
npm run deps:audit
```

#### CI/CD Integration

```yaml
# .github/workflows/cleanup.yml
name: Weekly Cleanup
on:
  schedule:
    - cron: "0 2 * * 0" # Every Sunday at 2 AM
jobs:
  cleanup:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v3
      - run: npm install
      - run: npm run clean:all
      - run: npm run analyze:unused
```

### 10. Safety Measures

#### Backup Before Cleanup

```bash
# Create backup before major cleanup
tar -czf backup-$(date +%Y%m%d).tar.gz \
  --exclude=node_modules \
  --exclude=dist \
  --exclude=.git \
  .
```

#### Confirmation Prompts

```bash
# Interactive cleanup with confirmations
npm run clean:interactive

# Force cleanup (no prompts)
npm run clean:force

# Dry run (show what would be cleaned)
npm run clean:dry-run
```

## Implementation Workflow

### 1. Assessment Phase

```bash
# Analyze current state
npm run analyze:project-size
npm run analyze:unused
npm run deps:audit
```

### 2. Selective Cleanup

```bash
# Start with safe cleanup
npm run clean:cache
npm run clean:build
npm run clean:logs
```

### 3. Deep Cleanup

```bash
# More aggressive cleanup
npm run clean:unused-deps
npm run clean:dead-code
npm run clean:imports
```

### 4. Verification

```bash
# Verify everything still works
npm run build
npm run test
npm run lint
```

## Success Criteria

- Significant reduction in project size
- Improved build and development performance
- All tests continue to pass after cleanup
- No functionality is lost during cleanup
- Development environment remains stable
- Security vulnerabilities are addressed
- Code quality metrics improve
- Cleanup process is documented and repeatable
