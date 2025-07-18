package ru.homeWork.weatherKafkaConsumer.weather;

import java.util.Date;

public class WeatherReport {
    private WeatherType weatherType;
    private Integer temperature;
    private String location;
    private Date date;

    public WeatherReport() {
    }

    public WeatherReport(WeatherType weatherType, Integer temperature, String location, Date date) {
        this.weatherType = weatherType;
        this.temperature = temperature;
        this.location = location;
        this.date = date;
    }

    public WeatherType getWeatherType() {
        return weatherType;
    }

    public void setWeatherType(WeatherType weatherType) {
        this.weatherType = weatherType;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
