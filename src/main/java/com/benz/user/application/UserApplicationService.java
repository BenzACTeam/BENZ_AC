package com.benz.user.application;

import com.benz.user.domain.User;
//import com.benz.user.domain.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Created by paulliu on 2016/12/7.
 */
//@Service
//public class UserApplicationService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    public UserCommand createUser(UserCommand userCommand) {
//        //userRepository.save(new User("Test5", 50));
//        User user=userRepository.findUser("Test1");
//        userCommand.setName(user.getName());
//        userCommand.setPassword(user.getAge().toString());
//
//        return userCommand;
//    }
//}
