package com.benz.user.adapter.web;

import com.benz.user.application.UserApplicationService;
import com.benz.user.application.UserCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by xinyu.b.zhang on 16/12/7.
 */
//@RestController
//public class HelloController {
//
//    @Autowired
//    protected UserApplicationService userApplicationService;
//
//    @RequestMapping("/")
//    public UserCommand login() {
//        UserCommand userCommand=new UserCommand("admin","password");
//        userCommand=userApplicationService.createUser(userCommand);
//        return userCommand;
//    }
//}
