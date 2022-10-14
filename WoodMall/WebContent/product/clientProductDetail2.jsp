<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WoodMall : ${product.prodName}</title>
</head>
<link rel="stylesheet" type="text/css" href="../css/clientProductDetail.css">
<script type="text/javascript" src="../script/product.js"></script>

<body>
	<%@ include file="../baseLayout/header.jsp"%>
	<div id="wrap" align="center">
<form action="deleteProduct.do" method="post">
<h2>상품삭제</h2>
<table>
		<tr>
			<td rowspan="5" width="200px">
				<c:choose>
					<%-- 이미지가 서버에 존재하지 않는 경우 --%>
					<c:when test="${empty product.pictureurl}">
						<img src="image/no.png" width="150px">
					</c:when>
					<%-- 이미지가 서버에 존재하는 경우 --%>
					<c:otherwise>
						<img src="upload/${product.pictureurl}" width="200px">
					</c:otherwise>
				</c:choose>
			</td>
		</tr>

		<tr>
			<th width="80px">상품명</th>
			<td>${product.name}</td>
		</tr>
		<tr>
			<th>가격</th>
			<td>${product.price}</td>
		</tr>

		

	</table>
	<input type="hidden" name="code" value="${product.code}">
	<input type="submit" value="삭제">	
	<input type="button" value="목록 이동" onclick="location.href='productList.do'">
</form>
</div>

	<div class="tab">
		<button class="tablinks" onclick="openTap(event, 'pro_detail')">제품상세</button>
		<button class="tablinks" onclick="openTap(event, 'review')">리뷰</button>
		<button class="tablinks" onclick="openTap(event, 'qna')">QNA</button>
	</div>

	<!-- Tab content -->
	<div id="pro_detail" class="tabcontent">
		<h3>제품상세</h3>
		<p>London is the capital city of England.</p>
	</div>

	<div id="review" class="tabcontent">
		<h3>리뷰</h3>
		<p>Paris is the capital of France.</p>
	</div>

	<div id="qna" class="tabcontent">
		<h3>QNA</h3>
		<p>Tokyo is the capital of Japan.</p>
	</div>
	<%@ include file="../baseLayout/footer.jsp"%>
</body>
<script>
    window.onload = openTap(event, 'pro_detail');
    </script>
</html>