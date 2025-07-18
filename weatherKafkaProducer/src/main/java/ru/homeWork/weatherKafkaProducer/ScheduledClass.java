package ru.homeWork.weatherKafkaProducer;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.homeWork.weatherKafkaProducer.kafka.KafkaProducer;
import ru.homeWork.weatherKafkaProducer.weatherServices.WeatherReportFactory;

import java.util.UUID;

@Service
public class ScheduledClass {

    private final WeatherReportFactory weatherReportFactory;
    private final KafkaProducer kafkaProducer;

    private ObjectMapper mapper;

    public ScheduledClass(WeatherReportFactory weatherReportFactory, KafkaProducer kafkaProducer, ObjectMapper mapper) {
        this.weatherReportFactory = weatherReportFactory;
        this.kafkaProducer = kafkaProducer;
        this.mapper = mapper;
    }

    @Scheduled(fixedRate = 5000L)
    private void generateRandomWeatherAndSendToTopic() {
        try {
            System.out.println(mapper.writeValueAsString(weatherReportFactory.createRandomWeatherReport()));
            kafkaProducer.sendMessage(UUID.randomUUID().toString(), mapper.writeValueAsString(weatherReportFactory.createRandomWeatherReport(7)));
        } catch (JsonProcessingException e) {
            System.out.println(e);
        }
    }
}
