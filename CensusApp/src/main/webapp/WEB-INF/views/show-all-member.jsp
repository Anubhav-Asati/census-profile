<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>List of FamilyMembers</h1>



<table border="1">
<tr>
<th>familyMemberId</th>
<th>firstName</th>
<th>lastName</th>
<th>gender</th>
<th>suffix</th>
<th>birthdate</th>
<th>qualification</th>
<th>profession</th>
<th>hobbies</th>
<th>relation</th>
<th>address</th>
<th>location</th>
<th>email</th>
<th>mobile</th>
<th>familyHeadId</th>
</tr>
<c:forEach var="h" items="${familyMemberList}">
<tr>
<td>${h.familyMemberId}</td>
<td>${h.firstName}</td>
<td>${h.lastName}</td>
<td>${h.gender}</td>
<td>${h.suffix }</td>
<td>${h.birthdate }</td>
<td>${h.qualification1}</td>
<td>${h.profession}</td>
<td>${h.hobbies1}</td>
<td>${h.relation}</td>
<td>${h.address}</td>
<td>${h.location}</td>
<td>${h.email}</td>
<td>${h.mobile}</td>
<td>${h.familyHeadId}</td>
<td><a href="update-member?id=${h.familyMemberId}">edit</a>
<a href ="deletefamilymember" = ${h.familyMemberId}>Delete</a>
</td>
</tr>
</c:forEach>
</table>
</body>
</html>