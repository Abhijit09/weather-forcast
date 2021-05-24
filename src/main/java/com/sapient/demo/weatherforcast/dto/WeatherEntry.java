package com.sapient.demo.weatherforcast.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.Instant;
import java.util.List;
import java.util.Map;

public class WeatherEntry implements Serializable {

	private static final  double KELVIN_TO_CELSIUS_CONVERSION_CONSTANT = 273.15;

	private String timestamp;

	private double minTemperature;

	private double maxTemperature;

	private double cloudiness;

	private String specialInstruction = "";

	DecimalFormat df = new DecimalFormat("#.##");

	@JsonProperty("timestamp")
	public String getTimestamp() {
		return this.timestamp;
	}

	@JsonSetter("dt")
	public void setTimestamp(long unixTime) {
		this.timestamp = Instant.ofEpochMilli(unixTime * 1000).toString();
	}

	public double getMinTemperature() {
		return minTemperature;
	}

	public void setMinTemperature(double minTemperature) {
		this.minTemperature = minTemperature;
	}

	public double getMaxTemperature() {
		return maxTemperature;
	}

	public void setMaxTemperature(double maxTemperature) {
		this.maxTemperature = maxTemperature;
	}

	public double getCloudiness() {
		return cloudiness;
	}

	public void setCloudiness(double cloudiness) {
		this.cloudiness = cloudiness;
	}

	public String getSpecialInstruction() {
		return specialInstruction;
	}

	public void setSpecialInstruction(String specialInstruction) {
		this.specialInstruction = this.specialInstruction.concat(" ").concat(specialInstruction);
	}

	@JsonProperty("main")
	public void setMain(Map<String, Object> main) {

		setMinTemperature(Double.parseDouble(df.format(Double.parseDouble(main.get("temp_min").toString())-KELVIN_TO_CELSIUS_CONVERSION_CONSTANT)));
		setMaxTemperature(Double.parseDouble(df.format(Double.parseDouble(main.get("temp_max").toString())-KELVIN_TO_CELSIUS_CONVERSION_CONSTANT)));
		if (this.getMaxTemperature() > 40 ) {
			setSpecialInstruction("Use Sunscreen Lotion");
		}

	}

	@JsonProperty("clouds")
	public void setClouds(Map<String, Object> clouds) {
		setCloudiness(Double.parseDouble(clouds.get("all").toString()));
		if (this.getCloudiness() > 0 ) {
			setSpecialInstruction("Carry Umbrella");
		}
	}

	@JsonProperty("weather")
	public void setWeather(List<Map<String, Object>> weatherEntries) {
		Map<String, Object> weather = weatherEntries.get(0);
	}

}
