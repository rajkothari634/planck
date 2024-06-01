package com.lifegadget.planck.facades;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lifegadget.planck.core.errors.DatabaseException;
import com.lifegadget.planck.core.lib.Helper;
import com.lifegadget.planck.database.noSQLModels.LinkActivityLog;
import com.lifegadget.planck.database.sqlModels.Link;
import com.lifegadget.planck.services.KafkaProducerService;
import com.lifegadget.planck.services.LinkActivityLogService;
import com.lifegadget.planck.services.LinkService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.util.HashMap;

@Component
public class LinkFacade {
    @Autowired
    private LinkService linkService;
    @Autowired
    private LinkActivityLogService linkActivityLogService;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private Helper helper;
    @Autowired
    private KafkaProducerService kafkaProducerService;

    public Link createLink(Link link){
        return linkService.createLink(link);
    }
    public Link getLink(String shortCode, HttpServletRequest httpServletRequest){
        try{
            Link link = linkService.getLink(shortCode);
            System.out.println("process the link - " + link.getId());
            HashMap<String, Object> requestData = helper.getObjectOfHttpServletRequest(httpServletRequest);
            ObjectMapper objectMapper = new ObjectMapper();
            HashMap<String, String> kafkaMessage = new HashMap<>();
            kafkaMessage.put("requestData", objectMapper.writeValueAsString(requestData) );
            kafkaMessage.put("linkId", link.getId().toString());
            kafkaMessage.put("ipAddress", helper.getClientIp(httpServletRequest));
            kafkaProducerService.sendMessage("link_activity_logs", link.getId().toString(), objectMapper.writeValueAsString(kafkaMessage));
            return link;
        }catch (Exception e){
            throw new DatabaseException(e.getMessage());
        }
    }

}
