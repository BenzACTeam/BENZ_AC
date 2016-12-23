package com.benz.usecase.domain;

import com.benz.framework.jpa.BaseRepository;
import org.hibernate.annotations.SQLDelete;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

/**
 * Created by hongying.fu on 12/22/2016.
 */
public interface ResultFileRepository extends BaseRepository<ResultFile, String> {
    @Modifying
    @Transactional
    @Query( "delete from ResultFile rf where rf.useCase.id = :useCaseId")
    void deleteByUseCaseId(@Param("useCaseId") String useCaseId);
}
