package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import mysql.DBConnection;

public class Review {
	
	private int reviewID;
	private int sellerID;
	private int customerID;
	private int billingID;
	private int amount;
	private String paymentType;
	
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
			rs.getInt("Review_ID");
			rs.getInt("Customer_ID");
			rs.getInt("Item_ID");		
			rs.getString("Description");
			rs.getInt("Rating");
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
	public Review(int reviewID, int sellerID, int customerID, int billingID, int amount, String paymentType) {
		this.reviewID = reviewID;
		this.sellerID = sellerID;
		this.customerID = customerID;
		this.billingID = billingID;
		this.amount = amount;
		this.paymentType = paymentType;
	}
	
	public int getReviewID() {
		return reviewID;
	}

	public void setReviewID(int reviewID) {
		this.reviewID = reviewID;
	}

	public int getSellerID() {
		return sellerID;
	}
	
	public void setSellerID(int sellerID) {
		this.sellerID = sellerID;
	}

	public int getCustomerID() {
		return customerID;
	}
	
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
	public int getBillingID() {
		return billingID;
	}
	
	public void setBillingID(int billingID) {
		this.billingID = billingID;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	


	public String getPaymentType() {
		return paymentType; 
	}
	
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
}

