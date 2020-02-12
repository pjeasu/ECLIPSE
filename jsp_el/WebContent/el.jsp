<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="EUC-KR">
		<title>Insert title here</title>
	</head>
	
	<body>
		
		<!-- MemberInfo member = new MemberInfo(); -->
		<jsp:useBean id = "member" class = "edu.bit.ex.MemberInfo" scope = "page"/>
		
		<!-- member.setName("홍길동"); -->
		<jsp:setProperty name="member" property="name" value = "홍길동"/>
		<jsp:setProperty name="member" property="id" value = "abc"/>
		<jsp:setProperty name="member" property="pw" value = "123"/>
	
		<!-- member.getName(); -->
		이름 : <jsp:getProperty name="member" property="name" /><br>
		아이디 : <jsp:getProperty name="member" property="id" /><br>
		비밀번호 : <jsp:getProperty name="member" property="pw" /><br>
		
		<hr>
		
		이름 : ${member.name } <br>
		아이디 : ${member.id } <br>
		비밀번호 : ${member.pw } <br>
		
		
		
		
	<%-- 	
		${10} <br>
		${99.9999} <br>
		${"ABC"} ${'ABC'} <br>
		${true} <br><br>
		
		${1+2}<br>
		${1-2}<br>
		${1*2}<br>
		${1/2}<br>
		${1>2}<br>
		${1<2}<br>
		${(1 > 2) ? 1 : 2}<br>
		${(1 > 2) || (1 < 2)}<br><br>
		 --%>
		 
	</body>
	
</html>