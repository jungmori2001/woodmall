<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>공지 수정 페이지</h2>
	<form action="updateNotice.do" method="post" name="frm">
		<table class="list" border="1">
			<tr>
			<tr>
				<th>글 번호</th>
				<td>${woodmallnotice.noticeNum}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="noticeTitle"
					value="${woodmallnotice.noticeTitle}"></td>
			</tr>
			<tr>
				<th>글 내용</th>
				<td style="height: 220px; width: 100%;"><input type="text"
					name="noticeContent" value="${woodmallnotice.noticeContent}">
				</td>
			</tr>
			</tr>
		</table>
		<input type="hidden" name="noticeNum" value="${woodmallnotice.noticeNum}"> 
		<input type="submit" value="수정"> <input type="reset" value="리셋">
			<input type="button" value="목록" onClick="location.href='noticeList.do'">
	</form>
</body>
</html>