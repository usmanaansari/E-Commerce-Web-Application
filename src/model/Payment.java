package model;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import mysql.DBConnection;

public class Payment {
	
	private int paymentId;
	private String paymentType;
	private BigDecimal amount;
	private User seller;
	private User customer;
	private BillingInfo billingInfo;
	
	public Payment(int paymentId) {
		try {
			Connection con = DBConnection.getConnection();
			String query = "select * from payment where payment_id = " + paymentId + ";";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				this.paymentId = paymentId;
				paymentType = rs.getString("payment_type");
				customer = new User(rs.getInt("customer_id")); 
				amount = rs.getBigDecimal("amount");
				seller = new User(rs.getInt("seller_id"));
				customer = new User(rs.getInt("customer_id"));
				System.out.println(rs.getInt("Billing_ID"));
				billingInfo = new BillingInfo(rs.getInt("Billing_ID"));		
			}
			DBConnection.close(con, rs, st);		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	public Payment() {
	
	}


	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public User getSeller() {
		return seller;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}
	public BillingInfo getBillingInfo() {
		return billingInfo;
	}

	public void setBillingInfo(BillingInfo billingInfo) {
		this.billingInfo = billingInfo;
	}
	
	
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", paymentType=" + paymentType + ", amount=" + amount + ", seller="
				+ seller + ", customer=" + customer + ", billingInfo=" + billingInfo + "]";
	}


	public void addPaymentToDB() {
		try {
			Connection con = DBConnection.getConnection();

			String query = "insert into payment(payment_type, amount, seller_id, customer_id, billing_id)" 
					+ "VALUES( '" + paymentType + "', " + amount + ", "+seller.getUser_id() + 
					", "+ customer.getUser_id() +", " + billingInfo.getBilling_ID() + ");"; 
					 
			Statement st = con.createStatement();
			st.executeUpdate(query);

			DBConnection.close(con, null, st);

		} catch (Exception e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}
	}
	
	
	public static ArrayList<Payment> getPayments(int userID){
		 
		ArrayList<Payment> payments = null;
		return payments;
	}
	
	
}
