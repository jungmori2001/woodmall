<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="./css/adminPage.css">
<title>Insert title here</title>
</head>
<body>
<h2> 공지사항 리스트</h2>
<a href="writeNotice.do">공지사항 쓰기</a>
<table border="1">
	<tr>
		<th style=width:5%;>글번호</th>
		<th style=width:10%;>아이디</th>
		<th style=width:10%;>작성자</th>
		<th style=width:15%;>제목</th>
		<th style=width:30%;>글내용</th>
		<th style=width:5%;>조회수</th>
	</tr>
	
	<c:forEach var="woodmallnotice" items="${noticeList}">
		<tr>
			<td>${woodmallnotice.noticeNum}</td>
			<td>${woodmallnotice.userId}</td>
			<td>${woodmallnotice.name}</td>
			<td><a href="noticeDetail.do?noticeNum=${woodmallnotice.noticeNum}">${woodmallnotice.noticeTitle}</a></td>
			<td>${woodmallnotice.noticeContent}</td>
			<td>${woodmallnotice.noticeHits}</td>
		</tr>
	</c:forEach>	
</table>

</body>
</html>