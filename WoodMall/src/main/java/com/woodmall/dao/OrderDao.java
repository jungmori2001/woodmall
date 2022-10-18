package com.woodmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.woodmall.dto.OrderDetailVo;
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
		String sql = "select o.* , m.name\r\n"
				+ "from ordermanager o, member m \r\n"
				+ "where o.userid = m.userid\r\n"
				+ "order by ordernum desc";
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
	//ordermanager만 부분 조회
	public OrderVo selectOrderByOrderNum1(String orderNum) {
		String sql ="select * from ordermanager where ordernum=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		OrderVo oVo = null;	
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, orderNum);
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				oVo=new OrderVo();
				oVo.setOrderNum(rs.getInt("orderNum"));
				oVo.setUserId(rs.getString("userId"));
				oVo.setOrderQuen(rs.getInt("orderQuen"));
				oVo.setOrderContent(rs.getString("orderContent"));
				oVo.setPaymentStatus(rs.getString("paymentStatus"));
				oVo.setOrderStatus(rs.getString("orderStatus"));
				oVo.setPrice(rs.getInt("price"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return oVo;
	}
	//주문 상세 확인 (orderNum)
	public OrderDetailVo selectOrderByOrderNum(String orderNum) {
		String sql = "select o.*, p.prodname,m.name, m.emailid, m.emailaddress, m.firstphone, m.midphone, m.lastphone, m.postnum, m.mainaddress, m.detailaddress, m.subaddress\r\n"
				+ "from ordermanager o, woodmallproduct p, member m\r\n"
				+ "where o.userid = m.userid\r\n"
				+ "and o.prodnum = p.prodnum\r\n"
				+ "and o.ordernum=?"; 
//				"select o.* from ordermanager o right join member m On o.name = m.name where ordernum=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		OrderDetailVo oDVo = null;
		ProductVo pVo = null;
//		memberVo mVo = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, orderNum);
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				oDVo=new OrderDetailVo();
				
				oDVo.setOrderNum(rs.getInt("orderNum"));
				oDVo.setProdName(rs.getString("prodName"));
				oDVo.setUserId(rs.getString("userId"));
				oDVo.setOrderQuen(rs.getInt("orderQuen"));
				oDVo.setFirstPhone(rs.getString("firstPhone"));
				oDVo.setMidPhone(rs.getString("midPhone"));
				oDVo.setLastPhone(rs.getString("lastPhone"));
				oDVo.setMainAddress(rs.getString("mainAddress"));
				oDVo.setDetailAddress(rs.getString("detailAddress"));
				oDVo.setSubAddress(rs.getString("subAddress"));
				oDVo.setEmailId(rs.getString("emailId"));
				oDVo.setEmailAddress(rs.getString("emailAddress"));
				oDVo.setOrderContent(rs.getString("orderContent"));
				oDVo.setPaymentStatus(rs.getString("paymentStatus"));
				oDVo.setName(rs.getString("name"));
				oDVo.setOrderStatus(rs.getString("orderStatus"));
				oDVo.setPrice(rs.getInt("price"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return oDVo;
		
	}
	//수정
	public int updateOrder(OrderVo oVo) {
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update ordermanager set orderstatus=? where ordernum=?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, oVo.getOrderStatus());
			pstmt.setInt(2, oVo.getOrderNum());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("오류발생: " +pstmt);
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}













}
