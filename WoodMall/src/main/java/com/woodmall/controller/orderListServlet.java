package com.woodmall.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woodmall.dao.OrderDao;
import com.woodmall.dto.OrderVo;

@WebServlet("/orderList.do")
public class orderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderDao oDao = OrderDao.getInstance();
		
		//모든 주문내역 리스트를 DB로부터 조회 후 저장
		List<OrderVo> orderList = oDao.selectAllOrder();
		request.setAttribute("orderList", orderList);
//		System.out.println(orderList);
		
		//리스트 페이지로 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher("order/orderList.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
