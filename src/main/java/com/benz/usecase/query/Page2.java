package com.benz.usecase.query;

import java.util.List;

public class Page2<T> {

	//每页记录数(已知)
	private int pageSize = 10;
	
	//当前条件下总记录数(已知)
	private int totalCount = 0;

	//当前页码(已知)
	private int pageNo = 1;

	//总页数(未知)
	private int totalPage = 1;

	//开始行号(未知)
	private int startNum = 0;

	//结束行号(未知)
	private int endNum = 0;

	//结果集
	private List<T> list;

	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getTotalPage() {
		this.totalPage = totalCount/pageSize;
		if(totalCount == 0 || totalCount%pageSize != 0){
			totalPage++;
		}
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartNum() {
		this.startNum = (pageNo-1)*pageSize + 1;
		return startNum;
	}

	public void setStartNum(int num) {
		this.startNum = num;
	}

	public int getEndNum() {
		this.endNum = pageNo*pageSize;
		return endNum;
	}

	public void setEndNum(int num) {
		this.endNum = num;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public Boolean hasNext(Boolean bool){
		return  bool;
	}
}