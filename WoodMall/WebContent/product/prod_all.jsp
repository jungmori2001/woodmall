<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="./css/adminPage.css">
<title>Insert title here</title>
</head>
<body>

<h2> 전체상품 리스트</h2>
<a href="adminIndexPage.jsp" class="item-link" id="pageLink" >
	<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
		<path stroke-linecap="round" stroke-linejoin="round" d="M2.25 12l8.954-8.955c.44-.439 1.152-.439 1.591 0L21.75 12M4.5 9.75v10.125c0 .621.504 1.125 1.125 1.125H9.75v-4.875c0-.621.504-1.125 1.125-1.125h2.25c.621 0 1.125.504 1.125 1.125V21h4.125c.621 0 1.125-.504 1.125-1.125V9.75M8.25 21h8.25" />
	</svg>
</a>
<a href="writeProduct.do">
	<svg xmlns="http://www.w3.org/2000/svg" width="30" hieght:"30" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
		<path stroke-linecap="round" stroke-linejoin="round" d="M12 9v6m3-3H9m12 0a9 9 0 11-18 0 9 9 0 0118 0z" />
	</svg>
</a>
<div class="search">
		<form action="productList.do">
			<select name="column">
				<option ${(param.column=="prodNum")?"selected":""} value="prodNum">상품번호</option>
				<option ${(param.column=="prodName")?"selected":""} value="prodName">상품명</option>
				<option ${(param.column=="kind")?"selected":""} value="kind">분류</option>
			</select>
			<input type="text" name="keyword" value="${param.keyword}">
			<input type="submit" value="검색">
		</form>
	</div>
<div>
<table border="1">
	<tr>
		<th style=width:5%;>코드</th>
		<th style=width:10%;>분류</th>
		<th style=width:5%;>사진</th>
		<th style=width:15%;>이름</th>
		<th style=width:10%;>가격</th>
		<th style=width:10%;>등록일자</th>
		<th style=width:5%;>상세</th>
		<th style=width:5%;>수정</th>
		<th style=width:5%;>삭제</th>
	</tr>
	
	<c:forEach var="woodmallproduct" items="${productList}">
		<tr>
			<td>${woodmallproduct.prodNum}</td>
			<td>${woodmallproduct.kind}</td>
			<td><img style="width:30px; height:30px;" src="upload/${woodmallproduct.image}"></td>
			<td>${woodmallproduct.prodName}</td>
			<td>${woodmallproduct.price}</td>
			<td>${woodmallproduct.reg_date}</td>
			<td><a href="productDetail.do?prodnum=${woodmallproduct.prodNum}">상품상세</a></td>
			<td><a href="updateProduct.do?prodnum=${woodmallproduct.prodNum}">상품수정</a></td>
			<td><a href="deleteProduct.do?prodnum=${woodmallproduct.prodNum}">상품삭제</a></td>
		</tr>
	</c:forEach>	
</table>
</div>
<!-- 페이징 
페이지 번호, 디비에서 전체 페이지 수 조회
설계 : 5개 페이지 번호를 표시, 5번이 넘어가면 다음 버튼을 통해 이동, 
    이전 1 2 3 4 5 다음-->

<hr>
<!-- 끝페이지 번호  lastNum -->
<!-- lastNum = Math.ceil(전체게시물 / 한페이지당 게시물 수) -->
<!-- 처음 6개 페이지 링크 표시 -->
<!-- 페이지 -->
<c:set var="page" value= "${(empty param.p)?1:param.p}"></c:set>
<c:set var="startNum" value="${page-(page-1)%5}"></c:set>
<c:set var="lastNum" value="${fn:substringBefore(Math.ceil(count/10), '.')}"></c:set>
<!-- 	페이지 수 -->
<c:if test="${startNum-1>0}">
	<a href="?p=${startNum-1}&column=${param.column}&keyword=${param.keyword}">이전 </a>
</c:if>
<c:if test="${startNum-1<=0}">
		<span onclick="alert('이전페이지가 없습니다.');"> 이전 </span>
	</a>
</c:if>

<c:forEach var="i" begin="0" end="4">
	<c:if test="${(i+startNum) <= lastNum}">
	<a href="?p=${i+startNum}>&column=${param.column}&keyword=${param.keyword}">
	${i+startNum}</a>
	</c:if>
</c:forEach>
<c:forEach var="i" begin="0" end="4">
	<a href="?p=${i+1}&column=${param.column}&keyword=${param.keyword}">${i+1}</a>
</c:forEach> 
<c:if test="${(startNum+4) < lastNum}">
	<a href="?p=${startNum+5}&column=${param.column}&keyword=${param.keyword}">
		다음
	</a>
</c:if>
<c:if test="${(startNum+4) >= lastNum}">
		<span onclick="alert('다음페이지가 없습니다.');"> 다음</span>
	</a>
</c:if>


<!-- 	<a href="?p=1">1</a> -->
<!-- 	<a href="?p=2">2</a> -->
<!-- 	<a href="?p=3">3</a> -->
<!-- 	<a href="?p=4">4</a> -->
<!-- 	<a href="?p=5">5</a> -->
</body>

</html>