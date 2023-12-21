package ProiectP3Biblioteca;

import java.time.LocalDate;

public class Imprumut {
	private int idExemplar;
	private String CNPCititor;
	private LocalDate dataImprumut;
	
	public Imprumut() {
		this.CNPCititor="nec";
		this.idExemplar=0;
		this.dataImprumut=(LocalDate.of(0,0,0));
	}
	
	public Imprumut(int idExemplar, String CNP, LocalDate di) {
		this.CNPCititor=CNP;
		this.idExemplar=idExemplar;
		this.dataImprumut=di;
	}
	
	public int getIdExemplar() {
		return this.idExemplar;
	}
	
	public String getCNPCititor() {
		return this.CNPCititor;
	}
	
	public LocalDate getDataImprumut() {
		return this.dataImprumut;
	}
}