package com.woodmall.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woodmall.dao.MemberDao;
import com.woodmall.dto.MemberVo;
import com.woodmall.util.DBManager;


@WebServlet("/adminUpdateMember.do")
public class adminUpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		System.out.println("userId: "+ userId);
		
//		MemberDao mDao = new MemberDao();			// 데이터베이스 연동
		MemberDao mDao = MemberDao.getInstance();	// 데이터 베이스 연동
		MemberVo mVo = mDao.selectMemeberByUserId(userId);		// 데이터베이스로부터 회원정보 로딩
		
//		request.setAttribute("name", mVo.getName());
		request.setAttribute("member", mVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/updateMember.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; chaset=UTF-8");
		
		MemberDao mDao = MemberDao.getInstance();
		MemberVo mVo = new MemberVo();
		
		int result = -1;
		
		try {
			System.out.println(mVo);
			String password = request.getParameter("password");
			String emailId = request.getParameter("emailId");
			String midPhone = request.getParameter("midPhone");
			String LastPhone = request.getParameter("lastPhone");
			String userId = request.getParameter("userId");
			
			mVo.setPassword(password);
			mVo.setEmailId(emailId);
			mVo.setMidPhone(midPhone);
			mVo.setLastPhone(LastPhone);
			mVo.setUserId(userId);
			
			System.out.println(mVo);
		}catch(Exception e) {
			System.out.println("글쓰는데 예외 발생:" + e);
			System.out.println(mVo);
		}
		
		result = mDao.updateMember(mVo);
		if(result==1) {
			System.out.println("공지사항 수정 성공");
			request.setAttribute("message", "멤버 수정 성공!");
		}else {
			System.out.println("공지사항 수정 실패");
			request.setAttribute("message", "멤버 수정 실패!");
		}
		response.sendRedirect("memberList.do");

		
	}

	
	
}
