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



> <태그 속성="값" 속성="값"></태그>



> 구획 태그

〈article〉 여러 개의 내용으로 나누는 구분, 본문 내의 세부 절 〈/article〉

〈aside〉 주요 내용 이외의 문서 내용, 사이드 바 〈/aside〉

〈footer〉 저작자, 저작권 정보 〈/footer〉

〈header〉 사이트 소개,로고 〈/header〉

〈nav〉 네이게이션, 웹 문서 내의 메뉴 〈/nav〉

〈section〉 문서의 내용, 웹 문서의 본문 〈/section〉



> 제목 크기 조절 태그

〈h1〉 〈h2〉 〈h3〉 〈h4〉 〈h5〉 〈h6〉 

  큼  ──────────────  작음



> 정리 태그

〈br〉 줄 바꿈

〈p〉 문단 나누기 〈/p〉

〈hr〉 수평선

〈pre〉 편집기에 입력한 형태 그대로 웹 문서에 보여줌 〈/pre〉

〈div〉 블록 지정 〈/div〉

〈span〉 인라인 블록 지정 〈/span〉



> 목록 태그

〈ul〉 번호 없는 목록 〈/ul〉

​		 속성 type 값 disc / square / circle 항목에 사용할 점의 모양

〈ol〉 번호 있는 목록 〈/ol〉

​		 속성 type 값 1 / A / a / I / i 항목에 사용할 번호의 종류

  〈li〉 ul, ol 태그의 항목 〈/li〉



> 글자 스타일 태그

〈b〉 굵게 〈/b〉

〈u〉 밑줄 〈/u〉

〈i〉 이탤릭체 〈/i〉

〈sub〉 아랫첨자 〈/sub〉

〈sup〉 윗첨자 〈/sup〉

〈small〉 조금 작게 〈/small〉



> 루비 글자 태그

〈ruby〉 글자 위에 주석 〈/ruby〉

  〈rt〉 문자에 대한 설명, 발음 표현 〈/rt〉



> 특수 문자 입력

 ＆nbsp;  공백

 ＆lt; < 

 ＆gt; &gt; 

 ＆amp; &amp; 

 ＆quot; "

 ＆copy; &copy; 



> 이미지 삽입

〈img src="이미지 파일 경로" width="폭" height="높이" alt="설명"〉



> 멀티미디어 삽입

〈embed src="멀티미디어 파일 경로" width="폭" height="높이"〉



〈audio autoplay controls src="오디오 파일 경로"〉〈/audio〉

〈video autoplay controls src="비디오 파일 경로"〉〈/video〉

속성 autoplay 자동플레이

​		 controls 컨트롤 기능 

​		 loop 반복 재생

​		 muted 뮤트

