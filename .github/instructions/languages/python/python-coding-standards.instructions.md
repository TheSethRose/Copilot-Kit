---
applyTo: "**/*.py,**/*.pyi"
description: "Python coding standards with type hints, performance optimization, and testing requirements following PEP guidelines"
---

# Python Coding Standards

Apply the [general coding guidelines](./general.instructions.md) to all Python code.

## Python Style Guide

### Code Formatting

- Follow PEP 8 style guide for Python code
- Use 4 spaces for indentation (never tabs)
- Maximum line length of 88 characters (Black formatter standard)
- Use Black formatter for consistent code formatting
- Use isort for import organization

### Import Organization

```python
# Standard library imports
import os
import sys
from typing import Dict, List, Optional

# Third-party imports
import requests
import pandas as pd

# Local application imports
from .models import User
from .utils import validate_email
```

## Type Hints and Annotations

### Function Signatures

```python
def process_user_data(
    user_id: int,
    data: Dict[str, Any],
    is_admin: bool = False
) -> Optional[User]:
    """Process user data with proper type hints."""
    pass
```

### Class Definitions

```python
from typing import Protocol, TypeVar, Generic
from dataclasses import dataclass

@dataclass
class UserProfile:
    """User profile data structure."""
    name: str
    email: str
    age: Optional[int] = None

    def __post_init__(self) -> None:
        """Validate data after initialization."""
        if not self.email:
            raise ValueError("Email is required")
```

### Generic Types and Protocols

```python
T = TypeVar('T')

class Serializable(Protocol):
    """Protocol for serializable objects."""
    def to_dict(self) -> Dict[str, Any]: ...

def serialize_data(obj: Serializable) -> str:
    """Serialize any object that implements Serializable protocol."""
    return json.dumps(obj.to_dict())
```

## Error Handling

### Exception Handling

```python
from typing import Union
import logging

logger = logging.getLogger(__name__)

class CustomError(Exception):
    """Custom application error."""
    def __init__(self, message: str, error_code: Optional[str] = None):
        super().__init__(message)
        self.error_code = error_code

def safe_api_call(url: str) -> Union[Dict[str, Any], None]:
    """Make API call with proper error handling."""
    try:
        response = requests.get(url, timeout=30)
        response.raise_for_status()
        return response.json()
    except requests.RequestException as e:
        logger.error(f"API call failed for {url}: {e}")
        return None
    except ValueError as e:
        logger.error(f"Invalid JSON response from {url}: {e}")
        return None
```

### Context Managers

```python
from contextlib import contextmanager
from typing import Generator

@contextmanager
def database_transaction() -> Generator[None, None, None]:
    """Context manager for database transactions."""
    transaction = begin_transaction()
    try:
        yield
        transaction.commit()
    except Exception:
        transaction.rollback()
        raise
    finally:
        transaction.close()
```

## Data Validation

### Pydantic Models

```python
from pydantic import BaseModel, EmailStr, validator
from typing import List, Optional
from datetime import datetime

class UserCreateRequest(BaseModel):
    """Request model for creating a user."""
    name: str
    email: EmailStr
    age: Optional[int] = None
    tags: List[str] = []

    @validator('name')
    def name_must_not_be_empty(cls, v: str) -> str:
        if not v.strip():
            raise ValueError('Name cannot be empty')
        return v.title()

    @validator('age')
    def age_must_be_valid(cls, v: Optional[int]) -> Optional[int]:
        if v is not None and (v < 0 or v > 150):
            raise ValueError('Age must be between 0 and 150')
        return v
```

## Async Programming

### Async Functions

```python
import asyncio
import aiohttp
from typing import List, Dict, Any

async def fetch_data(session: aiohttp.ClientSession, url: str) -> Optional[Dict[str, Any]]:
    """Fetch data from URL asynchronously."""
    try:
        async with session.get(url) as response:
            if response.status == 200:
                return await response.json()
            else:
                logger.warning(f"HTTP {response.status} for {url}")
                return None
    except Exception as e:
        logger.error(f"Failed to fetch {url}: {e}")
        return None

async def fetch_multiple_urls(urls: List[str]) -> List[Dict[str, Any]]:
    """Fetch multiple URLs concurrently."""
    async with aiohttp.ClientSession() as session:
        tasks = [fetch_data(session, url) for url in urls]
        results = await asyncio.gather(*tasks, return_exceptions=True)
        return [r for r in results if isinstance(r, dict)]
```

## Testing Standards

### Test Structure

```python
import pytest
from unittest.mock import Mock, patch
from typing import Any

class TestUserService:
    """Test suite for UserService."""

    @pytest.fixture
    def mock_database(self) -> Mock:
        """Mock database fixture."""
        return Mock()

    @pytest.fixture
    def user_service(self, mock_database: Mock) -> UserService:
        """UserService instance with mocked dependencies."""
        return UserService(database=mock_database)

    def test_create_user_success(self, user_service: UserService) -> None:
        """Test successful user creation."""
        # Arrange
        user_data = {"name": "John Doe", "email": "john@example.com"}

        # Act
        result = user_service.create_user(user_data)

        # Assert
        assert result.name == "John Doe"
        assert result.email == "john@example.com"

    @pytest.mark.asyncio
    async def test_async_operation(self) -> None:
        """Test async operations."""
        result = await async_function()
        assert result is not None
```

