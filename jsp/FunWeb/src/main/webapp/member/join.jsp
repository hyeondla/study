<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/default.css" rel="stylesheet" type="text/css">
<link href="../css/subpage.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	function winopen() {
		if(document.fr.id.value == "") {
			alert("아이디를 입력하세요");
			document.fr.id.focus();
			return;
		}
		var id=document.fr.id.value;
		document.open("winopen.jsp?id="+id,"","width=400,height=300");
	}
</script>
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
				<li><a href="#">Join us</a></li>
				<li><a href="#">Privacy policy</a></li>
				
			</ul>
	</nav>
	<!-- 본문 내용 -->
	<article>
		<h1>Join Us</h1>
		<form action="joinPro.jsp" method="post" id="join" name="fr">
			<fieldset>
				<legend>Basic Info</legend>
					<label>User Id</label>
					<input type="text" name="id" class="id">
					<input type="button" value="dup.check" class="dup" onclick="winopen()"><br>
					
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
<jsp:include page="../inc/bottom.jsp"/>
</div>
</body>
</html>