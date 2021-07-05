<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main/main.jsp</title>
<link href="../css/default.css" rel="stylesheet" type="text/css">
<link href="../css/front.css" rel="stylesheet" type="text/css">
<script src="../script/jquery-3.6.0.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('.brown').click(function() {
		$.getJSON('json.jsp', function(rdata) {
			$.each(rdata, function(index,item) {
				// 문자열 => Date 날짜객체
				nowdate = new Date(item.date);
				// 날짜 년, 월, 일 => 문자열
				date_str = nowdate.getFullYear() + "." + (nowdate.getMonth()+1) + "." + nowdate.getDate();
				$('table').append('<tr><td class="contxt"><a href="../center/content.jsp?num='+item.num+'">'+item.subject+'</a></<td><td>'+date_str+'</td></tr>');
			});
		});
		$(this).unbind();
	});
});
</script>
</head>
<body>
<div id="wrap">
<!-- 헤더 들어가는곳 -->
<jsp:include page="../inc/top.jsp"/>
<!-- 헤더 들어가는곳 -->
  
<div class="clear"></div>   
<!-- 본문들어가는 곳 -->
  <!-- 메인 이미지 -->
  <div id="main_img"><img src="../images/main_img.jpg"></div>
  <!-- 본문 내용 -->
  <article id="front">
  	<div id="solution">
  		<div id="hosting">
  			<h3>Web Hosting Solution</h3>
			<p>Lorem impsun Lorem impsunLorem impsunLorem impsunLorem impsunLorem impsunLorem impsunLorem impsunLorem impsunLorem impsun....</p>
  		</div>
  		<div id="security">
  		  	<h3>Web Security Solution</h3>
			<p>Lorem impsun Lorem impsunLorem impsunLorem impsunLorem impsunLorem impsunLorem impsunLorem impsunLorem impsunLorem impsun....</p>
  		</div>
  		<div id="payment">
  			<h3>Web Payment Solution</h3>
			<p>Lorem impsun Lorem impsunLorem impsunLorem impsunLorem impsunLorem impsunLorem impsunLorem impsunLorem impsunLorem impsun....</p>
  		</div>
  	</div>
  	
  	<div class="clear"></div>
 	
 	
 	  	<div id="sec_news">
<h3><span class="orange">Security</span> News</h3>
<dl>
<dt>Vivamus id ligula....</dt>
<dd>Proin quis ante Proin quis anteProin 
quis anteProin quis anteProin quis anteProin 
quis ante......</dd>
</dl>
<dl>
<dt>Vivamus id ligula....</dt>
<dd>Proin quis ante Proin quis anteProin 
quis anteProin quis anteProin quis anteProin 
quis ante......</dd>
</dl>
</div>


	<div id="news_notice">
  		<h3 class="brown">News &amp; Notice</h3>
  		<table>
  		
  		</table>
  	</div>
	
 	
  </article>
  
  
<div class="clear"></div>  
<!-- 푸터 들어가는곳 -->
<jsp:include page="../inc/bottom.jsp"/>
<!-- 푸터 들어가는곳 -->
</div>
</body>
</html>


