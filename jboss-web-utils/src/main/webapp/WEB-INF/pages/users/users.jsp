<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<html>
<head>
	<meta charset="utf-8" />
	<link rel='stylesheet' type='text/css' href='<c:url value="/resources/css/styles.css"/>'>	
</head>


<body>
	<h3>Check if a user exists and which roles she has</h3>
	
	<div class="mini">
	  <form method="POST">
	    <label for="username">First Name</label>
	    <input type="text" id="username" name="username" placeholder="user name">
	
	    <label for="userpass">Last Name</label>
	    <input type="text" id="userpass" name="userpass" placeholder="user password">
	
		<label for="realm">Last Name</label>
	    <input type="text" id="realm" name="realm" value="ApplicationRealm">
	  
	    <input type="submit" value="Submit">
	  </form>
	</div>



	<c:if test="${userForm != null}">
		<hr>
		<h3>Results</h3>
		<label>Username:</label> ${userForm.username}<br/>					
		<label>Userpass:</label> ${userForm.userpass} <br/>
		<label>Realm:</label> ${userForm.realm} <br/>
		<label>Roles:</label> ${userForm.roles} <br/>
		<label>Error:</label> ${userForm.error} <br/>
	</c:if>

</body>
</html>
