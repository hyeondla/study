<%@page import="board.ReBoardDAO"%>
<%@page import="board.ReBoardBean"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

String name = request.getParameter("name");
int board_num = Integer.parseInt(request.getParameter("board_num"));
String content = request.getParameter("content");
Timestamp date = new Timestamp(System.currentTimeMillis());

ReBoardBean rb = new ReBoardBean();

rb.setName(name);
rb.setContent(content);
rb.setBoard_num(board_num);
rb.setDate(date);

ReBoardDAO rdao = new ReBoardDAO();
rdao.insertReBoard(rb);

response.sendRedirect("content.jsp?num="+board_num);

%>