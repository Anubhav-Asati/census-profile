<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1><font color="blue">Adding Family Head</font></h1>

<form action="addfamilyhead">
<table border="1">
<tr><th>Enter firstName</th><td><input type="text" name="firstname" size="30"> </td></tr>
<tr><th>Enter lastName</th><td><input type="text" name="lastname" size="30"> </td></tr>
<tr><th>Choose gender</th><td>
<select name="gender">
<option value = "MALE">MALE</option>
<option value = "FEMALE">FEMALE</option>
<option value = "OTHERS">OTHERS</option>
</select></td></tr>
<tr><th>Choose Suffix</th><td>
<select name="suffix">
<option value = "MISS">MISS</option>
<option value = "MR">MR</option>
<option value = "MRS">MRS</option>
<option value = "DR">DR</option>
</select></td></tr>
<tr><th>BirthDate</th><td><input type ="date" name = "birthdate"></td></tr>
<tr><th>Enter Qualification</th><td><input type="text" name="qualification" size="100"> </td></tr>
<tr><th>Enter Profession</th><td><input type="text" name="profession" size="30"> </td></tr>
<tr><th>Enter Hobbies</th><td><input type="text" name="hobbies" size="100"> </td></tr>
<tr><th>Enter address</th><td><input type="text" name="address" size="30"> </td></tr>
<tr><th>Enter location</th><td><input type="text" name="location" size="30"> </td></tr>
<tr><th>Enter email</th><td><input type="text" name="email" size="30"> </td></tr>
<tr><th>Enter mobile</th><td><input type="number" name="mobile" size="30"> </td></tr>
<tr><td colspan="2" align="center"> <input type="submit" value="submit"> </td>
<!-- <td colspan="2" align="right"> <input type="text" value="addmember"> </td></tr> -->
</table>
</form>



</body>
</html>