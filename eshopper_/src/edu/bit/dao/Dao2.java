package edu.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


import edu.bit.dto.Dto;
import edu.bit.dto.Dto2;


public class Dao2 {
DataSource dataSource;
	
	public Dao2() { // 커넥션풀에서 커넥션을 가져오는 때 : 객체 생성할때 바로 !
		try {
			Context context = new InitialContext(); // 커넥션 풀을 설정한 context.xml에서 가져옴
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Dto2> list2() {
		ArrayList<Dto2> dtos = new ArrayList<Dto2>();
		 Connection con = null;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 
		 try {
			con = dataSource.getConnection();
			String query ="select * from dept";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				
				String dName = rs.getString("dname");
				
				Dto2 dto = new Dto2(dName);
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

}
