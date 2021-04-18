> HTML 문서의 기본 형식

```html
<!DOCTYPE html>
<html>
	<head>
    	<title> 웹 문서 제목 </title> 
    </head>        
    <body>
        웹 문서 내용
    </body>
</html>
</!doctype>
```

<br>

> <태그 속성="값" 속성="값"></태그>

<br>

> 구획 태그

〈article〉 여러 개의 내용으로 나누는 구분, 본문 내의 세부 절 〈/article〉

〈aside〉 주요 내용 이외의 문서 내용, 사이드 바 〈/aside〉

〈footer〉 저작자, 저작권 정보 〈/footer〉

〈header〉 사이트 소개,로고 〈/header〉

〈nav〉 네이게이션, 웹 문서 내의 메뉴 〈/nav〉

〈section〉 문서의 내용, 웹 문서의 본문 〈/section〉

<br>

> 제목 크기 조절 태그

〈h1〉 〈h2〉 〈h3〉 〈h4〉 〈h5〉 〈h6〉 

&nbsp;&nbsp;&nbsp;큼  ──────────────  작음

<br>

> 정리 태그

〈br〉 줄 바꿈

〈p〉 문단 나누기 〈/p〉

〈hr〉 수평선

〈pre〉 편집기에 입력한 형태 그대로 웹 문서에 보여줌 〈/pre〉

〈div〉 블록 지정 〈/div〉

〈span〉 인라인 블록 지정 〈/span〉

<br>

> 목록 태그

〈ul〉 번호 없는 목록 〈/ul〉

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;속성 type 값 disc / square / circle 항목에 사용할 점의 모양

〈ol〉 번호 있는 목록 〈/ol〉

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;속성 type 값 1 / A / a / I / i 항목에 사용할 번호의 종류

〈li〉 항목, ul/ol 태그 안에 사용 〈/li〉

<br>

> 글자 스타일 태그

〈b〉 굵게 〈/b〉

〈u〉 밑줄 〈/u〉

〈i〉 이탤릭체 〈/i〉

〈sub〉 아랫첨자 〈/sub〉

〈sup〉 윗첨자 〈/sup〉

〈small〉 조금 작게 〈/small〉

<br>

> 루비 글자 태그

〈ruby〉 글자 위에 주석 〈/ruby〉

〈rt〉 문자에 대한 설명, 발음 표현, ruby 태그 안에 사용 〈/rt〉

<br>

> 특수 문자 입력

 ＆nbsp;  공백

 ＆lt; < 

 ＆gt; &gt; 

 ＆amp; &amp; 

 ＆quot; "

 ＆copy; &copy; 

<br>

> 이미지 삽입

〈img src="이미지 파일 경로" width="폭" height="높이" alt="설명"〉

<br>

> 멀티미디어 삽입

〈embed src="멀티미디어 파일 경로" width="폭" height="높이"〉

-------------------------------------------------------------------------------------------

〈audio autoplay controls src="오디오 파일 경로"〉〈/audio〉

〈video autoplay controls src="비디오 파일 경로"〉〈/video〉

속성  autoplay 자동플레이

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;controls 컨트롤 기능 

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;loop 반복 재생

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;muted 뮤트

<br>

> 테이블

```html
<table>
	<tr>
    	<td> (1,1) </td>
        <td> (1,2) </td>
        <td> (1,3) </td>
    </tr>
    <tr>
    	<td> (2,1) </td>
        <td> (2,2) </td>
        <td> (2,3) </td>
    </tr>
</table>
```

〈tr〉 테이블 한 줄 정의 〈/tr〉

속성 border 테두리 두께 지정

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;bgcolor 배경 색상 지정

-------------------------------------------------------------------------------------------

〈th〉 셀을 제목으로 지정, 굵은 글씨,가운데 정렬, tr 태그 안에 사용 〈/th〉

〈td〉 셀, tr 태그 안에 사용 〈/td〉

속성 colspan 위치한 셀로부터 합칠 칸의 수 지정

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;rowspan 위치한 셀로부터 합칠 줄의 수 지정

<br>

> 색상 지정

1. 16진수 : #000000, 3쌍의 2자리 16진수(00~FF)
2. 색상명 : 웹 브라우저와  HTML에서 지정한 색상명 사용
3.  RGB코드 : RGB(000,000,000), RED/GREEN/BLUE 00~255

<br>

> 하이퍼링크

〈a href="URL"〉 클릭시 이동할 텍스트/이미지 〈/a〉

속성 target 값 _blank 새 창에서 열기

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;_parent 현재 프레임의 부모 프레임에서 열기

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;_self 현재 프레임 페이지에서 열기 (기본)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;_top 최상위의 화면에서 열기, 전체 화면으로 표시

-------------------------------------------------------------------------------------------

html 파일 외에도 여러 종류의 파일 연결 가능

이미지 파일 : gif, jpg, png

음악 파일 : wav, mid, wma

동영상 파일 : asf, wmv, asx, mpeg, mov

압축 파일 : zip

텍스트 파일, 문서 : txt, hwp, docx, pdf

-------------------------------------------------------------------------------------------

특정 위치로 이동

1. 같은 문서의 특정 위치로 이동

```html
<a href="#이름"> 클릭시 이름으로 이동 </a>
<!-- 중간 내용 -->
<a name="이름"> 이동하여 보여질 내용 </a>
```

2. 다른 문서의 특정 위치로 이동

```html
<a href="파일명#이름"> 클릭시 다른 파일의 이름으로 이동 </a>
<!-- 중간 내용 -->
<a name="이름"> 이동하여 보여질 내용 </a>
```

<br>

