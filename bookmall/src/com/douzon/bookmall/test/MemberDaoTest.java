package com.douzon.bookmall.test;

import java.util.List;

import com.douzon.bookmall.vo.MemberVo;
import com.douzon.bookmall.dao.MemberDao;

public class MemberDaoTest {
	public static void main(String[] args) {
		insertTest("강재성", "010-7511-2386", "wotjd@naver.com", "1111", "부산시사상구학장동");
		insertTest("강우재", "010-2345-1231", "dnwo@gmail.com", "2222", "부산시사상구엄궁동");
		insertTest("카카오", "010-3435-1556", "zkzkdh@daum.net", "3333", "서울시강서구대림동");
		insertTest("도라에몽", "010-9535-1235", "dpahd@gmail.com", "4444", "부산시중구신림동");
		insertTest("김민정", "010-2324-5135", "alswjd@hanmail.net", "5555", "부산시남구대연동");
		
		
		getListTest();
	}
	
	public static void insertTest(String name, String phonenumber, String email, String password, String address) {
		MemberVo vo = new MemberVo();
		
		vo.setName(name);
		vo.setPhonenumber(phonenumber);
		vo.setEmail(email);
		vo.setPassword(password);
		vo.setAddress(address);
		
		new MemberDao().insert(vo);
	}
	
	public static void getListTest() {
		List<MemberVo> list = new MemberDao().getList();
		for(MemberVo vo : list) {
			System.out.println(vo);
		}
	}
}
