package com.lifegadget.planck.controllers;

import com.lifegadget.planck.database.sqlModels.User;
import com.lifegadget.planck.dto.UserDTO;
import com.lifegadget.planck.services.UserService;
import jakarta.validation.Valid;
import org.hibernate.mapping.Selectable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @ResponseStatus(value = HttpStatus.FOUND)
    @GetMapping("/user/{userId}")
    public User getUserById(@Valid @PathVariable Long userId) {
        System.out.println("vdvnj");
        return userService.getUserById(userId);
    }
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/user")
    public User createUser(@Valid @RequestBody User user){
        System.out.println(user);
        return userService.createUser(user);
    }
}
