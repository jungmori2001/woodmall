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
import com.woodmall.dao.ProductDao;
import com.woodmall.dto.CartVo;
import com.woodmall.dto.ProductVo;


@WebServlet("/clientProductCart.do")
public class ClientProductCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prodNum = request.getParameter("prodNum");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String userId = request.getParameter("userId");		
		
		
		CartVo cVo = new CartVo();
		CartDao cDao = CartDao.getInstance();
		ProductDao pDao = ProductDao.getInstance();
		ProductVo pVo = new ProductVo();
		
		// 장바구니 DB 에 상품 정보 넣기
		pVo = pDao.selectProductByCode(prodNum);
		cVo.setPrice(pVo.getPrice());
		cVo.setProdName(pVo.getProdName());
		cVo.setProdNum(pVo.getProdNum());
		cVo.setQuantity(quantity);
		cVo.setUserId(userId);
		
		cDao.insertProductToCart(cVo);

		response.sendRedirect("clientCart.do?&userId="+userId);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
}
