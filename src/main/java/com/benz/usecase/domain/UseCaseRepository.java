package com.benz.usecase.domain;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by paulliu on 2016/12/12.
 */
public interface UseCaseRepository extends CrudRepository<UseCase, String> {

    String nextIdentity();

    void create(UseCase useCase);
}
