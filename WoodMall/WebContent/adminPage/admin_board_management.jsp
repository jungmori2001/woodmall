<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/style.css">
    <title>게시판관리 페이지</title>
</head>
<body>
    <header style="display:flex">
        <div style="flex:10%">
            <img src="../image/logo.jpg" width="70%">
        </div>
        <div style="flex:90%">
            <div style="background-color: white; text-align: right;">
                회원가입
            </div>
            <div class="menubar">
                <ul class="menu">
                    <li>
                        <a href="admin_prod_management.jsp">상품관리</a>
                    </li>
                    <li>
                        <a href="admin_member_management.jsp">회원관리</a>
                    </li>
                    <li>
                        <a href="admin_board_management.jsp">게시판관리</a>
                    </li>
                    <li>
                        <a href="admin_order_management.jsp">주문관리</a>
                    </li>
                </ul>
            </div>
        </div>
    </header>
    <div>
        <h3 style="margin:3%;">게시판관리</h3>
        <table class="table">
            <tr>
                <th>글번호</th>
                <th>작성자</th>
                <th>제목</th>
                <th>관리</th>
            </tr>
            <tr>
                <td>1</td>
                <td>2</td>
                <td>3</td>
                <td><input type="button" class="btn" value="글보기">
                    <input type="button" class="btn" value="삭제"></td>
            </tr>
            
        </table>
    </div>
    <div>
        <input type="button" class="btn writebtn" value="관리자 메인" onClick="location.href='admin_main.jsp'"style="float:left;">
        <input type="button" class="btn writebtn" value="글쓰기">
    </div>
</body>
</html>