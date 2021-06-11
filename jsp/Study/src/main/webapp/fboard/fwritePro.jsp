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
// 물리적 경로
String uploadPath = request.getRealPath("/upload");
System.out.println(uploadPath);

// 파일 최대크기
int maxSize = 10*1024*1024; // 10MB

MultipartRequest multi = new MultipartRequest(request, uploadPath, maxSize, "utf-8", new DefaultFileRenamePolicy());

String name = multi.getParameter("name");
String pass = multi.getParameter("pass");
String subject = multi.getParameter("subject");
String content = multi.getParameter("content");
int readcount=0;
Timestamp date = new Timestamp(System.currentTimeMillis());

String file = multi.getFilesystemName("file");

FileBoardBean bb = new FileBoardBean();
bb.setName(name);
bb.setPass(pass);
bb.setSubject(subject);
bb.setContent(content);
bb.setReadcount(readcount);
bb.setDate(date);
bb.setFile(file);

FileBoardDAO bdao = new FileBoardDAO();
bdao.finsertBoard(bb);

// response.sendRedirect("list.jsp");
%>
</body>
</html>