---
applyTo: "**/*.md,**/*.mdx"
description: "Comprehensive Markdown writing standards for documentation, README files, and technical content with accessibility and SEO considerations"
---

# Markdown Writing Standards

Apply the [general coding guidelines](./general.instructions.md) to all Markdown content.

## Document Structure

### Front Matter (YAML)

```yaml
---
title: "Document Title"
description: "Brief description of the content"
date: 2025-06-06
author: "Author Name"
tags: ["tag1", "tag2"]
draft: false
---
```

### Heading Hierarchy

```markdown
# Main Title (H1) - Only one per document

## Section Headings (H2) - Major sections

### Subsection Headings (H3) - Subsections

#### Minor Headings (H4) - Use sparingly
```

## Content Guidelines

### Writing Style

- Use clear, concise language
- Write in active voice when possible
- Use second person ("you") for instructional content
- Use first person plural ("we") for collaborative content
- Avoid jargon unless necessary (define when used)

### Paragraph Structure

- Keep paragraphs focused on one main idea
- Use 2-4 sentences per paragraph for readability
- Add blank lines between paragraphs
- Use transition words to connect ideas

## Formatting Standards

### Text Emphasis

```markdown
**Bold text** for important concepts and UI elements
_Italic text_ for emphasis and first-time terminology
`Inline code` for code snippets, filenames, and commands
~~Strikethrough~~ for corrections or deprecated content
```

### Code Blocks

````markdown
```typescript
// Language-specific syntax highlighting
interface User {
  id: string;
  name: string;
  email: string;
}
```

```bash
# Shell commands with comments
npm install package-name
```

```json
{
  "config": "value",
  "nested": {
    "property": true
  }
}
```
````

### Lists

#### Unordered Lists

```markdown
- Use hyphens for primary list items
- Maintain consistent indentation
  - Use 2 spaces for nested items
  - Keep nesting to 3 levels maximum
- End lists with blank line
```

#### Ordered Lists

```markdown
1. Use numbers for sequential steps
2. Maintain consistent formatting
   1. Use 3 spaces for nested numbered items
   2. Continue numbering logically
3. Include code examples when helpful
```

#### Task Lists

```markdown
- [x] Completed task
- [ ] Pending task
- [ ] Another pending task
```

### Links and References

#### Internal Links

```markdown
<!-- Example internal links (syntax examples) -->

[Link text]&#40;./relative-path.md&#41;
[Section reference]&#40;#section-heading&#41;
[Reference-style link][ref-id]

[ref-id]: https://example.com "Optional title"
```

#### External Links

```markdown
[External link](https://example.com) opens in same tab
[External link](https://example.com){:target="\_blank"} opens in new tab
```

### Images and Media

```markdown
![Alt text]&#40;./images/filename.png "Optional title"&#41;

<!-- With size specifications -->

&lt;img src="./images/filename.png" alt="Alt text" width="500" height="300"&gt;

<!-- Figure with caption -->
<figure>
  <img src="./images/filename.png" alt="Alt text">
  <figcaption>Figure caption describing the image</figcaption>
</figure>
```

## Tables

### Simple Tables

```markdown
| Column 1   | Column 2   | Column 3   |
| ---------- | ---------- | ---------- |
| Row 1 Data | Row 1 Data | Row 1 Data |
| Row 2 Data | Row 2 Data | Row 2 Data |
```

### Aligned Tables

```markdown
| Left Aligned | Center Aligned | Right Aligned |
| :----------- | :------------: | ------------: |
| Text         |      Text      |          Text |
| More text    |   More text    |     More text |
```

### Complex Tables with HTML

```html
<table>
  <thead>
    <tr>
      <th>Header 1</th>
      <th>Header 2</th>
      <th>Header 3</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>Complex content</td>
      <td><code>code snippet</code></td>
      <td>**formatted text**</td>
    </tr>
  </tbody>
</table>
```

## Special Content Blocks

### Blockquotes

```markdown
> Single line quote

> Multi-line quote
> that spans multiple lines
> and provides context

> **Citation Example**  
> Important quote with proper attribution.  
> — Author Name, _Source Title_
```

### Callout Boxes (if supported)

