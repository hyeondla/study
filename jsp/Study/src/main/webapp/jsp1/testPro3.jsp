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
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	String[] hobby = request.getParameterValues("hobby");
	String grade = request.getParameter("grade");
	%>

	이름 : <%=name%><br>
	성별 : <%=gender%><br>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>취미</td>
		</tr>
		<%
		if (hobby != null) {
			for (int i = 0; i < hobby.length; i++) {
				// length = 0이면 null → 오류
		%>
		<tr>
			<td><%=i + 1%></td>
			<td><%=hobby[i]%></td>
		</tr>
		<%
		}
		}
		%>
	</table>
	<br> 학년 : <%=grade%><br>

</body>
</html>