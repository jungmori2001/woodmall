package com.woodmall.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woodmall.dao.ProductDao;
import com.woodmall.dto.ProductVo;


@WebServlet("/deleteProduct.do")
public class deleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 쿼리 스트링으로 전달받은 prodnum 를 획득
		String prodNum = request.getParameter("prodnum");
		
		// 상품 삭제 링크 클릭시 삭제할 상품 정보를 표시
		ProductDao pDao = ProductDao.getInstance();
		ProductVo pVo = new ProductVo();
		
		// 데이터 베이스에서 삭제할 데이터 정보 확인
		pVo = pDao.selectProductByCode(prodNum);
		
		request.setAttribute("woodmallproduct", pVo);

		
		// 페이지 이동 : 삭제 페이지
		RequestDispatcher dispatcher = request.getRequestDispatcher("product/deleteProduct.jsp");
		dispatcher.forward(request, response);		// 페이지 이동	

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 상품 삭제 코드
		ProductDao pDao = ProductDao.getInstance();
		ProductVo pVo = new ProductVo();
		
		String prodnum = request.getParameter("prodNum");
		System.out.println(prodnum);
		
		// 데이터베이스로부터 해당 코드의 정보를 삭제
		pDao.deleteProduct(prodnum);
		
		// 삭제 후 목록 페이지로 이동
		response.sendRedirect("productList.do");
		
	}

}
