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
			//������ ������ �ö��ִµ��ȿ� �ҷ��ͼ� �����ִ�
			//������ object Ÿ������ �����ϱ⶧���� String���� ����ȯ �������
			name = (String)session.getAttribute("name");
			id = (String)session.getAttribute("id");
			pw = (String)session.getAttribute("pw");
		%>
	
		<%=name%>�� �ȳ��ϼ��� <br/><%=id%>
		
		<a href = "modify.jsp">ȸ������ ����</a>
	
		
	</body>
	
</html>

