package com.woodmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.woodmall.dto.NoticeVo;
import com.woodmall.util.DBManager;

public class NoticeDao {
	private NoticeDao() {
	}
	
	private static NoticeDao instance = new NoticeDao();
	
	public static NoticeDao getInstance() {
		return instance;
	}
	
	//전체 공지 조회
	public List<NoticeVo> selectAllNotice(){
		String sql ="select * from woodmallnotice order by noticenum desc";
//				"select woodmallnotice.*, member.name from member left join woodmallnotice On woodmallnotice.name = member.name order by noticenum desc"; 
//				"select woodmallnotice.*, member.* from member left join woodmallnotice On woodmallnotice.name = member.name order by noticenum desc";
		
		List<NoticeVo> list = new ArrayList<NoticeVo>();  //List 컬렉션 객체 생성
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
				NoticeVo nVo = new NoticeVo();
				
				nVo.setNoticeNum(rs.getInt("noticeNum"));
				nVo.setUserId(rs.getString("userId"));
				nVo.setName(rs.getString("name"));
				nVo.setNoticeTitle(rs.getString("noticeTitle"));
				nVo.setNoticeContent(rs.getString("noticeContent"));
				nVo.setNoticeHits(rs.getInt("noticeHits"));
				
				list.add(nVo);
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
	//공지 쓰기
	public int insertNotice(NoticeVo nVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = -1;
		
		String sql_insert = "insert into woodmallnotice(noticenum, userid, name, noticetitle, noticecontent) values(woodmallnotice_seq.nextval,?, ?, ?, ?)";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql_insert);
			
//			pstmt.setInt(1, nVo.getNoticeNum());
			pstmt.setString(1, nVo.getUserId());
			pstmt.setString(2, nVo.getName());
			pstmt.setString(3, nVo.getNoticeTitle());
			pstmt.setString(4, nVo.getNoticeContent());
			result = pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);

		}
		return result;
	}
	//공지 하나 확인하기(noticeNum)
	public NoticeVo selectNoticeByNoticeNum(String noticeNum) {
		String sql = "select * from woodmallnotice where noticenum=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		NoticeVo nVo = null;
		try {
			conn=DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, noticeNum);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				nVo = new NoticeVo();
				nVo.setNoticeNum(rs.getInt("noticeNum"));
				nVo.setName(rs.getString("name"));
				nVo.setNoticeTitle(rs.getString("noticeTitle"));
				nVo.setNoticeContent(rs.getString("noticeContent"));
				nVo.setNoticeHits(rs.getInt("noticeHits"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return nVo;
	}
	//공지 수정
	public int updateNotice(NoticeVo nVo) {
		int result = -1;
		Connection conn=null;
		PreparedStatement pstmt = null;
		
		String sql = "update woodmallnotice set noticeTitle=?, noticeContent=? where noticeNum=?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nVo.getNoticeTitle());
			pstmt.setString(2, nVo.getNoticeContent());
//			pstmt.setInt(3, nVo.getNoticeHits());
			pstmt.setInt(3, nVo.getNoticeNum());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("오류"+ pstmt);
		}finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	//공지 삭제
	public NoticeVo deleteNotice(String noticeNum) {
		String sql = "delete from woodmallnotice where noticeNum=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		NoticeVo nVo = null;
		
		try {
			conn=DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, noticeNum);
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				nVo= new NoticeVo();
				nVo.setNoticeNum(rs.getInt("noticeNum"));
				nVo.setName(rs.getString("name"));
				nVo.setNoticeTitle(rs.getString("noticeTitle"));
				nVo.setNoticeContent(rs.getString("noticeContent"));
				nVo.setNoticeHits(rs.getInt("noticeHits"));
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("삭제실패");
		}finally {
			DBManager.close(conn, pstmt, rs);
			System.out.println("삭제완료");
		}
		return nVo;
	}

}
