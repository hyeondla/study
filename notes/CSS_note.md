> CSS 적용

1. 외부 스타일시트 파일 연결 (Linked Style)

```css
<head>
	<link rel="stylesheet" type="text/css" href="css파일 경로">
</head>
```

2. 문서 내부에 정의 (Embedded Style)

```css
<head>
	<style type="text/css">
		/* 내용 작성 */
	</style>
</head>
```

3. 태그에 직접 정의 (Inline Style)

```html
<head>...</head>
<body style="스타일속성:값">
	<!-- 내용 --> 
</body>
```

<br>

> 스타일시트 기본 형식

**적용대상 {스타일 속성: 값; 스타일 속성: 값}**

**태그1, 태그2, 태그3 {스타일 속성: 값}** 여러 태그에 같은 스타일 적용 `,` 사용

**태그1 태그2 {스타일 속성: 값}**  상위 태그에 포함된 하위 태그에만 스타일 지정 `Space Bar` 사용

**태그:not([type=타입명]) {스타일 속성: 값}** 타입 제외하고 적용

**태그:last-of-type{스타일 속성: 값}** 마지막 태그에만 적용

<br>

> Class `.`

```html
<head>
<style type="text/css">
    .이름1 {스타일속성: 값}
    .이름2 {스타일속성: 값}
    .이름3 {스타일속성: 값}
</style>
</head>
<body>
    <태그 class="이름1">...</태그>
    <태그 class="이름2 이름3">...</태그>
</body>
```

같은 태그라도 각각 다른 스타일을 지정하고자 할 때 클래스 이름으로 구분

<br>

> ID `#`

```html
<head>
<style type="text/css">
    #이름 {스타일속성: 값}
</style>
</head>
<body>
    <태그 id="이름">...</태그>
</body>
```

한 페이지에서 하나만 유효 → 한 태그에만 부여됨

<br>

> 배경 background

Selector**{background-color: 값}** 색상 바꾸기

Selector**{background-image: url(이미지 경로)}** 그림 바꾸기

Selector**{background-repeat: 값}** 반복되는 그림

옵션 **repeat** 가로, 세로 방향 계속 반복

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**no-repeat** 반복되지 않고 한번만

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**repeat-x** 가로 방향으로만 반복

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**repeat-y** 세로 방향으로만 반복

Selector**{background-attachment: 값}** 스크롤 지정

옵션 **scroll** 문서 내용이 스크롤되면 배경 그림도 같이 스크롤 (기본값)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**fixed** 배경 그림 고정

Selector**{background-position: 가로값 세로값}** 위치 지정

→ background-repeat: no-repeat

옵션 가로 **left, center, right, %**

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;세로 **top, center, bottom, %**

Selector**{background: image값 repeat값 attachment값 position값}** 

속성 한 번에 지정, `Space Bar` 구분

Selector**{background-size: 넓이값 높이값}** 크기 지정

Selector**{background-origin: 값}** 이미지 위치 지정

옵션 **content-box** 본문 안쪽

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**padding-box**

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**border-box** border 안쪽

<br>

>  테두리 border

Selector**{border-style: 값}** 테두리 형태 지정

옵션 none 지정안함

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**dotted** 점

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;dashed 점선

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**solid** 1줄 선

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;double 2줄 선

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;groove 입체감

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ridge 볼록하게 

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;inset 테두리 전체가 들어가 보임

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;outset 테두리 전체가 튀어나와 보임

Selector**{border-color: 값}** 테두리 색상 지정

Selector**{border-방향-width: 값}** 테두리 두께 지정

Selector**{border-width: 값}** 테두리 두께 한 번에 지정

옵션 값1 → 네 방향 모두 적용

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;값1 값2 → 상하 좌우

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;값1 값2 값3 값4 → top right bottom left

Selector**{border-radius: 값}** 테두리 둥글게

Selector**{box-shadow: 오른쪽값 아래쪽값 흐림정도 색상}** 테두리 그림자

<br>

> 바깥 여백 margin 

Selector**{margin-방향: 값}**  바깥 여백 지정

Selector**{margin: 값}** 바깥 여백 한 번에 지정

<br>

> 안쪽 여백 padding

Selector**{padding-방향: 값}** 안쪽 여백 지정

Selector**{padding: 값}** 안쪽 여백 한 번에 지정

<br>

> 문단

Selector**{top/bottom: 값; left/right: 값}** 위치 지정

