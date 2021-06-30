<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../script/jquery-3.6.0.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('#fr').submit(function() {
// 		alert("전송");
		var id=$('#id').val();
		var pass=$('#pass').val();
// 		alert(id);
		
		if(id==""){
			alert("아이디 입력하세요");
			$('#id').focus();
			return false;
		}
		if(pass==""){
			alert("비밀번호를 입력하세요");
			$('#pass').focus();
			return false;
		}
		if($('#gender1').is(":checked")==false && $('#gender2').is(":checked")==false){
			alert("성별을 체크하세요");
			return false;
		}
		if($('#age').val()==""){
			alert("연령을 선택하세요");
			return false;
		}
			
	});
})
</script>
</head>
<body>
<form action="test9Pro.jsp" method="post" id="fr">
아이디 : <input type="text" name="id" id="id"><br>
비밀번호 : <input type="password" name="pass" id="pass"><br>
성별 : <input type="radio" name="gender" value="남" id="gender1">남
	   <input type="radio" name="gender" value="여" id="gender2">여
연령 : <select name="age" id="age">
	<option value="">선택해주세요</option>
	<option value="10대">10대</option>
	<option value="20대">20대</option>
	<option value="30대">30대</option>
</select>
<input type="submit" value="회원가입">
</form>
</body>
</html>