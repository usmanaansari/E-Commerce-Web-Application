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
		if(command == null) command = "list"; //use list as default command
		
		switch(command) { //check the command and route accordingly
		case "list": listItems(request, response);
			break;
		case "add": addItem(request, response);
			break;
		case "delete": deleteItem(request, response);
			break;
		case "update": updateItem(request, response);
			break;
		}
		
		
	}

	private void updateItem(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void deleteItem(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void addItem(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void listItems(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ArrayList<Item> items = Item.getAllItems();
		
		request.setAttribute("allItems", items);
		
		RequestDispatcher dispatch = request.getRequestDispatcher("/index.jsp");
		dispatch.forward(request, response);
	}



}
