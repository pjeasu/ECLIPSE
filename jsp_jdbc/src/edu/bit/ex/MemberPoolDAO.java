package edu.bit.ex;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.Statement;

//Ŀ�ؼ� Ǯ ���� �� �� �ڵ� ���� ����
public class MemberPoolDAO {
//	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
//	private String uid = "scott";
//	private String upw = "tiger";
	
	//DataCource = Connection Pool 
	private DataSource dataSource;
	
	
	
	
	
	public MemberPoolDAO() {
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Context context = new InitialContext();
			//JNDI�� JavaNaming and Directory interface 
			// ��� �� ���丮 ���񽺿� �����ϱ� ���� API
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
													//�ڹٿ��� ���� �ּ�ü��
			
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
//			connection = DriverManager.getConnection(url, uid, upw);
			connection = dataSource.getConnection();
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
					if(stmt != null) stmt.close(); //close �Ҷ��� ��ü�� ������ �������� !!! 
					if(connection != null) connection.close();
				
			} catch (Exception e2) {}
		}
		return dtos;
	}
}
