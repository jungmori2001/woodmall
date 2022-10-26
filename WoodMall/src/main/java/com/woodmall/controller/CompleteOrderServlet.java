package com.woodmall.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		ProductDao pDao = ProductDao.getInstance();
		ProductVo pVo = new ProductVo();
		for(String prodNum : prodNums) {
		pVo = pDao.selectProductByCode("prodNum");
		
		
		}
		
	}

}
