<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
</head>
<body>
<h1 align="center">Profile</h1>
<div align="center">
<c:forEach var="test" items="${orgs}">
<table border="solid"><tr></tr>
<tr><td> Username:</td><td>
<c:out value="${test.username}"/></td></tr>
<tr><td>Email:</td><td>
<c:out value="${test.email}"/></td></tr>
<tr><td>Date of Birth:</td><td>
<c:out value="${test.dob}"/></td></tr>
<tr><td>Gender:</td><td>
<c:out value="${test.gender}"/></td></tr>
<tr><td>Qualification:</td><td>
<c:out value="${test.qualification}"/></td></tr>
</table>
</c:forEach>
</div>
</body>
</html>