### Parametrized Tests

```python
@pytest.mark.parametrize("input_data,expected", [
    ({"name": "John", "age": 25}, True),
    ({"name": "", "age": 25}, False),
    ({"name": "John", "age": -1}, False),
])
def test_validate_user_data(input_data: Dict[str, Any], expected: bool) -> None:
    """Test user data validation with various inputs."""
    result = validate_user_data(input_data)
    assert result == expected
```

## Performance and Best Practices

### List Comprehensions and Generators

```python
# Prefer list comprehensions for simple transformations
processed_data = [process_item(item) for item in items if item.is_valid]

# Use generators for memory efficiency with large datasets
def process_large_dataset(items: Iterable[Item]) -> Generator[ProcessedItem, None, None]:
    """Process large dataset using generator for memory efficiency."""
    for item in items:
        if item.is_valid:
            yield process_item(item)
```

### Caching and Memoization

```python
from functools import lru_cache, cached_property
from typing import Dict, Any

class DataProcessor:
    """Data processor with caching."""

    @lru_cache(maxsize=128)
    def expensive_computation(self, data: str) -> Dict[str, Any]:
        """Expensive computation with LRU cache."""
        # Expensive operation here
        return processed_result

    @cached_property
    def configuration(self) -> Dict[str, Any]:
        """Cached property for configuration."""
        return load_configuration()
```

## Documentation Standards

### Docstring Format (Google Style)

```python
def complex_function(
    param1: str,
    param2: List[int],
    param3: Optional[bool] = None
) -> Dict[str, Any]:
    """Process complex data with multiple parameters.

    This function performs complex data processing with various
    parameters and returns structured results.

    Args:
        param1: Description of the first parameter
        param2: List of integers to process
        param3: Optional boolean flag for special processing

    Returns:
        Dictionary containing processed results with keys:
        - 'status': Processing status
        - 'data': Processed data
        - 'errors': List of any errors encountered

    Raises:
        ValueError: If param1 is empty
        TypeError: If param2 contains non-integer values

    Example:
        >>> result = complex_function("test", [1, 2, 3])
        >>> print(result['status'])
        'success'
    """
    pass
```

## Security Best Practices

### Input Validation and Sanitization

```python
import re
from typing import Optional

def sanitize_input(user_input: str) -> str:
    """Sanitize user input to prevent injection attacks."""
    # Remove potentially dangerous characters
    cleaned = re.sub(r'[<>"\';]', '', user_input)
    return cleaned.strip()

def validate_sql_identifier(identifier: str) -> bool:
    """Validate SQL identifier to prevent SQL injection."""
    pattern = r'^[a-zA-Z_][a-zA-Z0-9_]*$'
    return bool(re.match(pattern, identifier))
```

### Environment Configuration

```python
import os
from typing import Optional

class Config:
    """Application configuration from environment variables."""

    DATABASE_URL: str = os.getenv('DATABASE_URL', 'sqlite:///default.db')
    SECRET_KEY: str = os.getenv('SECRET_KEY', '')
    DEBUG: bool = os.getenv('DEBUG', 'False').lower() == 'true'

    @classmethod
    def validate(cls) -> None:
        """Validate required configuration."""
        if not cls.SECRET_KEY:
            raise ValueError("SECRET_KEY environment variable is required")
```

## Common Anti-Patterns to Avoid

### Code Smells

```python
# DON'T: Bare except clauses
try:
    risky_operation()
except:  # Too broad
    pass

# DO: Specific exception handling
try:
    risky_operation()
except (ValueError, TypeError) as e:
    logger.error(f"Operation failed: {e}")
    handle_error(e)

# DON'T: Mutable default arguments
def add_item(item: str, items: List[str] = []) -> List[str]:  # Dangerous!
    items.append(item)
    return items

# DO: Use None as default
def add_item(item: str, items: Optional[List[str]] = None) -> List[str]:
    if items is None:
        items = []
    items.append(item)
    return items
```

## Dependency Management

### Requirements Files

```python
# requirements.txt - Production dependencies
fastapi==0.68.0
pydantic==1.8.2
sqlalchemy==1.4.23

# requirements-dev.txt - Development dependencies
pytest==6.2.5
black==21.7b0
mypy==0.910
flake8==3.9.2
```

### Virtual Environment Best Practices

```bash
# Create virtual environment
python -m venv venv

# Activate virtual environment
source venv/bin/activate  # Unix/macOS
# or
venv\Scripts\activate  # Windows

# Install dependencies
pip install -r requirements.txt
```
