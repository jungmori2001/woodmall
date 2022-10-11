<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/product.css">
<title>상품 상세 페이지</title>
</head>
<body>
<div id="wrap" align="center">
<h2>상품 상세 페이지</h2>
<table class="list" border="1">
	<tr>
		<td style="width: 300px;" >
			<c:choose>
				<c:when test="${empty woodmallproduct.image}">
					<img src="image/noimage.jpg">
				</c:when>
				<c:otherwise>
					<img src="upload/${woodmallproduct.image}">
				</c:otherwise>
			</c:choose>
		</td>
		<tr>
			<th>상품명</th>
			<td>${woodmallproduct.prodName}</td>
		</tr>
		<tr>
			<th>가격</th>
			<td>${woodmallproduct.price}</td>
		</tr>
		<tr>
			<th>설명</th>
			<td style="height:220px; width:100%;">
				<div>${woodmallproduct.content}</div>
			</td>
		</tr>
		<tr>
			<th>등록일자</th>
			<td>${woodmallproduct.reg_date}</td>
		</tr>
	</tr>
</table>
<input type="button" value="목록" onClick="location.href='productList.do'">
</div>
</body>
</html>