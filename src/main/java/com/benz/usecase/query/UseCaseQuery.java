package com.benz.usecase.query;

import com.benz.framework.query.BaseQuery;
import com.benz.framework.query.PageParameter;
import com.benz.framework.query.PagedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by hongying.fu on 12/15/2016.
 */
@Service
public class UseCaseQuery extends BaseQuery {

    @Autowired
    private UseCaseMapper useCaseMapper;

    public PagedList<UseCaseResult> findAll(final UseCaseParameter parameter, Integer pageNum) {

        PagedList<UseCaseResult> useCaseResultPagedList = paging(parameter, new Callable<List<UseCaseResult>>() {
            public List<UseCaseResult> call() {
                return useCaseMapper.findAll(parameter);
            }
        }, new PageParameter(pageNum));

        return useCaseResultPagedList;
    }
}