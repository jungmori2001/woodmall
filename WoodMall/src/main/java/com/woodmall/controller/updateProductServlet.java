package com.woodmall.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.woodmall.dao.ProductDao;
import com.woodmall.dto.ProductVo;

@WebServlet("/updateProduct.do")
public class updateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//쿼리스트링으로 전달 받을 prodnum 획득
		String prodnum = request.getParameter("prodnum");
		//상품 수정링크 클릭시 수정할 상품 정보를 표시
		ProductDao pDao = ProductDao.getInstance();
		ProductVo pVo = new ProductVo();
		
		//데이터베이스에서 수정할 데이터 정보 확인
		pVo = pDao.selectProductByCode(prodnum);
		
		request.setAttribute("woodmallproduct", pVo);
		
		//페이지 이동: 수정페이지
		RequestDispatcher dispatcher = request.getRequestDispatcher("product/updateProduct.jsp");
		dispatcher.forward(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//상품 수정 코드 : DB에서 상품 수정
		ProductDao pDao = ProductDao.getInstance();
		ProductVo pVo = new ProductVo();
		
		int result = -1;
		String savePath = "upload";
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		System.out.println("저장파일 서버경로:" + uploadFilePath);	//image 저장파일경로 지정
		int uploadFileSizeLimit = 5 * 1024 * 1024;
		String encType = "UTF-8";
		
		try {
			MultipartRequest multi = new MultipartRequest(
				request,
				uploadFilePath,
				uploadFileSizeLimit,
				encType,
				new DefaultFileRenamePolicy());
				
			//입력 양식을 통해 정보를 휙득
			System.out.println(pVo);//디버깅
			int prodNum = Integer.parseInt(multi.getParameter("prodnum"));
			String prodName = multi.getParameter("prodName");
			int price = Integer.parseInt(multi.getParameter("price"));
			String content = multi.getParameter("content");
			String image = multi.getFilesystemName("image");
			Date reg_date = Date.valueOf(multi.getParameter("reg_date"));
			
			System.out.println(pVo);//디버깅
			pVo.setProdNum(prodNum);
			pVo.setProdName(prodName);
			pVo.setPrice(price);
			pVo.setContent(content);
			pVo.setImage(image);
			pVo.setReg_date(reg_date);
			System.out.println(pVo);
		}catch(Exception e) {
			System.out.println("파일 업로드 예외 발생: " + e);
		}
		//DB로부터 해당 코드의 정보 수정
		result=pDao.updateProduct(pVo);
		
		//정상적인 수정 여부 확인
		if(result == 1) {
			System.out.println("상품 수정 성공");
		}else {
			System.out.println("상품 수정 실패");
		}
		
		//수정 후 목록 페이지로 이동
		response.sendRedirect("productList.do");
		
	}

}
