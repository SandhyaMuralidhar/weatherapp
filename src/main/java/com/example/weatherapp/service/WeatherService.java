package com.example.weatherapp.service;

import com.example.weatherapp.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Value("${openweathermap.api.key}")
    private String apiKey;

    @Value("${openweathermap.api.url}")
    private String apiUrl;

    public WeatherResponse getWeather(String city) {
        String url = apiUrl + "?q=" + city + "&appid=" + apiKey;
        System.out.println(url);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, WeatherResponse.class);
    }
}