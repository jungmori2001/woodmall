package com.woodmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.woodmall.dto.ProductVo;
import com.woodmall.util.DBManager;

public class ProductDao {
	private ProductDao() {
	}
	
	private static ProductDao instance = new ProductDao();
	
	public static ProductDao getInstance() {
		return instance;
	}
	
	//전체 상품 조회
	public List<ProductVo> selectAllProduct(){
		String sql = "select * from woodmallproduct order by prodnum desc";
		List<ProductVo> list = new ArrayList<ProductVo>(); //list 컬렉션 개체 생성
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			//Statement  객체 생성
			pstmt = conn.prepareStatement(sql);
			//SQL문 실행 및 결과처리 excuteQuery : 조회(select)
			rs = pstmt.executeQuery();
			//rs.next() : 다음 행(row) 확인, rs.getString("컬럼명")
			while(rs.next()) {
				ProductVo pVo = new ProductVo();
				pVo.setProdnum(rs.getInt("prodnum"));
				pVo.setKind(rs.getString("kind"));
				pVo.setImage(rs.getString("image"));
				pVo.setProdname(rs.getString("prodname"));
				pVo.setPrice(rs.getInt("price"));
				pVo.setReg_date(rs.getDate("reg_date"));
				list.add(pVo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//사용한 리소스 해제
				rs.close();
				pstmt.close();
				conn.close();
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return list;
		
	}
	
	
}
