package com.douzon.bookmall.test;

import java.util.List;

import com.douzon.bookmall.dao.BookDao;
import com.douzon.bookmall.vo.BookVo;

public class BookDaoTest {
	public static void main(String[] args) {
		insertTest(1, "고백", 12800);
		insertTest(1, "베일리 어게인", 15600);
		insertTest(2, "수필", 12000);
		insertTest(2, "근원수필", 4900);
		insertTest(3, "이펙티브 자바", 36000);
		insertTest(3, "러닝 자바스크립트", 25000);
		insertTest(4, "나의 이탈리아 인문 기행", 18000);
		insertTest(4, "미술관에 간 인문학자", 16000);
		insertTest(5, "경제 트렌드 2019", 16000);
		insertTest(5, "경제 읽어주는 남자", 15300);
		insertTest(6, "20세기 사진 예술", 28000);
		insertTest(6, "스페인 예술로 걷다", 16000);
		
		getListTest();
	}
	
	public static void insertTest(long categoryno, String title, long cost) {
		BookVo vo = new BookVo();
		vo.setCategoryno(categoryno);
		vo.setTitle(title);
		vo.setCost(cost);
		
		new BookDao().insert(vo);
	}
	
	public static void getListTest() {
		List<BookVo> list = new BookDao().getList();
		for(BookVo vo : list) {
			System.out.println(vo);
		}
	}
}
