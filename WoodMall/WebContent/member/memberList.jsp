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
<h2>회원 리스트</h2>
<a href="adminIndexPage.jsp" class="item-link" id="pageLink" >
	<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
		<path stroke-linecap="round" stroke-linejoin="round" d="M2.25 12l8.954-8.955c.44-.439 1.152-.439 1.591 0L21.75 12M4.5 9.75v10.125c0 .621.504 1.125 1.125 1.125H9.75v-4.875c0-.621.504-1.125 1.125-1.125h2.25c.621 0 1.125.504 1.125 1.125V21h4.125c.621 0 1.125-.504 1.125-1.125V9.75M8.25 21h8.25" />
	</svg>
</a>
<table id="wrap">
	<tr>
		<th style=width:10%;>회원 이름</th>
		<th style=width:15%;>아이디</th>
		<th style=width:20%>전화번호</th>
		<th style=width:5%;>상세</th>
		<th style=width:5%;>수정</th>
	</tr>
	<c:forEach var = "memberList" items="${memberList}">
		<tr>
			<td>${memberList.name}</td>
			<td>${memberList.userId}</td>
			<input type="hidden" name="userId" id="userId" value="${memberList.userId}">
			<td>${memberList.firstPhone} - ${memberList.midPhone} - ${memberList.lastPhone}</td>
			<td> <a href="memberDetail.do?userId=${memberList.userId}">상세</a></td>
			<td><a href="adminUpdateMember.do?userId=${memberList.userId}">수정</a></td>		
		</tr>
	</c:forEach>
	
</table>

</body>
</html>