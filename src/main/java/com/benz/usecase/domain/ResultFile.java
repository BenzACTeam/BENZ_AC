package com.benz.usecase.domain;

import javax.persistence.ManyToOne;

/**
 * Created by hongying.fu on 12/22/2016.
 */
public class ResultFile {
    private String id;
    private String fileName;
    private String url;

    public ResultFile() {
    }

    public ResultFile(String fileName, String url) {
        this.id = DomainRegistry.resultFileRepository().nextIdentity();
        this.fileName = fileName;
        this.url = url;
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

    public void delete() {
        DomainRegistry.resultFileRepository().delete(this.getId());
    }
}
