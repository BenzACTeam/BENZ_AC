package com.benz.usecase.adapter.web;

import com.benz.framework.query.PagedList;
import com.benz.usecase.application.UseCaseApplicationService;
import com.benz.usecase.application.UseCaseCreateCommand;
import com.benz.usecase.application.UseCaseUpdateCommand;
import com.benz.usecase.query.UseCaseParameter;
import com.benz.usecase.query.UseCaseMapper;
import com.benz.usecase.query.UseCaseQuery;
import com.benz.usecase.query.UseCaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by paulliu on 2016/12/12.
 */
@RestController
@RequestMapping("/usecase")
public class UseCaseController {
    @Autowired
    private UseCaseApplicationService useCaseApplicationService;
    @Autowired
    private UseCaseMapper useCaseMapper;
    @Autowired
    private UseCaseQuery useCaseQuery;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(@RequestBody UseCaseCreateCommand aCommand) {
        useCaseApplicationService.createUseCase(aCommand);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable String id, @RequestBody UseCaseUpdateCommand aCommand) {
        aCommand.setId(id);
        useCaseApplicationService.updateUseCase(aCommand);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        useCaseApplicationService.deleteUseCase(id);
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public UseCaseResult findOne(@PathVariable String id) {
        return useCaseMapper.findById(id);
    }

    @RequestMapping(value = "/clone/{id}", method = RequestMethod.GET)
    public UseCaseResult cloneOne(@PathVariable String id) {
        return findOne(id);
    }

    @RequestMapping(value = "/list/{pageNum}", method = RequestMethod.POST)
    public PagedList<UseCaseResult> findAll(@PathVariable Integer pageNum, @RequestBody(required = false) UseCaseParameter parameter) {
        return useCaseQuery.findAll(parameter, pageNum);
    }

}
