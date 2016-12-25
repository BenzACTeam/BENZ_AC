package com.benz.usecase.application;

import com.benz.framework.AssertionConcern;
import com.benz.usecase.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

        List<ResultFile> resultFileList = parseResultFiles(command.getResultFiles());
        Result result = new Result(command.getResultText(), resultFileList);

        List<AnalysisModelFile> analysisModelFileList = parseAnalysisModelFiles(command.getAnalysisModelFiles());
        AnalysisModel analysisModel = new AnalysisModel(command.getAnalysisModelText(), analysisModelFileList);

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

        useCase.create();

        return useCase.getId();
    }

    @Transactional
    public void updateUseCase(UseCaseUpdateCommand command) {
        UseCase useCase = existing(command.getId());

        List<ResultFile> resultFileList = parseResultFiles(command.getResultFiles());
        Result result = new Result(command.getResultText(), resultFileList);

        List<AnalysisModelFile> analysisModelFileList = parseAnalysisModelFiles(command.getAnalysisModelFiles());
        AnalysisModel analysisModel = new AnalysisModel(command.getAnalysisModelText(), analysisModelFileList);

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
        UseCase useCase = useCaseRepository.findOne(id);
        AssertionConcern.assertArgumentNotNull(useCase, "use case does not exist");
        return useCase;
    }

    private List<AnalysisModelFile> parseAnalysisModelFiles(List<FileCommand> fileCommands) {
        List<AnalysisModelFile> analysisModelFileList = new ArrayList<>();
        if (fileCommands != null && fileCommands.size() > 0) {
            for (FileCommand analysisModelFileCommand : fileCommands) {
                AnalysisModelFile analysisModelFile = new AnalysisModelFile(analysisModelFileCommand.getFileName(), analysisModelFileCommand.getUrl());
                analysisModelFileList.add(analysisModelFile);
            }
        }
        return analysisModelFileList;
    }

    private List<ResultFile> parseResultFiles(List<FileCommand> fileCommands) {
        List<ResultFile> resultFiles = new ArrayList<>();
        if (fileCommands != null && fileCommands.size() > 0) {
            for (FileCommand fileCommand : fileCommands) {
                ResultFile resultFile = new ResultFile(fileCommand.getFileName(), fileCommand.getUrl());
                resultFiles.add(resultFile);
            }
        }
        return resultFiles;
    }
}
