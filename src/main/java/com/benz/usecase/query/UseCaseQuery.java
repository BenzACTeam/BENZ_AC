package com.benz.usecase.query;

import com.benz.framework.query.BaseQuery;
import com.benz.framework.query.PagedList;
import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by hongying.fu on 12/15/2016.
 */
@Component
public class UseCaseQuery extends BaseQuery {

    public PagedList<UseCaseResult> findAll(UseCaseParameter parameter, Integer pageNo, Integer pageSize)throws IllegalAccessException {
        PagedList<UseCaseResult> page = getResult(parameter, pageNo, pageSize, "searchUseCase", "countUseCase", "useCaseMapping");
        return page;
    }

    public UseCaseResult findByIdUseCase(String id) {
        Query query = em.createNamedQuery("findByIdUseCase");
        query.setParameter(1, id);
        UseCaseResult result = (UseCaseResult) query.getSingleResult();
        return result;
    }

}