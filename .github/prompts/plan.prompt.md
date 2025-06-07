---
description: "Requirements analysis and implementation planning with clear deliverables, timelines, and success criteria"
---

# Plan - Requirements Analysis & Implementation Planning

Apply the [general coding guidelines](./general.instructions.md) to all planning and analysis activities.

**Command:** `/plan`

## Purpose

Analyze requirements thoroughly and create detailed implementation plans with clear deliverables, timelines, and success criteria.

## Usage

```
/plan [feature/project description]
```

## Planning Framework

### 1. Requirements Gathering

- **Functional Requirements**: What the system must do
- **Non-Functional Requirements**: Performance, scalability, security
- **User Stories**: User personas and their needs
- **Acceptance Criteria**: Definition of done for each requirement
- **Dependencies**: External systems, APIs, libraries required

### 2. Technical Analysis

- **Current State Assessment**: Existing architecture and capabilities
- **Gap Analysis**: What needs to be built or modified
- **Technology Evaluation**: Stack decisions and tool selection
- **Integration Points**: How new features connect to existing systems
- **Data Flow Mapping**: Information movement through the system

### 3. Architecture Planning

- **System Design**: High-level component architecture
- **Database Schema**: Data structures and relationships
- **API Design**: Endpoints, request/response formats
- **Security Considerations**: Authentication, authorization, data protection
- **Performance Requirements**: Load expectations and optimization needs

### 4. Implementation Strategy

- **Phased Approach**: Break work into manageable iterations
- **MVP Definition**: Minimum viable product scope
- **Feature Prioritization**: Critical path and dependencies
- **Resource Allocation**: Team assignments and skill requirements
- **Timeline Estimation**: Realistic delivery schedules

### 5. Risk Management

- **Technical Risks**: Complexity, unknown technologies
- **Resource Risks**: Availability, skill gaps
- **Timeline Risks**: Dependencies, scope creep
- **Mitigation Strategies**: Backup plans and alternatives

## Output Structure

```markdown
## Project Overview

- **Objective**: [Clear goal statement]
- **Scope**: [What's included/excluded]
- **Success Criteria**: [Measurable outcomes]

## Requirements

### Functional Requirements

1. [Requirement with acceptance criteria]
2. [Requirement with acceptance criteria]

### Non-Functional Requirements

- **Performance**: [Specific metrics]
- **Security**: [Requirements and compliance]
- **Scalability**: [Growth expectations]
- **Accessibility**: [Standards and guidelines]

## Technical Specification

### Architecture Overview

[High-level system design]

### Technology Stack

- **Frontend**: [Technologies and rationale]
- **Backend**: [Technologies and rationale]
- **Database**: [Choice and structure]
- **Infrastructure**: [Hosting and deployment]

### API Design

[Endpoint specifications and data models]

## Implementation Plan

### Phase 1: [Name] (Timeline: [Duration])

- **Tasks**:
  - [ ] [Specific deliverable]
  - [ ] [Specific deliverable]
- **Dependencies**: [Prerequisites]
- **Deliverables**: [Concrete outputs]

### Phase 2: [Name] (Timeline: [Duration])

[Same structure]

### Phase 3: [Name] (Timeline: [Duration])

[Same structure]

## Testing Strategy

- **Unit Testing**: [Coverage requirements]
- **Integration Testing**: [Key scenarios]
- **End-to-End Testing**: [User journey validation]
- **Performance Testing**: [Load and stress testing]

## Deployment Plan

- **Environment Strategy**: [Dev, staging, production]
- **CI/CD Pipeline**: [Automation requirements]
- **Rollback Strategy**: [Risk mitigation]
- **Monitoring**: [Health checks and alerting]

## Risk Assessment

| Risk               | Impact       | Probability  | Mitigation |
| ------------------ | ------------ | ------------ | ---------- |
| [Risk description] | High/Med/Low | High/Med/Low | [Strategy] |

## Success Metrics

- **Technical Metrics**: [Performance, reliability]
- **User Metrics**: [Adoption, satisfaction]
- **Business Metrics**: [ROI, efficiency gains]
```

## Best Practices

- Start with user needs, not technical solutions
- Define clear, measurable success criteria
- Plan for iterative delivery and feedback loops
- Consider maintenance and long-term evolution
- Document assumptions and constraints
- Validate plans with stakeholders before implementation
- Include rollback and recovery strategies
- Plan for both happy path and edge cases

## Integration

Use this command for:

- New feature development
- System refactoring initiatives
- Performance improvement projects
- Security enhancement planning
- Infrastructure upgrades
