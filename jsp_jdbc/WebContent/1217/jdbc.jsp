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
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; //오라클서버 ip 
			String uid = "scott";
			String upw = "tiger";
			String query = "select * from emp";
		%>
	
		<%
			try{ // runtimeexception상속받지 않는 exception 클래스는 try문 강제 !!!
				Class.forName(driver); //Class 라는 이름을 가진 class , forName을 이용해 동적객체생성! 
				connection = DriverManager.getConnection(url, uid, upw); //연결다리
				statement = connection.createStatement(); //명령문선언.. query를 전달하기 위함 
				resultSet = statement.executeQuery(query); //select * from
				
				while(resultSet.next()){ //row
					String name = resultSet.getString("ename");
					String job = resultSet.getString("job");
					String mgr = resultSet.getString("mgr");
					
					out.println("이름 : " + name + ", 직책 : " + job + ", 매니저 : " + mgr + "<br/>");
					
				}
			}catch(Exception e){
				
			}finally{ //에러가 나든 안나든 타는 코드
				try{
					if(resultSet != null) resultSet.close();
					if(statement != null) statement.close();
					if(connection != null) connection.close();
				}catch(Exception e){}
				
			}
		
		%>
	
	
	</body>
</html>