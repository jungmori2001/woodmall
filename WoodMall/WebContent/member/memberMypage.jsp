<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="../script/memberMypage.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<title>회원 정보 확인</title>
</head>
<body>
<table>

	<tr>
		<td>이름</td>
		<td><input type="text" name="name" value="${loginUser.name}" readonly>*</td>
	</tr>
	<tr>
		<td>아이디</td>
		<td><input type="text" name="userid" value="${loginUser.userId}" readonly>*</td>
	</tr>
	<tr>
		<td>암호</td>
		<td><input type="password" name="password" value="${loginUser.password}" readonly >*</td>
	</tr>
	<tr>
		<td>이메일아이디</td>
		<td><input type="text" name="emailId" value="${loginUser.emailId}" readonly></td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td><input type="text" name="firstPhone" value="${loginUser.firstPhone}" readonly></td>
		<td><input type="text" name="midPhone" value="${loginUser.midPhone}" readonly ></td>
		<td><input type="text" name="lastPhone" value="${loginUser.lastPhone}" readonly></td>
	</tr>
	<tr>
		<td>주소</td>
		<td><input type="text" name="mainAddress" value="${loginUser.mainAddress}" readonly></td>
		<td><input type="text" name="detailAddress" value="${loginUser.detailAddress}" readonly></td>
		<td><input type="text" name="subAddress" value="${loginUser.subAddress}" readonly></td>
	</tr>
		<tr>
		<td colspan="2" align="center">
		<a href="index.jsp">확인</a>
		<a href="updateMember.do">수정</a>
		
		</td>
		
</table>
	


</body>
</html>