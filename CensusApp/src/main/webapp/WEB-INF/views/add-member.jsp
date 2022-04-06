<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="addmember">
<table>
<tr><td>First Name:</td><td><input type="text" name="firstname" required/></td></tr>
<tr><td>Last Name:</td><td><input type="text" name="lastname"></td></tr>
<tr><td>Gender</td><td><input type="text" name="gender" placeholder="Enter gender"></td></tr>
<tr><td>Suffix</td><td><input type="text" name="suffix" placeholder="Enter suffix"></td></tr>
<tr><td>Date of Birth</td><td><input type="text" name="birthdate"></td></tr>
<tr><td>Qualification</td><td><input type="text" name="qualification"></td></tr>
<tr><td>Profession</td><td><input type="text" name="profession"></td></tr>
<tr><td>Hobbies</td><td><input type="text" name="hobbies"></td></tr>
<tr><td>Relation</td><td><input type="text" name="relation" placeholder="Enter relation"></td></tr>
<tr><td>Address</td><td><input type="text" name="address"></td></tr>
<tr><td>Location</td><td><input type="text" name="location"></td></tr>
<tr><td>Email</td><td><input type="email" name="email"></td></tr>
<tr><td>Mobile</td><td><input type="number" name="mobile" size="30"></td></tr>
<tr><td>FamilyHeadId</td><td><input type="text" name="familyHeadId"></td></tr>
<tr><td><button type="submit" value="submit" >Submit</button></td></tr>
</table>

</form>

</body>
</html> --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1><font color="blue">Enter Family Member Details</font></h1>

<form action="addmember" method="post" >
<table border="1">
<tr><th>FirstName</th><td><input type="text" name="firstname" size="30"> </td></tr>
<tr><th>LastName</th><td><input type="text" name="lastname" size="30"> </td></tr>
<tr><th>Gender</th><td>
<select name="gender">
<option value = "MALE">MALE</option>
<option value = "FEMALE">FEMALE</option>
<option value = "OTHERS">OTHERS</option>
</select></td></tr>
<tr><th>Suffix</th><td>
<select name="suffix" >
<option value = "MISS">MISS</option>
<option value = "MR">MR</option>
<option value = "MRS">MRS</option>
<option value = "DR">DR</option>
</select></td></tr>
<tr><th>BirthDate</th><td><input type ="date" name = "birthdate"></td></tr>
<tr><th>Qualification</th><td><input type="text" name="qualification" size="100"> </td></tr>
<tr><th>Profession</th><td><input type="text" name="profession" size="30"> </td></tr>
<tr><th>Hobbies</th><td><input type="text" name="hobbies" size="100"> </td></tr>
<tr><th>Relation</th><td>
<select name="relation" >
<option value = "WIFE">WIFE</option>
<option value = "SON">SON</option>
<option value = "DAUGHTER">DAUGHTER</option>
</select></td></tr>
<tr><th>Address</th><td><input type="text" name="address" size="100"> </td></tr>
<tr><th>Location</th><td><input type="text" name="location" size="50"> </td></tr>
<tr><th>Email</th><td><input type="email" name="email" size="50"> </td></tr>
<tr><th>Mobile</th><td><input type="number" name="mobile" size="10"> </td></tr>
<tr><th>FamilyHeadId</th><td><input type="number" name="familyHeadId" size="10"> </td></tr>
<tr><td colspan="2" align="center"> <input type="submit" value="submit"> </td>

</table>
</form>
</body>
</html>

