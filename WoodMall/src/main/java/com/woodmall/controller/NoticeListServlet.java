package com.woodmall.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woodmall.dao.NoticeDao;
import com.woodmall.dto.NoticeVo;

@WebServlet("/noticeList.do")
public class NoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeDao nDao = NoticeDao.getInstance();
		
		//모든 공지사항 리스트를 DB로부터 조회 후 저장
		List<NoticeVo> noticeList = nDao.selectAllNotice();
		request.setAttribute("noticeList", noticeList);
		
		//리스트 페이지로 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher("notice/notice_all.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
