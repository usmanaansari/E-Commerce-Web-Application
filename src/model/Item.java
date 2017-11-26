package model;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import mysql.DBConnection;

public class Item {
	private int itemId;
	private String itemName;
	private int quantity;
	private String department;
	private BigDecimal price;
	private String description;
	private User seller;

	public Item(int itemId) {
		this.itemId = itemId;

		Connection con;
		try {
			con = DBConnection.getConnection();
			String query = "select * from item where item_id = " + itemId + ";";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			if (rs.next()) {
				this.itemName = rs.getString("item_name");
				this.quantity = rs.getInt("quantity");
				this.department = rs.getString("department");
				this.price = rs.getBigDecimal("price");
				this.description = rs.getString("description");
			}

			DBConnection.close(con, rs, st);
			// seller = new User(rs.getInt("seller_id"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Item(String itemName, int quantity, String department, BigDecimal price, String description, int sellerID) {
		super();
		this.itemName = itemName;
		this.quantity = quantity;
		this.department = department;
		this.price = price;
		this.description = description;
		this.seller = new User(sellerID);
	}

	public Item() {
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getSeller() {
		return seller;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", department=" + department + ", price=" + price
				+ ", seller=" + seller + "]";
	}

	public void addItemToDB() {
		try {
			Connection con = DBConnection.getConnection();

			String query = "insert into item(item_name, quantity, department, price, " + "description, seller_id)"
					+ "VALUES( '" + itemName + "', " + quantity + ", '" + department + "'," + price + ", '"
					+ description + "', " + seller.getUser_id() + " );";
			Statement st = con.createStatement();
			st.executeUpdate(query);

			DBConnection.close(con, null, st);

		} catch (Exception e) {
			System.out.println("Connection failed");
			e.printStackTrace();

		}
	}

	// deletes this item from db
	public void deleteItemFromDB() {
		try {
			Connection con = DBConnection.getConnection();
			String query = "delete from item where item_id = " + itemId + ";";
			Statement st = con.createStatement();
			st.executeUpdate(query);

			DBConnection.close(con, null, st);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// decrements quantity of item in db when bought
	public void decrementQuantity() {
		try {
			Connection con = DBConnection.getConnection();
			String query = "update item set quantity = quantity -1 where quantity > 0 and item_id = " + itemId + ";";
			Statement st = con.createStatement();
			st.executeUpdate(query);

			DBConnection.close(con, null, st);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Item> getAllItems(){
		ArrayList<Item> items = new ArrayList<Item>();
		
		try {
			Connection con = DBConnection.getConnection();
			String query = "select * from item;";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				Item i = new Item();
				i.itemId = rs.getInt("item_id");
				i.itemName = rs.getString("item_name");
				i.department = rs.getString("department");
				i.description = rs.getString("description");
				i.price = rs.getBigDecimal("price");
				i.quantity = rs.getInt("quantity");
				i.seller = new User(rs.getInt("seller_id"));
				
				items.add(i);
			}
			DBConnection.close(con, rs, st);
		}catch(Exception e){
			e.printStackTrace();
		}
		return items;
	}
	
	public static ArrayList<Item> searchItems(String search){
		ArrayList<Item> items = new ArrayList<Item>();
		
		try {
			Connection con = DBConnection.getConnection();
			String query = "select * from item where item_name like '%" + search + "%';";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				Item i = new Item();
				i.itemId = rs.getInt("item_id");
				i.itemName = rs.getString("item_name");
				i.department = rs.getString("department");
				i.description = rs.getString("description");
				i.price = rs.getBigDecimal("price");
				i.quantity = rs.getInt("quantity");
				i.seller = new User(rs.getInt("seller_id"));
				
				items.add(i);
			}
			DBConnection.close(con, rs, st);
		}catch(Exception e){
			e.printStackTrace();
		}
		return items;
	}
	
	public static ArrayList<Item> searchItemsByDept(String department){
		ArrayList<Item> items = new ArrayList<Item>();
		
		try {
			Connection con = DBConnection.getConnection();
			String query = "select * from item where department = '" + department + "';";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				Item i = new Item();
				i.itemId = rs.getInt("item_id");
				i.itemName = rs.getString("item_name");
				i.department = rs.getString("department");
				i.description = rs.getString("description");
				i.price = rs.getBigDecimal("price");
				i.quantity = rs.getInt("quantity");
				i.seller = new User(rs.getInt("seller_id"));
				
				items.add(i);
			}
			DBConnection.close(con, rs, st);
		}catch(Exception e){
			e.printStackTrace();
		}
		return items;
	}
	

	public static ArrayList<Review> getReviews(int itemId) {
		ArrayList<Review> reviews = new ArrayList<Review>();

		try {
			Connection con = DBConnection.getConnection();
			String query = "select * from review where item_id =" + itemId + ";";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				Review rev = new Review();
				rev.setReviewID(rs.getInt("review_id"));
				rev.setItem(new Item(rs.getInt("item_id")));
				rev.setCustomer(new User(rs.getInt("customer_id")));
				rev.setDescription(rs.getString("description"));
				rev.setRating(rs.getInt("rating"));

				reviews.add(rev);
			}

			DBConnection.close(con, rs, st);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reviews;
	}
	
	

}
