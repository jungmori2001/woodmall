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


@WebServlet("/myPageDelete.do")
public class myPageDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 쿼리 스트링으로 전달받은 code 를 획득
		String userId = request.getParameter("userId");
		System.out.println(userId);
		// 회원 삭제 링크 클릭시 삭제할 상품 정보를 표시
		MemberDao mDao = MemberDao.getInstance();
		MemberVo mVo = new MemberVo();
		
		// 데이터 베이스에서 삭제할 데이터 정보 확인
		mVo = mDao.getMember(userId);
		mDao.deleteMember(userId);
		System.out.println(mDao);
		System.out.println(mVo);
		request.setAttribute("member", mVo);
		System.out.println(mVo);
		
		// 페이지 이동 : 삭제 페이지
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/deleteMember.jsp");
		dispatcher.forward(request, response);		// 페이지 이동	

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		MemberDao mDao = MemberDao.getInstance();
		MemberVo mVo = new MemberVo();
		
		response.sendRedirect("logout.do");
	
		
	}
}
