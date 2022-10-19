<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> 공지사항 리스트</h2>
<a href="writeNotice.do">공지사항 쓰기</a>
<table border="1">
	<tr>
		<th>글번호</th><th>아이디</th><th>작성자</th><th>제목</th><th>글내용</th><th>조회수</th>
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