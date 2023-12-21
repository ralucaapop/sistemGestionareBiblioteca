package ProiectP3Biblioteca;


public class Bibliotecar{
	
	private int idAngajat;
	private String nume;
	private String nrTelefon;
	private String parola;
	private String email;
	
	public Bibliotecar() {
		this.nume="nec";
		this.nrTelefon="nec";
		this.idAngajat=0;
		this.parola="nec";
		this.email="nec";
	}
	
	public Bibliotecar(String email, String nume, String nrTelefon, int idUtilizator, String parola) {
		
		this.idAngajat=idUtilizator;
		this.parola=parola;
		this.email=email;
		this.nrTelefon=nrTelefon;
		this.nume=nume;
	}
	
	public Bibliotecar(int idAngajat, String parola) {
		this.idAngajat=idAngajat;
		this.parola=parola;
	}
	
	public Bibliotecar creareCont(String email, String nume, String nrTelefon, int idUtilizator, String parola)
	{
		Bibliotecar c= new Bibliotecar(email, nume, nrTelefon, idUtilizator, parola);
		return c;
	}
	
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
