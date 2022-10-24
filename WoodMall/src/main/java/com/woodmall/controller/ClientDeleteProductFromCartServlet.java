package com.woodmall.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.woodmall.dao.CartDao;


@WebServlet("/clientDeleteProductFromCart.do")
public class ClientDeleteProductFromCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CartDao cDao = CartDao.getInstance();
		String prodNum = request.getParameter("prodNum");
		String userId = request.getParameter("userId");
		
		System.out.println("prodNum :" +prodNum);
		System.out.println(userId);
		
		cDao.deleteProductFromCart(userId, prodNum);
	
		response.sendRedirect("clientCart.do?userId="+userId);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
