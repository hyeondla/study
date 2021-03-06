<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 헤더 -->
<header>
	<% 
	String id = (String)session.getAttribute("id");
	if(id == null) { //세션값 없음
		%>
		<!-- 로그인 / 가입-->
		<div id="login"><a href="../member/login.jsp">login</a> | <a href="../member/join.jsp">join</a></div>
		<%
	} else { //세션값 있음
		%>
		<!-- 로그아웃 / 정보 수정 -->
		<div id="login"><%=id %>님 | <a href="../member/logout.jsp">logout</a> | <a href="../member/update.jsp">update</a></div>
		<%
	}
	%>
	<div class="clear"></div>
	<!-- 로고 -->
	<div id="logo"><img src="../images/logo.gif"></div>
	<!-- 메뉴 -->
	<nav id="top_menu">
		<ul>
			<li><a href="../main/main.jsp">HOME</a></li>
			<li><a href="../company/welcome.jsp">COMPANY</a></li>
			<li><a href="../company/welcome.jsp">SOLUTIONS</a></li>
			<li><a href="../center/notice.jsp">CUSTOMER CENTER</a></li>
			<li><a href="../company/welcome.jsp">CONTACT US</a></li>
		</ul>
	</nav>
</header>