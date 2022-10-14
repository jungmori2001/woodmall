package com.woodmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.woodmall.dto.OrderVo;
import com.woodmall.dto.ProductVo;
import com.woodmall.util.DBManager;

public class OrderDao {
	private OrderDao() {
	}
	
	private static OrderDao instance = new OrderDao();
	
	public static OrderDao getInstance() {
		return instance;
	}
	
	//전체 주문 조회
	public List<OrderVo> selectAllOrder(){
		String sql = "select * from ordermanager order by ordernum desc";
		List<OrderVo> list = new ArrayList<OrderVo>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				OrderVo oVo = new OrderVo();
				oVo.setOrderNum(rs.getInt("orderNum"));
				oVo.setName(rs.getString("name"));
				oVo.setOrderQuen(rs.getInt("orderQuen"));
				oVo.setPaymentStatus(rs.getString("paymentStatus"));
				oVo.setPrice(rs.getInt("price"));
				oVo.setOrderDate(rs.getDate("orderDate"));
				oVo.setOrderContent(rs.getString("orderContent"));
				oVo.setOrderStatus(rs.getString("orderStatus"));
				
				list.add(oVo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return list;
	}
	//주문 상세 확인 (orderNum)
	public OrderVo selectOrderByOrderNum(String orderNum) {
		String sql = "select * from ordermanager where ordernum=?"; 
//				"select o.* from ordermanager o right join member m On o.name = m.name where ordernum=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		OrderVo oVo = null;
		ProductVo pVo = null;
//		memberVo mVo = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, orderNum);
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				oVo=new OrderVo();
//				mVo=new MemberVo();
				
				oVo.setOrderNum(rs.getInt("orderNum"));
//				pVo.setProdName(rs.getString("prodName"));
				oVo.setOrderQuen(rs.getInt("orderQuen"));
//				받는사람
//				전화번호
//				배송지 상세 주소
//				이메일
//				전화번호
				oVo.setOrderContent(rs.getString("orderContent"));
				oVo.setPaymentStatus(rs.getString("paymentStatus"));
				oVo.setName(rs.getString("name"));
				oVo.setOrderStatus(rs.getString("orderStatus"));
			}
	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return oVo;
		
	}
	













}
