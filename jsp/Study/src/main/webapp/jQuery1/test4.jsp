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
	
	var wid=$('img').attr('width');
// 	alert(wid);
	$('img').attr('width','300');
	
	var w=['100','200','300'];
	$('img').attr('width', function(index) {
		return w[index];
	});
	
	$('img').attr({
		width:300,
		height:400
	});
	
	$('img').attr({
		width:function(index){
			return w[index];
		},
		height:400
	})
	
});
</script>
</head>
<body>
<img src="3.jpg" width="400" height="200">
<img src="4.jpg" width="400" height="200">
<img src="5.jpg" width="400" height="200">
</body>
</html>