package BDDprojetMEEF.DAOclasses;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class DAO<T> {
	
	public Connection conn = null;
	
	public DAO() {
		this.conn = connect();
	}
	

	public static Connection connect() {
		Connection connected = null;
		try {
			Class.forName("org.sqlite.JDBC");
			connected = DriverManager.getConnection("jdbc:sqlite:BDprojet.db");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		System.out.println("Connecter");
		return connected;
	}
	
	
}
