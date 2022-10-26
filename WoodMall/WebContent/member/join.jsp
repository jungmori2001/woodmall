<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 가입</title>
    <link rel="stylesheet" href="css/signUp.css">
    <script type="text/javascript" src="script/member.js"></script>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
<form action="join.do" method="post" name="frm">
    <header style="display:flex">
        <div style="flex:130px;">
            <img src="image/logo.jpg" width="120px;">
    </div>
    </header>
 
 <h1 align="center">회원가입 </h1>
 
    <hr>
       <div>
        <b class="name"> 이름 </b><br> 
           <input class="text" type="text" name="name" placeholder="이름" style="width:200px;height:30px"><br><br>
         </div>  
    <div>
        <b class="name">아이디</b><br>
        <input class="text" type="text" name="userId" placeholder="아이디" style="width:120px;height:30px">
       	<input type="hidden" name="checkid">	
		<input type="button" value="중복 체크" onclick="checkId()">
    </div>
    <div>
        <b class="name">비밀번호</b><br>
        <input class="text" type="password" name="password" placeholder="패스워드" style="width:200px;height:30px"><br><br>
    </div>
    <div>
        <b class="name"> 이메일 </b><br>
        <input class="text" type="text" name="emailId" placeholder="이메일 아이디" style="width:100px;height:30px">
        @ <input class="text" type="text" name="emailAddress" placeholder="이메일 주소" style="width:135px;height:30px"><br><br>
    </div>
        <div>
        <b class="name"> 전화번호 </b><br>
            <input class="text" name="firstPhone" placeholder="전화번호" style="width:70px;height:30px">
            -<input class="text" name="midPhone" placeholder="전화번호" style="width:70px;height:30px">
            -<input class="text" name="lastPhone" placeholder="전화번호" style="width:70px;height:30px">
          </div>  
     <br>       
    <div>
    	<b class="name"> 주소 </b><br>
	<input class="text"  type="text" id="postNum" name="postNum" style="width:70px;height:20px" placeholder="우편번호">
 	<input type="button" type="text" id="search" value="우편번호검색" onclick="new daum.Postcode()" ><br>
	<input class="text"  type="text" id="mainAddress" name="mainAddress"  size="39" placeholder="도로명" ><br>
	<input class="text"  type="text" name="detailAddress" size="39" placeholder="상세주소"><br>
	<input class="text"  type="text" name="subAddress"  size="39" placeholder="참고항목"><br>
 	</div>
 	
    <div>
        <input type="checkbox"> email 수신 동의
    </div>
    <div>
        <button class="sign_up" type="submit" onclick="return checkJoin()">확인 &nbsp;&nbsp;&nbsp;
        </button>
    </div>


</form>   
</body>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
window.onload = function(){
    document.getElementById("search").addEventListener("click", function(){ //주소입력칸을 클릭하면
        //카카오 지도 발생
        new daum.Postcode({
            oncomplete: function(data) { //선택시 입력값 세팅
                document.getElementById("mainAddress").value = data.address; // 주소 넣기
                document.querySelector("#postNum").value = data.zonecode;
                document.querySelector("input[name=detailAddress]").focus(); //상세입력 포커싱
                
            }
        }).open();
    });
}
</script>
</html>