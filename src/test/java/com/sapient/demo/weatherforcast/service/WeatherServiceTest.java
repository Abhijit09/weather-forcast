package com.sapient.demo.weatherforcast.service;

import com.sapient.demo.weatherforcast.dto.WeatherForecast;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherServiceTest {

    @Autowired
    private WeatherService weatherService;


    @Test
    public void getWeatherForecast() {

        WeatherForecast weatherForecast = new WeatherForecast();

        weatherForecast = this.weatherService.getWeatherForecast("Pune");

        Assert.notNull(weatherForecast);
    }
}