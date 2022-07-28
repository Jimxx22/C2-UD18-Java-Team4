import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainApp {
	
	static Connection connection;
	
	static final String USER_MYSQL = "remote";
	static final String PASS_MYSQL = "Bootcam_1"; 
	static final String URL_MYSQL = "jdbc:mysql://192.168.1.38:3306";

	//static final String URL_MYSQL = "jdbc:mysql://192.168.1.73:3306";
	//static final String USER_MYSQL = "remote";
	//static final String PASS_MYSQL = "PASSWORD";

	public static void main(String[] args) {

		connection(URL_MYSQL,USER_MYSQL,PASS_MYSQL);
		showDB();
		
	}
	
	private static void createBD (String name) {
		try {
			connection(URL_MYSQL,USER_MYSQL,PASS_MYSQL);
			String query = "CREATE DATABASE " + name + ";";
			Statement st = connection.createStatement();
			st.executeUpdate(query);
			closeConnection();
			System.out.println("La base de datos " + name + " se ha creado correctamente");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void createTable(String database, String table, String columns) {
		try {
			connection(URL_MYSQL,USER_MYSQL,PASS_MYSQL);
			String queryUseDb = "USE "+database+";";
			Statement statementDb = connection.createStatement();
			statementDb.executeUpdate(queryUseDb);
			
			String queryCreateTable = "CREATE TABLE "+table+" ("+columns+");";
			Statement statement = connection.createStatement();
			statement.executeUpdate(queryCreateTable);
			System.out.println("Table created succesfully");
			closeConnection();			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
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
	
	public static void getValues (String db, String nameTable) {
		try {
			connection(URL_MYSQL,USER_MYSQL,PASS_MYSQL);
			String queryDB = "USE " + db + ";";
			Statement stdb = connection.createStatement();
			stdb.executeUpdate(queryDB);
			
			String querySl = "SELECT * FROM " + nameTable + ";";
			Statement st = connection.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(querySl);
			
			closeConnection();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
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
	
	public void deleteRecord(String table, String id) {
		try {
			connection(URL_MYSQL,USER_MYSQL,PASS_MYSQL);
			String query = "DELETE FROM " + table + " WHERE ID = " + id + ";";
			Statement st = connection.createStatement();
			st.executeQuery(query);
			closeConnection();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} 
	}
		
	public static void insertData(String db, String insert) {
		
		try {
			connection(URL_MYSQL,USER_MYSQL,PASS_MYSQL);
			String usedb="USE "+db+";";
			Statement stdb=connection.createStatement();
			stdb.executeUpdate(usedb);
			
			Statement st = connection.createStatement();
			st.executeUpdate(insert);
			
			System.out.println("Datos almacenados correctamente");
			closeConnection();
			
		} catch (SQLException e) {
			System.out.println("Error al almacendar los datos");
			System.out.println(e);
		}
	}
	
	public static void showDB () {
		try {
			connection(URL_MYSQL,USER_MYSQL,PASS_MYSQL);
			String query = "SHOW DATABASES; " ;
			Statement st = connection.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(query);
			
			System.out.println("Databases:");
			while (resultSet.next()) {
				System.out.println(resultSet.getString("Database"));
			}
			
			closeConnection();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} 
	}
	
	
}
