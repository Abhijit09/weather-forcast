package com.sapient.demo.weatherforcast;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherForcastApplicationTests {

    @Test
    public void contextLoads() {

        WeatherForcastApplication app = new WeatherForcastApplication();
        String[] args = new String[] {};
        app.main(args);

    }

}
