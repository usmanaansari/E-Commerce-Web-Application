
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="index.jsp">Home</a>
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
            <% if(session.getAttribute("user") == null){ %>
            		<li class="nav-item">
              <a class="nav-link" href= "${loginLink}" >Log In</a>
            </li>
            <% }else{ %>
            		<li class="nav-item">
              <a class="nav-link" href="#">Sign Out</a>
            		</li>
            		<li class="nav-item">
              <a class="nav-link" href="#">My Profile</a>
            		</li>
          
            <%}%>

          </ul>
        </div>
        
        		
      </div>
    </nav>



