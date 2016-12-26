package com.benz.usecase.adapter.web;

import com.benz.framework.query.PagedList;
import com.benz.usecase.application.UseCaseApplicationService;
import com.benz.usecase.application.UseCaseCreateCommand;
import com.benz.usecase.application.UseCaseUpdateCommand;
import com.benz.usecase.query.UseCaseParameter;
import com.benz.usecase.query.UseCaseQuery2;
import com.benz.usecase.query.UseCaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by paulliu on 2016/12/12.
 */
@RestController
@RequestMapping("/usecase")
public class UseCaseController {
    @Autowired
    private UseCaseApplicationService useCaseApplicationService;
    @Autowired
    private UseCaseQuery2 useCaseQuery;

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
        return useCaseQuery.findById(id);
    }

    @RequestMapping(value = "/clone/{id}", method = RequestMethod.GET)
    public UseCaseResult cloneOne(@PathVariable String id) {
        return findOne(id);
    }

    @RequestMapping(value = "/list/{pageNo}", method = RequestMethod.GET)
    public PagedList<UseCaseResult> findAll(@PathVariable Integer pageNo, UseCaseParameter parameter) {
        parameter.prepare(pageNo, null);

        List<UseCaseResult> useCaseResultList = useCaseQuery.findAll(parameter);

        return null;
    }

}
