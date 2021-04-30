<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>scopePro.jsp</h1>
<%
/*
사용자가 서버에 scopePro.jsp 요청
→ http가 태그정보, 클라이언트정보, 서버정보, 세션정보, 쿠키정보를 들고 웹서버로 감
웹애플리케이션 서버 → request 내장객체 생성해서  http가 들고온 요청정보 저장
*/
String id = request.getParameter("id");
String pw = request.getParameter("pw");

//내장객체에 값 저장
pageContext.setAttribute("page", "pageContext value");
request.setAttribute("req", "reqest value");
session.setAttribute("ses", "session value");
application.setAttribute("app", "application value");
%>

요청정보 아이디 : <%=id %><br>
요청정보 비밀번호 : <%=pw %><br>
pageContext 값 : <%=pageContext.getAttribute("page") %><br>
request 값 : <%=request.getAttribute("req") %><br>
session 값 : <%=session.getAttribute("ses") %><br>
application 값 : <%=application.getAttribute("app") %><br>
 
<a href="scopeProPro.jsp?id=<%=id%>&pw=<%=pw%>">scopeProPro.jsp 이동(요청)</a>
<!-- ---------------------------------------------------------------------- -->
<script type="text/javascript">
// 	alert("scopeProPro.jsp 이동");
<%-- 	location.href="scopeProPro.jsp?id=<%=id%>&pw=<%=pw%>"; --%>
</script>
<%
// response.sendRedirect("scopeProPro.jsp?id="+id+"&pw="+pw);
%>

<!-- ============================================================================= -->
<% /*
액션태그 - forward : 요청(이동)
주소줄 : scopePro.jsp → 화면페이지 : scopeProPro.jsp
scopePro.jsp에 있는 모든 request 정보 공유
*/ %>
<%-- <jsp:forward page="scopeProPro.jsp" /> --%>


</body>
</html>