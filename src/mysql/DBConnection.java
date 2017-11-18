package mysql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DBConnection {

    public static Connection getConnection() throws Exception {
    	Connection connect = null;
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            //you have to replace the arguments to match your schema name, db username and password
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/305project?"
                            + "user=root&password=");
        }
        catch(SQLException e){ 
            e.printStackTrace();
        }
        return connect;		
    }
}