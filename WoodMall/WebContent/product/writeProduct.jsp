<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록 페이지</title>
<link rel="stylesheet" type="text/css" href="css/product.css">
<script type="text/javascript" src="./script/product.js"></script>
</head>
<body>
	<h2>상품 등록</h2>

	<form method="post" enctype="multipart/form-data" name="frm">
		<div id="wrap">
			<table border="1" class="list">
				<tr>
					<th>상품명</th>
					<td><input type="text" name="prodName"></td>
					<th>분류</th>
					<td><input type="text" name="kind"></td>
				</tr>
				<tr>
					<th>가격</th>
					<td><input type="text" name="price"></td>
				</tr>
				<tr>
					<th>사진</th>
					<td><input type="file" name="image"></td>
				</tr>
				<tr>
					<th>설명</th>
					<td>
						<!--<input type="text" name="description">--> <textarea rows="10"
							cols="80" name="content" placeholder="상품 설명을 작성하세요."></textarea>
					</td>
				</tr>
				<tr>
					<th>등록일자</th>
					<td><input type="text" name="reg_date"
						placeholder="0000-00-00">(예시)</td>
				</tr>
			</table>
			<br> <input type="submit" value="등록"
				onclick="return checkProduct()"> <input type="reset"
				value="취소"> <input type="button" value="목록"
				onclick="location.href='productList.do'">
		</div>
	</form>

</body>
</html>