```markdown
> [!NOTE]
> This is a note callout

> [!TIP]
> This is a tip callout

> [!WARNING]
> This is a warning callout

> [!IMPORTANT]
> This is an important callout
```

### Horizontal Rules

```markdown
---
Three hyphens for section breaks
---

Three asterisks for emphasis breaks
```

## Documentation-Specific Guidelines

### API Documentation

````markdown
## Method Name

Brief description of what the method does.

### Syntax

```typescript
methodName(param1: Type, param2?: Type): ReturnType
```
````

### Parameters

| Parameter | Type   | Required | Description           |
| --------- | ------ | -------- | --------------------- |
| param1    | string | Yes      | Description of param1 |
| param2    | number | No       | Description of param2 |

### Returns

Returns a `ReturnType` containing...

### Example

```typescript
const result = methodName("value", 42);
console.log(result);
```

### Throws

- `Error`: When invalid parameters are provided
- `TypeError`: When parameter types are incorrect

````

### README Structure
```markdown
# Project Name

Brief project description and purpose.

## Features

- Feature 1
- Feature 2
- Feature 3

## Installation

```bash
npm install project-name
````

## Usage

Basic usage example:

```typescript
import { ProjectName } from "project-name";

const instance = new ProjectName();
instance.doSomething();
```

## API Reference

Link to detailed API documentation.

## Contributing

Guidelines for contributors.

## License

License information.

````

## Accessibility Guidelines

### Alt Text for Images
```markdown
![Descriptive alt text that explains the image content](image.png)

<!-- For decorative images -->
![](decorative-image.png)
<!-- Or -->
<img src="decorative-image.png" alt="" role="presentation">
````

### Semantic HTML in Markdown

```html
<!-- Use semantic elements when needed -->
<section>
  <h2>Section Title</h2>
  <p>Section content...</p>
</section>

<article>
  <h2>Article Title</h2>
  <p>Article content...</p>
</article>

<aside>
  <h3>Related Information</h3>
  <p>Sidebar content...</p>
</aside>
```

## Best Practices

### File Organization

```
docs/
├── README.md
├── getting-started.md
├── api/
│   ├── README.md
│   ├── authentication.md
│   └── endpoints.md
├── guides/
│   ├── installation.md
│   └── configuration.md
└── assets/
    └── images/
```

### Cross-References

```markdown
<!-- Use consistent linking patterns (examples with escaped syntax) -->

See [Installation Guide]&#40;./guides/installation.md&#41; for setup instructions.
Refer to the [API Reference]&#40;./api/README.md&#41; for detailed information.
```

### Version Control

```markdown
<!-- Include version information when relevant (example with escaped syntax) -->

> **Note**: This documentation is for version 2.x.
> For version 1.x documentation, see [v1 docs]&#40;./v1/&#41;.
```

## Content Maintenance

### Regular Updates

- Review content quarterly for accuracy
- Update code examples to reflect current best practices
- Verify all links are functional
- Update screenshots and images as needed

### Quality Checklist

- [ ] Spelling and grammar checked
- [ ] Code examples tested and working
- [ ] Links verified and functional
- [ ] Images have appropriate alt text
- [ ] Headings follow logical hierarchy
- [ ] Content is scannable with clear structure

## Common Anti-Patterns to Avoid

### Formatting Issues

```markdown
<!-- DON'T: Inconsistent spacing -->

#Heading Without Space
Text without blank line after heading

<!-- DO: Proper spacing -->

# Heading With Space

Text with proper spacing after heading.
```

### Link Problems

```markdown
<!-- DON'T: Broken relative links (example with escaped syntax) -->

[Link]&#40;../../../deeply/nested/path.md&#41;

<!-- DO: Clear, maintainable links (example with escaped syntax) -->

[Link]&#40;./relative-path.md&#41;
```

### Table Formatting

```markdown
<!-- DON'T: Poorly formatted tables -->

| Col1 | Col2 | Col3 |
| ---- | ---- | ---- |
| Data | Data | Data |

<!-- DO: Well-formatted tables -->

| Column 1 | Column 2 | Column 3 |
| -------- | -------- | -------- |
| Data     | Data     | Data     |
```
