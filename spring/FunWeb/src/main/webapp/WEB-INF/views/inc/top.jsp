<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 헤더 -->
<header>
	<c:choose>
		<c:when test="${empty sessionScope.id }">
			<div id="login"><a href="<c:url value='/member/login'/>">login</a> | <a href="<c:url value='/member/insert'/>">join</a></div>
		</c:when>
		<c:otherwise>
			<div id="login">${sessionScope.id }님 | <a href="<c:url value='/member/logout'/>">logout</a> | <a href="<c:url value='/member/update'/>">update</a></div>
		</c:otherwise>
	</c:choose>
	
	<div class="clear"></div>
	<!-- 로고 -->
	<div id="logo"><img src="<c:url value='/resources/images/logo.gif'/>"></div>
	<!-- 메뉴 -->
	<nav id="top_menu">
		<ul>
			<li><a href="<c:url value='/main/main'/>">HOME</a></li>
			<li><a href="<c:url value='/company/welcome'/>">COMPANY</a></li>
			<li><a href="<c:url value='/company/welcome'/>">SOLUTIONS</a></li>
			<li><a href="<c:url value='/board/list'/>">CUSTOMER CENTER</a></li>
			<li><a href="<c:url value='/mail/mailForm'/>">CONTACT US</a></li>
		</ul>
	</nav>
</header>