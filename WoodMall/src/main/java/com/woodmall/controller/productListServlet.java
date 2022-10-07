package com.woodmall.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woodmall.dao.ProductDao;
import com.woodmall.dto.ProductVo;

@WebServlet("/productList.do")
public class productListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDao pDao = ProductDao.getInstance();
		
		//모든 상품 리스트를 DB로부터 조회 후 저장
		List<ProductVo> productList = pDao.selectAllProduct();
		request.setAttribute("productList", productList);
		
		//리스트 페이지로 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher("product/prod_all.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
