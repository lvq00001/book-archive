<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html xmlns:th="http:/www.thymeleaf.org">

<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
	<c:choose>
		<c:when test="${register!= null }">
			<p>${register }</p>
		</c:when>
		<c:when test="${param.logout != null }">
			<p>LOG OUT SUCCESSFULLY!</p>
		</c:when>
		<c:when test="${param.error !=null }">
			<c:import url="wrong-password-username.jsp"></c:import>
		</c:when>
	</c:choose>

	<form th:action="@{/login}" method="post" class="form-horizontal"
		role="form">
		<div class="form-group">
			<label for="username" class="col-sm-2 control-label">User
				Name</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="username"
					placeholder="Enter User Name">
			</div>
		</div>

		<div class="form-group">
			<label for="password" class="col-sm-2 control-label">Password</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" name="password"
					placeholder="Enter Password">
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Log in</button>
			</div>
		</div>
	</form>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10" id="register">
			<form action="register" method="get">
				<button type="submit" class="btn btn-default">Register</button>
			</form>
		</div>
	</div>
</body>
</html>
