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
import com.woodmall.dao.OrderDao;
import com.woodmall.dao.ProductDao;
import com.woodmall.dto.CartVo;
import com.woodmall.dto.MemberVo;
import com.woodmall.dto.OrderVo;
import com.woodmall.dto.ProductVo;


@WebServlet("/clientOrder.do")
public class ClientOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String[] prodNums = request.getParameterValues("chk");
		String pay = request.getParameter("pay");
		String quantity = request.getParameter("quantity");

		if(prodNums != null) {						// 구매 상품 여러개일 경우
		CartDao cDao = CartDao.getInstance();
		CartVo cVo = new CartVo();
		OrderDao oDao = OrderDao.getInstance();
		ProductDao pDao = ProductDao.getInstance();
		ProductVo pVo = new ProductVo();
		// 사용자 ID와 상품 번호로 장바구니 DB 에서 선택된 상품의 정보를 가져와서 주문DB에 넣음과 동시에 
		// List 객체에 담아 주문 페이지로 넘겨줌
		List<CartVo> list = new ArrayList<CartVo>();
		OrderVo oVo = new OrderVo();
		for(String prodNum : prodNums) {		
			cVo = cDao.selectCheckProductFromCart(prodNum, userId);
			pVo = pDao.selectProductByCode(prodNum);
			list.add(cVo);
			oVo.setUserId(userId);
			oVo.setProdNum(Integer.parseInt(prodNum));
			oVo.setPaymentStatus(pay);
			oVo.setPrice(pVo.getPrice());
			oVo.setOrderQuan(Integer.parseInt(quantity));
			oDao.insertProductInOrder(oVo);
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
		
		} else {									// 단일상품 구매일 경우
			ProductVo pVo = new ProductVo();
			ProductDao pDao = ProductDao.getInstance();
			String prodNum = request.getParameter("prodNum");

			pVo = pDao.selectProductByCode(prodNum); // 상품 번호로 해당 상품 정보 조회

			request.setAttribute("product", pVo);
			request.setAttribute("quantity", quantity);
			System.out.println("product : "+pVo);
			System.out.println("quantity : "+quantity);
			
			// getMember
			MemberVo mVo = new MemberVo();
			MemberDao mDao = MemberDao.getInstance();
			mVo = mDao.getMember(userId);
			
			request.setAttribute("userInfo", mVo);
			System.out.println("userInfo : "+mVo);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("order/clientOrderOneBuy.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
