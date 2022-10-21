<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/style.css">
    <title>연습</title>
    <script src="./script/script.js"></script>
   	<style>
input[type="radio"] {
    display: none;
}

.js-slider {
    position: relative;
    width: 80%;
    height: 70vh;
    margin: 0 auto;
}

.js-slider_item {
    position: absolute;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    padding: 1rem 3rem;
    opacity: 0;
    visibility: hidden;
    transform-origin: right center;
    transform: translate3d(0%, 0%, 0) rotateY(30deg) scaleX(0.95);
    transition: all 1s ease, transform 1s cubic-bezier(0.43, 0.28, 0.51, 1);
}

#s-1:checked~.js-slider .js-slider_item.img-1,
#s-2:checked~.js-slider .js-slider_item.img-2,
#s-3:checked~.js-slider .js-slider_item.img-3 {
    opacity: 1;
    visibility: visible;
    transform-origin: left centerc-txt-s;
    transform: translate3d(0, 0, 0) rotateY(0deg) scaleX(1);
}

.js-slider_img {
    width: 100%;
    height: 60%;
    position: relative;
    overflow: hidden;
}

.c-img-w-full {
    position: absolute;
    top: 50%;
    left: 50%;
    width: auto;   /*100%*/
    height: 100%;  /*auto*/
    transform: translate3d(-50%, -50%, 0);
}

.c-img-h-full {
    position: absolute;
    top: 50%;
    left: 50%;
    width: auto;
    height: 100%;
    transform: translate3d(-50%, -50%, 0);
}

figcaption {
    display: block;
}

.wo-h3 {
    margin-top: 6rem;
    margin-bottom: 2rem;
    padding-bottom: 2rem;
    border-bottom: 1px solid rgb(66, 66, 248);
}
.wo-credit{
    display:flex;
}
.wo-credit >li{
    margin-right:20px;
    border-left: 2px solid rgb(30, 9, 216);
}
.c-label {
    display: inline-block;
    color: #eee;
    background-color: rgb(93, 93, 243);
    line-height: 1;
    padding: 0.5em 0.9em;
    margin-right: 0.5em;
    font-size: 1.4rem;
    font-weight: bold;
}

.view-sm {
    display: none;
}

.js-slider_nav {
    position: absolute;
    left: 0;
    top: 50%;
    width: 100%;
    transform: translate3d(0, -50%, 0);
}

.js-slider_nav_item.prev {
    left: 0;
}

.js-slider_nav_item.next {
    right: 0;
    transform: rotateY(180deg);
}

.js-slider_nav_item {
    position: absolute;
    display: none;
    width: 4rem;
    height: 4rem;
    border: 1px solid rgb(66, 66, 248);
    border-radius: 50%;
    cursor: pointer;
    transition: 1s all cubic-bezier(0.075, 0.82, 0.165, 1);
}

.js-slider_nav_item:before {
    content: "";
    display: block;
    position: absolute;
    left: 1rem;
    top: 55%;
    width: 1rem;
    height: 1px;
    background-color: rgb(66, 66, 248);
    transform-origin: left bottom;
    transform: translate3d(0, -50%, 0) rotate(-45deg);
    transition: 1s all cubic-bezier(0.075, 0.82, 0.165, 1);
}

.js-slider_nav_item:hover {
    transform: translate3d(-30%, 0, 0);
}

.js-slider_nav_item.next:hover {
    transform: rotateY(180deg) translate3d(-30%, 0, 0);
}

.js-slider_nav_item:hover:before {
    transform: translate3d(0, -50%, 0) rotate(-30deg);
}

.js-slider_nav_item:after {
    content: "";
    position: absolute;
    top: 55%;
    left: 50%;
    width: 2rem;
    height: 1px;
    background-color: rgb(93, 93, 243);
    transform: translate3d(-50%, -50%, 0);
}

#s-1:checked~.js-slider .js-slider_nav .s-nav-1,
#s-2:checked~.js-slider .js-slider_nav .s-nav-2,
#s-3:checked~.js-slider .js-slider_nav .s-nav-3 {
    display: block;
}

