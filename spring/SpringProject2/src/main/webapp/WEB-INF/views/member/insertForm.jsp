<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src='<c:url value="/resources/script/jquery-3.6.0.js" />'></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#btn').click(function(){
// 			alert("아이디중복체크 버튼 클릭");
			$.ajax('<c:url value="/member/idcheck" />',{
				data:{id:$('#id').val()},
				success:function(rdata){
					if(rdata=="iddup"){
						rdata="아이디 중복"
					}else{
						rdata="아이디 사용가능"
					}
					$('#dupdiv').html(rdata);
				}
			});
		});
	});
</script>
</head>
<body>
<form action='<c:url value="/member/insertPro" />' method="post" id="fr">
아이디 : <input type="text" name="id" id="id">
<input type="button" value="아이디중복체크" id="btn">
<div id="dupdiv"></div><br>
비밀번호 : <input type="password" name="pass"><br>
이름 : <input type="text" name="name"><br>
<input type="submit" value="회원가입">
</form>
</body>
</html>