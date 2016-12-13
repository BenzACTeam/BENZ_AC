package com.benz.user.adapter.web;

import com.benz.user.application.UserCommand;
import com.benz.user.domain.User;
import com.benz.user.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by xinyu.b.zhang on 16/12/6.
 */

//@Controller
//public class TemplateController {

//    @Autowired
//    private UserRepository userRepository;
//
//    @RequestMapping(value = "/test")
//    public String helloHtml(Model model, HttpServletRequest request, Model uiModel){
////        userRepository.save(new User("Test1", 10));
////        userRepository.save(new User("Test2", 20));
////        userRepository.save(new User("Test3", 30));
////        userRepository.save(new User("Test4", 40));
////        userRepository.save(new User("Test5", 50));
//        User user=userRepository.findUser("Test1");
//
//        UserCommand loginForm=new UserCommand(user.getName(),user.getAge().toString());
//        model.addAttribute("loginForm",loginForm);
//        return "hello";
//    }
//}
