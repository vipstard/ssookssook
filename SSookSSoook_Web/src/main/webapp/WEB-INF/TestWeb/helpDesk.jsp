<%@page import="kr.smhrd.domain.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>고객 센터</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
 
<div class="container">
  <h2>고객센터</h2>    
  <div class="panel panel-default">
    <div class="panel-heading">
	<button class="btn btn-default btn-sm" onclick="history.go(-1)">뒤로가기</button>
	<button class="btn btn-default btn-sm" onclick="#">FAQ</button>
	<button class="btn btn-default btn-sm" onclick="#">온라인문의</button>
    </div>
    <div class="panel-body">
    
	<table class = "table table-bordered table-hover">
   
   
   <c:forEach var="vo" items="${listProduct}">
   <tr>
   	  <td>${vo.idx}</td>
      <td><a href="/TEST/boardContent.do?idx=${vo.idx}">${vo.url}</a></td>
      <td>${vo.name}</td>
      <td>${vo.desc}</td>
      <td>${vo.price}</td>
   </tr>
   </c:forEach>
   
</table>

</div>
    <div class="panel-footer">SSook SSoook</div>
  </div>
</div>

</body>
</html>


