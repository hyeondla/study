<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="fboard.FileBoardDAO"%>
<%@page import="fboard.FileBoardBean"%>
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
String uploadPath = request.getRealPath("/upload");
int maxSize = 10*1024*1024;

MultipartRequest multi = new MultipartRequest(request,uploadPath,maxSize,"utf-8", new DefaultFileRenamePolicy());

int num = Integer.parseInt(multi.getParameter("num"));
String subject = multi.getParameter("subject");
String content = multi.getParameter("content");
String file = multi.getFilesystemName("file");
if(file==null) { // 수정할 파일 없음 -> 기존 파일이름 유지
	file = multi.getParameter("oldfile"); // 히든 -> getParameter
}

FileBoardDAO bdao = new FileBoardDAO();

FileBoardBean bb = new FileBoardBean();
bb.setNum(num);
bb.setSubject(subject);
bb.setContent(content);
bb.setFile(file);

bdao.fupdateBoard(bb);
%>
<script type="text/javascript">
	alert("수정되었습니다");
	location.href="fcontent.jsp?num=<%=num %>";
</script>
</body>
</html>