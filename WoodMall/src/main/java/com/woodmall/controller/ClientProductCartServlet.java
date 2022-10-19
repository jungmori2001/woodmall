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
		HttpSession session = request.getSession();
		
		CartDao cDao = CartDao.getInstance();
		ProductVo pVo = new ProductVo();
		ProductDao pDao = ProductDao.getInstance();
		
		// 장바구니에 표시해야 하는 값 가져오기
		String userId = (String) session.getAttribute("loginUser");	// 아이디
		String prodNum = request.getParameter("prodNum");	// 상품 코드
		int quantity = Integer.parseInt(request.getParameter("quantity"));	// 상품 수량
		System.out.println("id : "+ userId);
		System.out.println("prodNum : "+ prodNum);
		System.out.println("quantity : "+ quantity);
	
		//1.prodNum 기반으로 데이터 가져오기
		pVo = pDao.selectProductByCode(prodNum);
		
		//2.가져온 데이터에서 필요한 부분만 insert 함수에 넣기
		
		CartVo cVo = new CartVo();
		cVo.setPrice(pVo.getPrice());
		cVo.setProdName(pVo.getProdName());
		cVo.setProdNum(pVo.getProdNum());
		cVo.setQuantity(quantity);
		cVo.setUserId(userId);
		
		cDao.insertProductToCart(cVo);
		
		String result = request.getParameter("result");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("product/clientProductDetail.jsp");
		dispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
}
