<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/clientProductList.css">

<title>WoodMall : ${productList[kind]}</title>
</head>


<body>
	<%@ include file="../baseLayout/header.jsp"%>
	<div align="center">
	<hr>
	<h3>Chair</h3>
	<hr>
	</div>
		<div class="products" id="wrapper">
			<div class="product-list">
			<c:forEach var="product" items="${productList}">
				<a href="#" class="product"> <img
					src="..upload/${product.image}" width="225">
					<div class="product-name">${product.prodName}</div>
					<div class="product-price">${product.price}</div>
				</a>
				</c:forEach>
			</div>
		</div>
	




	<%@ include file="../baseLayout/footer.jsp"%>
</body>
</html>