package com.benz.usecase.domain;

import java.util.List;

/**
 * Created by hongying.fu on 12/22/2016.
 */
public class Result {
    private String text;
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
}
