package board03;

import java.sql.*;

public class MySqlConnectionMaker  implements ConnectionMaker{//�����ͺ��̽� �ּҰ� ����������� �̰����� �����ϸ� �� 
	private final String URL = "jdbc:mysql://localhost:3306/example?serverTimezone=UTC";
	private final String ID = "root";
	private final String PASSWORD = "1111";
	//���� ������ ���ͼ����ʿ����..
	
	public Connection makeConnection()  throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(URL, ID, PASSWORD);
		return conn;
	}

}
