<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>

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
			Connection connection;
			Statement statement;
			ResultSet resultSet;
			
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; //����Ŭ���� ip 
			String uid = "scott";
			String upw = "tiger";
			String query = "select * from emp";
		%>
	
		<%
			try{ // runtimeexception��ӹ��� �ʴ� exception Ŭ������ try�� ���� !!!
				Class.forName(driver); //Class ��� �̸��� ���� class , forName�� �̿��� ������ü����! 
				connection = DriverManager.getConnection(url, uid, upw); //����ٸ�
				statement = connection.createStatement(); //��ɹ�����.. query�� �����ϱ� ���� 
				resultSet = statement.executeQuery(query); //select * from
				
				while(resultSet.next()){ //row
					String name = resultSet.getString("ename");
					String job = resultSet.getString("job");
					String mgr = resultSet.getString("mgr");
					
					out.println("�̸� : " + name + ", ��å : " + job + ", �Ŵ��� : " + mgr + "<br/>");
					
				}
			}catch(Exception e){
				
			}finally{ //������ ���� �ȳ��� Ÿ�� �ڵ�
				try{
					if(resultSet != null) resultSet.close();
					if(statement != null) statement.close();
					if(connection != null) connection.close();
				}catch(Exception e){}
				
			}
		
		%>
	
	
	</body>
</html>