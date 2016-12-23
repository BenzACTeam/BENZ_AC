package com.benz.usecase.application;

import com.benz.framework.AssertionConcern;
import com.benz.usecase.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paulliu on 2016/12/12.
 */
@Service
public class UseCaseApplicationService {

    @Autowired
    private UseCaseRepository useCaseRepository;

    public String createUseCase(UseCaseCreateCommand command) {

        List<ResultFile> list = new ArrayList<ResultFile>();
        Result result = new Result(command.getResultText(),list);

        List<AnalysisModelFile> analysisModelFileList = new ArrayList<AnalysisModelFile>();
        AnalysisModel analysisModel = new AnalysisModel(command.getAnalysisModelText(),analysisModelFileList);

        UseCase useCase =
                new UseCase(
                        new CaseSubject(command.getSubject()),
                        command.getValue(),
                        command.getScenario(),
                        result,
                        command.getDataSource(),
                        command.getDataTypeDescription(),
                        analysisModel,
                        command.getContributionBU(),
                        command.getStage(),
                        new TimeFrame(command.getFromDate(), command.getToDate()),
                        command.getContact()
                );

        List<ResultFileCreateCommand> resultFileCreateCommands = command.getResultFiles();
        if(resultFileCreateCommands != null && resultFileCreateCommands.size() > 0){
            for (ResultFileCreateCommand resultFileCreateCommand : resultFileCreateCommands){
                ResultFile resultFile = new ResultFile(resultFileCreateCommand.getFileName(), resultFileCreateCommand.getUrl());
                useCase.addResultFile(resultFile);
            }
        }

        List<AnalysisModelFileCreateCommand> analysisModelFileCommands = command.getAnalysisModelFiles();
        if(analysisModelFileCommands != null && analysisModelFileCommands.size()>0){
            for(AnalysisModelFileCreateCommand analysisModelFileCommand : analysisModelFileCommands){
                AnalysisModelFile analysisModelFile = new AnalysisModelFile(analysisModelFileCommand.getFileName(),analysisModelFileCommand.getUrl());
                useCase.addAnalysisModelFile(analysisModelFile);
            }
        }

        useCase.create();
        return useCase.getId();
    }

    public void updateUseCase(UseCaseUpdateCommand command) {
        UseCase useCase = existing(command.getId());
        System.out.println("useCase: " + useCase);
        useCase.deleteResult();
        useCase.deleteAnalysisModel();

        Result result = useCase.getResult();
        result.setText(command.getResultText());

        List<ResultFileUpdateCommand> resultFileCreateCommands = command.getResultFiles();
        if(resultFileCreateCommands != null && resultFileCreateCommands.size() > 0){
            for (ResultFileUpdateCommand resultFileCreateCommand : resultFileCreateCommands){
                ResultFile resultFile = new ResultFile(resultFileCreateCommand.getFileName(), resultFileCreateCommand.getUrl());
                useCase.addResultFile(resultFile);
            }
        }

        AnalysisModel analysisModel = useCase.getAnalysisModel();
        analysisModel.setText(command.getAnalysisModelText());

        List<AnalysisModelFileUpdateCommand> analysisModelFileCommands = command.getAnalysisModelFiles();
        if(analysisModelFileCommands != null && analysisModelFileCommands.size()>0){
            for(AnalysisModelFileUpdateCommand analysisModelFileCommand : analysisModelFileCommands){
                AnalysisModelFile analysisModelFile = new AnalysisModelFile(analysisModelFileCommand.getFileName(),analysisModelFileCommand.getUrl());
                useCase.addAnalysisModelFile(analysisModelFile);
            }
        }

        useCase.update(
                new CaseSubject(command.getSubject()),
                command.getValue(),
                command.getScenario(),
                result,
                command.getDataSource(),
                command.getDataTypeDescription(),
                analysisModel,
                command.getContributionBU(),
                command.getStage(),
                new TimeFrame(command.getFromDate(), command.getToDate()),
                command.getContact());
    }

    public void deleteUseCase(String id) {
        UseCase useCase = existing(id);
        useCase.delete();
    }

    private UseCase existing(String id) {
        UseCase useCase = useCaseRepository.getOne(id);
        AssertionConcern.assertArgumentNotNull(useCase, "use case does not exist");
        return useCase;
    }


    public UseCase findById(String id) {
        UseCase useCase = useCaseRepository.getOne(id);
        System.out.println(useCase);
        return useCase;
    }
}
