<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value='/resources/css/default.css'/>"  rel="stylesheet" type="text/css">
<link href="<c:url value='/resources/css/subpage.css'/>" rel="stylesheet" type="text/css">
</head>
<body>
<div id="wrap">
<!-- 헤더 -->
<jsp:include page="../inc/top.jsp"/>

<!-- 본문 -->
	<!-- 메인 이미지 -->
	<div id="sub_img_member"></div>
	<!-- 왼쪽 메뉴 -->
	<nav id="sub_menu">
			<ul>
				<li><a href="#">Privacy policy</a></li>
			</ul>
	</nav>
	<c:if test="${empty sessionScope.id }">
		<c:redirect url="/member/login" />
	</c:if>
	<!-- 본문 내용 -->
	<article>
		<h1>Update Info</h1>
		<form action="<c:url value='/member/updatePro'/>"  method="post" id="join">
			<fieldset>
				<legend>Basic Info</legend>
					<label>User Id</label>
					<input type="text" name="id" value="${mb.id }" readonly class="id"><br>
					
					<label>Password</label>
					<input type="password" name="pass"><br>
					
					<label>Name</label>
					<input type="text" name="name" value="${mb.name }"><br>
					
					<label>E-Mail</label>
					<input type="email" name="email" value="${mb.email }"><br>
 			</fieldset>
			<fieldset>
				<legend>Optional</legend>
					<label>Address</label>
					<input type="text" name="address" value="${mb.address }"><br>
					
					<label>Phone Number</label>
					<input type="text" name="phone" value="${mb.phone }"><br>
					<label>Mobile Phone number</label>
					<input type="text" name="mobile" value="${mb.mobile }"><br>
			</fieldset>
			<div class="clear"></div>
			<div id="buttons">
				<input type="submit" value="Update" class="submit">
				<input type="reset" value="Cancel" class="cancel">
			</div>
		</form>
	</article>
	<div class="clear"></div>
<jsp:include page="../inc/bottom.jsp"/>
</div>
</body>
</html>