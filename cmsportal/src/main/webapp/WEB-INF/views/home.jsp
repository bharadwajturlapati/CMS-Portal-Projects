<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OTV CMS</title>
<!-- load images -->
<link rel="icon" href="<c:url value="/resources/img/favicon.ico"/>"
	type="image/x-icon">
<!-- load stylesheets -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/home.css"/>">
<!-- load scripts -->
<script src="<c:url value="/resources/js/jquery-3.2.1.min.js"/>"></script>
<script src="<c:url value="/resources/js/home.js"/>"></script>
<!-- load Custom Scripts -->
</head>
<body onload="init()">
	<div>
		<p>OTV CMS DashBoard</p>
		<input id="logout" type="button" name="logout" value="Logout">
	</div>
	<p>Hello user: ${username}</p>
</body>
</html>