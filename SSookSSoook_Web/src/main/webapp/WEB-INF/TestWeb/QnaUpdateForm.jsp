<%@page import="kr.smhrd.domain.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
  <h2>Spring WEB MVC 게시판</h2>
  <div class="panel panel-default">
    <div class="panel-heading">BOARD</div>
    <div class="panel-body">
    
    
      <form class="form-horizontal" action="QnaUpdate" method="post">
      <input type="hidden" value="${QnaUpdate.idx}" name="idx">
      
        <div class="form-group">
          <label class="control-label col-sm-2" for="title">제목:</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" id="title" name="title" value="${QnaUpdate.title }">
          </div>
        </div>
        
        <div class="form-group">
          <label class="control-label col-sm-2" for="content">내용:</label>
          <div class="col-sm-10">
            <textarea rows="10" class="form-control" name="content">${QnaUpdate.content }</textarea>
          </div>
        </div>
        
         <div class="form-group">
          <label class="control-label col-sm-2" for="writer">작성자:</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" id="writer" name="writer" value="${QnaUpdate.writer}" readonly="readonly">
          </div>
        </div>
        
       
        <div class="form-group">
          <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-success btn-sm">등록</button>
            <button type="reset" class="btn btn-warning">취소</button>
          </div>
        </div>
      </form>
      
      
    </div>
    <div class="panel-footer">지능형 IoT융합 SW전문가과정</div>
  </div>
</div>
</body>
</html>