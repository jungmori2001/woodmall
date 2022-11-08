package com.woodmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.woodmall.dto.MemberVo;
import com.woodmall.util.DBManager;


public class MemberDao {	
	
	// 싱글톤 생성 및 사용
	// 필드
	private static MemberDao instance = new MemberDao();	
	// 생성자
	private MemberDao(){		
	}	
	// 메소드
	public static MemberDao getInstance() {
		return instance;		
	}	
	
	// 로그인(사용자 인증) : select
	// 입력값: 로그인 페이지에서 입력받은 사용자아이디와 암호
	// 반환값: result (1:암호일치), (0:암호불일치), (-1:사용자아이디없음)
	public int checkUser(String userid, String password) {
		int result = -1;	
		Connection conn = null;
//		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		String sql = "select password from Member where userid=?";	
		
		try {
			
			conn = DBManager.getConnection();	
			// (3 단계) Statement 객체 생성
//			stmt = conn.createStatement();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
//			pstmt.setString(2, password);
	
			// (4 단계) SQL문 실행 및 결과 처리 => executeQuery : 조회(select)
//			rs = stmt.executeQuery(sql);
			rs = pstmt.executeQuery();
			// rs.next() : 다음 행(row)을 확인, rs.getString("컬럼명")
			if(rs.next()) {
//				System.out.println(rs.getString("pwd"));	
				// 아이디/ 암호 비교 후 페이지 이동
				if(rs.getString("password")!=null &&
						rs.getString("password").equals(password)) {
					result = 1;		// 암호 일치
				} else {
					result = 0;		// 암호 불일치
				}
			} else {
				result = -1;		// 디비에 userid 없음
			}
		} catch(Exception e) {
				e.printStackTrace();
		} finally {
				DBManager.close(conn, pstmt, rs);
		}
		return result;
	}		
			
			
	

// 회원 가입: DB에 회원 정보를 삽입
//public int insertMember(String name, String id, String pwd, String email, String phone, int admin) {
public int insertMember(MemberVo mVo) {
	int result = -1;
	Connection conn = null;
//	Statement stmt = null;				// 정적 쿼리
	// 동일한 쿼리문을 특정 값만 바꿔서 여러번 실행해야 할때, 매개변수가 많아서 쿼리문 정리 필요
	PreparedStatement pstmt = null;		// 동적 쿼리
	
//	String sql_insert = "insert into member values('"+name+"', '"+id+"', '"+pwd+"', '"+email+"', '"+phone+"', "+admin+")";
	String sql_insert = "insert into Member values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
//	System.out.println(sql_insert);
	
	try {
		conn = DBManager.getConnection();
		
		// (3 단계) Statement 객체 생성
//		stmt = conn.createStatement();
		pstmt = conn.prepareStatement(sql_insert);
//		pstmt.setString(1, name);
//		pstmt.setString(2, id);
//		pstmt.setString(3, pwd);
//		pstmt.setString(4, email);
//		pstmt.setString(5, phone);
//		pstmt.setInt(6, admin);
		
		pstmt.setString(1, mVo.getName());
		pstmt.setString(2, mVo.getUserId());
		pstmt.setString(3, mVo.getPassword());
		pstmt.setString(4, mVo.getEmailId());
		pstmt.setString(5, mVo.getEmailAddress());			// 문자형
		pstmt.setString(6, mVo.getFirstPhone());
		pstmt.setString(7, mVo.getMidPhone());
		pstmt.setString(8, mVo.getLastPhone());
		pstmt.setString(9, mVo.getPostNum());
		pstmt.setString(10, mVo.getMainAddress());
		pstmt.setString(11, mVo.getDetailAddress());
		pstmt.setString(12, mVo.getSubAddress());
		pstmt.setString(13, mVo.getGrade());
		pstmt.setInt(14, mVo.getAdmin());
		pstmt.setInt(15, mVo.getTotalPurchase());
		
		
		// 정수형
//		pstmt.setFloat(int idx, float x);			// 실수형
//		pstmt.setDate(int idx, Date x);				// 날짜형
//		pstmt.setTimestamp(int idx, Timestamp x);	// 시간형
		
		// (4 단계) SQL문 실행 및 결과 처리
		// executeUpdate : 삽입(insert/update/delete)
//		result = stmt.executeUpdate(sql_insert);
		result = pstmt.executeUpdate();				// 쿼리 수행
	} catch(Exception e) {
		e.printStackTrace();			
	} finally {
		DBManager.close(conn, pstmt);
	}
	return result;
}


//전체 회원 정보 가져오기
public List<MemberVo> selectAllMember(){
	String sql="select * from member order by name";
	List<MemberVo> list = new ArrayList<MemberVo>();
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try {
		conn=DBManager.getConnection();
		pstmt=conn.prepareStatement(sql);
		rs=pstmt.executeQuery();
		
		while(rs.next()) {
//			<th>회원 이름</th><th>아이디</th><th>전화번호</th><th>상세</th><th>수정</th><th>삭제</th>
			MemberVo mVo = new MemberVo();
			mVo.setName(rs.getString("name"));
			mVo.setUserId(rs.getString("userid"));
			mVo.setFirstPhone(rs.getString("firstPhone"));
			mVo.setMidPhone(rs.getString("midPhone"));
			mVo.setLastPhone(rs.getString("lastPhone"));
			mVo.setAdmin(rs.getInt("admin"));
			list.add(mVo);
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
// 회원 정보 가져오기 : select
public MemberVo getMember(String userid) {
	String sql = "select * from Member where userid=?";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	MemberVo mVo = null;		
	try {
		conn = DBManager.getConnection();
		
//		// (3 단계) Statement 객체 생성
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userid);
		
//		 (4 단계) SQL문 실행 및 결과 처리 => executeQuery : 조회(select)
		rs = pstmt.executeQuery();
		// rs.next() : 다음 행(row)을 확인, rs.getString("컬럼명")
		while(rs.next()){
			// 디비로부터 회원 정보 획득
			mVo = new MemberVo();
			
			mVo.setName(rs.getString("name")); 						// DB에서 가져온 정보를 mVo객체에 저장				
			mVo.setUserId(rs.getString("userid")); 
			mVo.setPassword(rs.getString("password"));
			mVo.setEmailId("emailId");
			mVo.setEmailAddress(rs.getString("emailAddress"));
			mVo.setFirstPhone("firstPhone");
			mVo.setMidPhone("midPhone");
			mVo.setLastPhone("lastPhone");
			mVo.setPostNum(rs.getString("postNum"));
			mVo.setMainAddress(rs.getString("mainAddress"));
			mVo.setDetailAddress(rs.getString("detailAddress"));
			mVo.setSubAddress(rs.getString("subAddress"));
	
		}
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		DBManager.close(conn, pstmt, rs);
		
	}
	return mVo;
}

//회원 정보 업데이트 : update
	// 입력값: 회원 테이블 정보
	// 반환값: 성공여부
	public int updateMember(MemberVo mVo) {
		int result = -1;		
//		String sql = "update Member set password=?, emailId=?, midPhone=?, lastPhone=? where userid=?";
		String sql = "update Member set password=?, emailId=?, midPhone=?, lastPhone=? where userid=?";
		Connection conn = null;
//		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		System.out.print(1);
		
		try {
			conn = DBManager.getConnection();
			System.out.print(2);
			// (3 단계) Statement 객체 생성
			pstmt = conn.prepareStatement(sql);		// 쿼리 입력
			pstmt.setString(1, mVo.getPassword());
			pstmt.setString(2, mVo.getEmailId());
			pstmt.setString(3, mVo.getMidPhone());
			pstmt.setString(4, mVo.getLastPhone());
			pstmt.setString(5, mVo.getUserId());
			System.out.print(3);
			// (4 단계) SQL문 실행 및 결과 처리 => executeUpdate : 수정(update)
//			rs = stmt.executeQuery(sql);
			result = pstmt.executeUpdate();
			System.out.print(4);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}		
		return result;
	}

	// 아이디를 확인 : select
	// 입력값: 중복 체크하려는 userid
	// 반환값: 체크한 id가 DB에 존재 여부: 존재(1), 존재안함(-1)
public int confirmID(String userid) {
		int result = -1;
		String sql = "select userid from Member where userid=?";
		
		Connection conn = null;
//		Statement stmt =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// (1 단계) JDBC 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");	// Oracle
			// (2 단계) 데이터 베이스 연결 객체 생성 
			String url = "jdbc:oracle:thin:@192.168.0.158:1521:orcl";
			String uid = "ora_user";
			String pass = "1234";
			
			conn = DriverManager.getConnection(url, uid, pass);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			
//			// (4 단계) SQL문 실행 및 결과 처리 => executeQuery : 조회(select)
			rs = pstmt.executeQuery();
			// rs.next() : 다음 행(row)을 확인, rs.getString("컬럼명")
			if(rs.next()){
				// 디비로부터 회원 정보 획득
				result = 1;			// 디비에 userid 있음
			} else {
				result = -1;		// 디비에 userid 없음
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}	
		
		return result;	
		
	}
//멤버 삭제
public void deleteMember(String userId) {
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String sql = "delete from member where userid=?";
	
	try {
		conn = DBManager.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userId);
		
		pstmt.executeUpdate();
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		DBManager.close(conn, pstmt);
	}
}
//어드민 멤버 한명
	public MemberVo selectMemeberByUserId(String userId) {
		String sql= "select * from member where userId=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		MemberVo mVo = null;
		try {
			conn=DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				mVo = new MemberVo();
				mVo.setName(rs.getString("name"));
				mVo.setUserId(rs.getString("userId"));
				mVo.setPassword(rs.getString("password"));
				mVo.setEmailId(rs.getString("emailId"));
				mVo.setEmailAddress(rs.getString("emailAddress"));
				mVo.setFirstPhone(rs.getString("firstPhone"));
				mVo.setMidPhone(rs.getString("midPhone"));
				mVo.setLastPhone(rs.getString("lastPhone"));
				mVo.setPostNum(rs.getString("postNum"));
				mVo.setMainAddress(rs.getString("mainAddress"));
				mVo.setDetailAddress(rs.getString("detailAddress"));
				mVo.setSubAddress(rs.getString("subAddress"));
				mVo.setGrade(rs.getString("grade"));
				mVo.setAdmin(rs.getInt("admin"));
				mVo.setTotalPurchase(rs.getInt("totalPurchase"));
			}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(conn, pstmt, rs);
			}
			return mVo;
		
			}
}