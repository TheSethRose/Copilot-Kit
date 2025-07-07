---
description: "Comprehensive database health monitoring, connection testing, performance analysis, and maintenance operations"
---

# Database Health Check & Management

Apply the [general coding guidelines](./general.instructions.md) to all database operations.

**Command:** `/db`

## Purpose

Comprehensive database health monitoring, connection testing, performance analysis, and maintenance operations to ensure optimal database functionality and reliability.

## Usage

```
/db [operation] [options]
```

**Examples:**

- `/db health --full-check`
- `/db performance --analyze-queries`
- `/db backup --create-snapshot`
- `/db optimize --tune-indexes`
- `/db monitor --real-time`

## Methodology

### 1. Database Health Assessment

#### Connection & Availability

- Test database connectivity across all environments
- Verify connection pool health and configuration
- Check authentication and authorization status
- Validate SSL/TLS certificate status
- Monitor connection latency and timeout settings

#### Performance Monitoring

- Analyze query execution times and patterns
- Monitor database resource utilization (CPU, memory, I/O)
- Check for slow queries and optimization opportunities
- Review index usage and effectiveness
- Evaluate connection pool performance

#### Data Integrity

- Validate referential integrity constraints
- Check for data corruption or inconsistencies
- Verify backup and recovery procedures
- Monitor transaction log health
- Validate data validation rules

### 2. Health Check Commands

#### Basic Health Checks

```bash
# Overall database health
npm run db:health

# Connection test
npm run db:ping

# Quick status check
npm run db:status

# Detailed diagnostics
npm run db:diagnostics
```

#### Performance Analysis

```bash
# Query performance analysis
npm run db:analyze:queries

# Index usage analysis
npm run db:analyze:indexes

# Resource utilization check
npm run db:analyze:resources

# Connection pool status
npm run db:analyze:connections
```

#### Data Validation

```bash
# Integrity checks
npm run db:validate:integrity

# Consistency checks
npm run db:validate:consistency

# Constraint validation
npm run db:validate:constraints

# Data quality assessment
npm run db:validate:quality
```

### 3. Monitoring Dashboard

#### Key Performance Indicators

```typescript
interface DatabaseMetrics {
  connectivity: {
    status: "healthy" | "degraded" | "critical";
    responseTime: number; // milliseconds
    activeConnections: number;
    maxConnections: number;
    connectionErrors: number;
  };
  performance: {
    averageQueryTime: number;
    slowQueryCount: number;
    throughput: number; // queries per second
    cacheHitRatio: number;
    indexEfficiency: number;
  };
  resources: {
    cpuUsage: number; // percentage
    memoryUsage: number; // percentage
    diskUsage: number; // percentage
    ioWait: number; // percentage
  };
  integrity: {
    lastBackup: Date;
    backupStatus: "success" | "failed" | "pending";
    constraintViolations: number;
    dataConsistencyScore: number; // 0-100
  };
}
```

#### Health Check Report

```bash
# Generate comprehensive health report
npm run db:report

# Export metrics for monitoring
npm run db:metrics:export

# Create performance baseline
npm run db:baseline:create
```

### 4. Maintenance Operations

#### Routine Maintenance

```bash
# Update database statistics
npm run db:maintenance:stats

# Rebuild indexes
npm run db:maintenance:reindex

# Clean up temporary data
npm run db:maintenance:cleanup

# Optimize tables
npm run db:maintenance:optimize
```

#### Backup & Recovery

```bash
# Create backup
npm run db:backup:create

# Verify backup integrity
npm run db:backup:verify

# Test recovery procedure
npm run db:backup:test-restore

# List available backups
npm run db:backup:list
```

### 5. Security Assessment

#### Security Checks

```bash
# User privilege audit
npm run db:security:users

# Permission validation
npm run db:security:permissions

# Vulnerability scan
npm run db:security:scan

# Encryption status check
npm run db:security:encryption
```

#### Access Monitoring

```bash
# Login attempt monitoring
npm run db:security:logins

# Privilege escalation detection
npm run db:security:escalation

# Suspicious activity analysis
npm run db:security:activity
```

