<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ page import="model.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
	
<h1>Login failed, please try again. </h1>
 
</body>
</html>