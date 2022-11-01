package com.woodmall.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woodmall.dao.MemberDao;
import com.woodmall.dto.MemberVo;


@WebServlet("/updateMember.do")
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String userId = request.getParameter("userId");
		System.out.println("userId: "+ userId);
		
//		MemberDao mDao = new MemberDao();			// 데이터베이스 연동
		MemberDao mDao = MemberDao.getInstance();	// 데이터 베이스 연동
		MemberVo mVo = mDao.getMember(userId);		// 데이터베이스로부터 회원정보 로딩
		
//		request.setAttribute("name", mVo.getName());
		request.setAttribute("mVo", mVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/memberMyPage.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 데이터베이스에 수정된 정보를 업데이트


		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String emailId = request.getParameter("emailId");
		String midPhone = request.getParameter("midPhone");
		String lastPhone = request.getParameter("lastPhone");
		
		
//		MemberDao mDao = new MemberDao();			// 데이터베이스 연동
		MemberDao mDao = MemberDao.getInstance();	// 데이터 베이스 연동
		MemberVo mVo = new MemberVo();
		
		mVo.setUserId(userId);
		mVo.setPassword(password);
		mVo.setEmailId(emailId);
		mVo.setMidPhone(midPhone);
		mVo.setLastPhone(lastPhone);
		mVo.setUserId(userId);
		
//		System.out.println(mVo);
	
		mDao.updateMember(mVo);
//		System.out.println(mVo);
		response.sendRedirect("login.do");
		
		
		
	}

}

