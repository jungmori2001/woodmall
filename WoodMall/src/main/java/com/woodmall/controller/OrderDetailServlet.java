package com.woodmall.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woodmall.dao.OrderDao;
import com.woodmall.dto.OrderDetailVo;


@WebServlet("/orderDetail.do")
public class OrderDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String orderNum =request.getParameter("orderNum");
		OrderDao oDao = OrderDao.getInstance();
		OrderDetailVo oDVo = new OrderDetailVo();

		oDVo = oDao.selectOrderByOrderNum(orderNum);
		
		request.setAttribute("ordermanager", oDVo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("order/orderDetail.jsp");
		dispatcher.forward(request, response);
		System.out.println(oDVo);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
