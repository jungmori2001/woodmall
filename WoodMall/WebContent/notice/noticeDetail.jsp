<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" href="./css/adminPage.css">
<title>Insert title here</title>
</head>
<body>
<table class="list" border="1">
	<tr>
		<tr>
			<th>글 번호</th>
			<td>${woodmallnotice.noticeNum}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${woodmallnotice.name}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${woodmallnotice.noticeTitle }</td>
		</tr>
		<tr>
			<th>글 내용</th>
			<td style="height:220px; width:100%;">
				<div>${woodmallnotice.noticeContent}</div>
			</td>
		</tr>
	</tr>
</table>
<input type="button" value="목록" onClick="location.href='noticeList.do'">
<input type="button" value="수정" onClick="location.href='updateNotice.do?noticeNum=${woodmallnotice.noticeNum}'">
<input type="button" value="삭제" onClick="location.href='deleteNotice.do?noticeNum=${woodmallnotice.noticeNum}'">
</body>
</html>