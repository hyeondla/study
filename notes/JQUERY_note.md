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