import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainApp {
	
	static Connection connection;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void connection(String url, String user, String pass) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, pass);
			System.out.println("Server Connected");
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("No se ha podido connectar");
			System.out.println(e);
		}		
	}
	
	public static void closeConnection() {
		try {
			connection.close();
			System.out.println("Connection closed");
		} catch (SQLException e) {
			System.out.println("Error al desconectar");
		}
	}
}
