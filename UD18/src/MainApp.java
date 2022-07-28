import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.cj.MysqlConnection;

public class MainApp {
	
	static Connection connection;
	static final String URL_MYSQL = "jdbc:mysql://IP:PUERTO";
	static final String USER_MYSQL = "USER";
	static final String PASS_MYSQL = "PASSWORD";

	public static void main(String[] args) {

		connection(URL_MYSQL,USER_MYSQL,PASS_MYSQL);
		showDB();
		
		String database = "ud1801";
		createDB(database);
		createTable(database, "fabricantes", "codigo int not null, nombre varchar(255) not null, primary key(codigo)" );
		createTable(database, "articulos", "codigo int not null, nombre varchar(255) not null, primary key(codigo)" );		
		
	}
	
	private static void createDB (String name) {
		try {
			connection(URL_MYSQL,USER_MYSQL,PASS_MYSQL);
			String queryDrop  = "DROP DATABASE IF EXISTS " + name + ";";
			Statement stDrop = connection.createStatement();
			stDrop.executeUpdate(queryDrop);
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
			ResultSetMetaData rsmd = resultSet.getMetaData();
			int columnNum = rsmd.getColumnCount();
			
			while(resultSet.next()) {
				for(int i = 1; i <= columnNum; i++) {
					switch(rsmd.getColumnTypeName(i)) {
					case "VARCHAR":
						System.out.println(rsmd.getColumnName(i)+": "+resultSet.getString(i));
						break;
					case "INT":
						System.out.println(rsmd.getColumnName(i)+": "+resultSet.getInt(i));
						break;
					case "DATE":
						System.out.println(rsmd.getColumnName(i)+": "+resultSet.getDate(i));
						break;
					case "DOUBLE":
						System.out.println(rsmd.getColumnName(i)+": "+resultSet.getDouble(i));
						break;
					}
					
				}
				System.out.println();
			}
			
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
