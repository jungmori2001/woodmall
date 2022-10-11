<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> 전체상품 리스트</h2>
<a href="writeProduct.do">상품 등록</a>
<table border="1">
	<tr>
		<th>코드</th><th>분류</th><th>사진</th><th>이름</th><th>가격</th><th>등록일자</th><th>상세</th><th>수정</th><th>삭제</th>
	</tr>
	
	<c:forEach var="woodmallproduct" items="${productList}">
		<tr>
			<td>${woodmallproduct.prodNum}</td>
			<td>${woodmallproduct.kind}</td>
			<td><img style="width:30px; height:30px;" src="upload/${woodmallproduct.image}"></td>
			<td>${woodmallproduct.prodName}</td>
			<td>${woodmallproduct.price}</td>
			<td>${woodmallproduct.reg_date}</td>
			<td><a href="productDetail.do?prodnum=${woodmallproduct.prodNum}">상품상세</a></td>
			<td><a href="updateProduct.do?prodnum=${woodmallproduct.prodNum}">상품수정</a></td>
			<td><a href="deleteProduct.do?prodnum=${woodmallproduct.prodNum}">상품삭제</a></td>
		</tr>
	</c:forEach>	
</table>

</body>
</html>