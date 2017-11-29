package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import mysql.DBConnection;

public class BillingInfo {
	
	private int billing_ID;
	private User user;
	private String card_Number;
	private Date expirationDate;
	private int security_Code;
	private String billing_Address;
	
	public BillingInfo() {
		
	}
	public BillingInfo(int billing_ID) {
		//Need to Query using Billing Id
		//
		this.billing_ID = billing_ID;
		
		Connection con;
		try {
			con = DBConnection.getConnection();
			String query = "select * from billing_info where billing_id = " + billing_ID + ";";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			//we need to remove customer_id from db and add user_id
			while(rs.next()) {
				user = new User(rs.getInt("user_id"));
				card_Number = rs.getString("card_number");
				expirationDate = rs.getDate("expiration_date");
				security_Code = rs.getInt("security_code");
				billing_Address = rs.getString("billing_address");
			}
			DBConnection.close(con, rs, st);

		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	

	@Override
	public String toString() {
		return "BillingInfo [billing_ID=" + billing_ID + ", card_Number=" + card_Number + ", expirationDate="
				+ expirationDate + ", security_Code=" + security_Code + ", billing_Address=" + billing_Address + "]";
	}

	

	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getBilling_ID() {
		return billing_ID;
	}

	public void setBilling_ID(int billing_ID) {
		this.billing_ID = billing_ID;
	}


	public String getCard_Number() {
		return card_Number;
	}

	public void setCard_Number(String card_Number) {
		this.card_Number = card_Number;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
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
	
	public void addBillingInfoToDB(){
		try {
			Connection con = DBConnection.getConnection();

			String query = "insert into billing_info(user_id, card_number, expiration_date, security_code, billing_address)" 
					+ "VALUES( " + user.getUser_id() + ", '" + card_Number + "', '" + expirationDate + "', " + security_Code + ", '" 
					+ billing_Address + "');"; 
					 
			Statement st = con.createStatement();
			st.executeUpdate(query);

			DBConnection.close(con, null, st);

		} catch (Exception e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}
	}
	
	public void deleteBillingInfoFromDB(){
		try {
			Connection con = DBConnection.getConnection();
			String query = "delete from billing_info where billing_id = " + billing_ID + ";";
			Statement st = con.createStatement();
			st.executeUpdate(query);

			DBConnection.close(con, null, st);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<BillingInfo> getBillingInfo(int userId){
		//TODO query db billing_info and return all billing info for this user
		ArrayList<BillingInfo> billingInfo = null;
		return billingInfo;
	}
	
}
