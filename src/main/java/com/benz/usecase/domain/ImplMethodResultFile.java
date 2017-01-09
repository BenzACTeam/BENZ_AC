package com.benz.usecase.domain;

/**
 * Created by hongying.fu on 1/9/2017.
 */
public class ImplMethodResultFile {
    private String id;
    private String url;
    private String fileName;

    public ImplMethodResultFile() {
    }

    public ImplMethodResultFile(String id, String url, String fileName) {
        this.id = id;
        this.url = url;
        this.fileName = fileName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
