<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>write_view</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
		  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	</head>
	
	<body>
		<div class = "container">
		<table class = "table table-hover">
			<tr>	
				<td>이름</td>	
				<td> <input type="text" class="form-control" name = "bName" size = "50" ></td>
			</tr>
			<tr>
				<td>제목</td>	
				<td> <input type = "text" class="form-control" name = "bTitle"  size = "50"></td>
			</tr>	
			<tr>
				<td>내용</td>
				<td><textarea name = "bContent" class="form-control" rows = "10"></textarea></td>
			</tr>
			<tr>
				<td colspan = "2"> <input type = "submit" value = "입력">&nbsp;&nbsp;
				<a href = "list.do"> <span class="badge badge-info">목록보기</span></a>
				</td>
			</tr>
				
		
		</table>
		</div>
	</body>
</html>