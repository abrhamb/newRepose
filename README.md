# HelloWorld API Documentation

A comprehensive Java utility library providing greeting functionality and name validation utilities.

## Table of Contents

- [Overview](#overview)
- [Quick Start](#quick-start)
- [API Reference](#api-reference)
- [Examples](#examples)
- [Building and Running](#building-and-running)
- [Requirements](#requirements)
- [Contributing](#contributing)

## Overview

The HelloWorld library is a demonstration project showcasing proper Java API design and documentation practices. It provides a simple yet comprehensive set of utilities for:

- Generating personalized greeting messages
- Validating names according to standard criteria
- Creating custom greetings with flexible parameters
- Version tracking and API information

## Quick Start

### Basic Usage

```java
// Create an instance
HelloWorld hw = new HelloWorld();

// Generate a simple greeting
String greeting = hw.getGreeting("Alice");
System.out.println(greeting); // Output: "Hello, Alice!"

// Create a custom greeting
String customGreeting = hw.getCustomGreeting("Welcome", "Bob");
System.out.println(customGreeting); // Output: "Welcome, Bob!"

// Validate a name
boolean isValid = hw.isValidName("John Doe");
System.out.println(isValid); // Output: true
```

### Running the Application

```bash
# Compile the Java file
javac HelloWorld.java

# Run the main method
java HelloWorld
```

## API Reference

### Class: HelloWorld

The main utility class providing greeting and validation functionality.

#### Public Methods

##### `getGreeting(String name)`

Creates a personalized greeting message for a given name.

**Parameters:**
- `name` (String): The name to include in the greeting. Can be null or empty.

**Returns:**
- `String`: A personalized greeting string, or default greeting if name is invalid

**Example:**
```java
HelloWorld hw = new HelloWorld();
String greeting = hw.getGreeting("Alice");     // Returns: "Hello, Alice!"
String defaultGreeting = hw.getGreeting("");  // Returns: "Hello, World!"
```

---

##### `getCustomGreeting(String greetingWord, String name)`

Creates a custom greeting with a specified greeting word and name.

**Parameters:**
- `greetingWord` (String): The greeting word to use (e.g., "Welcome", "Hi", "Greetings")
- `name` (String): The name to greet

**Returns:**
- `String`: A formatted custom greeting string

**Throws:**
- `IllegalArgumentException`: if either parameter is null or empty

**Example:**
```java
HelloWorld hw = new HelloWorld();
String customGreeting = hw.getCustomGreeting("Welcome", "Bob");
// Returns: "Welcome, Bob!"

String anotherGreeting = hw.getCustomGreeting("Hi", "Carol");
// Returns: "Hi, Carol!"
```

---

##### `isValidName(String name)`

Validates if a given string is a valid name (not null, not empty, contains only letters and spaces).

**Parameters:**
- `name` (String): The string to validate as a name

**Returns:**
- `boolean`: true if the name is valid, false otherwise

**Validation Criteria:**
- Must not be null
- Must not be empty or only whitespace
- Must contain only alphabetic characters and spaces
- No numbers or special characters allowed

**Example:**
```java
HelloWorld hw = new HelloWorld();
boolean isValid1 = hw.isValidName("John Doe");    // Returns: true
boolean isValid2 = hw.isValidName("John123");     // Returns: false
boolean isValid3 = hw.isValidName("");            // Returns: false
boolean isValid4 = hw.isValidName(null);          // Returns: false
```

---

##### `getVersion()`

Returns the current version of the HelloWorld class.

**Returns:**
- `String`: The version string of this class

**Example:**
```java
HelloWorld hw = new HelloWorld();
String version = hw.getVersion(); // Returns: "1.0"
```

---

##### `main(String[] args)` (Static)

The main entry point of the application. Demonstrates the primary functionality of the HelloWorld class.

**Parameters:**
- `args` (String[]): Command line arguments (not used in this implementation)

**Example:**
```bash
java HelloWorld
# Output: 
# Hello, World!
# Hello, Abraham!
# Welcome, Developer!
```

## Examples

### Example 1: Basic Greeting

```java
public class GreetingExample {
    public static void main(String[] args) {
        HelloWorld hw = new HelloWorld();
        
        // Simple greeting
        System.out.println(hw.getGreeting("World"));
        // Output: Hello, World!
    }
}
```

### Example 2: Custom Greetings

```java
public class CustomGreetingExample {
    public static void main(String[] args) {
        HelloWorld hw = new HelloWorld();
        
        // Various custom greetings
        System.out.println(hw.getCustomGreeting("Good morning", "Alice"));
        System.out.println(hw.getCustomGreeting("Welcome", "Team"));
        System.out.println(hw.getCustomGreeting("Greetings", "Visitor"));
        
        // Output:
        // Good morning, Alice!
        // Welcome, Team!
        // Greetings, Visitor!
    }
}
```

### Example 3: Name Validation

```java
public class ValidationExample {
    public static void main(String[] args) {
        HelloWorld hw = new HelloWorld();
        String[] testNames = {"John Doe", "Alice", "Bob123", "", null, "Mary Jane"};
        
        for (String name : testNames) {
            boolean isValid = hw.isValidName(name);
            System.out.println("Name: '" + name + "' is " + (isValid ? "valid" : "invalid"));
        }
        
        // Output:
        // Name: 'John Doe' is valid
        // Name: 'Alice' is valid
        // Name: 'Bob123' is invalid
        // Name: '' is invalid
        // Name: 'null' is invalid
        // Name: 'Mary Jane' is valid
    }
}
```

### Example 4: Error Handling

```java
public class ErrorHandlingExample {
    public static void main(String[] args) {
        HelloWorld hw = new HelloWorld();
        
        try {
            // This will throw an IllegalArgumentException
            hw.getCustomGreeting("", "Alice");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            // Output: Error: Greeting word cannot be null or empty
        }
        
        try {
            // This will also throw an IllegalArgumentException
            hw.getCustomGreeting("Hello", null);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            // Output: Error: Name cannot be null or empty
        }
    }
}
```

## Building and Running

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Any Java IDE (optional, but recommended for development)

### Compilation

```bash
# Compile the main class
javac HelloWorld.java

# If you create additional example files
javac *.java
```

### Running

```bash
# Run the main HelloWorld application
java HelloWorld

# Run specific examples (if you create them)
java GreetingExample
java CustomGreetingExample
java ValidationExample
java ErrorHandlingExample
```

### Generating JavaDoc

```bash
# Generate HTML documentation from JavaDoc comments
javadoc -d docs HelloWorld.java

# Open docs/index.html in your browser to view the generated documentation
```

## Requirements

- **Java Version**: JDK 8 or higher
- **Dependencies**: None (uses only standard Java libraries)
- **Operating System**: Platform independent (Windows, macOS, Linux)

## API Design Principles

This library follows several important API design principles:

1. **Null Safety**: All public methods handle null inputs gracefully
2. **Input Validation**: Parameters are validated and appropriate exceptions are thrown
3. **Immutability**: Methods don't modify input parameters
4. **Clear Documentation**: Every public method includes comprehensive JavaDoc
5. **Consistent Naming**: Method names clearly indicate their purpose
6. **Error Handling**: Exceptions include descriptive error messages

## Contributing

When contributing to this project, please ensure:

1. All public methods include comprehensive JavaDoc comments
2. Add unit tests for new functionality
3. Follow the existing code style and naming conventions
4. Update this README if you add new public APIs
5. Include examples for complex functionality

## Version History

- **v1.0**: Initial release with basic greeting and validation functionality

---

**Note**: This is a demonstration project designed to showcase proper API documentation practices. The functionality is intentionally simple to focus on documentation quality and completeness.