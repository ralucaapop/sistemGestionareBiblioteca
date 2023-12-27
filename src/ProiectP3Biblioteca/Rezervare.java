package ProiectP3Biblioteca;

import java.time.LocalDate;
/**
 * Clasa care defineste un obiect de tip rezervare
 */
public class Rezervare {
	private int idExemplar;
	private String 	CNPCititor;
	private LocalDate dataRezervare;
	
	/**
	 * Constructor fara parametrii
	 */
	public Rezervare() {
		this.CNPCititor="nec";
		this.idExemplar=0;
		this.dataRezervare=(LocalDate.of(0,0,0));
	}
	
	/**
	 * Constructor cu parametrii
	 * @param CNP - CNP-ul utilizatorului care face o rezervare
	 * @param idExemplar - id-ul exemplarului care va fi rezervat
	 * @param dataRezervare - data rezervarii
	 */
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
