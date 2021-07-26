<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>jsp6/fcontent.jsp</h1>
<table border="1">
<tr><td>글번호</td><td>${bb.num }</td>
    <td>글쓴이</td><td>${bb.name }</td></tr>
<tr><td>글쓴날짜</td><td>${bb.date }</td>
    <td>조회수</td><td>${bb.readcount }</td></tr>    
<tr><td>제목</td>
    <td colspan="3">${bb.subject }</td></tr>
<tr><td>파일</td>
    <td colspan="3">${bb.file }<br>
<a href='<c:url value="/resources/upload/${bb.file }" />' download>
${bb.file }</a>
<img src='<c:url value="/resources/upload/${bb.file }" />' >
</td></tr>    
<tr><td>내용</td>
    <td colspan="3">${bb.content }</td></tr>
<tr><td colspan="4">
    <input type="button" value="글수정" 
    onclick="location.href='<c:url value="/board/fupdate?num=${bb.num }" />'">
    <input type="button" value="글삭제" 
    onclick="location.href='<c:url value="/board/fdelete?num=${bb.num }" />'">
    <input type="button" value="글목록" 
    onclick="location.href='<c:url value="/board/flist" />'"></td></tr>    
</table>	

</body>
</html>