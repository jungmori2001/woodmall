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
<a href="#">상품 등록</a>
<table border="1">
	<tr>
		<th>코드</th><th>분류</th><th>사진</th><th>이름</th><th>가격</th><th>등록일자</th><th>상세</th><th>수정</th><th>삭제</th>
	</tr>
	
	<c:forEach var="woodmallproduct" items="${productList2}">
		<tr>
			<td>${woodmallproduct.prodnum}</td>
			<td>${woodmallproduct.kind}</td>
			<td>${woodmallproduct.image}</td>
			<td>${woodmallproduct.prodname}</td>
			<td>${woodmallproduct.price}</td>
			<td>${woodmallproduct.reg_date}</td>
			<td>상품상세</td>
			<td>상품수정</td>
			<td>상품삭제</td>
		</tr>
	</c:forEach>	
</table>

</body>
</html>