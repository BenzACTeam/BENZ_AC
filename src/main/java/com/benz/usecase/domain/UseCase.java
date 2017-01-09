package com.benz.usecase.domain;

import java.util.Date;
import java.util.List;

/**
 * Created by paulliu on 2016/12/12.
 */
public class UseCase {
    private String id;
    private CaseSubject subject;
    private String value;
    private String scenario;
    private String dataSource;
    private String dataTypeDescription;
    private AnalysisMethodResult analysisMethodResult;
    private ValidationMethodResult validationMethodResult;
    private ImplMethodResult implMethodResult;
    private String contributionBU;
    private String stage;
    private TimeFrame timeFrame;
    private String contact;

    private List<Attachment> attachments;
    private Date createTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CaseSubject getSubject() {
        return subject;
    }

    public void setSubject(CaseSubject subject) {
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

    public ValidationMethodResult getValidationMethodResult() {
        return validationMethodResult;
    }

    public void setValidationMethodResult(ValidationMethodResult validationMethodResult) {
        this.validationMethodResult = validationMethodResult;
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

    public AnalysisMethodResult getAnalysisMethodResult() {
        return analysisMethodResult;
    }

    public void setAnalysisMethodResult(AnalysisMethodResult analysisMethodResult) {
        this.analysisMethodResult = analysisMethodResult;
    }

    public ImplMethodResult getImplMethodResult() {
        return implMethodResult;
    }

    public void setImplMethodResult(ImplMethodResult implMethodResult) {
        this.implMethodResult = implMethodResult;
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

    public TimeFrame getTimeFrame() {
        return timeFrame;
    }

    public void setTimeFrame(TimeFrame timeFrame) {
        this.timeFrame = timeFrame;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public UseCase() {
    }

    public UseCase(String id, CaseSubject subject, String value, String scenario, String dataSource, String dataTypeDescription, AnalysisMethodResult analysisMethodResult, ValidationMethodResult validationMethodResult, ImplMethodResult implMethodResult, String contributionBU, String stage, TimeFrame timeFrame, String contact) {
        this.id = DomainRegistry.repository().nextIdentity();
        this.subject = subject;
        this.value = value;
        this.scenario = scenario;
        this.dataSource = dataSource;
        this.dataTypeDescription = dataTypeDescription;
        this.analysisMethodResult = analysisMethodResult;
        this.validationMethodResult = validationMethodResult;
        this.implMethodResult = implMethodResult;
        this.contributionBU = contributionBU;
        this.stage = stage;
        this.timeFrame = timeFrame;
        this.contact = contact;
    }

    public void create() {
        DomainRegistry.repository().save(this);
    }

    public void update(CaseSubject subject, String value, String scenario, ValidationMethodResult validationMethodResult, String dataSource, String dataTypeDescription, AnalysisMethodResult analysisMethodResult, String contributionBU, String stage, TimeFrame timeFrame, String contact) {
        setSubject(subject);
        setValue(value);
        setScenario(scenario);
        setDataSource(dataSource);
        setDataTypeDescription(dataTypeDescription);
        setContributionBU(contributionBU);
        setStage(stage);
        setTimeFrame(timeFrame);
        setContact(contact);

        this.validationMethodResult.reset(validationMethodResult);
        this.analysisMethodResult.reset(analysisMethodResult);

        DomainRegistry.repository().save(this);
    }

    public void delete() {
        DomainRegistry.repository().delete(this);
    }

}
