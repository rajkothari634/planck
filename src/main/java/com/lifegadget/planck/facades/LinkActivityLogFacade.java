package com.lifegadget.planck.facades;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lifegadget.planck.core.lib.Helper;
import com.lifegadget.planck.services.LinkActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class LinkActivityLogFacade {
    @Autowired
    private LinkActivityLogService linkActivityLogService;

    @Autowired
    private Helper helper;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public void createLinkActivityLogFromKafkaMessage(String message){
        try{
            HashMap<String, String> deserializedMap = objectMapper.readValue(message, HashMap.class);
            com.lifegadget.planck.database.noSQLModels.LinkActivityLog linkActivityLog = new com.lifegadget.planck.database.noSQLModels.LinkActivityLog();
            linkActivityLog.setRequestData(objectMapper.readValue(deserializedMap.get("requestData"), HashMap.class));
            linkActivityLog.setLinkId(Long.parseLong(deserializedMap.get("linkId")));
            linkActivityLog.setIpAddress(deserializedMap.get("ipAddress"));
            linkActivityLogService.createLinkActivityLog(linkActivityLog);
        }catch(Exception e){
            throw new InternalError(e.getMessage());
        }
    }
}
