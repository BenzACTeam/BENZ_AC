package com.benz.usecase.adapter.web;

import com.benz.usecase.application.UseCaseApplicationService;
import com.benz.usecase.application.UseCaseCreateCommand;
import com.benz.usecase.application.UseCaseUpdateCommand;
import com.benz.usecase.domain.UseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void update(UseCaseUpdateCommand aCommand) {
        useCaseApplicationService.updateUseCase(aCommand);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(String id){
        useCaseApplicationService.deleteUseCase(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<UseCase> findAll(Integer pageNo, Integer pageSize){
        return  useCaseApplicationService.findAll(pageNo, pageSize);
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public UseCase findOne(String id){
        return useCaseApplicationService.findOne(id);
    }
}
