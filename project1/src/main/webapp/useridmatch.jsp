<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String a = (String)session.getAttribute("user");

			
%>
<form action="pwdchnsuccessupdate" method="get">
		USERNAME:<input type="text" readonly name="un" value="<%=a%>"><br><br>
		ENTER NEW PASSWORD:<input type="text" name="pw"><br><br>
		<button type="submit">Go</button>
		</form>

</body>
</html>