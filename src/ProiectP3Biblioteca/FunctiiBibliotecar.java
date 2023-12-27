package ProiectP3Biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ProiectP3Biblioteca.Exemplar.status;

public class FunctiiBibliotecar {
	
	public static void adaugaCarteNoua() {
		
		List<Carte> carti = new ArrayList<>();
		carti=Functii.citireCarti();
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Introduceti datele pentru a inregistra o noua carte");
		boolean idValid=true;
		boolean ok=false;
		int id=0;
		while(idValid)
		{	
			System.out.print("ID-ul Cartii:");
			id=Integer.parseInt(sc.next());
			for(Carte c: carti)
				if(c.getIdCarte()==id)
					{
						idValid=false;
						break;
					}
			if(idValid==false)
				{	
					System.out.println("Acesta nu este un id valid. INCEARCA IAR\n");
					idValid=true;
				}
			else if(idValid==true)
			{
				System.out.println("ID valid, continuati");
				idValid=false;	
				ok=true;
			}
		}
		if(ok==true) {
			System.out.print("Titlul Cartii:");
			String titlu = sc.next();
			System.out.print("Genul cartii");
			String gen = sc.next();
			System.out.print("Autorul cartii");
			String autor = sc.next();
			System.out.print("Numarul de zile de imprumut al cartii");
			int nrZileImprumut = Integer.parseInt(sc.next());
			Carte c = new Carte(id, titlu,gen,autor,0,0,0,nrZileImprumut);
			carti.add(c);
			System.out.println("Carte inregistrata cu succes");
			Functii.scrieCarti(carti);
		}	
	}
	
	public static void adaugaExemplarNou() {
		List<Exemplar> exemplare = new ArrayList<>();
		exemplare=Functii.citireExemplar();
		Scanner sc= new Scanner(System.in);
		System.out.println("Introduceti datele pentru a inregistra un nou exemplar");
		boolean idValid=true;
		boolean ok=false;
		int id=0;
		while(idValid)
		{	
			System.out.print("ID-ul Exemplarului:");
			id=Integer.parseInt(sc.next());
			for(Exemplar e: exemplare)
				if(e.getIdExemplar()==id)
					{
						idValid=false;
						break;
					}
			if(idValid==false)
				{	
					System.out.println("Acesta nu este un id valid. INCEARCA IAR\n");
					idValid=true;
				}
			else if(idValid==true)
			{
				System.out.println("ID valid, continuati\n");
				idValid=false;	
				ok=true;
			}
		}
		
		List<Carte> carti = new ArrayList<>();
		carti=Functii.citireCarti();
		
		Scanner sc1= new Scanner(System.in);
		
		int idCarte=0;
		boolean idCarteValid=false;
		
		if(ok==true) {
			while(!idCarteValid) 
			{
				System.out.println("Introduceti ID-ul cartii pentru care adaugati un nou exemplar");
				idCarte=Integer.parseInt(sc1.next());
				for(Carte c: carti)
					if(c.getIdCarte()==idCarte)
					{
						idCarteValid=true;
						break;
					}
				if(idCarteValid==false)
					System.out.println("Acest ID nu corespunde nici unei carti, INCERCATI IAR!");
			}
			if(idCarteValid==true)
				{
					Exemplar e = new Exemplar(id,idCarte,status.DISPONIBILA);
					exemplare.add(e);
					System.out.println("Exemplar adaugat cu succes");
					
					for(Carte c: carti)
						if(c.getIdCarte()==idCarte)
						{
							c.setNrExemplareDisponibile(c.getNrExemplareDisponibile()+1);
							break;
						}
					
					Functii.scrieExemplare(exemplare);
					Functii.scrieCarti(carti);
					
				}
		}
	}
	
	public static void adaugaCititorNou() 
	{
		
		System.out.println("Inregistreaza un cititor nou");
		boolean CNPValid=true;
		String cnp="0000000000";
		Scanner sc = new Scanner(System.in);
		
		List<Cititor> cititori = new ArrayList<>();
		cititori=Functii.citireCititori();
		boolean ok=false;
		while(CNPValid)
		{	
			System.out.print("CNP-ul Cititorului:");
			cnp=sc.next();
			for(Cititor c: cititori)
				if(c.getCNPCititor().equals(cnp))
					{
						CNPValid=false;
						break;
					}
			if(CNPValid==false)
				{	
					System.out.println("Acest CNP este deja folosit. INCEARCA IAR\n");
					CNPValid=true;
				}
			else if(CNPValid==true)
			{
				System.out.println("ID valid, continuati\n");
				CNPValid=false;	
				ok=true;
			}
		}
		if(ok==true)
		{
			System.out.println("NUMELE:");
			String nume=sc.next();
			System.out.println("NR Telefon:");
			String nrTel=sc.next();
			System.out.println("Parola:");
			String parola=sc.next();
			Cititor c= new Cititor(cnp, nume, nrTel, parola);
			cititori.add(c);
			System.out.println("Inregistrare efectuata cu succes");
			Functii.scrieCititori(cititori);
		}
	}
	
