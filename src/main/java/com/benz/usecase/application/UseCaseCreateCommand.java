package com.benz.usecase.application;

import java.util.List;

/**
 * Created by paulliu on 2016/12/12.
 */
public class UseCaseCreateCommand {

    private String subject;
    private String value;
    private String scenario;
    private String resultText;
    private List<FileCommand> resultFiles;
    private String dataSource;
    private String dataTypeDescription;
    private String analysisModelText;
    private List<FileCommand> analysisModelFiles;
    private String contributionBU;
    private String stage;
    private String fromDate;
    private String toDate;
    private String contact;

    public UseCaseCreateCommand() {
    }

    public UseCaseCreateCommand(String subject, String value, String scenario, String resultText, List<FileCommand> resultFiles, String dataSource, String dataTypeDescription, String analysisModelText, List<FileCommand> analysisModelFiles, String contributionBU, String stage, String fromDate, String toDate, String contact) {
        this.subject = subject;
        this.value = value;
        this.scenario = scenario;
        this.resultText = resultText;
        this.resultFiles = resultFiles;
        this.dataSource = dataSource;
        this.dataTypeDescription = dataTypeDescription;
        this.analysisModelText = analysisModelText;
        this.analysisModelFiles = analysisModelFiles;
        this.contributionBU = contributionBU;
        this.stage = stage;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.contact = contact;
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

    public void setResultText(String resultText) {
        this.resultText = resultText;
    }

    public List<FileCommand> getResultFiles() {
        return resultFiles;
    }

    public void setResultFiles(List<FileCommand> resultFiles) {
        this.resultFiles = resultFiles;
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

    public String getResultText() {
        return resultText;
    }

    public String getAnalysisModelText() {
        return analysisModelText;
    }

    public void setAnalysisModelText(String analysisModelText) {
        this.analysisModelText = analysisModelText;
    }

    public List<FileCommand> getAnalysisModelFiles() {
        return analysisModelFiles;
    }

    public void setAnalysisModelFiles(List<FileCommand> analysisModelFiles) {
        this.analysisModelFiles = analysisModelFiles;
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
