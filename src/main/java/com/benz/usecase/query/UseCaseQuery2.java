package com.benz.usecase.query;

import com.benz.framework.query.PagedList;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by paulliu on 2016/12/24.
 */
@Mapper
public interface UseCaseQuery2 {

    PagedList<UseCaseResult> findAll(UseCaseParameter parameter);

    UseCaseResult findById(String id);
}
