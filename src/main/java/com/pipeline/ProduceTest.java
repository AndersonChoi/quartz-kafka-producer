package com.pipeline;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class ProduceTest {
    private static ProduceTest instance = new ProduceTest();
    private static KafkaProducer<String, String> producer;

    private ProduceTest() {

        System.out.println("call EagerInitialization constructor.");

        String TOPIC_NAME = "test";
        String BOOTSTRAP_SERVERS = "localhost:9092";


        Properties configs = new Properties();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        producer = new KafkaProducer<>(configs);

    }

    public static ProduceTest getInstance() {
        return instance;
    }

    public void send(String value) {
        ProducerRecord<String, String> record = new ProducerRecord<>("test", value);
        producer.send(record);
    }
}