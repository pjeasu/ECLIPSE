<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>scope2</title>
	</head>
	
	<body>
		
		<h2>����� ���� ����غ���</h2>
			request : <%=request.getAttribute("id") %> <br>
			pageContext : <%=pageContext.getAttribute("name") %> <br>
		
			
		
	</body>
	
</html>