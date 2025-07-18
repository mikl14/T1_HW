package ru.homeWork.weatherKafkaConsumer.weather;

public enum WeatherType {
    SUNNY("Солнечно"),
    RAIN("Дождливо"),
    STORM("Шторм"),
    THUNDER("Гроза");

    private final String rusName;

    WeatherType(String rusName) {
        this.rusName = rusName;
    }

    public String getRusName() {
        return rusName;
    }
}
