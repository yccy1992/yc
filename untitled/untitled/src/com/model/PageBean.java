package com.model;

import java.util.List;

public class PageBean<T> {
	//总记录数
	private int totalCount;
	//总页数
	private int totalPage;
	//分页集合
	private List<T> list;
	//当前页是第几页
	private int currentPage;
	//每页记录数
	private int limitPage;
	//当前页开始的位置
	private int start;
	//当前页结束的位置
	private int end;
	//上一页是第几页
	private int prePage;
	//下一页是第几页
	private int nextPage;
	public PageBean(int totalCount,int currentPage,int limitPage) {
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		this.totalPage = (totalCount%limitPage)==0?totalCount/limitPage:(totalCount/limitPage)+1;
		this.limitPage = limitPage;
		this.start = (currentPage-1)*limitPage;//0表示第一条记录
		this.end = currentPage*limitPage>totalCount?totalCount-1:currentPage*limitPage-1;//	-1无问题	
		this.prePage = currentPage-1>0?currentPage-1:1;
		this.nextPage = currentPage+1<totalPage?currentPage+1:totalPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getLimitPage() {
		return limitPage;
	}
	public void setLimitPage(int limitPage) {
		this.limitPage = limitPage;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getPrePage() {
		return prePage;
	}
	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	
	
}
