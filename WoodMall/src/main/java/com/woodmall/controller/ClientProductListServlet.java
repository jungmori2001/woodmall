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


@WebServlet("/clientProductList.do")
public class ClientProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDao pDao = ProductDao.getInstance();
		String kind = request.getParameter("kind");
		

		//모든 상품 리스트를 DB로부터 조회 후 저장
		List<ProductVo> productList = pDao.selectAllProductByKind(kind);
		request.setAttribute("productList", productList);
		
		
		kind = kind.replaceAll("'", "");
		request.setAttribute("kind" , kind);
		
		
		
		//리스트 페이지로 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher("product/clientProductList.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}