---
description: "Database schema validation, synchronization, and management for ensuring data integrity and optimal database structure"
---

# Database Schema Management

Apply the [general coding guidelines](./general.instructions.md) to all database schema operations.

**Command:** `/schema`

## Purpose

Comprehensive database schema validation, synchronization, and management for ensuring data integrity and optimal database structure.

## Usage

```
/schema [operation] [options]
```

**Examples:**

- `/schema validate --check-integrity`
- `/schema sync --apply-changes`
- `/schema diff --compare-environments`
- `/schema optimize --review-indexes`
- `/schema backup --create-snapshot`

## Methodology

### 1. Schema Analysis Framework

#### Current State Assessment

- Analyze existing schema structure
- Identify schema drift from expected state
- Review table relationships and constraints
- Check index effectiveness and coverage
- Validate data types and column definitions

#### Schema Validation

- Compare schema against defined models/types
- Verify foreign key relationships
- Check constraint definitions and enforcement
- Validate index usage and performance impact
- Review naming conventions compliance

### 2. Schema Management Commands

```bash
# Schema inspection
npm run db:schema:dump
npm run db:schema:validate
npm run db:schema:compare

# Schema synchronization
npm run db:schema:sync --dry-run
npm run db:schema:sync --force

# Schema documentation
npm run db:schema:docs
npm run db:schema:diagram
```

### 3. Schema Validation Checklist

#### Structure Validation

- [ ] All required tables exist
- [ ] Column data types match specifications
- [ ] Constraints are properly defined
- [ ] Indexes align with query patterns
- [ ] Foreign key relationships are correct

#### Performance Validation

- [ ] Query performance meets requirements
- [ ] Index usage is optimized
- [ ] No missing indexes for common queries
- [ ] No unused or redundant indexes
- [ ] Proper partitioning if applicable

#### Data Integrity

- [ ] Primary keys are defined and efficient
- [ ] Foreign key constraints are enforced
- [ ] Check constraints validate business rules
- [ ] Unique constraints prevent duplicates
- [ ] Default values are appropriate

### 4. Schema Documentation

#### Required Documentation

- Entity Relationship Diagrams (ERD)
- Table and column descriptions
- Index documentation and rationale
- Constraint explanations
- Data dictionary with business context

#### Documentation Format

```markdown
## Schema Documentation

### Table: [table_name]

**Purpose**: Brief description of table purpose

#### Columns

| Column | Type | Constraints | Description       |
| ------ | ---- | ----------- | ----------------- |
| id     | UUID | PRIMARY KEY | Unique identifier |
| ...    | ...  | ...         | ...               |

#### Indexes

| Index Name | Columns | Type  | Purpose |
| ---------- | ------- | ----- | ------- |
| idx\_...   | [...]   | BTREE | ...     |

#### Relationships

- **[table_name]**: Foreign key relationship description
```

### 5. Schema Migration Strategy

#### Migration Planning

1. Assess impact of schema changes
2. Plan backward compatibility requirements
3. Determine migration execution strategy
4. Prepare rollback procedures
5. Schedule maintenance windows if needed

#### Migration Validation

- Test migrations on copy of production data
- Verify data integrity after migration
- Validate application compatibility
- Check performance impact
- Confirm rollback procedures work

### 6. Schema Monitoring

#### Automated Checks

- Schema drift detection
- Performance regression monitoring
- Constraint violation tracking
- Index usage monitoring
- Query performance analysis

#### Alerting Setup

- Schema change notifications
- Performance degradation alerts
- Constraint violation warnings
- Disk space monitoring
- Lock contention detection

### 7. Best Practices

#### Schema Design

- Use consistent naming conventions
- Implement proper normalization
- Design for scalability and performance
- Include audit trails where appropriate
- Plan for future extensibility

#### Change Management

- Version control all schema changes
- Use descriptive migration names
- Include rollback instructions
- Test in staging environment first
- Document business rationale for changes

### 8. Tools & Utilities

#### Schema Analysis Tools

- Database-specific schema inspection tools
- ERD generation utilities
- Performance analysis tools
- Data profiling tools
- Schema comparison utilities

#### Automation Tools

- Schema migration frameworks
- Continuous integration hooks
- Automated testing tools
- Documentation generators
- Monitoring dashboards

## Implementation Workflow

### 1. Initial Assessment

```bash
# Generate current schema documentation
npm run db:schema:docs

# Create ERD
npm run db:schema:diagram

# Analyze schema health
npm run db:schema:analyze
```

### 2. Validation Process

```bash
# Validate schema structure
npm run db:schema:validate

# Check for drift
npm run db:schema:compare

# Performance analysis
npm run db:performance:analyze
```

### 3. Synchronization

```bash
# Preview changes
npm run db:schema:sync --dry-run

# Apply changes
npm run db:schema:sync

# Verify results
npm run db:schema:validate
```

## Success Criteria

- Schema matches expected structure 100%
- All queries perform within acceptable limits
- Data integrity constraints are properly enforced
- Documentation is current and comprehensive
- Monitoring and alerting systems are operational
- Migration procedures are tested and documented
