<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Registetaion Form</h1>
<form action="reg" method="post">
RegNum : <input type="text" name="reg1"/><br><br>
Name : <input type="text" name="name1"/><br><br>
Mail : <input type="text" name="mail1"/><br><br>
password : <input type="password" name="pass1"/><br><br>
Gender : <input type="radio" name="gender1" value="Male"/>Male
		<input type="radio" name="gender1" value="Female"/>FeMale<br><br>
City : <select name="city1">
<option>select city</option>
<option>Bidar</option>
<option>Gulbarga</option>
<option>Bijarpoor</option>
<option>Bengalore</option>
<option>Hydrabad</option>
</select><br><br>
<input type="submit" value="Register"/>
<a href="index.jsp">home</a>
</form>
</body>
</html>