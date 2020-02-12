<%@page import="java.util.ArrayList"%>
<%@page import="edu.bit.hw.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>Insert title here</title>
		<style>
			table, th, td{
				border:2px solid green;
				border-collapse: collapse;

			}
			table{
				width:500px;
			}
		</style>
	</head>
	
	<body>
	<table border = "1" style="text-align: center;">
		<%
			//MemberDAO memberDAO = new MemberDAO();
			//ArrayList<MemberDTO> dtos = memberDAO.memberSelect();
			
			DAO dao = new DAO();
			ArrayList<DTO> dtos = dao.memberSelect();
			
			
			for(int i = 0; i<dtos.size(); i++){
				DTO dto = dtos.get(i);
				
				String empno = dto.getEmpno();
				String ename = dto.getEname();
				String job = dto.getJob();
				String mgr = dto.getMgr();
				String hiredate = dto.getHiredate();
				String sal = dto.getSal();
				String comm = dto.getComm();
				String deptno = dto.getDeptno();
				
				out.println("<tr><td>" + ename + "</td>");
				out.println("<td>" + hiredate + "</td></tr>");
				
			}
		%>
			</table>
	</body>
	
</html>

