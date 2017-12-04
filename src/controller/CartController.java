package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;

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
		case "addToCart": addToCart(request, response);
			break;
		case "deleteFromCart": deleteItemFromCart(request, response);
			break;
		default: listCartItems(request, response);

		}
	}

	//deletes passed item from cart of current user
	private void deleteItemFromCart(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	//adds passed item to cart of current user
	private void addToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Item item = new Item(Integer.parseInt(request.getParameter("itemId")));
		int userId = ((User)request.getSession().getAttribute("user")).getUser_id();
		item.addItemToCart(userId);
		request.setAttribute("item", item);

		RequestDispatcher dispatch = request.getRequestDispatcher("/item.jsp");
		dispatch.forward(request, response);
		
	}

	
	private void listCartItems(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}



}
