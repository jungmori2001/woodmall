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
		String sql = "select woodmallnotice.*, member.* from member left join woodmallnotice On woodmallnotice.name = member.name order by noticenum desc";
		
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
				nVo.setNoticeNum(rs.getInt("noticenum"));
				nVo.setName(rs.getString("name"));
				nVo.setNoticeTitle(rs.getString("noticetitle"));
				nVo.setNoticeContent(rs.getString("noticecontent"));
				nVo.setNoticeHits(rs.getInt("noticehits"));
				
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
}
