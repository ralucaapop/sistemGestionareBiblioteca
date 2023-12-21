package ProiectP3Biblioteca;

import java.time.LocalDate;

public class Rezervare {
	private int idExemplar;
	private String 	CNPCititor;
	private LocalDate dataRezervare;
	
	public Rezervare() {
		this.CNPCititor="nec";
		this.idExemplar=0;
		this.dataRezervare=(LocalDate.of(0,0,0));
	}
	
	public Rezervare(String CNP, int idExemplar, LocalDate dataRezervare) {
		this.CNPCititor=CNP;
		this.idExemplar=idExemplar;
		this.dataRezervare=dataRezervare;
	}
	
	public LocalDate getDataRezervare() {
		return this.dataRezervare;
	}
	
	public String getCNPCititor() {
		return this.CNPCititor;
	}
	
	public int getIdExemplar()
	{
		return this.idExemplar;
	}
}
