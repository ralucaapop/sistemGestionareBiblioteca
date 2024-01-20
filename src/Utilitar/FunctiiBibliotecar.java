package Utilitar;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ProiectP3Biblioteca.MainClasProiectP3Biblioteca;
import ProiectP3Biblioteca.Exemplar.status;
/**
 * Clasa care contine toate metodele corespunzatoare actiunilor aplicatie pentru un bibliotecar
 */
public class FunctiiBibliotecar {

	/**
	 * Metoda pentru verificarea existentei id-ului unei carti in baza de date, mai exact in tabela "carti".
	 * Pentru verificare se face o interogare asupra bazei de date si se cauta o inregistrare care are id-ul egal cu paramentru functiei
	 * Daca se gaseste, atunci inseamna ca exista deja in baza de date o carte cu id-ul dorit, deci nu putem insera inca o carte cu acest id
	 * @param id - id-ul cartii pe care dorim sa il verificam 
	 * @return returneaza true daca nu s-a gasit o inregistrare cu id-ul specifica, false in caz contrar
	 */
	public static boolean verificaIdCarte(int id) {
		
		boolean IDValid=true;
		try {
			Connection connection = DriverManager.getConnection(MainClasProiectP3Biblioteca.DB_URL,"root","Raluca_2003");
			java.sql.Statement st = connection.createStatement();
			try {
					String SQL_SELECT = "select * from carti where idCarte='"+id+"'";
					ResultSet resultSet = st.executeQuery(SQL_SELECT);
					while(resultSet.next())
						IDValid=false;
						if(IDValid==false)
						{	
							System.out.println("Acest ID apartine altei carti.");
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
		return IDValid;
	}
	
	/**
	 * Aceasta metoda este folosita pentru adaugarea unei noi carti in biblioteca.
	 * Se adauga o noua inregistrare in baza de date in tabelul "carti" cu informatiile din parametrii functiei 
	 * @param id - id-ul cartii 
	 * @param titlu - titlul cartii
	 * @param autor - autorul cartii
	 * @param gen - gen cartii
	 * @param nrZile - numarul de zile pe pentru care poate fi imprumutata o carte
	 */
	public static void adaugaCarteNoua(int id, String titlu, String autor, String gen, int nrZile) {
		try {
			Connection connection = DriverManager.getConnection(MainClasProiectP3Biblioteca.DB_URL,"root","Raluca_2003");
			java.sql.Statement st = connection.createStatement();

			
				String SQL_INSERT = "INSERT INTO carti VALUES(?,?,?,?,0,0,0,?)"; 
				
				try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT)) {
				    preparedStatement.setInt(1, id);
				    preparedStatement.setString(2, titlu);
				    preparedStatement.setString(3, gen);
				    preparedStatement.setString(4, autor);
				    preparedStatement.setInt(5, nrZile);

				    int affectedRows = preparedStatement.executeUpdate();
				    if(affectedRows>0)
				    	System.out.println("Carte inregistrata cu succes.");	
				} catch (SQLException e) {
				    e.printStackTrace();
				}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	

	/**
	 * Aceasta metoda este folosita pentru a verifica daca id-ul unei carti este corect(se gaseste in baza de bate).
	 * Se realizeaza o interogare asuprea bazei de date, daca se gaseste o inregistrare care are atributul idCarte egal cu valoarea peramentrului, atunci is-ul este corec
	 * @param idCarte - id-ul pe care dorim sa il verificam
	 * @return - true, daca id-ul sa gasit in baza de date, false in caz contrar
	 */
	public static boolean verificaIdCartePtExemplar(int idCarte) {
		boolean idCarteValid=false;
		try {
			Connection connection = DriverManager.getConnection(MainClasProiectP3Biblioteca.DB_URL,"root","Raluca_2003");
			java.sql.Statement st = connection.createStatement();
			
					String SQL_SELECT1 = "select * from carti where idCarte='"+idCarte+"'";
					ResultSet resultSet1 = st.executeQuery(SQL_SELECT1);
					while(resultSet1.next())
					{
						idCarteValid=true;
						break;
					}
					
		}catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		return idCarteValid;
	}
	
	
	/**
	 * Aceasta metoda este folosita pentru a verifica daca id-ul unui exemplar este corect(se gaseste in baza de bate).
	 * Se realizeaza o interogare asuprea bazei de date(tabela exemplare), daca se gaseste o inregistrare care are atributul idExemplar egal cu valoarea peramentrului,
	 * atunci id-ul este corect
	 * @param idCarte - id-ul pe care dorim sa il verificam
	 * @return - true, daca id-ul sa gasit in baza de date, false in caz contrar
	 */
	public static boolean verificaIdExemplar(int id) {
		boolean IDValid=true;
		
		try {
			Connection connection = DriverManager.getConnection(MainClasProiectP3Biblioteca.DB_URL,"root","Raluca_2003");
			java.sql.Statement st = connection.createStatement();

				try {
					String SQL_SELECT = "select * from exemplare where idExemplar='"+id+"'";
					ResultSet resultSet = st.executeQuery(SQL_SELECT);
					while(resultSet.next())
						IDValid=false;
					
					}catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
		return IDValid;
	}
	
	/**
	 * Aceasta metoda este folosita pentru adaugarea unui nou exemplar in baza de date. Se adauga in baza de date, in tabela exemplare,
	 * o noua inregistrare care sa contina datele valorilor din parametrii 
	 * @param idE - id-ul Exemplarului
	 * @param idC - id-ul Cartii
	 */
	public static void adaugaExemplarNou(int idE, int idC) {
		try {
			
			Connection connection = DriverManager.getConnection(MainClasProiectP3Biblioteca.DB_URL,"root","Raluca_2003");
			java.sql.Statement st = connection.createStatement();
			
			String SQL_SELECT="Select * from exemplare where idCarte = '"+idC+"'";
			ResultSet resultSet = st.executeQuery(SQL_SELECT);
			int nred=0;
			while(resultSet.next())
				nred=resultSet.getInt("nrcd");
			
			nred++;
			
			String SQL_UPDATE="UPDATE carti SET nrcd ='"+nred+"' WHERE (idCarte = '"+idC+"')";
			st.executeUpdate(SQL_UPDATE);
						
			String SQL_INSERT = "INSERT INTO exemplare VALUES(?,?,?)"; 
			

			try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT)) {
			    preparedStatement.setInt(1, idE);
			    preparedStatement.setInt(2, idC);
			    preparedStatement.setString(3, "DISPONIBILA");
			    int affectedRows = preparedStatement.executeUpdate();
			    if(affectedRows>0)
			    	System.out.println("Exemplar adaugat cu succes.");	
			} catch (SQLException e) {
			    e.printStackTrace();
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * Aceasta metoda este folosita pentru verificarea lungimii cnp-ului, daca acesta este diferit de 13, atunci cenp-ul nu este valid
	 * @param cnp - valoarea atributului care trebuie verificat
	 * @return - returneaza true daca lungimea este corect, false in caz contrar 
	 */
	public static boolean verLungimeCnp(String cnp) {
		boolean CNPValid=true;
		if(cnp.length()!=13)
			CNPValid=false;
		return CNPValid;
	}
	
	/**
	 * Aceasta metoda verifica daca cnp-ul pe care doreste utilizatorul sa il foloseasca pentru creearea unui nou cont este corect sau nu.
	 * Se cauta in baza de date(tabela cititori) daca exista o inregistrare pentru care atributul "cnp" sa fie egal cu valoarea parametrului, 
	 * in caz afirmativ, cnp-ul trimis pentru validare va fi respins, intucat oentru creearea unui cont cnp-ul trebuie sa fie unic
	 * (sa nu existe 2 inregistrari cu acelasi cnp) 
	 * @param cnp - valoarea cnp-ului trimisa spre validare
	 * @return- true, daca cnp-ul nu a fost gasit in baza de date, false in caz contrar
	 */
	public static boolean cnpValidPtInregistrare(String cnp)
	{
		boolean CNPValid=true;
		try {
			Connection connection = DriverManager.getConnection(MainClasProiectP3Biblioteca.DB_URL,"root","Raluca_2003");
			java.sql.Statement st = connection.createStatement();

			try {

						String SQL_SELECT = "select * from cititori where CNP='"+cnp+"'";
						ResultSet resultSet = st.executeQuery(SQL_SELECT);
						while(resultSet.next())
							CNPValid=false;
					
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	 }
		return CNPValid;
	}
	
	/**
	 * Aceasta metoda este folosita pentru creearea unui nou cont de cititor. Se adauga in baza de date, in tabela cititori,
	 * o noua inregistrare care sa contina datele valorilor din parametrii 
	 * @param cnp - cn-ul cititorului
	 * @param nume - numele cititorului
	 * @param nrTel - numarul de telefon
	 * @param parola - parola asociata contului
	 */
	public static void adaugaCititorNou(String cnp,String nume, String nrTel, String parola ) {
		try {
			Connection connection = DriverManager.getConnection(MainClasProiectP3Biblioteca.DB_URL,"root","Raluca_2003");
			java.sql.Statement st = connection.createStatement();
			String SQL_INSERT = "INSERT INTO cititori VALUES(?,?,?,?)"; 
			
			try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT)) {
			    preparedStatement.setString(1, cnp);
			    preparedStatement.setString(2, nume);
			    preparedStatement.setString(3, nrTel);
			    preparedStatement.setString(4, parola);

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
	 * Metoda pentru alegrea id-ului exemplarului care se doreste a fi imprututat. Se cauta in tabela exemplare, acele inregistrari care
	 * au ca si atribut in coloana idCarte, id-ul cartii trimise ca parametru si care au statusul "disponibila".
	 * In momentul in care se gaseste primul exemplar disponibil, atunci acel exemplar va fi selectat pentru a fi dat spre imprumut
	 * @param idCarte - id-ul cartii care se doreste a fi imprumutata
	 * @return - id-ul exemplarului ales pentru imprumut
	 */
	public static int alegeIdExemplarPtImprumut(int idCarte) {
		
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
						System.out.println("Exemplarul cu id-ul " + id+ " a fost selectat pentru imprumut.");
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
	 * Aceasta metoda este folosita pentru validarea cnp-ului unui cititor in momentul in care acesta doreste sa imprumute o carte.
	 * Se cauta in tabela "cititori" inregistrarea cu atributul cnp egal cu valoarea transmisa ca parametru functiei.
	 * Daca nu se gaseste o astfel de inregistrare, atunci inseamna ca cititorul nu are creat un cont, deci nu poate sa faca imprumuturi
	 * @param cnp - cnp-ul transmis spre valisare
	 * @return - true, daca cnp-ul a fost gasit, false in caz contrar
	 */
	public static boolean verificaCnpPtImprumut(String cnp) {
		boolean CNPValid=false;
		try {
			Connection connection = DriverManager.getConnection(MainClasProiectP3Biblioteca.DB_URL,"root","Raluca_2003");
			java.sql.Statement st = connection.createStatement();

			try {
					String SQL_SELECT = "select * from cititori where CNP='"+cnp+"'";
					ResultSet resultSet = st.executeQuery(SQL_SELECT);
					while(resultSet.next())
						CNPValid=true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
		}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
		return CNPValid;
	}
	
	

	/**
	 * Metoda folosita pentru realizarea unui imprumut. Se adauga in baza de date noi informtii: in tabela "imprumuturi" se adauga o noua inregistrare
	 * care contine datele despre un nou imprumut. Se mofifica numarul de carti disponibile si numarul de carti imprumutate pentru carte care este imprumutata,
	 * se modifica statusul exemplarului din"disponibila" in "rezervata"
	 * @param cit - citiroul pentru care se reazizeaza imorumutul
	 * @param idCarte - id-ul cartii care se doreste a fi imprumutata
	 * @param idExemplar - id-ul exemplarului corespunzator cartii
	 */
	public static void realizeazaImprumutP2(String cnp, int idCarte, int idExemplar ) {
		Connection connection;
		try {
			connection = DriverManager.getConnection(MainClasProiectP3Biblioteca.DB_URL,"root","Raluca_2003");
			java.sql.Statement st= connection.createStatement();
			String SQL_SELECT="Select * from carti where idCarte = '"+idCarte+"'";
			ResultSet resultSet = st.executeQuery(SQL_SELECT);
			int nred=0;
			int nrei=0;
			while(resultSet.next())
			{
				nred=resultSet.getInt("nrcd");
				nrei=resultSet.getInt("nrci");
			}
			nred--;
			nrei++;
			String SQL_UPDATE="UPDATE carti SET nrcd ='"+nred+"' WHERE (idCarte = '"+idCarte+"')";
			String SQL_UPDATE2="UPDATE carti SET nrci ='"+nrei+"' WHERE (idCarte = '"+idCarte+"')";
			
			String SQL_UPDATE1="UPDATE exemplare SET status='IMPRUMUTATA' WHERE (idExemplar = '"+idExemplar+"')";
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			//String SQL_INSERT ="INSERT INTO imprumuturi values('"+cit.getCNPCititor()+"','"+idExemplar+"','"+LocalDate.now().format(formatter)+"'";
			st.executeUpdate(SQL_UPDATE);
			st.executeUpdate(SQL_UPDATE1);
			st.executeUpdate(SQL_UPDATE2);
			//st.executeUpdate(SQL_INSERT);
			
			String SQL_INSERT = "INSERT INTO imprumuturi VALUES (?, ?, ?)";

			try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT)) {
			    preparedStatement.setString(1, cnp);
			    preparedStatement.setInt(2, idExemplar);
			    preparedStatement.setString(3, LocalDate.now().format(formatter));

			    int affectedRows = preparedStatement.executeUpdate();
			    if (affectedRows > 0) {
			        System.out.println("Insert successful. Rows affected: " + affectedRows);
			    } else {
			        System.out.println("No rows inserted.");
			    }
			} catch (SQLException e) {
			    e.printStackTrace();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		System.out.println("Imprumut efectuat cu succes.");	
	}
	
	/**
	 * Aceasta metoda verifica daca id-ul exemplarului ales pentru retuR se gaseste in lista de exemplare pe care cititorul le-a imprumutat.
	 * @param imprumuturi - lista de exemplare imprumutata de catre cititor
	 * @param id - id-ul exemplarului pe care doreste sa il returneze
	 * @return - true- daca id-ul se afla in lista de imprumuturi, false in caz contrar
	 */
	public static boolean verificaIdExemplarAlesPtRetur(List<AfisareImprumutri> imprumuturi, int id) {
		
		boolean idExemplarCorect=false;
		for(AfisareImprumutri r: imprumuturi)
			if(r.getIdE()==id)
				{
					idExemplarCorect=true;
					break;
				}
			
		return idExemplarCorect;
	}

	/**
	 *  Metoda folosita pentru realizarea unui retur. Se adauga in baza de date noi informtii: in tabela "imprumuturi" se sterge inregistrarea
	 * care contine datele despre exemplarul care se returneza si cnp-ul cititorului. Se mofifica numarul de carti disponibile si numarul de carti imprumutate pentru carte care este imprumutata,
	 * se modifica statusul exemplarului din"imprumutata" in "disponibila"
	 * @param cnp - cnp-ul cititorului care face retur
	 * @param idExemplar - id-ul Exemplarului care se returneza
	 */
	public static void realizeazaRetur(String cnp, int idExemplar) {
		try {
			Connection connection = DriverManager.getConnection(MainClasProiectP3Biblioteca.DB_URL,"root","Raluca_2003");
			java.sql.Statement st = connection.createStatement();
			String SQL_SELECT1="Select * from exemplare where idExemplar = '"+idExemplar+"'";
			ResultSet resultSet1 = st.executeQuery(SQL_SELECT1);
			
			int idCarte=0;
			while(resultSet1.next())
			{
				idCarte=resultSet1.getInt("idCarte");
			}
			
			String SQL_SELECT2="Select * from carti where idCarte = '"+idCarte+"'";
			ResultSet resultSet2 = st.executeQuery(SQL_SELECT2);
			int nred=0;
			int nrei=0;
			while(resultSet2.next())
			{
				nred=resultSet2.getInt("nrcd");
				nrei=resultSet2.getInt("nrci");
			}
			
			nred++;
			nrei--;
			String SQL_UPDATE="UPDATE carti SET nrcd ='"+nred+"' WHERE (idCarte = '"+idCarte+"')";
			String SQL_UPDATE2="UPDATE carti SET nrci ='"+nrei+"' WHERE (idCarte = '"+idCarte+"')";
			
			String SQL_UPDATE1="UPDATE exemplare SET status='DISPONIBILA' WHERE (idExemplar = '"+idExemplar+"')";
			
			st.executeUpdate(SQL_UPDATE);
			st.executeUpdate(SQL_UPDATE1);
			st.executeUpdate(SQL_UPDATE2);
			
			String SQL_DELETE = "DELETE FROM imprumuturi WHERE idExemplar=? and cnpCititor=?";

			try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE)) {
			    preparedStatement.setString(2, cnp);
			    preparedStatement.setInt(1, idExemplar);
			    int affectedRows = preparedStatement.executeUpdate();
			    if(affectedRows>0)
			    	System.out.println("Returnare efectuata cu succes.");
				}
			catch (SQLException e) {
		    e.printStackTrace();
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

	/**
	 * Aceasta metoda este folosita pentru revizuirea tututor rezervarilor.
	 * Se cauta in tabela "rezervari" tate inregistralie care au fost efectuat de mai mult de doua zile(se verifica data rezervarii) si se sterg din baza de date.
	 se modifica status-ul exemplarelor respective si numaru de carti disponibile si rezervate.
	 */
	public static void revizuiesteRezervari() {
	    try {
	        Connection connection = DriverManager.getConnection(MainClasProiectP3Biblioteca.DB_URL, "root", "Raluca_2003");
	        java.sql.Statement st = connection.createStatement();

	        LocalDate currentDate = LocalDate.now();
	        String SQL_SELECT = "SELECT * FROM rezervari";
	        ResultSet resultSet = st.executeQuery(SQL_SELECT);

	        while (resultSet.next()) {
	            Date sqlDate = resultSet.getDate("dataRezervare");
	            LocalDate storedDate = sqlDate.toLocalDate();

	            int idExemplar = resultSet.getInt("idExemplar");
	            String cnp = resultSet.getString("cnpCititor");

	            long daysBetween = ChronoUnit.DAYS.between(storedDate, currentDate);
	            if (daysBetween > 2) {
	                try  {
	                	java.sql.Statement st1 = connection.createStatement();
	                    String SQL_SELECT1 = "SELECT * FROM exemplare WHERE idExemplar = '" + idExemplar + "'";
	                    ResultSet resultSet1 = st1.executeQuery(SQL_SELECT1);

	                    int idCarte = 0;
	                    while (resultSet1.next()) {
	                        idCarte = resultSet1.getInt("idCarte");
	                    }

	                    String SQL_SELECT2 = "SELECT * FROM carti WHERE idCarte = '" + idCarte + "'";
	                    ResultSet resultSet2 = st1.executeQuery(SQL_SELECT2);
	                    int nred = 0;
	                    int nrer = 0;

	                    while (resultSet2.next()) {
	                        nred = resultSet2.getInt("nrcd");
	                        nrer = resultSet2.getInt("nrcr");
	                    }

	                    nred++;
	                    nrer--;

	                    String SQL_UPDATE = "UPDATE carti SET nrcd ='" + nred + "' WHERE idCarte = '" + idCarte + "'";
	                    String SQL_UPDATE2 = "UPDATE carti SET nrcr ='" + nrer + "' WHERE idCarte = '" + idCarte + "'";
	                    String SQL_UPDATE1 = "UPDATE exemplare SET status='DISPONIBILA' WHERE idExemplar = '" + idExemplar + "'";

	                    st1.executeUpdate(SQL_UPDATE);
	                    st1.executeUpdate(SQL_UPDATE2);
	                    st1.executeUpdate(SQL_UPDATE1);

	                    String SQL_DELETE = "DELETE FROM rezervari WHERE idExemplar = ? AND cnpCititor = ?";

	                    try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE)) {
	                        preparedStatement.setInt(1, idExemplar);
	                        preparedStatement.setString(2, cnp);
	                        preparedStatement.executeUpdate();
	                        
	                    } catch (SQLException e) {
	                        e.printStackTrace();
	                    }
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


	/**
	 * Aceasta metoda este folosita pentru afisarea tututor imprumuturilor unui cititor. Se cauta in tabela imrumuturi toate inregistrarile
	 * care au pentru atributul cnp valoarea egala cu cea trimisa ca parametru functiei si se adauga in lista.
	 * @param cnp - cenp-ul cititorului pentru care vrem sa aflam imprumuturile
	 * @return - lista de imorumuturi ale cititorului
	 */
	public static List<AfisareImprumutri> gasesteImprumuturileCititorului(String cnp){
		
		List<AfisareImprumutri> imprumuturi = new ArrayList<>();
		try {
			Connection connection = DriverManager.getConnection(MainClasProiectP3Biblioteca.DB_URL,"root","Raluca_2003");
			java.sql.Statement st = connection.createStatement();

			try {
				String SQL_SELECT = "select i.idExemplar, c.titlu, c.autor from imprumuturi i, carti c, exemplare e1 where i.cnpCititor='"
						+ ""+cnp+"'and e1.idExemplar=i.idExemplar" + " and e1.idCarte=c.idCarte";
				ResultSet resultSet = st.executeQuery(SQL_SELECT);
				while(resultSet.next())
					{
						System.out.println(resultSet.getInt("i.idExemplar")+" "+resultSet.getString("c.titlu")+" "+resultSet.getString("c.autor"));
						AfisareImprumutri r= new AfisareImprumutri(resultSet.getInt("i.idExemplar"),resultSet.getString("c.titlu"),resultSet.getString("c.autor"));
						imprumuturi.add(r);
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
		return imprumuturi;

	}
	
	/**
	 * Aceasta metoda este folosita pentru schimbarea parolei pentru contul de utilizator al unui bibliotecar. Se cauta in tabela bibliotecari inregistrarea
	 * care are pentru atributul "idAngajat" egal cu valoarea parametrenui functiei si sa face inlocuitest valoare atributului "parola" cu 
	 * noua parola
	 * @param parolaNoua - noua parola pentru cont
	 * @param idAngajat - id-ul bibliotecarului
	 */
	public static void schimbaParolaBibliotecar(String parolaNoua, int idAngajat ){
		Connection connection;
		try {
			connection = DriverManager.getConnection(MainClasProiectP3Biblioteca.DB_URL,"root","Raluca_2003");
			java.sql.Statement st= connection.createStatement();
		
			String SQL_UPDATE="UPDATE bibliotecari  SET parola ='"+parolaNoua+"' WHERE(idAngajat= '"+idAngajat+"')";
		
			st.executeUpdate(SQL_UPDATE);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();}
	}
}