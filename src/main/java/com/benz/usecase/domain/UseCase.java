package com.benz.usecase.domain;

import javax.persistence.*;

/**
 * Created by paulliu on 2016/12/12.
 */
@Entity
public class UseCase {

    @Id
    private String id;
//    @Column(columnDefinition = "nvarchar")
    @Convert(converter = CaseSubjectConverter.class)
    private CaseSubject subject;
//    @Column(columnDefinition = "nvarchar")
    private String value;
//    @Column(columnDefinition = "nvarchar")
    private String scenario;
//    @Column(columnDefinition = "nvarchar")
    private String result;
//    @Column(columnDefinition = "nvarchar")
    private String dataSource;
//    @Column(columnDefinition = "nvarchar")
    private String dataTypeDescription;
//    @Column(columnDefinition = "nvarchar")
    private String analysisModel;
//    @Column(columnDefinition = "nvarchar")
    private String contributionBU;
//    @Column(columnDefinition = "nvarchar")
    private String stage;
    @Embedded
    private TimeFrame timeFrame;
//    @Column(columnDefinition = "nvarchar")
    private String contact;

    public String getId() {
        return id;
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
}
