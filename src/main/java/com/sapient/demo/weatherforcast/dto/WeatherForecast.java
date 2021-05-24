package com.sapient.demo.weatherforcast.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WeatherForecast implements Serializable {

	private String cityName;

	private List<WeatherEntry> forcastDetails = new ArrayList<>();

	public String getName() {
		return this.cityName;
	}

	public void setName(String name) {
		this.cityName = name;
	}

	@JsonProperty("forcastDetails")
	public List<WeatherEntry> getEntries() {
		return this.forcastDetails;
	}

	@JsonSetter("list")
	public void setEntries(List<WeatherEntry> entries) {
		this.forcastDetails = entries;
	}

	@JsonProperty("city")
	public void setCity(Map<String, Object> city) {
		setName(city.get("name").toString());
	}

}
