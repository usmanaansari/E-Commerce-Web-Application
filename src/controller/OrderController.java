package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BillingInfo;
import model.Item;
import model.Order;
import model.User;

/**
 * Servlet implementation class OrderController
 */
@WebServlet("/OrderController")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public OrderController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		listOrderItems(request, response);
	}


	public void listOrderItems(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userID = ((User)request.getSession().getAttribute("users")).getUser_id();
		System.out.println(userID);
		ArrayList<Order> orders =  Order.getOrdersForUser(userID);
		request.setAttribute("orderList", orders);
		
		RequestDispatcher dispatch = request.getRequestDispatcher("/order.jsp");
		dispatch.forward(request, response);
	}
}
