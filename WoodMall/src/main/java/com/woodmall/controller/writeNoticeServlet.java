package com.woodmall.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woodmall.dao.NoticeDao;
import com.woodmall.dto.MemberVo;
import com.woodmall.dto.NoticeVo;


@WebServlet("/writeNotice.do")
public class writeNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("./notice/writeNotice.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; chaset=UTF-8");
		
		NoticeVo nVo = new NoticeVo();
		NoticeDao nDao = NoticeDao.getInstance();
		
		int result =-1;
		
		//내용 저장
		try {
			String name = request.getParameter("name");
			String userId = request.getParameter("userId");
			String noticeTitle = request.getParameter("noticeTitle");
			String noticeContent = request.getParameter("noticeContent");
			
//			nVo.setNoticeNum(noticeNum);
			nVo.setName(name);
			nVo.setUserId(userId);
			nVo.setNoticeTitle(noticeTitle);
			nVo.setNoticeContent(noticeContent);

			result = nDao.insertNotice(nVo);
		}catch(Exception e) {
			System.out.println("글 쓰는데 예외 발생: " + e);
			System.out.println(nVo);
		
		}
		//공지 작성 완료 시 메세지 출력
		if(result==1) {
			System.out.println("공지사항 등록 성공");
			request.setAttribute("message", "공지 등록 성공!");
		}else {
			System.out.println("공지사항 등록 실패");
			request.setAttribute("message", "공지 등록 실패!");
		}
		response.sendRedirect("noticeList.do");
	}

}
