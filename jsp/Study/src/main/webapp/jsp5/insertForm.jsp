<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="insertPro.jsp" method="post">
아이디 : <input type="text" name="id"><br>
비밀번호 : <input type="password" name="pass"><br>
이름 : <input type="text" name="name"><br>
<!-- 	나이, 성별, 이메일 추가 -->
나이 : <input type="text" name="age"><br>
성별 : 
<input type="radio" name="gender" value="남">남
<input type="radio" name="gender" value="여">여<br>
이메일 : <input type="text" name="email"><br>
<input type="submit" value="회원가입">
</form>
</body>
</html>