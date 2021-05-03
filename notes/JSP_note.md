**〈%       %〉**  변수, 연산자, 조건문, 반복문 사용 가능

**〈%=     %〉** 웹에 출력

〈%       %〉 안에 〈%=     %〉 사용 불가

**〈%!      %〉** 전역 변수 

**〈%@    %〉** 설정

**〈!--       --〉** 주석



> 웹서버

웹애플리케이션 서버에 전달

1. request, response 내장 객체 생성 (기억장소)
   request : 이름=값 요청 정보 저장
2. web.xml 참조
3. 서블릿 : request에 저장된 태그 이름에 해당하는 값을 가져와서 출력 명령
		request.getParameter("태그이름") → 리턴값 String 타입

<br>

> 한글 깨짐

form method="**post**" 일 때 발생, getParameter 사용 전에 처리 

```jsp
<% request.setCharacterEncoding("utf-8"); %>
```

<br>

> 문자열 → 정수 

**Integer.parseInt(변수명)**

<br>

> checkbox 다중 선택값 가져오기

**String[]** 변수명 = **request.getParameterValues**("태그이름");

```jsp
<% String[] hobby = request.getParameterValues("hobby"); %>

취미 : <%
	for(int i=0; i<hobby.length; i++){
	%>	<%=hobby[i] %> <%
	}
%>
```

<br>

> 내장객체에 값 저장

```jsp
<%
pageContext.setAttribute("page", "pageContext value");
request.setAttribute("req", "reqest value");
session.setAttribute("ses", "session value");
application.setAttribute("app", "application value");
%>

pageContext 값 : <%=pageContext.getAttribute("page") %><br>
request 값 : <%=request.getAttribute("req") %><br>
session 값 : <%=session.getAttribute("ses") %><br>
application 값 : <%=application.getAttribute("app") %><br>
```

<br>

> 내장객체 값 넘기기

```jsp
<% 
String id = request.getParameter("id"); 
String pw = request.getParameter("pw");
%>
<!-- 1)------------------------------------------ -->
<a href="scopeProPro.jsp?id=<%=id%>&pw=<%=pw%>">
<!-- 2)------------------------------------------ -->
<script type="text/javascript">
	alert("scopeProPro.jsp 이동");
	location.href="scopeProPro.jsp?id=<%=id%>&pw=<%=pw%>";
</script>
<%
response.sendRedirect("scopeProPro.jsp?id="+id+"&pw="+pw);
%>
```

<br>

> 액션태그 - **forward**

```jsp
<jsp:forward page="이동할 페이지" />
<jsp:forward page="이동할 페이지"></jsp:forward>
```

 모든 request 정보 공유

<br>

> 액션태그 - **include**

```jsp
<%@ include file = "포함할 파일" %>
<!-- ---------------------------------- -->
<body>
<jsp:include page="포함할 파일" />
<!-- ---------------------------------- -->
<jsp:include page="포함할 파일">
<jsp:param value=" " name=" " />
</jsp:include>
</body>
```

반복되는 파일

<br>

---

> 세션 **session**

```jsp
<% 
//세션공간에 이름:값 저장
session.setAttribute("session_name", "session_value"); 
%>
<% 
//세션공간에 값 삭제
session.removeAttribute("session_name"); 
%>
<% 
//세션공간에 값 전체 삭제
session.invalidate(); 
%>
```

<br>

