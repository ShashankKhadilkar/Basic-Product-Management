<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Basic Product Management</title>
</head>
<body>
	<h1>Product management page</h1>

	<button onclick="document.location='addProduct.jsp'">Add
		product</button>
	<br>
	<br>

	<c:if test="${not empty cnfMsg}">
		${cnfMsg}
		
	</c:if>


</body>
</html>