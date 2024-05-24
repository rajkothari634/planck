package com.lifegadget.planck.facades;

import com.lifegadget.planck.database.sqlModels.Link;
import com.lifegadget.planck.services.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LinkFacade {
    @Autowired
    private LinkService linkService;
    public Link createLink(Link link){
        return linkService.createLink(link);
    }
    public Link getLink(String shortCode){
        Link link = linkService.getLink(shortCode);
        System.out.println("process the link - " + link.getId());
        return link;
    }

}
