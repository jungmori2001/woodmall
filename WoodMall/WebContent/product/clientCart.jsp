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
                            <td></td>
                            <td colspan="2">상품정보</td>
                            <td>상품금액</td>
                            <td>수량</td>
                            <td>배송비</td>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="product" items="${productList}">
                        <tr class="cart__list__detail">
                            <td><input type="checkbox" name="prodNum" value="${product.prodNum}" checked>
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

                                <input style="text-align:center;" type="text" name="p_num1" id="p_num1" size="2" maxlength="4" class="p_num" value="1" readonly>
            
                                <span><i class="fas fa-arrow-alt-circle-up up"></i></span>
            
                                <span><i class="fas fa-arrow-alt-circle-down down"></i></span>
            
                            </div></td>
                            <td>무료</td>
                        </tr>
                        </c:forEach>
                    </tbody>
                    <tfoot>
                        <tr align="right">
                            <td colspan="5"><strong style="font-size:20px;">총 금액</strong></td>
                            <td style="font-size:17px"><fmt:formatNumber value="${totalPrice}"
									pattern="#,###" />원</td>
                        </tr>
                        
                    </tfoot>
            </table>
        </form>
            <div class="cart__mainbtns">
                <button class="cart__bigorderbtn left" onclick="location.href='./index.jsp'">쇼핑 계속하기</button>
                <button class="cart__bigorderbtn right">주문하기</button>
            </div>
        </section>
	
	<%@ include file="../baseLayout/footer.jsp" %>
</body>
</html>