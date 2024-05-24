package com.lifegadget.planck.controllers;

import com.lifegadget.planck.database.sqlModels.Link;
import com.lifegadget.planck.database.sqlModels.User;
import com.lifegadget.planck.dto.LinkDTO;
import com.lifegadget.planck.facades.LinkFacade;
import com.lifegadget.planck.services.LinkService;
import com.lifegadget.planck.services.UserService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class LinkController {

    @Autowired
    private LinkFacade linkFacade;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/link")
    public Link createLink(@RequestBody Link link){
        System.out.println(link);
        return linkFacade.createLink(link);
    }
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/{shortCode}")
    public Link getLink(@PathVariable String shortCode){
        System.out.println("shortCode - " + shortCode);
       return linkFacade.getLink(shortCode);
    }
}
