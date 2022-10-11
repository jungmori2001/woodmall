<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link href="/css/productListPage.css" rel="stylesheet">
<body>
	<%@ include file="../baseLayout/header.jsp" %>
        <div class="products" id="wrapper">
            <h3>Chair</h3>
    
            <div class="product-list">
                <a href="#" class="product">
                    <img src="/image/chair.jpg" width="225">
                    <div class="product-name">
                        고무나무의자
                    </div>
                    <div class="product-price">
                        49,000
                    </div>
                </a>
            </div>
        </div>
	<%@ include file="../baseLayout/footer.jsp" %>
</body>
</html>