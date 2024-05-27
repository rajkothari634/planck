package com.lifegadget.planck.facades;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lifegadget.planck.core.errors.DatabaseException;
import com.lifegadget.planck.database.noSQLModels.LinkActivityLog;
import com.lifegadget.planck.database.sqlModels.Link;
import com.lifegadget.planck.services.LinkActivityLogService;
import com.lifegadget.planck.services.LinkService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LinkFacade {
    @Autowired
    private LinkService linkService;
    @Autowired
    private LinkActivityLogService linkActivityLogService;
    @Autowired
    private ObjectMapper objectMapper;

    public Link createLink(Link link){
        return linkService.createLink(link);
    }
    public Link getLink(String shortCode, HttpServletRequest httpServletRequest){

        try{
//        System.out.print(request.toString());
            Link link = linkService.getLink(shortCode);
            System.out.println("process the link - " + link.getId());
            LinkActivityLog linkActivityLog = new LinkActivityLog();
            linkActivityLog.setLinkId(link.getId());
            linkActivityLog.setCountry("India");
            linkActivityLog.setRequestData(objectMapper.readTree(httpServletRequest.getInputStream()));
            System.out.println(httpServletRequest);
            linkActivityLogService.createLinkActivityLog(linkActivityLog);
            return link;
        }catch (Exception e){
            throw new DatabaseException(e.getMessage());
        }
    }

}
