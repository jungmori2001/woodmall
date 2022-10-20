package com.woodmall.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woodmall.dao.CartDao;
import com.woodmall.dto.CartVo;


@WebServlet("/clientCart.do")
public class ClientCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		
		CartDao cDao = CartDao.getInstance();
		
		// 장바구니에 넣은 데이터 가져와서 장바구니 화면에 뿌리기
		List<CartVo> productList = cDao.selectProductByUserId(userId);
		request.setAttribute("productList", productList);
			
		int totalPrice = cDao.selectTotalPriceByUserIdBy(userId);
		
		request.setAttribute("totalPrice", totalPrice);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("product/clientCart.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
