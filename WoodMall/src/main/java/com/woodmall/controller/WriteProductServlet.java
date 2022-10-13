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

import com.woodmall.dao.ProductDao;
import com.woodmall.dto.ProductVo;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/writeProduct.do")
public class WriteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("./product/writeProduct.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		ProductVo pVo = new ProductVo();
		ProductDao pDao = ProductDao.getInstance();	
		
		int result = -1;
		String savePath = "upload";
		ServletContext context = getServletContext();				// 이 서블릿이 실행되고 있는 컨택스트 가져오기
		String uploadFilePath = context.getRealPath(savePath);		// 실제 경로를 리턴
		System.out.println("저장파일 서버경로: " + uploadFilePath);
		int uploadFileSizeLimit = 5 * 1024 * 1024;
		String encType = "UTF-8";
		
		try {
			MultipartRequest multi = new MultipartRequest(
				request,							// request 객체
				uploadFilePath,						// 서버상의 실제 디렉토리
				uploadFileSizeLimit,				// 최대 업로드 파일 크기 
				encType,							// 인코딩 방식
				new DefaultFileRenamePolicy()		// 정책: 동일 이름 존재시, 새로운 이름 부여
			);	
			// 입력 양식을 통해 정보를 획득
			
//			int prodNum = Integer.parseInt(multi.getParameter("prodNum")) ;
			String kind = multi.getParameter("kind");
			String image = multi.getFilesystemName("image");
			String prodName = multi.getParameter("prodName");
			int price = Integer.parseInt(multi.getParameter("price"));
			String content = multi.getParameter("content");
			Date reg_date = Date.valueOf(multi.getParameter("reg_date"));
			
//			System.out.println(code);
//			System.out.println(name);
//			System.out.println(price);
//			System.out.println(description);
//			System.out.println(pictureurl);
//			System.out.println(reg_date);
			
//			pVo.setProdNum(prodNum);			// 입력된 상품 정보 Vo에 저장
			pVo.setKind(kind);
			pVo.setImage(image);
			pVo.setProdName(prodName);
			pVo.setPrice(price);
			pVo.setContent(content);
			pVo.setReg_date(reg_date);
			
			System.out.println(pVo);
	
			result = pDao.insertProduct(pVo);		// 입력된 상품 정보 삽입
			
		}catch(Exception e) {
			System.out.println("파일 업로드간 예외 발생" + e);
		}
		// 상품 등록 완료 시, 메시지 출력
		if(result == 1) {
			System.out.println("상품 등록에 성공");
			request.setAttribute("message", "상품 등록 성공");
		} else {
			System.out.println("상품 등록에 실패");
			request.setAttribute("message", "상품 등록 실패");
		}
		response.sendRedirect("productList.do");
	}

}