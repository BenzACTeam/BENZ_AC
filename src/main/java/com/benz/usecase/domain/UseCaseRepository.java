package com.benz.usecase.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by paulliu on 2016/12/12.
 */
public interface UseCaseRepository extends JpaRepository<UseCase, String> {

}
