<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>reply_view</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
		  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
		  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	</head>
	
	<body>
	<div class = "container">
		<table class = "table table-hover">
		<form action="reply.do" method="post">
				<input type = "hidden" name = "bId" value="${reply_view.bId}">
				<input type = "hidden" name = "bGroup" value="${reply_view.bGroup}">
				<input type = "hidden" name = "bStep" value="${reply_view.bStep}">
				<input type = "hidden" name = "bIndent" value="${reply_view.bIndent}">
				<!-- 유저에게 숨긴채로 값을 받아옴  -->
				<tr>
					<td> 번호 </td>
					<td> ${reply_view.bId} </td>
				</tr>
				<tr>
					<td> 조회수 </td>
					<td> ${reply_view.bHit} </td>
				</tr>
				<!-- 답변을 단 본문의 이름, 제목 , 내용을 받아와 수정하는 방식으로 하기위해! -->
				<tr>
					<td> 이름 </td>
					<td> <input class="form-control" type="text" name="bName" value="${reply_view.bName}" size = "50"> </td>
				</tr>
				<tr>
					<td> 제목 </td>
					<td> <input type="text" class="form-control"name="bTitle" value="${reply_view.bTitle}"size = "50"> </td>
				</tr>
				<tr>
					<td> 내용 </td>
					<td> <textarea class="form-control" name="bContent" value="${reply_view.bContent}"rows="10" ></textarea> </td>
				</tr>
				<tr >
					<td colspan="2"> <input type="submit" value="답변"> &nbsp;&nbsp; <a href="list.do"><span class="badge badge-info">목록보기</span></a></td>
				</tr>
			</form>
		</table>
		</div>
	</body>
</html>