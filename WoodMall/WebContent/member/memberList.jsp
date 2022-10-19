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
<h2>회원 리스트</h2>
<table border='1';>
	<tr>
		<th>회원 이름</th><th>아이디</th><th>전화번호</th><th>상세</th><th>수정</th><th>삭제</th>
	</tr>
	<c:forEach var = "memberList" items="${memberList}">
		<tr>
			<td>${memberList.name}</td>
			<td>${memberList.userid}</td>
			<td>${memberList.firstPhone}-${memberList.midPhone}-${memberList.lastPhone}</td>
			<td>상세</td>
			<td>수정</td>
			<td>삭제</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>