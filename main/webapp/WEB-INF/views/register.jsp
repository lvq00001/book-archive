<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
</head>
<body>
	<c:choose>
		<c:when test="${rs != null }">
			<p>${rs }</p>
		</c:when>
	</c:choose>

	<form:form action="register" method="post" modelAttribute="bu">
		<table>
			<tr>
				<th>User name:</th>
				<td><form:input path="username" placeholder="Enter User Name" />
					<form:errors path="username"></form:errors></td>
			</tr>
			<tr>
				<th>Password:</th>
				<td><form:input path="user_password"
						placeholder="Enter Password" /> <form:errors path="user_password"></form:errors>
				</td>
			</tr>
		</table>
		<input type="submit" value="Register" />


	</form:form>
	<c:import url="footer.jsp"/>
</body>
</html>
