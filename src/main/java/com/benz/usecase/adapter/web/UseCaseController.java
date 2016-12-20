package com.benz.usecase.adapter.web;

import com.benz.usecase.application.UseCaseApplicationService;
import com.benz.usecase.application.UseCaseCreateCommand;
import com.benz.usecase.application.UseCaseUpdateCommand;
import com.benz.usecase.domain.UseCase;
import com.benz.usecase.query.Page2;
import com.benz.usecase.query.UseCaseParameter;
import com.benz.usecase.query.UseCaseQuery;
import com.benz.usecase.query.UseCaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public void create( UseCaseCreateCommand aCommand) {
        useCaseApplicationService.createUseCase(aCommand);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable String id,UseCaseUpdateCommand aCommand) {
        aCommand.setId(id);
        useCaseApplicationService.updateUseCase(aCommand);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        useCaseApplicationService.deleteUseCase(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Page2<UseCaseResult> findAll(UseCaseParameter parameter,Integer pageNo, Integer pageSize) {
        if(pageNo == null){
            pageNo = 1;
        }
        if(pageSize == null){
            pageSize = 10;
        }
        return useCaseQuery.findAll(parameter,pageNo,pageSize);
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public UseCaseResult findOne(@PathVariable String id) {
        return useCaseQuery.findOne(id);
    }

    @RequestMapping(value = "/clone/{id}", method = RequestMethod.GET)
    public UseCaseResult cloneOne(@PathVariable String id) {
        UseCaseResult result = useCaseQuery.findOne(id);
        result.setId(null);
        return result;
    }

    @RequestMapping(value = "/upload" ,method = RequestMethod.POST)
    public void upload(HttpServletRequest request, HttpServletResponse response)throws Exception{
        useCaseApplicationService.upload(request,response);
    }


}
