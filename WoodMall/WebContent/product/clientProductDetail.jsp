<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WoodMall : ${product.prodName}</title>
</head>
<script type="text/javascript">
        var index = 0; //이미지에 접근하는 인덱스
        window.onload = function () {
            slideShow();
        }

        function slideShow() {
            var i;
            var x = document.getElementsByClassName("slide1"); //slide1에 대한 dom 참조
            for (i = 0; i < x.length; i++) {
                x[i].style.display = "none"; //처음에 전부 display를 none으로 한다.
            }
            index++;
            if (index > x.length) {
                index = 1; //인덱스가 초과되면 1로 변경
            }
            x[index - 1].style.display = "block"; //해당 인덱스는 block으로
            setTimeout(slideShow, 4000); //함수를 4초마다 호출
        }
    </script>
    <style>
    /* 1. tab 영역 css 설정 */
.tab-area {
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    color: white;
    background-color: black;
    font-size: 20px;
}

/* 2. tab 메뉴 부분 디자인 */
.tab-area input {
    display: none;
}

.tab-area label {
    margin-left: auto;
    margin-right: auto;
}

/* label에 마우스 올렸을 때 */
.tab-area label:hover {
    cursor: pointer;
    /*마우스 모양 변경*/
}

/* tab-area 안에 존재하는 input 태그가 체크되었을 때, 
  체크된 input 태그 다음에 등장하는 label의 css 값 */
.tab-area input:checked + label {
    /* 해당 메뉴가 선택된 상태인지 아닌지를 사용자에게 알려줄 수 있음 */
    font-weight: bold;

}

/* 3. tab 내용 부분 디자인 */
.tab-content {
    width: 100%;
    /*부모 div width와 같은 width를 가진다.*/
    height: 500px;
    display: none;
    /*기본 값일땐 화면에 표시하지 않음. 체크 상태일 때, 화면에 표시되어야 함 */
    border-top: 2px solid rgba(200, 200, 200, 0.534);
    /*탭 메뉴와 내용구분선*/
}

/* input 태그가 체크 상태일떼, 이에 대응하는 content?를 display에 표시하도록 설정 */
#tab1:checked ~ #content1,
#tab2:checked ~ #content2,
#tab3:checked ~ #content3 {
    display: flex;
}

/* 탭 영역 */
/* Style the tab */
.tab {
    text-align: center;
    overflow: hidden;
    border: 1px solid #ccc;
    background-color: #f1f1f1;
}

  /* Style the buttons that are used to open the tab content */
.tab button {
    background-color: inherit;
    border: none;
    outline: none;
    cursor: pointer;
    padding: 14px 16px;
    transition: 0.3s;
}

  /* Change background color of buttons on hover */
.tab button:hover {
    background-color: #ddd;
}

  /* Create an active/current tablink class */
.tab button.active {
    background-color: #ccc;
}

  /* Style the tab content */
.tabcontent {
    text-align:center;
    display: none;
    padding: 6px 12px;
    border: 1px solid #ccc;
    border-top: none;
}

.title{
flex:40%;
}

.main{
display:flex;
margin-top:100px
}

.productName{
flex:60%;
}

.proName{
	margin-bottom:20px;
}

    </style>
<body>
<%@ include file="../baseLayout/header.jsp"%>
<article>
            <div class="main">
                <div class="title" align="center">
                <p>
                    <img src="/image/고무나무 책상.jpg" width="200px">
                    </p>
                </div>
                <div class="productName">
                    <div class="proName">
                        <h2>고무나무책상</h2>
                    </div>
                    <form action="order.do" method="post">
                    <table>
                        <tr><td>판매가</td><td align="right">100원</td></tr>
                        <tr><td>옵션</td><td>
                            <select name="selectOption">
                                <option value="0">기본 포장</option>
                                <option value="10000">특수 포장(+10000)</option>
                            </select>
                        </td></tr>
                        <tr style="height:20px"></tr>
                        <tr align="right"><td colspan="3">
                        <input type="hidden" name="prodNum" value="${product.prodNum}">
                        <input type="button" value="장바구니" onclick="location.href='cart.do?prodNum=${product.prodNum}'">
                        <input type="submit" value="구매">
                    </td>
                    </tr>
                        </form>
                    </table>
                </div>
            </div>
        </article>

        <div class="tab">
            <button class="tablinks" onclick="openTap(event, 'pro_detail')">제품상세</button>
            <button class="tablinks" onclick="openTap(event, 'review')">리뷰</button>
            <button class="tablinks" onclick="openTap(event, 'qna')">QNA</button>
        </div>

        <!-- Tab content -->
        <div id="pro_detail" class="tabcontent">
            <h3>제품상세</h3>
            <p>London is the capital city of England.</p>
        </div>

        <div id="review" class="tabcontent">
            <h3>리뷰</h3>
            <p>Paris is the capital of France.</p>
        </div>

        <div id="qna" class="tabcontent">
            <h3>QNA</h3>
            <p>Tokyo is the capital of Japan.</p>
        </div>
            <%@ include file="../baseLayout/footer.jsp"%>
</body>
</html>