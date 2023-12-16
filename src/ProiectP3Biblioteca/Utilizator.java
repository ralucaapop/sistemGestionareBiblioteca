package ProiectP3Biblioteca;

public abstract class Utilizator {
	
	protected String email;
	protected String nume;
	protected String nrTelefon;
	
	public Utilizator() {
		this.email="nec";
		this.nume="nec";
		this.nrTelefon="0";
	}
	
	public Utilizator(String email, String nume, String nrTelefon) {
		this.email=email;
		this.nume=nume;
		this.nrTelefon=nrTelefon;
	}
	
}
