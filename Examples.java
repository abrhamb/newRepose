/**
 * Examples - Comprehensive demonstration of HelloWorld API usage
 * 
 * This class contains multiple examples showing how to use the HelloWorld
 * class in various scenarios, including error handling, validation,
 * and best practices.
 * 
 * To run these examples:
 * 1. Compile: javac HelloWorld.java Examples.java
 * 2. Run: java Examples
 * 
 * @author API Documentation Generator
 * @version 1.0
 */
public class Examples {
    
    public static void main(String[] args) {
        System.out.println("=== HelloWorld API Usage Examples ===\n");
        
        // Run all example scenarios
        basicGreetingExample();
        customGreetingExample();
        nameValidationExample();
        errorHandlingExample();
        advancedUsageExample();
        performanceExample();
        
        System.out.println("\n=== All Examples Completed ===");
    }
    
    /**
     * Example 1: Basic Greeting Functionality
     * Demonstrates the simplest usage of the HelloWorld API
     */
    public static void basicGreetingExample() {
        System.out.println("--- Example 1: Basic Greeting ---");
        
        HelloWorld hw = new HelloWorld();
        
        // Simple greeting with a name
        String greeting1 = hw.getGreeting("Alice");
        System.out.println("Greeting for Alice: " + greeting1);
        
        // Greeting with empty string (returns default)
        String greeting2 = hw.getGreeting("");
        System.out.println("Greeting for empty string: " + greeting2);
        
        // Greeting with null (returns default)
        String greeting3 = hw.getGreeting(null);
        System.out.println("Greeting for null: " + greeting3);
        
        // Greeting with whitespace (trimmed)
        String greeting4 = hw.getGreeting("  Bob  ");
        System.out.println("Greeting for '  Bob  ': " + greeting4);
        
        System.out.println();
    }
    
