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


@WebServlet("/deleteNotice.do")
public class deleteNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String noticeNum = request.getParameter("noticeNum");
		
		NoticeDao nDao = NoticeDao.getInstance();
		NoticeVo nVo = new NoticeVo();
		
		nVo = nDao.selectNoticeByNoticeNum(noticeNum);
		request.setAttribute("woodmallnotice", nVo);
		
		//페이지 이동
				RequestDispatcher dispatcher = request.getRequestDispatcher("notice/deleteNotice.jsp");
				dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeDao nDao = NoticeDao.getInstance();
		NoticeVo nVo = new NoticeVo();
		
		String noticeNum = request.getParameter("noticeNum");
		nDao.deleteNotice(noticeNum);
		
		response.sendRedirect("noticeList.do");
	}

}
