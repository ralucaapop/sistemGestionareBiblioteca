package ProiectP3Biblioteca;

import java.time.LocalDate;

public class Imprumut {
	private int idExemplar;
	private int idImprumut;
	private int idCititor;
	private LocalDate dataImprumut;
	
	public Imprumut() {
		this.idCititor=0;
		this.idExemplar=0;
		this.idImprumut=0;
		this.dataImprumut=(LocalDate.of(0,0,0));
	}
	
	public Imprumut(int idi, int ide, int idc, LocalDate di) {
		this.idCititor=idc;
		this.idExemplar=ide;
		this.idImprumut=idi;
		this.dataImprumut=di;
	}
	
	public LocalDate getDataImprumut() {
		return this.dataImprumut;
	}
}