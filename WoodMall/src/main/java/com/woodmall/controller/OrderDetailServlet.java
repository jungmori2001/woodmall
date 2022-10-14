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
import com.woodmall.dto.OrderVo;
import com.woodmall.dto.ProductVo;


@WebServlet("/orderDetail.do")
public class OrderDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String orderNum =request.getParameter("orderNum");
		
		OrderDao oDao = OrderDao.getInstance();
		OrderVo oVo = new OrderVo();
//		ProductVo pVo = new ProductVo();
//		MemberVo mVo = new MemberVo();
		
		oVo = oDao.selectOrderByOrderNum(orderNum);

		request.setAttribute("ordermanager", oVo);
//		request.setAttribute("member", mVo);
//		request.setAttribute("woodmallproduct", pVo);
//		System.out.println(oVo);
//		System.out.println(pVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("order/orderDetail.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
