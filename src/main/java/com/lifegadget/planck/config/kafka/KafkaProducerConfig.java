package com.lifegadget.planck.config.kafka;

import com.lifegadget.planck.core.errors.DependencyException;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class KafkaProducerConfig {
    private Properties props;
    private KafkaProducer kafkaProducer;
    @Value("${kafka.bootstrap.servers}")
    private String bootstrapServers;
    @Value("${kafka.username}")
    private String username;
    @Value("${kafka.password}")
    private String password;

    @PostConstruct
    public void initializeKafkaProducer(){
        this.props = new Properties();
        props.put("bootstrap.servers", bootstrapServers);
        props.put("sasl.mechanism", "SCRAM-SHA-256");
        props.put("security.protocol", "SASL_SSL");
        props.put("sasl.jaas.config", "org.apache.kafka.common.security.scram.ScramLoginModule required username=\"" + username + "\" password=\"" + password + "\";");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        kafkaProducer = new KafkaProducer<>(this.props);
    }

    public void sendMessage(String topic, String key, String message){
        try{
            ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topic, key, message);
            this.kafkaProducer.send(producerRecord);
        }catch(Exception e){
            throw new DependencyException("Kafka failed to send message");
        }
    }

    @PreDestroy
    public void closeProducer(){

        System.out.println("pre destroy bean");
        this.kafkaProducer.close();
    }
}
