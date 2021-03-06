<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="http://localhost:8080/CyberFlixOne/styles.css">
<title><c:out value="${film.getTitle()}"/></title>
<c:set var="film" value ="${requestScope.film}"/>
</head>
<body>
<div class="w3-center w3-teal title-bar">
<h1>Movie Details</h1>
<hr>
</div>
<div class="w3-card-4 detail-card w3-cyan">
<img 
	class="detail-image"
	src="http://localhost:8080/CyberFlixOne/images/${requestScope.cover}${'.jpg'}"
	alt="${film.title}" 
/>
<h3><c:out value="${film.getTitle()}"/></h3>
<div class="result-detail"><b>Year: </b><c:out value="${film.getReleaseYear()}"/></div>
<div class="result-detail"><b>Rating: </b><c:out value="${film.getRating()}"/></div>
<div class="result-detail"><b>Running Time: </b><c:out value="${film.getLength()}"/> mins</div>
<div class="result-detail"><b>Actors: </b>
<c:if test="${film.getActors().size() == 0}">
None listed for this film.
</c:if>
<c:forEach var="actor" items="${film.getActors()}">
<c:out value="${actor.getFirstName()} ${actor.getLastName()},"/>
</c:forEach>
</div>
<br>
<div class="result-desc"><c:out value="${film.getDescription()}"/></div>
</div>
</body>
</html>