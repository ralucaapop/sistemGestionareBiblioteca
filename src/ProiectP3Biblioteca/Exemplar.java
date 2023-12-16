package ProiectP3Biblioteca;

import ProiectP3Biblioteca.Exemplar.status;

public class Exemplar {
	public enum status{IMPRUMUTATA, REZERVATA, DISPONIBILA};

	private status statusCarte;
	private int idExemplar;
	private int idCarte;


	public Exemplar() {
		this.statusCarte=status.DISPONIBILA;
		this.idExemplar=0;
		this.idCarte=0;
	}
	
	public Exemplar(int ide, int idc, status s) {
		this.statusCarte=s;
		this.idExemplar=ide;
		this.idCarte=idc;
	}

	public void setStatus(status s) {
		this.statusCarte=s;
	}
	
	public status getStatus() {
		return this.statusCarte;
	}
}
