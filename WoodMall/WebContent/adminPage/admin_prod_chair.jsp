<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/style.css">
    <title>의자 리스트</title>
</head>

<body>
    <h3 style="margin:3%;">의자 리스트</h3>
    <input type="button" class="btn writebtn" value="관리자 메인" onClick="location.href='admin_main.jsp'"style="float:left;">
    <input type="button" class="btn writebtn" value="상품 관리" onClick="location.href='admin_prod_management.jsp'"style="float:left;">
    <input type="button" class="btn writebtn" value="의자" onClick="location.href='admin_prod_chair.jsp'" style="float:left;">
    <input type="button" class="btn writebtn" value="책상" onClick="location.href='admin_prod_table.jsp'" style="float:left;">
    <div class="admin_right">
        <table class="table">
            <tr>
                <th>상품번호</th>
                <th>상품명</th>
                <th>분류</th>
                <th>관리</th>
            </tr>
            <tr>
                <td>1</td>
                <td>2</td>
                <td>3</td>
                <td>
                    <input type="button" class="btn" value="수정">
                    <input type="button" class="btn" value="삭제">
                </td>
            </tr>
        </table>
    </div>
</body>
</html>