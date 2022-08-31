<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Find Books</title>
</head>
<body>
	<c:import url="header.jsp"/>
	<br><br>
	<form action="find-books" method="POST">
		Find books:<input type="text" name="name" placeholder="Title or author name">
		<br> <br> 
		<input type="submit" value="Find">
	</form>
	<c:import url="footer.jsp"/>
</body>
</html>