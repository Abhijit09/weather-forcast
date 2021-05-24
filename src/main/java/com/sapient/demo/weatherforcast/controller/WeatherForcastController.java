package com.sapient.demo.weatherforcast.controller;

import com.sapient.demo.weatherforcast.dto.WeatherForecast;
import com.sapient.demo.weatherforcast.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather/forcast")
public class WeatherForcastController extends  BaseController {

    @Autowired
    private WeatherService weatherService;


    @GetMapping("/{cityName}")
    public WeatherForecast getWeatherForecast(@PathVariable String cityName) {

        return this.weatherService.getWeatherForecast(cityName);

    }
}
