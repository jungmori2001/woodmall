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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		PrintWriter out = response.getWriter();
		
		String prodNum = request.getParameter("prodNum");
		
		ProductDao pDao = ProductDao.getInstance();
		ProductVo pVo = new ProductVo();
		
		pVo = pDao.selectProductByCode(prodNum);
		
		request.setAttribute("product", pVo);
		
		
		HttpSession session = request.getSession();
		session.getAttribute("loginUser");
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("product/clientProductDetail.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
