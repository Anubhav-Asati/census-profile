<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>List of FamilyHead</h1>
	
	<table border="1">
	    <tr><th>familyHeadId</th>
	    <th>firstName</th><th>lastName</th><th>gender</th><th>suffix</th><th>birthdate</th>
	    					<th>qualification</th><th>profession</th><th>hobbies</th><th>address</th><th>location</th><th>email</th><th>mobile</th><th>action</th></tr>
		<c:forEach var="e" items="${familyHeadList}">
			<tr><td>${e.familyHeadId}</td><td>${e.firstName }</td><td>${e.lastName}</td><td>${e.gender }</td>
				<td>${e.suffix }</td><td>${e.birthdate }</td><td>${e.qualification1 }</td>
				<td>${e.profession}</td><td>${e.hobbies1}</td></td><td>${e.address}</td></td><td>${e.location}</td></td><td>${e.email}</td></td><td>${e.mobile}</td>
				<td><a href="edit-familyhead?id=${e.familyHeadId}">edit</a>
				<a href ="deletefamilyhead" = ${e.familyHeadId}>Delete</a></td> </tr>
		</c:forEach>	
	
	</table>



</body>
</html>