package ProiectP3Biblioteca;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ProiectP3Biblioteca.Exemplar.status;

/**
 * Clasa pentru definirea tuturor metodelor folosite in aplicatie de catre un cititor + cititri si scrierei in fisiere
 */

public class Functii {

	/**
	 * Metoda pentru citirea cartilor din fisier
	 * @return lista cu obiecte de tip carte
	 */
	public static ArrayList<Carte> citireCarti()
	{
		ArrayList<Carte> carti= new ArrayList<>();
		
		File fisierCarti= new File("C:\\Users\\Raluca\\OneDrive - e-uvt.ro\\fac\\anul2\\p3-proiect-sg1-ralucaapop\\src\\carti.txt");
		try {
			Scanner sc = new Scanner(fisierCarti);
			while(sc.hasNext())
			{
				String linie = sc.next();
				String[] p= linie.split(";");
				Carte c= new Carte(Integer.parseInt(p[0]), p[1], p[2], p[3],Integer.parseInt(p[4]),Integer.parseInt(p[5]), Integer.parseInt(p[6]),Integer.parseInt(p[7]));
				carti.add(c);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		return carti;
	}
	/**
	 * Metoda pentru citirea cititorilor din fisier
	 * @return lista cu obiecte de tip cititor
	 */
	public static ArrayList<Cititor> citireCititori()
	{
		ArrayList<Cititor> cititori= new ArrayList<>();
		
		File fisierCititori = new File("C:\\Users\\Raluca\\OneDrive - e-uvt.ro\\fac\\anul2\\p3-proiect-sg1-ralucaapop\\src\\cititori.txt");
		try {
			Scanner sc = new Scanner(fisierCititori);
			while(sc.hasNext())
			{
				String linie = sc.next();
				String[] p= linie.split(";");
				Cititor c= new Cititor(p[0], p[1], p[2],p[3]);
				cititori.add(c);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		return cititori;
	}
	
	/**
	 * Metoda pentru citirea bibliotecarilor din fisier
	 * @return lista cu obiecte de tip bibliotecar
	 */
	public static ArrayList<Bibliotecar> citireBibliotecari()
	{
		ArrayList<Bibliotecar> bibliotecari= new ArrayList<>();
		
		File fisierBibliotecari= new File("C:\\Users\\Raluca\\OneDrive - e-uvt.ro\\fac\\anul2\\p3-proiect-sg1-ralucaapop\\src\\bibliotecari.txt");
		try {
			Scanner sc = new Scanner(fisierBibliotecari);
			while(sc.hasNext())
			{
				String linie = sc.next();
				String[] p= linie.split(";");
				Bibliotecar b= new Bibliotecar(p[0], p[1], p[2], Integer.parseInt(p[3]),p[4]);
				bibliotecari.add(b);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		return bibliotecari;
	}
	
	/**
	 * Metoda pentru citirea exemplarelor din fisier
	 * @return lista cu obiecte de tip exemplar
	 */
	public static ArrayList<Exemplar> citireExemplar()
	{
		ArrayList<Exemplar> exemplare= new ArrayList<>();
		
		File fisierExemplare= new File("C:\\Users\\Raluca\\OneDrive - e-uvt.ro\\fac\\anul2\\p3-proiect-sg1-ralucaapop\\src\\exemplare.txt");
		try {
			Scanner sc = new Scanner(fisierExemplare);
			while(sc.hasNext())
			{
				String linie = sc.next();
				String[] p= linie.split(";");
				if(p[2].equals("DISPONIBILA"))
					{
						Exemplar b= new Exemplar(Integer.parseInt(p[0]), Integer.parseInt(p[1]),status.DISPONIBILA);
						exemplare.add(b);
					}
				else if(p[2].equals("REZERVATA"))
				{
					Exemplar b= new Exemplar(Integer.parseInt(p[0]), Integer.parseInt(p[1]),status.REZERVATA);
					exemplare.add(b);
				}
				else if(p[2].equals("IMPRUMUTATA"))
				{
					Exemplar b= new Exemplar(Integer.parseInt(p[0]), Integer.parseInt(p[1]),status.IMPRUMUTATA);
					exemplare.add(b);
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		return exemplare;
	}
	
	/**
	 * Metoda pentru citirea cartilor imprumutate din fisier
	 * @return lista cu obiecte de tip imprumut
	 */
	public static ArrayList<Imprumut> citireImprumuturi()
	{
		ArrayList<Imprumut> imprumuturi= new ArrayList<>();
		
		File fisierImprumuturi= new File("C:\\Users\\Raluca\\OneDrive - e-uvt.ro\\fac\\anul2\\p3-proiect-sg1-ralucaapop\\src\\imprumuturi.txt");
		try {
			Scanner sc = new Scanner(fisierImprumuturi);
			while(sc.hasNext())
			{
				String linie = sc.next();
				String[] p= linie.split(";");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				Imprumut b= new Imprumut( Integer.parseInt(p[0]), p[1], LocalDate.parse(p[2], formatter));
				imprumuturi.add(b);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		return imprumuturi;
	}
	
	/**
	 * Metoda pentru citirea cartilor rezervate din fisier
	 * @return lista cu obiecte de tip rezervare
	 */
	public static ArrayList<Rezervare> citireRezervari()
	{
		ArrayList<Rezervare> rezervari= new ArrayList<>();
		
		File fisierRezervari= new File("C:\\Users\\Raluca\\OneDrive - e-uvt.ro\\fac\\anul2\\p3-proiect-sg1-ralucaapop\\src\\rezervari.txt");
		try {
			Scanner sc = new Scanner(fisierRezervari);
			while(sc.hasNext())
			{
				String linie = sc.next();
				String[] p= linie.split(";");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				Rezervare b= new Rezervare(p[0], Integer.parseInt(p[1]), LocalDate.parse(p[2], formatter));
				rezervari.add(b);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		return rezervari;
	}
	
	/**
	 * Metoda pentru scrierea obiectelor de tip rezervare in fisier
	 * @param rezervari- lista de rezervari
	 */
	public static void scrieRezervari(List<Rezervare> rezervari)
	{
		 try {
			FileWriter myWriter = new FileWriter("C:\\Users\\Raluca\\OneDrive - e-uvt.ro\\fac\\anul2\\p3-proiect-sg1-ralucaapop\\src\\rezervari.txt");
			for(Rezervare r: rezervari)
			{
				StringBuilder sb = new StringBuilder();
				sb.append(r.getCNPCititor());
				sb.append(";");
				sb.append(r.getIdExemplar());
				sb.append(";");
				sb.append(r.getDataRezervare());
				sb.append("\n");
				myWriter.write(sb.toString());
				
			}
			myWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Metoda pentru scrierea obiectelor de tip exemplar in fisier
	 * @param exemplare- lista de exemplare
	 */
	public static void scrieExemplare(List<Exemplar> exemplare)
	{
		 try {
			FileWriter myWriter = new FileWriter("C:\\Users\\Raluca\\OneDrive - e-uvt.ro\\fac\\anul2\\p3-proiect-sg1-ralucaapop\\src\\exemplare.txt");
			for(Exemplar e: exemplare)
			{
				StringBuilder sb = new StringBuilder();
				sb.append(e.getIdExemplar());
				sb.append(";");
				sb.append(e.getIdCarte());
				sb.append(";");
				sb.append(e.getStatusExemplar());
				sb.append("\n");
				myWriter.write(sb.toString());
			}
			myWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Metoda pentru scrierea obiectelor de tip imprumut in fisier
	 * @param imprumuturi - lista de imprumuturi
	 */
	public static void scrieImprumuturi(List<Imprumut> imprumuturi)
	{
		 try {
			FileWriter myWriter = new FileWriter("C:\\Users\\Raluca\\OneDrive - e-uvt.ro\\fac\\anul2\\p3-proiect-sg1-ralucaapop\\src\\imprumuturi.txt");
			for(Imprumut i: imprumuturi)
			{
				StringBuilder sb = new StringBuilder();
				sb.append(i.getIdExemplar());
				sb.append(";");
				sb.append(i.getCNPCititor());
				sb.append(";");
				sb.append(i.getDataImprumut());
				sb.append("\n");
				myWriter.write(sb.toString());
			}
			myWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Metoda pentru scrierea obectelor de tip carte in fisier
	 * @param carti - lista de carti
	 */
	public static void scrieCarti(List<Carte> carti)
	{
		 try {
			FileWriter myWriter = new FileWriter("C:\\Users\\Raluca\\OneDrive - e-uvt.ro\\fac\\anul2\\p3-proiect-sg1-ralucaapop\\src\\carti.txt");
			for(Carte c: carti)
			{
				StringBuilder sb = new StringBuilder();
				sb.append(c.getIdCarte());
				sb.append(";");
				sb.append(c.getTitlu());
				sb.append(";");
				sb.append(c.getGen());
				sb.append(";");
				sb.append(c.getAutor());
				sb.append(";");
				sb.append(c.getNrExemplareImprumutate());
				sb.append(";");
				sb.append(c.getNrExemplareDisponibile());
				sb.append(";");
				sb.append(c.getNrExemplareRezervate());
				sb.append(";");
				sb.append(c.getNrZileImprumut());
				sb.append("\n");
				myWriter.write(sb.toString());
			}
			myWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Metoda pentru scrierea obiectelor de tip cititor in fisier
	 * @param cititori - lista de cititori
	 */
	public static void scrieCititori(List<Cititor> cititori)
	{
		 try {
			FileWriter myWriter = new FileWriter("C:\\Users\\Raluca\\OneDrive - e-uvt.ro\\fac\\anul2\\p3-proiect-sg1-ralucaapop\\src\\cititori.txt");
			for(Cititor c: cititori)
			{
				StringBuilder sb = new StringBuilder();
				sb.append(c.getCNPCititor());
				sb.append(";");
				sb.append(c.getNume());
				sb.append(";");
				sb.append(c.getNrTelefon());
				sb.append(";");
				sb.append(c.getParola());
				sb.append("\n");
				myWriter.write(sb.toString());
			}
			myWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Metoda pentru scrierea obiectelor de tip bibliotecar
	 * @param bibliotecari - lista de bibliotecari
	 */
	public static void scrieBibliotecari(List<Bibliotecar> bibliotecari)
	{
		 try {
			FileWriter myWriter = new FileWriter("C:\\Users\\Raluca\\OneDrive - e-uvt.ro\\fac\\anul2\\p3-proiect-sg1-ralucaapop\\src\\cititori.txt");
			for(Bibliotecar b: bibliotecari)
			{
				StringBuilder sb = new StringBuilder();
				sb.append(b.getEmail());
				sb.append(";");
				sb.append(b.getNume());
				sb.append(";");
				sb.append(b.getNrTelefon());
				sb.append(";");
				sb.append(b.getIdBibliotecar());
				sb.append(";");
				sb.append(b.getParolaBibliotecar());
				sb.append(";");
				sb.append("\n");
				myWriter.write(sb.toString());
			}
			myWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Metoda pentru autentificarea in aplicatie a unui cititor
	 * @param sc - un obiect de tip Scanner
	 */
	public static void actiuniCititor(Scanner sc)
	{
		boolean autentificare_corecta = false;
		List<Cititor> cititori = new ArrayList<>();
		cititori=Functii.citireCititori();
		String cnp="nec";
		String parola="nec";
		
		while(!autentificare_corecta)
		{
			System.out.println("Intra in contul tau\nIntrodu CNP-ul si parola pentru a te putea loga");
			int ok=1;
			System.out.print("CNP:");
			cnp = sc.next();
			System.out.print("PAROLA:");
			parola = sc.next();
			
			boolean cnpValid=false;
			boolean parolaValida=false;

			Cititor c = new Cititor(cnp,parola);
			for(Cititor cit: cititori)
				{	
					if(cit.getCNPCititor().equals(c.getCNPCititor()))
					{	
						cnpValid=true;
						if(cit.getParola().equals(c.getParola()))
						{	
							autentificare_corecta=true;
							parolaValida=true;
						}
						break;
					}
				}
			if(cnpValid==true && parolaValida==false)
				System.out.println("Parola incorecta, incearca iar");
			else if(cnpValid==false)
				System.out.println("CNP invalid, nu exista un utilizator inregistrat cu acest CNP, mai incearca/n");
			else 
				System.out.println("Autentificare cu succes"); 
		}
		if(autentificare_corecta)
		{
			Cititor c = new Cititor(cnp,parola);
			optiuniCititor(c);
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
		List<Carte> cartiPosibile = new ArrayList<>();
		List<Carte> carti = new ArrayList<>();
		carti=Functii.citireCarti();
		for(Carte c: carti)
			if(c.getTitlu().equals(titlu)&&c.getAutor().equals(autor)&&c.getNrExemplareDisponibile()>0)
				cartiPosibile.add(c);
		return cartiPosibile;
	}
	
	/**
	 * Metoda pentru alegerea id-ului cartii pentru rezervare
	 * @param carti - lista de carti din care se poate alege
	 * @return - id-ul cartii
	 */
	public static int alegeIdCartePtRezervare(List<Carte> carti)
	{
		boolean idCorect=false;
		int id=0;
		while(!idCorect)
		{
			System.out.println("Alege ID-ul cartii pe care doresti sa o rezervi");
			Scanner sc = new Scanner(System.in);
			System.out.print("ID:");
			id=Integer.parseInt(sc.next());
			for(Carte cart: carti) {
				if(cart.getIdCarte()==id)
					{
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
		
		List<Exemplar> exemplare = new ArrayList<>();
		exemplare=Functii.citireExemplar();
		int id=0;
		
		for(Exemplar e: exemplare)
			if(e.getIdCarte()==idCarte&&e.getStatusExemplar().equals(status.DISPONIBILA))
				{
					id=e.getIdExemplar();
					break;
				}
		System.out.println("Exemplarul cu id-ul " + id+ " a fost selectat pentru rezervare.");
		return  id;
	}

	/**
	 * Metoda pentru realizarea unei rezervari pentru un exemplar
	 * @param cit - obect de tip cititor care face rezervarea
	 * @param idCarte - id-ul cartii rezervate
	 * @param idExemplar - id-ul exemplarului rezervat
	 */
	public static void realizeazaRezervare(Cititor cit, int idCarte, int idExemplar ) {
		Rezervare rez = cit.rezervaExemplar(idExemplar);
		
		List<Rezervare> rezervari = new ArrayList<>(); 
		rezervari=Functii.citireRezervari();
		rezervari.add(rez);
		
		List<Carte> carti = new ArrayList<>();
		List<Exemplar> exemplare = new ArrayList<>();
		
		carti=Functii.citireCarti();
		exemplare=Functii.citireExemplar();
		
		for(Exemplar e: exemplare)
			if(e.getIdExemplar()==idExemplar)
				{	
					e.setStatus(status.REZERVATA);
					break;
				}
		
		for(Carte c: carti)
			if(c.getIdCarte()==idCarte)
				{	
					c.setNrExemplareDisponibile(c.getNrExemplareDisponibile()-1);
					c.setNrExemplareRezervate(c.getNrExemplareRezervate()+1);
					break;
				}
		scrieCarti(carti);
		scrieRezervari(rezervari);
		scrieExemplare(exemplare);
		System.out.println("Rezervare efectuata cu succes.");	
		
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
			Scanner sc = new Scanner(System.in);
			System.out.println("Introdu titlul cautat:");
			String titlu=sc.next();
			System.out.println("Introdu autorul:");
			String autor=sc.next();
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
	public static void anuleazaRezervare(Cititor cit) {
		
		List<Rezervare> rezervari = new ArrayList<>(); 
		rezervari=Functii.citireRezervari();
		
		String cnpCititor=cit.getCNPCititor();
		
		System.out.println("Rezervarile tale");
		
		
		List<Exemplar> exemplare = new ArrayList<>();
		exemplare=Functii.citireExemplar();
		
		List<Carte> carti = new ArrayList<>();
		carti=Functii.citireCarti();
		
		List<Integer> idExemplareRez = new ArrayList<>();
		
		System.out.println("ID Exemplar TITLU AUTOR");
		
		for(Rezervare i:rezervari)
		{
			if(i.getCNPCititor().equals(cnpCititor))
				for(Exemplar e:exemplare)
					if(e.getIdExemplar()==i.getIdExemplar())
						for(Carte cart:carti)
							if(cart.getIdCarte()==e.getIdCarte())
								{
									System.out.println(e.getIdExemplar() + " " + cart.afiseazaTitluAutro());
									idExemplareRez.add(e.getIdExemplar());
								}
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
			for(Rezervare i: rezervari)
				if(i.getIdExemplar()==idExemplar)
					{
						rezervari.remove(i);
						break;
					}
			
			int idCarte=0;
			for(Exemplar e:exemplare)
				if(e.getIdExemplar()==idExemplar)
				{
					e.setStatus(status.DISPONIBILA);
					idCarte=e.getIdCarte();
					break;
				}
			
			for(Carte c:carti) 
				if(c.getIdCarte()==idCarte)
				{
					c.setNrExemplareDisponibile(c.getNrExemplareDisponibile()+1);
					c.setNrExemplareRezervate(c.getNrExemplareRezervate()-1);
					break;
				}
			Functii.scrieCarti(carti);
			Functii.scrieExemplare(exemplare);
			Functii.scrieRezervari(rezervari);
			System.out.println("Rezervare anulata cu Succes");
		}
	
} 
	/**
	 * Metoda pentru alegerea actiunilor din aplicatie pentru rolul de Bibliotecar
	 * @param sc
	 */
	public static void actiuniBibliotecar(Scanner sc)
	{
		boolean autentificare_corecta = false;
		List<Bibliotecar> bibliotecari = new ArrayList<>();
		bibliotecari=Functii.citireBibliotecari();
		
		while(!autentificare_corecta)
		{
			System.out.println("\nIntra in contul tau\nIntrodu nr de angajat si parola pentru a te putea loga");
			int ok=1;
			System.out.print("Nr Angajat:");
			int id = Integer.parseInt(sc.next());
			System.out.print("PAROLA:");
			String parola = sc.next();
			
			boolean idValid=false;
			boolean parolaValida=false;

			Bibliotecar b = new Bibliotecar(id,parola);
			for(Bibliotecar bib:bibliotecari )
				{	
					if(bib.getIdBibliotecar()==b.getIdBibliotecar())
					{	
						idValid=true;
						if(bib.getParolaBibliotecar().equals(b.getParolaBibliotecar()))
						{	
							autentificare_corecta=true;
							parolaValida=true;
						}
						break;
					}
				}
			if(idValid==true && parolaValida==false)
				System.out.println("Parola incorecta, incearca iar");
			else if(idValid==false)
				System.out.println("CNP invalid, nu exista un utilizator inregistrat cu acest CNP, mai incearca/n");
			else System.out.println("Autentificare cu succes"); 
		}
		if(autentificare_corecta==true)
		{
			int alegere=0;
			while(alegere<1||alegere>6)
			{	
				System.out.println("\nACTIUNI POSIBILE:\n1.Adauga o carte noua\n2.Adauga un exemplar nou\n3.Adauga un nou cititor\n4.Realizeaza un imprumut\n5.Realizeaza un retur\n6.EXIT");
				Scanner sc1 = new Scanner(System.in);
				System.out.print("Alege NUMARUL actiunii dorite:");
				alegere=Integer.parseInt(sc1.next());
				
				if(alegere<0||alegere>5)
					System.out.println("ALEGERE INVALIDA. Trebuie sa selectati un numar din intervalul 1-6");
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
				System.exit(0);
		}
	}
	
}
