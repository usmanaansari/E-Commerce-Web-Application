<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="css/login.css" rel="stylesheet">
<title>Update Billing Info</title>
</head>
<body>

<% if (session.getAttribute("users") == null){ %>
	<%@include file="publicHeader.jsp"%>
	<%}else if (((User)session.getAttribute("users")).getAccountType().equals("customer")){ %> 
	<%@include file="customerHeader.jsp"%>
	<%}else if (((User)session.getAttribute("users")).getAccountType().equals("seller")){%>
	<%@include file="sellerHeader.jsp" %>
	<%} else{ %>
	<%@include file="employeeHeader.jsp" %>
	<%} %>
	
	
	<div>
		<br></br>
		<br></br>

		<h3> Update Account</h3>
		
		<form action="BillingInfoController" method="GET">
		
			
				<table>
					<tbody>
					<tr>
						<td> <label>Card Number:</label></td>
						<td><input type="text" name="cardNumber"value="${THE_USER.first_name}" /> </td>
					</tr>
					
					<tr>
						<td> <label>Expiration Date:</label></td>
						<td><input type="text" name="expirationDate"value="${THE_USER.middle_name}" /> </td>
					</tr>
					
					<tr>
						<td> <label>Security Code:</label></td>
						<td><input type="text" name="securityCode" value="${THE_USER.last_name}" /> </td>
					</tr>

					
					<tr>
						<td> <label>Billing Address:</label></td>
						<td><input type="text" name="billingAddress" value="${THE_USER.userAddress}" /> </td>
					</tr>
					
					
				
	
					</tbody>
				
				</table>
		
		<input type ="submit" value="Save" />
		</form>
	
	
	</div>




   <!-- Bootstrap core JavaScript -->
	   <script src="vendor/jquery/jquery.min.js"></script>
	  <script src="javaScript/login.js"></script>
   
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>




</html>