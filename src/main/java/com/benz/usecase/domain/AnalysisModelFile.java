package com.benz.usecase.domain;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by hongying.fu on 12/22/2016.
 */
public class AnalysisModelFile {
    private String id;
    private String fileName;
    private String url;
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="analysis_model_id", referencedColumnName = "id")
    private AnalysisModel analysisModel;

    public AnalysisModelFile() {
    }

    public AnalysisModelFile(String fileName, String url) {
        this.id = DomainRegistry.analysisModelRespository().nextIdentity();
        this.fileName = fileName;
        this.url = url;
    }

    public AnalysisModelFile(String fileName, String url, AnalysisModel analysisModel) {
        this.id = DomainRegistry.analysisModelRespository().nextIdentity();
        this.fileName = fileName;
        this.url = url;
        this.analysisModel = analysisModel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public AnalysisModel getAnalysisModel() {
        return analysisModel;
    }

    public void setAnalysisModel(AnalysisModel analysisModel) {
        this.analysisModel = analysisModel;
        if(!analysisModel.getFiles().contains(this)){
            analysisModel.getFiles().add(this);
        }
    }
}
