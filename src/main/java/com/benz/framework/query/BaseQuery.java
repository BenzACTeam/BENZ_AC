package com.benz.framework.query;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by hongying.fu on 12/21/2016.
 */
public class BaseQuery {

    protected <T> PagedList<T> paging(QueryParameter parameter, Integer pageNum, Callable<List<T>> func) {

        PageHelper.startPage(pageNum, 2);

        List<T> useCaseResultList = null;
        try {
            useCaseResultList = func.call();
        } catch (Exception e) {
            //TODO: exception handling
            e.printStackTrace();
        }

        PageInfo<T> pageInfo = ((Page<T>) useCaseResultList).toPageInfo();

        PagedList<T> pagedList = new PagedList<>(
                useCaseResultList,
                pageInfo.getPageNum(),
                pageInfo.getPageSize(),
                pageInfo.getSize(),
                pageInfo.getTotal(),
                pageInfo.getPages(),
                pageInfo.isIsFirstPage(),
                pageInfo.isIsLastPage(),
                pageInfo.isHasPreviousPage(),
                pageInfo.isHasNextPage());

        return pagedList;
    }

}
