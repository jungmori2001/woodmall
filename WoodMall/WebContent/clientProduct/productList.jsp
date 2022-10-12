<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Woodmall : ${product.kind}</title>
</head>
<link rel="stylesheet" href="../css/productList.css">

<body>
<%@ include file="../baseLayout/header.jsp" %>

	<div class="products" id="wrapper">
		<div align="center">
		<h3>Chair</h3>
</div>
		<div class="product-list">
			<a href="#" class="product"> <img src="/image/chair.jpg"
				width="225">
				<div class="product-name">${product.prodName}</div>
				<div class="product-price">${product.price}</div>
			</a>
		</div>
		
		<%@ include file="../baseLayout/footer.jsp" %>
</body>
</html>