---
description: "Comprehensive performance analysis and optimization for React TypeScript applications covering runtime and development workflow"
---

# Performance Analysis & Optimization

Apply the [general coding guidelines](./general.instructions.md) and [TypeScript React guidelines](./typescript-react.instructions.md) to all performance optimizations.

**Command:** `/perf`

## Purpose

Comprehensive performance analysis and optimization recommendations for the React TypeScript application, covering both runtime performance and development workflow optimization.

## Usage

```
/perf [scope] [options]
```

**Examples:**

- `/perf analyze --full-audit`
- `/perf bundle --size-analysis`
- `/perf runtime --check-components`
- `/perf build --optimize-pipeline`
- `/perf network --resource-optimization`

## When to Use

This command is ideal for:

- 📊 **Performance audits** - Comprehensive application performance analysis
- 📦 **Bundle optimization** - Reducing JavaScript bundle sizes and load times
- ⚡ **Runtime optimization** - Component re-rendering and memory usage optimization
- 🔄 **Build performance** - Speeding up development and CI/CD build times
- 🌐 **Network optimization** - Resource loading and caching strategies
- 📱 **Mobile performance** - Ensuring optimal performance on mobile devices

## Methodology

### 1. Performance Audit Framework

#### Bundle Analysis

- Analyze bundle size and identify heavy dependencies
- Check for code splitting opportunities
- Identify unused code and tree-shaking effectiveness
- Review dynamic imports and lazy loading implementation

#### Runtime Performance

- Measure Core Web Vitals (LCP, FID, CLS)
- Analyze React component re-render patterns
- Identify memory leaks and unnecessary computations
- Review network waterfall and resource loading

#### Build Performance

- Measure build times and identify bottlenecks
- Analyze TypeScript compilation performance
- Review Vite configuration optimization
- Check development server performance

### 2. Analysis Tools & Commands

```bash
# Bundle analysis
npm run build -- --analyze
npx vite-bundle-analyzer dist

# Performance profiling
npm run preview
# Use browser DevTools Performance tab

# Lighthouse audit
npx lighthouse http://localhost:4173 --output=json --output-path=./perf-audit.json

# Bundle size tracking
npx bundlesize
```

### 3. Performance Checklist

#### React Optimization

- [ ] Implement React.memo for expensive components
- [ ] Use useMemo/useCallback for expensive computations
- [ ] Optimize context providers to prevent unnecessary re-renders
- [ ] Implement proper key props for list items
- [ ] Check for unnecessary effect dependencies

#### Assets & Resources

- [ ] Optimize images (WebP, proper sizing, lazy loading)
- [ ] Implement font optimization strategies
- [ ] Review and optimize SVG assets
- [ ] Check for unused CSS and JavaScript

#### Network & Caching

- [ ] Implement proper HTTP caching headers
- [ ] Use service workers for caching strategies
- [ ] Optimize API requests (batching, deduplication)
- [ ] Review third-party script loading

#### Code Splitting

- [ ] Implement route-based code splitting
- [ ] Split vendor bundles appropriately
- [ ] Use dynamic imports for heavy components
- [ ] Optimize chunk splitting strategy

### 4. Metrics & Monitoring

#### Key Performance Indicators

- First Contentful Paint (FCP) < 1.8s
- Largest Contentful Paint (LCP) < 2.5s
- First Input Delay (FID) < 100ms
- Cumulative Layout Shift (CLS) < 0.1
- Total bundle size < 250KB (gzipped)

#### Development Metrics

- TypeScript compilation time
- Hot reload performance
- Build time optimization
- Test execution speed

### 5. Optimization Strategies

#### Immediate Wins

1. Enable Vite's built-in optimizations
2. Implement proper image optimization
3. Add React.memo to frequently re-rendering components
4. Optimize import statements and remove unused code

#### Advanced Optimizations

1. Implement virtual scrolling for large lists
2. Use Web Workers for heavy computations
3. Implement sophisticated caching strategies
4. Optimize CSS delivery and critical path

#### Monitoring Setup

1. Set up performance budgets in CI/CD
2. Implement performance monitoring in production
3. Create automated performance regression tests
4. Set up alerts for performance degradation

### 6. Reporting Format

#### Performance Report Structure

```markdown
## Performance Analysis Report

### Executive Summary

- Overall performance score
- Critical issues identified
- Estimated impact of optimizations

### Detailed Findings

1. Bundle Analysis Results
2. Runtime Performance Issues
3. Build Performance Bottlenecks
4. Network & Resource Optimization

### Recommendations

1. High Impact, Low Effort
2. Medium Impact, Medium Effort
3. High Impact, High Effort

### Implementation Plan

- Phase 1: Quick wins (1-2 days)
- Phase 2: Medium-term improvements (1-2 weeks)
- Phase 3: Long-term optimizations (1+ months)

### Metrics Tracking

- Before/after performance metrics
- Monitoring setup recommendations
- Success criteria definition
```

## Implementation Notes

- Run performance analysis in production-like environment
- Use both synthetic and real user monitoring
- Consider mobile and low-end device performance
- Test performance across different network conditions
- Document baseline metrics before optimization
- Implement gradual rollout for performance changes

## Success Criteria

- Achieve target Core Web Vitals scores
- Reduce bundle size by specified percentage
- Improve build times by measurable amount
- Establish performance monitoring workflow
- Create actionable optimization roadmap
