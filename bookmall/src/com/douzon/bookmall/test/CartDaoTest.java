package com.douzon.bookmall.test;

import java.util.List;

import com.douzon.bookmall.dao.CartDao;
import com.douzon.bookmall.vo.CartVo;

public class CartDaoTest {

	public static void main(String[] args) {
		insertTest(1, 1, 4, 12800*4);
		insertTest(5, 1, 1, 36000*1);
		insertTest(11, 2, 2, 28000*2);
		insertTest(8, 3, 5, 16000*5);
		
		getListTest();
	}
	public static void insertTest(long bookno, long memberno, long count, long totalcost) {
		CartVo vo = new CartVo();
		
		vo.setBookno(bookno);
		vo.setMemberno(memberno);
		vo.setCount(count);
		vo.setTotalcost(totalcost);
		
		new CartDao().insert(vo);
	}
	
	public static void getListTest() {
		List<CartVo> list = new CartDao().getList();
		for(CartVo vo : list) {
			System.out.println(vo);
		}
	}
}
