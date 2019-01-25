package com.douzon.bookmall.vo;

public class CartVo {
	private long no;
	private long bookno;
	private long memberno;
	private long count;
	private long totalcost;
	private String bookname;
	
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public long getBookno() {
		return bookno;
	}
	public void setBookno(long bookno) {
		this.bookno = bookno;
	}
	public long getMemberno() {
		return memberno;
	}
	public void setMemberno(long memberno) {
		this.memberno = memberno;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public long getTotalcost() {
		return totalcost;
	}
	public void setTotalcost(long totalcost) {
		this.totalcost = totalcost;
	}
	@Override
	public String toString() {
		return "CartVo [no=" + no + ", bookno=" + bookno + ", memberno=" + memberno + ", count=" + count
				+ ", totalcost=" + totalcost + ", bookname=" + bookname + "]";
	}
	
	
	
	
}
