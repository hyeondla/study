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
	session : 서버, 클라이언트 연결 정보를 서버에 저장
			  sessionID 부여
			  
	session 삭제 : 1. 로그아웃 
				   2. 브라우저 모든 창 닫기
				   3. 30분 이상 브라우저 작업 X 
	
 */
%>
세션 ID : <%=session.getId() %><br>
세션 생성 시간 : <%=session.getCreationTime() %><br>
세션 접근 시간 : <%=session.getLastAccessedTime() %><br>
세션 유지 시간 : <%=session.getMaxInactiveInterval() %>초<br>
세션 유지 시간 변경 
<%
	session.setMaxInactiveInterval(3600);
%><br>
세션 초기화(전체 세션 삭제) : 로그아웃
<%
	session.invalidate();
%><br>
</body>
</html>