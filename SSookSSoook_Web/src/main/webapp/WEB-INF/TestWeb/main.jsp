<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
		
		
 <div class="panel panel-default">
    <div class="panel-heading">
			<c:if test="${!empty LoginVo}">
				<div class="form-group">
					<label>${LoginVo.name }님 환영합니다.</label>
						
					<button class="btn btn-default btn-sm" onclick="location.href='https://kauth.kakao.com/oauth/logout?client_id=e3eced6c366d05e611468e218fc8f42d&logout_redirect_uri=http://211.227.224.199:8081/SS/LogOut'">LogOut</button>
					<button class="btn btn-default btn-sm" onclick="location.href='EditProfile'">Edit Profile</button>
					
					<c:if test='${LoginVo.admin_yn == "Y" }'>
					
					</c:if>
				</div>
			</c:if>
			
	<c:if test="${empty LoginVo}">
	<button type="button" class="btn" onclick="location.href='JoinForm'">Join</button>
    <button type="button" class="btn" onclick="location.href='LoginForm'">Login</button>
    
    
    </c:if>
    <button class="btn btn-default btn-sm" onclick="location.href='member_Manage'">Management</button>
    <button type="button" class="btn" onclick="location.href='productList'">제품구매</button>
    <button type="button" class="btn" onclick="location.href='helpDesk'">고객센터</button>
    </div>
    <div class="panel-body">



</body>
</html>