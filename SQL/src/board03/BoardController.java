package board03;

import java.sql.*;
import java.util.ArrayList;

//Database와 통신을 담당하는 컨트롤러 클래스
//만약 DB와의 기능이 추가 적으로 더 필요해진다면 컨드롤러만 건드린다. >> 유지보수 용이


public class BoardController {
	//의존성 주입을 위해 필드와 셋터를 만든다
	//하지만 셋터를 이용한 의존성 주입은 강제성이 떨어지기 때문에 기본생성자를 막고 파라미터가 있는 생성자를 만들어서 
	//꼭 ConnectionMaker가 들어와서 makeConnection()메소드를 통해서 Connection conn이 초기화가 될수있게 만들어서
	//생성자를 통한 DI를 구현한다.

	Connection conn; //여기서 결정되는게아니라 외부에서 호출을할떄 주입.. 되는것을 결정하는것.. 
	//makeConnection()에서 리턴된 콘으로 초기화를 한것
	
	
//	public void setConn(ConnectionMaker m) throws Exception {
//	conn = m.makeConnection();
//}
	
	public BoardController(ConnectionMaker m) throws Exception{
		conn = m.makeConnection();//기본생성자가 만들어지는것을 막는다
		//의존성을...주입하는것.... 
	}

	public ArrayList<BoardVO> selectAll() {
		ArrayList<BoardVO> list = new ArrayList<>();
		String sql = "SELECT * FROM board";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);		
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO b = new BoardVO();
				b.setId(rs.getInt("id"));
				b.setTitle(rs.getString("title"));
				b.setContent(rs.getString("content"));
				b.setWrittenDate(rs.getDate("writtenDate"));
				b.setUpdatedDate(rs.getDate("updatedDate"));
				list.add(b);
						
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return list;
	}

	public BoardVO select(int id) {
		BoardVO boardVO = new BoardVO();
		String sql = "SELECT * FROM board WHERE id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				boardVO.setId(id);
				boardVO.setTitle(rs.getString("title"));
				boardVO.setContent(rs.getString("content"));
				boardVO.setWrittenDate(rs.getDate("writtenDate"));
				boardVO.setUpdatedDate(rs.getDate("updatedDate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardVO;
	}
	
	
	public void insert(BoardVO boardVO) {
		String sql = "INSERT INTO board(title, content, writtenDate, updatedDate) VALUES(?, ?, NOW(), NOW())";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardVO.getTitle());
			pstmt.setString(2, boardVO.getContent());
			pstmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(BoardVO boardVO) {
		String sql = "UPDATE board SET title = ?, content = ?, updatedDate = NOW() WHERE id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  boardVO.getTitle());
			pstmt.setString(2, boardVO.getContent());
			pstmt.setInt(3, boardVO.getId());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void delete(int id) {
		String sql = "DELETE FROM board WHERE id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
