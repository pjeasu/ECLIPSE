package edu.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


import edu.bit.dto.Dto;


public class Dao {
DataSource dataSource;
	
	public Dao() { // 커넥션풀에서 커넥션을 가져오는 때 : 객체 생성할때 바로 !
		try {
			Context context = new InitialContext(); // 커넥션 풀을 설정한 context.xml에서 가져옴
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Dto> list() {
		ArrayList<Dto> dtos = new ArrayList<Dto>();
		 Connection con = null;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 
		 try {
			con = dataSource.getConnection();
			String query ="select * from emp";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				
				String sal = rs.getString("sal");
				String eName = rs.getString("ename");
				
				Dto dto = new Dto(eName, sal);
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
