<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>ContextPath</title>
	</head>
	
	<body>
		<a href="insert.do">insert</a>
		<hr/>
		
		<a href="http://localhost:8282<%=request.getContextPath()%>/update.do">update</a>
		<hr/>
		
		<a href="http://localhost:8282/jsp_front/select.do">select</a>
		<hr/>
		
		<a href="<%=request.getContextPath()%>/delete.do">delete</a>
		<hr/>
		
	</body>	
</html>

