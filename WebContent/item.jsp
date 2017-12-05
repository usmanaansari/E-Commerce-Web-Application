<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Item</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/shop-item.css" rel="stylesheet">

  </head>

  <body>

<%@include file="header.jsp"%>

    <!-- Page Content -->
    <div class="container">

      <div class="row">

      
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">

          <div class="card mt-4">
            <img class="card-img-top img-fluid" src="http://placehold.it/900x400" alt="">
            <div class="card-body">
              <h3 class="card-title">${item.itemName}</h3>
              <h4>$ ${item.price}</h4>
              <p class="card-text">${item.description }</p>
              Sold by ${item.seller.userEmail} <br>
              Quantity: ${item.quantity} <br>
              
              <% if(session.getAttribute("user") != null){ %>
            <form action="CartController" method="GET">
				<input type="hidden" name="command" value="addToCart" />
				<input type="hidden" name="itemId" value="${item.itemId}" />
				<input type="submit" value="Add to Cart" class ="btn btn-success" />
				</form>
            <% }%>

            </div>
          </div>
          <!-- /.card -->

          <div class="card card-outline-secondary my-4">
            <div class="card-header">
              Product Reviews
            </div>
            <div class="card-body">
            
            <c:forEach var="tempReview" items="${reviews}" > 
              <p>${tempReview.description} </p>
              <small class = "muted"> Posted by ${tempReview.customer.userEmail} </small>
              <hr>
              
            </c:forEach>
            <form action="ItemController" method="GET">
            <input type="hidden" name="command" value="addReview" />
            <input type="hidden" name="itemId" value="${item.itemId}" />
          	 <div class="form-group">
    				
    			
    				<input class="form-control input-lg" id="inputlg" type="text" name="reviewDesc">
 			 </div>
              <input type=submit class="btn btn-success" value ="Leave a Review">
              </form>
            </div>
          </div>
          <!-- /.card -->

        </div>
        <!-- /.col-lg-9 -->

      </div>

    </div>
    <!-- /.container -->

    <!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Your Website 2017</p>
      </div>
      <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  </body>

</html>


<body>
	ITEM <br>
	Item Name: ${item.itemName} <br>
	Item Description: ${item.description} <br>
	Item Price: ${item.price } <br>
		<form action="CartController" method="GET">
			<input type="hidden" name="command" value="addToCart" />
			<input type="hidden" name="itemId" value="${item.itemId}" />
			<input type="submit" value="Add to Cart" />
		</form>
</body>
