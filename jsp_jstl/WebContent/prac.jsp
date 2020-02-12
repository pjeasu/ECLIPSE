<%@page import="java.util.ArrayList"%>
<%@page import="edu.bit.prac.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>Insert title here</title>
		<style>
			table, th, td{
			/* 	border:2px solid green; */
				border-collapse: collapse;
			}
			table{
				width:500px;
			}
		</style>
	</head>
	
	<body>
	
	<c:set var="dtos" value="${applicationScope.dtos}" />
<!-- 	<table border = "1" style="text-align: center;"> -->

	<c:forEach var="dtos" items="${arrList }"> 
		<c:set var="ename" value="${dtos.ename}" /> 
		${dtos.ename}
	</c:forEach>


	
			<!-- </table> -->
	</body>
	
</html>

