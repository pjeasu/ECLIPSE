<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>scope</title>
	</head>
	
	<body>
	
		<%
			pageContext.setAttribute("name", "hong gil dong");
			request.setAttribute("id", "abcde");
		%>
		
		<h2>����� ���� ����غ���</h2>
			request : <%=request.getAttribute("id") %> <br>
			pageContext : <%=pageContext.getAttribute("name") %> <br><br>
			
		
		<a href ="scope2.jsp">�̵��ϱ�</a>
		<jsp:forward page="scope2.jsp"/>
		<!--forward �̹Ƿ� �ּҴ� �ȹٲ� -->
			
			
			
	</body>
	
</html>