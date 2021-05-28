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
//application 내장객체
// - 웹 어플리케이션 서버 정보 저장
// - 서버 start → 하나만 생성, stop → 소멸
// - 전체 자원 공유
%>
서버 정보 : <%=application.getServerInfo() %>
서버 물리적 경로 : <%=application.getRealPath("/") %><br>
<%
//pageContext 내장객체 : 현페이지 정보 저장
//out 내장객체 : 출력정보 저장

out.print("출력<br>");
out.print("버퍼크기 : " + out.getBufferSize());
out.print("<br>버퍼 남은 크기 : " + out.getRemaining() + "byte<br>");

out.close();
out.print("중지 후 출력 → 에러 → 실행 안됨");
%>
</body>
</html>