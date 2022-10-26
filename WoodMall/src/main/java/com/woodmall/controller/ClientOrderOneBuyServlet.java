package com.woodmall.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woodmall.dao.OrderDao;
import com.woodmall.dao.ProductDao;
import com.woodmall.dto.OrderVo;
import com.woodmall.dto.ProductVo;


@WebServlet("/clientOrderOneBuy.do")
public class ClientOrderOneBuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String userId = request.getParameter("userId");
		String prodNum = request.getParameter("prodNum");
		String pay = request.getParameter("pay");
		String quantity = request.getParameter("quantity");
		
		ProductDao pDao = ProductDao.getInstance();
		ProductVo pVo = new ProductVo();
		OrderDao oDao = OrderDao.getInstance();
		pVo = pDao.selectProductByCode(prodNum);
		
		OrderVo oVo = new OrderVo();
		oVo.setUserId(userId);
		oVo.setProdNum(Integer.parseInt(prodNum));
		oVo.setPaymentStatus(pay);
		oVo.setPrice(pVo.getPrice());
		oVo.setOrderQuan(Integer.parseInt(quantity));
		oDao.insertProductInOrder(oVo);
		System.out.println(oVo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("order/clientOrderOneBuy.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
