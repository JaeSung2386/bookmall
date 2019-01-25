package com.douzon.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.douzon.bookmall.vo.OrderBookVo;

public class OrderBookDao {
	public boolean insert(OrderBookVo orderBookVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		
		try {
			conn = getConnection();
			
			String sql = 
					"insert into " + 
					" order_book  " + 
					" values(?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, orderBookVo.getBookno());
			pstmt.setLong(2, orderBookVo.getOrderno());
			
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
	
	public List<OrderBookVo> getList() {
		List<OrderBookVo> list = new ArrayList<OrderBookVo>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			stmt = conn.createStatement();
			
			String sql = 
					"select ob.book_no, b.title, o.count " + 
					"from book b, order_book ob, orderdetail o " + 
					"where b.no = ob.book_no " + 
					"and o.no = ob.order_no " +
					"order by ob.book_no";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				long bookno = rs.getLong(1);
				String title = rs.getString(2);
				long count = rs.getLong(3);
				
				OrderBookVo vo = new OrderBookVo();
				vo.setBookno(bookno);
				vo.setTitle(title);
				vo.setCount(count);
				
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
