package ProiectP3Biblioteca;

import java.time.LocalDate;

public class Rezervare {
	private int idExemplar;
	private int idRezervare;
	private int idCititor;
	private LocalDate dataRezervare;
	
	public Rezervare() {
		this.idCititor=0;
		this.idExemplar=0;
		this.idRezervare=0;
		this.dataRezervare=(LocalDate.of(0,0,0));
	}
	
	public Rezervare(int idr,int idc, int ide, LocalDate di) {
		this.idCititor=idc;
		this.idExemplar=ide;
		this.idRezervare=idr;
		this.dataRezervare=di;
	}
	
	public LocalDate getDataRezervare() {
		return this.dataRezervare;
	}
	
	public int getIdCititor() {
		return this.idCititor;
	}
	
	public int getIdExemplar()
	{
		return this.idExemplar;
	}
}
