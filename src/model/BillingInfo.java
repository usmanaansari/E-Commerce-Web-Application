package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import mysql.DBConnection;

public class BillingInfo {
	
	private int billing_ID;
	private int user_ID;
	private String card_Number;
	private String expirationDate;
	private int security_Code;
	private String billing_Address;
	
	
	public BillingInfo(int billing_ID) {
		//Need to Query using Billing Id
		//
		this.billing_ID = billing_ID;
		
		Connection con;
		try {
			con = DBConnection.getConnection();
			String query = "select * from item where billing_id = " + billing_ID + ";";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			//we need to remove customer_id from db and add user_id
			rs.getInt("billing_id");
			rs.getInt("user_id");
			rs.getInt("card_number");
			rs.getDate("expiration_date");
			rs.getInt("security_code");
			rs.getString("billing_address");
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public BillingInfo(int billing_ID, int user_ID, 
			String card_Number, String expirationDate,
			int security_Code, String billing_Address) {
		
		this.billing_ID = billing_ID;
		this.user_ID = user_ID;
		this.card_Number = card_Number;
		this.expirationDate = expirationDate;
		this.security_Code = security_Code;
		this.billing_Address = billing_Address;
		
	}

	public int getBilling_ID() {
		return billing_ID;
	}

	public void setBilling_ID(int billing_ID) {
		this.billing_ID = billing_ID;
	}

	public int getUser_ID() {
		return user_ID;
	}

	public void setUser_ID(int user_ID) {
		this.user_ID = user_ID;
	}

	public String getCard_Number() {
		return card_Number;
	}

	public void setCard_Number(String card_Number) {
		this.card_Number = card_Number;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public int getSecurity_Code() {
		return security_Code;
	}

	public void setSecurity_Code(int security_Code) {
		this.security_Code = security_Code;
	}

	public String getBilling_Address() {
		return billing_Address;
	}

	public void setBilling_Address(String billing_Address) {
		this.billing_Address = billing_Address;
	}
	
	
}
