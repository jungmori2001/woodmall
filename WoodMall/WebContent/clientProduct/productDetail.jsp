<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="../script/productDetail.js"></script>
<body>
	<%@ include file="../baseLayout/header.jsp" %>
	
	
	<article>
            <div class="sep">
                <div class="sideLeft" style="display:flex">
                    <div id="changeImg" class="slideImg">
                        <img class="slide1" src="/image/chair.jpg" width="250">
                        <img class="slide1" src="/image/chair2.jpg" width="250">
                    </div>
                    <div class="sideRight">
                        <div class="sideRightName" style="margin-top:50px;">
                            <strong>원목 의자</strong><br>
                        </div>
                        <br>
                        <div>
                            <div class="chooseOption" style="margin-top:100px">
                                <strong>옵션선택</strong><br>
                            </div>
                            <select class="optionSelect">
                                <option name="option1">기본 포장 (+0원)</option>
                                <option name="option2">안전 포장 (+6,000원)</option>
                            </select>
                        </div>
                        <br>
                        <div>
                            <input
                                class="button_base b01_simple_rollover"
                                type="button"
                                name="basket"
                                value="장바구니"
                                id="bt">
                            <input
                                class="button_base b01_simple_rollover"
                                type="button"
                                name="buy"
                                value="구매"
                                onclick="location.href='orderPage.html'">
                        </div>

                    </div>
                </div>
            </article>
            <section>
                <div class="container">
                    <ul class="tabs">
                        <li class="tap_link current" data-tab="tab1">제품상세</li>
                        <li class="tap_link" data-tab="tab2">리뷰</li>
                        <li class="tap_link" data-tab="tab3">QNA</li>
                    </ul>
                    <div id="tab1" class="tap-content current">탭1</div>
                    <div id="tab1" class="tap-content">탭2</div>
                    <div id="tab1" class="tap-content">탭3</div>
                    
                </div>
            
            </section>
            
            <%@ include file="../baseLayout/footer.jsp" %>
</body>
</html>