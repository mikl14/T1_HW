package ru.homeWork.weatherKafkaConsumer.kafka;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.homeWork.weatherKafkaConsumer.weather.WeatherReport;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class KafkaConsumer {

    private final ObjectMapper mapper;

    public KafkaConsumer(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @KafkaListener(topics = "weather",groupId = "weather_consumer")
    public void listen(ConsumerRecord<String, String> message) {

        try {
            List<WeatherReport> weatherReport = mapper.readValue(message.value(), new TypeReference<List<WeatherReport>>() {
            });

            Map<String, Double> avgTempByCity = weatherReport.stream()
                    .collect(Collectors.groupingBy(
                            WeatherReport::getLocation,
                            Collectors.averagingInt(WeatherReport::getTemperature)
                    ));

            System.out.println(avgTempByCity.toString());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
