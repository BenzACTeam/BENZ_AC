package com.benz.usecase.domain;

import javax.persistence.Embeddable;
import java.util.Date;

/**
 * Created by paulliu on 2016/12/12.
 */
@Embeddable
public class TimeFrame {
    private Date fromValue;
    private Date toValue;

    public TimeFrame() {
    }

    public TimeFrame(Date fromValue, Date toValue) {
        this.fromValue = fromValue;
        this.toValue = toValue;
    }

    public TimeFrame(String fromValue, String toValue) {
    }
}
