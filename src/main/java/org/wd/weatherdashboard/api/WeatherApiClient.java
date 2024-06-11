package org.wd.weatherdashboard.api;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class WeatherApiClient {
    private final String apiKey;
    private final OkHttpClient client;

    public WeatherApiClient(String apiKey) {
        this.apiKey = apiKey;
        this.client = new OkHttpClient();
    }

    public String getCurrentWeather(String city) throws IOException {
        HttpUrl url = HttpUrl.parse("https://api.openweathermap.org/data/2.5/weather")
                .newBuilder()
                .addQueryParameter("q", city)
                .addQueryParameter("appid", apiKey)
                .addQueryParameter("units", "metric")
                .build();

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            return response.body().string();
        }
    }

    public String getWeatherForecast(String city) throws IOException {
        HttpUrl url = HttpUrl.parse("https://api.openweathermap.org/data/2.5/forecast")
                .newBuilder()
                .addQueryParameter("q", city)
                .addQueryParameter("appid", apiKey)
                .addQueryParameter("units", "metric")
                .build();

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            return response.body().string();
        }
    }
}
