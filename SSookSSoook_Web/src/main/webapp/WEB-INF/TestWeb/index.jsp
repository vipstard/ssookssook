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
<%for(int i=1; i<=5; i++){ 
	if(i%2==0){
%>
	
   <font size="<%=i%>">안녕!</font>
<%} 
}%>   

<c:forEach var="i" begin="1" end="5" step="1">
	<c:if test="${i%2==0}">
   		<font size="${i}">안녕!</font>
	</c:if>
</c:forEach>

<%
	int a =10;
%>
<c:set var="a" value="10"/>

<c:if test="${a%2==0}">
	짝수입니다.
</c:if>

<c:choose>
	<c:when test="${a%2==0}">
	짝수입니다.
	</c:when>
</c:choose>

<%
   String[] seasons = {"봄", "여름", "가을", "겨울"};
   request.setAttribute("seasons", seasons);
%>

<table border="1">
   <c:forEach var="s" items="${seasons}">
   <tr>
      <td>${s}</td>
   </tr>
   </c:forEach>
</table>

</body>
</html>






