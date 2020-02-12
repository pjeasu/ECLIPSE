import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//자바에 연결하기위해서는 자바의 sql패키지의 커넥션 클래스와 드라이버매니저클래스와 SQLExcption클래스를 불러와야한다
// 또한 자바에서는  MySQL드라이버를 기본으로 제공하지 않기떄문에 외부에서 받아와서 로딩해줘야한다.

//가장 기본적인 MySQL 연결하는 방식...

public class Ex01 {
	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		//커넥션 객체가 하는 일...
		//우리가 mysql 드라이버를 불러오면 연결을 유지시켜줌
		
		//try catch finally 리셉션이 발생하는 코드들을 안전하게 처리해줌
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?serverTimezone=UTC", "root","1111");
			//local host : 자기 자신의 컴퓨터를 뜻함 3306은 포트번호
				System.out.println("로그인성공");
		}catch(ClassNotFoundException  | SQLException e ) {
			e.printStackTrace(); 
			//오류상태를 출력만 하기보다는 사용자가 오류 상황을 인식하기 쉽게.. 어찌구... 
		
		}finally {
			if(conn != null && !conn.isClosed()) {//커넥션에 성공했고 아직 닫히지않았따면 ! 
				conn.close();
			}
			System.out.println("여기서 마지막으로 마무리 작업");
		}
		
		
	}
	
}
