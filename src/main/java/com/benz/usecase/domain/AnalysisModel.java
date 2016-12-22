package com.benz.usecase.domain;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by hongying.fu on 12/22/2016.
 */
public class AnalysisModel {
    private String id;
    private String text;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade= CascadeType.ALL,mappedBy="analysisModel")
    private List<AnalysisModelFile> files;


    public AnalysisModel() {
    }

    public void addFile(AnalysisModelFile analysisModelFile){
        this.files.add(analysisModelFile);
        if(analysisModelFile.getAnalysisModel() != this){
            analysisModelFile.setAnalysisModel(this);
        }
    }
    public AnalysisModel(String text, List<AnalysisModelFile> fileNames) {
        this.id = DomainRegistry.analysisModelRespository().nextIdentity();
        this.text = text;
        this.files = fileNames;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<AnalysisModelFile> getFiles() {
        return files;
    }

    public void setFiles(List<AnalysisModelFile> files) {
        this.files = files;
    }

    public void create() {
        DomainRegistry.analysisModelRespository().save(this);
    }
}
