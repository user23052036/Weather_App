import org.json.JSONObject;
import org.json.JSONArray;

/**
 * Demonstrates basic JSON creation and manipulation using the org.json library.
 * This class shows how to create JSON objects and arrays, add various data types,
 * and print the resulting JSON structures.
 * 
 * Purpose: Educational example for beginners learning JSON handling in Java.
 * Expected Output: Prints a JSON array and a JSON object to the console.
 */
public class Demo_JSON 
{
    /**
     * Main method that demonstrates JSON object and array creation.
     * Creates a sample JSON object with various data types including strings,
     * booleans, null values, and nested arrays.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) 
    {
        // Create an empty JSON object to store key-value pairs
        JSONObject obj = new JSONObject();
        
        // Create an empty JSON array to store multiple values
        JSONArray arr = new JSONArray();
        
        // Add different data types to the array
        arr.put("games");           // String value
        arr.put(false);              // Boolean value
        arr.put(JSONObject.NULL);    // Null value
        arr.put("money");            // Another string value
        
        // Add key-value pairs to the JSON object
        obj.put("name","sonu");
        obj.put("isStudent","false");
        obj.put("dead",JSONObject.NULL);
        obj.put("random array ",arr);
        
        // Create and add an inline JSON array with skills
        obj.put("skills", new JSONArray().put("Java").put("Python"));
        
        // Print the JSON array to console
        System.out.println(arr);
        
        // Print the JSON object to console
        System.out.println(obj);
    }
}