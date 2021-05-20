<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
// 자바 변수,연산자,조건문,반복문 사용 가능
int a = 10;
int b = 20;
System.out.println(a+b+s); //=> 콘솔창에 출력됨
%>

<%=a+b+s %> <!-- 웹에 출력됨 -->

<!-- 전역 변수 설정 -->
<%! String s = "안녕";%>

<form action="testPro.jsp" method="get">
이름 : <input type="text" name="name"><br>
좋아하는 숫자 : <input type="text" name="num"><br>
<input type="submit" value="전송">
</form>

</body>
</html>