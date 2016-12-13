package com.benz.usecase.adapter.web;

import com.benz.usecase.application.UseCaseApplicationService;
import com.benz.usecase.application.UseCaseCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by paulliu on 2016/12/12.
 */
@RestController
@RequestMapping("/usecase")
public class UseCaseController {
    @Autowired
    private UseCaseApplicationService useCaseApplicationService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(UseCaseCommand aCommand) {
        useCaseApplicationService.createUseCase(aCommand);
    }
}
