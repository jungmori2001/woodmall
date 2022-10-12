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
<%@ include file="../baseLayout/header.jsp" %>
	<div class="products" id="wrapper">
		<h3>Chair</h3>
		<hr>
		<div class="product-list">
			<c:forEach var="product" items="${productList}">
				<a href="productDetail.do?code='${product.prodNum}'" class="product">
					<img src="/upload/${image}" width="225">
					<div class="product-name">${product.prodName}</div>
					<div class="product-price">${product.price}</div>
				</a>
			</c:forEach>
		</div>
	</div>
<%@ include file="../baseLayout/footer.jsp" %>
</body>
</html>