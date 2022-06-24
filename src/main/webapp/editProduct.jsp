<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="editProduct" method="post">
		 <input type="hidden" name="id" 
			value="${product.getId()}"><br> Enter product name : <input
			type="text" name="productName" value="${product.getName()}"><br>
		<br> Enter product brand : <input type="text" name="productBrand"
			value="${product.getBrand()}"><br> <br> Enter
		product quantity : <input type="number" name="productQuantity"
			value="${product.getQuantity()}"><br> <br> <input
			type="submit">
	</form>
</body>
</html>