import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/**
 * Demonstrates how to make HTTP API calls to fetch weather data.
 * This class shows the basics of using Java's HttpClient to make GET requests
 * to the WeatherStack API and retrieve JSON responses.
 * 
 * Purpose: Educational example for beginners learning API integration.
 * Expected Output: Weather data in JSON format for the requested city.
 */
class API
{
    
    private static final String API_key = "e01eaa6b5b05805bea9572f6e4e70208";
    //private static final HttpClient client = HttpClient.newHttpClient(); set with default settings
    private static final HttpClient client = HttpClient.newBuilder()
                                            .version(HttpClient.Version.HTTP_2)
                                            .connectTimeout(Duration.ofSeconds(10))
                                            .build();    
    
    /**
     * Fetches current weather data for a specified city from the WeatherStack API.
     * 
     * @param city the name of the city to get weather data for (e.g., "Kolkata", "London")
     * @return JSON string containing weather information, or null if an error occurs
     */
    public static String getWeatherData(String city) 
    {
        // Construct the API URL with the city parameter and API key
        String url = "http://api.weatherstack.com/current?access_key="+API_key+
                     "&query="+city+
                     "&units=m"; // optional parameters
        
        // Build the HTTP GET request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        
        try 
        {
            // Send the request and receive response as a String
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            // You can add more error handling here based on response.statusCode()
            return response.body();
        } catch (Exception e) {
            // Print error details if the request fails
            e.printStackTrace();
            return null;
        }
    }
}

/**
 * Main demo class that tests the API functionality.
 * This class demonstrates how to use the API class to fetch and display weather data.
 * 
 * Expected Output: Prints JSON weather data for Kolkata to the console.
 */
public class Demo_API
{
    /**
     * Main method that executes the weather API demo.
     * Fetches weather data for Kolkata and prints it to the console.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) 
    {
        // Fetch weather data for Kolkata
        String weather_Data = API.getWeatherData("Kolkata");
        
        // Print the JSON response to console
        System.out.println(weather_Data);
    }
}