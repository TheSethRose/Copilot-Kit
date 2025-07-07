---
description: "Database seeding and test data management for development, testing, and demo environments with referential integrity"
---

# Database Seeding & Test Data Management

Apply the [general coding guidelines](./general.instructions.md) to all database seeding operations.

**Command:** `/seed`

## Purpose

Comprehensive database seeding with development, testing, and demo data to support various environments and testing scenarios while maintaining data consistency and referential integrity.

## Usage

```
/seed [environment] [options]
```

**Examples:**

- `/seed development --full-dataset`
- `/seed testing --minimal-data`
- `/seed demo --showcase-features`
- `/seed performance --large-dataset`
- `/seed clean --reset-and-reseed`

## Methodology

### 1. Seeding Strategy Framework

#### Environment-Specific Seeding

- **Development**: Rich, realistic data for development workflow
- **Testing**: Controlled, predictable data for automated tests
- **Staging**: Production-like data for integration testing
- **Demo**: Curated data showcasing application features
- **Performance**: Large datasets for performance testing

#### Data Categories

- **Core Data**: Essential system data (roles, permissions, settings)
- **Reference Data**: Static lookup data (countries, categories, etc.)
- **User Data**: Sample users, profiles, and authentication data
- **Business Data**: Application-specific entities and relationships
- **Test Data**: Specific scenarios for automated testing

### 2. Seeding Commands

#### Basic Seeding Operations

```bash
# Seed all environments
npm run db:seed

# Environment-specific seeding
npm run db:seed:dev
npm run db:seed:test
npm run db:seed:staging
npm run db:seed:demo

# Selective seeding
npm run db:seed --tables=users,products
npm run db:seed --categories=core,reference
```

#### Advanced Seeding

```bash
# Generate large datasets
npm run db:seed:performance --size=large

# Seed with custom data
npm run db:seed:custom --file=custom-data.json

# Incremental seeding
npm run db:seed:incremental

# Seed reset and refresh
npm run db:seed:reset
npm run db:seed:refresh
```

### 3. Data Generation Framework

#### Realistic Data Generation

```typescript
interface SeedDataGenerator {
  users: UserSeedGenerator;
  products: ProductSeedGenerator;
  orders: OrderSeedGenerator;
  reviews: ReviewSeedGenerator;
}

interface UserSeedGenerator {
  generateUsers(count: number): User[];
  generateProfiles(): UserProfile[];
  generatePreferences(): UserPreferences[];
}

// Example data generation
const generateRealisticUsers = (count: number): User[] => {
  return Array.from({ length: count }, () => ({
    id: faker.datatype.uuid(),
    email: faker.internet.email(),
    firstName: faker.name.firstName(),
    lastName: faker.name.lastName(),
    avatar: faker.image.avatar(),
    createdAt: faker.date.between("2020-01-01", new Date()),
    isActive: faker.datatype.boolean(),
    role: faker.helpers.arrayElement(["user", "admin", "moderator"]),
  }));
};
```

#### Relationship Management

```typescript
interface RelationshipSeeder {
  seedUserOrders(users: User[]): Order[];
  seedProductReviews(products: Product[], users: User[]): Review[];
  seedCategoryProducts(categories: Category[]): Product[];
  ensureReferentialIntegrity(): void;
}
```

### 4. Seed Data Organization

#### Directory Structure

```
seeds/
├── core/                 # Essential system data
│   ├── roles.json
│   ├── permissions.json
│   └── settings.json
├── reference/            # Static lookup data
│   ├── countries.json
│   ├── categories.json
│   └── currencies.json
├── development/          # Development environment data
│   ├── users.dev.json
│   ├── products.dev.json
│   └── orders.dev.json
├── testing/              # Test-specific data
│   ├── users.test.json
│   ├── scenarios/
│   └── fixtures/
├── demo/                 # Demo presentation data
│   ├── showcase.json
│   └── features.json
└── generators/           # Data generation scripts
    ├── user-generator.ts
    ├── product-generator.ts
    └── order-generator.ts
```

#### Seed File Format

```json
{
  "metadata": {
    "version": "1.0.0",
    "environment": ["development", "testing"],
    "dependencies": ["core/roles.json"],
    "description": "Sample user data for development"
  },
  "data": {
    "users": [
      {
        "id": "user_001",
        "email": "john.doe@example.com",
        "firstName": "John",
        "lastName": "Doe",
        "role": "admin"
      }
    ]
  }
}
```

### 5. Seeding Execution Pipeline

#### Pre-Seeding Validation

```bash
# Validate seed data integrity
npm run db:seed:validate

# Check database schema compatibility
npm run db:seed:check-schema

# Verify dependencies and order
npm run db:seed:validate-deps

# Test data generation
npm run db:seed:test-generation
```

#### Seeding Process

```bash
# Execute seeding pipeline
npm run db:seed:pipeline

# Monitor seeding progress
npm run db:seed:monitor

# Verify seeding results
npm run db:seed:verify

# Generate seeding report
npm run db:seed:report
```

### 6. Data Consistency & Integrity

#### Referential Integrity

