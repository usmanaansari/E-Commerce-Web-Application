package model;

public class Payment {

	private String payment_type;
	private Double amount;
	private int seller_id;
	private int customer_id;
	private int billing_id;
	
	public Payment(String payment_type, Double amount, int seller_id,
			int customer_id, int billing_id) {
		
		this.payment_type = payment_type;
		this.amount = amount;
		this.seller_id = seller_id;
		this.customer_id = customer_id;
		this.billing_id = billing_id;
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
	public int getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public int getBilling_id() {
		return billing_id;
	}
	public void setBilling_id(int billing_id) {
		this.billing_id = billing_id;
	}
}
