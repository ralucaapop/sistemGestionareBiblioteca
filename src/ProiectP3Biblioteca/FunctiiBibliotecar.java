package ProiectP3Biblioteca;

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

import com.mysql.cj.xdevapi.Statement;

import ProiectP3Biblioteca.Exemplar.status;
/**
 * Clasa care contine toate metodele corespunzatoare actiunilor aplicatie pentru un bibliotecar
 */
public class FunctiiBibliotecar {
	/**
	 * Metoda pentru adaugarea uneoi noi carti in binlioteca
	 */
	public static void adaugaCarteNoua() {
		
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
					System.out.print("ID-ul Cartii:");
					id=Integer.parseInt(sc.next());
						
						String SQL_SELECT = "select * from carti where idCarte='"+id+"'";
						ResultSet resultSet = st.executeQuery(SQL_SELECT);
						while(resultSet.next())
							IDValid=false;
					
						if(IDValid==false)
						{	
							System.out.println("Acest ID apartine altei carti. INCEARCA IAR\n");
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
					System.out.print("Titlul Cartii:");
					String titlu = sc.next();
					System.out.print("Genul cartii");
					String gen = sc.next();
					System.out.print("Autorul cartii");
					String autor = sc.next();
					System.out.print("Numarul de zile de imprumut al cartii");
					int nrZileImprumut = Integer.parseInt(sc.next());
					
					
					String SQL_INSERT = "INSERT INTO carti VALUES(?,?,?,?,0,0,0,?)"; 
					
					try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT)) {
					    preparedStatement.setInt(1, id);
					    preparedStatement.setString(2, titlu);
					    preparedStatement.setString(3, gen);
					    preparedStatement.setString(4, autor);
					    preparedStatement.setInt(5, nrZileImprumut);

					    int affectedRows = preparedStatement.executeUpdate();
					    if(affectedRows>0)
					    	System.out.println("Carte inregistrata cu succes.");	
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
	 * Metoda pentru adaugarea unui nou exemplar in biblioteca
	 */
	public static void adaugaExemplarNou() {
	
		
		System.out.println("Introduceti datele pentru a inregistra un nou exemplar");
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
					System.out.print("ID-ul Exemplarului:");
					id=Integer.parseInt(sc.next());
						
						String SQL_SELECT = "select * from exemplare where idExemplar='"+id+"'";
						ResultSet resultSet = st.executeQuery(SQL_SELECT);
						while(resultSet.next())
							IDValid=false;
					
						if(IDValid==false)
						{	
							System.out.println("Acest ID apartine altui exemplar. INCEARCA IAR\n");
							IDValid=true;
						}
						else if(IDValid==true)
						{
						System.out.println("ID valid, continuati\n");
							ok=true;
							break;

						}
				}
				int idCarte=0;
				boolean idCarteValid=false;
				
				if(ok==true) 
				{
					while(!idCarteValid) 
					{
						System.out.println("Introduceti ID-ul cartii pentru care adaugati un nou exemplar");
						idCarte=Integer.parseInt(sc.next());
						String SQL_SELECT1 = "select * from carti where idCarte='"+idCarte+"'";
						ResultSet resultSet1 = st.executeQuery(SQL_SELECT1);
						while(resultSet1.next())
						{
							idCarteValid=true;
							break;
						}
						if(idCarteValid==false)
							System.out.println("Acest ID nu corespunde nici unei carti, INCERCATI IAR!");
					}
					if(idCarteValid==true) {
						
						String SQL_SELECT="Select * from exemplare where idCarte = '"+idCarte+"'";
						ResultSet resultSet = st.executeQuery(SQL_SELECT);
						int nred=0;
						while(resultSet.next())
						{
							nred=resultSet.getInt("nrcd");
						}
						
						nred++;
						
						String SQL_UPDATE="UPDATE carti SET nrcd ='"+nred+"' WHERE (idCarte = '"+idCarte+"')";
						st.executeUpdate(SQL_UPDATE);
									
						String SQL_INSERT = "INSERT INTO exemplare VALUES(?,?,?)"; 
						

						try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT)) {
						    preparedStatement.setInt(1, id);
						    preparedStatement.setInt(2, idCarte);
						    preparedStatement.setString(3, "DISPONIBILA");
						    int affectedRows = preparedStatement.executeUpdate();
						    if(affectedRows>0)
						    	System.out.println("Exemplar adaugat cu succes.");	
						} catch (SQLException e) {
						    e.printStackTrace();
						}
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
	 * Metoda pentru creearea unui noi cont de cititor
	 */
	public static void adaugaCititorNou() 
	{
		
		System.out.println("Inregistreaza un cititor nou");
		boolean CNPValid=true;
		String cnp="0000000000";
		
		boolean ok=false;	
		
		try {
				Connection connection = DriverManager.getConnection(MainClasProiectP3Biblioteca.DB_URL,"root","Raluca_2003");
				java.sql.Statement st = connection.createStatement();

				try {
					Scanner sc = new Scanner(System.in);

					while(CNPValid)
					{
						System.out.print("CNP-ul Cititorului:");
						cnp=sc.next();
						if(cnp.length()==13)
							
						{
							String SQL_SELECT = "select * from cititori where CNP='"+cnp+"'";
							ResultSet resultSet = st.executeQuery(SQL_SELECT);
							while(resultSet.next())
								CNPValid=false;
						
							if(CNPValid==false)
							{	
								System.out.println("Acest CNP este deja folosit. INCEARCA IAR\n");
								CNPValid=true;
							}
							else if(CNPValid==true)
							{
							System.out.println("CNP valid, continuati\n");
								ok=true;
								break;
	
							}
						}
						else System.out.println("CNP-ul nu are lungimea corespunzatoare. Incercati iar");
					}
					if(ok==true)
					{
						System.out.println("NUMELE:");
						String nume=sc.next();
						System.out.println("NR Telefon:");
						String nrTel=sc.next();
						System.out.println("Parola:");
						String parola=sc.next();
						
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
	 * Metoda pentru alegrea id-ului exemplarului care se doreste a fi imprututat
	 * @param idCarte - id-ul cartii care se doreste a fi imprumutata
	 * @return - id-ul exemplarului
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
	 * Metoda pentru determinarea cititorului care doreste sa faca un imprumut
	 * @return un obiect de tipul Cititor
	 */
	public static Cititor determinaCititorulCareImprumutaCartea()
	{
		boolean CNPValid=false;
		String cnp="0000000000";
		Scanner sc = new Scanner(System.in);
		Cititor cit= new Cititor();
		
			try {
				Connection connection = DriverManager.getConnection(MainClasProiectP3Biblioteca.DB_URL,"root","Raluca_2003");
				java.sql.Statement st = connection.createStatement();

				try {
					while(!CNPValid)
					{
						System.out.print("CNP-ul Cititorului:");
						cnp=sc.next();
						String SQL_SELECT = "select * from cititori where CNP='"+cnp+"'";
						ResultSet resultSet = st.executeQuery(SQL_SELECT);
						while(resultSet.next())
						{
							
							System.out.println("Cititorul cu CNP-ul " + cnp+ " a fost selectat pentru rezervare.");
							String CNP = resultSet.getString("CNP");
							String nrTelefon = resultSet.getString("nrTelefon");
							String nume = resultSet.getString("nume");
							String parola = resultSet.getString("parola");
							cit = new Cititor(CNP,nrTelefon,nume, parola);
							CNPValid=true;
						}
					if(CNPValid==false)
						{	
							System.out.println("Acest CNP nu este asociat nici unui utilizator. INCEARCA IAR\n");
						}
					else if(CNPValid==true)
						System.out.println("CNP valid, continuati\n");
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
			
		return cit;
	}
	
	
	/**
	 * Metoda pentru alegerea id-ului cartii care se doreste a fi imprumutata
	 * @param carti - lista de carti din boblioteca
	 * @return - id-ul cartii
	 */
	public static int alegeIdCartePtImprumut(List<Carte> cartiPosibile)
	{
		boolean idCorect=false;
		int id=0;
		while(!idCorect)
		{
			System.out.println("Alege ID-ul cartii pe care doresti sa o imprumuti");
			Scanner sc = new Scanner(System.in);
			System.out.print("ID:");
			id=Integer.parseInt(sc.next());
			for(Carte cart: cartiPosibile) {
				if(cart.getIdCarte()==id)
					{
						if(cart.getNrExemplareDisponibile()==0)
						{
							System.out.println("Nu exista exemplare disponibile pentru aceasta carte");
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
	 * Metoda folosita pentru realizarea unui imprumut 
	 * @param cit - citiroul pentru care se reazizeaza imorumutul
	 * @param idCarte - id-ul cartii care se doreste a fi imprumutata
	 * @param idExemplar - id-ul exemplarului corespunzator cartii
	 */
	public static void realizeazaImprumutP2(Cititor cit, int idCarte, int idExemplar ) {
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
			System.out.println(nred);
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
			    preparedStatement.setString(1, cit.getCNPCititor());
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

		//Functii.scrieCarti(carti);
		//Functii.scrieImprumuturi(imprumuturi);
		//Functii.scrieExemplare(exemplare);
		System.out.println("Imprumut efectuat cu succes.");	
	}
	
	/**
	 * Metoda pentru reazlizarea imprumutului unei carti
	 */
	public static void realizeazaImprumutP1() {
		
		System.out.println("<<Imprumuta o carte>>");
		boolean carteGasita=false;
		List<Carte> carti = new ArrayList<>();
		
		while(!carteGasita) 
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Introdu titlul cautat:");
			String titlu=sc.next();
			System.out.println("Introdu autorul:");
			String autor=sc.next();
			carti=Functii.returneazaCartea(titlu,autor);
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
		int idCartePtImprumut=alegeIdCartePtImprumut(carti);
		int idExemplarPtImprumut=alegeIdExemplarPtImprumut(idCartePtImprumut);
		System.out.println(idExemplarPtImprumut);
		Cititor cititor=determinaCititorulCareImprumutaCartea();
		realizeazaImprumutP2(cititor, idCartePtImprumut, idExemplarPtImprumut);
	}
	
	/**
	 * Metoda pentru realizarea returului unui exemplar
	 */
	public static void realizeazaRetur() {
		
			try {
				Connection connection = DriverManager.getConnection(MainClasProiectP3Biblioteca.DB_URL,"root","Raluca_2003");
				java.sql.Statement st = connection.createStatement();

				try {
					boolean CNPValid=false;

					Scanner sc = new Scanner(System.in);
					String cnp="0";
					
					Cititor cit= new Cititor();
						
					while(!CNPValid)
						{
							System.out.print("CNP-ul Cititorului:");
							cnp=sc.next();
							String SQL_SELECT = "select * from cititori where CNP='"+cnp+"'";
							ResultSet resultSet = st.executeQuery(SQL_SELECT);
							while(resultSet.next())
							{
								
								System.out.println("Cititorul cu CNP-ul " + cnp+ " a fost selectat pentru returnarea unai carti.");
								String CNP = resultSet.getString("CNP");
								String nrTelefon = resultSet.getString("nrTelefon");
								String nume = resultSet.getString("nume");
								String parola = resultSet.getString("parola");
								cit = new Cititor(CNP,nrTelefon,nume, parola);
								CNPValid=true;
							}
						if(CNPValid==false)
							{	
								System.out.println("Acest CNP nu este asociat nici unui utilizator. INCEARCA IAR\n");
							}
						else if(CNPValid==true)
							System.out.println("CNP valid, continuati\n");
						}
					
					if(CNPValid) 
					{
						System.out.println("Imprumuturile acestui cititor");
						
						
						List<Integer> idExemplareImp = new ArrayList<>();
						
						System.out.println("ID Exemplar TITLU AUTOR");
						
						String SQL_SELECT = "select i.idExemplar, c.titlu, c.autor from imprumuturi i, carti c, exemplare e1 where i.cnpCititor='"
								+ ""+cit.getCNPCititor()+"'and e1.idExemplar=i.idExemplar" + " and e1.idCarte=c.idCarte";
						ResultSet resultSet = st.executeQuery(SQL_SELECT);
						
						while(resultSet.next())
						{
							System.out.println(resultSet.getInt("i.idExemplar")+" "+resultSet.getString("c.titlu")+" "+resultSet.getString("c.autor"));
							idExemplareImp.add(resultSet.getInt("i.idExemplar"));
						}
						
						boolean idExemplarCorect=false;
						int idExemplar=0;
						Scanner sc1 = new Scanner(System.in);
						
						while(!idExemplarCorect) {
							
							System.out.println("Alegeti id-ul corespunzator exemplarului pentru care doriti sa reazlizati retur");
							idExemplar=Integer.parseInt(sc1.next());
							if(idExemplareImp.contains(idExemplar))
								{
									idExemplarCorect=true;
									break;
								}
							else {System.out.print("Acest id este incorect. INCEARCA IAR");}
						}
						if(idExemplarCorect)
						{
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
							    preparedStatement.setString(2, cit.getCNPCititor());
							    preparedStatement.setInt(1, idExemplar);
							    int affectedRows = preparedStatement.executeUpdate();
							    if(affectedRows>0)
							    	System.out.println("Returnare efectuata cu succes.");
								}
							catch (SQLException e) {
						    e.printStackTrace();
							}
						}
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
	}
	

	
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


	
}