### 6. Troubleshooting Procedures

#### Common Issues

- Connection timeout problems
- Slow query performance
- Deadlock detection and resolution
- Resource exhaustion handling
- Constraint violation resolution

#### Diagnostic Commands

```bash
# Connection troubleshooting
npm run db:debug:connections

# Query performance debugging
npm run db:debug:queries

# Lock contention analysis
npm run db:debug:locks

# Resource bottleneck identification
npm run db:debug:resources
```

### 7. Alerting & Notifications

#### Alert Thresholds

```yaml
# Database alert configuration
alerts:
  connectivity:
    response_time_threshold: 1000ms
    connection_failure_threshold: 5%
    max_connections_threshold: 80%

  performance:
    slow_query_threshold: 5000ms
    throughput_drop_threshold: 20%
    cache_hit_ratio_threshold: 80%

  resources:
    cpu_threshold: 80%
    memory_threshold: 85%
    disk_threshold: 90%
```

#### Notification Channels

- Email alerts for critical issues
- Slack notifications for warnings
- Dashboard alerts for real-time monitoring
- SMS alerts for emergency situations

### 8. Environment-Specific Checks

#### Development Environment

```bash
# Development database health
npm run db:health:dev

# Seed data validation
npm run db:validate:seeds

# Migration status check
npm run db:migrations:status
```

#### Production Environment

```bash
# Production health check
npm run db:health:prod

# Performance baseline comparison
npm run db:compare:baseline

# Compliance validation
npm run db:validate:compliance
```

### 9. Automated Monitoring

#### Continuous Monitoring

```bash
# Start monitoring daemon
npm run db:monitor:start

# Stop monitoring
npm run db:monitor:stop

# View real-time metrics
npm run db:monitor:watch
```

#### Scheduled Health Checks

```yaml
# Cron job configuration
# Daily health check at 2 AM
0 2 * * * npm run db:health:scheduled

# Weekly deep analysis on Sundays
0 3 * * 0 npm run db:analyze:comprehensive

# Monthly maintenance on first Sunday
0 4 1-7 * 0 npm run db:maintenance:monthly
```

### 10. Reporting & Documentation

#### Health Report Format

```markdown
## Database Health Report

### Executive Summary

- Overall Status: [Healthy/Warning/Critical]
- Last Check: [timestamp]
- Key Issues: [count]
- Recommendations: [count]

### Connectivity Status

- Connection Success Rate: [percentage]
- Average Response Time: [milliseconds]
- Active Connections: [current/max]

### Performance Metrics

- Query Performance: [status]
- Index Efficiency: [percentage]
- Cache Hit Ratio: [percentage]
- Throughput: [queries/second]

### Resource Utilization

- CPU Usage: [percentage]
- Memory Usage: [percentage]
- Disk Usage: [percentage]
- I/O Performance: [metrics]

### Data Integrity

- Last Backup: [timestamp]
- Constraint Violations: [count]
- Data Consistency: [score]

### Recommendations

1. [Priority] [Action item]
2. [Priority] [Action item]

### Action Items

- Immediate: [urgent issues]
- Short-term: [improvements needed within week]
- Long-term: [strategic improvements]
```

## Implementation Workflow

### 1. Initial Assessment

```bash
# Run comprehensive health check
npm run db:health:full

# Establish performance baseline
npm run db:baseline:create

# Document current state
npm run db:report:initial
```

### 2. Ongoing Monitoring

```bash
# Daily automated checks
npm run db:health:daily

# Weekly performance analysis
npm run db:analyze:weekly

# Monthly comprehensive review
npm run db:review:monthly
```

### 3. Issue Resolution

```bash
# Identify issues
npm run db:issues:identify

# Prioritize problems
npm run db:issues:prioritize

# Execute fixes
npm run db:issues:resolve
```

## Success Criteria

- Database availability exceeds 99.9% uptime
- Query response times meet performance requirements
- All integrity constraints are satisfied
- Backup and recovery procedures are verified
- Security configurations pass audit requirements
- Resource utilization remains within acceptable limits
- Monitoring and alerting systems are operational
- Documentation is current and comprehensive
