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

import com.woodmall.dao.ProductDao;
import com.woodmall.dto.ProductVo;


@WebServlet("/clientOrder.do")
public class ClientOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDao pDao = ProductDao.getInstance();
		ProductVo pVo = new ProductVo();
		
		// 1. 장바구니에서 체크된 항목의 코드값만 가져와서 다시 디비에서 불러오기
		
			// 전체 금액
		String[] prices = request.getParameterValues("price");
		int totalPrice = 0;
		for(String price: prices) {
			totalPrice = totalPrice+ Integer.parseInt(price);
		}
		
		String[] prodNums = request.getParameterValues("prodNum");
		
		List<ProductVo> list = new ArrayList<ProductVo>();
		
		for(String prodNum : prodNums) {
			pVo = pDao.selectProductByCode(prodNum);
			pVo.getProdName();
			pVo.getPrice();
			pVo.getProdNum();
		}
		list.add(pVo);
		
		
		request.setAttribute("productList", list);
		
		
		
		request.setAttribute("totalPrice", totalPrice);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("order/clientOrder.jsp");
		dispatcher.forward(request, response);
	}

}
