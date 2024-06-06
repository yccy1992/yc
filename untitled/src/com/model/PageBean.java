package com.model;

import java.util.List;

public class PageBean<T> {
	//�ܼ�¼��
	private int totalCount;
	//��ҳ��
	private int totalPage;
	//��ҳ����
	private List<T> list;
	//��ǰҳ�ǵڼ�ҳ
	private int currentPage;
	//ÿҳ��¼��
	private int limitPage;
	//��ǰҳ��ʼ��λ��
	private int start;
	//��ǰҳ������λ��
	private int end;
	//��һҳ�ǵڼ�ҳ
	private int prePage;
	//��һҳ�ǵڼ�ҳ
	private int nextPage;
	public PageBean(int totalCount,int currentPage,int limitPage) {
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		this.totalPage = (totalCount%limitPage)==0?totalCount/limitPage:(totalCount/limitPage)+1;
		this.limitPage = limitPage;
		this.start = (currentPage-1)*limitPage;//0��ʾ��һ����¼
		this.end = currentPage*limitPage>totalCount?totalCount-1:currentPage*limitPage-1;//	-1������	
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
