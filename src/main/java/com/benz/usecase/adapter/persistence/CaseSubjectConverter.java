package com.benz.usecase.adapter.persistence;

import com.benz.usecase.domain.CaseSubject;
import javax.persistence.AttributeConverter;

/**
 * Created by paulliu on 2016/12/13.
 */
public class CaseSubjectConverter implements AttributeConverter<CaseSubject, String> {
    @Override
    public String convertToDatabaseColumn(CaseSubject caseSubject) {
        return caseSubject.getValue();
    }

    @Override
    public CaseSubject convertToEntityAttribute(String s) {
        return new CaseSubject(s);
    }
}
