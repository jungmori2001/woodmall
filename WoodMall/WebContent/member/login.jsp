<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
  <script src="https://kit.fontawesome.com/53a8c415f1.js"></script>
  <link rel="stylesheet" href="css/login.css"> 
<title>로그인</title>
</head>
<body>

<form action="login.do" method="post" name="frm">
    <img src="image/logo.jpg">
    <div class="wrap">
        <div class="login">
            <h2></h2>
            <div class="login_sns">
            <li><a href=""><i class="fab fa-instagram"></i></a></li>
            <li><a href=""><i class="fab fa-facebook-f"></i></a></li>
            <li><a href=""><i class="fab fa-twitter"></i></a></li>
            </div>
            <div class="login_id">
                <h4>아이디</h4>
                <input type="text" name="userId" placeholder="아이디">
            </div>
            <div class="login_pw">
                <h4>비밀번호</h4>
                <input type="password" name="password"  placeholder="비밀번호">
            </div>
            <div class="login_etc">
                <div class="checkbox">
                <input type="checkbox" name="rembid" > 아이디 저장
                </div>
                <div class="forgot_pw">
                <a href="">비밀번호를 잃어버렸나요?</a>
            </div>
            </div>
            <div class="submit">
                <input type="submit" value="로그인" onclick="return checkLogin()"> 
            </div>
        </div>
    </div>
   
</form>

</body>
</html>