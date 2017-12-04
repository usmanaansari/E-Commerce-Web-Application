package controller;

import java.io.IOException;
import java.util.*;
import model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;

/**
 * Servlet implementation class ItemController
 */
@WebServlet("/ItemController")
public class ItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		if(command == null) command = "listItems"; //use list as default command
		
		switch(command) { //check the command and route accordingly
		case "listItems": listItems(request, response);
			break;
		case "addItemBySeller": addItemBySeller(request, response);
			break;
		case "deleteItemBySeller": deleteItemBySeller(request, response);
			break;
		case "updateItemBySeller": updateItemBySeller(request, response);
			break;
		case "getItem": getItem(request, response);

		}
		
		
	}

	private void getItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Item item = new Item(Integer.parseInt(request.getParameter("itemId")));
		request.setAttribute("item", item);
		RequestDispatcher dispatch = request.getRequestDispatcher("/item.jsp");
		dispatch.forward(request, response);
		
	}

	//updates the item using attributes passed in request, performed by seller
	private void updateItemBySeller(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
	//deletes the item passed in request, performed by seller
	private void deleteItemBySeller(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
	
	//adds the item using attributes passed in request, performed by seller
	private void addItemBySeller(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void listItems(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ArrayList<Item> items = Item.getAllItems();
		
		request.setAttribute("allItems", items);
		
		RequestDispatcher dispatch = request.getRequestDispatcher("/index.jsp");
		dispatch.forward(request, response);
	}



}