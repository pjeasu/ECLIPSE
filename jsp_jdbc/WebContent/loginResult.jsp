<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>Insert title here</title>
	</head>
	
	<body>
	
		<%!
			String name, id, pw;
		%>
		<%
			//세션이 서버에 올라가있는동안엔 불러와서 쓸수있다
			//세션은 object 타입으로 리턴하기때문에 String으로 형변환 해줘야함
			name = (String)session.getAttribute("name");
			id = (String)session.getAttribute("id");
			pw = (String)session.getAttribute("pw");
		%>
	
		<%=name%>님 안녕하세요 <br/><%=id%>
		
		<a href = "modify.jsp">회원정보 수정</a>
	
		
	</body>
	
</html>

