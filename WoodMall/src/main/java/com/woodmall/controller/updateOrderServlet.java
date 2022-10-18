package com.woodmall.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woodmall.dao.OrderDao;
import com.woodmall.dto.OrderDetailVo;
import com.woodmall.dto.OrderVo;


@WebServlet("/updateOrder.do")
public class updateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderNum = request.getParameter("orderNum");
		OrderDao oDao = OrderDao.getInstance();
		OrderVo oVo = new OrderVo();
		
		oVo = oDao.selectOrderByOrderNum1(orderNum);
		
		request.setAttribute("ordermanager", oVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("order/orderDetail.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; chaset=UTF-8");
		
		OrderDao oDao = OrderDao.getInstance();
		OrderVo oVo = new OrderVo();
		
		int result = -1;
		
		try {
			String orderStatus = request.getParameter("orderStatus");
			
			oVo.setOrderStatus(orderStatus);
		}catch(Exception e) {
			System.out.println("업데이트 오더 서블릿 오류: " + e);
		}
		result=oDao.updateOrder(oVo);
		System.out.println(oVo);
		if(result==1) {
			System.out.println("주문 수정 완료");
		}else {
			System.out.println("주문 수정 실패");
		}
		response.sendRedirect("orderList.do");
	}

}
