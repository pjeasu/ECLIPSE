
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>Insert title here</title>
	</head>
	
	<body>
		<%!
			Connection connection;
			PreparedStatement preparedStatement;
			ResultSet resultSet;
			
			
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String uid = "scott";
			String upw = "tiger";
		
		%>
		<%
		
		try {
			
			Class.forName(driver);
			connection = DriverManager.getConnection(url, uid, upw);
			String query = "insert into member(id, pw, name) values (?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			
			int n;
			preparedStatement.setString(1, "abc");
			preparedStatement.setString(2, "123");
			preparedStatement.setString(3, "ȫ�浿");
			
			n = preparedStatement.executeUpdate();
			preparedStatement.setString(1, "abczz");
			preparedStatement.setString(2, "123zz");
			preparedStatement.setString(3, "ȫ�浿zz");
			
			n = preparedStatement.executeUpdate();
			
			if(n == 1){
				out.println("insert success");
			}else{
				out.println("insert fail");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
					if(resultSet != null) resultSet.close();
					if(preparedStatement != null) preparedStatement.close(); //close �Ҷ��� ��ü�� ������ �������� !!! 
					if(connection != null) connection.close();
				
			} catch (Exception e2) {}
		}
		%>
		
	</body>
	
</html>