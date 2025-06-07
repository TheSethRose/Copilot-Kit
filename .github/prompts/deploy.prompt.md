---
description: "Comprehensive deployment procedures for React TypeScript portfolio applications with environment management"
---

# /deploy - React TypeScript Portfolio Deployment

Apply the [general coding guidelines](./general.instructions.md) and [TypeScript React guidelines](./typescript-react.instructions.md) to all deployment operations.

You are a senior deployment specialist for React TypeScript portfolio applications. When the `/deploy` command is invoked, execute comprehensive deployment procedures following the mandatory analysis framework and deployment methodology.

**Command:** `/deploy`

## Usage

```
/deploy [environment] [platform] [options]
```

**Examples:**

- `/deploy production vercel --optimize-build`
- `/deploy staging netlify --preview-mode`
- `/deploy development docker --hot-reload`
- `/deploy testing github-pages --static-site`
- `/deploy production aws-s3 --cdn-enabled`

## When to Use

This command is ideal for:

- 🚀 **Production deployments** - Live website launches with optimization
- 🧪 **Staging environments** - Testing deployments before production
- 🔄 **CI/CD pipeline setup** - Automated deployment configuration
- 🌐 **Platform migrations** - Moving between hosting providers
- 📊 **Performance optimization** - Build and deployment speed improvements
- 🔒 **Security hardening** - Deployment security configuration and validation

## MANDATORY ANALYSIS FRAMEWORK

Before any deployment implementation:

1. **OBJECTIVE**: Restate the deployment goal in technical terms
2. **CONSTRAINTS**: Identify technical/business limitations affecting deployment
3. **COMPLEXITY**: Rate 1-10 with justification for the deployment effort
4. **APPROACH**: Detail step-by-step deployment plan in pseudocode
5. **CONFIDENCE**: X/10 with rationale for deployment approach
6. **ALTERNATIVES**: What other deployment strategies were considered

## COMPREHENSIVE DEPLOYMENT METHODOLOGY

Execute in this exact order:

1. **PRE-DEPLOYMENT CHECKS**: Validate code quality and build integrity
2. **ENVIRONMENT PREPARATION**: Configure deployment environment and dependencies
3. **BUILD OPTIMIZATION**: Create optimized production build
4. **SECURITY VALIDATION**: Verify security configurations and credentials
5. **DEPLOYMENT EXECUTION**: Deploy to target environment with safety checks
6. **POST-DEPLOYMENT VERIFICATION**: Validate deployment success and functionality
7. **MONITORING SETUP**: Enable monitoring and alerting for the deployed application

## DEPLOYMENT ENVIRONMENT TYPES

### Static Site Hosting (Recommended for Portfolio)

- **Vercel**: Optimal for React applications with automatic deployments
- **Netlify**: Great for static sites with form handling capabilities
- **GitHub Pages**: Free hosting for open source projects
- **AWS S3 + CloudFront**: Scalable solution with CDN

### Traditional Hosting

- **VPS/Dedicated Server**: Full control with Nginx/Apache
- **Docker Container**: Containerized deployment with Docker
- **Cloud Platforms**: AWS, Google Cloud, Azure

## PRE-DEPLOYMENT CHECKLIST

### Code Quality Validation

```bash
# TypeScript compilation check
npm run type-check

# Linting validation
npm run lint

# Run all tests
npm test

# Security audit
npm audit

# Build verification
npm run build
```

### Environment Configuration

```bash
# Verify environment variables
env | grep VITE_

# Check production environment file
cat .env.production

# Validate API endpoints
curl -I $VITE_API_URL/health

# Check SSL certificates (if applicable)
openssl s_client -connect yourdomain.com:443 -servername yourdomain.com
```

## DEPLOYMENT PROCEDURES

### Vercel Deployment (Recommended)

#### Initial Setup

```bash
# Install Vercel CLI
npm i -g vercel

# Login to Vercel
vercel login

# Initialize project
vercel

# Configure build settings
vercel env add VITE_APP_NAME
vercel env add VITE_API_URL
```

