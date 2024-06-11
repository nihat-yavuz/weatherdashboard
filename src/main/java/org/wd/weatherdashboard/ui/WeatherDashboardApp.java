package org.wd.weatherdashboard.ui;


import org.wd.weatherdashboard.api.WeatherApiClient;
import org.wd.weatherdashboard.api.WeatherResponseParser;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WeatherDashboardApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Weather Dashboard");

        Label cityLabel = new Label("Enter city:");
        TextField cityTextField = new TextField();
        Button getWeatherButton = new Button("Get Weather");
        TextArea weatherInfoTextArea = new TextArea();
        weatherInfoTextArea.setEditable(false);

        getWeatherButton.setOnAction(e -> {
            String city = cityTextField.getText();
            weatherInfoTextArea.setText("Fetching weather for " + city + "...");

            // Fetch and display weather information
            new Thread(() -> {
                try {
                    String apiKey = "39f41738c394b81d756130148706c2c8"; // Replace with your actual API key
                    WeatherApiClient weatherApiClient = new WeatherApiClient(apiKey);
                    String currentWeatherResponse = weatherApiClient.getCurrentWeather(city);
                    String parsedCurrentWeather = WeatherResponseParser.parseCurrentWeather(currentWeatherResponse);

                    // Update UI on JavaFX Application Thread
                    Platform.runLater(() -> weatherInfoTextArea.setText(parsedCurrentWeather));
                } catch (Exception ex) {
                    ex.printStackTrace();
                    Platform.runLater(() -> weatherInfoTextArea.setText("Error fetching weather data."));
                }
            }).start();
        });

        VBox vbox = new VBox(10, cityLabel, cityTextField, getWeatherButton, weatherInfoTextArea);
        Scene scene = new Scene(vbox, 400, 300);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

