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

import com.woodmall.dao.ProductDao;
import com.woodmall.dto.ProductVo;


@WebServlet("/completeOrder.do")
public class CompleteOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String prodNums[] = request.getParameterValues("prodNum");
		HttpSession session = request.getSession();			
		session.getAttribute("loginUser");
		
		ProductDao pDao = ProductDao.getInstance();
		ProductVo pVo = new ProductVo();
		List<ProductVo> productList = new ArrayList<ProductVo>(); 
		
		for(String prodNum : prodNums) {
		pVo = pDao.selectProductByCode(prodNum);
		
		productList.add(pVo);
		}
		request.setAttribute("productList", productList);
		
		System.out.println(productList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("order/completeOrder.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
