package Utilitar;

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

import ProiectP3Biblioteca.Carte;
import ProiectP3Biblioteca.Cititor;
import ProiectP3Biblioteca.MainClasProiectP3Biblioteca;
import ProiectP3Biblioteca.Exemplar.status;

/**
 * Clasa pentru definirea tuturor metodelor folosite in aplicatie pentru gestionarea actiunilor unui utilizator cu rol de cititor
 */

public class Functii {

	/**
	 * Aceasta metoda este folosita pentru a verificarea datelor introduse de catre cititor in vederea autentificari acestui in cont.
	 * Sunt verificate atat cnp-ul, cat si parola asociate contului. Pentru verificarea CNP-ului se foloseste o functe aditionala, 
	 * iar doar daca cnp-ul este corect, atunci se verifica si parola asociata acestuia.
	 * @param cnp - CNP-ul cititorului pe care il foloseste pentru a se autentifica 
	 * @param parola - parola asociata contului acestuia
	 * @return - se returneaza true daca datele introduse au fost corecte, false in caz contrar
	 */
	public static boolean verificaAutentificare(String cnp, String parola)
	{
		boolean autentificareCorecta = false;
		try {
			Connection connection = DriverManager.getConnection(MainClasProiectP3Biblioteca.DB_URL,"root","Raluca_2003");
		 	System.out.println("Intra in contul tau\nIntrodu CNP-ul si parola pentru a te putea loga");
		 	java.sql.Statement st = connection.createStatement();

				try {
					boolean cnpValid=verificaCNPAuth(cnp);
					
					if(cnpValid==true)
					{
						String SQL_SELECT1 = "select * from CITITORI where cnp='"+cnp+"' and parola='"+parola+"'";
						ResultSet resultSet1 = st.executeQuery(SQL_SELECT1);
						
						int ok1=0;
						
						while (resultSet1.next()) {
							ok1=1;
							//PAROLA CORECTA;
							}
						if(ok1==1)
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
	
	
	/**
	 * Aceasta metoda este folosita pentru verificarea existentei unui cont de utilizator(cititor) asociat cnp-ului introdus
	 *  pentru a se putea realiza ulterior autentificare in cont. Verificarea existentei se face prin interogarea bazei de date(tabla cititori)
	 * @param cnp - valoarea care trebuie verificata
	 * @return - se returneza true daca cnp-ul a fost gasit, false in caz contrar
	 */
	public static boolean verificaCNPAuth(String cnp){
		
		boolean ok = false;
		try {
			Connection connection = DriverManager.getConnection(MainClasProiectP3Biblioteca.DB_URL,"root","Raluca_2003");
		 		java.sql.Statement st = connection.createStatement();

				try {
					String SQL_SELECT = "select * from CITITORI where cnp='"+cnp+"'";
					ResultSet resultSet = st.executeQuery(SQL_SELECT);
					
					while (resultSet.next()) {
						ok=true;
						
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
	 * Metoda care returneaza o lista de carti care au titlul si autorul specificat. In aceasta metoda se cauta in baza de date in tabela carti toate inregistrarile
	 * pentru care atributele "titlu" si "autor" se portivescu cu cele spceificate de utilizator in aplicatie. 
	 * @param titlu - titlul cartii dorite
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
	 * Aceasta metoda verifica daca id-ul cartii pe care cititorul l-a ales pentru a face o rezervare este unul corect(se regaseste in lista de carti afisate
	 * si daca exista exemplare disponibile pentru cartea dorita
	 * @param cartiPosibile
	 * @param id
	 * @return
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
	
	/**
	 * Metoda este folosita pentru ca utilizatorul sa aleaga din lista de carti afisata, in urma specificarii cartii dorte,
	 * exact cartea pentru care doreste sa faca rezervare. Daca pentru cartea aleasa nu mai sunt exemplare disponibile, acesa va primi un mesaj aferent,
	 * si va putea selecta id-ul unei ale carti din lista prezentata
	 * @param carti - lista de carti din care se poate alege
	 * @return - id-ul cartii pe care utilizaotrul a ales-o spre rezervare
	 */
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
	 * Aceasta metoda este folosita pentru alegerea id-ului exemplarului care va fi rezervat de catre cititor. Dupa alegere cartii si verificarea id-ului acesteia, 
	 * din lista de exemplare ale cartii respective se alege id-ul primului exemplar care este disponibil. 
	 * @param idCarte- id-ul cartii pe care cititorul doreste sa o rezerve
	 * @return id-ul exemplarului care va fi selectat pentru imprumut
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
	 * In aceasta metoda are loc realizarea efectiva a rezervarii. Se cauta in tablea "carti" cartea care se doreste a fi rezervata, se modifica numarul de exemplare
	 * disponibile si rezervate, se modifica status-ul exemplarului cartii in "REZERVATA" si se adauga o noua inregistrare in tabela rezervari care contine
	 * cnp-ul cititorului, id-ul exemplarului si data curenta
	 * @param cit - obect de tip cititor care face rezervarea
	 * @param idCarte - id-ul cartii care urmeaza a fi rezervat
	 * @param idExemplar - id-ul exemplarului care urmeaza a fi rezervat
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
	 * Aceasta metoda este folosita pentru afisarea tuturor rezervarilor active efectuate de catre un cititor. Se cauta in tabela rezervari toate inregistratile
	 * care au valoarea atributului cnpCititor egal cu valoarea cnp-ului obiectului de tip cititor primit ca parametru
	 * @param cit - cititorul pentru care se afiseaza rezervarile
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
	
	/**
	 * Aceasta metoda este folosita pentru a verifica daca id-ul exemplarului pe care dorese cititorul sa il returneze este valid sau nu.
	 * Se cauta in lista de exemplare rezervate ale cititorul, iar daca id-ul selectat de cititor pentru anularea unei rezervari se regaseste in lista
	 * de rezervari, atunci se poate realiza anularea 
	 * @param rezervari - lista cu exemplare rezervate de catre un cititor
	 * @param id - id-ul exemplarului pe care cititorul doreste sa anuleze rezervarea
	 * @return - returneza true daca id-ul este valid, false in caz contrar
	 */
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
	
	
	
	/**
	 * In aceasta metoda se realizeaza anularea rezervarii efective, dupa ce au fost selectate cititorul si id-ul exemplarului se modifica baza de date 
	 * prin stergerea inregistrarii aferecte rezervarii care se doreste a fi anulata in tabela "rezervari", modificarea numarului de exemplare disponibile
	 * si rezervate pentu catrea corespunzatoare id-ului exemplarului dorit in tabela carti si modificarea ststusului din "rezervata" in "disponibila" in
	 * tabela exemplare.  
	 * @param cit - cititorul care realizeaza anularea rezervarii 
	 * @param idExemplar - id-ul exemplarului pentru care va fi anulata rezervarea
	 */
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

	/**
	 * Aceasta metoda este folosita pentru crearea unui nou cont de utiliztor de tip bibliotecar.
	 * Se adauga in baza de date o noua inregistrare cu valorile primite ca parametrii
	 * @param id - id-ul de angajat la bibliotecarului
	 * @param nume - numele bibliotecarului
	 * @param nrTel - numarul de telefon al bibliotecarului
	 * @param email - adresa de e-mail a utilizatorului
	 * @param parola - parola de la cont al utilizatorului pe care o va folosi pentru a se putea autentifica in cont
	 */
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
	
	
	
	/**
	 * Aceasta metoda este folosita pentru autentificarea unui utilizator de tip bibliotecar in aplicatie
	 * Se verifica datele introduse de catre bibliotecar in vederea autentificari acestui in cont.
	 * Sunt verificate atat id-ul de angajat, cat si parola asociate contului. Pentru verificarea id-ului se foloseste o functe aditionala, 
	 * iar doar daca id-ul este corect, atunci se verifica si parola asociata acestuia.
	 * Pentru verificare se realizeaza interogari asupra bazei de date, mai exact asuprea tabelei "bibliotecari" si se verifica daca exista o inregistrare
	 * pentru care atributele corespunzatoare id-ului si parolei sa fie egale cu valorile paramentrilor functiei
	 * @param idA - id-ul angajatului pe care il introduce bibliotecarul pentru autentificarea in cont
	 * @param parola - parola pe care o introduce bibliotecarul pentru sa se putea autentifica in cont
	 * @return - returneaza true daca autentificarea este valida, fals in caz contrar
	 */
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
	
	/**
	 * Aceasta metoda este folosita pentru verificarea existentei unui cont de utilizator(cititor) asociat id-ului introdus
	 *  pentru a se putea realiza ulterior autentificare in cont. Verificarea existentei se face prin interogarea bazei de date(tabla bibliotecari)
	 * @param idA - id-ul de angajat care se cauta in baza de date pentru a se verifica autentificare
	 * @return true, daca s-a gasit id-ul in baza de date(daca exista un cont de bibliotecar asociat acestui id)
	 */
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
	
	
	/**
	 * Aceasta metoda este folosita pentru schimbarea parolei pentru contul de utilizator al unui cititor. Se cauta in tabela cititori inregistrarea
	 * care are pentru atributul "cnp" egal cu valoarea parametrenui functiei si sa face inlocuitest valoare atributului "parola" cu 
	 * noua parola
	 * @param parolaNoua - noua parola pentru cont
	 * @param cnp - cnp-ul cititorului
	 */
	public static void schimbaParolaCititor(String parolaNoua, String cnp ){
		Connection connection;
		try {
			connection = DriverManager.getConnection(MainClasProiectP3Biblioteca.DB_URL,"root","Raluca_2003");
			java.sql.Statement st= connection.createStatement();
		
			String SQL_UPDATE="UPDATE cititori  SET parola ='"+parolaNoua+"' WHERE(cnp= '"+cnp+"')";
		
			st.executeUpdate(SQL_UPDATE);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();}
	}
}
