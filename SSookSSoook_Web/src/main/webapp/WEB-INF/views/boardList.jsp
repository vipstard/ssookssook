<%@page import="kr.smhrd.domain.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>SSook SSoook</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
 
<div class="container">
  <h2>SSook SSoook</h2>    
  <div class="panel panel-default">
    <div class="panel-heading">
				<c:if test="${!empty LoginVo}">
					<div class="form-group">
						<label>${LoginVo.name }님 환영합니다.</label>
						
						<button class="btn btn-default btn-sm" onclick="location.href='https://kauth.kakao.com/oauth/logout?client_id=e3eced6c366d05e611468e218fc8f42d&logout_redirect_uri=http://localhost:8081/TEST/LogOut'">LogOut</button>
						<button class="btn btn-default btn-sm" onclick="location.href='/TEST/EditProfile'">Edit Profile</button>
						<c:if test="${LoginVo.ad_ck == '1'}">
						<button class="btn btn-default btn-sm" onclick="location.href='/TEST/member_Manage'">Management</button>
						</c:if>
					</div>
				</c:if>
	<c:if test="${empty LoginVo}">
	<button type="button" class="btn" onclick="location.href='/TEST/JoinForm'">Join</button>
    <button type="button" class="btn" onclick="location.href='/TEST/Login'">Login</button>
    
    
    </c:if>
    <button type="button" class="btn" onclick="location.href='/TEST/productList'">제품구매</button>
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
   
   <c:forEach var="vo" items="${list}">
   <tr>
   	  <td>${vo.idx}</td>
      <td><a href="/TEST/boardContent.do?idx=${vo.idx}">${vo.title}</a></td>
      <td>${vo.writer}</td>
      <td>${vo.indate}</td>
      <td>${vo.count}</td>
   </tr>
   </c:forEach>
   
   <c:if test="${!empty LoginVo}">
   <tr>
   		<td colspan="5">
   			<button class="btn btn-success btn-sm" onclick="location.href='/TEST/boardForm.do'">글쓰기</button>
   		</td>
   </tr>
   </c:if>
   
</table>

</div>
    <div class="panel-footer">SSook SSoook</div>
  </div>
</div>

</body>
</html>


