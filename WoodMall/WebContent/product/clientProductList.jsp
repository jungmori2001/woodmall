<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/style.css">
<title>WoodMall : ${kind}</title>
</head>
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Gothic+A1&family=Merriweather:wght@900&display=swap')
	;



.product-list {
	width: auto;
	margin-left: auto;
	margin-right: auto;
}

.products h3 {
	font-size: 24px;
	color: #545454;
	margin-top: 60px;
	margin-bottom: 60px;
	text-align: center;
}

.product {
	display: inline-block;
	width: 225px;
	text-align: center;
	text-decoration: none;
	color: black;
	margin-left: 15px;
	margin-right: 0px;
	margin-bottom: 20px;
}

.product-name {
	margin-top: 20px;
	margin-bottom: 4px;
}
</style>

<body>
<%@ include file="../baseLayout/header.jsp"%>	
	
	<div align="center">
		<div style="margin-top: 20px; margin-bottom: 50px">
			<p>
			<h2>Chair</h2>
			<p>
		</div>
	</div>
	<p>
	<div class="search" align="center">
	
		<form action="searchProduct.do">
			<input type="text" name="keyword" value="${param.keyword}" placeholder="상품명을 검색하세요">
			<input type="submit" value="검색">
		</form>
		
	</div>
	<p>
	<div class="products" id="wrapper">
		<div class="product-list">
			<c:forEach var="product" items="${productList}">
				<a href="./clientProductDetail.do?prodNum=${product.prodNum}"
					class="product"> <c:choose>
						<%-- 이미지가 서버에 존재하지 않는 경우 --%>
						<c:when test="${empty product.image}">
							<img src="./image/no.png" width="200px">
						</c:when>
						<%-- 이미지가 서버에 존재하는 경우 --%>
						<c:otherwise>
							<img src="upload/${product.image}" width="200px">
						</c:otherwise>
					</c:choose>

					<div class="product-name">${product.prodName}</div>
					<div class="product-price">
					<fmt:formatNumber value="${product.price}" pattern="#,###" type="currency" currencySymbol="￦"/> 원</div>
				</a>
			</c:forEach>
		</div>
	</div>

	<%@ include file="../baseLayout/footer.jsp"%>
</body>
</html>