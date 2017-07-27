<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<h3 align="center">Login Successful</h3>
<h4 align="center">Welcome <c:out value="${username}"/></h4>
<c:set var="va" value="${pageContext.request.contextPath}"></c:set>
<a href="logout">Logout</a>
<a href="profile">Profile</a>
<% 
String ur=request.getContextPath();
if(request.getSession(false)==null){
	response.sendRedirect(ur+"/loginpage");
}
%>
</body>
</html>