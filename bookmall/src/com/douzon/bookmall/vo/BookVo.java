package com.douzon.bookmall.vo;

public class BookVo {
	private long no;
	private long categoryno;
	private String title;
	private long cost;
	
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public long getCategoryno() {
		return categoryno;
	}
	public void setCategoryno(long categoryno) {
		this.categoryno = categoryno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public long getCost() {
		return cost;
	}
	public void setCost(long cost) {
		this.cost = cost;
	}
	
	@Override
	public String toString() {
		return "BookVo [no=" + no + ", categoryno=" + categoryno + ", title=" + title + ", cost=" + cost + "]";
	}
	
}
