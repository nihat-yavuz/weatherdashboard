package org.wd.weatherdashboard.api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class WeatherResponseParser {

    public static String parseCurrentWeather(String jsonResponse) {
        JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
        JsonObject main = jsonObject.getAsJsonObject("main");
        JsonObject weather = jsonObject.getAsJsonArray("weather").get(0).getAsJsonObject();

        String temperature = main.get("temp").getAsString();
        String weatherDescription = weather.get("description").getAsString();
        String cityName = jsonObject.get("name").getAsString();

        return String.format("City: %s, Temperature: %s°C, Weather: %s", cityName, temperature, weatherDescription);
    }

    public static String parseWeatherForecast(String jsonResponse) {
        JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
        // Parsing logic for forecast can be added here

        return "Forecast data parsing not implemented yet";
    }
}
