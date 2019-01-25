package com.douzon.bookmall.test;

import java.util.List;

import com.douzon.bookmall.dao.OrderBookDao;
import com.douzon.bookmall.vo.OrderBookVo;

public class OrderBookDaoTest {

	public static void main(String[] args) {
//		insertTest(1, 1);
//		insertTest(5, 1);
//		insertTest(11, 2);
//		insertTest(8, 3);
		getListTest();
	}
	public static void insertTest(long bookno, long orderno) {
		OrderBookVo vo = new OrderBookVo();
		
		vo.setBookno(bookno);
		vo.setOrderno(orderno);
		
		new OrderBookDao().insert(vo);
	}
	
	public static void getListTest() {
		List<OrderBookVo> list = new OrderBookDao().getList();
		for(OrderBookVo vo : list) {
			System.out.println(vo);
		}
	}
}
