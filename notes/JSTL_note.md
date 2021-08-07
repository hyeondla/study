> JSTL 

Java Server Pages Standard Tag Library

<br>

> Core Tags

```jsp
<% @taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
```

- c:out

- c:import 

- c:set

- c:remove

- c:catch

- c:if

  ```jsp
  <c:if test="${조건식}">
  	조건식이 True일 경우 표시할 내용
  </c:if>
  ```

- c:choose 

- c:when 

- c:otherwise

  ```jsp
  <c:choose>
  	<c:when test="${조건식1}">
      	조건식1이 True일 경우 표시할 내용
      </c:when>
      <c:when thet="${조건식2}">
      	조건식2가 True일 경우 표시할 내용
      </c:when>
      <c:otherwise>
      	조건식1,2가 False일 경우 표시할 내용
      </c:otherwise>
  </c:choose>
  ```

- c:forEach

  ```jsp
  <c:forEach var="i" begin="1" end="10">
  	<c:out value="${i}"/><br>
  </c:forEach>
  ```

- c:forTokens

  ```jsp
  <c:forTokens items="aaa-bbb-ccc" delims="-" var="ch">
  	<c:out value="${ch}"/><br>
  </c:forTokens>
  ```

- c:param

- c:redirect

  ```jsp
  <c:redirect url="URL주소"/>
  ```

<br>

> Function Tags

```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
```

- fn:contains()

  ```jsp
  <c:set var="str" value="Hello World"/>
  <c:if test=${fn:contains(str, 'Hello')}>
  	문자열에 Hello가 포함된 경우 표시할 내용
  </c:if>
  ```

- fn:containsIgnoreCase()

  대소문자 구분 X

- fn:endsWith()

  ```jsp
  <c:set var="str" value="Hello World"/>
  <c:if test=${fn:endsWith(str, 'rld')}>
  	문자열이 rld로 끝날 경우 표시할 내용
  </c:if>
  ```

- fn:escapeXml()

- fn:indexOf()

  지정된 문자열의 인덱스 반환

  ```jsp
  <c:set var="str" value="Hello World"/>
  ${fn:indexOf(str), "W"} 
  ${fn:indexOf(str), "lo"}
  ```

- fn:trim()

  문자열 양쪽 끝 공백 제거

  ```jsp
  <c:set var="str" value=" Hello World     "/>
  ${fn:trim(str)}
  ```

- fn:startsWith()

  ```jsp
  <c:set var="str" value="Hello World"/>
  <c:if test=${fn:startsWith(str, 'He')}>
  	문자열이 He로 시작할 경우 표시할 내용
  </c:if>
  ```

- fn:split()

  ```jsp
  <c:set var="str" value="aaa-bbb-ccc"/>
  <c:set var="strArr" value="${fn:split(str,'-')}" />
  ```

- fn:toLowerCase()

  문자열 대문자 → 소문자

  ```jsp
  ${fn:toLowerCase(str)}
  ```

- fn:toUpperCase()

  문자열 소문자 → 대문자

  ```jsp
  ${fn:toUpperCase(str)}
  ```

- fn:subString()

  문자열 start~end 반환

  ```jsp
  <c:set var="str" value="Hello World"/>
  ${fn:substring(str,start,end)}
  ${fn:substring(str,2,5)}
  ```

- fn:substringAfter()

  문자열 값 뒤의 문자열 반환

  ```jsp
  <c:set var="str" value="Hello World"/>
  ${fn:substringAfter(str,"Wo")}
  ```

- fn:substringBefore()

  문자열 값 앞의 문자열 반환

  ```jsp
  <c:set var="str" value="Hello World"/>
  ${fn:substringBefore(str,"Wo")}
  ```

- fn:length()

  문자열 길이, 컬렉션 크기 반환

  ```jsp
  <c:set var="str" value="Hello World"/>
  ${fn:length(str)}
  ```

- fn:replace()

  입력 문자열 바꿈

  ```jsp
  <c:set var="str" value="Hello World"/>
  ${fn:replace(str, "Hello", "바꿀 문자열")}
  ```

<br>

> Formatting Tags

```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
```

- fmt:parseNumber
- fmt:timeZone
- fmt:formatNumber
- fmt:parseDate
- fmt:bundle
- fmt:setTimeZone
- fmt:setBundle
- fmt:message
- fmt:formatDate

<br>

> XML Tags

```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>  
```

- x:out
- x:parse
- x:set
- x:choose
- x:when
- x:otherwise
- x:if
- x:transform
- x:param

<br>

> SQL Tags

```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>  
```

- sql:setDataSource
- sql:query
- sql:update
- sql:param
- sql:dateParam
- sql:transaction

<br>

> EL

${pageScope} 

${requestScope}

${sessionScope}

${applicationScope}

${param}

${header}

${cookie}

${initParam}

${pageContext}