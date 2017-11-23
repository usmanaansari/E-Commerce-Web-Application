package model;

public class User {
 
	private String userEmail;
	private String user_Password;
	private int user_id;
	private String accountType;
	private String first_name;
	private String last_name;
	private String middle_name = "";
	private String userAddress;
	
	
	public User(String userEmail, String user_password){
		this.userEmail = userEmail;
		this.user_Password = user_password; 
	}
	public User(String email, String password, int id, String account,
			String firstName, String lastName, String middleName, 
			String userAddress){
		
		userEmail = email;
		user_Password = password;
		user_id = id;
		accountType = account;
		first_name = firstName;
		last_name = lastName;
		middle_name = middleName;
		this.userAddress = userAddress;
	}
	
	
	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getMiddle_name() {
		return middle_name;
	}


	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}


	public String getUserAddress() {
		return userAddress;
	}


	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}


	public String getAccountType() {
		return accountType;
	}
	
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
 
	public String getUsername() {
		return userEmail;
	}
 
 
	public String getPassword() {
		return user_Password;
	}
 
	public void setPassword(String password) {
		this.user_Password = password;
	}
 
}