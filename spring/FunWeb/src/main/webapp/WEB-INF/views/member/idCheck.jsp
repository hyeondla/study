<%@page import="member.MemberBean"%>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id=request.getParameter("id");
MemberDAO mdao = new MemberDAO();
MemberBean mb = mdao.getMember(id);
if(mb!=null){
	%>중복입니다<%
}else{
	%>사용가능합니다<%
}
%>