package com.benz.usecase.query;

import com.benz.framework.query.BaseQuery;
import com.benz.framework.query.PagedList;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;

/**
 * Created by hongying.fu on 12/15/2016.
 */
@Service
public class UseCaseQuery extends BaseQuery {

    public PagedList<UseCaseResult> findAll(UseCaseParameter parameter) throws IllegalAccessException {
        PagedList<UseCaseResult> page = getResult(parameter, "searchUseCase", "countUseCase", "useCaseMapping");
        return page;
    }

    public UseCaseResult findByIdUseCase(String id) {
        Query query = em.createNamedQuery("findByIdUseCase");
        query.setParameter(1, id);
        List l = query.getResultList();
        System.out.println(l.size());
        for (Object obj : l) {
            System.out.println(obj.toString());
        }

        return null;
    }

}