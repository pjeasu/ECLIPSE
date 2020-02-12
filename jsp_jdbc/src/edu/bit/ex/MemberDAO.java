package edu.bit.ex;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;

//Data Access Object
public class MemberDAO {
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "scott";
	private String upw = "tiger";
	
	public MemberDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	public ArrayList<MemberDTO> memberSelect(){
		ArrayList<MemberDTO> dtos = new ArrayList<MemberDTO>();
		Connection connection = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		
		try {
			connection = DriverManager.getConnection(url, uid, upw);
			stmt = connection.createStatement();
			resultSet = stmt.executeQuery("select * from member");
			
			while(resultSet.next()) {
				String name = resultSet.getString("name");
				String id = resultSet.getString("id");
				String pw = resultSet.getString("pw");
				String phone1 = resultSet.getString("phone1");
				String phone2 = resultSet.getString("phone2");
				String phone3 = resultSet.getString("phone3");
				String gender = resultSet.getString("gender");
				
				MemberDTO dto = new MemberDTO(name, id, pw, phone1, phone2, phone3, gender);
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
