package com.lifegadget.planck.services;

import com.lifegadget.planck.config.kafka.KafkaProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    @Autowired
    private KafkaProducerConfig kafkaProducerConfig;

    public void sendMessage(String topic, String key, String message){
        System.out.println("send message for  link - " + key);

        kafkaProducerConfig.sendMessage(topic, key, message);
    }

}
