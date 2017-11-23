package model;

public class BillingInfo {
	
	private int billing_ID;
	private int customer_ID;
	private String card_Number;
	private String expirationDate;
	private int security_Code;
	private String billing_Address;
	
	
	public BillingInfo(int billing_ID) {
		//Need to Query using Billing Id
		this.billing_ID = billing_ID;
	}
	
	public BillingInfo(int billing_ID, int customer_ID, 
			String card_Number, String expirationDate,
			int security_Code, String billing_Address) {
		
		this.billing_ID = billing_ID;
		this.customer_ID = customer_ID;
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

	public int getCustomer_ID() {
		return customer_ID;
	}

	public void setCustomer_ID(int customer_ID) {
		this.customer_ID = customer_ID;
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
