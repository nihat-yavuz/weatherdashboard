# Weather Dashboard

The Weather Dashboard is a simple Java application that fetches and displays current weather information for a specified city using the OpenWeatherMap API. It features a graphical user interface (GUI) built with JavaFX, and allows users to input their OpenWeather API key directly through the UI.

## Features

- Input your OpenWeather API key directly in the UI
- Search for current weather conditions by city name
- Display current temperature, weather description, and city name
- User-friendly interface built with JavaFX

## Requirements

- Java 17 or higher
- Maven
- OpenWeatherMap API key

## Installation

1. **Clone the repository:**

   ```sh
   git clone https://github.com/nihat-yavuz/weatherdashboard.git
   cd weatherdashboard
   ```

2. **Build the project:**

   ```sh
   mvn clean install
   ```

3. **Run the application:**

   ```sh
   mvn javafx:run
   ```

## Usage

1. Open the application.
2. Enter your OpenWeather API key in the designated field.
3. Enter the name of the city you want to search for in the text field.
4. Click the "Get Weather" button.
5. The current weather information will be displayed in the text area.

## Project Structure

```
weatherdashboard/
├── pom.xml
├── README.md
└── src/
    └── main/
        └── java/
            └── org/
                └── wd/
                    ├── Main.java
                    ├── api/
                    │   ├── WeatherApiClient.java
                    │   └── WeatherResponseParser.java
                    └── ui/
                        └── WeatherDashboardApp.java
```

- `Main.java`: The main entry point of the application.
- `WeatherApiClient.java`: Handles HTTP requests to the OpenWeatherMap API.
- `WeatherResponseParser.java`: Parses JSON responses from the OpenWeatherMap API.
- `WeatherDashboardApp.java`: The main JavaFX application class.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contributing

Contributions are welcome! Please open an issue or submit a pull request for any improvements or new features.

## Acknowledgements

- OpenWeatherMap for providing the weather data API.
- JavaFX for the graphical user interface framework.
