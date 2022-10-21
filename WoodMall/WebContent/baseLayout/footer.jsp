<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<style>
.footer_footer {
    position: relative;
    transform: translateY(90%);
}

.footer_sns {
    margin: 0.5%;
    margin-top: 1%;
    width: 50px;
    height: 50px;
}

.copy_left {
    margin-top: 100px;
    font-size: 5px;
    float: left;
}

.copy_right {
    font-size: 8px;
    float: right;
    margin-top: 100px;
    font-size: 5px;
}

/*상품 관리 리스트 페이지*/
.admin_right{
    width:100%;
    float: right;
    height: 100%;
}
</style>
<body>
<footer class="footer_footer" style="width:100%; height: 200px; background-color: black;">
        <div>
            <span><a class="footer_a" href="https://www.youtube.com/"><img class="footer_sns" src="./image/youtube.png"></a></span>
            <span><a class="footer_a" href="https://www.instagram.com/"><img class="footer_snssns" src="./image/insta.png"></a></span>
            <span><a class="footer_a" href="https://ko-kr.facebook.com/"><img class="footer_snssns" src="./image/facebook.png"></a></span>
        </div>
        <div class="copy_left">
            <h1 style="color:white;">All Contents Copyright 2022 7조 All Right reserved</h1>
            <address style="color:white;">ContactMail : 7jo.naver.com Tel:+82 010-0000-0000</address>
        </div>
        <div class="copy_right">
            <a href="#">이용약관</a>
            <a href="#">개인정보취급방침</a>
        </div>
    </footer>
</body>
</html>