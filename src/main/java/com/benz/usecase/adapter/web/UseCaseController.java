package com.benz.usecase.adapter.web;

import com.benz.usecase.application.UseCaseApplicationService;
import com.benz.usecase.application.UseCaseCreateCommand;
import com.benz.usecase.application.UseCaseUpdateCommand;
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
    public void create(UseCaseCreateCommand aCommand) {
        useCaseApplicationService.createUseCase(aCommand);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void update(UseCaseUpdateCommand aCommand) {
        useCaseApplicationService.updateUseCase(aCommand);
    }
}
