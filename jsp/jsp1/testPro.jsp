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
/* 
웹서버 : 웹애플리케이션 서버에 전달
1. request, response 내장 객체 생성 (기억장소)
   request : 이름=값 요청 정보 저장
2. web.xml 참조
3. 서블릿 : request에 저장된 태그 이름에 해당하는 값을 가져와서 출력 명령
			request.getParameter("태그이름") → 리턴값 String 타입
*/
String sname = request.getParameter("name");
String snum = request.getParameter("num");
//문자열 → 정수 변경 : Integer.parseInt(변수명)
int num = Integer.parseInt(snum);
//int num = Integer.parseInt(request.getParameter("num"));

%>

이름 : <%=sname %><br>
좋아하는 숫자 : <%=snum %><br>
좋아하는 숫자 + 100 : <%=snum+100 %> <!-- 문자열 + 숫자 = 문자열 (연결자) --> 
좋아하는 숫자 + 100 : <%=num+100 %> 


</body>
</html>