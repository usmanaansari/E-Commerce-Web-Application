package controller;
 
import java.io.IOException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Authenticator;
import model.User;

@WebServlet("/UserAccountController")

public class UserAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private User user;

	public UserAccountController() {
		super();
	}

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			user = (User)req.getSession().getAttribute("users");
			
			System.out.println(user.getFirst_name());
			
			loadUser(req,resp);
			
		}
		catch(Exception exc) {
			
		}
		
		
		
		
	}
	
	
	private void callUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String firstName = req.getParameter("firstName");
		String middleName = req.getParameter("middleName");
		String lastName = req.getParameter("lastName");
		String Email = req.getParameter("Email");
		String Address = req.getParameter("Address");
		
		user.setFirst_name(firstName);
		user.setMiddle_name(middleName);
		user.setLast_name(lastName);
		user.setUserEmail(Email);
		user.setUserAddress(Address);
		
		user.updateUser();
		
	}
	private void loadUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		req.setAttribute("THE_USER", user);
		
	
		RequestDispatcher dispatcher = req.getRequestDispatcher("/updateAccount.jsp");
		
	
		dispatcher.forward(req, resp);
		callUpdate(req,resp);
		
	}
	
}
