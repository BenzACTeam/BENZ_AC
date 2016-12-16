package com.benz.usecase.adapter.web;

import com.benz.usecase.application.UseCaseApplicationService;
import com.benz.usecase.application.UseCaseCreateCommand;
import com.benz.usecase.application.UseCaseUpdateCommand;
import com.benz.usecase.domain.UseCase;
import com.benz.usecase.query.Page2;
import com.benz.usecase.query.UseCaseQuery;
import com.benz.usecase.query.UseCaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
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
    private UseCaseQuery useCaseQuery;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(UseCaseCreateCommand aCommand) {
        useCaseApplicationService.createUseCase(aCommand);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void update(UseCaseUpdateCommand aCommand) {
        useCaseApplicationService.updateUseCase(aCommand);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(String id) {
        useCaseApplicationService.deleteUseCase(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Page2<UseCaseResult> findAll(Integer pageNo, Integer pageSize) {
        /*Page<UseCase> xx = useCaseQuery.findAll(new PageRequest(pageNo, pageSize));
        List<UseCase> ucs =  xx.getContent();
        List<UseCaseResult> results = new ArrayList<UseCaseResult>();
        for(UseCase useCase : ucs){
            UseCaseResult result = new UseCaseResult();
            result.setId(useCase.getId());
            result.setSubject(useCase.getSubject().getValue());
            result.setValue(useCase.getValue());
            results.add(result);
        }
//        return useCaseQuery.findAll(null, pageNo, pageSize);
        Page2<UseCaseResult> page2 = new Page2<UseCaseResult>();
        page2.setList(results);
        page2.hasNext(xx.hasNext());*/
        return useCaseQuery.findAll(null,pageNo,pageSize);
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public UseCaseResult findOne(String id) {
        return useCaseQuery.findOne(id);
    }

    @RequestMapping(value = "/clone", method = RequestMethod.GET)
    public UseCaseResult cloneOne(String id) {
        UseCaseResult result = useCaseQuery.findOne(id);
        result.setId(null);
        return result;
    }

}
