package ProiectP3Biblioteca;

import java.time.LocalDate;

import ProiectP3Biblioteca.Cititor;
import ProiectP3Biblioteca.Rezervare;
/**
 * Clasa care defineste un obiect de tip Cititor
 */
public class Cititor{
	
	protected String CNP;
	protected String nume;
	protected String nrTelefon;
	protected String parola;

	/**
	 * Constructor fara parametrii
	 */
	public Cititor() {
		this.CNP="nec";
		this.nume="nec";
		this.nrTelefon="0";
		this.parola="nec";
	}
	
	/**
	 * Constructor cu parametrii
	 * @param CNP - CNP-ul citotorului
	 * @param nume - numele
	 * @param nrTelefon - numarul de telefon
	 * @param parola - parola contului
	 */
	public Cititor(String CNP, String nume, String nrTelefon, String parola) {
		this.CNP=CNP;
		this.nume=nume;
		this.nrTelefon=nrTelefon;
		this.parola=parola;
	}
	
	/**
	 * Constructor pentru aytentificare
	 * @param CNP - CNP-ul cititorului
	 * @param parola - parola contului
	 */
	public Cititor(String CNP, String parola)
	{
		this.CNP=CNP;
		this.parola=parola;
	}
	
	public String getCNPCititor() {
		return this.CNP;
	}
	
	public String getNume() {
		return this.nume;
	}
	
	public String getNrTelefon() {
		return this.nrTelefon;
	}
	public String getParola() {
		return this.parola;
	}
	
	/**
	 * Metoda pentru autentificarea 
	 * @param CNP- cnp-ul cititorului
	 * @param parola - parola pentru contul de cititor
	 * @return
	 */
	public static Cititor autentificareCititor(String CNP, String parola)
	{
		Cititor c= new Cititor(CNP, parola);
		return c;
	}
	
	/**
	 * Metoda folosita in procesul de rezervare al unei carti
	 * @param idExemplar - id-ul exemplarului rezervat
	 * @return un obiect de tip rezervare
	 */
	public Rezervare rezervaExemplar(int idExemplar)
	{
		Rezervare rez = new Rezervare(this.CNP,idExemplar, LocalDate.now());
		return rez;
	}
	
}

