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
	
	// each() 반복문
	$('h1').each(function(index) {
// 		alert(index);
		$(this).html(index);
	});
	
	// .each(배열변수)	
	var array = [
		{'num':'1', 'subject':'제목1'},
		{'num':'2', 'subject':'제목2'},
		{'num':'3', 'subject':'제목3'},
	];
	$.each(array,function(index,item){
// 		alert(index);
// 		alert(item.num);
// 		alert(item.subject);
		
		$('table').append("<tr><td>"+item.num+"</td><td>"+item.subject+"</td></tr>");
		
	});
	
});
</script>
</head>
<body>
<h1>item-0</h1>
<h1>item-1</h1>
<h1>item-2</h1>
<h1>item-3</h1>
<h1>item-4</h1>
<table border="1">
<tr><td>번호</td><td>내용</td></tr>
</table>
</body>
</html>