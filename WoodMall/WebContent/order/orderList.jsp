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
	<a href="adminIndexPage.jsp" class="item-link" id="pageLink" >
	<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
		<path stroke-linecap="round" stroke-linejoin="round" d="M2.25 12l8.954-8.955c.44-.439 1.152-.439 1.591 0L21.75 12M4.5 9.75v10.125c0 .621.504 1.125 1.125 1.125H9.75v-4.875c0-.621.504-1.125 1.125-1.125h2.25c.621 0 1.125.504 1.125 1.125V21h4.125c.621 0 1.125-.504 1.125-1.125V9.75M8.25 21h8.25" />
	</svg>
</a>

	<table border="1">
		<tr>
			<th>주문번호</th>
			<th>아이디</th>
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
				<td>${ordermanager.userId}</td>
				<td>${ordermanager.orderQuan}</td>
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