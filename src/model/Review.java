package model;

public class Review {
	
	private int sellerID;
	private int customerID;
	private int billingID;
	private int amount;
	private String paymentType;
	
	public Review(int sellerID, int customerID, int billingID, int amount, String paymentType) {
		this.sellerID = sellerID;
		this.customerID = customerID;
		this.billingID = billingID;
		this.amount = amount;
		this.paymentType = paymentType;
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
	
	public void setPaymentType() {
		this.paymentType = paymentType;
	}
}

