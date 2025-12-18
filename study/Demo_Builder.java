/**
 * Represents a Phone object built using the Builder design pattern.
 * This class demonstrates how to create immutable objects with many optional parameters
 * using a fluent API approach, similar to Java's HttpClient.newBuilder().
 * 
 * All fields are final, making the Phone object immutable after construction.
 */
class Phone {
    private final String phName;
    private final String os;
    private final int cores;
    private final boolean screenTouch;
    
    /**
     * Private constructor that takes a Builder object.
     * This ensures objects can only be created through the Builder.
     * 
     * @param builder the Builder object containing all phone properties
     */
    private Phone(Builder builder) 
    {
        this.phName = builder.phName;
        this.os = builder.os;
        this.cores = builder.cores;
        this.screenTouch = builder.screenTouch;
    }
    
    /**
     * Gets the phone name.
     * 
     * @return the phone brand/model name
     */
    public String getPhName() { return phName; }
    
    /**
     * Gets the operating system.
     * 
     * @return the OS name (e.g., "Android", "iOS")
     */
    public String getOs() { return os; }
    
    /**
     * Gets the number of processor cores.
     * 
     * @return the number of cores
     */
    public int getCores() { return cores; }
    
    /**
     * Checks if the phone has a touchscreen.
     * 
     * @return true if touchscreen is present, false otherwise
     */
    public boolean isScreenTouch() { return screenTouch; }
    
    /**
     * Static nested Builder class for constructing Phone objects.
     * Uses method chaining to provide a fluent API for setting properties.
     */
    public static class Builder 
    {
        private String phName;
        private String os;
        private int cores;
        private boolean screenTouch;
        
        /**
         * Sets the phone name.
         * 
         * @param phName the phone brand/model name
         * @return this Builder instance for method chaining
         */
        public Builder setPhName(String phName) 
        {
            this.phName = phName;
            return this;
        }
        
        /**
         * Sets the operating system.
         * 
         * @param os the OS name (e.g., "Android", "iOS")
         * @return this Builder instance for method chaining
         */
        public Builder setOs(String os) 
        {
            this.os = os;
            return this;
        }
        
        /**
         * Sets the number of processor cores.
         * 
         * @param cores the number of cores
         * @return this Builder instance for method chaining
         */
        public Builder setCores(int cores) 
        {
            this.cores = cores;
            return this;
        }
        
        /**
         * Sets whether the phone has a touchscreen.
         * 
         * @param screenTouch true if touchscreen, false otherwise
         * @return this Builder instance for method chaining
         */
        public Builder setScreenTouch(boolean screenTouch) 
        {
            this.screenTouch = screenTouch;
            return this;
        }
        
        /**
         * Builds and returns the final Phone object.
         * 
         * @return a new immutable Phone instance with the configured properties
         */
        public Phone build() 
        {
            return new Phone(this);
        }
    }
    
    /**
     * Static factory method for creating a new Builder instance.
     * Provides a convenient entry point similar to HttpClient.newBuilder().
     * 
     * @return a new Builder instance
     */
    public static Builder newBuilder() 
    {
        return new Builder();
    }
}

/**
 * Demonstrates the Builder design pattern for object creation.
 * This class shows how to use the Phone.Builder to create Phone objects
 * with a clean, readable fluent API.
 * 
 * Purpose: Educational example showing the Builder pattern in action.
 * Expected Output: Prints "Samsung" to the console.
 */
public class Demo_Builder 
{
    /**
     * Main method that demonstrates using the Builder pattern.
     * Creates a Phone object using method chaining and prints its name.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) 
    {
        // Build a Phone object using the fluent Builder API
        Phone phone = Phone.newBuilder()
            .setPhName("Samsung")
            .setOs("Android")
            .setCores(8)
            .setScreenTouch(true)
            .build();
        
        // Print the phone name
        System.out.println(phone.getPhName());
    }
}