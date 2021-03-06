https://jquery.com/download/

Download the uncompressed, development jQuery 3.6.0

→ 다른 이름으로 저장 → jquery-3.6.0.js

```jsp
<head>
<script src="(경로)/jquery-3.6.0.js"></script>
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
```

```javascript
$(document).ready(function(){
	// 전체선택자.함수()
    $('*').css('color','red');
	// 태그선택자.함수()
    $('태그').css('color','red');
	// 아이디선택자.함수()
    $('#아이디').css('color','red');
	// 클래스선택자.함수()
    $('.클래스').css('color','red');
    
    // 태그[속성=값].함수()
    $('input[type=text]').css('color','red');
    $('input[type=password]').css('color','red');
    
    // 태그:odd → 홀수
    $('tr:odd').css('background','pink');
    // 태그:even → 짝수
    $('tr:even').css('background','pink');
    // 태그:first → 첫번째
    $('tr:first').css('background','pink');
    // 태그:last → 마지막
    $('tr:last').css('background','pink');
});
```

<br>

https://api.jquery.com/

<br>

> css 

```javascript
$(document).ready(function(){
    
	// .css( propertyName ) → 태그의 속성값을 리턴
    var color = $('h1').css('color'); 
    
	// .css( propertyName, value ) → 태그의 속성값을 바꿈
    $('h1').css('color','red'); 
    
	// .css( propertyName, function ) → 함수 사용
    var color=['blue','green','orange'];
    $('h1').css('color', function(index){ // index → 변수, 태그 대상 순서값
        return color[index];
    });	

	// .css( properties ) → 여러 개의 속성값을 바꿈
    $('h1').css('color','blue').css('background','pink');
    
    $('h1').css({
        color:'blue',
        background:'pink'
	});
   
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
```

<br>

> attr

```javascript
$(document).ready(function(){
    
    // .attr( attributeName ) → 속성의 속성값을 리턴
    var w = $('img').attr('width');
    
    // .attr( attributeName, value ) → 속성의 속성값을 바꿈
    $('img').attr('width','300'); 
    
    // .attr( attributes ) → 여러 개의 속성값을 바꿈
    $('img').attr({
		width:300,
		height:400
	});
    
    // .attr( attributeName, function ) → 함수 사용
    var w = ['100','200','300'];
	$('img').attr('width', function(index) {
		return width[index];
	});
    
});
```

<br>

> html 

```javascript
$(document).ready(function(){
  
	// .html() → 태그의 html 내용을 리턴
	var h = $('h1').html();
   
	// .html( htmlString )
    $('h1').html("문자열"); // → 덮어쓰기
    
    // .html( function )
    $('h1').html(function(index, oldhtml) { // → 이전 내용에 문자열 추가
		return oldhtml + " 문자열";
	});
    
});
```

<br>

> append 

```javascript
$(document).ready(function(){
    
    // .append() → 태그 뒤에 추가
    $('body').append("추가할 내용"); 
    $('table').append("<tr><td>내용</td><td>내용</td></tr>");
    
});
```

<br>

> each 

```javascript
$(document).ready(function() {
    
    // .each( function ) → 반복
	$('h1').each(function(index) {
		$(this).html(index);
	});
    
    // .each( array, function )
    var array = [
		{'num':'1', 'subject':'제목1'},
		{'num':'2', 'subject':'제목2'},
		{'num':'3', 'subject':'제목3'},
	];
    $.each(array,function(index,item){
        // 테이블에 열 추가
        $('table').append("<tr><td>"+item.num+"</td><td>"+item.subject+"</td></tr>");
    });
    
});
```

<br>

> bind 

```javascript
$('h1').bind('click',function(){
	$(this).html('클릭시 내용변경');
});
```

<br>

> click

```javascript
$('h2').click(function() {
	$(this).html('클릭시 내용변경');
 	$(this).unbind(); // 이벤트 해제 => 총 한번만 실행
});
```

<br>

