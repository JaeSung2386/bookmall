package com.douzon.bookmall.vo;

public class OrderBookVo {
	private long bookno;
	private long orderno;
	private String title;
	private long count;
	
	public long getBookno() {
		return bookno;
	}
	public void setBookno(long bookno) {
		this.bookno = bookno;
	}
	public long getOrderno() {
		return orderno;
	}
	public void setOrderno(long orderno) {
		this.orderno = orderno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}	
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "OrderBookVo [bookno=" + bookno + ", orderno=" + orderno + "]";
	}

}
