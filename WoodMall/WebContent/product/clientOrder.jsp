<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	function getPostCode() {
		new daum.Postcode({
			oncomplete : function(data) {
				// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분. 각 주소의 노출 규칙에 따라 주소를 조합한다. 내려오는 변수가 값이 없는
				// 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
				var addr = ''; // 주소 변수
				var extraAddr = ''; // 참고항목 변수

				//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
				if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
					addr = data.roadAddress;
				} else { // 사용자가 지번 주소를 선택했을 경우(J)
					addr = data.jibunAddress;
				}

				// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
				if (data.userSelectedType === 'R') {
					// 법정동명이 있을 경우 추가한다. (법정리는 제외) 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
					if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
						extraAddr += data.bname;
					}
					// 건물명이 있고, 공동주택일 경우 추가한다.
					if (data.buildingName !== '' && data.apartment === 'Y') {
						extraAddr += (extraAddr !== '' ? ', '
								+ data.buildingName : data.buildingName);
					}
					// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
					if (extraAddr !== '') {
						extraAddr = ' (' + extraAddr + ')';
					}
					// 조합된 참고항목을 해당 필드에 넣는다.
					document.getElementById("subAddress").value = extraAddr;

				} else {
					document.getElementById("subAddress").value = '';
				}

				// 우편번호와 주소 정보를 해당 필드에 넣는다.
				document.getElementById('postNum').value = data.zonecode;
				document.getElementById("mainAddress").value = addr;
				// 커서를 상세주소 필드로 이동한다.
				document.getElementById("detailAddress").focus();
			}
		}).open();
	}
</script>
<style>
#pay {
    text-align:center;
}

#productSide {
    flex:auto; 
    border: 1px solid black;
    border-radius:10px 10px 10px 10px;
    margin-bottom:20px;
}

#productName {
    text-align:left; 
    font-weight:600;
    margin-top:15px;
    margin-left:20px;
    margin-right:20px;
}

#productOption {
    margin-bottom: 15px;
    margin-left: 20px;
    margin-right: 20px;
}

.payDetail {
    display:flex;
}

hr{
    height:2px; 
    background-color: grey;
}


#payDetailLayor{
    flex:80%; 
    margin-right:20px;
}

.payDetailLeft{
    flex:50%; 
    text-align:left;
}

.payDetailRight{
    flex:50%; 
    text-align:right
}


.order{
    background-color:black;
    text-align: center;
    color:white;
    font-size:xx-large;
    font-weight:bold;
    
}
</style>

<body>

	<article>
		<div style="display: flex;">
			<div style="flex: auto;">
				<img src="/image/고무나무 책상.jpg" width="150">
			</div>
			<div id="productSide">
				<div id="productName">
					품명 : 고무나무 책상
					<hr>
				</div>
				<div id="productOption">
					<br>옵션 : 추가 안전 포장(+10,000원) <br>수량 : 1 개
				</div>

			</div>

		</div>
		<div style="display: flex;">

			<div style="flex: 50%"></div>
			<div id="payDetailLayor">

				<strong>결제 상세</strong>
				<hr>

				<div class="payDetail">
					<div class="payDetailLeft">주문 금액</div>
					<div class="payDetailRight">13 만원</div>
				</div>
				<div class="payDetail">
					<div class="payDetailLeft">상품 금액</div>
					<div class="payDetailRight">13 만원</div>
				</div>
				<div class="payDetail">
					<div class="payDetailLeft">배송비</div>
					<div class="payDetailRight">0 원</div>
				</div>
				<hr>
				<p>
				<div class="payDetail">
					<div class="payDetailLeft">
						<strong>총 결제 금액</strong>
					</div>
					<div class="payDetailRight">12 만원</div>
				</div>
				</p>
				<hr>
			</div>
		</div>
		<hr>
		<div id="pay">
			<div>
				<strong>결제 수단</strong>
			</div>
			<div>
				<br> <input type="radio" name="pay">계좌입금 <input
					type="radio" name="pay">카드결제
			</div>
		</div>

	</article>
</body>
</html>