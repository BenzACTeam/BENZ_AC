package com.benz.usecase.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private String text;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade= CascadeType.ALL,mappedBy="useCase")
    @JsonManagedReference
    private List<AnalysisModelFile> files;


    public AnalysisModel() {
    }

    public AnalysisModel(String text, List<AnalysisModelFile> fileNames) {
        this.text = text;
        this.files = fileNames;
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

    public void deleteFiles(String id) {
        DomainRegistry.analysisModelRespository().deleteByUseCaseId(id);
    }
}
