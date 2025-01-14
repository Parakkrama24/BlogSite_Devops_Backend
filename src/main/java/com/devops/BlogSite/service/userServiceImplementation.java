package com.devops.BlogSite.service;

import com.devops.BlogSite.model.user;
import com.devops.BlogSite.repository.userRepository;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.stereotype.Service;

@Service
public class userServiceImplementation implements  userService{

    private userRepository UserRepository;

    @Override
    public user findUserByEmail(String userName) throws Exception {

      user User= UserRepository.findUserByEmail(userName);
        if(User!=null){
            return User;
        }
        throw new Exception("User doesn't exist");
    }
}
