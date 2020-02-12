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
	
	public Dao() { // Ŀ�ؼ�Ǯ���� Ŀ�ؼ��� �������� �� : ��ü �����Ҷ� �ٷ� !
		try {
			Context context = new InitialContext(); // Ŀ�ؼ� Ǯ�� ������ context.xml���� ������
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
