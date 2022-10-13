<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<link rel="stylesheet" href="./css/style.css">
<body>
<header style="display:flex">
        <div style="flex:10%">
            <img src="./image/logo.jpg" width="70%">
        </div>
        <div style="flex:90%">
            <div style="background-color: white; text-align: right;">
                <a href="#">로그인</a>
                <a href="#">회원가입</a>
            </div>
            <div class="menubar">
                <ul class="menu">
                    <li>
                        <a href="#">소개</a>
                    </li>
                    <li>
                        <a href="#">가구</a>
                        <ul class="submenu">
                            <li><a href="clientProduct.do?kind='책상'">책상</a></li>
                            <li><a href="clientProduct.do?kind='의자'">의자</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">고객센터</a>
                    </li>
                </ul>
            </div>
        </div>
    </header>
</body>
</html>