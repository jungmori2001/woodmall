package com.woodmall.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.woodmall.dao.ProductDao;
import com.woodmall.dto.MemberVo;
import com.woodmall.dto.ProductVo;


@WebServlet("/clientProductDetail.do")
public class ClientProductDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prodNum = request.getParameter("prodNum");  // 고유 번호 값을 가져옴
		
		HttpSession session = request.getSession();			// 세션 값을 가져옴
		session.getAttribute("loginUser");
		
		ProductDao pDao = ProductDao.getInstance();		// 상품 Dao, Vo 객체 생성
		ProductVo pVo = new ProductVo();

		pVo = pDao.selectProductByCode(prodNum);			// 상품 코드 값으로 해당 상품 정보를 가져옴
		request.setAttribute("product", pVo);				// 가져온 상품 정보를 인자값에 할당
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("product/clientProductDetail.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
