<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WoodMall : ${product.prodName}</title>
</head>
<link rel="stylesheet" type="text/css"
	href="./css/clientProductDetail.css">
<script type="text/javascript" src="./script/product.js"></script>

<body onload="init()">
	<script type="text/javaScript">
		var sell_price;
		var quantity;

		function init() {
			sell_price = document.form.sell_price.value;
			quantity = document.form.quantity.value;
			document.form.sum.value = sell_price;
			change();
		}

		function add() {
			hm = document.form.quantity;
			sum = document.form.sum;
			hm.value++;

			sum.value = (parseInt(hm.value) * sell_price)
					.toLocaleString('ko-KR');
		}

		function del() {
			hm = document.form.quantity;
			sum = document.form.sum;
			if (hm.value > 1) {
				hm.value--;
				sum.value = (parseInt(hm.value) * sell_price)
						.toLocaleString('ko-KR');

			}
		}

		function change() {
			hm = document.form.quantity;
			sum = document.form.sum;

			if (hm.value < 0) {
				hm.value = 0;
			}
			sum.value = (parseInt(hm.value) * sell_price)
					.toLocaleString('ko-KR');

		}
	</script>

	<%@ include file="../baseLayout/header.jsp"%>
	<article>
		<form action="clientOrder.do" name="form" method="post">
			<div class="article">
				<div class="image" align="center">
					<c:choose>
						<%-- 이미지가 서버에 존재하지 않는 경우 --%>
						<c:when test="${empty product.image}">
							<img src="../image/no.png" width="150px">
						</c:when>
						<%-- 이미지가 서버에 존재하는 경우 --%>
						<c:otherwise>
							<img src="upload/${product.image}" width="200px">
						</c:otherwise>
					</c:choose>
				</div>
				<div class="imp">
					<div class="prodName">
						<h2>${product.prodName}</h2>
					</div>
					<table>
						<tr>
							<td>가격</td>
							<td align="right"><fmt:formatNumber value="${product.price}"
									pattern="#,###" />원</td>
						</tr>
						<tr>
							<td>수량</td>
							<td align="right">
							<input type="hidden" name="userId" value="${loginUser.userId}"> 
							<input type="hidden" name="sell_price" value="${product.price}"> 
								<input class="input" type="text" name="quantity" value="1" size="3" onchange="change();"> 
								<input type="button" value=" + "
								onclick="add();"><input type="button" value=" - "
								onclick="del();"></td>
						</tr>
						<tr>
							<td>총 금액</td>
							<td align="right"><input style="text-align: right"
								class="input" type="text" name="sum" size="11"
								readonly="readonly">원</td>
					</table>
					<input type="hidden" name="prodNum" value="${product.prodNum}">
				</div>
			</div>
			<div align="center">
				<c:set var="quantity" value="1"/>
				<input style="height: 30px" type="button" value="Add to Cart"
					onclick="location.href='./clientProductCart.do?prodNum=${product.prodNum}&quantity=${quantity}&userId=${loginUser.userId}'">
					
				<input style="height: 30px" type="submit" value="구매">
			</div>
		</form>
	</article>

	<div class="tab">
		<button class="tablinks" onclick="openTap(event, 'pro_detail')">제품상세</button>
		<button class="tablinks" onclick="openTap(event, 'review')">리뷰</button>
		<button class="tablinks" onclick="openTap(event, 'qna')">QNA</button>
	</div>

	<!-- Tab content -->
	<div id="pro_detail" class="tabcontent">
		<h3>제품상세</h3>
		<p>${product.prodName} 상세정보</p>
	</div>

	<div id="review" class="tabcontent">
		<h3>리뷰</h3>
		<p>${product.prodName} 리뷰</p>
	</div>

	<div id="qna" class="tabcontent">
		<h3>QNA</h3>
		<p>${product.prodName} QNA</p>
	</div>
	<%@ include file="../baseLayout/footer.jsp"%>
</body>
<script>
	window.onload = openTap(event, 'pro_detail');
</script>
</html>