<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="model.User"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="css/signup.css" rel="stylesheet">

<title>Login</title>
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
		<form role="form" action="SignUpController" method="get">
			<fieldset>
				<h2>Enter Account Information</h2>
				<hr class="colorgraph">
				<div class="form-group">
                    <input type="email" name="email" id="email" class="form-control input-lg" placeholder="Email Address">
				</div>
				<div class="form-group">
                    <input type="password" name="password" id="password" class="form-control input-lg" placeholder="Password">
				</div>
				<div class="form-group">
                    <input type="accounttype" name="accounttype" id="accounttype" class="form-control input-lg" placeholder="Account Type">
				</div>
				<div class="form-group">
                    <input type="firstName" name="firstName" id="firstName" class="form-control input-lg" placeholder="First Name">
				</div>
				<div class="form-group">
                    <input type="midName" name="midName" id="midName" class="form-control input-lg" placeholder="Middle Name">
				</div>
				<div class="form-group">
                    <input type="lastName" name="lastName" id="lastName" class="form-control input-lg" placeholder="Last Name">
				</div>
				<div class="form-group">
                    <input type="address" name="address" id="address" class="form-control input-lg" placeholder="Address">
				</div>
				
				
				<hr class="colorgraph">
				<div class="row">
					<div class="col-xs-6 col-sm-6 col-md-6">
                        <input type="submit" class="btn btn-lg btn-success btn-block" value="Create Account">
					</div>
					
				</div>
			</fieldset>
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