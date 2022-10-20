<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<style>
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

.header_link {
    text-decoration: none;
}

header > ul, li {
	list-style:none;
}

.header_menu {
    font-family: fantasy;
    float: right;
    display: flex;
    width: 100%;
    overflow: hidden;
    margin: auto;
}

.header_menu>li {
    width: 40%;
    /*20*2=40%*/
    float: left;
    text-align: center;
    line-height: 50px;
    /*background-color: beige;*/
}

.header_menu a {
    color: sienna;
}

.header_submenu>li {
    line-height: 50px;
    background-color: azure;
}

.header_submenu {
    height: 0;
    /*ul의 높이를 안보이게 처리*/
    overflow: hidden;

}

.header_menu>li:hover {
    background-color: skyblue;
    transition-duration: 0.5s;
}

.header_menu>li:hover .header_submenu {
    height: 100px;
    /*서브메뉴 li한개의 높이 50*2*/
    transition-duration: 0.5s;
    background-color: white;
}
</style>
<body>
<header style="display:flex">
        <div style="flex:10%">
            <img src="./image/logo.jpg" width="70%">
        </div>
        <div style="flex:90%">
            <div style="background-color: white; text-align: right;">
                <a class="header_link" href="login.do">로그인</a>
                <a class="header_link" href="join.do">회원가입</a>
            </div>
            <div class="header_menubar">
                <ul class="header_menu">
                    <li>
                        <a class="header_link" href="#">소개</a>
                    </li>
                    <li>
                        <a class="header_link" href="#">가구</a>
                        <ul class="header_submenu">
                            <li><a class="header_link" href="./clientProductList.do?kind='책상'">책상</a></li>
                            <li><a class="header_link" href="./clientProductList.do?kind='의자'">의자</a></li>
                        </ul>
                    </li>
                    <li>
                        <a class="header_link" href="#">고객센터</a>
                    </li>
                </ul>
            </div>
        </div>
    </header>
</body>
</html>