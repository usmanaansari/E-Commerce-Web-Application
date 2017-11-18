package mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class Main {
    public static void main(String[] args){
        try{
    		Connection con = DBConnection.getConnection();
    		String query = "select * from user where user_id = 123";
    		Statement st = con.createStatement();
    		ResultSet rs = st.executeQuery(query);
    		
    		while(rs.next()){
    			int id = rs.getInt("user_id");
				String name = rs.getString("user_firstname");
				String email = rs.getString("user_email");
				System.out.println(id + " " + name + " " + email);
    		}
        }catch(Exception e){
        	e.printStackTrace();
        }
        
    }
}
