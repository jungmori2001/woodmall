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
		
		String userId = (String) session.getAttribute("userId");
		System.out.println(userId);
		int prodNum = Integer.parseInt(request.getParameter("prodNum"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
	
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
			pVo = pDao.selectProductByCode(Integer.parseInt(prodNum));
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
