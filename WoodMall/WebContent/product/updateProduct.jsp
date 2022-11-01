<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/product.css">
 <link rel="stylesheet" href="./css/adminPage.css">
<title>상품 수정 페이지</title>
</head>
<body>
<h2>상품 수정 페이지</h2>
<form action="updateProduct.do" method="post" enctype="multipart/form-data" name="frm">
<table border="1">
	<tr>
		<td style="width:20%; colspan=2;" >
			<c:choose>
				<c:when test="${empty woodmallproduct.image}">
					<img src="image/noimage.jpg">
				</c:when>
				<c:otherwise>
					<img src="upload/${wouctodmallprod.image}">
				</c:otherwise>
			</c:choose>
		</td>
		<tr>
			<th>상품명</th>
			<td><input type="text" name="prodName" value="${woodmallproduct.prodName}"></td>
		</tr>
		<tr>
			<th>가격</th>
			<td><input type="text" name="price" value="${woodmallproduct.price}"></td>
		</tr>
		<tr>
			<th>사진</th>
			<td><input type="file" name="image"></td>
		</tr>
		<tr>
			<th>설명</th>
			<td><textarea rows="10" cols="80" name="content">${woodmallproduct.content}</textarea></td>
		</tr>
		<tr>
			<th>등록일자</th>
			<td><input type="text" name="reg_date" value="${woodmallproduct.reg_date}"></td>
		</tr>
	</tr>
</table>
<input type="hidden" name="prodnum" value="${woodmallproduct.prodNum}">
<input type="submit" value="수정" class="btn">
<input type="reset" value="취소" class="btn">
<input type="button" value="목록" onClick="location.href='productList.do'" class="btn">
</form>
</body>
</html>