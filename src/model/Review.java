package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import mysql.DBConnection;

public class Review {
	
	private int reviewID;
	private Item item;
	private User customer;
	private String description;
	private int rating;
	
	public Review(int reviewID) {
		//
		this.reviewID = reviewID;
		
		Connection con;
		try {
			con = DBConnection.getConnection();
			String query = "select * from review where review_ID = " + reviewID + ";";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			//we need to remove seller_ID from the DB
			this.reviewID = rs.getInt("Review_ID");
			int customerID = rs.getInt("Customer_ID");
			this.customer = new User(customerID);
			int itemID = rs.getInt("Item_ID");	
			this.item = new Item(itemID);
			this.description = rs.getString("Description");
			this.rating = rs.getInt("Rating");
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
	public Review(){
		
	}
	
	public Review(int reviewID,  int customerID) {
		this.reviewID = reviewID;
		

	}
	
	public int getReviewID() {
		return reviewID;
	}

	public void setReviewID(int reviewID) {
		this.reviewID = reviewID;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}


	


}

