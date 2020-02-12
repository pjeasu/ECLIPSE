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
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
			String uid = "scott";
			String upw = "tiger";
			String query = "select * from emp";
		%>
		<table border = "1">
		<%
			try{ 
				Class.forName(driver);
				connection = DriverManager.getConnection(url, uid, upw); 
				statement = connection.createStatement(); 
				resultSet = statement.executeQuery(query); 
				
				while(resultSet.next()){ //row
					String ename = resultSet.getString("ename");
					String job = resultSet.getString("job");
					String mgr = resultSet.getString("mgr");
					String hiredate = resultSet.getString("hiredate");
					String sal = resultSet.getString("sal");
					String comm = resultSet.getString("comm");
					String deptno = resultSet.getString("deptno");
					
					out.println("<tr><td>" + ename + "</td>");
					out.println("<td>" + job + "</td>");
					out.println("<td>" + mgr + "</td>");
					out.println("<td>" + hiredate + "</td>");
					out.println("<td>" + comm + "</td>");					
					out.println("<td>" + deptno + "</td></tr>");
				}
			}catch(Exception e){
			}finally{ 
				try{
					if(resultSet != null) resultSet.close();
					if(statement != null) statement.close();
					if(connection != null) connection.close();
				}catch(Exception e){}
			}
		%>
	</table>
	</body>
</html>