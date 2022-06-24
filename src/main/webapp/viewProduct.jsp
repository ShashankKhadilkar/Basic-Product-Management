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
	<table cellspacing="20">

		<tbody>

			<tr>
				<th>Product Id</th>
				<th>Product Name</th>
				<th>Product Brand</th>
				<th>Product Quantity</th>



			</tr>

			<c:forEach items="${productList}" var="product">
				<tr>

					<td>${product.getId()}</td>
					<td>${product.getName()}</td>
					<td>${product.getBrand()}</td>
					<td>${product.getQuantity()}</td>

					<td><a href="deleteProduct/${product.getId()}"><button>Delete</button></a></td>
					
					<td><c:set var="id" value="${product.getId()}" scope="session" /><button onclick="document.location='editProduct.jsp'">Edit</button></a></td>

				</tr>

			</c:forEach>
		</tbody>
	</table><br>
	<br>
	
	<c:if test="${not empty cnfMsg}">
		${cnfMsg}
		<c:remove var="cnfMsg" scope="session" />
		
	</c:if><br>
	<br>
</body>
</html>