    /**
     * Example 2: Custom Greeting Creation
     * Shows how to create personalized greetings with different greeting words
     */
    public static void customGreetingExample() {
        System.out.println("--- Example 2: Custom Greetings ---");
        
        HelloWorld hw = new HelloWorld();
        
        try {
            // Various greeting types
            String morning = hw.getCustomGreeting("Good morning", "Alice");
            System.out.println("Morning greeting: " + morning);
            
            String welcome = hw.getCustomGreeting("Welcome", "Team");
            System.out.println("Welcome message: " + welcome);
            
            String farewell = hw.getCustomGreeting("Goodbye", "Friend");
            System.out.println("Farewell message: " + farewell);
            
            String casual = hw.getCustomGreeting("Hey", "Buddy");
            System.out.println("Casual greeting: " + casual);
            
            // Greeting with whitespace (automatically trimmed)
            String trimmed = hw.getCustomGreeting("  Hi  ", "  Carol  ");
            System.out.println("Trimmed greeting: " + trimmed);
            
        } catch (IllegalArgumentException e) {
            System.err.println("Error in custom greeting: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Example 3: Name Validation
     * Demonstrates how to validate names before using them
     */
    public static void nameValidationExample() {
        System.out.println("--- Example 3: Name Validation ---");
        
        HelloWorld hw = new HelloWorld();
        
        // Test various name formats
        String[] testNames = {
            "John Doe",           // Valid: letters and space
            "Alice",              // Valid: single name
            "Mary Jane Smith",    // Valid: multiple names
            "Bob123",             // Invalid: contains numbers
            "Alice@Domain",       // Invalid: contains special characters
            "",                   // Invalid: empty
            null,                 // Invalid: null
            "   ",                // Invalid: whitespace only
            "John-Doe",           // Invalid: contains hyphen
            "O'Connor",           // Invalid: contains apostrophe
            "Jean Pierre",        // Valid: space between names
            "Anne-Marie"          // Invalid: contains hyphen
        };
        
        System.out.println("Name Validation Results:");
        for (String name : testNames) {
            boolean isValid = hw.isValidName(name);
            String nameDisplay = (name == null) ? "null" : "\"" + name + "\"";
            System.out.printf("%-20s -> %s%n", nameDisplay, isValid ? "Valid" : "Invalid");
        }
        
        System.out.println();
    }
    
    /**
     * Example 4: Error Handling
     * Shows how to properly handle exceptions and edge cases
     */
    public static void errorHandlingExample() {
        System.out.println("--- Example 4: Error Handling ---");
        
        HelloWorld hw = new HelloWorld();
        
        // Test cases that should throw exceptions
        System.out.println("Testing error scenarios:");
        
        // Empty greeting word
        try {
            hw.getCustomGreeting("", "Alice");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Caught expected error: " + e.getMessage());
        }
        
        // Null greeting word
        try {
            hw.getCustomGreeting(null, "Bob");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Caught expected error: " + e.getMessage());
        }
        
        // Empty name
        try {
            hw.getCustomGreeting("Hello", "");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Caught expected error: " + e.getMessage());
        }
        
        // Null name
        try {
            hw.getCustomGreeting("Hi", null);
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Caught expected error: " + e.getMessage());
        }
        
        // Whitespace-only parameters
        try {
            hw.getCustomGreeting("   ", "Carol");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Caught expected error: " + e.getMessage());
        }
        
        try {
            hw.getCustomGreeting("Hello", "   ");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Caught expected error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Example 5: Advanced Usage Patterns
     * Demonstrates real-world usage scenarios and best practices
     */
    public static void advancedUsageExample() {
        System.out.println("--- Example 5: Advanced Usage ---");
        
        HelloWorld hw = new HelloWorld();
        
        // Scenario 1: User registration welcome message
        System.out.println("Scenario 1: User Registration");
        String newUserName = "John Smith";
        if (hw.isValidName(newUserName)) {
            try {
                String welcomeMessage = hw.getCustomGreeting("Welcome to our platform", newUserName);
                System.out.println("Registration success: " + welcomeMessage);
            } catch (IllegalArgumentException e) {
                System.err.println("Failed to create welcome message: " + e.getMessage());
            }
        } else {
            System.err.println("Invalid name format for registration: " + newUserName);
        }
        
        // Scenario 2: Dynamic greeting based on time of day
        System.out.println("\nScenario 2: Time-based Greetings");
        String userName = "Alice";
        String[] timeBasedGreetings = {"Good morning", "Good afternoon", "Good evening"};
        
        for (String timeGreeting : timeBasedGreetings) {
            if (hw.isValidName(userName)) {
                try {
                    String greeting = hw.getCustomGreeting(timeGreeting, userName);
                    System.out.println(greeting);
                } catch (IllegalArgumentException e) {
                    // Fallback to default greeting
                    System.out.println("Fallback: " + hw.getGreeting(userName));
                }
            }
        }
        
        // Scenario 3: Batch processing with validation
        System.out.println("\nScenario 3: Batch Processing");
        String[] users = {"Alice Johnson", "Bob123", "Carol Smith", "", "David Lee"};
        System.out.println("Processing user list:");
        
        for (String user : users) {
            if (hw.isValidName(user)) {
                String greeting = hw.getGreeting(user);
                System.out.println("✓ Processed: " + greeting);
            } else {
                System.out.println("✗ Skipped invalid name: \"" + user + "\"");
            }
        }
        
        // Scenario 4: API version checking
        System.out.println("\nScenario 4: Version Information");
        String apiVersion = hw.getVersion();
        System.out.println("Using HelloWorld API version: " + apiVersion);
        
        System.out.println();
    }
    
    /**
     * Example 6: Performance Demonstration
     * Shows performance characteristics and optimization techniques
     */
    public static void performanceExample() {
        System.out.println("--- Example 6: Performance Demonstration ---");
        
        HelloWorld hw = new HelloWorld();
        
        // Demonstrate reusability of instances
        System.out.println("Testing instance reusability:");
        long startTime = System.nanoTime();
        
        for (int i = 0; i < 1000; i++) {
            hw.getGreeting("User" + i);
        }
        
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000; // Convert to milliseconds
        System.out.println("Generated 1000 greetings in " + duration + " ms");
        
        // Demonstrate validation performance
        System.out.println("\nTesting validation performance:");
        String[] testNames = {"Valid Name", "Invalid123", "Another Valid Name", "Invalid@Name"};
        
        startTime = System.nanoTime();
        int validCount = 0;
        
        for (int i = 0; i < 1000; i++) {
            for (String name : testNames) {
                if (hw.isValidName(name)) {
                    validCount++;
                }
            }
        }
        
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1_000_000;
        System.out.println("Validated 4000 names in " + duration + " ms");
        System.out.println("Valid names found: " + validCount);
        
        // Memory efficiency demonstration
        System.out.println("\nMemory efficiency:");
        System.out.println("HelloWorld instance is stateless - safe to reuse");
        System.out.println("No memory leaks from method calls");
        
        System.out.println();
    }
}

/**
 * UserGreetingService - Example of integrating HelloWorld into a service class
 * 
 * This demonstrates how HelloWorld might be used in a real application
 * as part of a larger service architecture.
 */
class UserGreetingService {
    private final HelloWorld helloWorld;
    
    public UserGreetingService() {
        this.helloWorld = new HelloWorld();
    }
    
    /**
     * Creates a greeting for a user with input validation and error handling
     */
    public String createUserGreeting(String greetingType, String userName) {
        // Validate inputs
        if (greetingType == null || greetingType.trim().isEmpty()) {
            greetingType = "Hello"; // Default greeting type
        }
        
        if (!helloWorld.isValidName(userName)) {
            throw new IllegalArgumentException("Invalid user name: " + userName);
        }
        
        try {
            return helloWorld.getCustomGreeting(greetingType, userName);
        } catch (IllegalArgumentException e) {
            // Fallback to simple greeting
            return helloWorld.getGreeting(userName);
        }
    }
    
    /**
     * Validates a user name using the HelloWorld API
     */
    public boolean isValidUserName(String userName) {
        return helloWorld.isValidName(userName);
    }
    
    /**
     * Gets the API version for logging/debugging
     */
    public String getApiVersion() {
        return helloWorld.getVersion();
    }
}