<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>

<link rel="stylesheet" href="resources/css/header-footer.css">
</head>
<body>
	<header>
			User:
			<c:import url="/user-info"></c:import>
			<c:import url="userInfo.jsp"></c:import>
			|
			<c:import url="logout.jsp"></c:import>
	</header>

</body>
</html>