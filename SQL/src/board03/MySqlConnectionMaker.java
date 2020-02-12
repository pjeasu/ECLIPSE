package board03;

import java.sql.*;

public class MySqlConnectionMaker  implements ConnectionMaker{//데이터베이스 주소가 ㅂㅏ뀌었을시 이곳에서 수정하면 됨 
	private final String URL = "jdbc:mysql://localhost:3306/example?serverTimezone=UTC";
	private final String ID = "root";
	private final String PASSWORD = "1111";
	//위의 세개는 겟터셋터필요없음..
	
	public Connection makeConnection()  throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(URL, ID, PASSWORD);
		return conn;
	}

}
