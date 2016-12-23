package com.benz.usecase.application;

/**
 * Created by hongying.fu on 12/22/2016.
 */
public class AnalysisModelFileUpdateCommand {
    private String fileName;
    private String url;

    public AnalysisModelFileUpdateCommand() {
    }

    public AnalysisModelFileUpdateCommand(String fileName, String url) {
        this.fileName = fileName;
        this.url = url;
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
}
