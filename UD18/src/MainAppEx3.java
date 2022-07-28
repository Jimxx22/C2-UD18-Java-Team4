
public class MainAppEx3 extends Metodos{

	public static void main(String[] args) {
		connection(Credentials.URL_MYSQL, Credentials.USER_MYSQL, Credentials.PASS_MYSQL);
		String database = "ud1803";
		createBD(database);
		createTable(database, "almacenes", 
				"codigo int not null, "
				+ "lugar varchar(255) not null, "
				+ "capacidad int not null, "
				+ "primary key(codigo) ");
		createTable(database, "cajas", 
				"numReferencia varchar(255) not null, "
				+ "contenido varchar(255),"
				+ "valor double not null,"
				+ "almacen int not null, "
				+ "primary key(numReferencia),"
				+ "foreign key (almacen) references almacenes (codigo)");
		
		insertData(database, "INSERT INTO `almacenes` VALUES (1,'Valencia',3),(2,'Barcelona',4),(3,'Bilbao',7),(4,'Los Angeles',2),(5,'San Francisco',8);");
		insertData(database, "INSERT INTO `cajas` VALUES ('0MN7','Rocks',180,3),('4H8P','Rocks',250,1),('4RT3','Scissors',190,4),('7G3H','Rocks',200,1),"
				+ "('8JN6','Papers',75,1),('8Y6U','Papers',50,3),('9J6F','Papers',175,2),('LL08','Rocks',140,4),('P0H6','Scissors',125,1),"
				+ "('P2T6','Scissors',150,2),('TU55','Papers',90,5);");
		
		getValues(database, "almacenes");
		getValues(database, "cajas");
		
		deleteRecord(database, "cajas", "4H8P");
		
	}
}
