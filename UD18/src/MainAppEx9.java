
public class MainAppEx9 {

	public static void main(String[] args) {
		String db= "ud1809";
		
		// Facultad Table
		String facultad= "Facultad";
		String camposFacultad="codigo int,nombre varchar(100),Primary key(codigo)";
		String insertFacultad="Insert into Facultad values (1,'Facultad de Química'),(2,'Facultad de Matemáticas'),(3,'Facultad de Informática'),(4,'Facultad de Robótica'),(5,'Facultad de Nutrición'),(6,'Facultad de Derecho'),(7,'Facultad de ADE'),(8,'Facultad de Física'),(9,'Facultad de Arquitectura'),(10,'Facultad de Bellas Artes');";
		
		// Equipos Table
		String equipos= "Equipos";
		String camposEquipos="numSerie char(4),nombre varchar(100),facultad int,Primary key(numSerie),constraint fk_EquiposFacultad FOREIGN KEY (facultad) REFERENCES Facultad(codigo) ON DELETE CASCADE ON UPDATE CASCADE";
		String insertEquipos="Insert into Equipos values ('GP01','Grupo 1',1),('GP02','Grupo 2',2),('GP03','Grupo 3',3),('GP04','Grupo 4',4),('GP05','Grupo 5',5),('GP06','Grupo 6',6),('GP07','Grupo 7',7),('GP08','Grupo 8',8),('GP09','Grupo 9',9),('GP10','Grupo 10',10);";
		
		// Investigadores Table
		String investigadores= "Investigadores";
		String camposInvestigadores="dni varchar(8),nomApels varchar(255),facultad int,PRIMARY KEY (dni),constraint fk_InvestigadoresFacultad FOREIGN KEY (facultad) REFERENCES Facultad(codigo) ON DELETE CASCADE ON UPDATE CASCADE";
		String insertInvestigadores="insert into Investigadores values ('0748311H', 'Zakaria Rodríguez', 8),('7282724C', 'Albert de-La-Rosa', 7),('7283808V', 'Rogelio Julian', 10),('1501770X', 'Patricio del Castillo', 1),('1703919G', 'Consuelo Calatayud', 9),('8561124Y', 'Angelica Zafra', 2),('9028610E', 'Óscar Toledano', 3),('2922936E', 'Ingrid Urbano', 5),('7906130L', 'Fernando Castro', 4),('0972860M', 'Maria-Isabel Rojo', 6);";
		
		// Reserva Table
		String reserva= "Reserva";
		String camposReserva="dni varchar(8) not null,numSerie char(4) not null,comienzo datetime,fin datetime,primary key (dni, numSerie),constraint fk_ReservaInvestigador FOREIGN KEY (dni) REFERENCES Investigadores(dni) ON DELETE CASCADE ON UPDATE CASCADE,constraint fk_ReservaEquipo FOREIGN KEY (numSerie) REFERENCES Equipos(numSerie) ON DELETE CASCADE ON UPDATE CASCADE";
		String insertReserva="Insert into Reserva values ('1501770X','GP01','2021-11-20','2022-03-21'),('8561124Y','GP02','2021-12-10','2022-02-01'),('9028610E','GP03','2020-10-15','2021-04-22'),('0748311H','GP04','2020-04-10','2020-09-29'),('2922936E','GP05','2021-11-20','2022-03-21'),('0972860M','GP06','2022-01-20','2022-05-08'),('0748311H','GP07','2021-05-20','2021-12-21'),('7282724C','GP08','2021-12-20','2022-03-21'),('7906130L','GP09','2021-01-20','2021-03-21'),('7283808V','GP10','2021-10-20','2022-01-21');";

		Metodos.createBD(db);
		
		Metodos.createTable(db, facultad, camposFacultad);
		Metodos.createTable(db, equipos, camposEquipos);
		Metodos.createTable(db, investigadores, camposInvestigadores);
		Metodos.createTable(db, reserva, camposReserva);
		
		Metodos.insertData(db, insertFacultad);
		Metodos.insertData(db, insertEquipos);
		Metodos.insertData(db, insertInvestigadores);
		Metodos.insertData(db, insertReserva);

		Metodos.getValues(db, facultad);	
		Metodos.getValues(db, equipos);	
		Metodos.getValues(db, investigadores);	
		Metodos.getValues(db, reserva);	
		
	}

}
