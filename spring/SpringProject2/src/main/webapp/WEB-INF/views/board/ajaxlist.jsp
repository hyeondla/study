<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src='<c:url value="/resources/script/jquery-3.6.0.js" />'></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#btn').click(function(){
			$.getJSON('<c:url value="/board/ajaxlist" />',function(rdata){
				$.each(rdata,function(index,item){
					$('table').append('<tr><td>'+item.num+'</td><td>'+item.subject+'</td><td>'+item.name+'</td><td>'+item.date+'</td><td>'+item.readcount+'</td></tr>');
				});
			});
		});
	});
</script>
</head>
<body>
<input type="button" value="글목록" id="btn">
<table border="1">
<tr><td>글번호</td><td>글제목</td><td>글쓴이</td><td>작성일</td><td>조회수</td></tr>

</table>
</body>
</html>