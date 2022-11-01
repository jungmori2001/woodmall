<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<script type="text/javascript" src="script/member.js"></script>
</head>
<body>
<h2>회원 정보 수정</h2>
'*' 표시 항목은 필수 입력 항목입니다.

<form action="updateMember.do" method="post" name="frm">
<table>
	<tr>
		<td>이름</td>
		<td><input type="text" name="name" value="${member.name}" readonly>*</td>
	</tr>
	<tr>
		<td>아이디</td>
		<td><input type="text" name="userId" value="${member.userId}" readonly>*</td>
	</tr>
	<tr>
		<td>암호</td>
		<td><input type="text" name="password" value="${member.password}">*</td>
	</tr>
	<tr>
		<td>암호 확인</td>
		<td><input type="password" name="password">*</td>
	</tr>
	<tr>
		<td>이메일아이디</td>
		<td><input type="text" name="emailId" value="${member.emailId}"></td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td><input type="text" name="firstPhone" value="${member.firstPhone}"></td>
		<td><input type="text" name="midPhone"  value="${member.midPhone}"></td>
		<td><input type="text" name="lastPhone" value="${member.lastPhone}"></td>
	</tr>
	
	<tr>
		<td colspan="2" align="center">
			<!-- 태그에 onclick이 있는 경우, onclick을 먼저 수행하고 href로 이동하는 액션 수행 -->
			<!-- onclick에서 return이 false인 경우 href로 이동하는 액션을 수행하지 않음 -->
			<input type="submit" value="확인" onclick="return checkJoin()"> &nbsp;&nbsp;&nbsp;
			<input type="reset" value="취소">
		</td>
	</tr>
</table>
	
</form>

</body>
</html>
