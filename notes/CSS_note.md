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

<br>

> **Class** `.`

```html
<head>
<style type="text/css">
    .이름1 {스타일속성: 값}
    .이름2 {스타일속성: 값}
</style>
</head>
<body>
    <태그 class="이름1">...</태그>
    <태그 class="이름2">...</태그>
</body>
```

같은 태그라도 각각 다른 스타일을 지정하고자 할 때 클래스 이름으로 구분

<br>

> **ID** `#`

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

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**fixed** 배경 그림 고정

Selector**{background-position: 가로값 세로값}** 위치 지정

→ background-repeat: no-repeat

옵션 가로 **left, center, right, %**

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;세로 **top, center, bottom, %**

Selector**{background: background-image 속성값 background-repeat 속성값 background-attachment 속성값 background-position 속성값}** 속성 한 번에 지정, `Space Bar` 구분

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

Selector**{borer-color: 값}** 테두리 색상 지정

Selector**{border-방향-width: 값}** 테두리 두께 지정

Selector**{border-width: 값}** 테두리 두께 한 번에 지정

----------------------------------------------------------------------------------------

옵션값1 → 네 방향 모두 적용

옵션값2 → 상하 좌우

옵션값4 → top right bottom left

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