→ 웹 브라우저 top/bottom과 left/right로부터 얼마만큼 떨어져있는지 지정

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;top, left 속성과 bottom, right 속성 동시 적용 불가

Selector**{width: 값; height: 값}** 폭, 높이 지정

----------------------------------------------------------------------------------------

※ **position** 속성과 함께 사용

옵션 **static** 자유로운 문단 배치에 사용,  top left 속성 적용 불가

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**relative** 상대적인 위치, 현재 콘텐츠 위치로부터 문단 시작, top 0 left 0

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**absolute** 절대적인 위치, 웹 브라우저 왼쪽 상단 모서리 top 0 left 0

<br>

> 글자

Selector**{color: 값}** 색상 지정

Selector**{font-family: 값1, 값2, 값3, ...}** 글꼴 지정

사용자의 컴퓨터에 글꼴1이 없을 경우 글꼴2, 글꼴3, ... , 기본글꼴 으로 대체 

Selector**{font-style: 값}** 형태 지정

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;값 **normal, italic, oblique**

Selector**{font-weight: 값}** 굵기 지정

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;값 **normal, bold, bolder, lighter, 100~900**

Selector**{font-size: 값}** 크기 지정

Selector**{font: style값 weight값 size값 height값 family값}**

속성 한 번에 지정, `Space Bar` 구분

<br>

> 문자 & 문단

Selector**{letter-spacing: 값}** 자간 지정

Selector**{word-spacing: 값}** 단어 간격 지정

Selector**{line-height: 값}** 줄 간격 지정

Selector**{white-space: 값}** 공백, 줄바꿈 지정

옵션 **normal** 여러 개의 공백을 하나로 표시

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**pre** 공백을 그대로 표시

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**nowrap** br태그 없이 줄 바꿈 허용 안함

Selector**{text-align: 값}** 글자,그림 위치 지정

옵션 **left** 왼쪽 정렬

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**center** 가운데 정렬

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**right** 오른쪽 정렬

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**justify** 양쪽 정렬

Selector**{vertical-align: 값}** 글자,그림 수직 정렬 지정

옵션 baseline 문자의 밑선에 맞춰 정렬

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;middle 문자의 중앙을 밑선으로 하여 정렬

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;sub 아랫첨자

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;super 윗첨자

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;text-top 문자의 윗선을 밑선으로 하여 정렬

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;text_bottom 문자의 밑선을 윗선으로 하여 정렬

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;top 위쪽 정렬

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;bottom 아랫쪽 정렬

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;% 퍼센트로 지정

Selector**{text-indent: 값}** 문단 들여쓰기

Selector**{text-shadow: 수평값 수직값 흐림거리값 색상값}** 그림자

Selector**{text-decoration: 값}** 글자에 밑줄긋기

옵션 **underline** 밑줄

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**none** 긋지 않음

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**overline** 텍스트 위에 선 긋기

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**line-through** 텍스트 가운데 선 긋기

Selector**{text-transform: 값}** 대/소문자 지정

옵션 **none** html 코드 그대로 표시

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**uppercase** 모두 대문자로 바꿈

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**lowercase** 모두 소문자로 바꿈

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**capitalize** 첫글자 대문자로 바꿈

Selector**{word-wrap: break-word}** 강제 줄 바꿈 

<br>

> 목록

Selector**{list-style-type: 값}** 머리 기호 바꾸기

옵션 **none** 지정하지 않음

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**circle** 원형

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**disc** 검은 원형

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**square** 사각형

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;lower-roman 소문자 로마자

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;lower-alpha 소문자 알파벳

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;decimal 10진수, 1부터 시작

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;upper-roman 대문자 로마자

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;upper-alpha 대문자 알파벳

Selector**{list-style-image: 파일 경로}** 머리 기호를 그림으로 지정

Selector**{list-style-position: 값}** 들여쓰기 지정

옵션 **inside** 머리 기호 들여쓰기

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**outside** 머리 기호 내어쓰기

<br>

> 하이퍼링크

Selector **a:link**{color:값; text-decoration:값} 기본

Selector **a:visited**{color:값; text-decoration:값} 방문한 하이퍼링크

Selector **a:hover**{color:값; text-decoration:값} 마우스 포인터를 올려놓았을 때

Selector **a:active**{color:값; text-decoration:값} 클릭하는 동안

<br>

> 사용자 인터페이스

Selector**{box-sizing: 값}** 

옵션 **content-box** 

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**border-box**

