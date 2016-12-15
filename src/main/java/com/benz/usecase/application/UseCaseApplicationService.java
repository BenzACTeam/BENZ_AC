package com.benz.usecase.application;

import com.benz.framework.AssertionConcern;
import com.benz.usecase.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * Created by paulliu on 2016/12/12.
 */
@Service
public class UseCaseApplicationService {

    @Autowired
    private UseCaseRepository useCaseRepository;

    public String createUseCase(UseCaseCreateCommand command) {
        UseCase useCase =
                new UseCase(
                        new CaseSubject(command.getSubject()),
                        command.getValue(),
                        command.getScenario(),
                        command.getResult(),
                        command.getDataSource(),
                        command.getDataTypeDescription(),
                        command.getAnalysisModel(),
                        command.getContributionBU(),
                        command.getStage(),
                        new TimeFrame(command.getFromDate(), command.getToDate()),
                        command.getContact()
                );

        useCase.create();
        return useCase.getId();
    }

    public void updateUseCase(UseCaseUpdateCommand command) {
        UseCase useCase = existing(command.getId());
        useCase.update(
                new CaseSubject(command.getSubject()),
                command.getValue(),
                command.getScenario(),
                command.getResult(),
                command.getDataSource(),
                command.getDataTypeDescription(),
                command.getAnalysisModel(),
                command.getContributionBU(),
                command.getStage(),
                new TimeFrame(command.getFromDate(), command.getToDate()),
                command.getContact());
    }

    public void deleteUseCase(String id) {
        UseCase useCase = existing(id);
        useCase.delete();
    }

    public List<UseCase> findAll(Integer pageNo, Integer pageSize) {
        Pageable pageRequest = new PageRequest(pageNo,pageSize);
        Page<UseCase> page = DomainRegistry.repository().findAll(pageRequest);
        return  page.getContent();
    }

    private UseCase existing(String id) {
        UseCase useCase = useCaseRepository.getOne(id);
        System.out.println(useCase);
        AssertionConcern.assertArgumentNotNull(useCase, "use case does not exist");
        return useCase;
    }

    public UseCase findOne(String id) {
        UseCase useCase = DomainRegistry.repository().getOne(id);
        return useCase;
    }

}
