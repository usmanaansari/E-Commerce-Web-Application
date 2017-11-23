package model;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import mysql.DBConnection;

public class Item {
	private int itemId;
	private String itemName;
	private int quantity;
	private String department;
	private BigDecimal price;
	private String description;
	private User seller;
	

	public Item(int itemId){
		this.itemId = itemId;
		
		Connection con;
		try {
			con = DBConnection.getConnection();
			String query = "select * from item where item_id = " + itemId + ";";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			this.itemName = rs.getString("item_name");
			this.quantity = rs.getInt("quantity");
			this.department = rs.getString("department");
			this.price = rs.getBigDecimal("price");
			this.description = rs.getString("description");
			
			DBConnection.close(rs, st);
			//seller = new User(rs.getInt("seller_id"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public int getItemId() {
		return itemId;
	}


	public void setItemId(int itemId) {
		this.itemId = itemId;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public BigDecimal getPrice() {
		return price;
	}


	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public User getSeller() {
		return seller;
	}


	public void setSeller(User seller) {
		this.seller = seller;
	}


	public static void addItemToDB(String itemName, int quantity, String departnemt, BigDecimal price, 
			String description, int sellerId){
		//TODO
	}
	
	//deletes this item from db 
	public void deleteItemFromDB(){
		//TODO
	}
	
	//decrements quantity of item in db when bought 
	public void decrementQuantity(){
		//TODO
	}
	
	public ArrayList<Review> getReviews(){
		//TODO 
		ArrayList<Review> reviews = null;
		return reviews;
	}
}
