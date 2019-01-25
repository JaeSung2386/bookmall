package com.douzon.bookmall.vo;

public class OrderVo {
	private long no;
	private long memberno;
	private String name;
	private String email;
	private long totalcost;
	private String address;
	private long count;
	
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public long getMemberno() {
		return memberno;
	}
	public void setMemberno(long memberno) {
		this.memberno = memberno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getTotalcost() {
		return totalcost;
	}
	public void setTotalcost(long totalcost) {
		this.totalcost = totalcost;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "OrderVo [no=" + no + ", memberno=" + memberno + ", name=" + name + ", email=" + email + ", totalcost="
				+ totalcost + ", address=" + address + ", count=" + count + "]";
	}
	
	
}
