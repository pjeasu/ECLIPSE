<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>list</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
		  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	</head>
	
	<body>
	<div class = "container">
		<table class = "table table-hover">
		<thead class = "table-info">
			<tr class = "table-info">
				<td>번호</td>	
				<td>이름</td>	
				<td>제목</td>	
				<td>날짜</td>	
				<td>히트</td>	
			</tr>
			</thead>
				<c:forEach items = "${list}" var = "dto">
					<tr>
						<td>${dto.bId}</td>
						<td>${dto.bName}</td>
						<td>
							<c:forEach begin = "1" end = "${dto.bIndent}">↳</c:forEach>
							<a href = "content_view.do?bId=${dto.bId}">${dto.bTitle}</a>
						</td>
						<td>${dto.bDate}</td>
						<td>${dto.bHit}</td>
					</tr>	
				</c:forEach>
			<tr>
				 <td colspan = "5"> <a href = "write_view.do">
				 <span class="badge badge-info">글작성</span></a></td>
			</tr>
		
		</table>
		</div>
	</body>
</html>