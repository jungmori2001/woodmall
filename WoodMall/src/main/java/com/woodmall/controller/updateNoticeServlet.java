package com.woodmall.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woodmall.dao.NoticeDao;
import com.woodmall.dto.NoticeVo;

@WebServlet("/updateNotice.do")
public class updateNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String noticeNum = request.getParameter("noticeNum");
		NoticeDao nDao = NoticeDao.getInstance();
		NoticeVo nVo = new NoticeVo();
		
		nVo = nDao.selectNoticeByNoticeNum(noticeNum);
		
		request.setAttribute("woodmallnotice", nVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("notice/updateNotice.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; chaset=UTF-8");
		
		NoticeDao nDao = NoticeDao.getInstance();
		NoticeVo nVo = new NoticeVo();
		
		int result =-1;


		try {
			System.out.println(nVo);
			int noticeNum = Integer.parseInt(request.getParameter("noticeNum"));
			String name = request.getParameter("name");
			String noticeTitle = request.getParameter("noticeTitle");
			String noticeContent = request.getParameter("noticeContent");
//			int noticeHits = Integer.parseInt(request.getParameter("noticeHits"));
	
			nVo.setNoticeNum(noticeNum);
			nVo.setName(name);
			nVo.setNoticeTitle(noticeTitle);
			nVo.setNoticeContent(noticeContent);
//			nVo.setNoticeHits(noticeHits);
			
			System.out.println(nVo);
			

		}catch(Exception e) {
			System.out.println("글 쓰는데 예외 발생: " + e);
			System.out.println(nVo);
		}
		
		result = nDao.updateNotice(nVo);
		//공지 작성 완료 시 메세지 출력
		if(result==1) {
			System.out.println("공지사항 수정 성공");
			request.setAttribute("message", "공지 수정 성공!");
		}else {
			System.out.println("공지사항 수정 실패");
			request.setAttribute("message", "공지 수정 실패!");
		}
		response.sendRedirect("noticeList.do");
	}

}
