package com.benz.usecase.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by hongying.fu on 12/22/2016.
 */
public class Result {
    private String text;
    @OneToMany(cascade= CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="useCase")
    @JsonManagedReference
    private List<ResultFile> files;

    public Result() {
    }

    public Result(String text, List<ResultFile> files) {
        this.text = text;
        this.files = files;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<ResultFile> getFiles() {
        return files;
    }

    public void setFiles(List<ResultFile> files) {
        this.files = files;
    }

    public void deleteResultFile(String useCaseId) {

        DomainRegistry.resultRepository().deleteByUseCaseId(useCaseId);
    }

}
