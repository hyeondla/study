<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../script/jquery-3.6.0.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	// $선택자.함수()
	$('*').css('color','red');
	$('h1').css('color','blue');
	$('#ta').css('color', 'purple');
	$('.ta2').css('color', 'orange');
	// $태그[속성=값]
	$('input[type=text]').css('color','green');
	$('input[type=password]').css('color','yellow');
	// 
	$('tr:odd').css('background','pink');
	$('tr:even').css('background','yellow');
	$('tr:first').css('background','green');
	$('tr:last').css('background','purple');
});
</script>
</head>
<body>

<table>
<tr><td>번호</td><td>제목</td><td>작성자</td></tr>
<tr><td>1</td><td>제목1</td><td>작성자1</td></tr>
<tr><td>2</td><td>제목2</td><td>작성자2</td></tr>
<tr><td>3</td><td>제목3</td><td>작성자3</td></tr>
<tr><td>4</td><td>제목4</td><td>작성자4</td></tr>
</table>

<br>

<input type="text" value="안녕">
<input type="password" value="1234">

<h1>제목1</h1>
<h1 id="ta">제목2</h1>
<h1 class="ta2">제목3</h1>
내용
</body>
</html>