package com.benz.usecase.query;

import com.benz.framework.query.QueryParameter;

/**
 * Created by hongying.fu on 12/16/2016.
 */
public class UseCaseParameter extends QueryParameter {
    private String subject;
    private String value;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public UseCaseParameter(String subject, String value) {
        this.subject = subject;
        this.value = value;
    }

    public UseCaseParameter() {
    }
}
