package model;

public class Order {

	private int order_ID;
	private User customer;
	private String order_status;
	private int total;
	private String order_date;
	
	public int getOrder_ID() {
		return order_ID;
	}

	public void setOrder_ID(int order_ID) {
		this.order_ID = order_ID;
	}


	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public Order(int order_ID) {
		this.order_ID = order_ID;	
	}
	
	public Order(int order_ID, int customer_ID, String order_status,
			int total, String order_date) {
		
		this.order_ID = order_ID;
		this.order_date = order_date;
		this.order_status = order_status;
		this.total = total;
	}
	
}
