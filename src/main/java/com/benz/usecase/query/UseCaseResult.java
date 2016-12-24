package com.benz.usecase.query;

import java.util.List;

/**
 * Created by hongying.fu on 12/15/2016.
 */
public class UseCaseResult {
    private String id;
    private String subject;
    private String value;
    private String scenario;
    private String resultText;
    private String dataSource;
    private String dataTypeDescription;
    private String analysisModelText;
    private String contributionBU;
    private String stage;
    private String fromDate;
    private String toDate;
    private String contact;
    private List<FileResult> resultFiles;
    private List<FileResult> analysisModelFiles;

    public UseCaseResult() {
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

    public String getResultText() {
        return resultText;
    }

    public void setResultText(String resultText) {
        this.resultText = resultText;
    }

    public List<FileResult> getResultFiles() {
        return resultFiles;
    }

    public void setResultFiles(List<FileResult> resultFiles) {
        this.resultFiles = resultFiles;
    }

    public String getAnalysisModelText() {
        return analysisModelText;
    }

    public void setAnalysisModelText(String analysisModelText) {
        this.analysisModelText = analysisModelText;
    }

    public List<FileResult> getAnalysisModelFiles() {
        return analysisModelFiles;
    }

    public void setAnalysisModelFiles(List<FileResult> analysisModelFiles) {
        this.analysisModelFiles = analysisModelFiles;
    }
}
