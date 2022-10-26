package com.woodmall.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woodmall.dao.MemberDao;
import com.woodmall.dto.MemberVo;


@WebServlet("/join.do")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/join.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		// post 방식 한글 설정
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();		// 웹페이지 출력 처리
		
		// 회원 가입에서 작성한 데이터를 데이터 베이스에 삽입(insert)
		
		String name = request.getParameter("name");		// 입력양식으로부터 이름 획득
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String emailAddress = request.getParameter("emailAddress");
		String firstPhone = request.getParameter("firstPhone");
		String midPhone = request.getParameter("midPhone");
		String lastPhone = request.getParameter("lastPhone");
		String postNum = request.getParameter("postNum");
		String mainAddress = request.getParameter("mainAddress");
		String detailAddress = request.getParameter("detailAddress");
		String subAddress = request.getParameter("subAddress");
		
		
//		System.out.println("name: " + name);
//		System.out.println("userId: " + userId);
//		System.out.println("pwd: " + pwd);
//		System.out.println("email: " + email);
//		System.out.println("phone: " + phone);
//		System.out.println("admin: " + admin);
		
//		MemberDao mDao = new MemberDao();		// DB 연동
		MemberDao mDao = MemberDao.getInstance();			// 데이터 베이스 연동
		
		MemberVo mVo =  new MemberVo();
		mVo.setName(name);				// MemberVo 클래스에 정보 저장 
		mVo.setUserId(userId);
		mVo.setPassword(password);
		mVo.setFirstPhone(firstPhone);
		mVo.setMidPhone(midPhone);
		mVo.setLastPhone(lastPhone);
		mVo.setEmailAddress(emailAddress);
		mVo.setPostNum(postNum);
		mVo.setMainAddress(mainAddress);
		mVo.setDetailAddress(detailAddress);
		mVo.setSubAddress(subAddress);
		
//		System.out.println(mVo.getName());
//		System.out.println(mVo.getAdmin());
		
//		mDao.insertMember(name, userId, pwd, email, phone, admin);
		int result = mDao.insertMember(mVo);
		if (result == 1) {
			System.out.println("회원가입 성공");
		} else {
			System.out.println("회원가입 실패");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/login.jsp");
		dispatcher.forward(request, response);		// 페이지 이동		
	}

}