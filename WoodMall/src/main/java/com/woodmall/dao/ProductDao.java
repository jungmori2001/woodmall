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
	// 상품등록
	// 입력값 : 전체 상품 정보
	// 반환값 : 쿼리 수행 결과

	public int insertProduct(ProductVo pVo) {
		Connection conn = null;
		// 동일한 쿼리문을 특정 값만 바꿔서 여러번 실행해야 할때, 매개변수가 많아서 쿼리문 정리필요
		PreparedStatement pstmt = null;	// 동적 쿼리
		int result = -1;
		
		String sql_insert = "insert into woodmallproduct values(?, ?, ?, ?, ?, ?, ?)";		// ? : 변화가 가능한 변수

		
		try {
			conn = DBManager.getConnection();

			// (3단계) Statement 객체 생성
			pstmt = conn.prepareStatement(sql_insert);
			
			pstmt.setInt(1, pVo.getProdNum());
			pstmt.setString(2, pVo.getKind());
			pstmt.setString(3, pVo.getImage());
			pstmt.setString(4, pVo.getProdName());
			pstmt.setInt(5, pVo.getPrice());					// 정수형
			pstmt.setString(6, pVo.getContent());			// 문자형
			pstmt.setDate(7, pVo.getReg_date());				// 날짜형

			// (4단계) SQL문 실행 및 결과 처리
			//	executeUpdate : 삽입(insert/update/delete)
			result = pstmt.executeUpdate();		// 쿼리 수행
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return result;
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
			System.out.println("statement 객체 생성");
			//SQL문 실행 및 결과처리 excuteQuery : 조회(select)
			rs = pstmt.executeQuery();
			//rs.next() : 다음 행(row) 확인, rs.getString("컬럼명")
			while(rs.next()) {
				ProductVo pVo = new ProductVo();
				pVo.setProdNum(rs.getInt("prodNum"));
				pVo.setKind(rs.getString("kind"));
				pVo.setImage(rs.getString("image"));
				pVo.setProdName(rs.getString("prodName"));
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
	
	//카테고리별 
	public List<ProductVo> selectAllProductByKind(String kind){
		String sql = "select * from woodmallproduct where kind="+kind;
		List<ProductVo> list = new ArrayList<ProductVo>(); //list 컬렉션 개체 생성
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			//Statement  객체 생성
			pstmt = conn.prepareStatement(sql);
			System.out.println("statement 객체 생성");
			//SQL문 실행 및 결과처리 excuteQuery : 조회(select)
			rs = pstmt.executeQuery();
			//rs.next() : 다음 행(row) 확인, rs.getString("컬럼명")
			while(rs.next()) {
				ProductVo pVo = new ProductVo();
				pVo.setProdNum(rs.getInt("prodNum"));
				pVo.setKind(rs.getString("kind"));
				pVo.setImage(rs.getString("image"));
				pVo.setProdName(rs.getString("prodName"));
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
	
	
	//단일 상품 조회
	public ProductVo selectProductByCode(String prodnum) {
		String sql = "select * from woodmallproduct where prodnum=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductVo pVo = null;
		try {
			conn = DBManager.getConnection();
			// (3 단계) Statement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, prodnum);
			
			// (4 단계) SQL문 실행 및 결과 처리 => executeQuery : 조회(select)
			rs = pstmt.executeQuery();
			// rs.next() : 다음 행(row)을 확인, rs.getString("컬럼명")
			while(rs.next()){
				//rs.getInt("컬럼명");
				pVo = new ProductVo();
				pVo.setProdNum(rs.getInt("prodnum"));// 컬럼명 code인 정보를 가져옴
				pVo.setProdName(rs.getString("prodname"));// DB에서 가져온 정보를 pVo객체에 저장
				pVo.setPrice(rs.getInt("price"));
				pVo.setImage(rs.getString("image"));
				pVo.setContent(rs.getString("content"));
				pVo.setReg_date(rs.getDate("reg_date"));
			}

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return pVo;
	}
	//상품 수정
	public int updateProduct(ProductVo pVo) {
		int result = -1;
		Connection conn = null;
		//동일한 쿼리문을 특정 값만 바꿔서 여러번 실행해야 할때, 매개변수가 많아서 쿼리문 정리필요
		PreparedStatement pstmt = null; //동적 쿼리
		
		String sql="update woodmallproduct set prodname=?, price=?, image=?, content=?, reg_date=? where prodnum=?";
		System.out.println(pVo);
		try {
			conn = DBManager.getConnection();
			//Statement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pVo.getProdName());
			pstmt.setInt(2, pVo.getPrice());
			pstmt.setString(3, pVo.getImage());
			pstmt.setString(4, pVo.getContent());
			pstmt.setDate(5, pVo.getReg_date());
			pstmt.setInt(6, pVo.getProdNum());
			
			//SQL문 실행 및 결과 처리
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	//상품 삭제
	public ProductVo deleteProduct(String prodnum) {
		String sql = "delete from woodmallproduct where prodnum=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductVo pVo = null;
		try {
			conn = DBManager.getConnection();
			// (3 단계) Statement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, prodnum);
			
			// (4 단계) SQL문 실행 및 결과 처리 => executeQuery : 조회(select)
			rs = pstmt.executeQuery();
			// rs.next() : 다음 행(row)을 확인, rs.getString("컬럼명")
			while(rs.next()){
				//rs.getInt("컬럼명");
				pVo = new ProductVo();
				pVo.setProdNum(rs.getInt("prodnum"));// 컬럼명 code인 정보를 가져옴
				pVo.setProdName(rs.getString("prodname"));// DB에서 가져온 정보를 pVo객체에 저장
				pVo.setPrice(rs.getInt("price"));
				pVo.setImage(rs.getString("image"));
				pVo.setContent(rs.getString("content"));
				pVo.setReg_date(rs.getDate("reg_date"));
			}

		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("삭제실패");
		} finally {
			DBManager.close(conn, pstmt, rs);
			System.out.println("삭제완료");
		}
		return pVo;
	}
	
}
