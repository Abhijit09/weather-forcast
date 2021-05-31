package com.sapient.demo.weatherforcast.controller;

import com.sapient.demo.weatherforcast.dto.WeatherEntry;
import com.sapient.demo.weatherforcast.dto.WeatherForecast;
import com.sapient.demo.weatherforcast.service.WeatherService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(value = WeatherForcastController.class)
public class WeatherForcastControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WeatherService weatherService;

    @Test
    public void getWeatherForecast_Success() throws Exception {

        WeatherForecast weatherForecast = new WeatherForecast();

        WeatherEntry weatherEntry = new WeatherEntry();

        weatherEntry.setMinTemperature(12.8);
        weatherEntry.setMaxTemperature(8.8);
        weatherEntry.setCloudiness(0);
        weatherEntry.setTimestamp(1487246400);
        weatherEntry.setSpecialInstruction("");

        List<WeatherEntry> weatherEntryList = new ArrayList<>();
        weatherEntryList.add(weatherEntry);

        weatherForecast.setEntries(weatherEntryList);
        weatherForecast.setName("Pune");

        Mockito.when(weatherService.getWeatherForecast(Mockito.anyString())).thenReturn(weatherForecast);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/api/weather/forcast/Pune").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String content = result.getResponse().getContentAsString();

        System.out.println(content);

        Assert.assertTrue(content.contains("12.8"));


    }
}