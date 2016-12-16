package com.benz.usecase.domain;

import com.benz.usecase.query.UseCaseResult;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;
import java.util.Date;

/**
 * Created by paulliu on 2016/12/12.
 */
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
@SqlResultSetMapping(
        name = "useCaseMapping",
        classes = @ConstructorResult(
                targetClass = UseCaseResult.class,
                columns = {
                        @ColumnResult(name = "id"),
                        @ColumnResult(name = "subject"),
                        @ColumnResult(name = "value"),
                        @ColumnResult(name = "scenario"),
                        @ColumnResult(name = "result"),
                        @ColumnResult(name = "data_source"),
                        @ColumnResult(name = "data_type_description"),
                        @ColumnResult(name = "analysis_model"),
                        @ColumnResult(name = "contributionbu"),
                        @ColumnResult(name = "stage"),
                        @ColumnResult(name = "afrom_value",type= String.class),
                        @ColumnResult(name = "ato_value",type = String.class),
                        @ColumnResult(name = "contact")
                }
        )
)
public class UseCase {
    private String id;
    private CaseSubject subject;
    private String value;
    private String scenario;
    private String result;
    private String dataSource;
    private String dataTypeDescription;
    private String analysisModel;
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

    public UseCase(CaseSubject subject, String value, String scenario, String result, String dataSource, String dataTypeDescription, String analysisModel, String contributionBU, String stage, TimeFrame timeFrame, String contact) {

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

    public void update(CaseSubject subject, String value, String scenario, String result, String dataSource, String dataTypeDescription, String analysisModel, String contributionBU, String stage, TimeFrame timeFrame, String contact) {
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


}
