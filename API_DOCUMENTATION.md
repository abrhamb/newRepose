# HelloWorld API Documentation

## Table of Contents

1. [Class Overview](#class-overview)
2. [Public API Reference](#public-api-reference)
3. [Method Details](#method-details)
4. [Constants](#constants)
5. [Exceptions](#exceptions)
6. [Usage Patterns](#usage-patterns)
7. [Best Practices](#best-practices)
8. [Performance Considerations](#performance-considerations)

## Class Overview

### HelloWorld

**Package:** Default package  
**Visibility:** Public  
**Type:** Class  
**Thread Safety:** Thread-safe (stateless)  
**Since:** 1.0  

The `HelloWorld` class is a utility class designed to demonstrate proper API design and documentation practices. It provides functionality for generating greeting messages and validating names.

**Key Features:**
- Personalized greeting generation
- Custom greeting creation with flexible parameters
- Name validation using standard criteria
- Version information tracking
- Null-safe operations
- Input validation and sanitization

**Class Hierarchy:**
```
java.lang.Object
  └── HelloWorld
```

## Public API Reference

### Constructors

| Constructor | Description |
|-------------|-------------|
| `HelloWorld()` | Default constructor. Creates a new instance of HelloWorld. |

### Methods

| Method | Return Type | Description | Throws |
|--------|-------------|-------------|--------|
| `getGreeting(String)` | `String` | Creates a personalized greeting for a name | None |
| `getCustomGreeting(String, String)` | `String` | Creates a custom greeting with specified greeting word and name | `IllegalArgumentException` |
| `isValidName(String)` | `boolean` | Validates if a string is a valid name | None |
| `getVersion()` | `String` | Returns the version of the class | None |
| `main(String[])` | `void` | Main entry point (static) | None |

### Constants

| Constant | Type | Value | Description |
|----------|------|-------|-------------|
| `DEFAULT_GREETING` | `String` | "Hello, World!" | Default greeting message (private) |

## Method Details

### Constructor Details

#### `HelloWorld()`

```java
public HelloWorld()
```

**Description:**  
Default constructor that creates a new instance of the HelloWorld class. The class is stateless, so multiple instances behave identically.

**Parameters:** None  
**Throws:** None  
**Since:** 1.0  

**Example:**
```java
HelloWorld hw = new HelloWorld();
```

---

### Method Details

#### `getGreeting(String name)`

```java
public String getGreeting(String name)
```

**Description:**  
Creates a personalized greeting message for the specified name. If the name is null or empty, returns the default greeting.

**Parameters:**
- `name` - The name to include in the greeting. Can be null or empty.

**Returns:**  
A personalized greeting string, or the default greeting if the name is invalid.

**Throws:** None

**Behavior:**
- If `name` is `null`, returns `DEFAULT_GREETING`
- If `name` is empty or whitespace-only, returns `DEFAULT_GREETING`
- Otherwise, returns "Hello, {trimmed_name}!"

**Thread Safety:** Thread-safe

**Performance:** O(1) - constant time complexity

**Since:** 1.0

**Examples:**
```java
HelloWorld hw = new HelloWorld();

// Valid name
String result1 = hw.getGreeting("Alice");
// Returns: "Hello, Alice!"

// Empty name
String result2 = hw.getGreeting("");
// Returns: "Hello, World!"

// Null name
String result3 = hw.getGreeting(null);
// Returns: "Hello, World!"

// Name with whitespace
String result4 = hw.getGreeting("  Bob  ");
// Returns: "Hello, Bob!"
```

---

#### `getCustomGreeting(String greetingWord, String name)`

```java
public String getCustomGreeting(String greetingWord, String name)
```

**Description:**  
Creates a custom greeting with the specified greeting word and name. Both parameters are required and validated.

**Parameters:**
- `greetingWord` - The greeting word to use (e.g., "Welcome", "Hi", "Greetings"). Must not be null or empty.
- `name` - The name to greet. Must not be null or empty.

**Returns:**  
A formatted custom greeting string in the format "{greetingWord}, {name}!"

**Throws:**
- `IllegalArgumentException` - if `greetingWord` is null or empty
- `IllegalArgumentException` - if `name` is null or empty

**Behavior:**
- Trims whitespace from both parameters
- Validates both parameters are non-null and non-empty
- Returns formatted string: "{trimmed_greetingWord}, {trimmed_name}!"

**Thread Safety:** Thread-safe

**Performance:** O(1) - constant time complexity

**Since:** 1.0

**Examples:**
```java
HelloWorld hw = new HelloWorld();

// Valid parameters
String result1 = hw.getCustomGreeting("Welcome", "Bob");
// Returns: "Welcome, Bob!"

// Parameters with whitespace
String result2 = hw.getCustomGreeting("  Hi  ", "  Carol  ");
// Returns: "Hi, Carol!"

// Exception cases
try {
    hw.getCustomGreeting("", "Alice");
    // Throws: IllegalArgumentException("Greeting word cannot be null or empty")
} catch (IllegalArgumentException e) {
    // Handle exception
}

try {
    hw.getCustomGreeting("Hello", null);
    // Throws: IllegalArgumentException("Name cannot be null or empty")
} catch (IllegalArgumentException e) {
    // Handle exception
}
```

---

#### `isValidName(String name)`

```java
public boolean isValidName(String name)
```

**Description:**  
Validates if a given string is a valid name according to standard criteria.

**Validation Criteria:**
- Must not be null
- Must not be empty or contain only whitespace
- Must contain only alphabetic characters (a-z, A-Z) and spaces
- No numbers, special characters, or symbols allowed

**Parameters:**
- `name` - The string to validate as a name

**Returns:**  
`true` if the name meets all validation criteria, `false` otherwise

**Throws:** None

**Behavior:**
- Returns `false` for null input
- Returns `false` for empty or whitespace-only input
- Uses regex pattern `^[a-zA-Z\\s]+$` for validation
- Trims input before validation

**Thread Safety:** Thread-safe

**Performance:** O(n) - linear time complexity based on string length

**Since:** 1.0

**Examples:**
```java
HelloWorld hw = new HelloWorld();

// Valid names
boolean result1 = hw.isValidName("John Doe");      // Returns: true
boolean result2 = hw.isValidName("Alice");         // Returns: true
boolean result3 = hw.isValidName("Mary Jane");     // Returns: true
boolean result4 = hw.isValidName("  Bob  ");       // Returns: true (trimmed)

// Invalid names
boolean result5 = hw.isValidName("John123");       // Returns: false (contains numbers)
boolean result6 = hw.isValidName("Alice@");        // Returns: false (contains symbol)
boolean result7 = hw.isValidName("");              // Returns: false (empty)
boolean result8 = hw.isValidName(null);            // Returns: false (null)
boolean result9 = hw.isValidName("   ");           // Returns: false (whitespace only)
boolean result10 = hw.isValidName("John-Doe");     // Returns: false (contains hyphen)
```

---

#### `getVersion()`

```java
public String getVersion()
```

**Description:**  
Returns the current version of the HelloWorld class. Useful for debugging, logging, and compatibility checking.

**Parameters:** None

**Returns:**  
The version string of this class (currently "1.0")

**Throws:** None

**Thread Safety:** Thread-safe

**Performance:** O(1) - constant time complexity

**Since:** 1.0

**Example:**
```java
HelloWorld hw = new HelloWorld();
String version = hw.getVersion();
// Returns: "1.0"

// Usage in logging
System.out.println("Using HelloWorld version: " + version);
```

---

#### `main(String[] args)` (Static)

```java
public static void main(String[] args)
```

**Description:**  
The main entry point of the application. Demonstrates the primary functionality of the HelloWorld class by executing various methods and printing results.

**Parameters:**
- `args` - Command line arguments (not used in this implementation)

**Returns:** `void`

**Throws:** None

**Behavior:**
- Prints the default greeting
- Creates a HelloWorld instance
- Demonstrates `getGreeting()` with "Abraham"
- Demonstrates `getCustomGreeting()` with "Welcome" and "Developer"

**Since:** 1.0

**Example:**
```bash
# Compile and run
javac abrham.java
java HelloWorld

# Expected output:
# Hello, World!
# Hello, Abraham!
# Welcome, Developer!
```

## Constants

### DEFAULT_GREETING

```java
private static final String DEFAULT_GREETING = "Hello, World!"
```

**Description:**  
The default greeting message used when no valid name is provided to the `getGreeting()` method.

**Visibility:** Private  
**Type:** `String`  
**Value:** `"Hello, World!"`  
**Mutability:** Immutable (final)  

## Exceptions

### IllegalArgumentException

The `getCustomGreeting()` method throws `IllegalArgumentException` in the following cases:

1. **Null or empty greeting word**
   - **Message:** "Greeting word cannot be null or empty"
   - **Cause:** The `greetingWord` parameter is null, empty, or contains only whitespace

2. **Null or empty name**
   - **Message:** "Name cannot be null or empty"
   - **Cause:** The `name` parameter is null, empty, or contains only whitespace

**Exception Handling Example:**
```java
HelloWorld hw = new HelloWorld();

try {
    String greeting = hw.getCustomGreeting("", "Alice");
} catch (IllegalArgumentException e) {
    System.err.println("Error: " + e.getMessage());
    // Error: Greeting word cannot be null or empty
}
```

## Usage Patterns

### Pattern 1: Simple Greeting Generation

```java
HelloWorld hw = new HelloWorld();
String greeting = hw.getGreeting(userName);
System.out.println(greeting);
```

**Use Case:** Basic greeting functionality where you want a consistent greeting format.

### Pattern 2: Custom Greeting with Validation

```java
HelloWorld hw = new HelloWorld();

if (hw.isValidName(userName)) {
    try {
        String customGreeting = hw.getCustomGreeting(greetingType, userName);
        System.out.println(customGreeting);
    } catch (IllegalArgumentException e) {
        System.err.println("Invalid greeting parameters: " + e.getMessage());
    }
} else {
    System.err.println("Invalid name format");
}
```

**Use Case:** When you need to validate inputs before creating custom greetings.

### Pattern 3: Defensive Programming

```java
HelloWorld hw = new HelloWorld();

// Safe greeting generation (handles null/empty gracefully)
String safeGreeting = hw.getGreeting(possiblyNullName);

// Validation before processing
if (hw.isValidName(inputName)) {
    // Process valid name
    processValidName(inputName);
} else {
    // Handle invalid name
    handleInvalidName(inputName);
}
```

**Use Case:** When dealing with unreliable input sources.

## Best Practices

### 1. Input Validation

Always validate inputs when using `getCustomGreeting()`:

```java
// Good
if (greetingWord != null && !greetingWord.trim().isEmpty() &&
    name != null && !name.trim().isEmpty()) {
    try {
        String greeting = hw.getCustomGreeting(greetingWord, name);
        // Use greeting
    } catch (IllegalArgumentException e) {
        // Handle exception
    }
}

// Also good - let the method handle validation
try {
    String greeting = hw.getCustomGreeting(greetingWord, name);
    // Use greeting
} catch (IllegalArgumentException e) {
    // Handle invalid input
}
```

### 2. Name Validation

Use `isValidName()` before processing names in business logic:

```java
// Good
if (hw.isValidName(userInput)) {
    String greeting = hw.getGreeting(userInput);
    // Process valid name
} else {
    // Request valid input from user
}
```

### 3. Thread Safety

The class is thread-safe, but create instances appropriately:

```java
// Good - shared instance for multiple threads
private static final HelloWorld HELLO_WORLD = new HelloWorld();

// Also good - instance per thread/operation
HelloWorld hw = new HelloWorld();
```

### 4. Error Handling

Handle exceptions appropriately based on your application's needs:

```java
// Application with user feedback
try {
    String greeting = hw.getCustomGreeting(word, name);
    displayGreeting(greeting);
} catch (IllegalArgumentException e) {
    showErrorToUser("Please provide valid greeting word and name");
}

// Logging application
try {
    String greeting = hw.getCustomGreeting(word, name);
    logger.info("Generated greeting: " + greeting);
} catch (IllegalArgumentException e) {
    logger.warn("Failed to generate greeting: " + e.getMessage());
}
```

## Performance Considerations

### Time Complexity

| Method | Time Complexity | Space Complexity |
|--------|-----------------|------------------|
| `getGreeting()` | O(1) | O(1) |
| `getCustomGreeting()` | O(1) | O(1) |
| `isValidName()` | O(n) | O(1) |
| `getVersion()` | O(1) | O(1) |

**Note:** n = length of the input string for `isValidName()`

### Memory Usage

- **Instance overhead:** Minimal (stateless class)
- **Method calls:** No significant memory allocation except for returned strings
- **String operations:** Uses `trim()` which creates new strings when whitespace is present

### Optimization Tips

1. **Reuse instances:** The class is stateless, so you can safely reuse instances
2. **Batch validation:** If validating multiple names, consider validating all at once
3. **Caching:** For repeated operations with the same input, consider caching results

```java
// Good for performance
HelloWorld hw = new HelloWorld(); // Reuse this instance

// Cache frequently used greetings
Map<String, String> greetingCache = new HashMap<>();
String cachedGreeting = greetingCache.computeIfAbsent(name, hw::getGreeting);
```

---

**Last Updated:** Version 1.0  
**Compatibility:** Java 8+  
**Thread Safety:** Thread-safe  
**Null Safety:** Null-safe (all methods handle null inputs appropriately)