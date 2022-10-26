<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WoodMall : 주문완료</title>
</head>
<body>
    <div>
        <h2>${loginUser.name}님 구매해 주셔서 감사합니다.</h2>
        <c:forEach var="product" items="productList">
         <div>${product.prodname} 구매 완료</div>
        </c:forEach>
        <input type="button" value="돌아가기" onclick="location.href='index.jsp'">
    </div>
</body>
</html>