<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<h1 align="center">Welcome <c:out value="${detail[2]}"/>
</h1>
<h3 align="center">Signup Successful</h3>
<div align="center">
<form action="loginpage">
<input type="submit" value="LOGIN">
</form>
</div>
</body>
</html>