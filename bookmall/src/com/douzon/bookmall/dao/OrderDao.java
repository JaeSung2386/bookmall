package com.douzon.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.douzon.bookmall.vo.OrderVo;

public class OrderDao {
	public boolean insert(OrderVo orderVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		
		try {
			conn = getConnection();
			
			String sql = 
					"insert into " + 
					" orderdetail  " + 
					" values(null, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, orderVo.getMemberno());
			pstmt.setLong(2, orderVo.getTotalcost());
			pstmt.setLong(3, orderVo.getCount());
			
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
	
	public List<OrderVo> getList() {
		List<OrderVo> list = new ArrayList<OrderVo>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			stmt = conn.createStatement();
			
			String sql = 
					"select o.no, m.name, m.email, o.total_cost, m.address " + 
					"from member m, orderdetail o " + 
					"where m.no = o.member_no";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				long no = rs.getLong(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				long totalcost = rs.getLong(4);
				String address = rs.getString(5);
				
				OrderVo vo = new OrderVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setEmail(email);
				vo.setTotalcost(totalcost);
				vo.setAddress(address);
				
				
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
