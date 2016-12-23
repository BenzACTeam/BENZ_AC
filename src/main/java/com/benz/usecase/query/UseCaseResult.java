package com.benz.usecase.query;

import com.benz.usecase.domain.AnalysisModelFile;
import com.benz.usecase.domain.ResultFile;

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
    private List<ResultFile> resultFiles;
    private List<AnalysisModelFile> analysisModelFiles;

    public UseCaseResult() {
    }

    public UseCaseResult(String id, String subject) {
        this.id = id;
        this.subject = subject;
    }

    public UseCaseResult(String id, String subject, List<ResultFile> resultFiles) {
        this.id = id;
        this.subject = subject;
        this.resultFiles = resultFiles;
    }

    public UseCaseResult(String id, String subject, String value, String scenario, String resultText, String dataSource, String dataTypeDescription, String analysisModelText, String contributionBU, String stage, String fromDate, String toDate, String contact, List<ResultFile> resultFiles) {
        this.id = id;
        this.subject = subject;
        this.value = value;
        this.scenario = scenario;
        this.resultText = resultText;
        this.dataSource = dataSource;
        this.dataTypeDescription = dataTypeDescription;
        this.analysisModelText = analysisModelText;
        this.contributionBU = contributionBU;
        this.stage = stage;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.contact = contact;
        this.resultFiles = resultFiles;
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

    public List<ResultFile> getResultFiles() {
        return resultFiles;
    }

    public void setResultFiles(List<ResultFile> resultFiles) {
        this.resultFiles = resultFiles;
    }

    public String getAnalysisModelText() {
        return analysisModelText;
    }

    public void setAnalysisModelText(String analysisModelText) {
        this.analysisModelText = analysisModelText;
    }

    public List<AnalysisModelFile> getAnalysisModelFiles() {
        return analysisModelFiles;
    }

    public void setAnalysisModelFiles(List<AnalysisModelFile> analysisModelFiles) {
        this.analysisModelFiles = analysisModelFiles;
    }
}
