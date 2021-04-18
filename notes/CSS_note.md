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

적용대상 {스타일 속성: 값; 스타일 속성: 값}

태그1, 태그2, 태그3 {스타일 속성: 값} 여러 태그에 같은 스타일 적용 `,` 사용

태그1 태그2 {스타일 속성: 값}  상위 태그에 포함된 하위 태그에만 스타일 지정 `Space Bar` 사용

<br>

> Class

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

> ID

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