<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>Insert title here</title>
	</head>
	
	<body>
	
		<c:set var = "vatName" value = "varValue"/>
			vatName : <c:out value = "${vatName }"/><br>
		
		<c:set var = "num" value = "100"/>
			num : <c:out value = "${num }"/><br>
			
			
		<c:remove var="num"/>
			vatName : <c:out value = "${vatName }"/><br>
			num : <c:out value = "${num }"/><br>
		
		
		<br><hr>
		
		<c:catch var="error">
			<%= 2/0 %>
		</c:catch>
		<br>
		<c:out value="${error}"></c:out>
		
		<br><br><hr><br>
		
		<c:if test="${1+2 == 3}">
			1 + 2 = 3
		</c:if>
		
		<c:if test="${1+2 != 3}">
			1 + 2 = 3
		</c:if><br>
		
		<c:if test="true">
			true
		</c:if>
		
		<br><br><hr><br>
		
		<c:forEach var ="feach" begin="0" end = "30" step = "3"> 
			${feach}
		</c:forEach>
		
		<br><br><hr><br>
		
		
		<c:choose>
			<c:when test="${1>0}">
				1은 0보다 크다 <br>
			</c:when>
			
			<c:when test="${2>0}">
				2도 0보다 크다 <br>
			</c:when>
			
			<c:otherwise>
				다크다,, <br>
			</c:otherwise>
		</c:choose>
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	</body>
	
</html>