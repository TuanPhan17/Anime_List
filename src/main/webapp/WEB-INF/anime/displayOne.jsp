<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

Welcome to one of ${anime.seller.userName} FAV Anime YAY!! 

<h3>Title: ${anime.title}</h3>

<h3>Genre: ${anime.genre}</h3>

<h3>Rating: ${anime.rating}</h3>

<p>Artist: ${anime.artist}</p>

<h1>Description: ${anime.description}</h1>



</body>
</html>