.js-slider_indicator {
    position: absolute;
    left: 0;
    top: 63%;
    width: 100%;
    text-align: center;
}

.js-slider-indi {
    position: relative;
    display: inline-block;
    padding: 2rem;
    cursor: pointer;
}

.js-slider-indi:after {
    content: "";
    position: absolute;
    top: 50%;
    left: 50%;
    width: 1rem;
    height: 1rem;
    border-radius: 1rem;
    background: rgb(93, 93, 243);
    transform: translate3d(-50%, -50%, 0);
}

.js-slider-indi:hover:after {
    transform: translate3d(-50%, -50%, 0) scale(1.5);
    transition: 1s all cubic-bezier(0.075, 0.82, 0.165, 1);
}

#s-1:checked~.js-slider .js-slider_indicator .indi-1:after,
#s-2:checked~.js-slider .js-slider_indicator .indi-2:after,
#s-3:checked~.js-slider .js-slider_indicator .indi-3:after {
    transform: translate3d(-50%, -50%, 0) scale(2.5);
}
   		
   	</style>
</head>

<body>
<%@ include file="./baseLayout/header.jsp" %>
<div style="flex:90%">
<div style="background-color: white; text-align: right;">

</div>
</div>
    <!--메인-->
    <input type="radio" id="s-1" name="slider-control" checked="checked">
    <input type="radio" id="s-2" name="slider-control">
    <input type="radio" id="s-3" name="slider-control">
    <div class="js-slider">
        <figure class="js-slider_item img-1">
            <div class="js-slider_img">
                <img class="c-img-w-full" src="./image/slideimg02.jpg" alt="">
            </div>
        
            <figcaption class="wo-caption">
                <h3 class="wo-h3">
                    <div class="c-label">WoodMall</div>
                    <br class="view-sm mb-s"><a href="#">more+</a>
                </h3>
                <ul class="wo-credit">
                    <li>인테리어 제품을 판매하는 WoodMall 입니다</li>
                    <li><a href="#">More Table</a></li>
                    <li><span class="c-txt-s"><a href="#">More Chair</a></span></li>
                </ul>
            </figcaption>
        </figure>
        <figure class="js-slider_item img-2">
            <div class="js-slider_img">
                <img class="c-img-h-full" src="./image/slideimg02.jpg" alt="">
            </div>
            <figcaption class="wo-caption">
                <h3 class="wo-h3">인테리어</h3>
                <ul class="wo-credit">
                    <li><a onmouseover="winOpen()">상세상품정보</a></li>
                    <li><a onmouseover="winOpen()">상세상품정보</a></li>
                    <li><a onmouseover="winOpen()">상세상품정보</a></li>
                </ul>
            </figcaption>
        </figure>
        <figure class="js-slider_item img-3">
            <div class="js-slider_img">
                <img class="c-img-h-full" src="./image/slideimg02.jpg" alt="">
            </div>
            <figcaption class="wo-caption">
                <h3 class="wo-h3">인테리어</h3>
                <ul class="wo-credit">
                    <li><a onmouseover="winOpen()">상세상품정보</a></li>
                    <br>
                    <li><a onmouseover="winOpen()">상세상품정보</a></li>
                    <br>
                    <li><a onmouseover="winOpen()">상세상품정보</a></li>
                </ul>
            </figcaption>
        </figure>
        <div class="js-slider_nav">
            <label class="js-slider_nav_item s-nav-1 prev" for="s-3"></label>
            <label class="js-slider_nav_item s-nav-1 next" for="s-2"></label>
            <label class="js-slider_nav_item s-nav-2 prev" for="s-1"></label>
            <label class="js-slider_nav_item s-nav-2 next" for="s-3"></label>
            <label class="js-slider_nav_item s-nav-3 prev" for="s-2"></label>
            <label class="js-slider_nav_item s-nav-3 next" for="s-1"></label>
        </div>
        <div class="js-slider_indicator">
            <div class="js-slider-indi indi-1"></div>
            <div class="js-slider-indi indi-2"></div>
            <div class="js-slider-indi indi-3"></div>
        </div>
    </div>
    <!--푸터-->

    <%@ include file="baseLayout/footer.jsp" %>

</body>

</html>