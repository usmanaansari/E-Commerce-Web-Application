package model;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import mysql.DBConnection;

public class Item {
	int itemId;
	String itemName;
	int quantity;
	String department;
	BigDecimal price;
	String description;
	User seller;
	

	public Item(int itemId){
		this.itemId = itemId;
		
		Connection con;
		try {
			con = DBConnection.getConnection();
			String query = "select * from item where item_id = " + itemId + ";";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			rs.getInt("item_id");
			rs.getString("item_name");
			rs.getInt("quantity");
			rs.getString("department");
			rs.getBigDecimal("price");
			rs.getString("description");
			rs.getInt("seller_id");
			
			//seller = new User();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public static void addItemToDB(String itemName, int quantity, String departnemt, BigDecimal price, 
			String description, int sellerId){
		//TO DO
	}
	
	public static void deleteItemFromDB(int itemId){
		//TO DO
	}
	
	//decrements quantity of item in db when bought 
	public static void decrementQuantity(int itemId){
		//TO DO
	}
}
