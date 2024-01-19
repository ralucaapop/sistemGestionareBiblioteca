package ProiectP3Biblioteca;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ProiectP3Biblioteca.Exemplar.status;

/**
 * Clasa pentru definirea tuturor metodelor folosite in aplicatie de catre un cititor
 */

public class Functii {

	
	public static boolean verificaAutentificare(String cnp, String parola)
	{
		boolean autentificareCorecta = false;
		try {
			Connection connection = DriverManager.getConnection(MainClasProiectP3Biblioteca.DB_URL,"root","Raluca_2003");
		 	System.out.println("Intra in contul tau\nIntrodu CNP-ul si parola pentru a te putea loga");
		 	java.sql.Statement st = connection.createStatement();

				try {
					boolean cnpValid=verificaCNPAuth(cnp);
					
					if(cnpValid==false)
						System.out.println("CNP invalid, nu exista un utilizator inregistrat cu acest CNP, mai incearca/n");
					else {
						String SQL_SELECT1 = "select * from CITITORI where cnp='"+cnp+"' and parola='"+parola+"'";
						ResultSet resultSet1 = st.executeQuery(SQL_SELECT1);
						
						int ok1=0;
						
						while (resultSet1.next()) {
							ok1=1;
							
							System.out.println("PAROLA CORECTA");
							}
						if(ok1==0)
							System.out.println("Parola incorecta, incearca iar");
						else 
							{
								System.out.println("Autentificare cu succes");
								autentificareCorecta=true;
							}
					} 
					}catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();}
					
		return autentificareCorecta;
	}
	
