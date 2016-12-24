package com.benz.usecase.domain;

import com.benz.framework.AssertionConcern;

/**
 * Created by paulliu on 2016/12/12.
 */
public class CaseSubject {
    private String value;

    public CaseSubject() {
    }

    public CaseSubject(String value) {
        AssertionConcern.assertArgumentNotEmpty(value, "Subject cannot be empty");
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
