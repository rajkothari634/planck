package com.lifegadget.planck.facades;

import com.lifegadget.planck.core.errors.DatabaseException;
import com.lifegadget.planck.database.sqlModels.User;
import com.lifegadget.planck.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class UserFacade {

    @Autowired
    private UserService userService;

    public User createUser(User user){
        try{
            return userService.createUser(user);
        }catch (Exception e){
            throw new DatabaseException("error in creating user. Data provided - "+ user.toString() + " error - " + e.getMessage());
        }
    }
    public User getUserById(Long userId){
        try{
            return userService.getUserById(userId);
        }catch (Exception e){
            throw new DatabaseException("error in fetching user. Data provided - "+ userId+ " error - " + e.getMessage());
        }
    }
}
