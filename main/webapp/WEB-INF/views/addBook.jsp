<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Books</title>
</head>
<body>
	<c:import url="header.jsp"/><br>
	<form:form method="post" action="add-book" modelAttribute="book"
		enctype="multipart/form-data">

	<%-- 	<form:errors path="*"></form:errors> --%>
		<table>
			<tr>
				<th>ID</th>
				<td><form:input path="id" placeholder="Enter Book ID"/> <form:errors path="id"></form:errors></td>
			</tr>
			<tr>
				<th>Title</th>
				<td><form:input path="title" placeholder="Enter Title"/> <form:errors path="title"></form:errors></td>
			</tr>
			<tr>
				<th>Publisher</th>
				<td><form:input path="publisher" placeholder="Enter Publisher Number"/> <form:errors
						path="publisher"></form:errors></td>
			</tr>
			<tr>
				<th>Author</th>
				<td><form:input path="author" placeholder="Enter Author Name"/> <form:errors path="author"></form:errors></td>
			</tr>	
			<tr>
				<th>Year</th>
				<td><form:input path="year" placeholder="Enter Publishing Year"/> <form:errors path="year"></form:errors></td>
			</tr>
			<tr>
				<th>Image name</th>
				<td><form:input path="image" placeholder="Enter Image File Name"/> <form:errors path="image"></form:errors></td>
			</tr>
			<tr>
				<th>Image upload</th>
				<td><input type="file" name=bookImage accept="image/jpg"></td>
			</tr>

		</table>
		<br>
		<input type="submit" value="Add book"/>



	</form:form>
	<c:import url="footer.jsp"/>
</body>
</html>

