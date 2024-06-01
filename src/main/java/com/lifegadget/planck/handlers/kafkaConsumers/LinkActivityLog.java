package com.lifegadget.planck.handlers.kafkaConsumers;


import com.lifegadget.planck.facades.LinkActivityLogFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class LinkActivityLog {
    @Autowired
    private LinkActivityLogFacade linkActivityLogFacade;

    @KafkaListener(topics = "link_activity_logs", groupId = "link_activity")
    public void linkActivityListner(String message) {
        try{
            linkActivityLogFacade.createLinkActivityLogFromKafkaMessage(message);
        }catch (Exception e){
            throw new InternalError(e.getMessage());
        }
    }
}
