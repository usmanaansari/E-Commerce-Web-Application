<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body> 
Items: <br>
<table>
	<tr>
		<th>Item Name</th>
		<th>Item Price</th>
		<th>Item Description</th>
		<th>Seller Name</th>
		
	</tr>
	<c:forEach var="tempItem" items="${allItems}" > 
		<tr>
			<td>${tempItem.itemName}</td>
			<td>${tempItem.price}</td>
			<td>${tempItem.description}</td>
			<td>${tempItem.seller.first_name}</td>
		</tr>	
	</c:forEach>
</table>

</body>
</html>