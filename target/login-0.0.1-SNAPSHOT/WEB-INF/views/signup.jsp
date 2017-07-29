<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SIGN UP</title>
</head>
<body>
<h2 align="center">Sign Up</h2>
<div align="center">
<form action="welcome" method="post">
<table><tr></tr><tr><td>
Email:</td> <td><input type="email" name="email"></td></tr>
<tr><td>
Password:</td> <td><input type="password" name="password"></td></tr>
<tr><td>
Username: </td> <td> <input type="text" name="username"></td></tr>
<tr><td>
Date Of Birth: </td> <td> <input type="text" name="dob" placeholder="yyyy/mm/dd"></td></tr>
<tr><td>
Gender: </td> <td>
<select name="gender">
<option value="Male" label="Male"/>
<option value="Female" label="Female"/>
</select>
</td></tr>





<tr><td>
Qualification: </td> <td> <input type="text" name="qualification"></td></tr><tr></tr>
<tr><td></td><td>
<input type="submit" value="signup"></td></tr>
</table>
</form>
<c:set var="ur" value="${pageContext.request.contextPath}"></c:set>
<a href="${ur}/loginpage">login</a>
</div>
</body>
</html>