<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>object EL </title>
	</head>
	
	<body>
			
			
		<form action = "objelOk.jsp" method = "get">
			���̵� : <input type = "text" name = "id"> <br>
			��й�ȣ : <input type = "password" name = "pw"> <br> 
			<input type = "submit" value = "login">
		</form>
		
		<%
			application.setAttribute("application_name", "application_value");
			session.setAttribute("session_name"	, "session_value");
			pageContext.setAttribute("page_name", "page_value");
			request.setAttribute("request_name", "request_value");
			
		%>
		
	</body>
	
</html>

