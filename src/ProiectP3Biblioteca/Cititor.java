package ProiectP3Biblioteca;

import java.time.LocalDate;

import ProiectP3Biblioteca.Cititor;
import ProiectP3Biblioteca.Rezervare;
import ProiectP3Biblioteca.Utilizator;

public class Cititor extends Utilizator{
	
	private int idCititor;
	private String parola;
	
	public Cititor() {
		super();
		this.idCititor=0;
		this.parola="nec";
	}
	
	public Cititor(String email, String nume, String nrTelefon, int idUtilizator, String parola) {
		super(email,nume,nrTelefon);
		this.idCititor=idUtilizator;
		this.parola=parola;
	}
	
	public Cititor(int idCititor, String parola) {
		this.idCititor=idCititor;
		this.parola=parola;
	}
	
	public Cititor creareCont(String email, String nume, String nrTelefon, int idUtilizator, String parola)
	{
		Cititor c= new Cititor(email, nume, nrTelefon, idUtilizator, parola);
		return c;
	}
	
	public Cititor autentificareCititor(int idCititor, String parola)
	{
		Cititor c= new Cititor(idCititor, parola);
		return c;
	}
	
	public void rezervaCarte(int idExemplar)
	{
		Rezervare rez = new Rezervare(this.idCititor,idExemplar,1, LocalDate.now());
	}
}

