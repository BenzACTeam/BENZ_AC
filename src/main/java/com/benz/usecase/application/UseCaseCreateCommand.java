package com.benz.usecase.application;

/**
 * Created by paulliu on 2016/12/12.
 */
public class UseCaseCreateCommand {

    private String subject;
    private String value;
    private String scenario;
    private String result;
    private String dataSource;
    private String dataTypeDescription;
    private String analysisModel;
    private String contributionBU;
    private String stage;
    private String fromDate;
    private String toDate;
    private String contact;

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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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

    public String getAnalysisModel() {
        return analysisModel;
    }

    public void setAnalysisModel(String analysisModel) {
        this.analysisModel = analysisModel;
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
