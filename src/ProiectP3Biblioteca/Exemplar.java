package ProiectP3Biblioteca;

import ProiectP3Biblioteca.Exemplar.status;

public class Exemplar {
	public enum status{IMPRUMUTATA, REZERVATA, DISPONIBILA};

	private status statusExemplar;
	private int idExemplar;
	private int idCarte;


	public Exemplar() {
		this.statusExemplar=status.DISPONIBILA;
		this.idExemplar=0;
		this.idCarte=0;
	}
	
	public Exemplar(int ide, int idc, status s) {
		this.statusExemplar=s;
		this.idExemplar=ide;
		this.idCarte=idc;
	}
	
	public int getIdCarte() {
		return this.idCarte;
	}
	
	public int getIdExemplar() {
		return this.idExemplar;
	}
	
	public status getStatusExemplar() {
		return this.statusExemplar;
	}
	
	public void setStatus(status s) {
		this.statusExemplar=s;
	}
	
	
}
