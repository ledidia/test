package manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class SqLiteConect {
	
private static Connection con;
private static boolean hasData = false;

private  void getConnection() throws ClassNotFoundException, SQLException {
	if (con == null) {
		Class.forName("org.sqlite.JDBC");
		con = DriverManager.getConnection("jdbc:sqlite:SQLiteTest1.db");
		initialise();
	}
}

private void initialise() throws SQLException {	
		Statement state =con.createStatement();
		state.execute("CREATE TABLE date1 ( A varchar(255) , B varchar(255), C varchar(255), D varchar(255), E varchar(255), F varchar(255), G varchar(255), H varchar(255), I varchar(255), J varchar(255));");

}
public void insert(String[] s) throws ClassNotFoundException, SQLException {
	if (!hasData) {
		hasData =true;
		getConnection();
	}
	PreparedStatement statment = con.prepareStatement("insert into date1 values(?,?,?,?,?,?,?,?,?,?)");
	statment.setString(1, s[0]);
	statment.setString(2, s[1]);
	statment.setString(3, s[2]);
	statment.setString(4, s[3]);
	statment.setString(5, s[4]);
	statment.setString(6, s[5]);
	statment.setString(7, s[6]);
	statment.setString(8, s[7]);
	statment.setString(9, s[8]);
	statment.setString(10, s[9]);
	statment.executeUpdate();
	
	
}
}
