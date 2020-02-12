package edu.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import edu.bit.dto.DTO;

public class DAO {
	DataSource dataSource;
	
	public DAO() { // 커넥션풀에서 커넥션을 가져오는 때 : 객체 생성할때 바로 !
		try {
			Context context = new InitialContext(); // 커넥션 풀을 설정한 context.xml에서 가져옴
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	 public ArrayList<DTO> list(){
		 ArrayList<DTO> dtos = new ArrayList<DTO>();
		 Connection con = null;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 
		 try {
			con = dataSource.getConnection();
			String query ="select * from mvc_board order by bGroup desc, bStep asc";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				int bId = rs.getInt("bId");
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");

				Timestamp bDate = rs.getTimestamp("bDate");

				int bHit = rs.getInt("bHit");
				int bGroup = rs.getInt("bGroup");
				int bStep = rs.getInt("bStep");
				int bIndent = rs.getInt("bIndent");
				
				DTO dto = new DTO(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		 
		 return dtos;
	 }
	 
	public void write(String bName, String bTitle, String bContent) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = dataSource.getConnection();
			String query = "insert into mvc_board (bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) "
					+ "values (mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0 )";
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			int rn = pstmt.executeUpdate();

			if (rn == 1) {
				System.out.println("정상");
			} else {
				System.out.println("비정상 처리");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	
		
		
	}


	public DTO contentView(String bId) {
		upHit(bId);
		
		DTO dto = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			String query = "select * from mvc_board where bId = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1,  Integer.parseInt(bId));
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int bNum = rs.getInt("bId");
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bContent");
				String bContent = rs.getString("bContent");
				Timestamp bDate = rs.getTimestamp("bDate");
				int bHit = rs.getInt("bHit");
				int bGroup = rs.getInt("bGroup");
				int bStep = rs.getInt("bStep");
				int bIndent = rs.getInt("bIndent");
				
				dto = new DTO(bNum, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)
					rs.close();
				if(pstmt!= null)
					pstmt.close();
				if(con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		return dto;
	}


	private void upHit(String bId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = dataSource.getConnection();
			String query = "update mvc_board set bHit = bHit+1 where bId = ?";
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(bId));
			
			
			int rn = pstmt.executeUpdate();
			
			if (rn == 1) {
				System.out.println("success");
			} else {
				System.out.println("fail");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}


	public void modify(String bName, String bTitle, String bContent, String bId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = dataSource.getConnection();
			String query = "update mvc_board set bName = ?, bTitle = ?, bContent = ? where bId = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setInt(4, Integer.parseInt(bId));
			
			int rn = pstmt.executeUpdate();

			if (rn == 1) {
				System.out.println("success");
			} else {
				System.out.println("fail");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}


	public void delete(String bId) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = dataSource.getConnection();
			String query = "delete from mvc_board WHERE bId = ?";
			pstmt = conn.prepareStatement(query);
			System.out.println(bId);
			pstmt.setInt(1, Integer.parseInt(bId));

			boolean rn = pstmt.execute();

			if (rn == true) {
				System.out.println("success");
			} else {
				System.out.println("fail");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}


	public void reply(String bId, String bName, String bTitle, String bContent, String bGroup, String bStep,
			String bIndent) {
		
		replyShape(bGroup, bStep);
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = dataSource.getConnection();
			String query = "insert into mvc_board (bId, bName, bTitle, bContent,bGroup, bStep, bIndent) "
					+ "values (mvc_board_seq.nextval, ?, ?, ?, ?, ?, ? )";
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setInt(4, Integer.parseInt(bGroup));
			pstmt.setInt(5, Integer.parseInt(bStep)+1);
			pstmt.setInt(6, Integer.parseInt(bIndent)+1);
			
			
			int rn = pstmt.executeUpdate();

			if (rn == 1) {
				System.out.println("정상");
			} else {
				System.out.println("비정상 처리");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}


	private void replyShape(String bGroup, String bStep) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = dataSource.getConnection();
			String query = "update mvc_board set bStep = bStep+1 where bGroup = ? and bStep>?"; 
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, Integer.parseInt(bGroup));
			pstmt.setInt(2, Integer.parseInt(bStep));
			
			int rn = pstmt.executeUpdate();

			if (rn == 1) {
				System.out.println("정상");
			} else {
				System.out.println("비정상 처리");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}


	public DTO reply_view(String bId) {
		upHit(bId);
		
		DTO dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();

			String query = "select * from mvc_board where bId = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(bId));

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int number = rs.getInt("bId");
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");
				Timestamp bDate = rs.getTimestamp("bDate");
				int bHit = rs.getInt("bHit");
				int bGroup = rs.getInt("bGroup");
				int bStep = rs.getInt("bStep");
				int bIndent = rs.getInt("bIndent");

				dto = new DTO(number, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		
		
		
		
		return dto;
	}
	
}
