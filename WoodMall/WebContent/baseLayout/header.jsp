<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
            <a href="index.jsp"><img src="./image/logo.jpg" width="70%"></a>
        </div>
            <div style="flex:90%">
            <div style="background-color: white; text-align: right;">
            
            <c:set var="userId" scope="session" value="${loginUser}"/>
            <c:if test="${empty userId}">
            	<a class="header_link" href="login.do">로그인</a>
                <a class="header_link" href="join.do">회원가입</a>
            </c:if>
            <c:if test="${userId!=null}">
            <p>${loginUser.name}(${loginUser.userId})님</p>
            <a class="header_link" href="logout.do">로그아웃</a>	
             <a class="header_link" href="memberMypage.do">마이페이지</a>
             <a class="header_link" href="clientCart.do?userId=${loginUser.userId}">장바구니</a>	 
             </c:if>						
            <c:set var="admin" value="${loginUser.userId}"/>
            <c:if test="${admin=='admin'}">
                  	<a href="adminIndexPage.jsp">관리자페이지로</a>
            </c:if>
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
                        <a class="header_link" href="noticePage.do">고객센터</a>
                    </li>
                </ul>
            </div>
        </div>
    </header>
</body>
</html>