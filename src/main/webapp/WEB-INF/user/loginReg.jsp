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

<h1>login reg page</h1>



	<h1>Register</h1>
	<form:form action="/users/process/register" method="post"
		modelAttribute="user">

		<label>User Name</label>
		<form:input path="userName" />
		<form:errors path="userName" />
		<br>

		<label>Email</label>
		<form:input path="email" />
		<form:errors path="email" />
		<br>

		<label>Password</label>
		<form:input path="password" />
		<form:errors path="password" />
		<br>

		<label>Confirm Password</label>
		<form:input path="confirm" />
		<form:errors path="confirm" />
		<br>

		<input type="submit" value="Register User" />
	</form:form>


	<h1>login</h1>
	<form:form action="/users/process/login" method="post"
		modelAttribute="loginUser">

		<label>Email</label>
		<form:input path="email" />
		<form:errors path="email" />
		<br>

		<label>Password</label>
		<form:input path="password" />
		<form:errors path="password" />
		<br>

		<input type="submit" value="Login" />
	</form:form>


</body>
</html>