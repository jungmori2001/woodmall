package com.woodmall.controller;

import java.io.IOException;
import java.util.Enumeration;
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
		System.out.println(session.getAttribute("loginUser"));
		
		
		CartDao cDao = CartDao.getInstance();
		ProductVo pVo = new ProductVo();
		ProductDao pDao = ProductDao.getInstance();
		
		// 장바구니에 표시해야 하는 값 가져오기
		String userId = "abcd";
		String prodNum = request.getParameter("prodNum");	// 상품 코드
		int quantity = Integer.parseInt(request.getParameter("quantity"));	// 상품 수량
//		System.out.println("id : "+ userId);

		
		//1.prodNum 기반으로 데이터 가져오기
		try{
		pVo = pDao.selectProductByCode(prodNum);
		
		//2.가져온 데이터에서 필요한 부분만 insert 함수에 넣기
		
		CartVo cVo = new CartVo();
		cVo.setPrice(pVo.getPrice());
		cVo.setProdName(pVo.getProdName());
		cVo.setProdNum(pVo.getProdNum());
		cVo.setQuantity(quantity);
		cVo.setUserId(userId);
			/// cartDao  함수 수정 해야함
		cDao.insertProductToCart(cVo);
		
//		List<CartVo> productList = cDao.selectProductByUserId(userId);
		
//		request.setAttribute("productList", productList);
		
		
		} catch(Exception e) {
			System.out.println(e.getStackTrace());
		} finally {
//			request.setAttribute("result", result);  
//			리턴값을 이용하여 장바구니에 들어갔는지 알려주는 함수 넣기
//			리턴값을 이용하여 장바구니 이동할지 계속 쇼핑할지 clientproductDetail.jsp 에 alert 함수 만들자 시간나면
		RequestDispatcher dispatcher = request.getRequestDispatcher("product/clientCart.jsp");
		dispatcher.forward(request, response);
		}
//		

		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
}
