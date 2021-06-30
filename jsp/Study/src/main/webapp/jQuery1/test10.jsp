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
	
	$('h1').click(function() {
		$(this).next().toggle('slow',function(){
			alert("효과 끝");
		});
	});
	
});
</script>
</head>
<body>
<h1>열고 닫기 1</h1>
<div>
<h1>제목1</h1>
<p>내용1</p>
</div>

<h1>열고 닫기 2</h1>
<div>
<h1>제목2</h1>
<p>내용2</p>
</div>
</body>
</html>