	public static boolean verificaCNPAuth(String cnp){
		
		boolean ok = false;
		try {
			Connection connection = DriverManager.getConnection(MainClasProiectP3Biblioteca.DB_URL,"root","Raluca_2003");
		 	System.out.println("Intra in contul tau\nIntrodu CNP-ul si parola pentru a te putea loga");
		 	java.sql.Statement st = connection.createStatement();

				try {
					String SQL_SELECT = "select * from CITITORI where cnp='"+cnp+"'";
					ResultSet resultSet = st.executeQuery(SQL_SELECT);
					
					while (resultSet.next()) {
						ok=true;
						System.out.println("CNP CORECT");
					}
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		return ok;
	}
	
	/**
	 * Metoda pentru autentificarea in aplicatie a unui cititor
	 * @param sc - un obiect de tip Scanner
	 */
	public static void actiuniCititor()
	{
		Scanner sc = new Scanner(System.in);
		boolean autentificare_corecta = false;
			
		String cnp="nec";
		String parola="nec";
	
		while(!autentificare_corecta)
			{
				System.out.println("Intra in contul tau\nIntrodu CNP-ul si parola pentru a te putea loga");
			
				System.out.print("CNP:");
				cnp = sc.next();
				System.out.print("PAROLA:");
				parola = sc.next();
				autentificare_corecta=verificaAutentificare(cnp,parola);
				
				if(autentificare_corecta)
				{
					Cititor cit = new Cititor(cnp,parola);
					System.out.println(cnp);
					optiuniCititor(cit);
				}
			}
	}
	
	/**
	 * Metoda care returneaza o lista de carti care au titlul si autorul specificat
	 * @param titlu - titlul cartii f=dorite
	 * @param autor - autorul cartii dorite
	 * @return lista de carti
	 */
	public static List<Carte> returneazaCartea(String titlu, String autor)
	{
		List<Carte> carti = new ArrayList<>();
		
		try {
			Connection connection = DriverManager.getConnection(MainClasProiectP3Biblioteca.DB_URL,"root","Raluca_2003");
			java.sql.Statement st = connection.createStatement();

			try {
					String SQL_SELECT = "select * from CARTI where titlu='"+titlu+"' and autor='"+autor+"'";
					ResultSet resultSet = st.executeQuery(SQL_SELECT);
					while(resultSet.next()) {
						Carte c = new Carte(resultSet.getInt("idCarte"),resultSet.getString("titlu"), resultSet.getString("gen"),resultSet.getString("autor"),resultSet.getInt("nrci"), resultSet.getInt("nrcd"), resultSet.getInt("nrcr"), resultSet.getInt("nrzi"));
						carti.add(c);
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
		}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return carti;
	}
	
	/**
	 * Metoda pentru alegerea id-ului cartii pentru rezervare
	 * @param carti - lista de carti din care se poate alege
	 * @return - id-ul cartii
	 */
	public static boolean verificaIdCarteAles(List<Carte> cartiPosibile, int id) {
		boolean idCorect=false;
		
		for(Carte cart: cartiPosibile) {
			if(cart.getIdCarte()==id)
				{
					if(cart.getNrExemplareDisponibile()==0)
					{
						System.out.println("Nu exista exemplare disponibile");
					}
					else
					idCorect=true;
					break;
				}
		}
		return idCorect;
	}
	
	public static int alegeIdCartePtRezervare(List<Carte> cartiPosibile)
	{
		boolean idCorect=false;
		int id=0;
		while(!idCorect)
		{
			System.out.println("Alege ID-ul cartii pe care doresti sa o rezervi");
			Scanner sc = new Scanner(System.in);
			System.out.print("ID:");
			id=Integer.parseInt(sc.next());
			for(Carte cart: cartiPosibile) {
				if(cart.getIdCarte()==id)
					{
						if(cart.getNrExemplareDisponibile()==0)
						{
							System.out.println("Nu exista exemplare disponibile");
						}
						else
						idCorect=true;
						break;
					}
			}
			if(idCorect==false)
			System.out.println("ID incorect, incearca iar");
		}
		return id;
	}
	
	/**
	 * Metoda pentru alegerea id-ului exemplarului care se doreste a fi rezervat
	 * @param idCarte- id-ul cartii  
	 * @return id-ul exemplarului 
	 */
	public static int alegeIdExemplarPtRezervare(int idCarte) {
		
		
		int id=0;
		
		try {
			Connection connection = DriverManager.getConnection(MainClasProiectP3Biblioteca.DB_URL,"root","Raluca_2003");
			java.sql.Statement st = connection.createStatement();

			try {
					String SQL_SELECT = "select * from exemplare where idCarte='"+idCarte+"' and status='DISPONIBILA'";
					ResultSet resultSet = st.executeQuery(SQL_SELECT);
					while(resultSet.next())
					{
						id=resultSet.getInt("idExemplar");
						System.out.println("Exemplarul cu id-ul " + id+ " a fost selectat pentru rezervare.");
						break;
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
		}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
		
		return  id;
	}

	/**
	 * Metoda pentru realizarea unei rezervari pentru un exemplar
	 * @param cit - obect de tip cititor care face rezervarea
	 * @param idCarte - id-ul cartii rezervate
	 * @param idExemplar - id-ul exemplarului rezervat
	 */
	public static void realizeazaRezervare(Cititor cit, int idCarte, int idExemplar ) {
		Connection connection;
		try {
		connection = DriverManager.getConnection(MainClasProiectP3Biblioteca.DB_URL,"root","Raluca_2003");
		java.sql.Statement st= connection.createStatement();
		String SQL_SELECT="Select * from carti where idCarte = '"+idCarte+"'";
		ResultSet resultSet = st.executeQuery(SQL_SELECT);
		int nred=0;
		int nrer=0;
		while(resultSet.next())
		{
			nred=resultSet.getInt("nrcd");
			nrer=resultSet.getInt("nrcr");
		}
		System.out.println(nred);
		nred--;
		nrer++;
		String SQL_UPDATE="UPDATE carti SET nrcd ='"+nred+"' WHERE (idCarte = '"+idCarte+"')";
		String SQL_UPDATE2="UPDATE carti SET nrcr ='"+nrer+"' WHERE (idCarte = '"+idCarte+"')";
		
		String SQL_UPDATE1="UPDATE exemplare SET status='REZERVATA' WHERE (idExemplar = '"+idExemplar+"')";
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		st.executeUpdate(SQL_UPDATE);
		st.executeUpdate(SQL_UPDATE1);
		st.executeUpdate(SQL_UPDATE2);
		
		String SQL_INSERT = "INSERT INTO rezervari VALUES (?, ?, ?)";

		try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT)) {
		    preparedStatement.setString(1, cit.getCNPCititor());
		    preparedStatement.setInt(2, idExemplar);
		    preparedStatement.setString(3, LocalDate.now().format(formatter));

		    int affectedRows = preparedStatement.executeUpdate();
		    if(affectedRows>0)
		    	System.out.println("Rezervare efectuata cu succes.");	
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

		
		
	}
	
	/**
	 * Metoda pentru alegerea actiunilor in aplicatie pentru un cititor
	 * @param cit - cititorul care face alegerile
	 */
	public static void optiuniCititor(Cititor cit) {
			int alegere=0;
			while(alegere<1||alegere>6)
			{	
				System.out.println("\nACTIUNI POSIBILE:\n1.Fa o rezervare\n2.Anuleaza o rezervare\n3.EXIT");
				Scanner sc1 = new Scanner(System.in);
				System.out.print("Alege NUMARUL actiunii dorite:");
				alegere=Integer.parseInt(sc1.next());
				
				if(alegere<0||alegere>5)
					System.out.println("ALEGERE INVALIDA. Trebuie sa selectati un numar din multimea{1,2,3}");
				
			}
			
			if(alegere==1)
			Functii.faRezervare(cit);
			else if(alegere==2)
			Functii.anuleazaRezervare(cit);
			else if(alegere==3)
				System.exit(0);
	}
	
	/**
	 * Metoda pentru rezervarea unei carti
	 * @param cititor - cititorul care face rezevarea
	 */
	public static void faRezervare(Cititor cititor) {
		
		System.out.println("<<Rezerva o carte>>");
		boolean carteGasita=false;
		List<Carte> carti = new ArrayList<>();
		
		while(!carteGasita) 
		{
			Scanner sc1 = new Scanner(System.in);
			System.out.println("Introdu titlul cautat:");
			String titlu=sc1.next();
			System.out.println("Introdu autorul:");
			String autor=sc1.next();
			carti=returneazaCartea(titlu,autor);
			if(carti.size()!=0)
				carteGasita=true;
			if(carti.size()==0)
			{
				System.out.println("Aceasta carte nu este disponibila. Asigurati-va ca ati introdus corect TITLUL si AUTORUL\nINCERCATI IAR ");
			}
		}
		if(carteGasita==true)
		{
			System.out.println("ID TITLU AUTOR");
			for(Carte c:carti)
				System.out.println(c);
		}
		int idCartePtRezervare=alegeIdCartePtRezervare(carti);
		int idExemplarPtRezervare=alegeIdExemplarPtRezervare(idCartePtRezervare);
		realizeazaRezervare(cititor, idCartePtRezervare, idExemplarPtRezervare);
	}
	
	/**
	 * Metoda pentru anularea unei rezervari
	 * @param cit - cititorul care realizeaza anularea
	 */
	
	public static List<AfisareRezervari> gasesteRezervarileCititorului(Cititor cit){
		
		List<AfisareRezervari> rezervari = new ArrayList<>();
		try {
			Connection connection = DriverManager.getConnection(MainClasProiectP3Biblioteca.DB_URL,"root","Raluca_2003");
			java.sql.Statement st = connection.createStatement();

			try {
					String SQL_SELECT = "select r.idExemplar, c.titlu, c.autor from rezervari r, carti c, exemplare e1 where r.cnpCititor='"
							+ ""+cit.getCNPCititor()+"'and e1.idExemplar=r.idExemplar" + " and e1.idCarte=c.idCarte";
					ResultSet resultSet = st.executeQuery(SQL_SELECT);
					while(resultSet.next())
					{
						System.out.println(resultSet.getInt("r.idExemplar")+" "+resultSet.getString("c.titlu")+" "+resultSet.getString("c.autor"));
						AfisareRezervari r= new AfisareRezervari(resultSet.getInt("r.idExemplar"),resultSet.getString("c.titlu"),resultSet.getString("c.autor"));
						rezervari.add(r);
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
		}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
		
		return rezervari;
	}
	
	public static boolean verificaIdExemplarAles(List<AfisareRezervari> rezervari, int id) {
		
		boolean idExemplarCorect=false;
		for(AfisareRezervari r: rezervari)
			if(r.getIdE()==id)
				{
					idExemplarCorect=true;
					break;
				}
		return idExemplarCorect;
	}
	
	
	
	
	public static void anuleazaRezervare(Cititor cit, int idExemplar) {
		Connection connection;
		try {
		connection = DriverManager.getConnection(MainClasProiectP3Biblioteca.DB_URL,"root","Raluca_2003");
		java.sql.Statement st= connection.createStatement();
		String SQL_SELECT="Select * from exemplare where idExemplar = '"+idExemplar+"'";
		ResultSet resultSet = st.executeQuery(SQL_SELECT);
		
		int idCarte=0;
		while(resultSet.next())
		{
			idCarte=resultSet.getInt("idCarte");
		}
		
		String SQL_SELECT1="Select * from carti where idCarte = '"+idCarte+"'";
		ResultSet resultSet1 = st.executeQuery(SQL_SELECT1);
		int nred=0;
		int nrer=0;
		while(resultSet1.next())
		{
			nred=resultSet1.getInt("nrcd");
			nrer=resultSet1.getInt("nrcr");
		}
		
		nred++;
		nrer--;
		String SQL_UPDATE="UPDATE carti SET nrcd ='"+nred+"' WHERE (idCarte = '"+idCarte+"')";
		String SQL_UPDATE2="UPDATE carti SET nrcr ='"+nrer+"' WHERE (idCarte = '"+idCarte+"')";
		
		String SQL_UPDATE1="UPDATE exemplare SET status='DISPONIBILA' WHERE (idExemplar = '"+idExemplar+"')";
		
		st.executeUpdate(SQL_UPDATE);
		st.executeUpdate(SQL_UPDATE1);
		st.executeUpdate(SQL_UPDATE2);
		
		String SQL_DELETE = "DELETE FROM rezervari WHERE idExemplar=? and cnpCititor=?";

		try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE)) {
		    preparedStatement.setString(2, cit.getCNPCititor());
		    preparedStatement.setInt(1, idExemplar);
		    int affectedRows = preparedStatement.executeUpdate();
		    if(affectedRows>0)
		    	System.out.println("Rezervare anulata cu succes.");	
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

	///nefolosita
	public static void anuleazaRezervare(Cititor cit) {
		
		
		System.out.println("Rezervarile tale");
		
		List<Integer> idExemplareRez = new ArrayList<>();
		
		System.out.println("ID Exemplar TITLU AUTOR");
		
		try {
			Connection connection = DriverManager.getConnection(MainClasProiectP3Biblioteca.DB_URL,"root","Raluca_2003");
			java.sql.Statement st = connection.createStatement();

			try {
					String SQL_SELECT = "select r.idExemplar, c.titlu, c.autor from rezervari r, carti c, exemplare e1 where r.cnpCititor='"
							+ ""+cit.getCNPCititor()+"'and e1.idExemplar=r.idExemplar" + " and e1.idCarte=c.idCarte";
					ResultSet resultSet = st.executeQuery(SQL_SELECT);
					while(resultSet.next())
					{
						System.out.println(resultSet.getInt("r.idExemplar")+" "+resultSet.getString("c.titlu")+" "+resultSet.getString("c.autor"));
						idExemplareRez.add(resultSet.getInt("r.idExemplar"));
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
		}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
		
		boolean idExemplarCorect=false;
		int idExemplar=0;
		Scanner sc1 = new Scanner(System.in);
		while(!idExemplarCorect) {
			
			System.out.println("Alegeti id-ul corespunzator exemplarului pentru care doriti sa anulati rezervarea");
			idExemplar=Integer.parseInt(sc1.next());
			if(idExemplareRez.contains(idExemplar))
				{
					idExemplarCorect=true;
					break;
				}
			else {System.out.print("Acest id este incorect. INCEARCA IAR");}
		}
		
		if(idExemplarCorect)
		{
			Connection connection;
			try {
			connection = DriverManager.getConnection(MainClasProiectP3Biblioteca.DB_URL,"root","Raluca_2003");
			java.sql.Statement st= connection.createStatement();
			String SQL_SELECT="Select * from exemplare where idExemplar = '"+idExemplar+"'";
			ResultSet resultSet = st.executeQuery(SQL_SELECT);
			
			int idCarte=0;
			while(resultSet.next())
			{
				idCarte=resultSet.getInt("idCarte");
			}
			
			String SQL_SELECT1="Select * from carti where idCarte = '"+idCarte+"'";
			ResultSet resultSet1 = st.executeQuery(SQL_SELECT1);
			int nred=0;
			int nrer=0;
			while(resultSet1.next())
			{
				nred=resultSet1.getInt("nrcd");
				nrer=resultSet1.getInt("nrcr");
			}
			
			nred++;
			nrer--;
			String SQL_UPDATE="UPDATE carti SET nrcd ='"+nred+"' WHERE (idCarte = '"+idCarte+"')";
			String SQL_UPDATE2="UPDATE carti SET nrcr ='"+nrer+"' WHERE (idCarte = '"+idCarte+"')";
			
			String SQL_UPDATE1="UPDATE exemplare SET status='DISPONIBILA' WHERE (idExemplar = '"+idExemplar+"')";
			
			st.executeUpdate(SQL_UPDATE);
			st.executeUpdate(SQL_UPDATE1);
			st.executeUpdate(SQL_UPDATE2);
			
			String SQL_DELETE = "DELETE FROM rezervari WHERE idExemplar=? and cnpCititor=?";

			try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE)) {
			    preparedStatement.setString(2, cit.getCNPCititor());
			    preparedStatement.setInt(1, idExemplar);
			    int affectedRows = preparedStatement.executeUpdate();
			    if(affectedRows>0)
			    	System.out.println("Rezervare anulata cu succes.");	
			} catch (SQLException e) {
			    e.printStackTrace();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		}
} 
	
	public static void adaugaBibliotecarNou(int id, String nume, String nrTel, String email,String parola) {
		try {
			Connection connection = DriverManager.getConnection(MainClasProiectP3Biblioteca.DB_URL,"root","Raluca_2003");
			java.sql.Statement st = connection.createStatement();
			String SQL_INSERT = "INSERT INTO bibliotecari VALUES(?,?,?,?,?)"; 
			
			try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT)) {
			    preparedStatement.setInt(1, id);
			    preparedStatement.setString(2, nume);
			    preparedStatement.setString(3, nrTel);
			    preparedStatement.setString(4, email);
			    preparedStatement.setString(5, parola);

			    int affectedRows = preparedStatement.executeUpdate();
			    if(affectedRows>0)
			    	System.out.println("Inregistrare efectuata cu succes.");	
			} catch (SQLException e) {
			    e.printStackTrace();
			}
			
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
}
	
	public static void adaugaBibliotecarNou() {
		System.out.println("Inregistreaza un bibliotecar nou");
		boolean IDValid=true;
		int id=0;
		
		boolean ok=false;	
		
		try {
				Connection connection = DriverManager.getConnection(MainClasProiectP3Biblioteca.DB_URL,"root","Raluca_2003");
				java.sql.Statement st = connection.createStatement();

				try {
					Scanner sc = new Scanner(System.in);

					while(IDValid)
					{
						System.out.print("ID-ul Angajatului:");
						id=Integer.parseInt(sc.next());
						
							String SQL_SELECT = "select * from bibliotecari where idAngajat='"+id+"'";
							ResultSet resultSet = st.executeQuery(SQL_SELECT);
							while(resultSet.next())
								IDValid=false;
						
							if(IDValid==false)
							{	
								System.out.println("Acest ID este deja folosit. INCEARCA IAR\n");
								IDValid=true;
							}
							else if(IDValid==true)
							{
							System.out.println("ID valid, continuati\n");
								ok=true;
								break;
							}
						}
					if(ok==true)
					{
						System.out.println("NUMELE:");
						String nume=sc.next();
						System.out.println("NR Telefon:");
						String nrTel=sc.next();
						System.out.println("E-mail:");
						String email=sc.next();
						System.out.println("Parola:");
						String parola=sc.next();
						
						String SQL_INSERT = "INSERT INTO bibliotecari VALUES(?,?,?,?,?)"; 
						
						try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT)) {
						    preparedStatement.setInt(1, id);
						    preparedStatement.setString(2, nume);
						    preparedStatement.setString(3, nrTel);
						    preparedStatement.setString(4, email);
						    preparedStatement.setString(5, parola);

						    int affectedRows = preparedStatement.executeUpdate();
						    if(affectedRows>0)
						    	System.out.println("Inregistrare efectuata cu succes.");	
						} catch (SQLException e) {
						    e.printStackTrace();
						}
						
					}
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}
	/**
	 * Metoda pentru alegerea actiunilor din aplicatie pentru rolul de Bibliotecar
	 * @param sc
	 */
	
	public static void actiuniBibliotecar(Scanner sc) {
		
			int alegere=0;
			while(alegere<1||alegere>6)
			{	
				System.out.println("\nACTIUNI POSIBILE:\n1.Autentificare bibliotecar\n2.Adauga cont nou bibliotecar\n3.EXIT");
				Scanner sc1 = new Scanner(System.in);
				System.out.print("Alege NUMARUL actiunii dorite:");
				alegere=Integer.parseInt(sc1.next());
				
				if(alegere<0||alegere>3)
					System.out.println("ALEGERE INVALIDA. Trebuie sa selectati un numar din intervalul 1-6");
			}
			
			if(alegere==1)
				autentificareBibliotecar();
			else if(alegere==2)
				adaugaBibliotecarNou();
			else if(alegere==3)
				System.exit(0);
		
	}
	
	
	public static boolean verificaAutentificareBibliotecar(int idA, String parola) {
		
		boolean autentificareCorecta = false;
		try {
			Connection connection = DriverManager.getConnection(MainClasProiectP3Biblioteca.DB_URL,"root","Raluca_2003");
		 	System.out.println("Intra in contul tau\nIntrodu CNP-ul si parola pentru a te putea loga");
		 	java.sql.Statement st = connection.createStatement();

				try {
					boolean idValid=verificaIDAngajat(idA);
					
					if(idValid==false)
						System.out.println("ID invalid, nu exista un utilizator inregistrat cu acest ID, mai incearca/n");
					else {
						String SQL_SELECT1 = "select * from bibliotecari where idAngajat='"+idA+"' and parola='"+parola+"'";
						ResultSet resultSet1 = st.executeQuery(SQL_SELECT1);
						int ok1=0;
						
						while (resultSet1.next()) {
							ok1=1;
							
							System.out.println("PAROLA CORECTA");
							}
						if(ok1==0)
							System.out.println("Parola incorecta, incearca iar");
						else 
							{
								System.out.println("Autentificare cu succes");
								autentificareCorecta=true;
							}
					} 
					}catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();}
					
		return autentificareCorecta;
	}
	
	public static boolean verificaIDAngajat(int idA) {
		boolean idCorect=false;
		try {
			Connection connection = DriverManager.getConnection(MainClasProiectP3Biblioteca.DB_URL,"root","Raluca_2003");
			java.sql.Statement st = connection.createStatement();

				try {
					String SQL_SELECT = "select * from bibliotecari where idAngajat='"+idA+"'";
					ResultSet resultSet = st.executeQuery(SQL_SELECT);
					
					int ok=0;
					
					while (resultSet.next()) {
						idCorect=true;
						System.out.println("ID CORECT");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idCorect;
	}
	
	public static void autentificareBibliotecar()
	{
		Scanner sc = new Scanner(System.in);
		boolean autentificare_corecta = false;
		
		int idA=0;
		String parola="nec";
	
		while(!autentificare_corecta)
			{
				System.out.println("Intra in contul tau\nIntrodu ID-ul si parola pentru a te putea loga");
			
				System.out.print("ID Angajat:");
				idA = Integer.parseInt(sc.next());
				System.out.print("PAROLA:");
				parola = sc.next();
				
				boolean idValid=verificaIDAngajat(idA);
				if(idValid)
					autentificare_corecta=verificaAutentificareBibliotecar(idA,parola);
			
					if(autentificare_corecta==true)
					{
						int alegere=0;
						while(alegere<1||alegere>6)
						{	
							System.out.println("\nACTIUNI POSIBILE:\n1.Adauga o carte noua\n2.Adauga un exemplar nou\n3.Adauga un nou cititor\n4.Realizeaza un imprumut\n5.Realizeaza un retur\n6Revizuieste Rezervari.\n7.EXIT");
							Scanner sc1 = new Scanner(System.in);
							System.out.print("Alege NUMARUL actiunii dorite:");
							alegere=Integer.parseInt(sc1.next());
							
							if(alegere<0||alegere>7)
								System.out.println("ALEGERE INVALIDA. Trebuie sa selectati un numar din intervalul 1-7");
						}
						
						if(alegere==1)
						FunctiiBibliotecar.adaugaCarteNoua();
						else if(alegere==2)
						FunctiiBibliotecar.adaugaExemplarNou();
						else if(alegere==3)
						FunctiiBibliotecar.adaugaCititorNou();
						else if(alegere==4)
						FunctiiBibliotecar.realizeazaImprumutP1();
						else if(alegere==5)
						FunctiiBibliotecar.realizeazaRetur();
						else if(alegere==6)
							FunctiiBibliotecar.revizuiesteRezervari();
						else if(alegere==7)
							System.exit(0);
					}
			}
	}
	
}
