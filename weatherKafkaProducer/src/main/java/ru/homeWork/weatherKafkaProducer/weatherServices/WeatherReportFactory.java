package ru.homeWork.weatherKafkaProducer.weatherServices;


import org.springframework.stereotype.Service;
import ru.homeWork.weatherKafkaProducer.config.AppProperties;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class WeatherReportFactory {

    private final AppProperties appProperties;
    public static final Random random = new Random();

    public WeatherReportFactory(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    public WeatherReport createRandomWeatherReport() {
        List<String> locations = appProperties.getCities();
        WeatherType[] values = WeatherType.values();
        int index = random.nextInt(locations.size());
        return new WeatherReport(values[random.nextInt(values.length)],
                random.nextInt(40) - 10,
                locations.get(index),
                randomDateWithinLastYear());
    }

    public List<WeatherReport> createRandomWeatherReport(int count) {
        List<WeatherReport> weatherReportList = new ArrayList<>();

        while (count > 0) {
            weatherReportList.add(createRandomWeatherReport());
            count--;
        }
        return weatherReportList;
    }

    private static Date randomDateWithinLastYear() {
        long now = System.currentTimeMillis();
        long yearAgo = now - 365L * 24 * 60 * 60 * 1000;
        long randomTime = ThreadLocalRandom.current().nextLong(yearAgo, now);
        return new Date(randomTime);
    }
}
