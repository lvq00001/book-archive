<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Books</title>
</head>
<body>
	<c:import url="header.jsp"></c:import>
	<form:form method="post" action="edit-book" modelAttribute="book">
		<table>
			<tr>
				<td>ID:</td>
				<td><form:input path="id" /></td>
			</tr>
			<tr>
				<td>Title:</td>
				<td><form:input path="title" /></td>
			</tr>
			<tr>
				<td>Publisher:</td>
				<td><form:input path="publisher" /></td>
			</tr>
			<tr>
				<td>Author(s):</td>
				<td><form:input path="author" /></td>
			</tr>
			<tr>
				<td>Image:</td>
				<td><form:input path="image" /></td>
			</tr>
		</table>
		<input type="submit" value="Edit" />
	</form:form>
	<c:import url="header.jsp"></c:import>
</body>
</html>

