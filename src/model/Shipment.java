package model;

public class Shipment {
	private float trackingNumber;
	private Order order;
	private String returnAddress;
	private String carrier;
	private int charge;
	private User customer;
	
	public Shipment(int orderID){ //we should make order id a primary key for shipment in the db
		//there shouldnt be multiple orders per shipment
		
	}
	
	public float getTrackingNumber() {
		return trackingNumber;
	}
	public void setTrackingNumber(float trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String getReturnAddress() {
		return returnAddress;
	}
	public void setReturnAddress(String returnAddress) {
		this.returnAddress = returnAddress;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public int getCharge() {
		return charge;
	}
	public void setCharge(int charge) {
		this.charge = charge;
	}
	public User getCustomer() {
		return customer;
	}
	public void setCustomer(User customer) {
		this.customer = customer;
	}
	
	
	
	
}
