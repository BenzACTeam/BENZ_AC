package com.benz.user.domain;

/**
 * Created by hongying.fu on 1/9/2017.
 */
public class UserCommentLikeShare {
    private String id;
    private String userId;
    private Boolean isLoginPerDay;

    private Integer perDayViewCaseTimes;  //2
    private Boolean overPerDayViewCaseTimes;

    private Integer perDayDownAttachTimes;  //2
    private Boolean overPerDayDownAttachTimes;

    private Integer perDayCommentTimes;  //2
    private Boolean overPerDayCommentTimes;

    private Integer perDayLikeTimes;  //2
    private Boolean overPerDayLikeTimes;

    private Integer perDayShareTimes;  //5
    private Integer overPerDayShareTimes;
}
