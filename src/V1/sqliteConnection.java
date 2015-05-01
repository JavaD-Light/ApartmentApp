package V1;


//this is a helper class to help maintain the connection to the database

import java.sql.*; //by adding the [*] to the import, it means to add all the other classes after java.sql.[x]
import javax.swing.*;

public class sqliteConnection {
	
	Connection conn=null; //this is part of the java.sql connection class
	
	//this method will return the connection
	public static Connection dbConnector(){
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\User\\Desktop\\FMIS 4225 Advanced System Apps\\Apartment App\\ApartmentData.sqlite");
			//^^the reason we use "\\" above is to differentiate that it is part of the path and not similar to "\n" as in a line break ^^
			
			//this part is just to show the connection was successful. testing method.
			//JOptionPane.showMessageDialog(null, "Connection was successful");
			
			return conn;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	
}

