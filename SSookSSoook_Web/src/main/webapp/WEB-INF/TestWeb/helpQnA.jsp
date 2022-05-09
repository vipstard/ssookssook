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
  <style type="text/css">

  .pageInfo{
      list-style : none;
      display: inline-block;
    margin: 50px 50px 0 100px;      
  }
  .pageInfo li{
      float: left;
    font-size: 15px;
    margin-left: 20px;
    padding: 7px;
    font-weight: 500;
  }
  
  .active{
      background-color: #cdd5ec;
  }
  
  
  .search_area{
    display: inline-block;
    margin-top: 30px;
    margin-left: 260px;
  }
  .search_area input{
      height: 30px;
    width: 250px;
  }
  .search_area button{
     width: 100px;
    height: 36px;
  }
  
 
 a:link {color:black; text-decoration: none;}
 a:visited {color:black; text-decoration: none;}
 a:hover {color:black; text-decoration: underline;}
 
</style>

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
	<div class="search_wrap">
        <div class="search_area">
            <input type="text" name="keyword" value="${BoardPageMaker.cri.keyword }">
            <button>Search</button>
        </div>
    </div>  
  
  <!-- 페이징 및 검색  -->
  <div class="pageInfo_wrap" >
        <div class="pageInfo_area">
			<ul id="pageInfo" class="pageInfo">		
			
                <!-- 이전페이지 버튼 -->
                <c:if test="${BoardBoardPageMaker.cri.pageNum > 10}">
                    <li class="pageInfo_btn previous"><a href="${BoardPageMaker.startPage-1}">Previous</a></li>
                </c:if>
                
               <!-- 각 번호 페이지 버튼 -->
               <c:forEach var="num" begin="${BoardPageMaker.startPage}" end="${BoardPageMaker.endPage}">
                   <li class="pageInfo_btn ${BoardPageMaker.cri.pageNum == num ? "active":"" }"><a href="${num}">${num}</a></li>
               </c:forEach>
               
                <!-- 다음페이지 버튼 -->
                <c:if test="${BoardPageMaker.cri.pageNum < BoardPageMaker.realEnd}">
                    <li class="pageInfo_btn next"><a href="${BoardPageMaker.endPage + 1 }">Next</a></li>
                </c:if>
                
 			</ul>
        </div>
    </div>
   
   <form id="moveForm" method="get">
   	<input type="hidden" name="pageNum" value="${BoardPageMaker.cri.pageNum }">
   	<input type="hidden" name="amount" value="${BoardPageMaker.cri.amount }">
   	<input type="hidden" name="keyword" value="${BoardPageMaker.cri.keyword }">
  </form> 

</div>
    <div class="panel-footer">지능형 IoT융합 SW전문가 과정</div>
  </div>
</div>

<script>

/* 페이지 넘기기 js */
let moveForm = $("#moveForm");

   $(".pageInfo a").on("click", function(e){
 
        e.preventDefault();
        moveForm.find("input[name='pageNum']").val($(this).attr("href"));
        moveForm.attr("action", "helpQnA");
        moveForm.submit();
        
    });
   
  
/* 검색 기능 */
   $(".search_area button").on("click", function(e){
       e.preventDefault();
       let val = $("input[name='keyword']").val();
       moveForm.find("input[name='keyword']").val(val);
       moveForm.find("input[name='pageNum']").val(1);
       moveForm.submit();
   });


 
</script>

</body>
</html>