```typescript
class SeedIntegrityManager {
  validateForeignKeys(): ValidationResult;
  ensureUniqueConstraints(): void;
  checkDataConsistency(): ConsistencyReport;
  repairInconsistencies(): RepairResult;
}
```

#### Data Validation

```bash
# Validate seeded data
npm run db:seed:validate-data

# Check business rules compliance
npm run db:seed:validate-rules

# Verify data relationships
npm run db:seed:validate-relationships

# Test data accessibility
npm run db:seed:test-access
```

### 7. Performance Considerations

#### Bulk Operations

```typescript
interface BulkSeedOperations {
  bulkInsertUsers(users: User[], batchSize?: number): Promise<void>;
  bulkInsertProducts(products: Product[]): Promise<void>;
  bulkUpdateRelationships(): Promise<void>;
  optimizeForPerformance(): void;
}
```

#### Large Dataset Handling

```bash
# Generate large datasets efficiently
npm run db:seed:bulk --size=10000

# Streaming data insertion
npm run db:seed:stream --file=large-dataset.json

# Parallel seeding
npm run db:seed:parallel --workers=4

# Memory-optimized seeding
npm run db:seed:memory-optimized
```

### 8. Testing Support

#### Test Data Scenarios

```typescript
interface TestScenarios {
  userRegistrationFlow: TestData;
  orderProcessingFlow: TestData;
  paymentFailureScenario: TestData;
  adminWorkflowTest: TestData;
  edgeCaseScenarios: TestData[];
}
```

#### Fixture Management

```bash
# Generate test fixtures
npm run db:seed:fixtures

# Load scenario-specific data
npm run db:seed:scenario --name=payment-flow

# Reset to clean test state
npm run db:seed:test-reset

# Seed specific test cases
npm run db:seed:test-case --id=TC001
```

### 9. Environment Management

#### Development Environment

```bash
# Rich development data
npm run db:seed:dev:full

# Minimal development data
npm run db:seed:dev:minimal

# User-specific development data
npm run db:seed:dev:user --email=developer@company.com
```

#### Production-like Data

```bash
# Generate production-scale data
npm run db:seed:prod-like --scale=medium

# Anonymized production data
npm run db:seed:anonymized

# Compliance-safe seeding
npm run db:seed:gdpr-compliant
```

### 10. Monitoring & Reporting

#### Seeding Metrics

```typescript
interface SeedingMetrics {
  recordsInserted: Record<string, number>;
  executionTime: number;
  memoryUsage: number;
  errorCount: number;
  warningCount: number;
  validationResults: ValidationSummary;
}
```

#### Seed Report Format

```markdown
## Database Seeding Report

### Summary

- Environment: [target environment]
- Execution Time: [duration]
- Records Processed: [total count]
- Success Rate: [percentage]
- Status: [success/partial/failed]

### Data Categories

| Category       | Records | Status     | Notes   |
| -------------- | ------- | ---------- | ------- |
| Core Data      | [count] | ✅ Success | [notes] |
| Reference Data | [count] | ✅ Success | [notes] |
| User Data      | [count] | ⚠️ Warning | [notes] |

### Performance Metrics

- Total Execution Time: [duration]
- Average Insert Rate: [records/second]
- Memory Peak Usage: [MB]
- Database Size After Seeding: [MB]

### Validation Results

- Referential Integrity: [✅/❌]
- Unique Constraints: [✅/❌]
- Business Rules: [✅/❌]
- Data Quality Score: [percentage]

### Issues & Warnings

- [List any issues encountered]
- [List any warnings or recommendations]

### Next Steps

- [Recommended actions or follow-ups]
```

### 11. Automation & Scheduling

#### Automated Seeding

```yaml
# GitHub Actions workflow
name: Database Seeding
on:
  schedule:
    - cron: "0 6 * * 1" # Weekly on Monday
  workflow_dispatch:
    inputs:
      environment:
        description: "Target environment"
        required: true
        default: "development"

jobs:
  seed:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v3
      - run: npm run db:seed:${{ github.event.inputs.environment }}
```

#### CI/CD Integration

```bash
# Pre-test seeding
npm run db:seed:test:before

# Post-deployment seeding
npm run db:seed:staging:after

# Development environment refresh
npm run db:seed:dev:refresh
```

## Implementation Workflow

### 1. Setup Phase

```bash
# Initialize seeding infrastructure
npm run db:seed:init

# Create seed templates
npm run db:seed:templates

# Configure environments
npm run db:seed:config
```

### 2. Data Preparation

```bash
# Generate seed data
npm run db:seed:generate

# Validate seed files
npm run db:seed:validate

# Test data generation
npm run db:seed:test
```

### 3. Execution Phase

```bash
# Execute seeding
npm run db:seed:execute

# Monitor progress
npm run db:seed:monitor

# Verify results
npm run db:seed:verify
```

## Success Criteria

- All target environments successfully seeded with appropriate data
- Data integrity and referential consistency maintained
- Seeding performance meets acceptable thresholds
- Test scenarios have reliable, predictable data
- Development workflow supported with realistic data
- Documentation covers all seeding procedures
- Automation reduces manual seeding overhead
- Rollback and cleanup procedures are tested and documented
