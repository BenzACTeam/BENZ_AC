package com.benz.usecase.domain;

import java.util.List;

/**
 * Created by hongying.fu on 1/9/2017.
 */
public class ImplMethodResult {
    private String implMethodResultText;
    private List<ImplMethodResultFile> files;

    public ImplMethodResult() {
    }

    public ImplMethodResult(String implMethodResultText, List<ImplMethodResultFile> files) {
        this.implMethodResultText = implMethodResultText;
        this.files = files;
    }

    public String getImplMethodResultText() {
        return implMethodResultText;
    }

    public void setImplMethodResultText(String implMethodResultText) {
        this.implMethodResultText = implMethodResultText;
    }

    public List<ImplMethodResultFile> getFiles() {
        return files;
    }

    public void setFiles(List<ImplMethodResultFile> files) {
        this.files = files;
    }
}
