package Utilitar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.DatabaseMetaData;

import ProiectP3Biblioteca.MainClasProiectP3Biblioteca;


public class CreareTabele {

	/**
	 * Aceasta metoda verifica daca esista tabela "cititori" in baza de date, in caz contrar, aceasta se va creea
	 */
	public static void createTableCititori() {
		
		try {
			Connection conn = DriverManager.getConnection(MainClasProiectP3Biblioteca.DB_URL,"root","Raluca_2003");

			try {
				DatabaseMetaData dbmd = (DatabaseMetaData) conn.getMetaData();

				ResultSet rs = dbmd.getTables(null, null, "cititori",null);
				if(rs.next()) 
					System.out.println("Table " + rs.getString(3) + " exists");
				
				else {
					java.sql.Statement s = conn.createStatement();
					s.executeQuery(
							"CREATE TABLE cititori cnp VARCHAR(13) NOT NULL, nume VARCHAR(45)  NOT NULL, nrTelefon VARCHAR(10)  NOT NULL, parola VARCHAR(45)  NOT NULL, PRIMARY KEY (cnp))");

					conn.commit();
					System.out.println("Table cititori created");
				}
			} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
	/**
	 * Aceasta metoda verifica daca esista tabela "bibliotecari" in baza de date, in caz contrar, aceasta se va creea
	 */
	public static void createTableBibliotecari() {
		
		try {
			Connection conn = DriverManager.getConnection(MainClasProiectP3Biblioteca.DB_URL,"root","Raluca_2003");

			try {
				DatabaseMetaData dbmd = (DatabaseMetaData) conn.getMetaData();

				ResultSet rs = dbmd.getTables(null, null, "bibliotecari",null);
				if(rs.next()) 
					System.out.println("Table " + rs.getString(3) + " exists");
				
				else {
					java.sql.Statement s = conn.createStatement();
					s.executeQuery(
							"CREATE TABLE bibliotecari idAngajat INTEGER NOT NULL, nume VARCHAR(45)  NOT NULL, nrTelefon VARCHAR(10)  NOT NULL,  email VARCHAR(45)  NOT NULL,  parola VARCHAR(45)  NOT NULL, PRIMARY KEY (idAngajat))");

					conn.commit();
					System.out.println("Table bibliotecari created");
				}
			} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
	
	/**
	 * Aceasta metoda verifica daca esista tabela "carti" in baza de date, in caz contrar, aceasta se va creea
	 */
	public static void createTableCarti() {
		
		try {
			Connection conn = DriverManager.getConnection(MainClasProiectP3Biblioteca.DB_URL,"root","Raluca_2003");

			try {
				DatabaseMetaData dbmd = (DatabaseMetaData) conn.getMetaData();

				ResultSet rs = dbmd.getTables(null, null, "carti",null);
				if(rs.next()) 
					System.out.println("Table " + rs.getString(3) + " exists");
				
				else {
					java.sql.Statement s = conn.createStatement();
					s.executeQuery(
							"CREATE TABLE carti idCarte INTEGER NOT NULL, titlu VARCHAR(45)  NOT NULL, autor VARCHAR(45)  NOT NULL,  gen VARCHAR(45)  NOT NULL,  nrci INTEGER  NOT NULL, nrcr INTEGER  NOT NULL, nrcd INTEGERE  NOT NULL, nrzi INTEGER  NOT NULL, PRIMARY KEY (idCarte))");

					conn.commit();
					System.out.println("Table carti created");
				}
			} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
	
	/**
	 * Aceasta metoda verifica daca esista tabela "exemplare" in baza de date, in caz contrar, aceasta se va creea
	 */
	public static void createTableExemplare() {
		
		try {
			Connection conn = DriverManager.getConnection(MainClasProiectP3Biblioteca.DB_URL,"root","Raluca_2003");

			try {
				DatabaseMetaData dbmd = (DatabaseMetaData) conn.getMetaData();

				ResultSet rs = dbmd.getTables(null, null, "exemplare",null);
				if(rs.next()) 
					System.out.println("Table " + rs.getString(3) + " exists");
				
				else {
					java.sql.Statement s = conn.createStatement();
					s.executeQuery(
							"CREATE TABLE exemplare idExemplar INTEGER NOT NULL, idCarte INTEGER NOT NULL, status VARCHAR(45) NOT NULL, PRIMARY KEY (idExemplar))");

					conn.commit();
					System.out.println("Table exemplare created");
				}
			} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}

	/**
	 * Aceasta metoda verifica daca esista tabela "imprumuturi" in baza de date, in caz contrar, aceasta se va creea
	 */
	public static void createTableImprumuturi() {
		
		try {
			Connection conn = DriverManager.getConnection(MainClasProiectP3Biblioteca.DB_URL,"root","Raluca_2003");

			try {
				DatabaseMetaData dbmd = (DatabaseMetaData) conn.getMetaData();

				ResultSet rs = dbmd.getTables(null, null, "imprumuturi",null);
				if(rs.next()) 
					System.out.println("Table " + rs.getString(3) + " exists");
				
				else {
					java.sql.Statement s = conn.createStatement();
					s.executeQuery(
							"CREATE TABLE imprumuturi cnpCititor VARCHAR(45) NOT NULL, idExemplar INTEGER NOT NULL, dataImprumut date NOT NULL");

					conn.commit();
					System.out.println("Table imprumuturi created");
				}
			} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
	
	/**
	 * Aceasta metoda verifica daca esista tabela "rezervari" in baza de date, in caz contrar, aceasta se va creea
	 */
	public static void createTableRezervari() {
		
		try {
			Connection conn = DriverManager.getConnection(MainClasProiectP3Biblioteca.DB_URL,"root","Raluca_2003");

			try {
				DatabaseMetaData dbmd = (DatabaseMetaData) conn.getMetaData();

				ResultSet rs = dbmd.getTables(null, null, "rezervari",null);
				if(rs.next()) 
					System.out.println("Table " + rs.getString(3) + " exists");
				
				else {
					java.sql.Statement s = conn.createStatement();
					s.executeQuery(
							"CREATE TABLE rezervari cnpCititor VARCHAR(45) NOT NULL, idExemplar INTEGER NOT NULL, dataRezervare date NOT NULL");

					conn.commit();
					System.out.println("Table rezervari created");
				}
			} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}

}
