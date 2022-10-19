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
	
	// 장바구니에 넣기
	public int insertProductToCart(CartVo cVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = -1;
		
		String sql_insert = "insert into cart values(?, ?, ?, ?, ?);";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql_insert);
			
//			pstmt.setInt(1, nVo.getNoticeNum());
			pstmt.setString(1, cVo.getUserId());
			pstmt.setInt(2, cVo.getProdNum());
			pstmt.setString(3, cVo.getProdName());
			pstmt.setInt(4, cVo.getPrice());
			pstmt.setString(5, cVo.getQuantity());
			
			result = pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);

		}
		return result;
	}
	
	
	
	// 장바구니 정보 출력
	public List<CartVo> selectProductByUserId(String userId) {
		String sql = "select * from cart order by userid=?";
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
				cVo.setQuantity(rs.getString("quantity"));
				list.add(cVo);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;		
	
	}
	
	public CartVo deleteProductFromCart(String userId, int prodNum) {
		String sql = "delete from cart where userid=?, prodNum=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CartVo cVo = null;
		try {
			conn = DBManager.getConnection();
			// (3 단계) Statement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setInt(2, prodNum);

			// (4 단계) SQL문 실행 및 결과 처리 => executeQuery : 조회(select)
			rs = pstmt.executeQuery();
			// rs.next() : 다음 행(row)을 확인, rs.getString("컬럼명")
			while (rs.next()) {
				// rs.getInt("컬럼명");
				cVo = new CartVo();
				cVo.setUserId(rs.getString("userId"));
				cVo.setProdNum(rs.getInt("prodNum"));
				cVo.setProdName(rs.getString("prodName"));
				cVo.setPrice(rs.getInt("price"));
				cVo.setQuantity(rs.getString("quantity"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("삭제실패");
		} finally {
			DBManager.close(conn, pstmt, rs);
			System.out.println("삭제완료");
		}
		return cVo;
	}
	
	
	
}
