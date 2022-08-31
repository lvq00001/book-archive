<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>

<body>
	<c:import url="header.jsp"></c:import>
	<br>
	<p>WELCOME TO BOOK ARCHIVE</p>
	<ul>
		<li><a href="${path}/find-books">Click
				here to find book</a></li>
		<li><a href="${path}/add-book">Click
				here to add book to archive</a></li>
		<li><a href="${path}/list">Click
				here to edit archive</a></li>
	</ul>


	<c:import url="footer.jsp" />


</body>
</html>