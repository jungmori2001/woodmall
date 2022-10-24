<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	margin-left: 10px;
	margin-right: 10px;
	margin-bottom: 30px;
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
	<div class="products" id="wrapper">
		<div class="product-list">
			<c:forEach var="product" items="${productList}">
				<a href="./clientProductDetail.do?prodNum=${product.prodNum}"
					class="product"> <c:choose>
						<%-- 이미지가 서버에 존재하지 않는 경우 --%>
						<c:when test="${empty product.image}">
							<img src="image/no.png" width="225px">
						</c:when>
						<%-- 이미지가 서버에 존재하는 경우 --%>
						<c:otherwise>
							<img src="upload/${product.image}" width="225px">
						</c:otherwise>
					</c:choose>

					<div class="product-name">${product.prodName}</div>
					<div class="product-price"><fmt:formatNumber value="${product.price}"
									pattern="#,###" /> 원</div>
				</a>
			</c:forEach>
		</div>
	</div>

   
	<%@ include file="../baseLayout/footer.jsp"%>
</body>
</html>