> mouseover, mouseout

```javascript
$('#img1').mouseover(function() { 
	$(this).attr('src','4.jpg');
}).mouseout(function() {
	$(this).attr('src','3.jpg');
})
```

<br>

> toggle

```javascript
$('h1').click(function() {
    $(this).next().toggle();
	$(this).next().toggle('slow');
    $(this).next().toggle('slow',function(){
        alert("내용");
    });
});
```

<br>

> submit 

```javascript
$('#fr').submit(function(){ // 폼 id="fr"
    
    if($('#id').val()==""){
		alert("아이디를 입력하세요");
		$('#id').focus();
		return false;
    }
    
	if($('#pass').val()==""){
		alert("비밀번호를 입력하세요");
		$('#pass').focus();
		return false;
	}
    
    // input type="radio" → 옵션에 id
	if($('#gender1').is(":checked")==false && $('#gender2').is(":checked")==false){
		alert("성별을 체크하세요");
		return false;
	}
    
    // select id="age"
    if($('#age').val()==""){
		alert("연령을 선택하세요");
		return false;
	}
    
});
```

<br>

> innerfade.js

```jsp
<head>
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
```

<br>

> AJAX 비동기방식

```javascript
$('#btn').click(function() {
	$.ajax('string.jsp',{ // 이동할 페이지
		data:{id:$('#id').val()}, // 데이터 넘기기
		success:function(rdata){ // rdata : 이동한 페이지로부터 받아올 데이터
			$('#dup').html(rdata); // 출력
		}
	});
});
```

<br>

> XML

```jsp
<%@ page language="java" contentType="text/xml; charset=UTF-8" pageEncoding="UTF-8"%>
<member>
<person><id>id1</id><pass>pw1</pass><name>이름1</name></person>
<person><id>id2</id><pass>pw2</pass><name>이름2</name></person>
<person><id>id3</id><pass>pw3</pass><name>이름3</name></person>
</member>
```

```javascript
$(document).ready(function() {
	$('#btn').click(function() {
		$.ajax('xml.jsp',{
			success:function(rdata){
				// find() : 태그 찾기
				$(rdata).find('person').each(function(){ // each() : 반복
					var id = $(this).find('id').text(); // text() : 글자 가져오기
					var pass = $(this).find('pass').text();	
					var name = $(this).find('name').text();
					$('table').append('<tr><td>'+id+'</td><td>'+pass+'</td><td>'+name+'</td></tr>'); // 출력
				});
			}
		})
		$(this).unbind();
	});
});
```

<br>

> JSON

webapp → WEB-INF → lib → **json-simple-1.1.1.jar**

```jsp
<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
[
{"id":"id1","pass":"pw1","name":"이름1"},
{"id":"id2","pass":"pw2","name":"이름2"},
{"id":"id3","pass":"pw3","name":"이름3"}
]

<!-- ----------------DB------------------- -->
<%
// JDBC 연결 과정 생략
JSONArray mblist = new JSONArray();
while(rs.next()) {
	JSONObject mb = new JSONObject();

    // 모두 문자열(getString)으로 받아옴
	mb.put("id", rs.getString("id"));
	mb.put("pass", rs.getString("pass"));
	mb.put("name", rs.getString("name"));
	mb.put("date", rs.getString("date"));
	
	mblist.add(mb);	
}
%>
```

```javascript
$('#btn').click(function() {
	$.getJSON('json1.jsp', function(rdata) {
		$.each(rdata, function(index, item) {
            nowdate = new Date(item.date); // 문자열 → Date 객체
            date_str = nowdate.getFullYear() + "." + (nowdate.getMonth()+1) + "." + nowdate.getDate(); // 년.월.일 → 문자열
            
			$('table').append('<tr><td>'+item.id+'</td><td>'+item.pass+'</td><td>'+item.name+'</td><td>'+date_str+'</td></tr>');
		});
	});
	$(this).unbind();
});
```

<br>

