package com.benz.usecase.application;

import java.util.List;

/**
 * Created by paulliu on 2016/12/13.
 */
public class UseCaseUpdateCommand {

    private String id;
    private String subject;
    private String value;
    private String scenario;
    private String validationMethodResultText;
    private List<FileCommand> validationMethodResultFiles;
    private String dataSource;
    private String dataTypeDescription;
    private String analysisMethosResultText;
    private List<FileCommand> analysisMethodResultFiles;
    private String contributionBU;
    private String stage;
    private String fromDate;
    private String toDate;
    private String contact;

    public UseCaseUpdateCommand() {
    }

    public UseCaseUpdateCommand(String id, String subject, String value, String scenario, String validationMethodResultText, List<FileCommand> validationMethodResultFiles, String dataSource, String dataTypeDescription, String analysisMethosResultText, List<FileCommand> analysisMethodResultFiles, String contributionBU, String stage, String fromDate, String toDate, String contact) {
        this.id = id;
        this.subject = subject;
        this.value = value;
        this.scenario = scenario;
        this.validationMethodResultText = validationMethodResultText;
        this.validationMethodResultFiles = validationMethodResultFiles;
        this.dataSource = dataSource;
        this.dataTypeDescription = dataTypeDescription;
        this.analysisMethosResultText = analysisMethosResultText;
        this.analysisMethodResultFiles = analysisMethodResultFiles;
        this.contributionBU = contributionBU;
        this.stage = stage;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.contact = contact;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

    public String getValidationMethodResultText() {
        return validationMethodResultText;
    }

    public void setValidationMethodResultText(String validationMethodResultText) {
        this.validationMethodResultText = validationMethodResultText;
    }

    public List<FileCommand> getValidationMethodResultFiles() {
        return validationMethodResultFiles;
    }

    public void setValidationMethodResultFiles(List<FileCommand> validationMethodResultFiles) {
        this.validationMethodResultFiles = validationMethodResultFiles;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getDataTypeDescription() {
        return dataTypeDescription;
    }

    public void setDataTypeDescription(String dataTypeDescription) {
        this.dataTypeDescription = dataTypeDescription;
    }

    public String getAnalysisMethosResultText() {
        return analysisMethosResultText;
    }

    public void setAnalysisMethosResultText(String analysisMethosResultText) {
        this.analysisMethosResultText = analysisMethosResultText;
    }

    public List<FileCommand> getAnalysisMethodResultFiles() {
        return analysisMethodResultFiles;
    }

    public void setAnalysisMethodResultFiles(List<FileCommand> analysisMethodResultFiles) {
        this.analysisMethodResultFiles = analysisMethodResultFiles;
    }

    public String getContributionBU() {
        return contributionBU;
    }

    public void setContributionBU(String contributionBU) {
        this.contributionBU = contributionBU;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
