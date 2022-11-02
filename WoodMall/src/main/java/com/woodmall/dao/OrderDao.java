package com.woodmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.woodmall.dto.MemberVo;
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
				oVo.setOrderQuan(rs.getInt("orderQuan"));
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
	
	public List<OrderVo> selectAllOrderById(String userId){
		String sql = "select * from ordermanager where userId=?";
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
				oVo.setOrderQuan(rs.getInt("orderQuan"));
				oVo.setPaymentStatus(rs.getString("paymentStatus"));
				oVo.setPrice(rs.getInt("price"));
				oVo.setOrderDate(rs.getDate("orderDate"));
				oVo.setOrderContent(rs.getString("orderContent"));
				oVo.setOrderStatus(rs.getString("orderStatus"));
				
				list.add(oVo);
				
			}
			System.out.println(list);
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
	public OrderVo changeStatusByOrderNum(String orderNum) {
		String sql ="select * from ordermanager  where ordernum=?";
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
				oVo.setProdNum(rs.getInt("prodNum"));
				oVo.setUserId(rs.getString("userId"));
				oVo.setOrderQuan(rs.getInt("orderQuan"));
				oVo.setPaymentStatus(rs.getString("paymentStatus"));
				oVo.setPrice(rs.getInt("price"));
				oVo.setOrderDate(rs.getDate("orderDate"));
				oVo.setOrderContent(rs.getString("orderContent"));
				oVo.setOrderStatus(rs.getString("orderStatus"));
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("상세보기 오류");
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


	public int insertProductInOrder(OrderVo oVo) {
		int result = -1;
		Connection conn = null;

		// 동일한 쿼리문을 특정 값만 바꿔서 여러번 실행해야 할때, 매개변수가 많아서 쿼리문 정리 필요
		PreparedStatement pstmt = null;		// 동적 쿼리
		
//		String sql_insert = "insert into member values('"+name+"', '"+id+"', '"+pwd+"', '"+email+"', '"+phone+"', "+admin+")";
		String sql_insert = "insert into ordermanager(orderNum, prodnum, userid, paymentstatus, price, quantity)  values(ordermanager_seq.nextval,?,?,?,?,?)";
		
		try {
			conn = DBManager.getConnection();
			
			// (3 단계) Statement 객체 생성
//		
			pstmt = conn.prepareStatement(sql_insert);

			pstmt.setInt(1, oVo.getProdNum());
			pstmt.setString(2, oVo.getUserId());
			pstmt.setString(3, oVo.getPaymentStatus());
			pstmt.setInt(4, oVo.getPrice());
			pstmt.setInt(5, oVo.getOrderQuan());
			result = pstmt.executeUpdate();				// 쿼리 수행
		} catch(Exception e) {
			e.printStackTrace();			
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}










}
