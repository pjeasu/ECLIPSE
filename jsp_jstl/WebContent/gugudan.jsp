<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>������</title>
	<!--������ ����� jstl, el�� Ȱ���Ͽ� ����Ͻÿ� style ���̺� ������ : green -->
	<style>
		table, tr, td {
			border:2px solid ;
			background-color: green;
			border-collapse: collapse;
		}
	</style>
	</head>
	<body>
		<table border = "1" >
			<c:forEach var ="i" begin="1" end = "9" >
				<tr>
					<c:forEach var = "j"  begin="2" end = "9" >
					 	<td> ${j} x  ${i} = ${i * j}</td>
					</c:forEach>
				</tr>
			</c:forEach>
		</table>
	
	<br><br><br>
	
	<table border = "1" >
		<c:forEach var ="i" begin="1" end = "9" >
		<tr>
			<c:forEach var = "j"  begin="2" end = "9" >
				<c:if test="${j % 2 == 0}">
					 <td> ${j} x  ${i} = ${i * j}</td>
				</c:if>
			</c:forEach></tr>
		</c:forEach>
	</table>
	
	<br><br><br>
	
	<table border = "1" >
		<c:forEach var ="i" begin="1" end = "9" >
			<tr>
				<c:forEach var = "j"  begin="2" end = "9" >
					<c:if test="${(i*j) % 2 == 0}">
				 <td> ${j} x  ${i} = ${i * j}</td>
					</c:if>
				<c:if test="${(i*j) % 2 != 0}">
					 <td> ${" "} </td>
					</c:if>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
	
	</body>
</html>

