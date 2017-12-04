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

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	public LoginController() {
		super();
	}
 
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
 
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		RequestDispatcher rd = null;
 
		
		boolean result = Authenticator.authenticate(email, password);
		
		if (result) {
			rd = request.getRequestDispatcher("ItemController");
			User user = new User(email);
			System.out.println(user);
			request.setAttribute("user", user);
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
		} else {
			rd = request.getRequestDispatcher("/error.jsp");
		}
		rd.forward(request, response);
		
	}
 
}