
public class MainAppEx4 {

	public static void main(String[] args) {
		String db= "ud1804";
		
		Metodos.createBD(db);
		Metodos.createTable(db, "Peliculas", "codigo int auto_increment not null,\r\n"
				+ "nombre varchar(100),\r\n"
				+ "calificacionEdad varchar(6),\r\n"
				+ "PRIMARY KEY (codigo)");

		Metodos.createTable(db, "Salas", "codigo int auto_increment not null,\r\n"
				+ "nombre varchar(100),\r\n"
				+ "pelicula int,\r\n"
				+ "primary key (codigo),\r\n"
				+ "constraint fk_codigoPeliculas FOREIGN KEY (pelicula ) \r\n"
				+ "REFERENCES Peliculas (codigo)\r\n"
				+ "ON DELETE CASCADE ON UPDATE CASCADE");
		
		Metodos.insertData(db, "Insert into Peliculas values \r\n"
				+ "(1, 'Citizen Kane', 'PG'),\r\n"
				+ "(2, 'Singin in the Rain', 'G'),\r\n"
				+ "(3, 'The Wizard of Oz', 'G'),\r\n"
				+ "(4, 'The Quiet Man', null),\r\n"
				+ "(5, 'North by Northwest', null),\r\n"
				+ "(6, 'The Last Tango in Paris', 'NC-17'),\r\n"
				+ "(7, 'Some Like it Hot', 'PG-13'),\r\n"
				+ "(8, 'A Night at the Opera', null),\r\n"
				+ "(9, 'Citizen King','G');");
		
		Metodos.insertData(db, "Insert into Salas values \r\n"
				+ "(1, 'Odeon', 5),\r\n"
				+ "(2, 'Imperial', 1),\r\n"
				+ "(3, 'Majestic', null),\r\n"
				+ "(4, 'Royale', 6),\r\n"
				+ "(5, 'Paraiso', 3),\r\n"
				+ "(6, 'Nickelodeon', null);");
		
		Metodos.getValues(db, "Peliculas");
		Metodos.getValues(db, "Salas");

	}

}
