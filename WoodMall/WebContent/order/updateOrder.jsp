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

	<h2>주문 수정</h2>
	<form action="updateOrder.do" method="post" name="frm">
		<table>
		<tr>
		<th>주문상태</th>
		<section id="section2">
			<td>
				<select id="status-select">
					<option value="배송준비중">배송준비중</option>
					<option value="배송중">배송중</option>
					<option value="배송완료">배송완료</option>
				</select> 
			</td>
			<input type="button" class="change-button" value="변경" id="text">
		</section>
		</tr>
			
		</table>
		<!-- ∇ 자바스크립트로 변경된 값 저장  -->
		<input type="hidden" id="status-input" name="orderStatus" value="${ordermanager.orderStatus}">
		
			<input type="hidden" name="orderNum" value="${ordermanager.orderNum}">
			<input type="button" value="목록" onClick="location.href='orderList.do'">
			<!--form 태그를 이용해 수정버튼을 누르면 updateOrder.do로 이동-->
			<input type="submit" value="수정">
			<input type="reset" value="취소">
			<p id="demo"></p>
	</form>
</body>

</html>