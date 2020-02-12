<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>content_view</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
		  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	</head>
	
	<body>
	<div class = "container">
		<table class = "table table-hover">
		<form action = "modify.do" method="post">
		<input type = "hidden" name = "bId" value = "${content_view.bId }">
		
			<tr>
				<td>번호</td>
				<td>${content_view.bId }</td>
			</tr>
			<tr>
				<td>히트</td>
				<td>${content_view.bHit }</td>
			</tr>
			<tr>	
				<td>이름</td>	
				<td> <input type="text" class="form-control" name = "bName" value = "${content_view.bName}"></td>
			</tr>
			<tr>
				<td>제목</td>	
				<td> <input type = "text" class="form-control" name = "bTitle"value = "${content_view.bTitle}"></td>
			</tr>	
			<tr>
				<td>내용</td>
				<td><textarea name = "bContent" class="form-control" rows = "10">${content_view.bContent}</textarea></td>
			</tr>
			<tr>
				<td colspan = "2"> <input type = "submit" value = "수정">&nbsp;&nbsp;
				<a href = "list.do"><span class="badge badge-info">목록보기</span></a>&nbsp;&nbsp;
				<a href = "delete.do?bId=${content_view.bId}"><span class="badge badge-info">삭제</span></a>&nbsp;&nbsp;
				<a href = "reply_view.do?bId=${content_view.bId}"><span class="badge badge-info">답변</span></a>
				</td>
			</tr>
				
			</form>
		</table>
		</div>
	</body>
</html>