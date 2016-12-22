package com.benz.usecase.application;

import com.benz.usecase.domain.DomainRegistry;
import com.benz.usecase.domain.Result;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by hongying.fu on 12/22/2016.
 */
public class ResultFileCreateCommand {
    private String fileName;
    private String url;

    public String getUrl() {
        return url;
    }

    public ResultFileCreateCommand(String fileName, String url) {
        this.fileName = fileName;
        this.url = url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ResultFileCreateCommand() {
    }

    public ResultFileCreateCommand(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "ResultFileCreateCommand{" +
                "fileName='" + fileName + '\'' +
                '}';
    }


}
