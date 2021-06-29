<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jQuery/test1.jsp</title>
<script src="../script/jquery-3.6.0.js"></script>
<script type="text/javascript">
jQuery(document).ready(function(){
	alert("첫번째 방법");
});

$(document).ready(function(){
	alert("두번째 방법");
});

$(function(){
	alert("세번째 방법");
});
</script>
</head>
<body>

</body>
</html>



