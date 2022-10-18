<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="./script/orderDetail.js"></script>
</head>
<body>

	<h2>주문 상세 확인</h2>
	<form action="updateOrder.do" method ="post" name="frm">
	<table>
	<tr>
		<th>주문번호</th><td>${ordermanager.orderNum}</td>
	</tr>
	<tr>
		<th>상품 이름</th><td>${ordermanager.prodName}</td>
	</tr>
	<tr>
		<th>수량</th><td>${ordermanager.orderQuen}</td>
	</tr>
	<tr>
		<th>배송지 정보</th>
	</tr>
	<tr>
		<th>받는사람</th><td>${ordermanager.name}</td>
	</tr>
	<tr>
		<th>전화번호</th><td>${ordermanager.firstPhone} ${ordermanager.midPhone} ${ordermanager.lastPhone}</td>
	</tr>
	<tr>
		<th>배송지 주소</th><td>${ordermanager.postNum}</td>
	</tr>
	<tr>
		<th>배송지 상세 주소</th><td>${ordermanager.mainAddress} ${ordermanager.detailAddress} ${ordermanager.subAddress}</td>
	</tr>
	<tr>
		<th>주문자 정보</th>
	</tr>
	<tr>
		<th>이메일</th><td>${ordermanager.emailId} @ ${ordermanager.emailAddress}</td>
	</tr>
	<tr>
		<th>기타 요구사항</th><td>${ordermanager.orderContent}</td>
	</tr>
	<tr>
		<th>결제정보</th>
	</tr>
	<tr>
		<th>결제방법</th><td>${ordermanager.paymentStatus}</td>
	</tr>
	<tr>
		<th>입금자명</th><td>${ordermanager.name}</td>
	</tr>
	<tr>
		 
		<th>주문상태</th>
		<section id="section2">
		<td>
		
			<select id="status-select">			
				<option value="배송준비중">배송준비중</option>
				<option value="배송중">배송중</option>
				<option value="배송완료">배송완료</option>
			</select>
			<input type="button" class="change-button" value="변경"  id="text">
		</td>
		
		</section>
	</tr>
	<p id="demo"></p>
	</table>
	
	
	<input type="text" id="status-input" name="orderStatus" value=${ordermanager.orderStatus}>
	<input type="button" value="목록" onClick="location.href='orderList.do'">
	<input type="submit" value="수정">
	<input type="reset" value="취소">
	</form>
</body>

</html>