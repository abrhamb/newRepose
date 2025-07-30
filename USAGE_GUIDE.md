# HelloWorld API Usage Guide

## Quick Start Guide

This guide will help you get started with the HelloWorld API quickly and efficiently.

## Table of Contents

1. [Installation and Setup](#installation-and-setup)
2. [Basic Usage](#basic-usage)
3. [Common Patterns](#common-patterns)
4. [Advanced Features](#advanced-features)
5. [Error Handling](#error-handling)
6. [Best Practices](#best-practices)
7. [Troubleshooting](#troubleshooting)
8. [Migration Guide](#migration-guide)

## Installation and Setup

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Text editor or IDE (IntelliJ IDEA, Eclipse, VS Code, etc.)

### Getting Started

1. **Download the source code**
   ```bash
   # Download HelloWorld.java file to your project directory
   ```

2. **Compile the code**
   ```bash
   javac HelloWorld.java
   ```

3. **Verify installation**
   ```bash
   java HelloWorld
   ```

   Expected output:
   ```
   Hello, World!
   Hello, Abraham!
   Welcome, Developer!
   ```

## Basic Usage

### Creating an Instance

```java
// Create a new HelloWorld instance
HelloWorld hw = new HelloWorld();
```

### Simple Greetings

```java
// Basic greeting with a name
String greeting = hw.getGreeting("Alice");
System.out.println(greeting); // Output: Hello, Alice!

// Handling null or empty names gracefully
String defaultGreeting = hw.getGreeting(null);
System.out.println(defaultGreeting); // Output: Hello, World!
```

### Custom Greetings

```java
// Create custom greetings with different formats
String customGreeting = hw.getCustomGreeting("Welcome", "Bob");
System.out.println(customGreeting); // Output: Welcome, Bob!

String morningGreeting = hw.getCustomGreeting("Good morning", "Carol");
System.out.println(morningGreeting); // Output: Good morning, Carol!
```

### Name Validation

```java
// Validate names before processing
boolean isValid = hw.isValidName("John Doe");
if (isValid) {
    String greeting = hw.getGreeting("John Doe");
    System.out.println(greeting);
} else {
    System.out.println("Invalid name format");
}
```

## Common Patterns

### Pattern 1: Safe Greeting Generation

This pattern ensures your application never crashes due to invalid input:

```java
public class SafeGreetingGenerator {
    private final HelloWorld hw = new HelloWorld();
    
    public String generateSafeGreeting(String name) {
        // Always returns a valid greeting, even for invalid input
        return hw.getGreeting(name);
    }
    
    public String generateSafeCustomGreeting(String greetingWord, String name) {
        try {
            return hw.getCustomGreeting(greetingWord, name);
        } catch (IllegalArgumentException e) {
            // Fallback to basic greeting
            return hw.getGreeting(name);
        }
    }
}
```

### Pattern 2: Input Validation and Sanitization

This pattern validates and sanitizes input before processing:

```java
public class ValidatedGreetingService {
    private final HelloWorld hw = new HelloWorld();
    
    public String createValidatedGreeting(String name) {
        if (!hw.isValidName(name)) {
            throw new IllegalArgumentException("Invalid name: " + name);
        }
        return hw.getGreeting(name);
    }
    
    public boolean canCreateGreeting(String name) {
        return hw.isValidName(name);
    }
}
```

### Pattern 3: Batch Processing

This pattern efficiently processes multiple names:

```java
public class BatchGreetingProcessor {
    private final HelloWorld hw = new HelloWorld();
    
    public List<String> processNames(List<String> names) {
        List<String> greetings = new ArrayList<>();
        
        for (String name : names) {
            if (hw.isValidName(name)) {
                greetings.add(hw.getGreeting(name));
            } else {
                greetings.add("Invalid name: " + name);
            }
        }
        
        return greetings;
    }
    
    public Map<String, Boolean> validateNames(List<String> names) {
        Map<String, Boolean> results = new HashMap<>();
        
        for (String name : names) {
            results.put(name, hw.isValidName(name));
        }
        
        return results;
    }
}
```

### Pattern 4: Configuration-Driven Greetings

This pattern allows for flexible greeting configuration:

```java
public class ConfigurableGreetingService {
    private final HelloWorld hw = new HelloWorld();
    private final Map<String, String> greetingTemplates;
    
    public ConfigurableGreetingService() {
        greetingTemplates = new HashMap<>();
        greetingTemplates.put("formal", "Good day");
        greetingTemplates.put("casual", "Hey");
        greetingTemplates.put("morning", "Good morning");
        greetingTemplates.put("evening", "Good evening");
    }
    
    public String createGreeting(String style, String name) {
        if (!hw.isValidName(name)) {
            throw new IllegalArgumentException("Invalid name: " + name);
        }
        
        String greetingWord = greetingTemplates.getOrDefault(style, "Hello");
        
        try {
            return hw.getCustomGreeting(greetingWord, name);
        } catch (IllegalArgumentException e) {
            return hw.getGreeting(name);
        }
    }
}
```

## Advanced Features

### Thread Safety

The HelloWorld class is thread-safe and can be used in multi-threaded environments:

```java
public class ThreadSafeGreetingService {
    // Shared instance - safe to use across multiple threads
    private static final HelloWorld hw = new HelloWorld();
    
    public static String getThreadSafeGreeting(String name) {
        return hw.getGreeting(name);
    }
}

// Usage in multiple threads
ExecutorService executor = Executors.newFixedThreadPool(10);

for (int i = 0; i < 100; i++) {
    final String name = "User" + i;
    executor.submit(() -> {
        String greeting = ThreadSafeGreetingService.getThreadSafeGreeting(name);
        System.out.println(Thread.currentThread().getName() + ": " + greeting);
    });
}
```

### Performance Optimization

For high-performance scenarios, consider these optimizations:

```java
public class OptimizedGreetingService {
    private final HelloWorld hw = new HelloWorld();
    private final Map<String, String> greetingCache = new ConcurrentHashMap<>();
    
    // Cache frequently used greetings
    public String getCachedGreeting(String name) {
        return greetingCache.computeIfAbsent(name, hw::getGreeting);
    }
    
    // Batch validation for better performance
    public Set<String> getValidNames(Collection<String> names) {
        return names.stream()
                   .filter(hw::isValidName)
                   .collect(Collectors.toSet());
    }
}
```

### Integration with Logging

```java
public class LoggingGreetingService {
    private static final Logger logger = LoggerFactory.getLogger(LoggingGreetingService.class);
    private final HelloWorld hw = new HelloWorld();
    
    public String createGreetingWithLogging(String name) {
        logger.debug("Creating greeting for name: {}", name);
        
        if (!hw.isValidName(name)) {
            logger.warn("Invalid name provided: {}", name);
            return hw.getGreeting(null); // Use default
        }
        
        String greeting = hw.getGreeting(name);
        logger.info("Generated greeting: {}", greeting);
        
        return greeting;
    }
}
```

## Error Handling

### Understanding Exceptions

The HelloWorld API throws `IllegalArgumentException` in specific cases:

```java
public class ErrorHandlingExamples {
    private final HelloWorld hw = new HelloWorld();
    
    public void demonstrateErrorHandling() {
        // This will throw IllegalArgumentException
        try {
            hw.getCustomGreeting("", "Alice");
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
            // Handle error appropriately
        }
        
        // This will throw IllegalArgumentException
        try {
            hw.getCustomGreeting("Hello", null);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
            // Handle error appropriately
        }
    }
}
```

### Graceful Error Recovery

```java
public class RobustGreetingService {
    private final HelloWorld hw = new HelloWorld();
    
    public String createRobustGreeting(String greetingWord, String name) {
        try {
            // Attempt to create custom greeting
            return hw.getCustomGreeting(greetingWord, name);
        } catch (IllegalArgumentException e) {
            // Log the error
            System.err.println("Failed to create custom greeting: " + e.getMessage());
            
            // Try fallback to simple greeting
            try {
                return hw.getGreeting(name);
            } catch (Exception fallbackError) {
                // Final fallback
                return "Hello, there!";
            }
        }
    }
}
```

### Validation Before Operation

```java
public class PreValidatedGreetingService {
    private final HelloWorld hw = new HelloWorld();
    
    public String createValidatedCustomGreeting(String greetingWord, String name) {
        // Pre-validate inputs
        if (greetingWord == null || greetingWord.trim().isEmpty()) {
            throw new IllegalArgumentException("Greeting word is required");
        }
        
        if (!hw.isValidName(name)) {
            throw new IllegalArgumentException("Invalid name format: " + name);
        }
        
        // Safe to call now - we've pre-validated
        return hw.getCustomGreeting(greetingWord, name);
    }
}
```

## Best Practices

### 1. Instance Management

```java
// Good: Reuse instances (class is stateless)
public class GreetingService {
    private final HelloWorld hw = new HelloWorld();
    
    public String greet(String name) {
        return hw.getGreeting(name);
    }
}

// Also good: Static instance for application-wide use
public class GlobalGreetingService {
    private static final HelloWorld HW = new HelloWorld();
    
    public static String greet(String name) {
        return HW.getGreeting(name);
    }
}
```

### 2. Input Validation

```java
// Good: Validate early and provide clear error messages
public String createGreeting(String name) {
    if (name == null) {
        throw new IllegalArgumentException("Name cannot be null");
    }
    
    if (!hw.isValidName(name)) {
        throw new IllegalArgumentException(
            "Name must contain only letters and spaces: " + name
        );
    }
    
    return hw.getGreeting(name);
}
```

### 3. Error Message Handling

```java
// Good: Provide meaningful error messages to users
public class UserFriendlyGreetingService {
    private final HelloWorld hw = new HelloWorld();
    
    public Result<String> createGreeting(String name) {
        if (!hw.isValidName(name)) {
            return Result.error("Please enter a valid name (letters and spaces only)");
        }
        
        String greeting = hw.getGreeting(name);
        return Result.success(greeting);
    }
}

// Helper class for clean error handling
class Result<T> {
    private final T value;
    private final String error;
    private final boolean success;
    
    private Result(T value, String error, boolean success) {
        this.value = value;
        this.error = error;
        this.success = success;
    }
    
    public static <T> Result<T> success(T value) {
        return new Result<>(value, null, true);
    }
    
    public static <T> Result<T> error(String error) {
        return new Result<>(null, error, false);
    }
    
    public boolean isSuccess() { return success; }
    public T getValue() { return value; }
    public String getError() { return error; }
}
```

### 4. Documentation and Examples

```java
/**
 * Service for creating user greetings with comprehensive validation.
 * 
 * Example usage:
 * <pre>
 * GreetingService service = new GreetingService();
 * String greeting = service.createGreeting("John Doe");
 * System.out.println(greeting); // Output: Hello, John Doe!
 * </pre>
 */
public class WellDocumentedGreetingService {
    private final HelloWorld hw = new HelloWorld();
    
    /**
     * Creates a greeting for the specified name.
     * 
     * @param name the name to greet (must be valid according to isValidName)
     * @return a greeting string
     * @throws IllegalArgumentException if name is invalid
     */
    public String createGreeting(String name) {
        return hw.getGreeting(name);
    }
}
```

## Troubleshooting

### Common Issues and Solutions

#### Issue: "IllegalArgumentException: Greeting word cannot be null or empty"

**Cause:** Passing null or empty string as greeting word to `getCustomGreeting()`

**Solution:**
```java
// Bad
hw.getCustomGreeting("", "Alice");

// Good
String greetingWord = "Hello";
if (greetingWord != null && !greetingWord.trim().isEmpty()) {
    hw.getCustomGreeting(greetingWord, "Alice");
}
```

#### Issue: "Name validation always returns false"

**Cause:** Name contains numbers, special characters, or is improperly formatted

**Solution:**
```java
// Check what makes a valid name
String name = "John123";
boolean isValid = hw.isValidName(name); // false - contains numbers

// Valid names contain only letters and spaces
String validName = "John Doe";
boolean isValid2 = hw.isValidName(validName); // true
```

#### Issue: "Getting default greeting instead of personalized one"

**Cause:** Name parameter is null, empty, or whitespace-only

**Solution:**
```java
// Bad - will return default greeting
String greeting = hw.getGreeting("   ");

// Good - trim and validate first
String name = "   Alice   ";
if (name != null && !name.trim().isEmpty()) {
    greeting = hw.getGreeting(name.trim());
}
```

### Debugging Tips

1. **Check API version**
   ```java
   String version = hw.getVersion();
   System.out.println("Using HelloWorld API version: " + version);
   ```

2. **Enable debug logging**
   ```java
   public String debugGreeting(String name) {
       System.out.println("Input name: '" + name + "'");
       System.out.println("Is valid: " + hw.isValidName(name));
       
       String result = hw.getGreeting(name);
       System.out.println("Result: '" + result + "'");
       
       return result;
   }
   ```

3. **Test with known good values**
   ```java
   // These should always work
   assert hw.getGreeting("Alice").equals("Hello, Alice!");
   assert hw.isValidName("John Doe") == true;
   assert hw.getVersion().equals("1.0");
   ```

## Migration Guide

### From Simple Print Statements

If you're migrating from simple print statements:

```java
// Old way
System.out.println("Hello, " + name);

// New way
HelloWorld hw = new HelloWorld();
String greeting = hw.getGreeting(name);
System.out.println(greeting);
```

### From Custom Greeting Logic

If you have existing custom greeting logic:

```java
// Old way
public String createGreeting(String type, String name) {
    if (name == null || name.isEmpty()) {
        return "Hello, World!";
    }
    return type + ", " + name + "!";
}

// New way
public String createGreeting(String type, String name) {
    HelloWorld hw = new HelloWorld();
    
    if (type == null || type.isEmpty()) {
        return hw.getGreeting(name);
    }
    
    try {
        return hw.getCustomGreeting(type, name);
    } catch (IllegalArgumentException e) {
        return hw.getGreeting(name);
    }
}
```

### Performance Considerations During Migration

```java
// If you're processing many greetings, reuse the instance
public class MigrationExample {
    private final HelloWorld hw = new HelloWorld(); // Reuse this
    
    public List<String> migrateGreetings(List<String> names) {
        return names.stream()
                   .map(hw::getGreeting) // Reuses the same instance
                   .collect(Collectors.toList());
    }
}
```

## Conclusion

The HelloWorld API provides a simple yet powerful interface for creating greetings and validating names. By following the patterns and best practices outlined in this guide, you can build robust applications that handle edge cases gracefully and provide excellent user experiences.

For more detailed information, refer to:
- [API_DOCUMENTATION.md](API_DOCUMENTATION.md) - Complete API reference
- [README.md](README.md) - Project overview and quick start
- [Examples.java](Examples.java) - Comprehensive code examples

---

**Need Help?** 

Check the examples in `Examples.java` or refer to the comprehensive API documentation for detailed method specifications and additional usage patterns.