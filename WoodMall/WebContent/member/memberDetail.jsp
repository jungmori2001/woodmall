<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="./script/memberCheck.js"></script>
<title>Insert title here</title>
</head>
<body>
<title>회원 정보 확인</title>
</head>
<body>
<table>
	<tr>
		<td>이름</td>
		<td><input type="text" name="name" value="${member.name}" readonly>*</td>
	</tr>
	<tr>
		<td>아이디</td>
		<td><input type="text" name="userid" value="${member.userId}" readonly>*</td>
	</tr>
	<tr>
		<td>암호</td>
		<td><input type="password" name="password" value="${member.password}" readonly >*</td>
	</tr>
	<tr>
		<td>이메일아이디</td>
		<td><input type="text" name="emailId" value="${member.emailId}" readonly></td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td><input type="text" name="firstPhone" value="${member.firstPhone}" readonly></td>
		<td><input type="text" name="midPhone" value="${member.midPhone}" readonly ></td>
		<td><input type="text" name="lastPhone" value="${member.lastPhone}" readonly></td>
	</tr>
	<tr>
		<td>주소</td>
		<td><input type="text" name="mainAddress" value="${member.mainAddress}" readonly></td>
		<td><input type="text" name="detailAddress" value="${member.detailAddress}" readonly></td>
		<td><input type="text" name="subAddress" value="${member.subAddress}" readonly></td>
	</tr>
	<div>
	<input type="hidden" name="userId" id="userId" value="${member.userId}">
		<p id="checkDelete" style="cursor:pointer;">삭제</p>
	</div>
	</form>
</body>
</html>