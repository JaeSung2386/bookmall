package com.douzon.bookmall.test;

import java.util.List;

import com.douzon.bookmall.dao.OrderDao;
import com.douzon.bookmall.vo.OrderVo;

public class OrderDaoTest {
	public static void main(String[] args) {
//		insertTest(1, "강재성", "wotjd@naver.com", 12800*4, "부산시사상구학장동", 4);
//		insertTest(2, "강우재", "dnwo@naver.com", 28000*2, "부산시사상구엄궁동", 1);
//		insertTest(3, "카카오", "zkzkdh@naver.com", 16000*5, "서울시강서구대림동", 5);
		getListTest();
	}
	public static void insertTest(
			long memberno, long totalcost, long count) {
		OrderVo vo = new OrderVo();
		
		vo.setMemberno(memberno);
		vo.setTotalcost(totalcost);
		vo.setCount(count);
		
		new OrderDao().insert(vo);
	}
	
	public static void getListTest() {
		List<OrderVo> list = new OrderDao().getList();
		for(OrderVo vo : list) {
			System.out.println(vo);
		}
	}
}
