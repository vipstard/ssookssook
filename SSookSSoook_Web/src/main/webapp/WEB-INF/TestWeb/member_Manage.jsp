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
  <h2>회원관리</h2>    
  <div class="panel panel-default">
    <div class="panel-heading">
				
	<button class="btn btn-default btn-sm" onclick="history.go(-1)">뒤로가기</button>
					
    </div>
    <div class="panel-body">
    
	<table class = "table table-bordered table-hover">
   <tr>
      <th>번호</th>
      <th>아이디</th>
      <th>이메일</th>
      <th>이름</th>
      <th>주소</th>
      <th>핸드폰 번호</th>
      <th>가입날짜</th>
   </tr>
   
   <c:forEach var="m_vo" items="${Mem_list}">
   <tr>
   	  <td>${m_vo.rn}</td>
      <td>${m_vo.id}</a></td>
      <td>${m_vo.email}</td>
      <td>${m_vo.name}</td>
      <td>${m_vo.addr}</td>
      <td>${m_vo.phone}</td>
      <td>${m_vo.joindate}</td>
   </tr>
   </c:forEach>
  
   
</table>

</div>
    <div class="panel-footer">SSook SSook</div>
  </div>
</div>

</body>
</html>


