package com.douzon.bookmall.main;

import java.util.List;

import com.douzon.bookmall.dao.BookDao;
import com.douzon.bookmall.dao.CartDao;
import com.douzon.bookmall.dao.CategoryDao;
import com.douzon.bookmall.dao.MemberDao;
import com.douzon.bookmall.dao.OrderBookDao;
import com.douzon.bookmall.dao.OrderDao;
import com.douzon.bookmall.test.BookDaoTest;
import com.douzon.bookmall.test.CartDaoTest;
import com.douzon.bookmall.test.CategoryDaoTest;
import com.douzon.bookmall.test.MemberDaoTest;
import com.douzon.bookmall.test.OrderBookDaoTest;
import com.douzon.bookmall.test.OrderDaoTest;
import com.douzon.bookmall.vo.BookVo;
import com.douzon.bookmall.vo.CartVo;
import com.douzon.bookmall.vo.CategoryVo;
import com.douzon.bookmall.vo.MemberVo;
import com.douzon.bookmall.vo.OrderBookVo;
import com.douzon.bookmall.vo.OrderVo;

public class BookMall {

	public static void main(String[] args) {
		System.out.println("====================회원====================");
		MemberDaoTest.insertTest("강재성", "010-7511-2386", "wotjd@naver.com", "1111", "부산시사상구학장동");
		MemberDaoTest.insertTest("강우재", "010-2345-1231", "dnwo@gmail.com", "2222", "부산시사상구엄궁동");
		MemberDaoTest.insertTest("카카오", "010-3435-1556", "zkzkdh@daum.net", "3333", "서울시강서구대림동");
		MemberDaoTest.insertTest("도라에몽", "010-9535-1235", "dpahd@gmail.com", "4444", "부산시중구신림동");
		MemberDaoTest.insertTest("김민정", "010-2324-5135", "alswjd@hanmail.net", "5555", "부산시남구대연동");
		
		List<MemberVo> memberVo = new MemberDao().getList();
		for(MemberVo vo : memberVo) {
			String passwd = new String();
			for(int i = 0; i < vo.getPassword().length(); i++) {
				passwd += "*";
			}
				
			System.out.println(
					vo.getNo() + ". " + 
					vo.getName() + ", " + 
					vo.getEmail() + ", " + 
					vo.getPhonenumber() + ", " + 
					passwd);
		}
		
		System.out.println("\n====================카테고리====================");
		CategoryDaoTest.insertTest("소설");
		CategoryDaoTest.insertTest("수필");
		CategoryDaoTest.insertTest("컴퓨터/IT");
		CategoryDaoTest.insertTest("인문");
		CategoryDaoTest.insertTest("경제");
		CategoryDaoTest.insertTest("예술");
		
		List<CategoryVo> categoryVo = new CategoryDao().getList();
		for(CategoryVo vo : categoryVo) {
			System.out.println(vo.getNo() + ". " + vo.getName());
		}
		
		System.out.println("\n====================도서====================");
		BookDaoTest.insertTest(1, "고백", 12800);
		BookDaoTest.insertTest(1, "베일리 어게인", 15600);
		BookDaoTest.insertTest(2, "수필", 12000);
		BookDaoTest.insertTest(2, "근원수필", 4900);
		BookDaoTest.insertTest(3, "이펙티브 자바", 36000);
		BookDaoTest.insertTest(3, "러닝 자바스크립트", 25000);
		BookDaoTest.insertTest(4, "나의 이탈리아 인문 기행", 18000);
		BookDaoTest.insertTest(4, "미술관에 간 인문학자", 16000);
		BookDaoTest.insertTest(5, "경제 트렌드 2019", 16000);
		BookDaoTest.insertTest(5, "경제 읽어주는 남자", 15300);
		BookDaoTest.insertTest(6, "20세기 사진 예술", 28000);
		BookDaoTest.insertTest(6, "스페인 예술로 걷다", 16000);
		
		List<BookVo> bookVo = new BookDao().getList();
		for(BookVo vo : bookVo) {
			System.out.println(
					vo.getNo() + ". " + 
					vo.getTitle() + ", " + 
					vo.getCost());
		}
		
		System.out.println("\n====================카트(장바구니)====================");
		CartDaoTest.insertTest(1, 1, 4, 12800*4);
		CartDaoTest.insertTest(5, 1, 1, 36000*1);
		CartDaoTest.insertTest(11, 2, 2, 28000*2);
		CartDaoTest.insertTest(8, 3, 5, 16000*5);
		
		List<CartVo> cartVo = new CartDao().getList();
		for(CartVo vo : cartVo) {
			System.out.println(
					vo.getNo() + ". " +
					vo.getBookname() + ", " +
					vo.getCount() +  ", " +
					vo.getTotalcost());
		}
		
		System.out.println("\n====================주문 리스트====================");
		OrderDaoTest.insertTest(1, 12800*4, 4);
		OrderDaoTest.insertTest(2, 28000*2, 1);
		OrderDaoTest.insertTest(3, 16000*5, 5);
		
		List<OrderVo> orderVo = new OrderDao().getList();
		for(OrderVo vo : orderVo) {
			System.out.println(
					vo.getNo() + ". " +
					vo.getName() + "/" +
					vo.getEmail() + ", " +
					vo.getTotalcost() + ", " +
					vo.getAddress());
		}
		
		System.out.println("\n====================주문 도서 리스트====================");		
		OrderBookDaoTest.insertTest(1, 1);
		OrderBookDaoTest.insertTest(5, 1);
		OrderBookDaoTest.insertTest(11, 2);
		OrderBookDaoTest.insertTest(8, 3);
		
		List<OrderBookVo> orderBookVo = new OrderBookDao().getList();
		for(OrderBookVo vo : orderBookVo) {
			System.out.println(
					vo.getBookno() + ". " + 
					vo.getTitle() +	", " + 
					vo.getCount());
		}
	}
}
