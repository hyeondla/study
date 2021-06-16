<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="mailSend.jsp" method="post">
보내는 사람 메일 (관리자) : <input type="text" name="sender"><br>
받는 사람 메일 (사용자) : <input type="text" name="receiver"><br>
제목 : <input type="text" name="subject"><br>
내용 : <textarea rows="20" cols="40" name="content"></textarea><br>
<input type="submit" value="전송">
</form>
</body>
</html>