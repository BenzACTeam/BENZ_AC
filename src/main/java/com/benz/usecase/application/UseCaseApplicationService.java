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

        List<ValidationMethodResultFile> validationMethodResultFileList = parseResultFiles(command.getValidationMethodResultFiles());
        ValidationMethodResult validationMethodResult = new ValidationMethodResult(command.getValidationMethodResultText(), validationMethodResultFileList);

        List<AnalysisMethodResultFile> analysisMethodResultFileList = parseAnalysisModelFiles(command.getAnalysisMethodResultFiles());
        AnalysisMethodResult analysisMethodResult = new AnalysisMethodResult(command.getAnalysisMethodResultText(), analysisMethodResultFileList);

        UseCase useCase =
                new UseCase(
                        new CaseSubject(command.getSubject()),
                        command.getValue(),
                        command.getScenario(),
                        validationMethodResult,
                        command.getDataSource(),
                        command.getDataTypeDescription(),
                        analysisMethodResult,
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

        List<ValidationMethodResultFile> validationMethodResultFileList = parseResultFiles(command.getValidationMethodResultFiles());
        ValidationMethodResult validationMethodResult = new ValidationMethodResult(command.getValidationMethodResultText(), validationMethodResultFileList);

        List<AnalysisMethodResultFile> analysisMethodResultFileList = parseAnalysisModelFiles(command.getAnalysisMethodResultFiles());
        AnalysisMethodResult analysisMethodResult = new AnalysisMethodResult(command.getAnalysisMethosResultText(), analysisMethodResultFileList);

        useCase.update(
                new CaseSubject(command.getSubject()),
                command.getValue(),
                command.getScenario(),
                validationMethodResult,
                command.getDataSource(),
                command.getDataTypeDescription(),
                analysisMethodResult,
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

    private List<AnalysisMethodResultFile> parseAnalysisModelFiles(List<FileCommand> fileCommands) {
        List<AnalysisMethodResultFile> analysisMethodResultFileList = new ArrayList<>();
        if (fileCommands != null && fileCommands.size() > 0) {
            for (FileCommand analysisModelFileCommand : fileCommands) {
                AnalysisMethodResultFile analysisMethodResultFile = new AnalysisMethodResultFile(analysisModelFileCommand.getFileName(), analysisModelFileCommand.getUrl());
                analysisMethodResultFileList.add(analysisMethodResultFile);
            }
        }
        return analysisMethodResultFileList;
    }

    private List<ValidationMethodResultFile> parseResultFiles(List<FileCommand> fileCommands) {
        List<ValidationMethodResultFile> validationMethodResultFiles = new ArrayList<>();
        if (fileCommands != null && fileCommands.size() > 0) {
            for (FileCommand fileCommand : fileCommands) {
                ValidationMethodResultFile validationMethodResultFile = new ValidationMethodResultFile(fileCommand.getFileName(), fileCommand.getUrl());
                validationMethodResultFiles.add(validationMethodResultFile);
            }
        }
        return validationMethodResultFiles;
    }
}
