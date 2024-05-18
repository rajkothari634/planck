package com.lifegadget.planck.controllers;

import com.lifegadget.planck.database.sqlModels.Link;
import com.lifegadget.planck.database.sqlModels.User;
import com.lifegadget.planck.services.LinkService;
import com.lifegadget.planck.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class LinkController {

    @Autowired
    private LinkService linkService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @GetMapping("/link")
    public Link createLink(@RequestParam Long link){
        System.out.println(link);
        return linkService.createLink(link);
    }
}
