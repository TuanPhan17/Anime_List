<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/">Home</a>

	<form:form action='/animes/process/create' method='POST'
		modelAttribute="anime">


		<form:label path="title">Title:</form:label>
		<form:input type="text" path="title" />
		<form:errors path="title" />
		<br>

		<form:label path="genre">Genre:</form:label>
		<form:input type="text" path="genre" />
		<form:errors path="genre" />
		<br>

		<form:label path="rating">Rating:</form:label>
		<form:input type="text" path="rating" />
		<form:errors path="rating" />
		<br>

		<form:label path="artist">Artist:</form:label>
		<form:input type="text" path="artist" />
		<form:errors path="artist" />
		<br>

		<form:label path="description">Description:</form:label>
		<form:input type="text" path="description" />
		<form:errors path="description" />
		<br>

		<input type='submit' value='Create Anime to share!!'>


	</form:form>



</body>
</html>