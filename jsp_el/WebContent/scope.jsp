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
		
		<h2>저장된 정보 출력해보기</h2>
			request : <%=request.getAttribute("id") %> <br>
			pageContext : <%=pageContext.getAttribute("name") %> <br><br>
			
		
		<a href ="scope2.jsp">이동하기</a>
		<jsp:forward page="scope2.jsp"/>
		<!--forward 이므로 주소는 안바뀜 -->
			
			
			
	</body>
	
</html>