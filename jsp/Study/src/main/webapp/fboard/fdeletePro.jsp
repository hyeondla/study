<%@page import="fboard.FileBoardBean"%>
<%@page import="fboard.FileBoardDAO"%>
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
int num = Integer.parseInt(request.getParameter("num"));
String pass = request.getParameter("pass");

FileBoardDAO bdao = new FileBoardDAO();
FileBoardBean bb = bdao.fnumCheck(num, pass);

if(bb != null){
	
	bdao.fdeleteBoard(num);
	
	%>
	<script type="text/javascript">
		alert("삭제되었습니다")
		location.href="flist.jsp";
	</script>
	<%
	
} else {
	%>
	<script type="text/javascript">
		alert("입력하신 정보가 틀립니다");
		history.back();
	</script>
	<%
}
%>

</body>
</html>