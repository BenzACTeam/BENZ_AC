package com.benz.usecase.query;

import com.benz.framework.query.QueryParameter;

/**
 * Created by hongying.fu on 12/16/2016.
 */
public class UseCaseParameter extends QueryParameter {
    private String subject;

    public UseCaseParameter() {
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

}
