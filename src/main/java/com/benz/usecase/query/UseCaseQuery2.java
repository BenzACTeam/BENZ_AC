package com.benz.usecase.query;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by paulliu on 2016/12/24.
 */
@Mapper
public interface UseCaseQuery2 {

    List<UseCaseResult> findAll(UseCaseParameter parameter);

    UseCaseResult findById(String id);
}
