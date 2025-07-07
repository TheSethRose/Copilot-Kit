---
description: "Comprehensive database migration execution, validation, and rollback management for safe schema changes"
---

# Database Migration Management

Apply the [general coding guidelines](./general.instructions.md) to all migration operations.

**Command:** `/migrate`

## Purpose

Comprehensive database migration execution, validation, and rollback management to ensure safe and reliable database schema changes.

## Usage

```
/migrate [operation] [options]
```

**Examples:**

- `/migrate up --to-latest`
- `/migrate down --steps=1`
- `/migrate status --show-pending`
- `/migrate create --name=add_user_preferences`
- `/migrate rollback --to-version=001`

## Methodology

### 1. Pre-Migration Assessment

#### Environment Validation

- Verify database connectivity and permissions
- Check available disk space and resources
- Validate backup systems are operational
- Confirm maintenance window scheduling
- Review migration dependencies and order

#### Migration Analysis

- Analyze pending migrations for potential issues
- Estimate execution time and resource requirements
- Identify potential blocking operations
- Review impact on application functionality
- Plan rollback scenarios for each migration

### 2. Migration Execution Framework

#### Safety Checks

```bash
# Verify migration status
npm run db:migrate:status

# Validate migration files
npm run db:migrate:validate

# Check for conflicts
npm run db:migrate:check

# Backup database
npm run db:backup:create
```

#### Execution Process

```bash
# Dry run (validate without applying)
npm run db:migrate:up --dry-run

# Execute migrations with confirmation
npm run db:migrate:up --confirm

# Apply specific migration
npm run db:migrate:up --to=<migration_id>

# Rollback if needed
npm run db:migrate:down --steps=1
```

### 3. Migration Validation Checklist

#### Pre-Migration

- [ ] All migration files are syntactically valid
- [ ] Dependencies are resolved and available
- [ ] Database backup is created and verified
- [ ] Application can handle temporary downtime
- [ ] Rollback procedures are tested and ready

#### During Migration

- [ ] Monitor migration progress and performance
- [ ] Watch for blocking operations and deadlocks
- [ ] Verify data integrity during long-running operations
- [ ] Monitor system resources (CPU, memory, disk)
- [ ] Check application health and connectivity

#### Post-Migration

- [ ] All migrations completed successfully
- [ ] Database schema matches expected state
- [ ] Application functionality is verified
- [ ] Performance regression tests pass
- [ ] Data integrity checks complete successfully

### 4. Migration Monitoring

#### Real-time Monitoring

```bash
# Monitor migration progress
npm run db:migrate:status --watch

# Check database performance
npm run db:performance:monitor

# Verify application health
npm run health:check --database
```

#### Performance Tracking

- Migration execution time
- Database performance impact
- Application response time during migration
- Resource utilization patterns
- Lock contention and blocking

### 5. Rollback Procedures

#### Rollback Planning

- Identify rollback points for each migration
- Prepare data preservation strategies
- Plan application compatibility during rollback
- Document rollback decision criteria
- Test rollback procedures in staging

#### Rollback Execution

```bash
# Rollback last migration
npm run db:migrate:down --steps=1

# Rollback to specific version
npm run db:migrate:down --to=<migration_id>

# Emergency rollback with force
npm run db:migrate:rollback --force --to=<safe_version>
```

### 6. Data Safety Measures

#### Backup Strategy

- Full database backup before migration batch
- Incremental backups during long migrations
- Point-in-time recovery capability
- Cross-region backup verification
- Backup restoration testing

#### Data Validation

```bash
# Validate data consistency
npm run db:validate:consistency

# Check referential integrity
npm run db:validate:integrity

# Verify data completeness
npm run db:validate:completeness

# Run custom validation queries
npm run db:validate:custom
```

### 7. Migration Types & Strategies

#### Schema Migrations

- Table creation and modification
- Index management
- Constraint addition/removal
- Data type changes
- Column addition/removal

#### Data Migrations

- Data transformation and cleanup
- Large dataset migrations
- Reference data updates
- Data archival operations
- Performance optimization migrations

#### Application Coordination

- Feature flag coordination
- API versioning alignment
- Backward compatibility maintenance
- Graceful degradation planning
- Zero-downtime migration strategies

### 8. Error Handling & Recovery

#### Common Issues

- Lock timeouts and deadlocks
- Disk space exhaustion
- Memory limitations
- Connection failures
- Data consistency violations

#### Recovery Procedures

```bash
# Handle failed migration
npm run db:migrate:repair

# Reset migration state
npm run db:migrate:reset --migration=<id>

# Force unlock stuck migrations
npm run db:migrate:unlock

# Verify and fix schema state
npm run db:schema:repair
```

### 9. Documentation & Reporting

#### Migration Reports

```markdown
## Migration Execution Report

### Summary

- Migration batch: [batch_id]
- Execution time: [duration]
- Status: [success/failed/partial]
- Affected tables: [count]

### Executed Migrations

| Migration | Status   | Duration | Impact        |
| --------- | -------- | -------- | ------------- |
| [id]      | [status] | [time]   | [description] |

### Performance Impact

- Database response time: [before/after]
- Application performance: [metrics]
- Resource utilization: [peak values]

### Issues Encountered

- [List any issues and resolutions]

### Rollback Plan

- [Current rollback capability]
- [Recovery procedures if needed]
```

## Implementation Workflow

### 1. Preparation Phase

```bash
# Check migration status
npm run db:migrate:status

# Validate pending migrations
npm run db:migrate:validate

# Create backup
npm run db:backup:create --name="pre-migration-$(date +%Y%m%d)"
```

### 2. Execution Phase

```bash
# Execute with monitoring
npm run db:migrate:up --monitor --confirm

# Verify results
npm run db:schema:validate
npm run db:validate:integrity
```

### 3. Validation Phase

```bash
# Run application tests
npm run test:integration

# Check performance
npm run db:performance:check

# Verify functionality
npm run health:check --full
```

## Success Criteria

- All migrations execute without errors
- Database schema matches expected state
- Application functionality remains intact
- Performance meets acceptable thresholds
- Data integrity is maintained throughout
- Rollback procedures are tested and documented
- Migration execution is properly logged and reported
