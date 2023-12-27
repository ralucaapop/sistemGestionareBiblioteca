package ProiectP3Biblioteca;

/**
 * Clasa care defineste un obiect de tip Bibiotecar
 */
public class Bibliotecar{
	
	private int idAngajat;
	private String nume;
	private String nrTelefon;
	private String parola;
	private String email;
	
	/**
	 * Constructor fara parametrii
	 */
	public Bibliotecar() {
		this.nume="nec";
		this.nrTelefon="nec";
		this.idAngajat=0;
		this.parola="nec";
		this.email="nec";
	}
	/**
	 * Constructorul cu parametrii
	 * @param email- email-ul bibliotecarului
	 * @param nume - numele bibliotecarului
	 * @param nrTelefon - numarul de telefon al bibliotecarului
	 * @param idUtilizator - id-ul Angajatului 
	 * @param parola - parola contului
	 */
	public Bibliotecar(String email, String nume, String nrTelefon, int idUtilizator, String parola) {
		
		this.idAngajat=idUtilizator;
		this.parola=parola;
		this.email=email;
		this.nrTelefon=nrTelefon;
		this.nume=nume;
	}
	
	/**
	 * Constructor cu doi parametrii folosit pentru autentificare
	 * @param idAngajat - id-ul Angajatului
	 * @param parola - parola contului
	 */
	public Bibliotecar(int idAngajat, String parola) {
		this.idAngajat=idAngajat;
		this.parola=parola;
	}
	
	/**
	 * Metoda pentru creearea contului unui bibliotecar
	 * @param email - adresa de e-mail a bibliotecarului
	 * @param nume - numele bibliotecarului
	 * @param nrTelefon - numarul de telefon al bibliotecarului
	 * @param idUtilizator - id-ul de angajat al Bibliotecarlui
	 * @param parola - parola de la cont
	 * @return obiectulde tipul Bibliotecar
	 */
	public Bibliotecar creareCont(String email, String nume, String nrTelefon, int idUtilizator, String parola)
	{
		Bibliotecar c= new Bibliotecar(email, nume, nrTelefon, idUtilizator, parola);
		return c;
	}
	
	/**
	 * Metoda pentru autentificare unui bibliotecar in aplicatie
	 * @param idBibliotecar - id-ul de angajat
	 * @param parola - parola contului
	 * @return
	 */
	public Bibliotecar autentificareBibliotecar(int idBibliotecar, String parola)
	{
		Bibliotecar c= new Bibliotecar(idBibliotecar, parola);
		return c;
	}
	
	public int getIdBibliotecar()
	{
		return this.idAngajat;
	}
	
	public String getParolaBibliotecar()
	{
		return this.parola;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getNrTelefon() {
		return this.nrTelefon;
	}
	
	public String getNume() {
		return this.nume;
	}
	public String toString() {
		return "Bibliotecarul "+this.nume+ " cu adresa de e-mail " + this.email + "; nr de telefon " + this.nrTelefon+ " si id-ul de angajat "+this.idAngajat;
	}
}
