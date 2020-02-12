package comic;

import java.sql.*;
import java.util.ArrayList;

public class BoardController {

	Connection conn;

	public BoardController(ConnectionMaker m) throws Exception {
		conn = m.makeConnection();
	}

	public ArrayList<WriterVO> selectAll() {
		ArrayList<WriterVO> list = new ArrayList<>();
		String sql = "SELECT * FROM writer";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				WriterVO writerVO = new WriterVO();
				writerVO.setId(rs.getInt("id"));
				writerVO.setWriter(rs.getString("writer"));
				list.add(writerVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<InfoVO> selectAllInfo() {
		ArrayList<InfoVO> list = new ArrayList<>();
		String sql = "SELECT * FROM info";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				InfoVO infoVO = new InfoVO();
				infoVO.setId(rs.getInt("id"));
				infoVO.setTitle(rs.getString("title"));
				infoVO.setGenre(rs.getString("genre"));
				infoVO.setWeek(rs.getString("week"));
				list.add(infoVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public WriterVO selectW(int id) {
		WriterVO writerVO = new WriterVO();
		String sql = "SELECT * FROM writer WHERE id = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				writerVO.setId(id);
				writerVO.setWriter(rs.getString("writer"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return writerVO;
	}

	public InfoVO selectI(int id) {
		InfoVO infoVO = new InfoVO();
		String sql = "SELECT * FROM info WHERE id = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				infoVO.setId(id);
				infoVO.setWriterId(rs.getInt("writerId"));
				infoVO.setTitle(rs.getString("title"));
				infoVO.setGenre(rs.getString("genre"));
				infoVO.setWeek(rs.getString("week"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return infoVO;
	}

	public ArrayList<InfoVO> selectOne(int id) {
		ArrayList<InfoVO> list = new ArrayList<>();
		String sql = "SELECT * FROM info WHERE WriterId = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				InfoVO infoVO = new InfoVO();
				infoVO.setWriterId(rs.getInt("writerId"));
				infoVO.setId(rs.getInt("id"));
				infoVO.setTitle(rs.getString("title"));
				infoVO.setGenre(rs.getString("genre"));
				infoVO.setWeek(rs.getString("week"));
				list.add(infoVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void insertW(WriterVO writerVO) {
		String sql = "INSERT INTO writer(writer) VALUES(?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writerVO.getWriter());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertI(InfoVO infoVO, int id) {
		String sql = "INSERT INTO info(title, genre, week, writerId) VALUES(?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, infoVO.getTitle());
			pstmt.setString(2, infoVO.getGenre());
			pstmt.setString(3, infoVO.getWeek());
			pstmt.setInt(4, id);
			pstmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteW(int id) {
		String sql = "DELETE FROM writer WHERE id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteI(int id) {
		String sql = "DELETE FROM info WHERE id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
