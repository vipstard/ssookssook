<%@page import="kr.smhrd.domain.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
 
<div class="container">
  <h2>온라인 문의</h2>
  <div class="panel panel-default">
    <div class="panel-heading">
    <button class="btn btn-default btn-sm" onclick="history.go(-1)">뒤로가기</button>
    </div>
    <div class="panel-body">
    
	<table class = "table table-bordered table-hover">
   <tr>
      <th>번호</th>
      <th>제목</th>
      <th>작성자</th>
      <th>작성일</th>
      <th>조회수</th>
   </tr>
   <c:forEach var="vo" items="${QnaList}">
   <tr>
   	  <td>${vo.idx}</td>
      <td><a href="/SS/QnaContent?idx=${vo.idx}">${vo.title}</a></td>
      <td>${vo.writer}</td>
      <td>${vo.indate}</td>
      <td>${vo.count}</td>
   </tr>
   </c:forEach>
   <tr>
   		<td colspan="5">
   			<button class="btn btn-success btn-sm" onclick="location.href='/SS/QnaForm'">문의하기</button>
   		</td>
   </tr>
</table>

</div>
    <div class="panel-footer">지능형 IoT융합 SW전문가 과정</div>
  </div>
</div>

</body>
</html>


