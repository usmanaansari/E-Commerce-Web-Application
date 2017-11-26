package model;

import java.util.ArrayList;

public class Payment {

	private String payment_type;
	private double amount;
	private User seller;
	private User customer;
	private BillingInfo billingInfo;
	
	public Payment(String payment_type, double amount, int seller_id,
			int customer_id, int billing_id) {
		
		this.payment_type = payment_type;
		this.amount = amount;
	}
		
	
	public String getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
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
	
	
	public static ArrayList<Payment> getPayments(int userID){
		//TODO query db payment and return all payments this seller has received 
		ArrayList<Payment> payments = null;
		return payments;
	}
	
	
}
