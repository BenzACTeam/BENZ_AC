package com.benz.usecase.query;

/**
 * Created by paulliu on 2016/12/23.
 */
public class FileResult {
    private String fileName;
    private String url;

    public FileResult() {
    }

    public FileResult(String fileName, String url) {
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
