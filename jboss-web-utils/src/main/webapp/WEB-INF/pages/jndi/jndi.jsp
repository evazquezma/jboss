<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<html>
<head>
	<meta charset="utf-8" />
	<link rel='stylesheet' type='text/css' href='<c:url value="/resources/css/styles.css"/>'>
</head>


<body>
	<h3>Check if a JNDI exists</h3>
	
	<div class="mini">
	  <form method="POST">
	    <label for="jndiKey">JNDI key</label>
	    <input type="text" id="jndiKey" name="jndiKey" placeholder="jndiKey">
		  	  
	    <input type="submit" value="Submit">
	  </form>
	</div>
	
	
	<c:if test="${jndiForm != null}">
		<hr>
		<h3>Results</h3>
		<label>JNDI key:</label> ${jndiForm.jndiKey} <br/>
		<label>JNDI value:</label> ${jndiForm.jndiValue} <br/>
		<label>JNDI class:</label> ${jndiForm.jndiClass} <br/>
		<label>Error:</label> ${jndiForm.error} <br/>
	</c:if>

</body>
</html>