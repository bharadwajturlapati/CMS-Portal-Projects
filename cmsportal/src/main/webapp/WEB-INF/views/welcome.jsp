<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Secure Login Page</title>
<!-- load images -->
<link rel="icon" href="<c:url value="/resources/img/favicon.ico"/>"
	type="image/x-icon">
<!-- load stylesheets -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/root.css"/>">
<!-- load scripts -->
<script src="<c:url value="/resources/js/jquery-3.2.1.min.js"/>"></script>
<script src="<c:url value="/resources/js/crypto-js.js"/>"></script>
<script src="<c:url value="/resources/js/app.js"/>"></script>

</head>
<body>
	<!-- login div -->
	<div class="loginsection">
		<div class="welcomesection"></div>
		<div class="userinputsection">
			<input id="userid" type="text" placeholder="User ID" autocomplete="off">
			<input id="password" type="password" placeholder="Password" autocomplete="off">
			<input type="submit" name="signin" value="Login to Portal">
		</div>
	</div>
</body>
</html>