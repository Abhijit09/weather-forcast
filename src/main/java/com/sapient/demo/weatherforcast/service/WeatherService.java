package com.sapient.demo.weatherforcast.service;

import com.sapient.demo.weatherforcast.dto.WeatherForecast;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.net.URI;

@Service
public class WeatherService {

	private static final String FORECAST_URL = "https://samples.openweathermap.org/data/2.5/forecast?q={cityName}&appid=d2929e9483efc82c82c32ee7e02d563e";

	private static final Logger logger = LoggerFactory.getLogger(WeatherService.class);

	private RestTemplate restTemplate;

	public WeatherService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	public WeatherForecast getWeatherForecast(String cityName) {
		logger.info("Requesting weather forecast for {}", cityName);
		URI url = new UriTemplate(FORECAST_URL).expand(cityName);

		WeatherForecast weatherForecast = invoke(url, WeatherForecast.class);

		weatherForecast.setName(cityName);

		return weatherForecast;
	}

	private <T> T invoke(URI url, Class<T> responseType) {
		RequestEntity<?> request = RequestEntity.get(url).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<T> exchange = this.restTemplate.exchange(request, responseType);

		return exchange.getBody();
	}

}
