package edu.bit.prac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DAO {
	private DataSource dataSource;
	
	public DAO() {
		try {
			Context context = new InitialContext();
		
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	public ArrayList<DTO> dtos(){
		ArrayList<DTO> dtos = new ArrayList<DTO>();
		Connection connection = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			resultSet = stmt.executeQuery("select * from emp");
			
			while(resultSet.next()) {
				String empno = resultSet.getString("empno");
				String ename = resultSet.getString("ename");
				String job = resultSet.getString("job");
				String mgr = resultSet.getString("mgr");
				String hiredate = resultSet.getString("hiredate");
				String sal = resultSet.getString("sal");
				String comm = resultSet.getString("comm");
				String deptno = resultSet.getString("deptno");
				
			DTO dto = new DTO(empno, ename, job, mgr, hiredate, sal, comm, deptno);
				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
					if(resultSet != null) resultSet.close();
					if(stmt != null) stmt.close(); //close 할때는 객체가 생성된 역순으로 !!! 
					if(connection != null) connection.close();
				
			} catch (Exception e2) {}
		}
		return dtos;
	}
}
