import java.net.URI;
import java.time.Duration;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Demonstrates the four main HTTP methods (GET, POST, PUT, DELETE) using Java's HttpClient.
 * This class shows how to make different types of HTTP requests to a RESTful API
 * and handle their responses.
 * 
 * Purpose: Educational example for beginners learning HTTP client operations in Java.
 * Expected Output: Prints response codes and bodies for GET, POST, PUT, and DELETE requests.
 */
public class HttpClientExamples 
{
    // Create a reusable HttpClient with HTTP/2 support and 10-second timeout
    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .connectTimeout(Duration.ofSeconds(10))
            .build();
    
    /**
     * Main method that executes all HTTP request examples.
     * Demonstrates GET, POST, PUT, and DELETE operations in sequence.
     * 
     * @param args command line arguments (not used)
     * @throws Exception if any HTTP request fails
     */
    public static void main(String[] args) throws Exception 
    {
        getExample();
        postExample();
        putExample();
        deleteExample();
    }
    
    /**
     * Demonstrates a GET request to retrieve a resource.
     * Fetches a single post from the JSONPlaceholder API.
     * 
     * @throws Exception if the request fails or connection issues occur
     */
    public static void getExample() throws Exception 
    {
        // Build a GET request to fetch post with id 1
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts/1"))
                .build();
        
        // Send the request and get the response as a String
        HttpResponse<String> response = httpClient.send(
                request, HttpResponse.BodyHandlers.ofString());
        
        // Print the response code and body
        System.out.println("GET Response Code: " + response.statusCode());
        System.out.println("GET Response Body: " + response.body());
    }
    
    /**
     * Demonstrates a POST request to create a new resource.
     * Sends JSON data to create a new post on the JSONPlaceholder API.
     * 
     * @throws Exception if the request fails or connection issues occur
     */
    public static void postExample() throws Exception 
    {
        // JSON data to send in the request body
        String json = """
            {
                "title": "foo",
                "body": "bar",
                "userId": 1
            }""";
        
        // Build a POST request with JSON body
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts"))
                .header("Content-Type", "application/json")
                .build();
        
        // Send the request and get the response
        HttpResponse<String> response = httpClient.send(
                request, HttpResponse.BodyHandlers.ofString());
        
        System.out.println("\nPOST Response Code: " + response.statusCode());
        System.out.println("POST Response Body: " + response.body());
    }
    
    /**
     * Demonstrates a PUT request to update an existing resource.
     * Updates post with id 1 on the JSONPlaceholder API.
     * 
     * @throws Exception if the request fails or connection issues occur
     */
    public static void putExample() throws Exception 
    {
        // JSON data with updated values
        String json = """
            {
                "id": 1,
                "title": "updated title",
                "body": "updated body",
                "userId": 1
            }""";
        
        // Build a PUT request to update the resource
        HttpRequest request = HttpRequest.newBuilder()
                .PUT(HttpRequest.BodyPublishers.ofString(json))
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts/1"))
                .header("Content-Type", "application/json")
                .build();
        
        // Send the request and get the response
        HttpResponse<String> response = httpClient.send(
                request, HttpResponse.BodyHandlers.ofString());
        
        System.out.println("\nPUT Response Code: " + response.statusCode());
        System.out.println("PUT Response Body: " + response.body());
    }
    
    /**
     * Demonstrates a DELETE request to remove a resource.
     * Deletes post with id 1 from the JSONPlaceholder API.
     * 
     * @throws Exception if the request fails or connection issues occur
     */
    public static void deleteExample() throws Exception 
    {
        // Build a DELETE request
        HttpRequest request = HttpRequest.newBuilder()
                .DELETE()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts/1"))
                .build();
        
        // Send the request and get the response
        HttpResponse<String> response = httpClient.send(
                request, HttpResponse.BodyHandlers.ofString());
        
        System.out.println("\nDELETE Response Code: " + response.statusCode());
        System.out.println("DELETE Response Body: " + response.body());
    }
}