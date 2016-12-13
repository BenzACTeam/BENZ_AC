package com.benz.usecase.domain;

import com.benz.framework.jpa.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by paulliu on 2016/12/12.
 */
public interface UseCaseRepository extends BaseRepository<UseCase, String> {

}
