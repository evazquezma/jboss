<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
	<meta charset="utf-8" />
	<link rel='stylesheet' type='text/css' href='<c:url value="/resources/css/styles.css"/>'> 	
</head>


<body>
<p>
	<a href="<c:url value="/vault"/>">Check vault</a>
</p>
	
<p> 
	<a href="<c:url value="/users"/>">Check User</a>
</p>

<p>
	<a href="<c:url value="/jndi"/>">Check jndi</a>
</p>
	
</body>
</html>