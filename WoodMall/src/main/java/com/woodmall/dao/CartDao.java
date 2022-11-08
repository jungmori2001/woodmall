package com.woodmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.woodmall.dto.CartVo;
import com.woodmall.dto.ProductVo;
import com.woodmall.util.DBManager;

public class CartDao {
	private CartDao() {
	}
	private static CartDao instance = new CartDao();
	public static CartDao getInstance() {
		return instance;
	}
	// 장바구니 DB에 상품 정보 넣기
	public int insertProductToCart(CartVo cVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = -1;
		
		//SQL 문 작성
		String sql_insert = "insert into cart values(?, ?, ?, ?, ?)";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql_insert);
			pstmt.setString(1, cVo.getUserId());
			pstmt.setInt(2, cVo.getProdNum());
			pstmt.setString(3, cVo.getProdName());
			pstmt.setInt(4, cVo.getPrice());
			pstmt.setInt(5, cVo.getQuantity());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}

	// 장바구니DB에서 아이디와 상품코드로 해당 장바구니 정보 출력
		public CartVo selectProductFromCart(String userId, String prodNum) {
			String sql = "select * from cart where prodnum=? and userid=?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			CartVo cVo = new CartVo();
			try {
				conn=DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userId);
				pstmt.setString(2, prodNum);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					
					cVo = new CartVo();
					cVo.setUserId(rs.getString("userId"));
					cVo.setProdNum(rs.getInt("prodNum"));
					cVo.setProdName(rs.getString("prodName"));
					cVo.setPrice(rs.getInt("price"));
					cVo.setQuantity(rs.getInt("quantity"));
					cVo.setImage(rs.getString("image"));
					
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(conn, pstmt, rs);
			}
			return cVo;		
		}
	// 사용자ID로 장바구니 정보 출력
	public List<CartVo> selectProductByUserId(String userId) {
		String sql = "select c.*, p.image "
				+ "from woodmallproduct p ,cart c "
				+ "where p.prodnum=c.prodnum and userid=?";
		List<CartVo> list = new ArrayList<CartVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn=DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CartVo cVo = new CartVo();
				cVo = new CartVo();
				cVo.setUserId(rs.getString("userId"));
				cVo.setProdNum(rs.getInt("prodNum"));
				cVo.setProdName(rs.getString("prodName"));
				cVo.setPrice(rs.getInt("price"));
				cVo.setQuantity(rs.getInt("quantity"));
				cVo.setImage(rs.getString("image"));
				list.add(cVo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;		
	
	}
	// 장바구니 정보 출력
		public CartVo selectCheckProductFromCart(String prodNum, String userId) {
			String sql = "select  c.*, p.image "
					+ "from   woodmallproduct p, cart c "
					+ "where  p.prodNum = c.prodNum "
					+ "and c.prodNum=? "
					+ "and c.userid=?";
			
			CartVo cVo = new CartVo();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				conn=DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, prodNum);
				pstmt.setString(2, userId);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					cVo = new CartVo();
					cVo.setUserId(rs.getString("userId"));
					cVo.setProdNum(rs.getInt("prodNum"));
					cVo.setProdName(rs.getString("prodName"));
					cVo.setPrice(rs.getInt("price"));
					cVo.setQuantity(rs.getInt("quantity"));
					cVo.setImage(rs.getString("image"));
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(conn, pstmt, rs);
			}
			return cVo;	
		}
		
	// 장바구니 총 금액 출력	
	public int selectTotalPriceByUserIdBy(String userId) {
		String sql = "select sum(price) sum from cart where userid=?";
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn=DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);		
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("sum");
			}							
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;		
	}
	// 장바구니 상품 삭제
	public void deleteProductFromCart(String userId, String prodNum) {
		String sql = "delete from cart where userid=? and prodNum=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			// (3 단계) Statement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, prodNum);

			// (4 단계) SQL문 실행 및 결과 처리 => executeQuery : 조회(select)
			pstmt.executeUpdate();
			// rs.next() : 다음 행(row)을 확인, rs.getString("컬럼명")

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("삭제실패");
		} finally {
			DBManager.close(conn, pstmt);
			System.out.println("삭제완료");
		}
	
	}
	// 장바구니 내 체크된 상품 총 금액
	public int selectTotalPriceCheckedProduct(String userId, String prodNum) {
		String sql = "select price from cart where userid=? and prodnum=?";
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn=DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, prodNum);
			
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("price");
			}							
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;		
	
	}
	
	
	
	
}
