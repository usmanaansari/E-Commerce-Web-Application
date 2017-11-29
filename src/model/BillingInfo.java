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
				user = new User(rs.getInt("customer_id"));
				card_Number = rs.getString("card_number");
				expirationDate = rs.getDate("expiration_date");
				security_Code = rs.getInt("security_code");
				billing_Address = rs.getString("billing_address");
			}
			DBConnection.close(con, rs, st);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

	@Override
	public String toString() {
		return "BillingInfo [billing_ID=" + billing_ID + ", card_Number=" + card_Number + ", expirationDate="
				+ expirationDate + ", security_Code=" + security_Code + ", billing_Address=" + billing_Address + "]";
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
	
	public void addBillingInfoToDB(int user_ID, 
			String card_Number, String expirationDate,
			int security_Code, String billing_Address){
		//TODO
	}
	
	public void deleteBillingInfoFromDB(){
		//TODO
	}
	
	public static ArrayList<BillingInfo> getBillingInfo(int userId){
		//TODO query db billing_info and return all billing info for this user
		ArrayList<BillingInfo> billingInfo = null;
		return billingInfo;
	}
	
}
