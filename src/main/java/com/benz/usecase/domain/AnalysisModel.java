package com.benz.usecase.domain;

import java.util.List;

/**
 * Created by hongying.fu on 12/22/2016.
 */
public class AnalysisModel {
    private String text;
    private List<AnalysisModelFile> files;

    public AnalysisModel() {
    }

    public AnalysisModel(String text, List<AnalysisModelFile> files) {
        this.text = text;
        this.files = files;
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
}
