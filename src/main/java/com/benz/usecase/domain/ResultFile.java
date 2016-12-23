package com.benz.usecase.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by hongying.fu on 12/22/2016.
 */
public class ResultFile {

    private String id;
    private String fileName;
    private String url;
    @ManyToOne(cascade= CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="use_case_id", referencedColumnName = "id")
    @JsonBackReference
    private UseCase useCase;

    public ResultFile() {
    }

    public ResultFile(String fileName, String url) {
        this.id = DomainRegistry.resultRepository().nextIdentity();
        this.fileName = fileName;
        this.url = url;
    }

    public ResultFile(String id, String fileName, String url, UseCase useCase) {
        this.id = DomainRegistry.resultRepository().nextIdentity();
        this.fileName = fileName;
        this.url = url;
        this.useCase = useCase;
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

    public UseCase getUseCase() {
        return useCase;
    }

    public void setUseCase(UseCase useCase) {
        this.useCase = useCase;
//        if(!useCase.getResult().getFiles().contains(this)){
//            useCase.getResult().getFiles().add(this);
//        }
    }

    @Override
    public String toString() {
        return "ResultFile{" +
                "id='" + id + '\'' +
                ", fileName='" + fileName + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
