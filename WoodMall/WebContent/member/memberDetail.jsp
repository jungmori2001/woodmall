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
	<div>
	<input type="hidden" name="userId" id="userId" value="${member.userId}">
		<p id="checkDelete" style="cursor:pointer;">삭제</p>
	</div>
	</form>
</body>
</html>