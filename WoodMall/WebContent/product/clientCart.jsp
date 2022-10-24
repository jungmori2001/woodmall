<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WoodMall : 장바구니</title>
<link rel="stylesheet" type="text/css" href="css/clientCart.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#checkbox_all").click(function() {
				if($("#checkbox_all").is(":checked")) $("input[name=chk]").prop("checked", true);
				else $("input[name=chk]").prop("checked", false);
			});
			
			$("input[name=chk]").click(function() {
				var total = $("input[name=chk]").length;
				var checked = $("input[name=chk]:checked").length;
				
				if(total != checked) $("#checkbox_all").prop("checked", false);
				else $("#checkbox_all").prop("checked", true); 
			});
		});
	</script>
</head>
<body>
	<%@ include file="../baseLayout/header.jsp" %>
	
	 <section class="cart">
            <div class="cart__information">
                <ul>
                    <li>장바구니 상품은 최대 30일간 저장됩니다.</li>
                    <li>가격, 옵션 등 정보가 변경된 경우 주문이 불가할 수 있습니다.</li>
                    <li>오늘출발 상품은 판매자 설정 시점에 따라 오늘출발 여부가 변경될 수 있으니 주문 시 꼭 다시 확인해 주시기 바랍니다.</li>
                </ul>
            </div>
            <form action="./clientOrder.do" name="form" method="post">
            <table class="cart__list">
                
                    <thead>
                        <tr>
                            <td><input type="checkbox" id="checkbox_all"></td>
                            <td colspan="3">상품정보</td>
                            <td>상품금액</td>
                            <td>수량</td>
                            <td>배송비</td>
                        </tr>
                    </thead>
                    <c:forEach var="product" items="${productList}">
                    <tbody>
                        <tr class="cart__list__detail">
                        <td>
                            <td>
                            <input type="checkbox" name="chk" value="${product.prodNum}" checked>
                            <input type="hidden" name="userId" value="${userId}">
                            <input type="hidden" name="price" value="${product.price}">
                            <c:set var="price" value="${product.price}"/></td>
                            <td><img src="upload/${product.image}"></td>
                            <td><a href="index.jsp">WoodMall</a><span class="cart__list__smartstore"> 스마트스토어</span>
                                <p>${product.prodName}</p>
                            </td>
                            
                            <td><span class="price">
                            <fmt:formatNumber value="${product.price}"
									pattern="#,###" />원</span><br>
                            </td>
                            <td><div class="updown">
                                1
                            </div></td>
                            
                            <td align="center">무료</td>
                        </tr>
                    </tbody>
                    </c:forEach>
                    <tfoot>
                        <tr align="right">
                            <td align="left" colspan="3">
							
							<input type="button" 
									value="선택상품 삭제" 
									onclick="location.href='clientDeleteProductFromCart.do?prodNum=${param.prodNum1}&userId=${userId}'" 
									class="cart__list__optionbtn">
								</td>
                            <td colspan="2">
                            	<strong style="font-size:20px;">총 금액</strong></td>
                            <td colspan="2" style="font-size:17px">
                            <fmt:formatNumber value="${totalPrice}" pattern="#,###" />원</td>
                            </tr>
                    </tfoot>
                    
            </table>
            <div class="cart__mainbtns">
                <input type="button" value="쇼핑 계속하기" class="cart__bigorderbtn left" onclick="location.href='./index.jsp'">
                <input type="submit" value="주문하기" class="cart__bigorderbtn right">
            </div>
        </form>
            
        </section>
	
	<%@ include file="../baseLayout/footer.jsp" %>
</body>
</html>