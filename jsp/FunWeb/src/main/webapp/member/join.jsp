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
<div id="wrap">
<!-- 헤더 -->
<header>
	<!-- 로그인 / 가입-->
	<div id="login"><a href="../member/login.jsp">login</a> | <a href="../member/join.jsp">join</a></div>
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

<!-- 본문 -->
	<!-- 메인 이미지 -->
	<div id="sub_img_member"></div>
	<!-- 왼쪽 메뉴 -->
	<nav id="sub_menu">
			<ul>
				<li><a href="#">Join us</a></li>
				<li><a href="#">Privacy policy</a></li>
				
			</ul>
	</nav>
	<!-- 본문 내용 -->
	<article>
		<h1>Join Us</h1>
		<form action="joinPro.jsp" method="post" id="join">
			<fieldset>
				<legend>Basic Info</legend>
					<label>User Id</label>
					<input type="text" name="id" class="id">
					<input type="button" value="dup.check" class="dup"><br>
					
					<label>Password</label>
					<input type="password" name="pass"><br>
					<label>Retype Password</label>
					<input type="password" name="pass2"><br>
					
					<label>Name</label>
					<input type="text" name="name"><br>
					
					<label>E-Mail</label>
					<input type="email" name="email"><br>
					<label>Retype E-Mail</label>
					<input type="email" name="email2"><br>
 			</fieldset>
			<fieldset>
				<legend>Optional</legend>
					<label>Address</label>
					<input type="text" name="address"><br>
					
					<label>Phone Number</label>
					<input type="text" name="phone"><br>
					<label>Mobile Phone number</label>
					<input type="text" name="mobile"><br>
			</fieldset>
			<div class="clear"></div>
			<div id="buttons">
				<input type="submit" value="Submit" class="submit">
				<input type="reset" value="Cancel" class="cancel">
			</div>
		</form>
	</article>
<div class="clear"></div>

<!-- 푸터 -->
<footer>
<hr>
<div id="copy">
All contents Copyright 2011 FunWeb 2011 FunWeb Inc. all rights reserved<br>
Contact mail:funweb@funwebbiz.com Tel +82 64 123 4315 Fax +82 64 123 4321
</div>
<div id="social">
<img src="../images/facebook.gif" alt="Facebook">
<img src="../images/twitter.gif" alt="Twitter">

</div>
</footer>
</div>
</body>
</html>