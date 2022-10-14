<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 가입</title>
    <link rel="stylesheet" href="css/join.css">

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<body>
    <header style="display:flex">
        <div style="flex:130px;">
            <img src="image/logo.jpg" width="120px;">
    </div>
    </header>
    <h1 align="center">회원가입 </h1>
    <hr>
    <div>
        <b class="name">아이디</b><br>
        <input class="text" type="text" name="userid" placeholder="아이디"><br><br>
    </div>
    <div>
        <b class="name">비밀번호</b><br>
        <input class="text" type="password" name="password" placeholder="패스워드"><br><br>
    </div>
    <div>
        <b class="name"> 이름 </b><br>
            <input class="text" type="text" name="name" placeholder="이름"><br><br>
    </div>
    <div>
        <b class="name"> 전화번호 </b><br>
            <input class="text" type="text" name="PhoneNum" placeholder="전화번호"><br><br>
    </div>
    <div>
        <b class="name"> 이메일 </b><br>
        <input class="text" type="text" name="emailAddress" placeholder="E-mail"><br><br>
    </div>
    <div>
    	<b class="name"> 주소 </b><br>
    </div>
    <div>
	<input type="text" id="postNum" size="5" placeholder="우편번호">
	<input type="button" value="우편번호검색" onclick="execDaumPostcode()" ><br>
	<input type="text" id="mainAddress"  size="39" placeholder="주소" ><br>
	<input type="text" id="detailAddress"  name="addr2" size="39" placeholder="상세주소"><br><br>
 	</div>
 	<div>
        <b class="name"> 닉네임 </b><br>
        <input class="text" type="nickname" name="NICKNAME" placeholder="닉네임"><br><br>
    </div>
    <div>
        <input type="checkbox"> email 수신 동의
    </div>
    <div>
        <button class="sign_up" type="button">Sign up</button>
    </div>
  	<script defer src="address.js"> </script>
 	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
   
</body>
</html>