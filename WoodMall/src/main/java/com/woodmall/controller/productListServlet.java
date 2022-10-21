package com.woodmall.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woodmall.dao.ProductDao;
import com.woodmall.dto.ProductVo;

@WebServlet("/productList.do")
public class productListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDao pDao = ProductDao.getInstance();
		ProductVo pVo = new ProductVo();
		
		//기본 값 설정(검색대상 :column, 검색내용, keyword, 페이지: page)
		String column = "prodnum"; //것ㅁ색 대상 분야
		String keyword = ""; //검색 내용(검색어)
		int page = 1;
		
		
		String t_column = request.getParameter("column");
		String t_keyword = request.getParameter("keyword");
		String t_page = request.getParameter("p");
		
		if(t_column != null && !t_column.equals("")) {
			column = t_column;
		}
		if(t_keyword != null && !t_keyword.equals("")) {
			keyword = t_keyword;
		}
		
		if(t_page != null && ! t_page.equals("")) {
			page = Integer.parseInt(t_page);
		}
		//모든 상품 리스트를 DB로부터 조회 후 저장
//		List<ProductVo> productList = pDao.selectAllProduct();
//		List<ProductVo> productList = pDao.getProductList(page);// 하나의 페이지에 표시할 데이터
		List<ProductVo> productList = pDao.getProductList(column, keyword, page);// 하나의 페이지에 표시할 데이터
//		int count = pDao.getProductCount();
		int count = pDao.getProductCount(column, keyword);
		
		//디비에서 검색한 게시물 수
		request.setAttribute("productList", productList);
		request.setAttribute("count", count);
		//리스트 페이지로 이동
		String url = "product/prod_all.jsp";
		request.getRequestDispatcher(url).forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}
}
