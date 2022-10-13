<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" >
<title>Insert title here</title>
</head>
<body>
 <h2>상품 리스트</h2>
   
   <%-- ${productList} --%>

   <table class="list">
   	<tr>
   		<td colspan="7" align="center">
   			<a href="writeProduct.do">상품 등록</a>
   		</td>
   	</tr>
      <tr>
         <th>코드</th><th>분류</th><th>이미지</th><th>이름</th><th>가격</th><th>등록일자</th><th>상세</th><th>수정</th><th>삭제</th>
      </tr>
      <c:forEach var="woodmallproduct" items="${productList}">   
         <tr>
            <td>${woodmallproduct.prodNum}</td>
            <td>${woodmallproduct.kind}</td>
            <td>${woodmallproduct.image}</td>         
            <td>${woodmallproduct.prodName}</td>
            <td>${woodmallproduct.price}</td>
            <td>${woodmallproduct.reg_date}</td>
            <td><a href="productDetail.do?code=${woodmallproduct.prodNum}">상품상세</a></td>
            <td><a href="updateProduct.do?code=${woodmallproduct.prodNum}">상품수정</a></td>
            <td><a href="deleteProduct.do?code=${woodmallproduct.prodNum}">상품삭제</a></td>
         </tr>
      </c:forEach>
   </table>
</body>
</html>