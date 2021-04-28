<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
서버 도메인명 : <%=request.getServerName() %><br>
서버 포트번호 : <%=request.getServerPort() %><br>
요청 URL : <%=request.getRequestURL() %><br>
요청 URI : <%=request.getRequestURI() %><br>
프로토콜(통신규약) : <%=request.getProtocol() %><br>
전송방식 : <%=request.getMethod() %><br>
프로젝트 경로(컨텍스트 경로) : <%=request.getContextPath() %><br>
클라이언트(사용자) IP 주소 : <%=request.getRemoteAddr() %><br>
웹서버의 물리적 경로 : <%=request.getRealPath("/") %><br>
http 헤더 이름 accept 정보 : <%=request.getHeader("accept") %><br>
http 헤더 이름 accept-language 정보 : <%=request.getHeader("accept-language") %><br>
http 헤더 이름 user-agent 정보 : <%=request.getHeader("user-agent") %><br>
세션 정보 : <%=request.getSession() %><br>
세션 부여된 ID 정보 : <%=request.getRequestedSessionId() %><br>
</body>
</html>