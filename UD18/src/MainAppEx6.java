
public class MainAppEx6 {

	public static void main(String[] args) {
		String db= "ud1806";
		
		Metodos.createBD(db);
		Metodos.createTable(db, "Piezas", "codigo int auto_increment not null,\r\n"
				+ "nombre varchar(100),\r\n"
				+ "Primary key (codigo)");

		Metodos.createTable(db, "Proveedores", "id char(4),\r\n"
				+ "nombre varchar(100),\r\n"
				+ "PRIMARY KEY (id)");

		Metodos.createTable(db, "Suministra", "codigoPieza int,\r\n"
				+ "idProveedor char(4),\r\n"
				+ "precio int,\r\n"
				+ "primary key (codigoPieza, idProveedor),\r\n"
				+ "constraint fk_codigoPieza FOREIGN KEY (codigoPieza  ) \r\n"
				+ "REFERENCES Piezas (codigo)\r\n"
				+ "ON DELETE CASCADE ON UPDATE CASCADE,\r\n"
				+ "constraint fk_codigoProveedores FOREIGN KEY (idProveedor) \r\n"
				+ "REFERENCES Proveedores (id)\r\n"
				+ "ON DELETE CASCADE ON UPDATE CASCADE");
		
		Metodos.insertData(db, "Insert into Proveedores values\r\n"
				+ "('ACH2','Samsung'),\r\n"
				+ "('JWD6','Qualcom'),\r\n"
				+ "('LGCD','LG'),\r\n"
				+ "('AS2D','Apple'),\r\n"
				+ "('PO98','Oppo'),\r\n"
				+ "('DWAS','Sony'),\r\n"
				+ "('MXW1','Leica'),\r\n"
				+ "('73J1','Huawei'),\r\n"
				+ "('HS21','Xiaomi'),\r\n"
				+ "('MNIW','AKG');");
		
		Metodos.insertData(db, "Insert into Piezas (nombre) values \r\n"
				+ "('Snapdragon 888+'),\r\n"
				+ "('Snapdragon 888'),\r\n"
				+ "('Pantalla iphone 12'),\r\n"
				+ "('Camaras iphone 12'),\r\n"
				+ "('Camara Leica'),\r\n"
				+ "('Pantalla Huawei'),\r\n"
				+ "('Altavoz Samsung'),\r\n"
				+ "('Bateria LG'),\r\n"
				+ "('Auriculares AKG'),\r\n"
				+ "('Altavoz Sony'),\r\n"
				+ "('Camara Xiaomi');");
		
		Metodos.insertData(db, "Insert into Suministra values\r\n"
				+ "(1,'JWD6', 75),\r\n"
				+ "(2, 'JWD6', 65),\r\n"
				+ "(3, 'AS2D', 220),\r\n"
				+ "(4, 'AS2D', 230),\r\n"
				+ "(5, 'MXW1', 120),\r\n"
				+ "(6, '73J1', 70),\r\n"
				+ "(7, 'LGCD', 10),\r\n"
				+ "(8, 'MNIW', 100),\r\n"
				+ "(9, 'DWAS', 60),\r\n"
				+ "(10, 'HS21', 40);");
		
		Metodos.getValues(db, "Proveedores");
		Metodos.getValues(db, "Piezas");
		Metodos.getValues(db, "Suministra");

	}

}
