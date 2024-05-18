package com.lifegadget.planck.services;

import com.lifegadget.planck.core.errors.DatabaseException;
import com.lifegadget.planck.core.errors.ValidationException;
import com.lifegadget.planck.database.sqlModels.User;
import com.lifegadget.planck.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long userId){
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()) {
            throw new ValidationException("No user present with id - " + userId);
        }
        return userOptional.get();
    }
    public User createUser(User user){
        try{
            return userRepository.save(user);
        }catch (Exception e){
            throw new DatabaseException("error in creating user. Data provided - "+ user.toString() + " error - " + e.getMessage());
        }
    }
}
