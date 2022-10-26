<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Woodmall : 주문/결제</title>
<link rel="stylesheet" type="text/css" href="css/clientOrder.css">
</head>
<body>
	<form action="completeOrder.do" form="frm" method="post">
		<header class="orderBody">
			<div align="center" id="header"><h1>주문 / 결제</h1></div>
			<div>
				<br>
				<br>
				<fieldset class="delivery">
					<legend>
						<strong>배송지</strong>
					</legend>
					<table>
						<br>
						<tr>
							<td align="center">받는분</td>
							<td><input type="text" name="name" value="${userInfo.name}" placeholder="50자 이내로 작성"
								style="width: auto;"></td>
						</tr>
						<tr>
							<td align="center">연락처</td>
							<td>
								<input type="text" name="firstPhone" value="${userInfo.firstPhone}">-
								<input type="text" name="midPhone" value="${userInfo.midPhone}">-
								<input type="text" name="lastphone" value="${userInfo.lastPhone}">
							</td>
						</tr>
						<tr>
							<td rowspan="3" align="center">주소</td>
							<td><input type="text" id="postNum" value="${userInfo.postNum}" placeholder="우편번호">
								<input type="button" onclick="getPostCode()" value="우편번호 찾기">
							</td>

						</tr>
						<tr>
							<td><input type="text" id="mainAddress" value="${userInfo.mainAddress}" placeholder="주소">
							</td>
						</tr>
						<tr>
							<td><input type="text" id="detailAddress" value="${userInfo.detailAddress}" placeholder="상세주소">
								<input type="text" id="subAddress" value="${userInfo.subAddress}" placeholder="참고항목"
								size="20px"></td>
						</tr>
					</table>
				</fieldset>
			</div>
			<br>
			<br>
		</header>
		<article class="orderBody">
		
			<div>
			
				<fieldset id="productSide">
				
					<legend id="productName"> 상품 정보 </legend>
					<input type="hidden" name="userId" value="${userInfo.userId}">
					<input type="hidden" name="prodNum" value="${product.prodNum}">
					<input type="hidden" name="quantity" value="${quantity}">
					<div style="display: flex">
						<div style="flex: 50%" align="center">
							<img src="upload/${product.image}" width="100px">
						</div>

						<div align="right" style="flex: 50%">
							<div>상품명 : ${product.prodName}</div>
							<div>수량 : ${quantity}개</div>
							<div><fmt:formatNumber value="${product.price}"
									pattern="#,###" /> 원</div>

						</div>
					</div>
					<hr>
					
				</fieldset>

			</div>
			
			<div style="display: flex;">

				<div style="flex: 50%"></div>
				<div id="payDetailLayor">
					<strong>결제 상세</strong>
					<hr class="totalHr">
					<div class="payDetail">
						<div class="payDetailLeft">주문 금액</div>
						
						<div class="payDetailRight"><fmt:formatNumber value="${product.price}"
									pattern="#,###" /> 원</div>
					</div>
					<div class="payDetail">
						<div class="payDetailLeft">배송비</div>
						<div class="payDetailRight">무료</div>
					</div>
					<hr class="totalHr">
					<p>
					<div class="payDetail">
						<div class="payDetailLeft">
							<strong>총 결제 금액</strong>
						</div>
						<div class="payDetailRight"><fmt:formatNumber value="${product.price}"
									pattern="#,###" /> 원</div>
					</div>
					</p>
					<hr class="totalHr">
				</div>
			</div>
			<hr>
			<div id="pay">
				<div>
					<strong>결제 수단</strong>
				</div>
				<div>
					<br> <input type="radio" name="pay" value="account_deposit">계좌입금
					<input type="radio" name="pay" value="creditCard">카드결제
				</div>
				
			</div>

		</article>

		<footer class="orderBody"> <br>

		<div align="center" class="order_btn">
			<input type="submit" 
			value="주      문">
		</div>
		</footer>
	</form>
</body>
</html>