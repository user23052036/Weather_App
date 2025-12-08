import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;  //package org.json

public class weatherAPI 
{
    static int temperature,wind_speed,humidity;
    static String weather_descriptions="";

    private static final String APIkey = "e01eaa6b5b05805bea9572f6e4e70208";

    // see the documentation of the specific codes in the study repo(weather_codes.txt)
    private static final Set<Integer> CLEAR_CODES = Set.of(113);
    private static final Set<Integer> CLOUDY_CODES = Set.of
    (
        116, 119, 122, 143, 248, 350
    );
    private static final Set<Integer> RAIN_CODES = Set.of
    (
        176, 200, 263, 266, 281, 284, 293, 296,
        299, 302, 305, 308, 353, 356, 359, 377,
        386, 389
    );
    private static final Set<Integer> SNOW_CODES = Set.of
    (
        179, 182, 185, 227, 230, 260, 311, 314,
        317, 320, 323, 326, 329, 332, 335, 338,
        362, 365, 368, 371, 374, 392, 395
    );

    private static final HttpClient client = HttpClient.newBuilder()
                                             .version(HttpClient.Version.HTTP_2)
                                             .connectTimeout(Duration.ofSeconds(10))
                                             .followRedirects(HttpClient.Redirect.NORMAL)
                                             .build();
                                             


    //utility method to fetch weather data
    public static int WeatherData(String location)
    {
        String url = "http://api.weatherstack.com/current?access_key="+APIkey+
                     "&query="+location+
                     "&units=m"; // optional parameters

        HttpRequest request = HttpRequest.newBuilder()
                              .uri(URI.create(url))
                              .GET()
                              .build();

        try
        {
            HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
            
            if(response.statusCode() == 200)  // OK(success)
            {
                JSONObject json = new JSONObject(response.body());
                JSONObject object = json.getJSONObject("current");
                JSONArray array = object.getJSONArray("weather_descriptions");

                for(int i=0; i<array.length(); i++)
                    weather_descriptions += (array.getString(i)+" ");

                temperature = object.getInt("temperature");
                wind_speed = object.getInt("wind_speed");
                humidity = object.getInt("humidity");

                return object.getInt("weather_code");           // directly we will return the json object
            }
            else System.out.println("Error: received status code :"+response.statusCode());

        } catch(Exception e){
            e.printStackTrace();
        }
        return -1;
    }

    public static String WeatherCondition(int weatherCode)
    {
        if(weatherCode==-1) return "error";

        if(CLEAR_CODES.contains(weatherCode)) return "clear";
        else if(CLOUDY_CODES.contains(weatherCode)) return "cloudy";
        else if(RAIN_CODES.contains(weatherCode)) return "rain";
        else if(SNOW_CODES.contains(weatherCode)) return "snow";
        return "cloudy"; // default/fallback
    }
}