	public static int alegeIdExemplarPtImprumut(int idCarte) {
		
		List<Exemplar> exemplare = new ArrayList<>();
		exemplare=Functii.citireExemplar();
		int id=0;
		
		for(Exemplar e: exemplare)
			if(e.getIdCarte()==idCarte&&e.getStatusExemplar().equals(status.DISPONIBILA))
				{
					id=e.getIdExemplar();
					break;
				}
		System.out.println("Exemplarul cu id-ul " + id+ " a fost selectat pentru imprumut.");
		return  id;
	}
	public static Cititor determinaCititorulCareImprumutaCartea()
	{
		boolean CNPValid=false;
		String cnp="0000000000";
		Scanner sc = new Scanner(System.in);
		Cititor cit= new Cititor();
		List<Cititor> cititori = new ArrayList<>();
		cititori=Functii.citireCititori();
		
		while(!CNPValid)
		{	
			System.out.print("CNP-ul Cititorului:");
			cnp=sc.next();
			for(Cititor c: cititori)
				if(c.getCNPCititor().equals(cnp))
					{
						CNPValid=true;
						cit=c;
						break;
					}
			if(CNPValid==false)
				{	
					System.out.println("Acest CNP nu este asociat nici unui utilizator. INCEARCA IAR\n");
				}
			else if(CNPValid==true)
				System.out.println("CNP valid, continuati\n");
		}
		return cit;
			
	}
	
	public static int alegeIdCartePtImprumut(List<Carte> carti)
	{
		boolean idCorect=false;
		int id=0;
		while(!idCorect)
		{
			System.out.println("Alege ID-ul cartii pe care doresti sa o imprumuti");
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
	
	public static void realizeazaImprumutP2(Cititor cit, int idCarte, int idExemplar ) {
		Imprumut imp = new Imprumut(idExemplar,cit.getCNPCititor(), LocalDate.now());
		
		List<Imprumut> imprumuturi = new ArrayList<>(); 
		imprumuturi=Functii.citireImprumuturi();
		imprumuturi.add(imp);
		
		List<Carte> carti = new ArrayList<>();
		List<Exemplar> exemplare = new ArrayList<>();
		
		carti=Functii.citireCarti();
		exemplare=Functii.citireExemplar();
		
		for(Exemplar e: exemplare)
			if(e.getIdExemplar()==idExemplar)
				{	
					e.setStatus(status.IMPRUMUTATA);
					break;
				}
		
		for(Carte c: carti)
			if(c.getIdCarte()==idCarte)
				{	
					c.setNrExemplareDisponibile(c.getNrExemplareDisponibile()-1);
					c.setNrExemplareImprumutate(c.getNrExemplareImprumutate()+1);
					break;
				}
		Functii.scrieCarti(carti);
		Functii.scrieImprumuturi(imprumuturi);
		Functii.scrieExemplare(exemplare);
		System.out.println("Imprumut efectuat cu succes.");	
	}
	
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
		
		Cititor cititor=determinaCititorulCareImprumutaCartea();
		realizeazaImprumutP2(cititor, idCartePtImprumut, idExemplarPtImprumut);
	}
	
	public static void realizeazaRetur() {
		
		boolean cititorCorect =false;
		Scanner sc = new Scanner(System.in);
		String cnpCititor="0";
		
		List<Cititor> cititori = new ArrayList<>();
		cititori=Functii.citireCititori();
		
		while(!cititorCorect) {
			System.out.print("Introduceti CNP-ul cititorului: ");
			cnpCititor=sc.next();
			for(Cititor c: cititori)
			{
				if(c.getCNPCititor().equals(cnpCititor))
				{
					cititorCorect=true;
					break;
				}
			}
			if(!cititorCorect)
				System.out.println("Acest CNP nu corespunde nici unui cititor! INCEARCA IAR\n");
		}
		if(cititorCorect) {
			System.out.println("Imprumuturile acestui cititor");
			
			List<Imprumut> imprumuturi = new ArrayList<>();
			imprumuturi=Functii.citireImprumuturi();
			
			List<Exemplar> exemplare = new ArrayList<>();
			exemplare=Functii.citireExemplar();
			
			List<Carte> carti = new ArrayList<>();
			carti=Functii.citireCarti();
			
			List<Integer> idExemplareImp = new ArrayList<>();
			
			System.out.println("ID Exemplar TITLU AUTOR");
			for(Imprumut i:imprumuturi)
			{
				if(i.getCNPCititor().equals(cnpCititor))
					for(Exemplar e:exemplare)
						if(e.getIdExemplar()==i.getIdExemplar())
							for(Carte cart:carti)
								if(cart.getIdCarte()==e.getIdCarte())
									{
										System.out.println(e.getIdExemplar() + " " + cart.afiseazaTitluAutro());
										idExemplareImp.add(e.getIdExemplar());
									}
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
				for(Imprumut i:imprumuturi)
					if(i.getIdExemplar()==idExemplar)
						{
							imprumuturi.remove(i);
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
						c.setNrExemplareImprumutate(c.getNrExemplareImprumutate()-1);
						break;
					}
				Functii.scrieCarti(carti);
				Functii.scrieExemplare(exemplare);
				Functii.scrieImprumuturi(imprumuturi);
				System.out.println("Exemplar Returnat cu Succes");
			}
		}
	}
}
