package ProiectP3Biblioteca;

import ProiectP3Biblioteca.Exemplar.status;

/**
 * Clasa care defineste un obiect de tip exemplar
 */
public class Exemplar {
	public enum status{IMPRUMUTATA, REZERVATA, DISPONIBILA};

	private status statusExemplar;
	private int idExemplar;
	private int idCarte;

	/**
	 * Constructor fara parametrii
	 */
	public Exemplar() {
		this.statusExemplar=status.DISPONIBILA;
		this.idExemplar=0;
		this.idCarte=0;
	}
	
	/**
	 * Constructor cu parametrii
	 * @param ide - id-ul exemplarului 
	 * @param idc - id-ul cartii corespunzator exemplarului
	 * @param s - status-ul exemplarului
	 */
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
	
	/**
	 * Metoda pentru modificarea statusului unui exemplar
	 * @param s - noul status
	 */
	public void setStatus(status s) {
		this.statusExemplar=s;
	}
	
	
}
