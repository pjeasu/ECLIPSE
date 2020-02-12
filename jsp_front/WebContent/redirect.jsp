<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>HttpServletResponse 클래스</title>
	</head>
	
	<body>
		<%
			request.setAttribute("id", "abcde");
			request.setAttribute("pw", "12345");
			
			response.sendRedirect("RequestObj");
			
		%>
	</body>	
</html>

