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
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"/>
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
   
   <form id="moveForm" method="get">
   <input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }">
   <input type="hidden" name="amount" value="${pageMaker.cri.amount }"> 
  </form>
   


	
    <div class="pageInfo_wrap" >
        <div class="pageInfo_area">
			<ul id="pageInfo" class="pageInfo">
			
               <!-- 각 번호 페이지 버튼 -->
               <c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
                   <li class="pageInfo_btn"><a href="${num}">${num}</a></li>
               </c:forEach>
               
 			</ul>
        </div>
    </div>
    
</div>
    <div class="panel-footer">SSook SSook</div>
  </div>
</div>

<script>

/* 페이지 넘기기 js */
$(".pageInfo a").on("click", function(e){

    e.preventDefault();
    moveForm.find("input[name='pageNum']").val($(this).attr("href"));
    moveForm.attr("action", "member_Manage");
    moveForm.submit();
    
});

</script>

</body>
</html>


