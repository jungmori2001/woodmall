<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel ="stylesheet" href="../css/style.css">
    <style>
    /* admin_main.html */ 
.admin_menu{
    height: 700px;
}
.admin_menu > ul {
    position: relative;
    left: 45%; top:35%;
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
    <title>Document</title>
</head>
<body>
    <div class="admin_menu">
        <ul>
            <li><a href="admin_prod_management.jsp">상품 관리</a></li>
            <li><a href="admin_member_management.jsp">회원 관리</a></li>
            <li><a href="admin_board_management.jsp">게시판 관리</a></li>
            <li><a href="admin_order_management.jsp">주문 관리</a></li>
        </ul>
    </div>
</body>
</html>