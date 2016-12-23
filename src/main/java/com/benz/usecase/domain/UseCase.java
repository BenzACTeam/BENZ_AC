package com.benz.usecase.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by paulliu on 2016/12/12.
 */

@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "fieldHandler"})
public class UseCase {
    private String id;
    private CaseSubject subject;
    private String value;
    private String scenario;
    private Result result;
    private String dataSource;
    private String dataTypeDescription;
    private AnalysisModel analysisModel;
    private String contributionBU;
    private String stage;
    private TimeFrame timeFrame;
    private String contact;

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

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
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

    public AnalysisModel getAnalysisModel() {
        return analysisModel;
    }

    public void setAnalysisModel(AnalysisModel analysisModel) {
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

    public UseCase(CaseSubject subject, String value, String scenario, Result result, String dataSource, String dataTypeDescription, AnalysisModel analysisModel, String contributionBU, String stage, TimeFrame timeFrame, String contact) {

        this.id = DomainRegistry.repository().nextIdentity();
        this.subject = subject;
        this.value = value;
        this.scenario = scenario;
        this.result = result;
        this.dataSource = dataSource;
        this.dataTypeDescription = dataTypeDescription;
        this.analysisModel = analysisModel;
        this.contributionBU = contributionBU;
        this.stage = stage;
        this.timeFrame = timeFrame;
        this.contact = contact;

    }

    public void create() {
        DomainRegistry.repository().save(this);
    }

    public void update(CaseSubject subject, String value, String scenario, Result result, String dataSource, String dataTypeDescription, AnalysisModel analysisModel, String contributionBU, String stage, TimeFrame timeFrame, String contact) {
        setSubject(subject);
        setValue(value);
        setScenario(scenario);
        setResult(result);
        setDataSource(dataSource);
        setDataTypeDescription(dataTypeDescription);
        setAnalysisModel(analysisModel);
        setContributionBU(contributionBU);
        setStage(stage);
        setTimeFrame(timeFrame);
        setContact(contact);

        DomainRegistry.repository().save(this);
    }

    public void delete() {
        DomainRegistry.repository().delete(id);
    }

    public void addResultFile(ResultFile resultFile){
        this.result.getFiles().add(resultFile);
        if(resultFile.getUseCase() != this){
            resultFile.setUseCase(this);
        }
    }

    public void addAnalysisModelFile(AnalysisModelFile analysisModelFile){
        this.analysisModel.getFiles().add(analysisModelFile);
        if(analysisModelFile.getUseCase() != this){
            analysisModelFile.setUseCase(this);
        }
    }

    public void deleteResult() {
        if(this.result != null){
            this.result.deleteResultFile(this.id);
        }
    }

    public void deleteAnalysisModel() {
        if(this.analysisModel != null){
            this.analysisModel.delelteFiles(this.id);
        }
    }

    @Override
    public String toString() {
        return "UseCase{" +
                "id='" + id + '\'' +
                ", subject=" + subject +
                ", value='" + value + '\'' +
                ", scenario='" + scenario + '\'' +
                ", result=" + result +
                ", dataSource='" + dataSource + '\'' +
                ", dataTypeDescription='" + dataTypeDescription + '\'' +
                ", analysisModel=" + analysisModel +
                ", contributionBU='" + contributionBU + '\'' +
                ", stage='" + stage + '\'' +
                ", timeFrame=" + timeFrame +
                ", contact='" + contact + '\'' +
                '}';
    }
}
