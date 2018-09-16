<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<html>
<head>
	<meta charset="utf-8" />
	<link rel='stylesheet' type='text/css' href='<c:url value="/resources/css/styles.css"/>'>
</head>


<body>
	<h3>Cache info</h3>	
	
	<h3>Results</h3>
	<label>Cache container:</label> ${cacheForm.container} <br/>
	<label>Cache key:</label> ${cacheForm.key} <br/>
	<label>Cache value:</label> ${cacheForm.value} <br/>
	<label>Cache value class:</label> ${cacheForm.valueClass} <br/>
	<label>Error:</label> ${cacheForm.error} <br/>
		
</body>
</html>