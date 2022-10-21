<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지</title>
<script type="text/javascript" src="script/member.js"></script>
</head>
<body>
<h2>마이 페이지</h2>

<form action="memberMyPage.do" name="frm">
<table>
	<tr>
		<td>이름</td>
		<td><input type="text" name="name" value="${loginUser.name}" readonly>*</td>
	</tr>
	<tr>
		<td>아이디</td>
		<td><input type="text" name="userid" value="${loginUser.userid}" readonly>*</td>
	</tr>
	<tr>
		<td>암호</td>
		<td><input type="password" name="password" value="${loginUser.password}" >*</td>
	</tr>
	<tr>
		<td>암호 확인</td>
		<td><input type="password" name="password" value="${loginUser.password}" >*</td>
	</tr>
	<tr>
		<td>이메일</td>
		<td><input type="text" name="emailId" value="${loginUser.emailId}"></td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td><input type="text" name="firstPhone" value="${loginUser.firstPhone}"></td>
		<td><input type="text" name="midPhone"  value="${loginUser.midPhone}" ></td>
		<td><input type="text" name="lastPhone" value="${loginUser.lastPhone}" ></td>
	</tr>
	
	
</table>
	
</form>

</body>
</html>
