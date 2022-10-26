<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<h1>주문이 완료 되었습니다.</h1>
	<h3>감사합니다.</h3>	
	</div>
	<div>
		<h4>주문 내역</h4>
		<div align="center">
		<c:forEach var="product" items="productList">
			결제 방식 : ${product.payment}<br>
			총 결제 금액 : ${product.price}
			</c:forEach>
		</div>
	</div>

</body>
</html>