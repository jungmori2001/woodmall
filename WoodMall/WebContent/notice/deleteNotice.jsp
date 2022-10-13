<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 삭제 페이지</title>
<link rel="stylesheet" type="text/css" href="css/product.css">
</head>
<body>
<h2>공지 삭제 페이지</h2>

<form action="deleteNotice.do" method="post">
<table border="1">
		<tr>
			<th>글번호</th>
			<td>${woodmallnotice.noticeNum}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${woodmallnotice.name}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${woodmallnotice.noticeTitle}</td>
		</tr>
		<tr>
			<th>설명</th>
			<td height="150px">${woodmallnotice.noticeContent}</td>
		</tr>
</table>
<input type="hidden" name="noticeNum" value="${woodmallnotice.noticeNum}">
<input type="submit" value="삭제">
<input type="button" value="목록" onClick="location.href='noticeList.do'">
</form>

</body>
</html>