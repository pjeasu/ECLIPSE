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
	
	public Dao2() { // Ŀ�ؼ�Ǯ���� Ŀ�ؼ��� �������� �� : ��ü �����Ҷ� �ٷ� !
		try {
			Context context = new InitialContext(); // Ŀ�ؼ� Ǯ�� ������ context.xml���� ������
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
