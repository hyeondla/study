<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
*{
	margin: 0px; 
	padding: 0px;
}
ul{
	list-style: none;
}
img {
	width: 300px;
}
</style>
<script src="../script/jquery-3.6.0.js"></script>
<script src="../script/jquery.innerfade.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('#inner_fade').innerfade({
		animationtype:'fade',
		speed:750,
		timeout:2000,
		type:'random',
		containerheight:'350px'
	});
});
</script>
</head>
<body>
<ul id="inner_fade">
<li><img src="3.jpg"></li>
<li><img src="4.jpg"></li>
<li><img src="5.jpg"></li>
</ul>
</body>
</html>