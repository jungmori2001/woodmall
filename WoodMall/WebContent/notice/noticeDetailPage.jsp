<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="./css/adminPage.css">
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
<input type="button" value="목록" onClick="location.href='noticePage.do'">
</body>
</html>