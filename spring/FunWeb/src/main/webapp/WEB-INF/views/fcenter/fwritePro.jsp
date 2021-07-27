<%@page import="fboard.FileBoardDAO"%>
<%@page import="fboard.FileBoardBean"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.sql.Timestamp"%>
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
String uploadPath = request.getRealPath("/upload"); // 물리적 경로
int maxSize = 10*1024*1024; // 10MB

MultipartRequest multi = new MultipartRequest(request, uploadPath, maxSize, "utf-8", new DefaultFileRenamePolicy());

String name = multi.getParameter("name");
String pass = multi.getParameter("pass");
String subject = multi.getParameter("subject");
String content = multi.getParameter("content");
Timestamp date = new Timestamp(System.currentTimeMillis());
String file = multi.getFilesystemName("file");

FileBoardBean bb = new FileBoardBean();
bb.setName(name);
bb.setPass(pass);
bb.setSubject(subject);
bb.setContent(content);
bb.setDate(date);
bb.setReadcount(0);
bb.setFile(file);

FileBoardDAO bdao = new FileBoardDAO();
bdao.finsertBoard(bb);
%>
<script type="text/javascript">
alert("글이 등록되었습니다");
location.href = "fnotice.jsp";
</script>
</body>
</html>