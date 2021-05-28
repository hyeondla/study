<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "include_file.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="<%=col1%>">
<table border="1" width="600">
	<tr>
		<td colspan="2" width="100" height="100">
			<jsp:include page="include_top.jsp">
			<jsp:param value="kim" name="id"/>
			</jsp:include>
		</td>
	</tr>
	<tr>
		<td width="100" height="400"><jsp:include page="include_left.jsp" /></td>
		<td>1 본문</td>
	</tr>
	<tr>
		<td colspan="2" height="100"><jsp:include page="include_bottom.jsp" /></td>
	</tr>
</table>
</body>
</html>