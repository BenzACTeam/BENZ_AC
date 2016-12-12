package com.benz.usecase.application;

/**
 * Created by paulliu on 2016/12/12.
 */
public class UseCaseCommand {

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

    public String getValue() {
        return value;
    }

    public String getScenario() {
        return scenario;
    }

    public String getResult() {
        return result;
    }

    public String getDataSource() {
        return dataSource;
    }

    public String getDataTypeDescription() {
        return dataTypeDescription;
    }

    public String getAnalysisModel() {
        return analysisModel;
    }

    public String getContributionBU() {
        return contributionBU;
    }

    public String getStage() {
        return stage;
    }

    public String getFromDate() {
        return fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public String getContact() {
        return contact;
    }
}
