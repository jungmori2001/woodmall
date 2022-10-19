<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
 <link rel="stylesheet" href="./css/adminPage.css">
<style>
	.admin_menu{
    height: 700px;
}
.admin_menu > ul {
    position: relative;
    left: 39%; top:35%;
    font-size:30px;
    display:inline-block;
    color:white;
}
.admin_menu > ul >li {
    margin-top: 50px;
    border: 2px solid black;
    text-align: center;
}
.admin_menu > ul >li:hover{
    background-color: gray;
    color:white;
    transition-duration: 0.7s;
}
.admin_menu > ul > li > a{
    color:grey;
}
.admin_menu > ul > li > a:hover{
    color:black;
    transition-duration: 0.7s;
}

</style>
</head>
<body>
<div>
<ul>
	<li><a href="memberList.do">관리자 회원관리 페이지</a></li>
	<li><a href="orderList.do">관리자 주문관리 페이지</a></li>
	<li><a href="productList.do">상품 페이지</a></li>
	<li><a href="noticeList.do">관리자 게시판 페이지</a></li>
	</ul>
</div>

</body>
</html>