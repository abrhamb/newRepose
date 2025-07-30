/**
 * HelloWorld - A comprehensive utility class for demonstration purposes
 * 
 * This class provides basic greeting functionality and utility methods
 * to showcase proper Java documentation and API design.
 * 
 * @author Abraham
 * @version 1.0
 * @since 1.0
 */
public class HelloWorld {
    
    /**
     * Default greeting message used by the application
     */
    private static final String DEFAULT_GREETING = "Hello, World!";
    
    /**
     * The main entry point of the application.
     * 
     * This method demonstrates the primary functionality of the HelloWorld class
     * by printing a greeting message to the console.
     * 
     * @param args Command line arguments (not used in this implementation)
     * 
     * @example
     * <pre>
     * java HelloWorld
     * // Output: Hello, World!
     * </pre>
     */
    public static void main(String[] args) {
        System.out.println(DEFAULT_GREETING);
        
        // Demonstrate other public methods
        HelloWorld hw = new HelloWorld();
        System.out.println(hw.getGreeting("Abraham"));
        System.out.println(hw.getCustomGreeting("Welcome", "Developer"));
    }
    
    /**
     * Creates a personalized greeting message for a given name.
     * 
     * This method takes a name parameter and returns a formatted greeting
     * message. If the name is null or empty, it returns the default greeting.
     * 
     * @param name The name to include in the greeting. Can be null or empty.
     * @return A personalized greeting string, or default greeting if name is invalid
     * 
     * @example
     * <pre>
     * HelloWorld hw = new HelloWorld();
     * String greeting = hw.getGreeting("Alice");
     * // Returns: "Hello, Alice!"
     * 
     * String defaultGreeting = hw.getGreeting("");
     * // Returns: "Hello, World!"
     * </pre>
     */
    public String getGreeting(String name) {
        if (name == null || name.trim().isEmpty()) {
            return DEFAULT_GREETING;
        }
        return "Hello, " + name.trim() + "!";
    }
    
    /**
     * Creates a custom greeting with a specified greeting word and name.
     * 
     * This method allows for complete customization of both the greeting
     * word and the target name. Both parameters are validated and sanitized.
     * 
     * @param greetingWord The greeting word to use (e.g., "Welcome", "Hi", "Greetings")
     * @param name The name to greet
     * @return A formatted custom greeting string
     * @throws IllegalArgumentException if either parameter is null or empty
     * 
     * @example
     * <pre>
     * HelloWorld hw = new HelloWorld();
     * String customGreeting = hw.getCustomGreeting("Welcome", "Bob");
     * // Returns: "Welcome, Bob!"
     * 
     * String anotherGreeting = hw.getCustomGreeting("Hi", "Carol");
     * // Returns: "Hi, Carol!"
     * </pre>
     */
    public String getCustomGreeting(String greetingWord, String name) {
        if (greetingWord == null || greetingWord.trim().isEmpty()) {
            throw new IllegalArgumentException("Greeting word cannot be null or empty");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        
        return greetingWord.trim() + ", " + name.trim() + "!";
    }
    
    /**
     * Validates if a given string is a valid name (not null, not empty, contains only letters and spaces).
     * 
     * This utility method checks if a string can be considered a valid name
     * according to basic criteria: non-null, non-empty, and containing only
     * alphabetic characters and spaces.
     * 
     * @param name The string to validate as a name
     * @return true if the name is valid, false otherwise
     * 
     * @example
     * <pre>
     * HelloWorld hw = new HelloWorld();
     * boolean isValid1 = hw.isValidName("John Doe");    // Returns: true
     * boolean isValid2 = hw.isValidName("John123");     // Returns: false
     * boolean isValid3 = hw.isValidName("");            // Returns: false
     * boolean isValid4 = hw.isValidName(null);          // Returns: false
     * </pre>
     */
    public boolean isValidName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        
        String trimmedName = name.trim();
        return trimmedName.matches("^[a-zA-Z\\s]+$");
    }
    
    /**
     * Returns the current version of the HelloWorld class.
     * 
     * This method provides version information for the API, useful for
     * debugging and compatibility checking.
     * 
     * @return The version string of this class
     * 
     * @example
     * <pre>
     * HelloWorld hw = new HelloWorld();
     * String version = hw.getVersion();
     * // Returns: "1.0"
     * </pre>
     */
    public String getVersion() {
        return "1.0";
    }
}
