<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head> 
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value='/resources/css/default.css'/>" rel="stylesheet" type="text/css">
<link href="<c:url value='/resources/css/subpage.css'/>" rel="stylesheet" type="text/css">
<script src="<c:url value='/resources/script/jquery-3.6.0.js'/>"></script>
<script type="text/javascript">
$(document).ready(function() {
	
	$('#join').submit(function() {
		if($('#id').val()==""){
			alert("아이디를 입력하세요");
			$('#id').focus();
			return false;
	    }
		if($('#pass').val()==""){
			alert("비밀번호를 입력하세요");
			$('#pass').focus();
			return false;
		}
		if($('#name').val()==""){
			alert("이름을 입력하세요");
			$('#name').focus();
			return false;
		}
		if($('#email').val()==""){
			alert("이메일을 입력하세요");
			$('#email').focus();
			return false;
		}
	});
	
	// 아이디 중복 체크
	$('#btn').click(function() {
		$.ajax('<c:url value="/member/idcheck"/>',{
			data:{id:$('#id').val()},
			success:function(rdata){
				if(rdata=='iddup'){
					rdata="아이디 중복";
				} else {
					rdata="아이디 사용가능";
				}
				$('#dup').html(rdata);
			}
		});
	});
	
	
	
});
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
		<form action="<c:url value='/member/insertPro'/>" method="post" id="join" name="fr">
			<fieldset>
				<legend>Basic Info</legend>
					<label>User Id</label>
					<input type="text" name="id" class="id" id="id">
					<input type="button" value="dup.check" class="dup" id="btn">
<!-- 					<div id="dup"></div> -->
					<span id="dup"></span>
					<br>
					
					<label>Password</label>
					<input type="password" name="pass" id="pass"><br>
					<label>Retype Password</label>
					<input type="password" name="pass2"><br>
					
					<label>Name</label>
					<input type="text" name="name" id="name"><br>
					
					<label>E-Mail</label>
					<input type="email" name="email" id="email"><br>
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