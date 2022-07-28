
public class MainAppEx5 {

	public static void main(String[] args) {
		String db= "ud1805";
		
		Metodos.createBD(db);
		Metodos.createTable(db, "Despachos", "numero int not null,\r\n"
				+ "capacidad int,\r\n"
				+ "primary key (numero)");

		Metodos.createTable(db, "Directores", "dni varchar(8),\r\n"
				+ "nomApels varchar(255),\r\n"
				+ "dniJefe varchar(8),\r\n"
				+ "despacho int,\r\n"
				+ "primary key(dni),\r\n"
				+ "constraint fk_numeroDespacho FOREIGN KEY (despacho  ) \r\n"
				+ "REFERENCES Despachos (numero)\r\n"
				+ "ON DELETE CASCADE ON UPDATE CASCADE");
		
		Metodos.insertData(db, "Alter table Directores add constraint fk_dniJefeDirectores FOREIGN KEY (dniJefe) \r\n"
				+ "REFERENCES Directores(dni)\r\n"
				+ "ON DELETE CASCADE ON UPDATE CASCADE;");
		
		Metodos.insertData(db, "Insert into Despachos values\r\n"
				+ "(101, 25),\r\n"
				+ "(102, 12),\r\n"
				+ "(103, 4),\r\n"
				+ "(104, 4),\r\n"
				+ "(105, 1),\r\n"
				+ "(106, 2),\r\n"
				+ "(107, 14),\r\n"
				+ "(108, 12),\r\n"
				+ "(109, 25),\r\n"
				+ "(110, 8);");
		
		Metodos.insertData(db, "Insert into Directores values \r\n"
				+ "('2028643T', 'Arancha Toledo', NULL, 105),\r\n"
				+ "('4485261V', 'Juan Mayoral', '2028643T', 101),\r\n"
				+ "('6588740L', 'Hajar Rosa', '2028643T', 102),\r\n"
				+ "('1413828R', 'Miriam Urbano', '2028643T', 103),\r\n"
				+ "('3030479K', 'Eduardo Gordillo', '2028643T', 104),\r\n"
				+ "('0987192K', 'Dunia Ojeda', '2028643T', 106),\r\n"
				+ "('8438266D', 'Laureano Cañadas', '2028643T', 107),\r\n"
				+ "('6741073D', 'Purificacion Lobo', '2028643T', 108),\r\n"
				+ "('9554072N', 'Juan-Luis Barros','2028643T', 109),\r\n"
				+ "('3205097B', 'Florencio Castellano', '2028643T', 110);");
		
		Metodos.getValues(db, "Despachos");
		Metodos.getValues(db, "Directores");

	}

}
