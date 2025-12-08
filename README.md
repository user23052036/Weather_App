<h1>🌦️ Weather_App</h1>

<p>
  <b>Weather_App</b> is a modern Java desktop application that delivers real-time weather information for any city worldwide. With a clean and intuitive GUI, users can easily search for a city and instantly view its current weather, including temperature, humidity, wind speed, and weather conditions-all powered by live data from a public weather API.
</p>

## 🖼 Screenshot
![Weather App UI](assets/screenshot.png)


<h2>🚀 Features</h2>
<ul>
  <li>Instant weather search by city name</li>
  <li>Displays temperature, humidity, and wind speed</li>
  <li>Shows weather conditions with descriptive text and icons (clear, cloudy, rain, snow)</li>
  <li>Real-time data retrieval from a trusted weather API</li>
  <li>Elegant and responsive Java Swing-based GUI</li>
  <li>Clickable search button with custom icon</li>
  <li>Automatic weather icon updates based on conditions</li>
</ul>

<h2>🛠️ Technical Overview</h2>
<ul>
  <li>
    <b>Frontend:</b> Built entirely with <b>Java Swing</b>, providing a robust, platform-independent graphical interface. The GUI features custom icons, styled text, and intuitive layout for a seamless user experience.
  </li>
  <li>
    <b>Backend:</b> Powered by two main Java packages:
    <ul>
      <li>
        <b>java.net.http</b>: Handles all HTTP requests and responses, enabling the app to fetch up-to-date weather data from the API efficiently and reliably.
      </li>
      <li>
        <b>org.json</b>: Parses and processes JSON responses from the API, extracting relevant weather details for display in the GUI.
      </li>
    </ul>
  </li>
</ul>

<h2>📁 Project Structure</h2>
<ul>
  <li>
    <b>AppLauncher.java</b>
    <ul>
      <li><i>Purpose:</i> Entry point of the application. Ensures the GUI is launched safely on the Event Dispatch Thread for thread-safe Swing operations.</li>
      <li>
        <b>main(String[] args):</b> Uses <code>SwingUtilities.invokeLater</code> to create and display the <b>weatherGUI</b> window.
      </li>
    </ul>
  </li>
  <li>
    <b>weatherGUI.java</b>
    <ul>
      <li><i>Purpose:</i> Implements the main graphical user interface and handles all user interactions.</li>
      <li>
        <b>weatherGUI():</b> Constructor that sets up the window, initializes components, and arranges them with absolute positioning.
      </li>
      <li>
        <b>addComponents():</b> Adds and configures all GUI elements-search bar, button, weather icon, temperature, description, humidity, and windspeed labels.
      </li>
      <li>
        <b>actionPerformed(ActionEvent e):</b> Handles the search button click: fetches weather data for the entered city, updates all display fields and icons accordingly.
      </li>
      <li>
        <b>LoadImage(String path):</b> Utility to load image assets (icons) from file paths, used for weather condition icons, search button, humidity, and windspeed images.
      </li>
    </ul>
  </li>
  <li>
    <b>WeatherAPI.java</b>
    <ul>
      <li><i>Purpose:</i> Handles all backend operations: fetching weather data from the API, parsing JSON, and mapping weather codes to descriptive categories.</li>
      <li>
        <b>WeatherData(String location):</b> Sends an HTTP request to the weather API for the specified city, parses the JSON response, and updates static fields for temperature, wind speed, humidity, and weather description.
      </li>
      <li>
        <b>WeatherCondition(int weatherCode):</b> Maps the weather code from the API to one of four categories: clear, cloudy, rain, or snow, using predefined sets of codes.
      </li>
      <li>
        <b>Static Fields:</b> <code>temperature</code>, <code>wind_speed</code>, <code>humidity</code>, and <code>weather_descriptions</code> are updated after each API call for use in the GUI.
      </li>
      <li>
        <b>API Integration:</b> Uses <code>java.net.http.HttpClient</code> for HTTP requests and <code>org.json</code> for JSON parsing.
      </li>
    </ul>
  </li>
  <li>
    <b>assets/</b>
    <ul>
      <li>Contains PNG image resources for weather icons (e.g., clear, cloudy, rain, snow), search button, humidity, and windspeed.</li>
    </ul>
  </li>
</ul>

<h2>🔮 Future Enhancements</h2>
<p>
  Future releases will introduce a more advanced frontend using <b>JavaFX</b> for richer interactivity, animations, and enhanced visual appeal. Planned improvements include animated weather icons, theme customization, and extended forecast support.
</p>

<h2>📦 How to Use</h2>
<ol>
  <li>Clone or download this repository.</li>
  <li>Ensure you have Java 11 or later installed.</li>
  <li>Build the project using your preferred IDE or <code>javac</code>.</li>
  <li>Run <b>AppLauncher.java</b> to start the application.</li>
  <li>Enter a city name in the search bar and click the search icon to view the latest weather.</li>
</ol>

<h2>⚙️ Requirements</h2>
<ul>
  <li>Java 11 or later</li>
  <li>Internet connection (for live weather data)</li>
</ul>

<h2>🙌 Credits</h2>
<p>
  Developed by <a href="https://github.com/user23052036">user23052036</a><br>
  Weather data powered by <a href="https://weatherstack.com/">WeatherStack</a>
</p>
