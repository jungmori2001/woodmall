<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>주문 상세 확인</h2>
	<table>
	<tr>
		<th>주문번호</th><td>${ordermanager.orderNum}</td>
	</tr>
	<tr>
		<th>상품 이름</th><td>${woodmallproduct.prodName}</td>
	</tr>
	<tr>
		<th>수량</th><td>${ordermanager.orderQuen}</td>
	</tr>
	<tr>
		<th>배송지 정보</th>
	</tr>
	<tr>
		<th>받는사람</th><td>123</td>
	</tr>
	<tr>
		<th>전화번호</th><td>123</td>
	</tr>
	<tr>
		<th>배송지 주소</th><td>123</td>
	</tr>
	<tr>
		<th>배송지 상세 주소</th><td>123</td>
	</tr>
	<tr>
		<th>주문자 정보</th>
	</tr>
	<tr>
		<th>이메일</th><td>123</td>
	</tr>
	<tr>
		<th>전화번호</th><td>123</td>
	</tr>
	<tr>
		<th>기타 요구사항</th><td>123</td>
	</tr>
	<tr>
		<th>결제정보</th><td>123</td>
	</tr>
	<tr>
		<th>결제방법</th><td>${ordermanager.paymentStatus}</td>
	</tr>
	<tr>
		<th>입금자명</th><td>${ordermanager.name }</td>
	</tr>
	<tr>
		<th>주문상태</th><td>${ordermanager.orderStatus}</td>
	</tr>
	</table>
	<input type="submit" value="수정" onClick="location.href='orderDeail.do?orderNum=${woodmallnotice.noticeNum}'">
	<input type="reset" value="취소">
</body>
</html>