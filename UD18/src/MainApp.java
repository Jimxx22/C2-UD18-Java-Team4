import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MainApp {
	
	static Connection connection;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static void createTable(String database, String table, String columns) {
		try {
			String queryUseDb = "USE "+database+";";
			Statement statementDb = connection.createStatement();
			statementDb.executeUpdate(queryUseDb);
			
			String queryCreateTable = "CREATE TABLE "+table+" ("+columns+");";
			Statement statement = connection.createStatement();
			statement.executeUpdate(queryCreateTable);
			System.out.println("Table created succesfully");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

}
