<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

</head>
<body>
<c:import url="header.jsp"></c:import>
	<table class = "table table-bordered">
		<tr>
			<th>Image</th>
			<th>BookID</th>
			<th>Author</th>
			<th>Title</th>
			<th>Year</th>
			<th>Publisher</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="book" items="${books}" varStatus="status">
			<tr>
				<td><a><img alt="book cover" width="100" height="100" src="resources/images/${book.image}"></img></a></td>
				<td>${book.id}</td>
				<td>${book.author}</td>
				<td>${book.title}</td>
				<td>${book.year}</td>
				<td>${publisher[status.index]}</td>
				<td><a href="http://localhost:8081/bookArchive/edit-book?id=${book.id}">Edit</a></td>
				<td><a href="http://localhost:8081/bookArchive/delete-book?id=${book.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<c:import url="footer.jsp"/>
</body>
</html>

