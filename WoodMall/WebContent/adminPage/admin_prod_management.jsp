<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../css/style.css">
<style>
.admin_right{
    display:flex;
    width:100%;
    float: right;
    height: 100%;
}
/*상품 관리 페이지*/
.list_wrap {
    width: 1200px;
    /*전체 가로길이*/
    margin: 0 auto;
    /*개체가 상위 컨테이너의 중앙에 위치*/
    padding: 100px;
    /*위에서 떨어지기*/
}

.list_wrap ul {
    font-size: 0;
    /*아이템(카드) 사이의 여백이 가려진다*/
}

.list_wrap .item {
    display: inline-block;
    /*가로로 배치하기*/
    width: 30%;
    /*가로 길이 줄이기*/
    margin-top: 40px;
    /*위쪽에서 멀어지기*/
    margin-left: 5%;
    /*왼쪽으로 멀어지게 적용*/
    box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.5);
    /*x값, y값, 흐려지는 정도(0.5), rgba는 색깔 적용*/
}

.list_wrap .item:nth-child(-n+3) {
    /*1, 2, 3, 번 아이템 들은 위쪽에서 멀어지지 않게 적용*/
    margin-top: 0;
}

.list_wrap .item:nth-child(3n-2) {
    /*가장 왼쪽에 있는것(1, 4, 7번 아이템)들은 margin-left가 적용되지 않도록 함*/
    margin-left: 0;
}

.list_wrap .item .image {
    width: 100%;
    /*가로*/
    height: 160px;
    /*세로*/
    background-color: #ddd;
    /*백그라운드 컬러*/
    background-repeat: no-repeat;
    /*백그라운드 전체지정*/
    background-position: 50% 50%;
    /*백그라운드 포지션*/
    background-size: cover;
    /*백그라운드 사이즈*/
}


.list_wrap .item1 .image {
    background-image: url(./image/slide01.jpg);
}

.list_wrap .item2 .image {
    background-image: url(./image/slide01.jpg);
}

.list_wrap .item3 .image {
    background-image: url(./image/slide01.jpg);
}

.list_wrap .item .cont {
    padding: 25px;
}

.list_wrap .item strong {
    display: block;
    /*Strong 태그는 inline 태그이기 때문에 margin이 적용 X margin값이 적용되도록 함*/
    margin: 0 0 10px 0;
    /*이미지와 제목의 간격 조정*/
    font-size: 19px;
    /*아이템 제목의 크기*/
    letter-spacing: -1px;
    /*아이템 제목의 글자 사이의 간격 줄이기*/
}

.list_wrap .item p {
    /*p태그*/
    font-size: 14px;
    /*p태그의 글자 크기*/
    letter-spacing: -1px;
    /*p태그의 글자 간격*/
}

.list_wrap .item a {
    /*a태그*/
    display: inline-block;
    /*위의 내용과 곂치지 않게 설정*/
    margin-top: 10px;
    /*내용과 버튼 사이의 간격*/
    padding: 5px 10px;
    /*상하좌우 여백*/
    background: #eee;
    font-size: 13px;
    /*a태그 글자 크기*/
    letter-spacing: -1px;
    /*a태그 글자 간격*/
}

.list_wrap .item a:hover {
    /*마우스 커서를 올렸을때 바뀌는 버튼 색깔 설정*/
    background: #325cb2;
    color: #fff;
}
</style>
<title>상품관리 페이지</title>
</head>
<body>
	<header style="display: flex">
		<div style="flex: 10%">
			<img src="../image/logo.jpg" width="70%">
		</div>
		<div style="flex: 90%">
			<div style="background-color: white; text-align: right;">회원가입</div>
			<div class="menubar">
				<ul class="menu">
					<li><a href="admin_prod_management.jsp">상품관리</a></li>
					<li><a href="admin_member_management.jsp">회원관리</a></li>
					<li><a href="admin_board_management.jsp">게시판관리</a></li>
					<li><a href="admin_order_management.jsp">주문관리</a></li>
				</ul>
			</div>
		</div>
	</header>
	<div class="list_wrap">
		<!--div 태그는 분할, 나누기태그로 알려져있으며 html에서 웹 페이지의 내용,텍스트, 이미지, 머리글 등을 구분하는데 사용됩니다.-->
		<ul>
			<!--ul 과 li 를 이용해서 리스트를 만들었다-->
			<li class="item item1">
				<div class="image">사진</div> <!--div에 백그라운드 이미지의 사진을 넣기 위해 적용-->
				<div class="cont">
					<strong>책상</strong>
					<!-- 제목 강조-->
					<p>설명1</p>
					<a href="admin_prod_table.jsp">상품 리스트</a>
					<!--a태그를 이용하여 버튼 생성-->
				</div>
			</li>
			<li class="item item2">
				<div class="image">사진</div> <!--div는 백그라운드 이미지의 사진을 넣기 위해 적용-->
				<div class="cont">
					<strong>의자</strong>
					<!--강조-->
					<p>설명</p>
					<a href="admin_prod_chair.jsp">상품 리스트</a>
					<!--a태그를 이용하여 버튼 생성-->
				</div>
			</li>
			<li class="item item3">
				<div class="image">사진</div> <!--div는 백그라운드 이미지의 사진을 넣기 위해 적용-->
				<div class="cont">
					<strong>###</strong>
					<!--강조-->
					<p>설명</p>
					<a href="#">상품 리스트</a>
					<!--a태그를 이용하여 버튼 생성-->
				</div>
			</li>
	</div>
</body>
</html>