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
	
	<form action="viewProduct">
		<button>View products</button>
	</form>
	<br>
	<br>
	
	
	

	<c:if test="${not empty cnfMsg}">
		${cnfMsg}
		
	</c:if><br>
	<br>
	
	
	
	
	
	<table cellspacing="20">

		<tbody>
		
			<c:forEach items="${productList}" var="product">				
				<tr>
				
					<td>${productList.getName()}</td>
					
					<td><button>Delete</button></a></td>
				</tr>
				
			</c:forEach>
		</tbody>
	</table>


</body>
</html>