package com.benz.framework.query;

/**
 * Created by paulliu on 2016/12/26.
 */
public class PageParameter {
    private Integer pageNum;
    private Integer pageSize;

    public PageParameter(Integer pageNum) {
        this(pageNum, null);
    }

    public PageParameter(Integer pageNum, Integer pageSize) {
        if (pageNum == null || pageNum < 0)
            pageNum = 1;

        if (pageSize == null)
            pageSize = 10;

        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }
}
