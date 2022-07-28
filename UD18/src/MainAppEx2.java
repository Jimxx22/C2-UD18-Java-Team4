
public class MainAppEx2 extends Metodos{
	
	public static void main(String[] args) {
		connection(Credentials.URL_MYSQL, Credentials.USER_MYSQL, Credentials.PASS_MYSQL);
		String database = "ud1802";
		createBD(database);
		createTable(database, "departamentos", 
				"codigo int not null, "
				+ "nombre varchar(255), "
				+ "presupuesto decimal(10,0) not null, "
				+ "primary key(codigo) ");
		createTable(database, "empleados", 
				"dni int not null, "
				+ "nombre varchar(255),"
				+ "apellidos varchar(255),"
				+ "departamento int not null, "
				+ "primary key(dni),"
				+ "foreign key (departamento) references departamentos (codigo)");
		
		insertData(database, "INSERT INTO `departamentos` VALUES (14,'IT',65000),(37,'Accounting',15000),(59,'Human Resources',240000),(77,'Research',55000);");
		insertData(database, "INSERT INTO `empleados` VALUES (123234877,'Michael','Rogers',14),(152934485,'Anand','Manikutty',14),"
				+ "(222364883,'Carol','Smith',37),(326587417,'Joe','Stevens',37),(332154719,'Mary-Anne','Foster',14),(332569843,'George','O\\'Donnell',77),"
				+ "(546523478,'John','Doe',59),(631231482,'David','Smith',77),(654873219,'Zacary','Efron',59),(745685214,'Eric','Goldsmith',59),"
				+ "(845657233,'Luis','López',14),(845657245,'Elizabeth','Doe',14),(845657246,'Kumar','Swamy',14),(845657266,'Jose','Pérez',77);");
		
		getValues(database, "departamentos");
		getValues(database, "empleados");
		
		deleteRecord(database, "empleados", "222364883");
		
	}
}
