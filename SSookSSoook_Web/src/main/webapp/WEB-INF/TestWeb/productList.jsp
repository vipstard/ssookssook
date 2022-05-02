<%@page import="kr.smhrd.domain.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>상품 목록</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
 
<div class="container">
  <h2>상품 목록</h2>    
  <div class="panel panel-default">
    <div class="panel-heading">
	<button class="btn btn-default btn-sm" onclick="history.go(-1)">뒤로가기</button>
    </div>
    <div class="panel-body">
    
	<table class = "table table-bordered table-hover">
   <tr>
      <th>번호</th>
      <th>상품사진</th>
      <th>상품명</th>
      <th>상품설명</th>
      <th>가격</th>
   </tr>
   
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


