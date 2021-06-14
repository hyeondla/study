<%@page import="fboard.FileBoardBean"%>
<%@page import="fboard.FileBoardDAO"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
String name = multi.getParameter("name");
String pass = multi.getParameter("pass");
String subject = multi.getParameter("subject");
String content = multi.getParameter("content");
String file = multi.getFilesystemName("file"); // 파일 추가
if(file==null) { // 수정할 파일 없음 -> 기존 파일이름 유지
	file = multi.getParameter("oldfile"); // 히든 -> getParameter
}

FileBoardDAO bdao = new FileBoardDAO();
FileBoardBean bb = bdao.fnumCheck(num, pass);

if(bb != null){
	FileBoardBean bb2 = new FileBoardBean();
	bb2.setNum(num);
	bb2.setName(name);
	bb2.setPass(pass);
	bb2.setSubject(subject);
	bb2.setContent(content);
	bb2.setFile(file); // 파일 추가
	bdao.fupdateBoard(bb2);
	%>
	<script type="text/javascript">
		alert("수정되었습니다");
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