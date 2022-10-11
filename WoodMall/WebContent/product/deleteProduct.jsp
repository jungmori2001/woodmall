<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 삭제 페이지</title>
<link rel="stylesheet" type="text/css" href="css/product.css">
</head>
<body>
<h2>상품 삭제 페이지</h2>

<form action="deleteProduct.do" method="post">
<div>
<table border="1">
	<tr>
		<td width="20%">
			<c:choose>
				<c:when test="${empty product.pictureurl}">
					<img src="image/noimage.jpg">
				</c:when>
				<c:otherwise>
					<img src="upload/${product.pictureurl}">
				</c:otherwise>
			</c:choose>
		</td>
		<tr>
			<th>상품명</th>
			<td>${product.name}</td>
		</tr>
		<tr>
			<th>가격</th>
			<td>${product.price}</td>
		</tr>
		<tr>
			<th>설명</th>
			<td height="150px">${product.description}</td>
		</tr>
		<tr>
			<th>등록일자</th>
			<td>${product.reg_date}</td>
		</tr>
	</tr>
</table>
<input type="hidden" name="code" value="${product.code}">
<input type="submit" value="삭제">
<input type="button" value="목록" onClick="location.href='productList.do'">
</form>
</div>
</body>
</html>