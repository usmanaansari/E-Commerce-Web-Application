
<c:url var="logoutLink" value="LoginController">
<c:param name="logOut" value="true" />
-					</c:url>
		
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="">Home</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
          		<li class="nav-item">
          		
    					<div class="input-group">
     					<input type="text" class="form-control" placeholder="Search for...">
      						<span class="input">
        						<button class="btn btn-default" type="button">Search</button>
     						 </span>
    						</div><!-- /input-group -->
  					
          		</li>
            
            		<li class="nav-item">
              <a class="nav-link" href= "${logoutLink}" >Logout</a>
            </li>
            
            		<li class="nav-item">
              <a class="nav-link" href="#">Cart</a>
            		</li>
            		
            		
            		
            		<li class="nav-item">
              				 <div class="dropdown">
 							 <button class="btn btn-secondary btn-sm dropdown-toggle dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
   								 My Account
 								 </button>
 								 <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
   								 <a class="dropdown-item" href="updateAccount.jsp">Update Account</a>
   								 <a class="dropdown-item" href="updateBillinginfo.jsp">Update Billing Info</a>
  							
 								 </div>
							</div>
              
              
            		</li>
            		


          </ul>
        </div>
        
        		
      </div>
    </nav>