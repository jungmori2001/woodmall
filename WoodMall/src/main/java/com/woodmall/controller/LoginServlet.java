package com.woodmall.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.woodmall.dao.MemberDao;
import com.woodmall.dto.MemberVo;


@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			String url = "member/login.jsp";
			
			// 세션 설정
			HttpSession session = request.getSession();			// 생성된 세션 객체 호출
//			System.out.println(session.getAttribute("loginUser"));
//			System.out.println(session);
			
			// 만약, 세션 속성이 유지되고 있는 동안(즉, 로그인 되어 있는 상태)에는 index.jsp 페이지로 이동
			if(session.getAttribute("loginUser") != null) {		// 세션에 로그인한 회원 정보가 저장되어 있는지 확인하여 
				url = "index.jsp";
			}
			
			// 페이지 이동(forward 방식)
			RequestDispatcher dispatcher;
			dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request,response);		
	
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");		// post 방식 한글 설정
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();		// 웹페이지 출력 처리
		
		String url = "member/login.jsp";			// 현재 URL

		//MemberDao mDao = new MemberDao();			// 데이터 베이스 연동
		
		MemberDao mDao = MemberDao.getInstance();	// 데이터 베이스 연동
		
		String userId = request.getParameter("userId");		// 입력양식으로 부터 가져온 아이디
		String userPwd = request.getParameter("password");
//		System.out.println("userId: "+ userId + " userPwd: "+ userPwd);
		// 디비 연동 후, 가져올 아이디/암호
//		String id = "kenneth";
		
		int result = mDao.checkUser(userId, userPwd);		// DB 사용자 확인

//		out.print("아이디: " + userId);
//		out.print("<br>");
//		out.print("암호: " + userPwd);
		
		
		if(result == 1) {
			System.out.println("로그인 성공");
			url = "index.jsp";
			
			
			MemberVo mVo = mDao.getMember(userId);
			System.out.println("회원 이름:" + mVo.getName());
			
			// 세션 설정
			HttpSession session = request.getSession();		// 생성된 세션 객체 호출
			session.setAttribute("loginUser", mVo);	
			
			
			// 세션에 회원 정보 저장
//			System.out.println(session.getAttribute("loginUser"));	// toString 확인
//			System.out.println(session);		// session 객체 확인
//			request.setAttribute("name", mVo.getName());
//			request.setAttribute("userId", mVo.getuserId());
		
			
		} else if(result == 0) {
			System.out.println("암호 불일치");
//			url = "member/login.jsp";
		} else {
			System.out.println("존재하지 않는 회원");
//			url = "member/login.jsp";
		}
		
		
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request,response);
	}

}


