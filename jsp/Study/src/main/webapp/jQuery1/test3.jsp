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
	// 	.css( propertyName )
	var col = $('h1').css('color');
	// alert(col);
	
	// 	.css( propertyName, value )
	$('h1').css('color','red');
	
	// 	.css( propertyName, function )
	var color=['blue','green','orange'];
	$('h1').css('color', function(index){
		// index : h1 대상 순서값
	
		// 	alert(index);
	// 	if(index==0){
	// 		return 'blue';
	// 	} else if(index==1){
	// 		return 'green';
	// 	} else if(index==2){
	// 		return 'orange';
	// 	}
	
	// 	alert(color[index]);
		return color[index];
	});	
	
	// 	.css( properties )
	// $('h1').css('color','red').css('background','pink');
	// $('h1').css({
	// 	color:'blue',
	// 	background:'pink'
	// });
	
	var fontColor=['blue','yellow','white'];
	var backColor=['skyblue','green','orange'];
	$('h1').css({
		color:function(index){
			return fontColor[index];
		},
		background:function(index){
			return backColor[index];
		}
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