package com.benz.usecase.domain;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by hongying.fu on 12/22/2016.
 */
public class ResultFile {

    private String id;
    private String fileName;
    private String url;
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="result_id", referencedColumnName = "id")
    private Result result;

    public ResultFile() {
    }

    public ResultFile(String fileName, String url) {
        this.id = DomainRegistry.resultRepository().nextIdentity();
        this.fileName = fileName;
        this.url = url;
    }

    public ResultFile(String fileName, String url, Result result) {
        this.id = DomainRegistry.resultRepository().nextIdentity();
        this.fileName = fileName;
        this.url = url;
        this.result = result;
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

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
        if(!result.getFiles().contains(this)){
            result.getFiles().add(this);
        }
    }


}
