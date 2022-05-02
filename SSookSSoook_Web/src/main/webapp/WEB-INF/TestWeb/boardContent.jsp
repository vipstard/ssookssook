<%@page import="kr.smhrd.domain.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%pageContext.setAttribute("newLine", "\n"); %> %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<%
   Board vo = (Board)request.getAttribute("vo");
%>
 
<div class="container">
  <h2>Sprin WEB MVC 게시판</h2>
  <div class="panel panel-default">
    <div class="panel-heading">Board</div>
    <div class="panel-body">
    
	<table class = "table table-bordered table-hover">
	<tr>
		<td>번호</td>
		<td>${vo.idx}</td>
   </tr>
	
	<tr>
		<td>제목</td>
		<td>${vo.title}</td>
   </tr>
	
	<tr>
		<td>내용</td>
		<td>${fn:replace(vo.content, newLine, "<br>")}</td>
   </tr>
	
	<tr>
		<td>작성자</td>
		<td>${vo.writer}</td>
   </tr>

	<tr>
		<td>작성일</td>
		<td>${vo.indate }</td>
   </tr>
   <tr>
   		<td colsapn="4" align="center">
   			<button class="btn btn-info btn-sm" onclick="location.href='/TEST/boardUpdate.do/${vo.idx}'">수정</button>
   			<button class="btn btn-warning btn-sm" onclick="location.href='/TEST/boardDelete.do/${vo.idx}'">삭제</button>
   			<button class="btn btn-success btn-sm" onclick="location.href='/TEST/boardList.do'">리스트</button>
   		</td>
   </tr>
	</table>

</div>
    <div class="panel-footer">지능형 IoT융합 SW전문가 과정</div>
  </div>
</div>

</body>
</html>


