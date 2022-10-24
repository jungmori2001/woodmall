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
		
		String userId = request.getParameter("userId");
		String[] prodNums = request.getParameterValues("chk");
		
		if(prodNums != null) {
		CartDao cDao = CartDao.getInstance();
		CartVo cVo = new CartVo();
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
			CartDao cDao = CartDao.getInstance();
			CartVo cVo = new CartVo();
			ProductVo pVo = new ProductVo();
			ProductDao pDao = ProductDao.getInstance();
			String prodNum = request.getParameter("prodNum");
			String quantity = request.getParameter("quantity");
			List<CartVo> productList = new ArrayList<CartVo>();
			
			
			
			pVo = pDao.selectProductByCode(prodNum); //리스트
			
			cVo.setProdNum(pVo.getProdNum());
			cVo.setQuantity(Integer.parseInt(quantity));
			cVo.setImage(pVo.getImage());
			cVo.setUserId(userId);
			cVo.setPrice(pVo.getPrice());
			cVo.setProdName(pVo.getProdName());
			
			cDao.insertProductToCart(cVo);
			
			
			
			cVo = cDao.selectProductFromCart(userId, prodNum);
			System.out.println(cVo);
			request.setAttribute("productList", productList);
			
			// getMember
			MemberVo mVo = new MemberVo();
			MemberDao mDao = MemberDao.getInstance();
			mVo = mDao.getMember(userId);
			
			
			
			
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("order/clientOrder.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
