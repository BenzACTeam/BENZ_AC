package com.benz.usecase.domain;

/**
 * Created by paulliu on 2016/12/12.
 */
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
//        DomainRegistry.repository().create(this);
        DomainRegistry.repository().save(this);
    }
}
