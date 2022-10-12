package com.woodmall.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woodmall.dao.NoticeDao;
import com.woodmall.dto.NoticeVo;

@WebServlet("/noticeDetail.do")
public class noticeDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			String noticeNum =request.getParameter("noticeNum");
			
			NoticeDao nDao = NoticeDao.getInstance();
			NoticeVo nVo = new NoticeVo();
			
			nVo = nDao.selectNoticeByNoticeNum(noticeNum);
			
			request.setAttribute("woodmallnotice", nVo);
			RequestDispatcher dispatcher = request.getRequestDispatcher("notice/noticeDetail.jsp");
			dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
