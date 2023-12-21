package ProiectP3Biblioteca;

import java.time.LocalDate;

import ProiectP3Biblioteca.Cititor;
import ProiectP3Biblioteca.Rezervare;
import ProiectP3Biblioteca.Utilizator;

public class Cititor{
	
	protected String CNP;
	protected String nume;
	protected String nrTelefon;
	protected String parola;
	
	public Cititor() {
		this.CNP="nec";
		this.nume="nec";
		this.nrTelefon="0";
		this.parola="nec";
	}
	
	public Cititor(String CNP, String nume, String nrTelefon, String parola) {
		this.CNP=CNP;
		this.nume=nume;
		this.nrTelefon=nrTelefon;
		this.parola=parola;
	}
	
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
	
	public static Cititor autentificareCititor(String CNP, String parola)
	{
		Cititor c= new Cititor(CNP, parola);
		return c;
	}
	
	
	public Rezervare rezervaExemplar(int idExemplar)
	{
		Rezervare rez = new Rezervare(this.CNP,idExemplar, LocalDate.now());
		return rez;
	}
	

}

