package com.woodmall.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.woodmall.dao.CartDao;
import com.woodmall.dao.OrderDao;
import com.woodmall.dao.ProductDao;
import com.woodmall.dto.OrderVo;
import com.woodmall.dto.ProductVo;


@WebServlet("/completeOrder.do")
public class CompleteOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String prodNums[] = request.getParameterValues("prodNum");
		String pay = request.getParameter("pay");
		String quantity = request.getParameter("quantity");
		HttpSession session = request.getSession();			
		session.getAttribute("loginUser");
		
		OrderDao oDao = OrderDao.getInstance();
		OrderVo oVo = new OrderVo();
		
		CartDao cDao = CartDao.getInstance();
		ProductDao pDao = ProductDao.getInstance();
		ProductVo pVo = new ProductVo();
		List<ProductVo> productList = new ArrayList<ProductVo>(); 
		
		for(String prodNum : prodNums) {
		pVo = pDao.selectProductByCode(prodNum);
		oVo.setProdNum(Integer.parseInt(prodNum));
		oVo.setUserId(userId);
		oVo.setPaymentStatus(pay);
		oVo.setPrice(pVo.getPrice());
		oVo.setOrderQuan(Integer.parseInt(quantity));
		oDao.insertProductInOrder(oVo);
		cDao.deleteProductFromCart(userId, prodNum);
		productList.add(pVo);
		}
		request.setAttribute("productList", productList);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("order/completeOrder.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
