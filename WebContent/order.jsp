<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="model.User"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="css/signup.css" rel="stylesheet">

<title>Sign Up</title>
</head>
<body>



<div class="container">
  

<% if (session.getAttribute("users") == null){ %>
	<%@include file="publicHeader.jsp"%>
	<%}else if (((User)session.getAttribute("users")).getAccountType().equals("customer")){ %> 
	<%@include file="customerHeader.jsp"%>
	<%}else if (((User)session.getAttribute("users")).getAccountType().equals("seller")){%>
	<%@include file="sellerHeader.jsp" %>
	<%} else{ %>
	<%@include file="employeeHeader.jsp" %>
	<%} %>
	
<div class="row" style="margin-top:120px" id="center">
    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
		<form role="form" action="OrderController" method="get">
		
		
		
		</form>
	</div>
</div>

</div>

	  <!-- Bootstrap core JavaScript -->
	   <script src="vendor/jquery/jquery.min.js"></script>
	  <script src="javaScript/signup.js"></script>
   
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    
    
</body>
</html>