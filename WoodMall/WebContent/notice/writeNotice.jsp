<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 등록</title>
<link rel="stylesheet" type="text/css" href="css/product.css">
<link rel="stylesheet" href="./css/adminPage.css">
<script type="text/javascript" src="./script/product.js"></script>
</head>
<body>
	<h2>공지사항 쓰기</h2>

	<form method="post" name="frm">
		<table border="1" class="list">
			<tr>
				<th>아이디</th>
				<td><input type="text" name="userId" value="${loginUser.userId}"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="name" value="${loginUser.name}"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="noticeTitle"></td>
			</tr>
			<tr>
				<th>글 내용</th>
				<td><textarea rows="10" cols="80" name="noticeContent"
						placeholder="글을 작성하세요."></textarea></td>
			</tr>
		</table>
		<br> <input type="submit" value="등록"> <input type="reset"
			value="취소"> <input type="button" value="목록"
			onclick="location.href='noticeList.do'">
	</form>

</body>
</html>