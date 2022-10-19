<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="./css/adminPage.css">
<title>주문 조회</title>
</head>
<body>
	<h2>주문 조회</h2>
	<table border="1">
		<tr>
			<th>주문번호</th>
			<th>이름</th>
			<th>개수</th>
			<th>결제방식</th>
			<th>가격</th>
			<th>주문날짜</th>
			<th>주문상태</th>
			<th>수정</th>
			<th>상세</th>
		</tr>
		<c:forEach var="ordermanager" items="${orderList}">
			<tr>
				<td>${ordermanager.orderNum}</td>
				<td>${ordermanager.name}</td>
				<td>${ordermanager.orderQuen}</td>
				<td>${ordermanager.paymentStatus}</td>
				<td>${ordermanager.price}</td>
				<td>${ordermanager.orderDate}</td>
				<td>${ordermanager.orderStatus}</td>
				<td><a href="updateOrder.do?orderNum=${ordermanager.orderNum}">수정</a></td>
				<td><a href="orderDetail.do?orderNum=${ordermanager.orderNum}">상세</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>