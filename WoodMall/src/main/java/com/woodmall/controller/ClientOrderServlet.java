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

import com.woodmall.dao.CartDao;
import com.woodmall.dao.MemberDao;
import com.woodmall.dao.ProductDao;
import com.woodmall.dto.CartVo;
import com.woodmall.dto.MemberVo;
import com.woodmall.dto.ProductVo;


@WebServlet("/clientOrder.do")
public class ClientOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CartDao cDao = CartDao.getInstance();
		CartVo cVo = new CartVo();
		String userId = request.getParameter("userId");
		String[] prodNums = request.getParameterValues("chk");
		
		System.out.println("userid :"+userId);
		
		if(prodNums != null) {
		List<CartVo> list = new ArrayList<CartVo>();
		for(String prodNum : prodNums) {
			cVo = cDao.selectCheckProductFromCart(prodNum, userId);
			list.add(cVo);
		}
		request.setAttribute("productList", list);
	
		// 상품 총 금액산출
		int totalPrice=0;
		String[] prices = request.getParameterValues("price");
		for(String price : prices) {
			 totalPrice = totalPrice + Integer.parseInt(price);
		}
		request.setAttribute("totalPrice", totalPrice);
		// getMember
		MemberVo mVo = new MemberVo();
		MemberDao mDao = MemberDao.getInstance();
		mVo = mDao.getMember(userId);
		
		request.setAttribute("userInfo", mVo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("order/clientOrder.jsp");
		dispatcher.forward(request, response);
		
		} else {
			ProductVo pVo = new ProductVo();
			ProductDao pDao = ProductDao.getInstance();
			String prodNum = request.getParameter("prodNum");
			String quantity = request.getParameter("quantity");
			List<CartVo> productList = new ArrayList<CartVo>();
			
			System.out.println(prodNum);
			System.out.println(quantity);
			
			pVo = pDao.selectProductByCode(prodNum); //리스트
			
			cVo.setProdNum(pVo.getProdNum());
			cVo.setQuantity(Integer.parseInt(quantity));
			cVo.setImage(pVo.getImage());
			cVo.setUserId(userId);
			cVo.setPrice(pVo.getPrice());
			cVo.setProdName(pVo.getProdName());
			
			cDao.insertProductToCart(cVo);
			
			System.out.println(cVo);
			
			productList = cDao.selectProductFromCart(userId, prodNum);
			
			request.setAttribute("productList", productList);
			
			// getMember
			MemberVo mVo = new MemberVo();
			MemberDao mDao = MemberDao.getInstance();
			mVo = mDao.getMember(userId);
			
			request.setAttribute("userInfo", mVo);
			System.out.println("productList : "+productList);
			System.out.println("userinfo : "+mVo);
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("order/clientOrder.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
