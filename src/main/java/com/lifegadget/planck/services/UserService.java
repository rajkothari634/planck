package com.lifegadget.planck.services;

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

    private User getUserById(Long userId){
        Optional<User> userOptional = userRepository.findById(userId);
        if(!userOptional.isPresent()){
            throw new ValidationException("No user present with id - " + userId);
        }
        return userOptional.get();
    }
}
