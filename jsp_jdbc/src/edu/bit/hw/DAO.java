package edu.bit.hw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DAO {
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "scott";
	private String upw = "tiger";
	
	public DAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	public ArrayList<DTO> memberSelect(){
		ArrayList<DTO> dtos = new ArrayList<DTO>();
		Connection connection = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		
		try {
			connection = DriverManager.getConnection(url, uid, upw);
			stmt = connection.createStatement();
			resultSet = stmt.executeQuery("select * from emp where comm IS NULL ");
			
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
