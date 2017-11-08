<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="http://localhost:8080/CyberFlixOne/styles.css">
<title>CyberFlix Search Results</title>
</head>
<body>
<div class="w3-container">
<div class="w3-container w3-center">
<h1>Movies Matching Your Search</h1>
<p>Select one of the choices below to see some more detailed info.</p>
<hr>
</div>
<c:forEach var="film" items="${requestScope.films}">
<a href="${requestScope.detailServlet}">
<div class="w3-card-4 search-result">
<img 
	class="cover-image"
	src="http://localhost:8080/CyberFlixOne/images/jurassicpark.jpg" 
	alt="${film.title}" 
/>
<h3><c:out value="${film.getTitle()}"/></h3>
<div class="result-detail"><b>Year: </b><c:out value="${film.getReleaseYear()}"/></div>
<div class="result-detail"><b>Rating: </b><c:out value="${film.getRating()}"/></div>
<div class="result-detail"><b>Running Time: </b><c:out value="${film.getLength()}"/></div>
<br>
<div class="result-desc"><c:out value="${film.getDescription()}"/></div>
</div>
</a>
</c:forEach>
</div>
</body>
</html>