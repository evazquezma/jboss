<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<html>
<head>
	<meta charset="utf-8" />
	<link rel='stylesheet' type='text/css' href='<c:url value="/resources/css/styles.css"/>'> 	
</head>

<body>
	<h3>Decrypt vault</h3>
	
	<div class="mini">
	  <form method="POST">
	    <label for="secret">Vault value</label>
	    <input type="text" id="secret" name="secret" placeholder="VAULT::...">
		  	  
	    <input type="submit" value="Submit">
	  </form>
	</div>
	
	
	<c:if test="${vaultForm != null}">
		<hr>
		<h3>Results</h3>
		<label>Vault value:</label> ${vaultForm.cypher} <br/>
		<label>Clear value:</label> ${vaultForm.clear} <br/>
		<label>Error:</label> ${vaultForm.error} <br/>
	</c:if>

</body>
</html>