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
	
	$('h1').bind('click',function(){
		$(this).html('클릭시 내용변경');
	});
	
	$('h2').click(function() {
		$(this).html('클릭시 내용변경2');
		alert('이벤트 발생');
		$(this).unbind(); // 이벤트 해제 => 한번만 실행
	});
	
	$('#btn').click(function() {
		alert('버튼');
	});
	
	$('#img1').mouseover(function() {
// 		alert('마우스오버');
		$(this).attr('src','4.jpg');
	}).mouseout(function() {
		$(this).attr('src','3.jpg');
	})
	
});
</script>
</head>
<body>
<img src="3.jpg" id="img1">
<h2>head2-0</h2>
<h2>head2-1</h2>
<h2>head2-2</h2>
<h1>head-0</h1>
<h1>head-1</h1>
<h1>head-2</h1>
<input type="button" value="버튼" id="btn">
</body>
</html>