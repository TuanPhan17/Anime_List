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
<h1> FAVORITE ANIME/MANGA</h1>

<a href="/users/logout">Logout</a>


<table>
		<thead>
			<tr>
				<th>Title</th>
				<th>Genre</th>
				<th>Rating</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="anime" items="${allAnimes}">
				<tr>
					<td><a href="/animes/${anime.id}"><c:out value="${anime.title}" /></a></td>
					<td><c:out value="${anime.genre}" /></td>
					<td><c:out value="${anime.rating}" /></td>
					
					<td>
					<c:if test="${anime.seller.id == user_id}">
					<a href="/animes/edit/${anime.id }">Edit</a>
					
					<form action="animes/delete/${anime.id }" method="post">
				
					<input type="hidden" name="_method" value="delete"/>
					<input type="submit" value="delete"/>
					</form>
					</c:if>
					
						<c:if test="${anime.seller.id != user_id}">
					<a href="/animes/${anime.id}">View</a>
					</c:if>
					
					</td>
					
				</tr>
			</c:forEach>

		</tbody>
	</table>
	
	<a href="/animes/create">New Anime!!</a>

</body>

</body>
</html>