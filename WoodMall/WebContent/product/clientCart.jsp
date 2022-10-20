<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WoodMall : 장바구니</title>
<link type="text/css" rel="stylesheet" href="./css/clientCart.css">
<script type = "text/javascript" > 
function selectAll(selectAll) {
    const checkboxes = document.getElementsByName('price');

    checkboxes.forEach((checkbox) => {
        checkbox.checked = selectAll.checked;
    })
}
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
            <form action="../clientProductCart.do" name=frm method="post">
            <table class="cart__list">
                    <thead>
                        <tr>
                            <td colspan="3">상품정보</td>
                            <td>상품금액</td>
                            <td>배송비</td>
                        </tr>
                    </thead>
                    <tbody>
                    
                        <tr class="cart__list__detail">
                            <td>
                            
                            <input type="hidden" name="userId" value="${user.userid}">
                            <input type="hidden" name="prodNum" value="${product.prodNum}">
                            <input type="hidden" name="quantity" value="${product.quantity}">
                            <input type="hidden" name="prodName" value="${product.prodName}">
                            <input type="hidden" name="userId" value="${product.userId}">
                            </td>
                            <td><img src="upload/${product.image}"></td>
                            <td><a href="../index.jsp">WoodMall</a><span class="cart_smartStore"> 스마트스토어</span>
                                <p>${product.prodName}</p>
                            </td>
                            
                            <td><span class="price">${product.price}원</span><br>
                            </td>
                            <td>무료</td>
                        </tr>
                        
                    </tbody>
                    <tfoot>
                        <tr>
                            <td colspan="3">
                            </td>
                            <td></td>
                            <td>총 구매 금액<br><br><span class="totalPrice"></span></td>
                            <td></td>
                        </tr>
                        
                    </tfoot>
            </table>
				</form>
            <div class="cart__mainbtns">
                <input type="button" value="쇼핑 계속하기" onclick="location.href='../index.jsp'" 
                		class="cart__bigorderbtn left">
                <input type="submit" value="주문하기" class="cart__bigorderbtn right">
            </div>
        </section>
        <%@ include file="../baseLayout/footer.jsp" %>
    </body>
</html>