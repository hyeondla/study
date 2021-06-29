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
	
	var h = $('h1').html(); // 태그 대상 html 내용 가져옴 
// 	alert(h);
	
// 	$('h1').html("내용 넣기"); // 덮어쓰기
	
	
// 	$('h1').html(function(index) {
// // 		alert(index);
// 		return "내용 넣기" + index;
// 	});
	
	$('h1').html(function(index, oldhtml) { // 이전 내용에 내용 추가
		return oldhtml + " 내용 넣기";
	});
	
});
</script>
</head>
<body>
<h1>head-0</h1>
<h1>head-1</h1>
<h1>head-2</h1>
</body>
</html>