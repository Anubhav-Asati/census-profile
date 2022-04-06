<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"%>
    
<%-- 
	By setting the attribute isErrorPage="true", this page is 
    designated as error page
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2> Error Page</h2>
	<hr>
	<h3>
			<%
				out.println(exception.getMessage());
			exception.printStackTrace();
			
			
			%>
			<br>
			<%= exception %>
			
	</h3>
	<hr>
</body>
</html>
