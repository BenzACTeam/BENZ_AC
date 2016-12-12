package com.benz.usecase.application;

import com.benz.usecase.domain.CaseSubject;
import com.benz.usecase.domain.TimeFrame;
import com.benz.usecase.domain.UseCase;
import org.springframework.stereotype.Service;

/**
 * Created by paulliu on 2016/12/12.
 */
@Service
public class UseCaseApplicationService {

    public String createUseCase(UseCaseCommand command) {
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
}
