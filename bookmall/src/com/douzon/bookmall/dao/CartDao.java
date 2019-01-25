package com.douzon.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.douzon.bookmall.vo.CartVo;

public class CartDao {
	
	public boolean insert(CartVo cartVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		
		try {
			conn = getConnection();
			
			String sql = 
					"insert " + 
					"	into cart " + 
					"values(null, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, cartVo.getBookno());
			pstmt.setLong(2, cartVo.getMemberno());
			pstmt.setLong(3, cartVo.getCount());
			pstmt.setLong(4, cartVo.getTotalcost());
			
			int count = pstmt.executeUpdate();
			result = count == 1;
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public List<CartVo> getList() {
		List<CartVo> list = new ArrayList<CartVo>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			stmt = conn.createStatement();
			
			String sql = 
					"select c.no, b.title, c.count, c.total_cost " + 
					"from member m, cart c, book b " + 
					"where c.member_no = m.no " + 
					"and b.no = c.book_no;";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				long no = rs.getLong(1);
				String bookname = rs.getString(2);
				long count = rs.getLong(3);
				long totalcost = rs.getLong(4);
				
				
				CartVo vo = new CartVo();
				vo.setNo(no);
				vo.setBookname(bookname);
				vo.setCount(count);
				vo.setTotalcost(totalcost);
				
				list.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("error" + e);
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://127.0.0.1:3306/bookmall";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		}
		
		return conn;
	}
}
