package ProiectP3Biblioteca;


public class Bibliotecar extends Utilizator {
	
	private int idAngajat;
	private String parola;
	
	public Bibliotecar() {
		super();
		this.idAngajat=0;
		this.parola="nec";
	}
	
	public Bibliotecar(String email, String nume, String nrTelefon, int idUtilizator, String parola) {
		super(email,nume,nrTelefon);
		this.idAngajat=idUtilizator;
		this.parola=parola;
	}
	
	public Bibliotecar(int idCititor, String parola) {
		this.idAngajat=idCititor;
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

}
