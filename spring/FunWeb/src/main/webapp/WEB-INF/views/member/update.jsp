<%@page import="member.MemberBean"%>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/default.css" rel="stylesheet" type="text/css">
<link href="../css/subpage.css" rel="stylesheet" type="text/css">
</head>
<body>
<%
String id = (String)session.getAttribute("id");

if(id==null){
	response.sendRedirect("../member/login.jsp");
}

MemberDAO mdao = new MemberDAO();
MemberBean mb = mdao.getMember(id);
%>
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
	<!-- 본문 내용 -->
	<article>
		<h1>Update Info</h1>
		<form action="updatePro.jsp" method="post" id="join">
			<fieldset>
				<legend>Basic Info</legend>
					<label>User Id</label>
					<input type="text" name="id" value="<%=mb.getId() %>" readonly class="id"><br>
					
					<label>Password</label>
					<input type="password" name="pass"><br>
					
					<label>Name</label>
					<input type="text" name="name" value="<%=mb.getName() %>"><br>
					
					<label>E-Mail</label>
					<input type="email" name="email" value="<%=mb.getEmail() %>"><br>
 			</fieldset>
			<fieldset>
				<legend>Optional</legend>
					<label>Address</label>
					<input type="text" name="address" value="<%=mb.getAddress() %>"><br>
					
					<label>Phone Number</label>
					<input type="text" name="phone" value="<%=mb.getPhone() %>"><br>
					<label>Mobile Phone number</label>
					<input type="text" name="mobile" value="<%=mb.getMobile() %>"><br>
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