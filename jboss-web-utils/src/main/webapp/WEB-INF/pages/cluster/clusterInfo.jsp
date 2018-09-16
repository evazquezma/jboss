<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<html>
<head>
	<meta charset="utf-8" />
	<link rel='stylesheet' type='text/css' href='<c:url value="/resources/css/styles.css"/>'>
</head>


<body>	
	<div class="mini">
		<form method="POST">
	    	<label for="username">Cache container</label>
	    	<input type="text" id="cacheContainer" name="cacheContainer" placeholder="cache container">

	    	<input type="submit" value="Submit">
	  </form>
	</div>
	
	
	
	<c:if test="${clusterInfo != null}">
		<br/>
		<h3>Members of web cache</h3>
		<ul>
			<c:forEach items="${clusterInfo.members}" var="member">
				<li>${member}</li>
			</c:forEach>
		</ul>
			
			
		<h3>Keys</h3>	
		<ul>
			<c:forEach items="${clusterInfo.keys}" var="key">
				<li><a href='<c:url value="/cache?container=web&key=${key}"/>'>${key}</a></li>
			</c:forEach>
		</ul>
	</c:if>
</body>
</html>