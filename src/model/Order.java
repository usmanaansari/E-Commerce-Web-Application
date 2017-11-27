package model;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import mysql.DBConnection;

public class Order {

	private int order_ID;
	private User customer;
	private String order_status;
	private BigDecimal total;
	private Date order_date;
	public Order(int order_ID, User customer, String order_status,
			BigDecimal total, Date order_date) {
		
		this.order_ID = order_ID;
		this.customer = customer;
		this.order_date = order_date;
		this.order_status = order_status;
		this.total = total;
	}
	
	public Order(int orderID) {
		Connection con;
		try {
			con = DBConnection.getConnection();
			String query = "select * from orders where order_id = " + orderID + ";";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			if (rs.next()) {
				this.order_ID = rs.getInt("order_ID");
				this.customer = new User(rs.getInt("customerID")); 
				this.order_date = rs.getDate("order_date");
				this.order_status = rs.getString("order_status");
				this.total = rs.getBigDecimal("total");
				
			}
			DBConnection.close(con, rs, st);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
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

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	
	public void addOrderToDB(int customer_ID, int total, String order_date){
		String order_status = "processed";
		try {
			Connection con = DBConnection.getConnection();

			String query = "insert into orders(order_date, order_status, total, customer)" 
					+ "VALUES( " + order_date + ", ' " + order_status + "', "+total+", "+customer+");"; 
					 
			Statement st = con.createStatement();
			st.executeUpdate(query);

			DBConnection.close(con, null, st);

		} catch (Exception e) {
			System.out.println("Connection failed");
			e.printStackTrace();

		}
	}
	
	public void removeOrderFromDB(){
		//TODO
	}
	
	
	public static ArrayList<Order> getOrdersForUser(int userID){
		//TODO query db order_items and return all orders for this customer (will return empty list if user is not customer)
		ArrayList<Order> orders = null;
		return orders;
	}
	
}
