package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/CartController")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		if(command == null) command = "listCartItems"; //use list as default command
		
		switch(command) { //check the command and route accordingly
		case "listCartItems": listCartItems(request, response);
			break;
		case "addItemToCart": addItemToCart(request, response);
			break;
		case "deleteItemFromCart": deleteItemFromCart(request, response);
			break;
	

		}
	}

	//deletes passed item from cart of current user
	private void deleteItemFromCart(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	//adds passed item to cart of current user
	private void addItemToCart(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	
	private void listCartItems(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}



}
