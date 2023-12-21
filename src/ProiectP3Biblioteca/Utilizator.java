package ProiectP3Biblioteca;

public abstract class Utilizator {
	
	protected String username;
	protected String nume;
	protected String nrTelefon;
	protected String parola;
	
	public Utilizator() {
		this.username="nec";
		this.nume="nec";
		this.nrTelefon="0";
		this.parola="nec";
	}
	
	public Utilizator(String username, String nume, String nrTelefon, String parola) {
		this.username=username;
		this.nume=nume;
		this.nrTelefon=nrTelefon;
		this.parola=parola;
	}
	
	public Utilizator(String username, String parola)
	{
		this.username=username;
		this.parola=parola;
	}
	
	public String getUsername() {
		return this.username;
	}
}
