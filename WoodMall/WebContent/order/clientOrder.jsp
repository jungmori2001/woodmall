<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Woodmall : 주문/결제</title>
</head>
<body>
	<form action="#" form="frm" metho="post">
		<header class="orderBody">
			<div id="header">주문 / 결제</div>
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
							<td><input type="text" name="name" placeholder="50자 이내로 작성"
								style="width: auto;"></td>
						</tr>
						<tr>
							<td align="center">연락처</td>
							<td><input type="text" name="phoneNum"
								placeholder="'-' 포함해서 적어주세요"></td>
						</tr>
						<tr>
							<td rowspan="3" align="center">주소</td>
							<td><input type="text" id="postNum" placeholder="우편번호">
								<input type="button" onclick="getPostCode()" value="우편번호 찾기">
							</td>

						</tr>
						<tr>
							<td><input type="text" id="mainAddress" placeholder="주소">
							</td>
						</tr>
						<tr>
							<td><input type="text" id="detailAddress" placeholder="상세주소">
								<input type="text" id="subAddress" placeholder="참고항목"
								size="20px"></td>
						</tr>

					</table>
				</fieldset>
			</div>
			<br>
			<br>
		</header>
		<article>
			<div>
				<fieldset id="productSide">
					<legend id="productName"> 상품명 </legend>
					<div style="display: flex">
						<div style="flex: 50%" align="center">
							<img src="upload/${product.image}" width="50px">
						</div>

						<div align="right" style="flex: 50%">
							<div>${product.prodName}</div>
							<div>${product.Quantity}</div>
							<div>${product.price}</div>

						</div>
					</div>
					<hr>
				</fieldset>

			</div>
			</div>
			<div style="display: flex;">

				<div style="flex: 50%"></div>
				<div id="payDetailLayor">
					<strong>결제 상세</strong>
					<hr class="totalHr">
					<div class="payDetail">
						<div class="payDetailLeft">주문 금액</div>
						<div class="payDetailRight">${totalPrice}</div>
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
						<div class="payDetailRight">${totalPrice}</div>
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

		<foodter> <br>

		<div class="order_btn">
			<a href="#"
				onclick="window.open('주소입력','','width=400px,height=600px')">주&nbsp;&nbsp;&nbsp;&nbsp;문</a>
		</div>
		</foodter>
	</form>
</body>
</html>