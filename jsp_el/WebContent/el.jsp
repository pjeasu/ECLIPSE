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
		
		<!-- member.setName("ȫ�浿"); -->
		<jsp:setProperty name="member" property="name" value = "ȫ�浿"/>
		<jsp:setProperty name="member" property="id" value = "abc"/>
		<jsp:setProperty name="member" property="pw" value = "123"/>
	
		<!-- member.getName(); -->
		�̸� : <jsp:getProperty name="member" property="name" /><br>
		���̵� : <jsp:getProperty name="member" property="id" /><br>
		��й�ȣ : <jsp:getProperty name="member" property="pw" /><br>
		
		<hr>
		
		�̸� : ${member.name } <br>
		���̵� : ${member.id } <br>
		��й�ȣ : ${member.pw } <br>
		
		
		
		
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