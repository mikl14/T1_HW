# Домашние задание 1

В этом репозитории находятся два проекта на Java Spring:

- **weatherKafkaProducer** — случайным образом генерирует списки городов с погодой и отправляет их в Kafka-топик.
- **weatherKafkaConsumer** — потребляет сообщения из Kafka, вычисляет среднюю температуру по городам и выводит результат в консоль.

Также в репозитории присутствует **Docker Compose** файл, который позволяет быстро развернуть окружение с этими двумя приложениями, а также с необходимыми сервисами Kafka и ZooKeeper.

## Как использовать

1. Запустите команду 

docker-compose up

чтобы поднять сервисы и приложения.

2. Producer начнёт отправлять данные в топик Kafka.

3. Consumer будет получать данные и выводить среднюю температуру по городам в консоль.

## Технологии

- Java Spring Boot
- Apache Kafka
- Docker, Docker Compose
- ZooKeeper (для Kafka)
