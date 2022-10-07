<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터베이스 연동 시험</title>
</head>
<body>

<%
// (1 단계) JDBC 드라이버 로드
//Class.forName("com.mysql.jdbc.Driver");			// MySql
Class.forName("oracle.jdbc.driver.OracleDriver");	// Oracle

// (2 단계) 데이터 베이스 연결 객체 생성 
String url = "jdbc:oracle:thin:@localhost:1521:orcl";
String uid = "ora_user";
String pass = "1234";
Connection conn = DriverManager.getConnection(url, uid, pass);

// (3 단계) Statement 객체 생성
Statement stmt = conn.createStatement();

// (4 단계) SQL문 실행 및 결과 처리
// executeQuery : 조회(select)
ResultSet rs = stmt.executeQuery("select * from woodmallproduct");

// rs.next() : 다음 행(row)을 확인
// rs.getString("컬럼명")
while(rs.next()){
	out.print("<h6>");
	out.print(rs.getString("prodname"));
	out.print("&nbsp&nbsp");	
	out.print(rs.getString("prodnum"));
	out.print("&nbsp&nbsp");	
	out.print(rs.getString("price"));
	out.print("&nbsp&nbsp");	
	out.print(rs.getString("content"));
	out.print("</h6>");
}

//(5 단계) 사용한 리소스 해제
rs.close();
stmt.close();
conn.close();
%>

</body>
</html>