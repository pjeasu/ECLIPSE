<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>object OK </title>
	</head>
	
	<body>
		
		
		<%
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
		%>
		
		���̵� : <%= id %> <br/>
		��й�ȣ : <%= pw %> <br/>
			
			
		<hr>
		
		���̵� :${param.id }<br/>
		��й�ȣ : ${param.pw }<br/>
		���̵� : ${param["id"]}<br/>
		��й�ȣ : ${param["pw"]}<br/>
		
		<hr>
		
		applicationScope : ${applicationScope.application_name }<br/>
		sessionScope : ${sessionScope.session_name }<br/>
		pageScope :  ${pageScope.page_name }<br/>
		requestScope :  ${requestScope.request_name }<br/>
		
		<hr>
			
		context �ʱ�ȭ �Ķ����  <br/>
		
		${initParam.con_name }<br/>
		${initParam.con_id }<br/>
		${initParam.con_pw }<br/>
		
		
		
		
	</body>
	
</html>

