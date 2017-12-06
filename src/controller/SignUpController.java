package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import model.Authenticator;
import model.User;
import mysql.DBConnection;

@WebServlet("/SignUpController")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	public SignUpController() {
		super();
	}
 
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
		Connection con;
		ResultSet rs;
		Statement st = null;
			con = (Connection) DBConnection.getConnection();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String fName = request.getParameter("firstName");
		String mName = request.getParameter("midName");
		String lName = request.getParameter("lastName");
		String accType = request.getParameter("accounttype");
		String address = request.getParameter("address");

		RequestDispatcher rd = null;
		String query = "select * from users where user_email =" + "'" + email + "'" +  ";" ;
		
			st = con.createStatement();
			rs = st.executeQuery(query);
			
		
		
		if (!rs.next()) {
			rd = request.getRequestDispatcher("ItemController");
			User user = new User(email, password, accType, fName, mName, lName, address);
			user.addUserToDB();
			System.out.println(user);
			request.setAttribute("users", user);
			HttpSession session = request.getSession();
			session.setAttribute("users", user);
		} else {
			rd = request.getRequestDispatcher("/error.jsp");
		}
		rd.forward(request, response);
		}
		
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
 
	}
}