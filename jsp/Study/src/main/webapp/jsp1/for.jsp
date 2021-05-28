<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String[] hobby = { "게임", "독서", "축구" };
	%>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>취미</td>
		</tr>
		<%
		for (int i = 0; i < hobby.length; i++) {
		%>
		<tr>
			<td><%=i + 1%></td>
			<td><%=hobby[i]%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>