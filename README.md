# spring-with-kafka-poc
This project contains the very basic configurations to start working
with kafka and spring framework

## Kafka and Zookeeper Servers config
This is the most complex part of this POC ever.
There are a bunch of ways to config those servers and 
could not work properly the way this project was configured.
<br><br>
With that been said I also provided a docker-compose to boostrap a working kafka and Zookeeper:
```
---
version: '3'
services:
  zookeeper:
    image: confluentinc/cp-zookeeper:7.0.1
    container_name: zookeeper
    environment:
      ZOOKEEPER_CLIENT_PORT: 2181
      ZOOKEEPER_TICK_TIME: 2000

  broker:
    image: confluentinc/cp-kafka:7.0.1
    container_name: broker
    ports:
    # To learn about configuring Kafka for access across networks see
    # https://www.confluent.io/blog/kafka-client-cannot-connect-to-broker-on-aws-on-docker-etc/
      - "9092:9092"
    depends_on:
      - zookeeper
    environment:
      KAFKA_BROKER_ID: 1
      KAFKA_ZOOKEEPER_CONNECT: 'zookeeper:2181'
      KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: PLAINTEXT:PLAINTEXT,PLAINTEXT_INTERNAL:PLAINTEXT
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://localhost:9092,PLAINTEXT_INTERNAL://broker:29092
      KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR: 1
      KAFKA_TRANSACTION_STATE_LOG_MIN_ISR: 1
      KAFKA_TRANSACTION_STATE_LOG_REPLICATION_FACTOR: 1
```
[reference for this docker-compose](https://developer.confluent.io/quickstart/kafka-docker/)

## CURL to send messages to topics
```
curl --location --request POST 'http://localhost:8080/kafka-poc/api/send-message/first-topic?message=this is a simple message to first topic'

curl --location --request POST 'http://localhost:8080/kafka-poc/api/send-message/second-topic?message=this is a simple message to second topic'
```