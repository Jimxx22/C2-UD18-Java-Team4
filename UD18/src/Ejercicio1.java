import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Ejercicio1 extends Metodos{
	
	public static void main(String[] args) {
		connection(URL_MYSQL, USER_MYSQL, PASS_MYSQL);
		String database = "ud1801";
		createBD(database);
		createTable(database, "fabricantes", "codigo int not null, nombre varchar(255), primary key(codigo)");
		createTable(database, "articulos", "codigo int not null, "
				+ "nombre varchar(255), "
				+ "precio decimal(10,0) not null, "
				+ "fabricante int not null, "
				+ "primary key(codigo), "
				+ "foreign key (fabricante) references fabricantes (codigo)");
		
		insertData(database, "INSERT INTO `fabricantes` VALUES (1,'Sony'),(2,'Creative Labs'),(3,'Hewlett-Packard'),(4,'Iomega'),(5,'Fujitsu'),(6,'Winchester');");
		insertData(database, "INSERT INTO `articulos` VALUES (1,'Hard drive',240,5),(2,'Memory',120,6),(3,'ZIP drive',150,4),(4,'Floppy disk',5,6),(5,'Monitor',240,1),(6,'DVD drive',180,2),(7,'CD drive',90,2),(8,'Printer',270,3),(9,'Toner cartridge',66,3),(10,'DVD burner',180,2);");
		
		getValues(database, "fabricantes");
		getValues(database, "articulos");
		
		deleteRecord(database, "articulos", "1");
		
	}
	
}

