
public class MainAppEx8 {

	public static void main(String[] args) {
		
		String db= "ud1808";
		
		// Cajeros Table
		String cajeros= "Cajeros";
		String camposCajeros="codigo int auto_increment not null,nomApels varchar(255),Primary key(codigo)";
		String insertCajeros="Insert into Cajeros (nomApels) values ('Jonatan Falcon'),('Maria-Fernanda Ripoll'),('Rufina Laguna'),('Bienvenida Bueno'),('Covadonga Trujillo'),('Maria-Esperanza Arana'),('Ismael Mercado'),('Triana Baez'),('Maria-Josefa Segovia'),('Hipolito Polo');";
		
		// Maquinas_Registradoras Table
		String maquinasRegistradoras= "Maquinas_Registradoras";
		String camposMaquinasRegistradoras="codigo int auto_increment not null,piso int,Primary key(codigo)";
		String insertMaquinasRegistradoras="Insert into Maquinas_Registradoras (piso) values (1),(1),(1),(2),(2),(2),(3),(3),(3),(3);";
		
		// Productos Table
		String productos= "Productos";
		String camposProductos="codigo int auto_increment not null,nombre varchar(100),precio int,Primary key(codigo)";
		String insertProductos="Insert into Productos (nombre,precio) values ('Arroz',1),('Tomate',2),('Patatas fritas',1),('Patatas congeladas',2),('Nocilla',3),('Chocolate Milka',2),('Cereales',3),('Zanahorias',1),('Detergente',5),('Leche',1);";
		
		// Ventas Table
		String ventas= "Ventas";
		String camposVentas="cajero int not null,maquina int not null,producto int not null,primary key (cajero, maquina, producto),constraint fk_cajero FOREIGN KEY (cajero) REFERENCES Cajeros (codigo) ON DELETE CASCADE ON UPDATE CASCADE,constraint fk_maquina FOREIGN KEY (maquina) REFERENCES Maquinas_Registradoras (codigo) ON DELETE CASCADE ON UPDATE CASCADE,constraint fk_producto FOREIGN KEY (producto) REFERENCES Productos (codigo) ON DELETE CASCADE ON UPDATE CASCADE";
		String insertVentas="Insert into Ventas values (1,1,1),(1,1,2),(2,1,2),(2,1,3),(3,3,4),(4,3,5),(5,6,9),(5,6,7),(7,7,6),(7,7,5);";

		Metodos.createBD(db);
		
		Metodos.createTable(db, cajeros, camposCajeros);
		Metodos.createTable(db, maquinasRegistradoras, camposMaquinasRegistradoras);
		Metodos.createTable(db, productos, camposProductos);
		Metodos.createTable(db, ventas, camposVentas);
		
		Metodos.insertData(db, insertCajeros);
		Metodos.insertData(db, insertMaquinasRegistradoras);
		Metodos.insertData(db, insertProductos);
		Metodos.insertData(db, insertVentas);

	}

}