#### Production Deployment

```bash
# Deploy to production
vercel --prod

# Verify deployment
vercel inspect [deployment-url]

# Check deployment logs
vercel logs [deployment-url]
```

#### Vercel Configuration (vercel.json)

```json
{
  "buildCommand": "npm run build",
  "outputDirectory": "dist",
  "framework": "vite",
  "redirects": [
    {
      "source": "/(.*)",
      "destination": "/index.html",
      "statusCode": 404
    }
  ],
  "headers": [
    {
      "source": "/(.*)",
      "headers": [
        {
          "key": "X-Frame-Options",
          "value": "DENY"
        },
        {
          "key": "X-Content-Type-Options",
          "value": "nosniff"
        },
        {
          "key": "Referrer-Policy",
          "value": "strict-origin-when-cross-origin"
        }
      ]
    }
  ]
}
```

### Netlify Deployment

#### Setup via Git

```bash
# Install Netlify CLI
npm install -g netlify-cli

# Login to Netlify
netlify login

# Initialize site
netlify init

# Configure build settings
netlify env:set VITE_APP_NAME "Portfolio Project"
```

#### Netlify Configuration (\_redirects)

```
/*    /index.html   200
```

#### Netlify Configuration (netlify.toml)

```toml
[build]
  publish = "dist"
  command = "npm run build"

[build.environment]
  NODE_VERSION = "18"

[[headers]]
  for = "/*"
  [headers.values]
    X-Frame-Options = "DENY"
    X-XSS-Protection = "1; mode=block"
    X-Content-Type-Options = "nosniff"
    Referrer-Policy = "strict-origin-when-cross-origin"

[[headers]]
  for = "/assets/*"
  [headers.values]
    Cache-Control = "public, max-age=31536000, immutable"
```

### GitHub Pages Deployment

#### GitHub Actions Workflow (.github/workflows/deploy.yml)

```yaml
name: Deploy to GitHub Pages

on:
  push:
    branches: [main]
  pull_request:
    branches: [main]

jobs:
  build-and-deploy:
    runs-on: ubuntu-latest

    steps:
      - name: Checkout
        uses: actions/checkout@v3

      - name: Setup Node.js
        uses: actions/setup-node@v3
        with:
          node-version: "18"
          cache: "npm"

      - name: Install dependencies
        run: npm ci

      - name: Run tests
        run: npm test

      - name: Build project
        run: npm run build
        env:
          VITE_APP_NAME: ${{ secrets.VITE_APP_NAME }}

      - name: Deploy to GitHub Pages
        uses: peaceiris/actions-gh-pages@v3
        if: github.ref == 'refs/heads/main'
        with:
          github_token: ${{ secrets.GITHUB_TOKEN }}
          publish_dir: ./dist
```

### Docker Deployment

#### Dockerfile

```dockerfile
# Build stage
FROM node:18-alpine as build
WORKDIR /app
COPY package*.json ./
RUN npm ci --only=production
COPY . .
RUN npm run build

# Production stage
FROM nginx:alpine
COPY --from=build /app/dist /usr/share/nginx/html
COPY nginx.conf /etc/nginx/nginx.conf
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
```

#### Nginx Configuration (nginx.conf)

```nginx
events {
    worker_connections 1024;
}

http {
    include       /etc/nginx/mime.types;
    default_type  application/octet-stream;

    server {
        listen 80;
        server_name localhost;
        root /usr/share/nginx/html;
        index index.html;

        # Security headers
        add_header X-Frame-Options "DENY";
        add_header X-Content-Type-Options "nosniff";
        add_header X-XSS-Protection "1; mode=block";

        # Handle client-side routing
        location / {
            try_files $uri $uri/ /index.html;
        }

        # Cache static assets
        location /assets/ {
            expires 1y;
            add_header Cache-Control "public, immutable";
        }
    }
}
```

## BUILD OPTIMIZATION

### Production Build Configuration

#### Vite Configuration (vite.config.ts)

