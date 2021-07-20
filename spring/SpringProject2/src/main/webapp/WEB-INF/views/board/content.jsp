<%@page import="board.BoardBean"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>jsp6/content.jsp</h1>
<%
// content.jsp?num=1
// int num = num파라미터값 가져오기
int num=Integer.parseInt(request.getParameter("num"));

// BoardDAO bdao 객체생성
BoardDAO bdao=new BoardDAO();
// 조회수 증가 메서드 정의 리턴할형 없음 updateReadcount(int num)
// updateReadcount(num) 메서드 호출
bdao.updateReadcount(num);

// 메서드 정의  리턴할형 BoardBean   getBoard(int num)
// BoardBean bb = getBoard(num)  호출
BoardBean bb=bdao.getBoard(num);

	%>
<table border="1">
<tr><td>글번호</td><td><%=bb.getNum() %></td>
    <td>글쓴이</td><td><%=bb.getName() %></td></tr>
<tr><td>글쓴날짜</td><td><%=bb.getDate() %></td>
    <td>조회수</td><td><%=bb.getReadcount() %></td></tr>    
<tr><td>제목</td>
    <td colspan="3"><%=bb.getSubject() %></td></tr>
<tr><td>내용</td>
    <td colspan="3"><%=bb.getContent() %></td></tr>
<tr><td colspan="4">
    <input type="button" value="글수정" 
    onclick="location.href='updateForm.jsp?num=<%=bb.getNum()%>'">
    <input type="button" value="글삭제" 
    onclick="location.href='deleteForm.jsp?num=<%=bb.getNum()%>'">
    <input type="button" value="글목록" 
    onclick="location.href='list.jsp'"></td></tr>    
</table>	
댓글달기
<form action="reWritePro.jsp" method="post">
<input type="hidden" name="name" value="삼색이">
<input type="hidden" name="board_num" value="<%=num %>">
<textarea rows="" cols="" name="content"></textarea>
<input type="submit" value="등록">
</form>
</body>
</html>