```typescript
import { defineConfig } from "vite";
import react from "@vitejs/plugin-react";
import path from "path";

export default defineConfig({
  plugins: [react()],
  resolve: {
    alias: {
      "@": path.resolve(__dirname, "./src"),
    },
  },
  build: {
    outDir: "dist",
    sourcemap: false,
    minify: "terser",
    rollupOptions: {
      output: {
        manualChunks: {
          vendor: ["react", "react-dom"],
          router: ["react-router-dom"],
        },
      },
    },
  },
  define: {
    "process.env.NODE_ENV": '"production"',
  },
});
```

### Performance Optimization

```bash
# Analyze bundle size
npx vite-bundle-analyzer

# Check for unused dependencies
npx depcheck

# Optimize images (if using)
npx imagemin src/assets/**/*.{jpg,png} --out-dir=src/assets/optimized

# Generate sitemap (if SEO important)
npx next-sitemap
```

## POST-DEPLOYMENT VERIFICATION

### Automated Testing

```bash
# Test deployed site accessibility
npx lighthouse https://yourdomain.com --only-categories=accessibility

# Performance testing
npx lighthouse https://yourdomain.com --only-categories=performance

# SEO validation
npx lighthouse https://yourdomain.com --only-categories=seo

# Best practices check
npx lighthouse https://yourdomain.com --only-categories=best-practices
```

### Manual Verification Checklist

- [ ] **Site Accessibility**: All pages load correctly
- [ ] **Navigation**: All routes work as expected
- [ ] **Forms**: Contact forms and interactions functional
- [ ] **Responsive Design**: Mobile and desktop layouts correct
- [ ] **Performance**: Page load times acceptable (<3 seconds)
- [ ] **SEO**: Meta tags and structured data present
- [ ] **Security**: HTTPS enabled and security headers set
- [ ] **Analytics**: Tracking code functional (if applicable)

### Monitoring Setup

```bash
# Set up uptime monitoring
curl -X POST "https://api.uptimerobot.com/v2/newMonitor" \
  -d "api_key=YOUR_API_KEY" \
  -d "format=json" \
  -d "type=1" \
  -d "url=https://yourdomain.com" \
  -d "friendly_name=Portfolio Site"

# Configure error tracking (example with Sentry)
npm install @sentry/react @sentry/tracing
```

## ROLLBACK PROCEDURES

### Vercel Rollback

```bash
# List deployments
vercel ls

# Rollback to previous deployment
vercel rollback [deployment-url]

# Promote specific deployment
vercel promote [deployment-url]
```

### Git-based Rollback

```bash
# Create rollback branch
git checkout -b rollback-to-stable

# Reset to last known good commit
git reset --hard [commit-hash]

# Force push to trigger redeployment
git push origin rollback-to-stable --force
```

## DEPLOYMENT SECURITY

### Environment Variables

- Never commit sensitive data to repository
- Use platform-specific environment variable management
- Rotate API keys and tokens regularly
- Validate all environment variables before deployment

### Security Headers

```javascript
// Security headers configuration
const securityHeaders = [
  { key: "X-DNS-Prefetch-Control", value: "on" },
  {
    key: "Strict-Transport-Security",
    value: "max-age=63072000; includeSubDomains; preload",
  },
  { key: "X-XSS-Protection", value: "1; mode=block" },
  { key: "X-Frame-Options", value: "SAMEORIGIN" },
  { key: "X-Content-Type-Options", value: "nosniff" },
  { key: "Referrer-Policy", value: "strict-origin-when-cross-origin" },
];
```

## TASK MANAGEMENT INTEGRATION

### Deployment Task Creation

- Create deployment checklist tasks
- Track environment configuration updates
- Monitor deployment pipeline health
- Document deployment procedures and troubleshooting

### Documentation Requirements

- Update deployment documentation
- Maintain environment variable inventory
- Document rollback procedures
- Create deployment troubleshooting guide

This deployment framework ensures safe, reliable, and optimized deployment of React TypeScript portfolio applications with comprehensive verification and monitoring.
